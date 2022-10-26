package com.example.lab8;


import static org.junit.jupiter.api.Assertions.*;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;


    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }


    /**
     * checks if city is in the container
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Same City", "Same Province"));
        assertTrue( list.hasCity(new City("Same City", "Same Province")) );
    }

    /**
     * deletes city that has been added to the list
     */
    @Test
    public void deleteAddedCityTest() {
        list = MockCityList();
        list.addCity(new City("Delete City", "Delete Province"));
        list.deleteCity(new City("Delete City", "Delete Province"));
        assertFalse( list.hasCity(new City("Delete City", "Delete Province")) );
    }

    /**
     * deletes city that is not in the list
     */
    @Test
    public void deleteNonExistentCityTest() {
        list = MockCityList();
        list.deleteCity(new City("Delete City", "Delete Province"));
        assertFalse( list.hasCity(new City("Delete City", "Delete Province")) );
    }
}

