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
    public Packager(SimControl simControl) throws IllegalAccessException {
      this.simControl = simControl;
      hashMap = new HashMap<>();// initializes the hash map
      // need to add way adding data in
      consturctDataKeys();
    }
    public void consturctDataKeys() throws IllegalAccessException {

      for(Field field: simControl.getClass().getFields()) // fancy code that pulls public vars names and will be used to add names to the hash map.
      {
          System.out.println(field.getName() + " = " + field.get(simControl)); // just a tester will be used later on
          if (!field.getName().equals("currentYear")) {
            hashMap.put(field.getName(), null); // sets the hashmap key to field name then adds a null position for now
            // this make a key for all public variables found in the class simControl
          }
      }
      //just used in order to construct hashmap names
    }
    public void constructorDataValue() throws NoSuchFieldException {

      // thinking about pulling all the key and finding the corresponding variable name and then making the arraylist with the current year and then have the opaque object added
      for (String variables : hashMap.keySet()) // this will only have the var we are tracking
      {
        Field var  = simControl.getClass().getField(variables); // grabs var by given name from hashmap then sets it into var
        // data structure put into hash map is going to be a tuple pair and an arraylist of tuples
        // each tuple will have a year associated with them
        // the array list we added into the hashmap with the key of the same name of the variable
        


      }
    }




}
