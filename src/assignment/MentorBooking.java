package assignment;
import java.util.ArrayList;
/**
 * This class is a MentorBooking class which have two static ArrayLists.
 * This class contains few method to validate mentor booking information.
 * @author fvx3255
 */
public class MentorBooking {
    public static ArrayList<String> availableMeList= new ArrayList<String>(); //booking is available for 4 month
    public static ArrayList<String> paperList = new ArrayList<String>(); //paperlist of mentor
    
    //returns array of available mentor list
    public String[] getArray(){
        String[] meBookings = new String[availableMeList.size()];
        for(int i=0; i<availableMeList.size(); i++)
            meBookings[i] = availableMeList.get(i);
        return meBookings;
    }
    
    //returns array of paper list
    public String[] getPaperArray(){
        String[] papers = new String[paperList.size()];
        for(int i=0; i<paperList.size(); i++)
            papers[i] = paperList.get(i);
        return papers;
    }
     
    //returns arrayList of available mentor session list
    public ArrayList<String> getArrayList(){
        return availableMeList;
    }
}
