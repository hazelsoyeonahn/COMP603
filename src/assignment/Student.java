/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author fvx3255
 */
public class Student {
    public boolean idFlag;
    public int id;
    public String name;
    public String gender;
    public String birthday;
    public String major;
    public String paper;
    
    public Student(){
        this.idFlag = false;
        this.id = 0;
        this.name = "";
        this.gender = "";
        this.birthday = "";
        this.major = "";
        this.paper = "";
    }
}
