package com.example.prudentkrishi;

public class Temperature {

    private String temp;
    private String humidity;
    private  String altitiude;
    private String dew;

    public Temperature(String temp, String humidity, String altitiude, String dew) {
        this.temp = temp;
        this.humidity = humidity;
        this.altitiude = altitiude;
        this.dew = dew;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getAltitiude() {
        return altitiude;
    }

    public void setAltitiude(String altitiude) {
        this.altitiude = altitiude;
    }

    public String getDew() {
        return dew;
    }

    public void setDew(String dew) {
        this.dew = dew;
    }
}
