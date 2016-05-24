package controllers;

import models.Inventory;
import play.*;
import play.mvc.*;
import play.db.jpa.*;
import views.html.*;
import models.Value;
import play.data.Form;
import play.data.FormFactory;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

import static play.libs.Json.*;

public class Application extends Controller {
    public Inventory inventory = Inventory.getInstance();
    private int storeMoney = inventory.getStoreMoney();
    private Map<String, Integer> storeInventory = inventory.getStoreInventory();
    private int selfMoney = inventory.getSelfMoney();
    private Map<String, Integer> selfInventory = inventory.getSelfInventory();
    private Map<String, Integer> items = inventory.getItems();
    private String message = inventory.getMessage();

    @Inject
    FormFactory formFactory;

    public Result index() {
        return ok(index.render());
    }
    @Transactional
    public Result buy() {
        Form<Value> valueForm = formFactory.form(Value.class);
        Value value = valueForm.bindFromRequest().get();
        JPA.em().persist(value);
        String itemName = value.getData();
        int index = 1;
        for (Map.Entry<String, Integer> entry : storeInventory.entrySet())
        {
            if (itemName.equalsIgnoreCase(entry.getKey()) || itemName.equals(index + ""))
            {
                String buyItem = entry.getKey();
                int buyStock = entry.getValue().intValue();
                if (storeInventory.get(buyItem) <= 0)
                {
                    message = "Error: That item is out of stock.";
                }
                else if (selfMoney < items.get(buyItem))
                {
                    message = "Error: You cannot afford this item. You withdrew money from the bank.";
                    selfMoney += items.get(buyItem);
                }
                else
                {
                    if (items.get(buyItem) % 100 == 0)
                    {
                        message = "You bought " + buyItem + " for $" + (items.get(buyItem) / 100) + "." + (items.get(buyItem) % 100) + "0.";
                    }
                    else if (items.get(buyItem) % 100 < 10)
                    {
                        message = "You bought " + buyItem + " for $" + (items.get(buyItem) / 100) + ".0" + (items.get(buyItem) % 100) + ".";
                    }
                    else
                    {
                        message = "You bought " + buyItem + " for $" + (items.get(buyItem) / 100) + "." + (items.get(buyItem) % 100) + ".";
                    }
                    //Price from items
                    storeMoney += items.get(buyItem);
                    selfMoney -= items.get(buyItem);
                    //Stock from inventories
                    storeInventory.put(buyItem, storeInventory.get(buyItem) - 1);
                    selfInventory.put(buyItem, selfInventory.get(buyItem) + 1);
                }
            }
            index++;
        }
        return redirect(routes.Application.index());
    }

