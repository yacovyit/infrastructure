package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.*;

import datamodel.*;

public class StockApi {

    private ObjectMapper objectMapper = new ObjectMapper();
    //request api
    private static final String QUERY = "query";
    private static final String FUNCTION = "function";
    private static final String SYMBOLE = "symbol";
    private static final String API_KEY = "apikey";
    //response

    private static final String META_DATA =  "Meta Data";
    private static final String Time_SERIES =  "Time Series";
    private static final String DAILY =  "Daily";

    //base url of the stock api
    private WebTarget target;
    private String apikey;

    //https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY&symbol=GOOG&apikey=
    public StockApi(String url, String apikey){
        Client c = ClientBuilder.newBuilder()
                .register(ObjectMapper.class)
                .build();
        target = c.target(url);
        this.apikey = apikey;
    }

    public Optional<Quotes> query(TimeSeries timeSeries, String symbol) throws JsonProcessingException {
        JsonNode jsonNode = target
                .path(QUERY)
                .queryParam(FUNCTION,timeSeries.name())
                .queryParam(SYMBOLE, symbol)
                .queryParam(API_KEY, apikey)
                .request()
                .get(JsonNode.class);
        return parse(jsonNode);
    }
    private Optional<Quotes> parse(JsonNode quotesNode) throws JsonProcessingException {
        List<Quote> quotes = new ArrayList<>();

        JsonNode metaDataNode = ((ObjectNode)quotesNode).remove(META_DATA);
        if (metaDataNode == null)
            return Optional.empty();
        QuoteMetaData quoteMetaData = objectMapper.treeToValue(metaDataNode, QuoteMetaData.class);

        Iterator<JsonNode> elementsIterator =  quotesNode.elements();
        if (elementsIterator.hasNext()){
            JsonNode dataNode = elementsIterator.next();

            for (Iterator<Map.Entry<String, JsonNode>> it = dataNode.fields(); it.hasNext(); ) {
                Map.Entry<String, JsonNode> entry = it.next();
                Quote quote = objectMapper.treeToValue(entry.getValue(), Quote.class);
                quotes.add(quote);
            }
        }
        return Optional.of(new Quotes(quoteMetaData, quotes));
    }

    public static enum TimeSeries {

        TIME_SERIES_INTRADAY,
        TIME_SERIES_DAILY,
        TIME_SERIES_DAILY_ADJUSTED,
        TIME_SERIES_WEEKLY,
        TIME_SERIES_WEEKLY_ADJUSTED,
        TIME_SERIES_MONTHLY,
        TIME_SERIES_MONTHLY_ADJUSTED,
        BATCH_STOCK_QUOTES;
    }
}
