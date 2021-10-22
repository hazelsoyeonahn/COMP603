/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
/**
 * This class is a Database class that is controls database connection with StudentDB.
 * This class includes few methods that help retrieve information from database.
 * @author fvx3255
 */
public class Database {
    String url = "jdbc:derby://localhost:1527/StudentDB;create=true"; //url for StudentDB
    String username = "pdc";
    String password = "pdc";
    Connection conn = null;
    
    //set up StudentDB database
    public void setupStudentDB(){
        try{
            conn = DriverManager.getConnection(url,username,password);
            Statement statement = conn.createStatement();
                  
        }catch(Throwable e){
            System.out.println("Error");
        }
    }
    
    //this method checks id parameter with existing database and returns Student object
    public Student checkID(int id){
        Student student = new Student();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT NAME, ID, GENDER, BIRTHDAY, MAJOR, PAPER FROM STUDENT "
            + "WHERE ID = " +id+"");
            //if id is found, save student's information and return
            if(rs.next()){
                student.idFlag = true;
                student.id = rs.getInt("ID");
                student.name = rs.getString("NAME");
                student.gender = rs.getString("GENDER");
                student.birthday = rs.getString("BIRTHDAY");
                student.major = rs.getString("MAJOR");
                student.paper = rs.getString("PAPER");
            }
            //if id is not found
            else{
                System.out.println("No such student");
                student = null; //return null value
            }
        }catch(SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }
 
    //register new student in Database
    public void registerStudent(Student student){
        Student newStudent = student;
        try{
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO STUDENT VALUES ('"+newStudent.name+
                    "', "+newStudent.id+", '"+newStudent.gender+"', '"+newStudent.birthday+"', '"
                            +newStudent.major+"')");
            System.out.println("Student is added");
        }catch(SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //This method add all students in Database to arrayList in StudentList, then returns its reference.
    public StudentList getStudentList(){
        StudentList stList = new StudentList();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT NAME, ID FROM STUDENT");
           
           while(rs.next()){
               Student tempStudent = new Student();
               tempStudent.id = rs.getInt("ID"); //only ID and NAME is displayed 
               tempStudent.name = rs.getString("NAME");
               stList.addStudent(tempStudent);
           }
           return stList;
        }catch(SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //this method initialise ambassador's booking session
    public void initAmbassadorBooking(){
        AmbassadorBooking amBooking = new AmbassadorBooking();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT BOOKINGS, AVAILABILITY FROM AMBBOOKING");
            
            while(rs.next()){
               int availability = 0;
               if(rs.getInt("AVAILABILITY") == 1){ //if 1 it can book, then initialise to AmbassadorBooking object
                   amBooking.availableAmList.add(rs.getString("BOOKINGS"));
               }
            }
            
        }catch(SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //this method books ambassador from ambbooking table
    public boolean bookAmbassador(String selection){
         try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT BOOKINGS, AVAILABILITY FROM AMBBOOKING");
            
            while(rs.next()){
                int ava = rs.getInt("AVAILABILITY");
                String booking = rs.getString("BOOKINGS");
                if(booking.equals(selection)){
                        if(ava != 1)
                        return false;
                         if(ava == 1){
                        try{//book if availability == 1, and set it back to 0
                            statement.execute("UPDATE AMBBOOKING SET AVAILABILITY = 0 WHERE BOOKINGS = '"+selection+"'");
                            return true;
                        }catch(SQLException ex){
                            System.out.println("No matching booking");
                            return false;
                        }
                    }
                }
            }
         }catch(SQLException ex){
              Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
    }
    
    //this method initilise paper bookings
    public void initPaperBooking(){
            MentorBooking meBooking = new MentorBooking();
            
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT PAPERCODE FROM PAPERCODE");
            
            while(rs.next()){
                meBooking.paperList.add(rs.getString("PAPERCODE"));
            }
            
        }catch(SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mentor initMentorBooking(String papercode){
        Mentor mentor = new Mentor();
            try{
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT ID, PAPER, AVAILABILITY1, AVAILABILITY2 FROM MENTOR");
                
                while(rs.next()){
                    String memPaper = rs.getString("PAPER");
                    if(memPaper.contains(papercode)){
                        mentor.id = rs.getInt("ID");
                        mentor.ava1 = rs.getString("AVAILABILITY1");
                        mentor.ava2 = rs.getString("AVAILABILITY2");
                        mentor.paper = memPaper;
                    }
                }
            }catch(SQLException ex){
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT NAME, ID FROM STUDENT WHERE ID = "+mentor.id);
                
                //if name found 
                if(rs.next())
                    mentor.name = rs.getString("NAME");
                else
                    mentor.name = "UNKNOWN";
                
            }catch(SQLException ex){
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return mentor;
    }
            
            
            
     public Boolean bookMentor(String selection){
         MentorBooking mb = new MentorBooking();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT BOOKINGS, PAPER, AVAILABILITY FROM MENBOOKING");
            
            while(rs.next()){
                int ava = rs.getInt("AVAILABILITY");
                String booking = rs.getString("BOOKINGS");
                String paper = rs.getString("PAPER");
                
                //if available booking matches returns the list of papers
                if(booking.equals(selection)){
                        if(ava != 1)
                        return false;
                         if(ava == 1){
                        try{
                            statement.execute("UPDATE MENBOOKING SET AVAILABILITY = 0 WHERE BOOKINGS = '"+selection+"'");
                            return true;
                        }catch(SQLException ex){
                            System.out.println("No matching booking");
                            return false;
                        }
                    }
                } 
            }
         }catch(SQLException ex){
              Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
    }
    
     //add all available papers to paperList; for student information
    public void generatePaperList(){
        Paper paper = new Paper();
        int listSize = paper.paperList.size();
        for(int i=0; i<listSize; i++){ //make sure paperList is empty
            paper.paperList.remove(paper.paperList.get(0));
        }
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT PAPERCODE FROM PAPERCODE");
            
            while(rs.next()){
                String paperCode = rs.getString("PAPERCODE");
                paper.paperList.add(paperCode); //add all available papers
            }
        }catch(SQLException ex){
              Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
