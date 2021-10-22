
package assignment;

import java.util.Observable;

/**
 * This class is a Model of MVC Design Pattern. 
 * This class extends Observable to notify View when event is happened.
 * This class help initialize bookable Ambassadors and Mentors
 * @author fvx3255
 */
public class Model extends Observable{
    public Student student;
    public StudentList stList;
    public Database db;
    public int id; //id of this student
    public View view;
    
    //constructor
    public Model(){
        this.db = new Database();
        this.db.setupStudentDB();
        this.db.initAmbassadorBooking(); //initiate ambassador once program starts
        this.db.initPaperBooking(); //initiate mentor once program starts
    }
   
    //this method searches ID from Database, notify student or null value to Observers
    public void checkID(int id){
        this.id = id;
        this.student = this.db.checkID(id);
        
        //if id is found, get available ambassador, mentor bookings
        if(student != null && student.idFlag){
            this.db.generatePaperList(); //if student found generatePaperList
            this.setChanged();
            this.notifyObservers(this.student);
        }
        //if id not found, no such student
        if(student == null){
            this.view.idSearchError = true; //error flag up
            this.setChanged();
            this.notifyObservers();
        }        
    }
   
    //this method change page to regiPanel
    public void registerIdPage(){
        this.view.goRegiPage = true;
        this.setChanged();
        this.notifyObservers();
    }
    
    //this method checks parameter id if it's already exists in Database
    public boolean checkExistingID(int id){
        this.id = id;
        this.student = this.db.checkID(id);
        if(this.student == null) //if id not existing return false
            return false;
        
        return this.student.idFlag; //if id exist return true
    }
    
    //this method goes back to main page
    public void backToMain(){
        if(this.student != null)
            this.student.idFlag = false;
        this.view.goMainFlag = true;
        this.setChanged();
        this.notifyObservers();
    }
    
    //register new student in Database
    public void createStudent(Student newStudent){
        this.db.registerStudent(newStudent);
        this.view.registerSucceed = true;
        this.setChanged();
        this.notifyObservers();
    }
    
    //if any error detected while registering student, notify any changed flags
    public void regiErrorDetected(){
        this.setChanged();
        this.notifyObservers();
    }
    
    //shows all list of student in db
    public void showListStudent(){
        this.stList = this.db.getStudentList();
        this.setChanged();
        this.notifyObservers(stList); //notify returned StudentList object
    }
    
    //this method books ambassador with received String
    public void bookAmbassador(String booking){
        boolean ambFlag = this.db.bookAmbassador(booking);
        if(ambFlag){
        this.view.ambBooked = true;
    }        
        this.setChanged();
        this.notifyObservers();
    }
    
    //this method books mentor with received parameter String
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
    
    //this method finds available mentor
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
