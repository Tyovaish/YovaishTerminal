package Model;

public class StockDateParser {
    public static String getMonth(String date){
        String [] dateCompnents = date.split("-");
        return dateCompnents[1];
    }
    public static String getDay(String date){
        String [] dateCompnents = date.split("-");
        return dateCompnents[2];
    }
    public static String getYear(String date){
        String [] dateCompnents = date.split("-");
        return dateCompnents[0];
    }
    public static String getMonthAbbreviation(String date) {
        String month = getMonth(date);
        switch (month) {
            case "01":
                return "Jan";
            case "02":
                return "Feb";
            case "03":
                return "Mar";
            case "04":
                return "Apr";
            case "05":
                return "May";
            case "06":
                return "Jun";
            case "07":
                return "Jul";
            case "08":
                return "Aug";
            case "09":
                return "Sep";
            case "10":
                return "Oct";
            case "11":
                return "Nov";
            case "12":
                return "Dec";
        }
        return "";
    }
}
