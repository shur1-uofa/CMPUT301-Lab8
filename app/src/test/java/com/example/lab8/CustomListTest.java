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

    /**
     * Adds 3 distinct cities that has been added to the list
     * then checks its count
     */
    @Test
    public void countCityTest() {
        // There is one "feature". If you add multiple cities of same name, province.
        // They are counted multiple times. So you can have a list full of basically
        // the same City objects
        // I'm gonna say this is a "feature" because the lab's implementation of countCity
        // doesn't account for this
        list = MockCityList();
        list.addCity(new City("City 1", "A"));
        list.addCity(new City("City 2", "B"));
        list.addCity(new City("City 3", "C"));
        assertEquals(3, list.getCount());
    }

}

