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
    public StudentList stList;
    public Database db;
    public int id;
    public View view;
    
    public Model(){
        this.db = new Database();
        this.db.setupStudentDB();
        this.db.initAmbassadorBooking(); //initiate ambassador once program starts
        this.db.initPaperBooking(); //initiate mentor once program starts
    }
    
    public void checkID(int id){
        this.id = id;
        this.student = this.db.checkID(id);
        
        //if id is found, get available ambassador, mentor bookings
        if(student != null && student.idFlag){
            this.setChanged();
            this.notifyObservers(this.student);
        }
        if(student == null){
            this.view.searchError = true;
            this.setChanged();
            this.notifyObservers();
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
    
    public void createStudent(Student newStudent){
        this.db.registerStudent(newStudent);
        this.view.registerSucceed = true;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void errorDetected(){
        this.setChanged();
        this.notifyObservers();
    }
    
    public void showListStudent(){
        stList = this.db.getStudentList();
        this.setChanged();
        this.notifyObservers(stList);
    }
    
    public void bookAmbassador(String booking){
        boolean ambFlag = this.db.bookAmbassador(booking);
        if(ambFlag){
        this.view.ambBooked = true;
    }        
        this.setChanged();
        this.notifyObservers();
    }
    
    public void bookMentor(String booking){
        boolean isBooked = this.db.bookMentor(booking);
        //paper cannot be null as suggested mentor teaches paper
        //check if student is enrolled for the paper
        
        if(isBooked)
            this.view.mentBooked = true;
        else
            this.view.mentBooked = true;
        this.setChanged();
        this.notifyObservers(); 
    }
    
    public void availableMentor(String selection){
        Mentor foundMentor = this.db.initMentorBooking(selection);
        if(foundMentor == null){
              this.view.noMentorError = true;
        }
        else{
            this.view.noMentorError = false;
        }
        this.setChanged();
        this.notifyObservers(foundMentor);
    }
}
