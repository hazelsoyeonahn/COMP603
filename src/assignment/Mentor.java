/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author fvx3255
 */
public class Mentor {
    int id = 0;
    String name = "";
    String ava1 = "";
    String ava2 = "";
    String paper = "";
    String day1 = "";
    String day2 = "";
    
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
