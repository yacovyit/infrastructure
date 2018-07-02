import com.fasterxml.jackson.databind.JsonNode;

public class Main {
    public static void main(String[] args) {

        //download stock data from stock api
        JsonNode jsonNode = new StockApi("https://www.alphavantage.co", "xxxxxxxxxxx").query(StockApi.TimeSeries.TIME_SERIES_DAILY,Symbole.AAPL);
        System.out.println(jsonNode);
        //insert stock data to elasticsearch

    }
}
