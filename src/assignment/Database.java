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
    String url = "jdbc:derby:StudentDB;create=true"; //url for StudentDB
    String username = "pdc";
    String password = "pdc";
    Connection conn = null;
    
    public void setupStudentDB(){
        try{
            conn = DriverManager.getConnection(url,username,password);
            Statement statement = conn.createStatement();
            String tablename = "StudentInformation";
            
            if(!checkTableExisting(tablename)){
                statement.execute("CREATE TABLE "+tablename+" "+"(name VARCHAR(30), age INT)");
            }
        }catch(Throwable e){
            System.out.println("Error");
        }
    }
    
    private boolean checkTableExisting(String tablename){
        boolean flag = false;
        try{
            System.out.println("check existing tables....");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet result = dbmd.getTables(null, null, null, null);
            while(result.next()){
                
            }
        }catch(SQLException ex){
        }
        return flag;
    }
}
