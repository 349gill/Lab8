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
        return new CustomList(null, new ArrayList<>());
    }

    /**
     * Test for getCount method: Checks if getCount returns the correct number of cities.
     */
    @Test
    public void countCityTest() {
        list = MockCityList();
        assertEquals(0, list.countCity());
        list.addCity(new City("Estevan", "SK"));
        assertEquals(1, list.countCity());
        list.addCity(new City("Edmonton", "AB"));
    }

    /**
     * Test for addCity method: Checks if the CustomList size is increased after addition of a city.
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    /**
     * Test for deleteCity method:
     * 1. Adds and deletes the same city to see if the size remains the same.
     * 2. Checks whether exception is thrown when deleting invalid city.
     */
    @Test
    public void deleteCityTest() throws Exception {
        list = MockCityList();

        list.addCity(new City("Estevan", "SK"));

        int size = list.getCount();

        list.deleteCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), size - 1);

        Exception e = assertThrows(Exception.class, () -> list.deleteCity(new City("Estevan", "SK")));
        assertEquals("City not found: " + new City("Estevan", "SK").getCityName(), e.getMessage());
    }

    /**
     * Test for hasCity method: Checks if newly added city shows up in the hasCity method.
     * Checks if false is returned when city is not in the list.
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        assertFalse(list.hasCity(new City("Estevan", "SK")));
        list.addCity(new City("Estevan", "SK"));
        assertTrue(list.hasCity(new City("Estevan", "SK")));
    }

    @Test
    public void getCountTest() {
        list = MockCityList();
        assertEquals(0, list.getCount());
        list.addCity(new City("Estevan", "SK"));
        assertEquals(1, list.getCount());
        list.addCity(new City("Edmonton", "AB"));
    }
}