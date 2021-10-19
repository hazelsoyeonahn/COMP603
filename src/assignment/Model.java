/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Observable;
import java.util.Random;

/**
 *
 * @author fvx3255
 */
public class Model extends Observable{
    public Student student;
    public Database db;
    public String id;
    
    public Model(){
        this.db = new Database();
        this.db.setupStudentDB();
    }
    
    public void checkID(String id){
        this.id = id;
        this.student = this.db.checkID(id);
        
    }
    
}
