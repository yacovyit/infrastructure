package datamodel;

import datamodel.QuoteMetaData;

import java.util.List;

public class Quotes {

    private QuoteMetaData quoteMetaData;
    private List<Quote> quotes;

    public Quotes(QuoteMetaData quoteMetaData, List<Quote> quotes) {
        this.quoteMetaData = quoteMetaData;
        this.quotes = quotes;
    }

    public QuoteMetaData getQuoteMetaData() {
        return quoteMetaData;
    }

    public void setQuoteMetaData(QuoteMetaData quoteMetaData) {
        this.quoteMetaData = quoteMetaData;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

}
