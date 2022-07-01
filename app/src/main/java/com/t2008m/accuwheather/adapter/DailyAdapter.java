package com.t2008m.accuwheather.adapter;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.t2008m.accuwheather.R;
import com.t2008m.accuwheather.entity.DailyWeather;
import com.t2008m.accuwheather.util.dateTimeUtil;
import com.t2008m.accuwheather.util.weatherIconUlti;

import java.util.List;

public class DailyAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<DailyWeather> weathers;

    public DailyAdapter(Activity activity, List<DailyWeather> weathers) {
        this.activity = activity;
        this.weathers = weathers;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = activity.getLayoutInflater().inflate(R.layout.daily_weather_item, parent, false);
        DailyHolder holder = new DailyHolder(viewItem);
        return holder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DailyHolder dailyHolder = (DailyHolder) holder;
        DailyWeather weather = weathers.get(position);
        dailyHolder.getTime().setText(dateTimeUtil.convertTime(weather.getDateTime()));
        String url = "";
        if (weather.getWeatherIcon() < 10){
            url = "https://developer.accuweather.com/sites/default/files/0" + weather.getWeatherIcon() + "-s.png";
        }else {
            url = "https://developer.accuweather.com/sites/default/files/" + weather.getWeatherIcon() + "-s.png";
        }
        Glide.with(activity).load(url).into(dailyHolder.getImageView());
        dailyHolder.getTemperature().setText(weather.getTemperature().getValue().toString());
    }

    @Override
    public int getItemCount() {
        return weathers.size();
    }

    private class DailyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView time, temperature;

        public DailyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.weatherImg);
            time = itemView.findViewById(R.id.textTime);
            temperature = itemView.findViewById(R.id.temperature);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public TextView getTime() {
            return time;
        }

        public void setTime(TextView time) {
            this.time = time;
        }

        public TextView getTemperature() {
            return temperature;
        }

        public void setTemperature(TextView temperature) {
            this.temperature = temperature;
        }
    }
}
