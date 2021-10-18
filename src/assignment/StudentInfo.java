/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

/**
 *
 * @author fvx3255
 */
public class StudentInfo extends JFrame{
    private JPanel idPanel = new JPanel();
    private JPanel infoPanel = new JPanel();
    private JLabel id = new JLabel("Student ID: ");
    private JTextField idInput = new JTextField(7);
    private JLabel idNotFound = new JLabel("Student not found, please type correct student ID");
    private JButton searchButton = new JButton("Search");
    String url = "jdbc:derby:StudentDB;create=true"; //url for StudentDB
    String username = "pdc";
    String password = "pdc";
    Connection conn = null;
    
    public StudentInfo(){
        
    }
    
      public void setupStudentDB(){
        try{
            conn = DriverManager.getConnection(url,username,password);
            Statement statement = conn.createStatement();
            String tablename = "STUDENT";
            
            if(!checkTableExisting(tablename)){
                statement.execute("CREATE TABLE "+tablename+" "+"(name VARCHAR(30), age INT)");
            }
            statement.close();
        }catch(Throwable e){
            System.out.println("Error");
        }
    }
      
      
    
}
