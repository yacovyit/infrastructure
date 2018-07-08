package api;

import com.opencsv.CSVReader;
import datamodel.Company;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NasdacApi {

    private static final String EXCHANGE="exchange";
    private static final String RENDER = "render";
    private static final String DOWNLOAD = "download";
    private String url;

    public NasdacApi(String url){
       this.url = url;
    }
//http://www.nasdaq.com/screening/companies-by-industry.aspx?exchange=NASDAQ&render=download

    /***
     * get companies of given industry
     * @param industry the symbol of the industry
     * @return companies
     */
    public List<Company> companiesByIndustry(String industry) throws IOException {

        List<Company> companies =  new ArrayList<>();

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(String.format("%s?%s=%s&%s=%s", url, EXCHANGE, industry, RENDER, DOWNLOAD));
        HttpResponse response = client.execute(request);

        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        String[] line;
        boolean firstRow = true;
        CSVReader reader = new CSVReader(br);
        while ((line = reader.readNext()) != null) {
            if (firstRow){//skip the first row it is just the coloumn names, "Symbol","Name","LastSale","MarketCap","ADR TSO","IPOyear","Sector","Industry","Summary Quote",
                firstRow = false;
                continue;
            }
            companies.add(new Company(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8]));
        }

        return companies;
    }


}
