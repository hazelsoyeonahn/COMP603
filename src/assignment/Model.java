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
    public int id;
    public View view;
    
    public Model(){
        this.db = new Database();
        this.db.setupStudentDB();
    }
    
    public void checkID(int id){
        this.id = id;
        this.student = this.db.checkID(id);
        
        if(student.idFlag){
            this.setChanged();
            this.notifyObservers(this.student);
        }
    }
    
    public boolean checkExistingID(int id){
        this.id = id;
        this.student = this.db.checkID(id);
        if(this.student == null) //if id not existing return false
            return false;
        
        return this.student.idFlag; //if id exist return true
    }
    
    public void backToMain(){
        if(this.student != null)
            this.student.idFlag = false;
        this.view.goMainFlag = true;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void registerIdPage(){
        this.view.goRegiPage = true;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void createStudent(){
        this.setChanged();
        this.notifyObservers();
    }
    
    public void errorRegi(){
        this.setChanged();
        this.notifyObservers();
    }
}
