import api.NasdacApi;
import api.StockApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import datamodel.Company;
import datamodel.Quotes;
import datamodel.Symbole;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {

        //download stock data from stock api
        StockApi stockApi =  new StockApi("https://www.alphavantage.co", "LQH9Z3CZJTCSIQ4R");
        List<Company> companiesByIndustry = new NasdacApi("http://www.nasdaq.com/screening/companies-by-industry.aspx").companiesByIndustry("NASDAQ");

        companiesByIndustry.forEach(company -> {
            try {
                Optional<Quotes> todayQuotes = stockApi.query(StockApi.TimeSeries.TIME_SERIES_DAILY, company.getSymbole());
                if (todayQuotes.isPresent())
                    System.out.println(todayQuotes.get().getQuoteMetaData().getSymbole() + "->" + todayQuotes.get().getQuotes().stream().findFirst().get());
                else
                    System.out.println("*** " + company.getSymbole() + " not found quotes");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

    }
}
