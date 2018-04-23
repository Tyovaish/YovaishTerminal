package Model;

public class StockSummary {
    String eps;
    String peRatio;
    String marketCap;
    String volume;
    String avgVolume;

    public String getEPS(){
        return eps;
    }
    public String getPeRatio(){
        return peRatio;
    }
    public String getMarketCap(){
        return marketCap;
    }
    public String getVolume() {
        return volume;
    }
    public String getAvgVolume() { return avgVolume; }

    public void  setEPS(String eps){
        this.eps=eps;
    }
    public  void setMarketCap(String marketCap){
        this.marketCap=marketCap;
    }
    public void setPeRatio(String peRatio){
        this.peRatio=peRatio;
    }
    public void setVolume(String volume) {
        this.volume = volume;
    }
    public void setAvgVolume(String avgVolume) { this.avgVolume = avgVolume;}
}
