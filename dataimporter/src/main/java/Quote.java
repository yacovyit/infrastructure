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

    public void setOpen(Float open) {
        this.open = open;
    }

    public Float getHigh() {
        return high;
    }

    public void setHigh(Float high) {
        this.high = high;
    }

    public Float getLow() {
        return low;
    }

    public void setLow(Float low) {
        this.low = low;
    }

    public Float getClose() {
        return close;
    }

    public void setClose(Float close) {
        this.close = close;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
