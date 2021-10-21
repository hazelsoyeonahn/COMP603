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
    public static ArrayList<String> paperList = new ArrayList<String>();
    
    public String[] getArray(){
        String[] meBookings = new String[availableMeList.size()];
        for(int i=0; i<availableMeList.size(); i++)
            meBookings[i] = availableMeList.get(i);
        return meBookings;
    }
    
    public String[] getPaperArray(){
        String[] papers = new String[paperList.size()];
        for(int i=0; i<paperList.size(); i++)
            papers[i] = paperList.get(i);
        return papers;
    }
     
    public ArrayList<String> getArrayList(){
        return availableMeList;
    }
}
