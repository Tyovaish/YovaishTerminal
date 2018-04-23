package Model.API;

import javafx.application.Platform;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import Model.Stock;

import java.io.IOException;

public class StockProfileScraper implements Runnable{
    Stock stock;
    final int COMPANY_NAME=6;
    public  StockProfileScraper(Stock stock){
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
            doc = Jsoup.connect("https://finance.yahoo.com/quote/"+stock.getStockTicker()+"/profile?p="+stock.getStockTicker()).get();
            //removeComments(doc);
            //System.out.println(doc.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        removeComments(doc.select("h3[data-reactid="+COMPANY_NAME+"]").first());
        String companyName = doc.select("h3[data-reactid="+COMPANY_NAME+"]").first().text();
        Platform.runLater(()->{stock.setStockName(companyName);});
        System.out.println("STOCK PROFILE COMPLETED");
        System.out.println(companyName);
        /*System.out.println(beta);
        System.out.println(eps);
        System.out.println(marketCap);
        System.out.println(peRatio);*/
    }
}
