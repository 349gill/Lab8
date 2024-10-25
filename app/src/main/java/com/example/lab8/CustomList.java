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

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;
    }

    /**
     * This gets the size of the list
     * @return the number of cities in the list
     */
    @Override
    public int getCount() {
        return cities.size();
    }

    /**
     * Adds a city object to the list if it does not already exist
     * @param city the city to add
     */
    public void addCity(City city) {
        if (!cities.contains(city)) {
            cities.add(city);
        }
    }

    /**
     * Find a given city from CustomList
     * @param city the city to check
     * @return True if city is present, false if it's not found
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes a city from the Customlist
     * @param city the city to delete
     * @throws Exception if the city is not in the CustomList
     */
    public void deleteCity(City city) throws Exception {
        if (cities.contains(city)) cities.remove(city);
        else throw new Exception("City not in list: " + city.getCityName());
    }

    /**
     * Finds the total number of cities in the CustomList object
     * @return Size of the Arraylist in CustomList object
     */
    public int countCity() {
        return getCount();
    }
}