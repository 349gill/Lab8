package com.example.lab8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    /**
     * Creates a mock list for testing
     * @return a new CustomList instance with an empty city list
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * Test for addCity method: Adds a city to the list and checks if the list size increases by one
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(list.getCount(), listSize + 1);
    }

    /**
     * Test for deleteCity method:
     * 1. Adds and deletes the same city to check if the size decreases.
     * 2. Checks that Exception is thrown while deleting a city thats not in the CustomList
     */
    @Test
    public void deleteCityTest() throws Exception {
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        int listSize = list.getCount();
        list.deleteCity(city);
        assertEquals(list.getCount(), listSize - 1);
        Exception exception = assertThrows(Exception.class, () -> list.deleteCity(city));
        assertEquals("City not in list: " + city.getCityName(), exception.getMessage());
    }

    /**
     * Test for hasCity method:
     * 1. Finds a city after it's added in the CustomList
     * 2. Checks if false is returned for a non-present city
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    /**
     * Test for countCity method: Checks if countCity returns the correct number of cities.
     */
    @Test
    public void countCityTest() {
        list = MockCityList();
        assertEquals(0, list.countCity());
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(1, list.countCity());
    }
}