import api.NasdacApi;
import api.StockApi;
import datamodel.Company;
import datamodel.Quotes;
import datamodel.Symbole;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        //download stock data from stock api
        Quotes quotes =  new StockApi("https://www.alphavantage.co", "xxxxxxxxxxx").query(StockApi.TimeSeries.TIME_SERIES_DAILY,Symbole.AAPL);
        List<Company> companiesByIndustry = new NasdacApi("http://www.nasdaq.com/screening/companies-by-industry.aspx").companiesByIndustry("NYSE");
        System.out.println("res:" + companiesByIndustry.size());


    }
}
