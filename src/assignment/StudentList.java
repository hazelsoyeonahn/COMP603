/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;
import java.util.ArrayList;

/**
 *
 * @author fvx3255
 */
public class StudentList {
    private ArrayList<Student> studentList;
    
    public StudentList(){
        this.studentList = new ArrayList<Student>();
    }
    
    public ArrayList<Student> returnList(){
        return this.studentList;
    }
}
