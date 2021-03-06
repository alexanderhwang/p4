package models;

import play.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Inventory
{
    private static Inventory instance = new Inventory();

    private int storeMoney = 100000000;
    private Map<String, Integer> storeInventory = new HashMap<String, Integer>();
    private int selfMoney = 1000000;
    private Map<String, Integer> selfInventory = new HashMap<String, Integer>();
    private Map<String, Integer> items = new HashMap<String, Integer>();
    private String message = "";

    private Inventory()
    {
        //Populate items and storeInventory
        items.put("Candy", 75);
        storeInventory.put("Candy", 256);
        selfInventory.put("Candy", 0);
        items.put("Lettuce", 350);
        storeInventory.put("Lettuce", 64);
        selfInventory.put("Lettuce", 0);
        items.put("Cheese", 450);
        storeInventory.put("Cheese", 80);
        selfInventory.put("Cheese", 0);
        items.put("Eggs", 600);
        storeInventory.put("Eggs", 48);
        selfInventory.put("Eggs", 0);
    }

    public static Inventory getInstance()
    {
        return instance;
    }
    public String getMessage()
    {
        return this.message;
    }
    public int getStoreMoney()
    {
        return this.storeMoney;
    }
    public int getSelfMoney()
    {
        return this.selfMoney;
    }
    public Map<String, Integer> getStoreInventory()
    {
        return this.storeInventory;
    }
    public Map<String, Integer> getSelfInventory()
    {
        return this.selfInventory;
    }
    public Map<String, Integer> getItems()
    {
        return this.items;
    }
}
