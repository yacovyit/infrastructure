package datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuoteMetaData {


    private String  information;
    private String  symbole;
    private String  lastRefreshd;
    private String  outputSize;
    private String  timeZone;

    public String getInformation() {
        return information;
    }

    @JsonProperty("1. Information")
    public void setInformation(String information) {
        this.information = information;
    }

    public String getSymbole() {
        return symbole;
    }

    @JsonProperty("2. Symbol")
    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public String getLastRefreshd() {
        return lastRefreshd;
    }

    @JsonProperty("3. Last Refreshed")
    public void setLastRefreshd(String lastRefreshd) {
        this.lastRefreshd = lastRefreshd;
    }

    public String getOutputSize() {
        return outputSize;
    }

    @JsonProperty("4. Output Size")
    public void setOutputSize(String outputSize) {
        this.outputSize = outputSize;
    }

    public String getTimeZone() {
        return timeZone;
    }

    @JsonProperty("5. Time Zone")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}

