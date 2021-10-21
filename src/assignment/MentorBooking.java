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
public class MentorBooking {
    public static ArrayList<String> availableMeList= new ArrayList<String>();; //booking is available for 4 month
     
    public String[] getArray(){
        String[] meBookings = new String[availableMeList.size()];
        for(int i=0; i<availableMeList.size(); i++)
            meBookings[i] = availableMeList.get(i);
        return meBookings;
    }
     
    public ArrayList<String> getArrayList(){
        return availableMeList;
    }
}
