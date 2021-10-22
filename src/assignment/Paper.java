package assignment;
import java.util.ArrayList;
/**
 * This class is a paper class which have static list of paper.
 * It contains few methods to validate paper list.
 * The list only contains unenrolled papers.
 * @author fvx3255
 */
public class Paper {
    static ArrayList<String> paperList = new ArrayList<String>(); //paparList is alreayd generated with all valid papers
    
    //returns String representation of enrolled list. 
    public String getEnrolPaper(){
        String enrol = "";
        if(paperList.size() == 5) //if in the list, student is enrolled
            return enrol;
        else{
            if(!paperList.contains("COMP500"))
                enrol+= "COMP500, ";
            if(!paperList.contains("COMP503"))
                enrol+= "COMP503, ";
            if(!paperList.contains("INFS601"))
                enrol+= "INFS601, ";
            if(!paperList.contains("COMP603"))
                enrol+= "COMP603, ";
            if(!paperList.contains("COMP611"))
                enrol+= "COMP611, ";
            
            enrol = enrol.substring(0, enrol.length()-2);
            return enrol;
        }
    }
    
    //returns String representation of unenrolled list from received Student parameter
    public String getUnenrolPaper(Student stu){
        String unenrol = "";
        Student student = stu;
        //if studnet have enrolled paper
        if(stu.paper.length() != 0){
            String tempPaper = "";
            for(int i=0; i<stu.paper.length(); i++){
                if(stu.paper.charAt(i) != ',' && stu.paper.charAt(i) != ' ')
                    tempPaper+=stu.paper.charAt(i);
                if(paperList.contains(tempPaper)) 
                    paperList.remove(tempPaper); //remove from this paperList
                if(stu.paper.charAt(i) == ',')
                    tempPaper = "";
            }
        }
        //then return unenrolled paperList
        for(int i=0; i<paperList.size(); i++){
            unenrol+=paperList.get(i);
            if(i!=paperList.size()-1)
                unenrol+=", ";
        }
        return unenrol;
    }
}
