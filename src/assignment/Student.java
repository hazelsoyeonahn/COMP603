package assignment;

/**
 * This class is a Student class extends Person class.
 * It contains information for student.
 * @author fvx3255
 */
public class Student extends Person{
    public boolean idFlag;
    public String gender;
    public String birthday;
    public String major;
    public String paper;
    
    //constructor
    public Student(){
        this.idFlag = false;
        super.id = 0;
        super.name = "";
        this.gender = "";
        this.birthday = "";
        this.major = "";
        this.paper = "";
    }
}
