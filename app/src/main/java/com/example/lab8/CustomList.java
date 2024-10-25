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
    private Context context;
    private ArrayList<City> cities;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;}

    @NonNull @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        City city = cities.get(position);
        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);
        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());
        return view;}

    /**
     * Gets the number of cities in our CustomList
     * @return number of cities in CustomList object
     */
    @Override
    public int getCount() {
        return this.cities.size();}

    /**
     * Adds a new city to CustomList
     * @param city the city to add
     */
    public void addCity(City city) {
        if (!cities.contains(city)) {
            this.cities.add(city);
        }
    }

    /**
     * Finds if a city exists in our CustomList
     * @param city the city to find
     * @return True if the city is found, False otherwise.
     */
    public boolean hasCity(City city) {
        return cities.contains(city);}

    /**
     * Deletes city from the CustomList
     * @param city the city to delete
     * @throws Exception if city is not in the CustomList
     */
    public void deleteCity(City city) throws Exception {
        if (cities.contains(city)) {
            cities.remove(city);
            return;
        } throw new Exception("City does not exist: " + city.getCityName());}

    /**
     * Gets the number of cities in our CustomList using getCount()
     * @return number of cities in CustomList object
     */
    public int countCity() {
        return this.getCount();}
}