    @Transactional
    public Result add() {
        Form<Value> valueForm = formFactory.form(Value.class);
        Value value = valueForm.bindFromRequest().get();
        JPA.em().persist(value);
        String fullData = value.getData();
        List<String> fullDataList = Arrays.asList(fullData.split("\\s*,\\s*"));
        if (fullDataList.size() > 3)
        {
            message = "Error: Data input contains more than 3 items.";
        }
        else if (fullDataList.get(0).isEmpty())
        {
            message = "Error: Item must have a name.";
        }
        else if (fullDataList.size() > 1 && !fullDataList.get(1).isEmpty() && !fullDataList.get(1).matches("^\\$?(([1-9]\\d{0,2}(,\\d{3})*)|(([1-9]\\d*)?\\d))(\\.\\d\\d)?$"))
        {
            message = "Error: Cost must be a positive monetary value.";
        }
        else if (fullDataList.size() > 2 && !fullDataList.get(2).isEmpty() && !fullDataList.get(2).matches("^\\d+$"))
        {
            message = "Error: Stock must be a positive integer.";
        }
        else
        {
            Boolean match = false;
            int index = 1;
            for (Map.Entry<String, Integer> entry : storeInventory.entrySet())
            {
                if (fullDataList.get(0).equalsIgnoreCase(entry.getKey()) || fullDataList.get(0).equals(index + ""))
                {
                    String addItem = entry.getKey();
                    if (fullDataList.size() == 1)
                    {
                        storeInventory.put(addItem, storeInventory.get(addItem) + 1);
                        message = addItem + " stock increased by 1.";
                    }
                    else if ((fullDataList.size() == 2 && !fullDataList.get(1).isEmpty()) || (fullDataList.size() == 3 && !fullDataList.get(1).isEmpty() && fullDataList.get(2).isEmpty()))
                    {
                        int pureCost = Integer.parseInt(fullDataList.get(1).replaceAll("[^\\d]+", ""));
                        if (!fullDataList.get(1).contains("."))
                        {
                            pureCost *= 100;
                        }
                        items.put(addItem, pureCost);
                        if (pureCost % 100 == 0)
                        {
                            message = addItem + " price changed to $" + (pureCost / 100) + "." + (pureCost % 100) + "0.";
                        }
                        else if (pureCost % 100 < 10)
                        {
                            message = addItem + " price changed to $" + (pureCost / 100) + ".0" + (pureCost % 100) + ".";
                        }
                        else
                        {
                            message = addItem + " price changed to $" + (pureCost / 100) + "." + (pureCost % 100) + ".";
                        }
                    }
                    else
                    {
                        message = addItem;
                        if (!fullDataList.get(1).isEmpty())
                        {
                            int pureCost = Integer.parseInt(fullDataList.get(1).replaceAll("[^\\d]+", ""));
                            if (!fullDataList.get(1).contains("."))
                            {
                                pureCost *= 100;
                            }
                            items.put(addItem, pureCost);
                            if (pureCost % 100 == 0)
                            {
                                message = addItem + " price changed to $" + (pureCost / 100) + "." + (pureCost % 100) + "0 and";
                            }
                            else if (pureCost % 100 < 10)
                            {
                                message = addItem + " price changed to $" + (pureCost / 100) + ".0" + (pureCost % 100) + " and";
                            }
                            else
                            {
                                message = addItem + " price changed to $" + (pureCost / 100) + "." + (pureCost % 100) + " and";
                            }
                        }
                        storeInventory.put(addItem, Integer.parseInt(fullDataList.get(2)));
                        message += " stock changed to " + fullDataList.get(2) + ".";
                    }
                    match = true;
                }
                index++;
            }
            if (!match)
            {
                String newItem = fullDataList.get(0);
                selfInventory.put(newItem, 0);
                storeInventory.put(newItem, 1);
                items.put(newItem, 0);
                if (fullDataList.size() == 1)
                {
                    message = newItem + " added.";
                }
                else if ((fullDataList.size() == 2 && !fullDataList.get(1).isEmpty()) || (fullDataList.size() == 3 && !fullDataList.get(1).isEmpty() && fullDataList.get(2).isEmpty()))
                {
                    int pureCost = Integer.parseInt(fullDataList.get(1).replaceAll("[^\\d]+", ""));
                    if (!fullDataList.get(1).contains("."))
                    {
                        pureCost *= 100;
                    }
                    items.put(newItem, pureCost);
                    if (pureCost % 100 == 0)
                    {
                        message = newItem + " added with price of $" + (pureCost / 100) + "." + (pureCost % 100) + "0.";
                    }
                    else if (pureCost % 100 < 10)
                    {
                        message = newItem + " added with price of $" + (pureCost / 100) + ".0" + (pureCost % 100) + ".";
                    }
                    else
                    {
                        message = newItem + " added with price of $" + (pureCost / 100) + "." + (pureCost % 100) + ".";
                    }
                }
                else
                {
                    message = newItem;
                    if (!fullDataList.get(1).isEmpty())
                    {
                        int pureCost = Integer.parseInt(fullDataList.get(1).replaceAll("[^\\d]+", ""));
                        if (!fullDataList.get(1).contains("."))
                        {
                            pureCost *= 100;
                        }
                        items.put(newItem, pureCost);
                        if (pureCost % 100 == 0)
                        {
                            message = newItem + " added with price of $" + (pureCost / 100) + "." + (pureCost % 100) + "0 and";
                        }
                        else if (pureCost % 100 < 10)
                        {
                            message = newItem + " added with price of $" + (pureCost / 100) + ".0" + (pureCost % 100) + " and";
                        }
                        else
                        {
                            message = newItem + " added with price of $" + (pureCost / 100) + "." + (pureCost % 100) + " and";
                        }
                    }
                    storeInventory.put(newItem, Integer.parseInt(fullDataList.get(2)));
                    message += " stock of " + fullDataList.get(2) + ".";
                }
            }
        }
        return redirect(routes.Application.index());
    }
    /*public Result sell() {
        Form<Value> valueForm = formFactory.form(Value.class);
        Value value = valueForm.bindFromRequest().get();
        JPA.em().persist(value);
        String itemName = value.getData();
        int index = 1;
        for (Map.Entry<String, Integer> entry : storeInventory.entrySet())
        {
            if (itemName.equalsIgnoreCase(entry.getKey()) || itemName.equals(index + ""))
            {
                String sellItem = entry.getKey();
                int sellItemMod = (int) (items.get(sellItem) * .75);
                int sellStock = entry.getValue().intValue();
                if (selfInventory.get(sellItem) <= 0)
                {
                    message = "Error: You do not have that item.";
                }
                else if (storeMoney < items.get(sellItem))
                {
                    message = "Error: The store cannot afford that item.";
                }
                else
                {
                    if (sellItemMod % 100 == 0) {
                        message = "You sold " + sellItem + " for $" + (sellItemMod / 100) + "." + (sellItemMod % 100) + "0.";
                    } else {
                        message = "You sold " + sellItem + " for $" + (sellItemMod / 100) + "." + (sellItemMod % 100) + ".";
                    }
                    //Price from items
                    storeMoney -= sellItemMod;
                    selfMoney += sellItemMod;
                    //Stock from inventories
                    storeInventory.put(sellItem, storeInventory.get(sellItem) + 1);
                    selfInventory.put(sellItem, selfInventory.get(sellItem) - 1);
                }
            }
            index++;
        }
        return redirect(routes.Application.index());
    }*/

