/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;
import java.util.ArrayList;

/**
 * This class represents list of student's list
 * The class contains a static ArrayList of Student object.
 * It has method that add student to the list and return the list
 * @author fvx3255
 */
public class StudentList {
    public static ArrayList<Student> studentList = new ArrayList<Student>();
    
    public StudentList(){
    }
    
    //add student to the list
    public void addStudent(Student student){
        this.studentList.add(student);
    }
    
    //return list
    public ArrayList<Student> returnList(){
        return this.studentList;
    }
}
