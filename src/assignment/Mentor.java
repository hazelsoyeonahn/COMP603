package assignment;

/**
 * This is a Mentor class represents Mentor extends Person class
 * This mentor class few method to validate mentor information and variables.
 * @author fvx3255
 */
public class Mentor extends Person{
    String ava1 = "";
    String ava2 = "";
    String paper = "";
    String day1 = "";
    String day2 = "";
    
    //constructor
    public Mentor(){
        super.id = 0;
        super.name = "";
    }
    
    //validate what day they are working
    public void getDay(){
        for(int i=0; i<ava1.length(); i++){
            if(ava1.charAt(i)==',')
                i = ava1.length() -1;
            else
                day1 += ava1.charAt(i);
        }
            
         for(int i=0; i<ava2.length(); i++){
            if(ava2.charAt(i)==',')
                i = ava2.length() -1;
            else
                day2 += ava2.charAt(i);
        }
    }
    
    //returns int represntation of date(based on October 2021)
    public int firstDate(String day){
        if(day.equals("Monday"))
            return 4;
        if(day.equals("Tuesday"))
            return 5;
        if(day.equals("Wednesday"))
            return 6;
        if(day.equals("Thursday"))
            return 7;
        if(day.equals("Friday"))
            return 8;
        else //if wrong input return 0
            return 0;
    }
}
