package com.t2008m.accuwheather.entity;

public class DailyWeather {
    private String DateTime;
    private int WeatherIcon;
    private String IconPhrase;
    private int PrecipitationProbability;
    private Temperature Temperature;

    public DailyWeather() {
    }

    public DailyWeather(String dateTime, int weatherIcon, String iconPhrase, int precipitationProbability, Temperature temperature) {
        this.DateTime = dateTime;
        this.WeatherIcon = weatherIcon;
        this.IconPhrase = iconPhrase;
        this.PrecipitationProbability = precipitationProbability;
        this.Temperature = temperature;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        this.DateTime = dateTime;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        this.WeatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        this.IconPhrase = iconPhrase;
    }

    public int getPrecipitationProbability() {
        return PrecipitationProbability;
    }

    public void setPrecipitationProbability(int precipitationProbability) {
        this.PrecipitationProbability = precipitationProbability;
    }

    public Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.Temperature = temperature;
    }
}
