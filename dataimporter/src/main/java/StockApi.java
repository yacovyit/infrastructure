import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class StockApi {

    private static final String QUERY = "query";
    private static final String FUNCTION = "function";
    private static final String SYMBOLE = "symbol";
    private static final String API_KEY = "apikey";
    //base url of the stock api
    private WebTarget target;
    private String apikey;
    //https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY&symbol=GOOG&apikey=
    StockApi(String url, String apikey){
        Client c = ClientBuilder.newBuilder()
                .register(ObjectMapper.class)
                .build();
        target = c.target(url);
        this.apikey = apikey;
    }

    public JsonNode query(TimeSeries timeSeries, String symbol){
        JsonNode jsonNode = target
                .path(QUERY)
                .queryParam(FUNCTION,timeSeries.name())
                .queryParam(SYMBOLE, symbol)
                .queryParam(API_KEY, apikey)
                .request()
                .get(JsonNode.class);
        return jsonNode;
    }

    public static enum TimeSeries {

        TIME_SERIES_INTRADAY,
        TIME_SERIES_DAILY,
        TIME_SERIES_DAILY_ADJUSTED,
        TIME_SERIES_WEEKLY,
        TIME_SERIES_WEEKLY_ADJUSTED,
        TIME_SERIES_MONTHLY,
        TIME_SERIES_MONTHLY_ADJUSTED,
        BATCH_STOCK_QUOTES

    }
}
