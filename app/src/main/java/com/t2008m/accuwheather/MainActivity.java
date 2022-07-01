package com.t2008m.accuwheather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.t2008m.accuwheather.adapter.DailyAdapter;
import com.t2008m.accuwheather.entity.DailyWeather;
import com.t2008m.accuwheather.retrofit.ApiManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tvPlace, tvStatus, tvNDTB;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvPlace = findViewById(R.id.tvPlace);
        tvStatus = findViewById(R.id.tvStatus);
        tvNDTB = findViewById(R.id.tvNDTB);
        recyclerView = findViewById(R.id.recycleView);
        //
        getHour();
        //
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void getHour() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.SERVER)
                .addConverterFactory(GsonConverterFactory.create()).build();
        ApiManager service = retrofit.create(ApiManager.class);
        service.getHour().enqueue(new Callback<List<DailyWeather>>() {
            @Override
            public void onResponse(Call<List<DailyWeather>> call, Response<List<DailyWeather>> response) {
                List<DailyWeather> weathers = response.body();
                DailyAdapter adapter = new DailyAdapter(MainActivity.this, weathers);
                recyclerView.setAdapter(adapter);
                DailyWeather dailyWeather = weathers.get(0);
                tvStatus.setText(dailyWeather.getIconPhrase());

                tvNDTB.setText(dailyWeather.getTemperature().getValue().intValue() + "°");
            }

            @Override
            public void onFailure(Call<List<DailyWeather>> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
            }
        });
    }

}