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
            if (itemName.equalsIgnoreCase(entry.getKey()))
            {
                String buyItem = entry.getKey();
                int buyStock = entry.getValue().intValue();
                if (items.get(buyItem) % 100 == 0)
                {
                    message = "You bought " + buyItem + " for $" + (items.get(buyItem) / 100) + "." + (items.get(buyItem) % 100) + "0.";
                }
                else
                {
                    message = "You bought " + buyItem + " for $" + (items.get(buyItem) / 100) + "." + (items.get(buyItem) % 100) + ".";
                }
                //Price from items
                storeMoney += items.get(buyItem);
                selfMoney -= items.get(buyItem);
                //Stock from inventories
                storeInventory.put(buyItem, storeInventory.get(buyItem) - 1) ;
                selfInventory.put(buyItem, selfInventory.get(buyItem) + 1);
            }
            else if (itemName.equals(index + ""))
            {
                String buyItem = entry.getKey();
                int buyStock = entry.getValue().intValue();
                if (items.get(buyItem) % 100 == 0)
                {
                    message = "You bought " + buyItem + " for $" + (items.get(buyItem) / 100) + "." + (items.get(buyItem) % 100) + "0.";
                }
                else
                {
                    message = "You bought " + buyItem + " for $" + (items.get(buyItem) / 100) + "." + (items.get(buyItem) % 100) + ".";
                }
                //Price from items
                storeMoney += items.get(buyItem);
                selfMoney -= items.get(buyItem);
                //Stock from inventories
                storeInventory.put(buyItem, storeInventory.get(buyItem) - 1) ;
                selfInventory.put(buyItem, selfInventory.get(buyItem) + 1);
            }
            index++;
        }
        /*if (itemName.equalsIgnoreCase("eggs"))
        {
            if ()
            message = "You bought eggs.";
            selfMoney -= 6;
            storeMoney += 6;
            selfInventory += 1;
            storeInventory -= 1;
        }*/
        return redirect(routes.Application.index());
    }

    @Transactional
    public Result sell() {
        Form<Value> valueForm = formFactory.form(Value.class);
        Value value = valueForm.bindFromRequest().get();
        JPA.em().persist(value);
        String itemName = value.getData();
        int index = 1;
        for (Map.Entry<String, Integer> entry : storeInventory.entrySet())
        {
            if (itemName.equalsIgnoreCase(entry.getKey()))
            {
                String sellItem = entry.getKey();
                int sellStock = entry.getValue().intValue();
                if (items.get(sellItem) * .75 % 100 == 0)
                {
                    message = "You sold " + sellItem + " for $" + (items.get(sellItem) * .75 / 100) + "." + (items.get(sellItem) * .75 % 100) + "0.";
                }
                else
                {
                    message = "You sold " + sellItem + " for $" + (items.get(sellItem) * .75 / 100) + "." + (items.get(sellItem) * .75 % 100) + ".";
                }
                //Price from items
                storeMoney -= items.get(sellItem) * .75;
                selfMoney += items.get(sellItem) * .75;
                //Stock from inventories
                storeInventory.put(sellItem, storeInventory.get(sellItem) + 1);
                selfInventory.put(sellItem, selfInventory.get(sellItem) - 1);
            }
            else if (itemName.equals(index + ""))
            {
                String sellItem = entry.getKey();
                int sellStock = entry.getValue().intValue();
                if (items.get(sellItem) * .75 % 100 == 0)
                {
                    message = "You sold " + sellItem + " for $" + (items.get(sellItem) * .75 / 100) + "." + (items.get(sellItem) * .75 % 100) + "0.";
                }
                else
                {
                    message = "You sold " + sellItem + " for $" + (items.get(sellItem) * .75 / 100) + "." + (items.get(sellItem) * .75 % 100) + ".";
                }
                //Price from items
                storeMoney -= items.get(sellItem) * .75;
                selfMoney += items.get(sellItem) * .75;
                //Stock from inventories
                storeInventory.put(sellItem, storeInventory.get(sellItem) + 1);
                selfInventory.put(sellItem, selfInventory.get(sellItem) - 1);
            }
            index++;
        }
        return redirect(routes.Application.index());
    }

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
            else
            {
                priceList += index + " - " + entry.getKey() + ":  $" + (entry.getValue() / 100) + "." + (entry.getValue() % 100) + "<br />";
            }
            index++;
        }
        return ok(priceList);
    }
}
