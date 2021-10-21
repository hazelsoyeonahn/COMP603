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
    public static ArrayList<String> availableAmList= new ArrayList<String>();; //booking is available for 1 month
    
    public String[] getArray(){
         String[] ambBookings = new String[availableAmList.size()];
        for(int i=0; i<availableAmList.size(); i++)
            ambBookings[i] = availableAmList.get(i);
        return ambBookings;
    }
    
    public ArrayList<String> getArrayList(){
        return availableAmList;
    }
  }
