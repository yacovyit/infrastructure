package datamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Quote {

    private Float open;
    private Float high;
    private Float low;
    private Float close;
    private Integer volume;
    private LocalDateTime localDateTime;


    public Float getOpen() {
        return open;
    }
    @JsonProperty("1. open")
    public void setOpen(Float open) {
        this.open = open;
    }

    public Float getHigh() {
        return high;
    }
    @JsonProperty("2. high")
    public void setHigh(Float high) {
        this.high = high;
    }

    public Float getLow() {
        return low;
    }

    @JsonProperty("3. low")
    public void setLow(Float low) {
        this.low = low;
    }

    public Float getClose() {
        return close;
    }

    @JsonProperty("4. close")
    public void setClose(Float close) {
        this.close = close;
    }

    public Integer getVolume() {
        return volume;
    }

    @JsonProperty("5. volume")
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @JsonIgnore
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
    @JsonIgnore
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
