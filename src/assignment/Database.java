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
import java.sql.DatabaseMetaData;
/**
 *
 * @author fvx3255
 */
public class Database {
    String url = "jdbc:derby://localhost:1527/StudentInformation;create=true"; //url for StudentDB
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
            ResultSet rs = statement.executeQuery("SELECT NAME, ID, GENDER, BIRTHDAY, MAJOR FROM STUDENT "
            + "WHERE ID = " +id+"");
            //if id is found
            if(rs.next()){
                student.idFlag = true;
                student.id = rs.getInt("ID");
                student.name = rs.getString("NAME");
                student.gender = rs.getString("GENDER");
                student.birthday = rs.getString("BIRTHDAY");
                student.major = rs.getString("MAJOR");
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
}
