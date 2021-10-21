/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.ArrayList;
/**
 *
 * @author fvx3255
 */
public class AmbassadorBooking {
    public static ArrayList<String> availableList= new ArrayList<String>();; //booking is available for 4 month
    
    public String[] getArray(){
         String[] ambBookings = new String[availableList.size()];
        for(int i=0; i<availableList.size(); i++)
            ambBookings[i] = availableList.get(i);
        return ambBookings;
    }
    
    public ArrayList<String> getArrayList(){
        return availableList;
    }
  }