    @Transactional(readOnly = true)
    public Result getValues() {
        List<Value> values = (List<Value>) JPA.em().createQuery("select v from Value v").getSingleResult();
        return ok(toJson(values));
    }

    @Transactional(readOnly = true)
    public Result storeMoney() {
        String moneyString = "Store money: $" + (storeMoney / 100) + "." + (storeMoney % 100);
        if (storeMoney % 100 == 0)
        {
            moneyString = "Store money: $" + (storeMoney / 100) + "." + (storeMoney % 100) + "0";
        }
        else if (storeMoney % 100 < 10)
        {
            moneyString = "Store money: $" + (storeMoney / 100) + ".0" + (storeMoney % 100);
        }
        return ok(moneyString);
    }

    @Transactional(readOnly = true)
    public Result storeInventory() {
        /*String listing = "";
        for (Map.Entry<String, Integer> entry : storeInventory.entrySet())
        {
            listing += entry.getKey() + ": " + entry.getValue() + "\n";
        }*/
        return ok("Store inventory: " + storeInventory);
    }

    @Transactional(readOnly = true)
    public Result selfMoney() {
        String moneyString = "Self money: $" + (selfMoney / 100) + "." + (selfMoney % 100);
        if (selfMoney % 100 == 0)
        {
            moneyString = "Self money: $" + (selfMoney / 100) + "." + (selfMoney % 100) + "0";
        }
        else if (selfMoney % 100 < 10)
        {
            moneyString = "Self money: $" + (selfMoney / 100) + ".0" + (selfMoney % 100);
        }
        return ok(moneyString);
    }

    @Transactional(readOnly = true)
    public Result selfInventory() {
        /*String listing = "";
        for (Map.Entry<String, Integer> entry : selfInventory.entrySet())
        {
            listing += entry.getKey() + ": " + entry.getValue() + "\n";
        }*/
        return ok("Self inventory: " + selfInventory);
    }

    @Transactional(readOnly = true)
    public Result message() {
        return ok(message);
    }

    @Transactional(readOnly = true)
    public Result priceList() {
        String priceList = "Prices: <br />";
        int index = 1;
        for (Map.Entry<String, Integer> entry : items.entrySet())
        {
            if (entry.getValue() % 100 == 0)
            {
                priceList += index + " - " + entry.getKey() + ":  $" + (entry.getValue() / 100) + "." + (entry.getValue() % 100) + "0<br />";
            }
            else if (entry.getValue() % 100 < 10)
            {
                priceList += index + " - " + entry.getKey() + ":  $" + (entry.getValue() / 100) + ".0" + (entry.getValue() % 100) + "<br />";
            }
            else
            {
                priceList += index + " - " + entry.getKey() + ":  $" + (entry.getValue() / 100) + "." + (entry.getValue() % 100) + "<br />";
            }
            index++;
        }
        return ok(priceList);
    }
}
