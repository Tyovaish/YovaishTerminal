package Model.API;

import javafx.application.Platform;
import Model.Stock;
import Model.StockSummary;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

import java.io.IOException;

public class StockSummaryScraper implements Runnable {
   static private final int VOLUME=73;
   static private final int AVGVOLUME=79;
   static private final int MKTCAP=88;
   static private final int PE_RATIO=100;
   static private final int EPS=106;


    Stock stock;
    public  StockSummaryScraper(Stock stock){
        this.stock=stock;
    }
    private void removeComments(Node node) {
        for (int i = 0; i < node.childNodeSize();) {
            Node child = node.childNode(i);
            if (child.nodeName().equals("#comment"))
                child.remove();
            else {
                removeComments(child);
                i++;
            }
        }
    }
    @Override
    public void run() {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://finance.yahoo.com/quote/"+stock.getStockTicker()+"?p="+stock.getStockTicker()).get();
            removeComments(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String volume = doc.select("span[data-reactid="+VOLUME+"]").first().text();
        String avgVolume = doc.select("span[data-reactid="+AVGVOLUME+"]").first().text();
        String mktCap = doc.select("span[data-reactid="+MKTCAP+"]").first().text();
        String peRatio = doc.select("span[data-reactid="+PE_RATIO+"]").first().text();
        String eps= doc.select("span[data-reactid="+EPS+"]").first().text();
//        System.out.println(volume);
//        System.out.println(avgVolume);
//        System.out.println(mktCap);
//        System.out.println(peRatio);
//        System.out.println(eps);
        StockSummary stockSummary = new StockSummary();
        stockSummary.setEPS(eps);
        stockSummary.setMarketCap(mktCap);
        stockSummary.setPeRatio(peRatio);
        stockSummary.setAvgVolume(avgVolume);
        stockSummary.setVolume(volume);
        stock.setStockSummary(stockSummary);
        System.out.println("STOCK SUMMARY COMPLETED");
    }
}
