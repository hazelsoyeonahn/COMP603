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
 *
 * @author fvx3255
 */
public class Database {
    String url = "jdbc:derby://localhost:1527/StudentDB;create=true"; //url for StudentDB
    String username = "pdc";
    String password = "pdc";
    Connection conn = null;
    
    public void setupStudentDB(){
        try{
            conn = DriverManager.getConnection(url,username,password);
            Statement statement = conn.createStatement();
                  
        }catch(Throwable e){
            System.out.println("Error");
        }
    }
    
    public Student checkID(int id){
        Student student = new Student();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT NAME, ID, GENDER, BIRTHDAY, MAJOR, PAPER FROM STUDENT "
            + "WHERE ID = " +id+"");
            //if id is found
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
    
    public StudentList getStudentList(){
        StudentList stList = new StudentList();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT NAME, ID FROM STUDENT");
           
           while(rs.next()){
               Student tempStudent = new Student();
               tempStudent.id = rs.getInt("ID");
               tempStudent.name = rs.getString("NAME");
               stList.addStudent(tempStudent);
           }
           return stList;
        }catch(SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void initAmbassadorBooking(){
        AmbassadorBooking amBooking = new AmbassadorBooking();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT BOOKINGS, AVAILABILITY FROM AMBBOOKING");
            
            while(rs.next()){
               int availability = 0;
               if(rs.getInt("AVAILABILITY") == 1){
                   amBooking.availableAmList.add(rs.getString("BOOKINGS"));
               }
            }
            
        }catch(SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
                        try{
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
}
