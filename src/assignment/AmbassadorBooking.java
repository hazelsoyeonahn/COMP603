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
    public ArrayList<Ambassador> ambList;
    public static ArrayList<String> availableList; //booking is available for 4 month
    
    public AmbassadorBooking(){
        this.ambList = new ArrayList<Ambassador>();
        this.availableList = new ArrayList<String>();
    }
    
    public void generateAvaList(){
        for(int i=0; i<ambList.size(); i++){
            String temp1 = ambList.get(i).ava1;
            String temp2 = ambList.get(i).ava2;
            
            String day1 = "";
            String day2 = "";
            //find days of their booking time
            for(int j=0; j<temp1.length(); j++){
                 if(temp1.charAt(j) == ',')
                    j = temp1.length()-1; // if ',' found stop the loop
                 else
                     day1 += String.valueOf(temp1.charAt(j));
            }
            
            for(int j=0; j<temp2.length(); j++){
                 if(temp2.charAt(j) == ',')
                    j = temp2.length()-1; // if ',' found stop the loop
                 else
                     day2 += String.valueOf(temp2.charAt(j));
            }
            
            int startDate1 = getStartDate(day1);
            int startDate2 = getStartDate(day2);
            
            for(int j=0; j<4; j++){
              String date1 = String.valueOf(startDate1);
              String date2 = String.valueOf(startDate2);
              
              availableList.add(date1+"/10 "+temp1);
              availableList.add(date2+"/10 "+temp2); 
              startDate1 += 7;
              startDate2 += 7;
            }  
        }
        System.out.println(availableList.toString());
    }
    
    public int getStartDate(String day){
        int date = 0;
        
        //the date is based on October 2021
        if(day.equals("Monday"))
            return 4;
        if(day.equals("Tuesday"))
            return 5;
        if(day.equals("Wednesday"))
            return 6;
        if(day.equals("Thurday"))
            return 7;
        if(day.equals("Friday"))
            return 8;
        
        //handle error if date = ""
        return date;
    }
}
