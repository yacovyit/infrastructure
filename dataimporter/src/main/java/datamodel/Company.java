package datamodel;

public class Company {

    private String Symbole;
    private String name;
    private String lastSale;
    private String marketCap;
    private String adrTso;
    private String iPOyear;
    private String Sector;
    private String Industry;
    private String summaryQuote;

    public Company(String symbole, String name, String lastSale, String marketCap, String adrTso, String iPOyear, String sector, String industry, String summaryQuote) {
        Symbole = symbole;
        this.name = name;
        this.lastSale = lastSale;
        this.marketCap = marketCap;
        this.adrTso = adrTso;
        this.iPOyear = iPOyear;
        Sector = sector;
        Industry = industry;
        this.summaryQuote = summaryQuote;
    }

    public String getSymbole() {
        return Symbole;
    }

    public void setSymbole(String symbole) {
        Symbole = symbole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastSale() {
        return lastSale;
    }

    public void setLastSale(String lastSale) {
        this.lastSale = lastSale;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    public String getAdrTso() {
        return adrTso;
    }

    public void setAdrTso(String adrTso) {
        this.adrTso = adrTso;
    }

    public String getiPOyear() {
        return iPOyear;
    }

    public void setiPOyear(String iPOyear) {
        this.iPOyear = iPOyear;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String sector) {
        Sector = sector;
    }

    public String getIndustry() {
        return Industry;
    }

    public void setIndustry(String industry) {
        Industry = industry;
    }

    public String getSummaryQuote() {
        return summaryQuote;
    }

    public void setSummaryQuote(String summaryQuote) {
        this.summaryQuote = summaryQuote;
    }
}
