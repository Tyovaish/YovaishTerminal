package Model.API;

import Model.Stock;
import Model.StockPrice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class StockDataRequest implements Runnable {
    final String API_KEY="JD2AHEDRK6AMY9QL";
    String dataSize="compact";
    String category="TIME_SERIES_DAILY";
    boolean continous=false;
    Stock stock;

    public StockDataRequest(Stock stock){
        this.stock=stock;
    }
    public void setDataSize(String dataSize){
        this.dataSize=dataSize;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public void setToContinous(){
        continous=true;
    }
    public void run(){
        String url = "https://www.alphavantage.co/query?function="+category+"&symbol="+stock.getStockTicker()+"&outputsize="+dataSize+"&apikey="+API_KEY+"&datatype=csv";
            try {
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                // optional default is GET
                con.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                in.readLine();
                while ((inputLine = in.readLine()) != null) {
                    String[] data = inputLine.split(",");
                    StockPrice stockPrice = new StockPrice();
                    stockPrice.setDate(data[0]);
                    stockPrice.setOpen(Double.parseDouble(data[1]));
                    stockPrice.setHigh(Double.parseDouble(data[2]));
                    stockPrice.setLow(Double.parseDouble(data[3]));
                    stockPrice.setClose(Double.parseDouble(data[3]));
                    stock.addStockPrice(stockPrice);
                }
                in.close();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        System.out.println("COMPLETED STOCK DATA IMPORTING");

    }
}
