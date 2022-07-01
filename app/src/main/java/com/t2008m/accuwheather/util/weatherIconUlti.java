package com.t2008m.accuwheather.util;

public class weatherIconUlti {
    private static String iconLink="https://developer.accuweather.com/sites/default/files/%s-s.png";
    public static String changeIconWeather(int weather){
        if (weather<10){
            return String.format(iconLink,"0"+weather);
        }
        return String.format(iconLink,weather);

    }
}
