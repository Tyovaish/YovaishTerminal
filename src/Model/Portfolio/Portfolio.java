package Model.Portfolio;

import Model.PurchaseOrder;
import Model.SellOrder;
import Model.Stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Portfolio {
    HashMap<String,ArrayList<PurchaseOrder>> stocksPurchased = new HashMap<>();
    HashMap<String,ArrayList<SellOrder>> stocksSold=new HashMap<>();
    public void buyStock(String stockTicker, double amountOfShares, double purchasePrice){
            if(!stocksPurchased.containsKey(stockTicker)){
                stocksPurchased.put(stockTicker,new ArrayList<PurchaseOrder>());
                stocksPurchased.get(stockTicker).add(new PurchaseOrder(stockTicker,amountOfShares,purchasePrice));
        } else {
                stocksPurchased.get(stockTicker).add(new PurchaseOrder(stockTicker,amountOfShares,purchasePrice));
        }
    }
    public void sellStock(String stockTicker, double amountOfShares, double sellPrice){
        if(!stocksSold.containsKey(stockTicker)){
            stocksSold.put(stockTicker,new ArrayList<SellOrder>());
            stocksSold.get(stockTicker).add(new SellOrder(stockTicker,amountOfShares,sellPrice));
        } else {
            stocksSold.get(stockTicker).add(new SellOrder(stockTicker,amountOfShares,sellPrice));
        }
    }
}
