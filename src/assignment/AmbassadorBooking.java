package assignment;

import java.util.ArrayList;
/**
 *This class is an AmbassadorBooking class which takes in booking for ambassador.
 * This class automatically gets generated list when Model is declared. 
 * availableAmList will contain available ambassador booking sessions.
 * @author fvx3255
 */
public class AmbassadorBooking {
    public static ArrayList<String> availableAmList= new ArrayList<String>();; //booking is available for 1 month
    
    //returns String array of booking sessions for JComboBox
    public String[] getArray(){
         String[] ambBookings = new String[availableAmList.size()];
        for(int i=0; i<availableAmList.size(); i++)
            ambBookings[i] = availableAmList.get(i);
        return ambBookings;
    }
    
    //returns ArrayList of session
    public ArrayList<String> getArrayList(){
        return availableAmList;
    }
  }
