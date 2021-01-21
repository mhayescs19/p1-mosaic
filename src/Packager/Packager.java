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
import java.util.List;

/**
 * packages data to be transferred to nakul's code
 * thinking that this will have some datastructures that will hold onto the code per iteration
 * also may be used for database
 *
 */
public class Packager {
  /**
   * var that design to grab the field currently*/
  private final static String yearvar = "currentYear"; //assigned pre compiled due to how I want this to work this will be used to find the value of the year from SimControl
  private final static ArrayList<String> RejectedVars = new ArrayList<>();
  private SimControl simControl;
  private   HashMap<String, ArrayList<AbstractMap.SimpleEntry<Integer,Object>>> hashMap; //for each type of data we have as an array list attached to it with the assign data type of a tuple pair of year and value
    public Packager(SimControl simControl) throws IllegalAccessException {
        ArrayFiller();
      this.simControl = simControl;
      hashMap = new HashMap<>();// initializes the hash map
      // need to add way adding data in
      consturctDataKeys();
    }
    public void consturctDataKeys() throws IllegalAccessException {

      for(Field field: simControl.getClass().getFields()) // fancy code that pulls public vars names and will be used to add names to the hash map.
      {
          System.out.println(field.getName() + " = " + field.get(simControl)); // just a tester will be used later on
          // searches if the var is with dictionary of rejected vars
          if (!RejectedVars.contains(field.getName())) {
             // sets the hashmap key to field name then adds a null position for now
            // this make a key for all public variables found in the class simControl
              if (field.getName().equals("population"))
              {
                  // need to do some mutilation of the data will add a separate method for this
                  System.out.println("place holder text");
              }
              if (field.getName().equals("initialYear"))
              {
                  // java forces you to make an allocation out side of the hash map
                  ArrayList<AbstractMap.SimpleEntry<Integer,Object>> temp = new ArrayList<>();
                  temp.add(new AbstractMap.SimpleEntry<>(0,field.get(simControl))); // this will be fix in the set wont be added to after first pass
                  hashMap.put(field.getName(), temp);
              }
              else
              {
                  hashMap.put(field.getName(), null);
              }
          }
          //separator for arraylist population

      }
      //just used in order to construct hashmap names
    }
    public void constructorDataValue() throws NoSuchFieldException, IllegalAccessException {
      // thinking about pulling all the key and finding the corresponding variable name and then making the arraylist with the current year and then have the opaque object added
      for (String variables : hashMap.keySet()) // this will only have the var we are tracking
      {
        Field var  = simControl.getClass().getField(variables); // grabs var by given name from hashmap then sets it into var
        // data structure put into hash map is going to be a tuple pair and an arraylist of tuples
        // each tuple will have a year associated with them
        // the array list we added into the hashmap with the key of the same name of the variable

        Field  year =  simControl.getClass().getField(yearvar);
        AbstractMap.SimpleEntry<Integer, Object> temp;
        temp = new AbstractMap.SimpleEntry<>((Integer) year.get(simControl), var.get(simControl)); // For hashmaps Must use Classed values so Integer not int
        //temp now houses the current year and the value of the variable from simControl
        ArrayList<AbstractMap.SimpleEntry<Integer,Object>> arrayList = new ArrayList<>();
        arrayList.add(temp);
        hashMap.put(variables,arrayList);
        //overwrites the current key position with one with the array list
      }
    }

  /**
   * really don't like doing this but cant think of a way to do it systematically that would just a efficient
   * would say hard coding in the var names is another thing i don't like but I don't know how to get around it
   *
   */
  public void ArrayFiller()
    {
      if (RejectedVars.isEmpty())
      {
          RejectedVars.add("percentageGender");
          RejectedVars.add("chanceBirth");
          RejectedVars.add("EndValue");
          RejectedVars.add("currentYear");
          RejectedVars.add("simSpeed");
          RejectedVars.add("chanceDeathInitial");
          RejectedVars.add("EndCondition");
          RejectedVars.add("EndValue");


      }
      else {
        System.out.println("list is already initialized");
      }
    }


    public void arrayListMangament(Field field)
    {
        // first is to track weather we have the right field
        if (field.getType().equals(java.util.ArrayList.class))
        {
                System.out.println("conditional statement worked and figure out this was an arraylist");

        }
        else
        {
            System.out.println("either the conditional statement failed or this was not an arraylist");
        }
    }

/*
         tracked vars all others will need to be filterd out so they wont be added to the list
        currentYear;
       initialYear;
        currentPop;
        initialPop;
        numberOfBirths;
        numberOfDeaths;
        numberMale;
        numberFemale; // will probably to play with the array list from micheal with poulation to get this data will most likely use lambda to get the data

        */








}
