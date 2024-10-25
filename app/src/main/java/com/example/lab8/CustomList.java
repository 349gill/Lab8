package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        City city = cities.get(position);
        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);
        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());
        return view;
    }

    /**
     * Gets the number of cities in our CustomList
     * @return number of cities in CustomList object
     */
    @Override
    public int getCount() {
        return cities.size();
    }

    /**
     * Adds a new city to CustomList
     * @param city the city to add
     */
    public void addCity(City city) {
        if (!cities.contains(city)) cities.add(city);
    }

}