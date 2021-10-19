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
    String url = "jdbc:derby:StudentInformation;create=true"; //url for StudentDB
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
    
    public Student checkID(String id){
        Student student = new Student();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT ID FROM STUDENT "
            + "WHERE ID = '" +id+"'");
            //if id is found
            if(rs.next()){
                
            }
            //if id is not found
            else{
                
            }
        }catch(SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return student;
    }
 
}
