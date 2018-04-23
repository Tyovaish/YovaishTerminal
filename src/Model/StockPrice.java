package Model;

public class StockPrice {
    String date;
    double open;
    double high;
    double close;
    double low;

    public double getClose() {
        return close;
    }

    public String getDate() {
        return date;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getOpen() {
        return open;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public void setOpen(double open) {
        this.open = open;
    }

}
