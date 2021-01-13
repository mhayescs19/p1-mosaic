/*
 * Copyright (c) 2021.
 * Created by Andrew Pegg
 */

package Packager;

import Main.SimControl;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * packages data to be transferred to nakul's code
 * thinking that this will have some datastructures that will hold onto the code per iteration
 * also may be used for database
 *
 */
public class Packager {
  private   HashMap<String, ArrayList<AbstractMap.SimpleEntry<Integer,Object>>> hashMap; //for each type of data we have as an array list attached to it with the assign data type of a tuple pair of year and value
    public Packager(SimControl simControl)
    {
      hashMap = new HashMap<>();// initializes the hash map
      // need to add way adding data in
    }
    public void addDataValueIn()
    {

    }



}
