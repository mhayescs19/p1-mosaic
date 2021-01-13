/*
 * Copyright (c) 2021.
 * Created by Andrew Pegg
 */

package Packager;

import Main.SimControl;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.reflect.Field;
/**
 * packages data to be transferred to nakul's code
 * thinking that this will have some datastructures that will hold onto the code per iteration
 * also may be used for database
 *
 */
public class Packager {
  private SimControl simControl;
  private   HashMap<String, ArrayList<AbstractMap.SimpleEntry<Integer,Object>>> hashMap; //for each type of data we have as an array list attached to it with the assign data type of a tuple pair of year and value
    public Packager(SimControl simControl)
    {
      this.simControl = simControl;
      hashMap = new HashMap<>();// initializes the hash map
      // need to add way adding data in
    }
    public void ConsturctDataKeys() throws IllegalAccessException {

      for(Field field: simControl.getClass().getFields()) // fancy code that pulls public vars names and will be used to add names to the hash map.
      {
          System.out.println(field.getName() + " = " + field.get(simControl)); // just a tester will be used later on
          hashMap.put(field.getName(), null); // sets the hashmap key to field name then adds a null position for now
      }
      //just used in order to construct hashmap names
    }



}
