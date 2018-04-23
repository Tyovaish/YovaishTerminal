package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class StockTickerFilter {
    public static HashMap<String,String> possibleStockTickers;
    public StockTickerFilter(){
        possibleStockTickers= new HashMap<String, String>();
        try {
            Scanner nyseStockScanner = new Scanner(new File("C:\\Users\\Trevor\\IdeaProjects\\YovaishTerminal2.0\\src\\Model\\nasdaqStocks.csv"));
            Scanner nasdaqStockScanner=new Scanner(new File("C:\\Users\\Trevor\\IdeaProjects\\YovaishTerminal2.0\\src\\Model\\nasdaqStocks.csv"));
            nyseStockScanner.nextLine();
            while(nyseStockScanner.hasNext()){
                String [] companyInformation=nyseStockScanner.nextLine().split(",");
                possibleStockTickers.put(companyInformation[0],companyInformation[1]);
            }
            nyseStockScanner.close();
            while(nasdaqStockScanner.hasNext()){
                String [] companyInformation=nasdaqStockScanner.nextLine().split(",");
                possibleStockTickers.put(companyInformation[0],companyInformation[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("ADDED ALL STOCK TICKERS TO SET");
    }
    public static boolean checkStockTicker(String stockTicker){
        return possibleStockTickers.containsKey(stockTicker);
    }
    public static String getCompanyName(String stockTicker){return possibleStockTickers.get(stockTicker);}
}
