/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;


import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author fvx3255
 */
public class Controller implements ActionListener{
    public Model model;
    public View view;
    
    public Controller(View view, Model model){
        this.model = model;
        this.view = view;
        this.view.addActionListener(this);
    }
    
    public boolean isNumeric(String id){
        if(id.length() == 0)
            return false;
        try{
            Integer.parseInt(id);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    
    //check if parameter name is character, returns boolean
    public boolean isCharacter(String name){
        boolean isAllSpace = false;
        for(int i=0; i<name.length(); i++){
            char c = name.charAt(i);
            if(!(c == ' ') && !Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }

    //check if parameter bday is in a right form
    public boolean checkBday(String bday){
        if(bday.length() != 8)
            return false;
        else{
            //check if date is in correct form
            if(bday.charAt(2) == '/' && bday.charAt(5) == '/'){
               try{
                   int day = Integer.parseInt(bday.substring(0, 2));
                   int month = Integer.parseInt(bday.substring(3,5));
                   int year = Integer.parseInt(bday.substring(6,8));
                   
                   if(0<=day && day<=31 && 0<=month && month<=12 && 0<=year && year<=99)
                       return true;
               }catch(NumberFormatException e){
                   return false;
               }
             }
        }
        return false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        switch(command){
            //idPanel buttons
            case "Search":
                //id search button
                int id =0;
                try{
                    id = Integer.parseInt(this.view.idInput.getText()); //get searchable id
                    this.view.idSearchError = false;
                    this.model.checkID(id);
                }catch(NumberFormatException ex){
                    this.view.idSearchError = true;
                    this.model.regiErrorDetected();        
                }
                break;
            case "Register new student":
                //register new student button which takes to regiPanel
                this.model.registerIdPage();
                break;
            case "Show list of student":
                //show list of student button which takes to listPanel
                this.model.showListStudent();
                break;
            case "Back to Main":
                //back to main page button
                this.model.backToMain();
                break;
            case "Book Ambassador":
                //book ambassador button
                String select1 =(String) this.view.ambBox.getItemAt(this.view.ambBox.getSelectedIndex());
                this.model.bookAmbassador(select1);
                break;
            case "Book Mentor":
                //book mentor button
                String select2 =(String) this.view.menBox.getItemAt(this.view.menBox.getSelectedIndex());
                this.model.bookMentor(select2);
                break;
            case "Find mentor session":
                String papSelection =(String) this.view.papBox.getItemAt(this.view.papBox.getSelectedIndex());
                this.model.availableMentor(papSelection);
                break;
            case "Create student information":
                //create student button on regiPanel
                Student newStudent = new Student();
                boolean isError = false; //check if there is any error occured
                int newId = 0;
                //check id
                try{
                   newId = Integer.parseInt(this.view.idField.getText()); //check if id is all digits
                }catch(NumberFormatException ex){
                   view.idError = true;
                   isError = true;
                  }   
                if(this.view.idField.getText().length() != 7){ //if id length is not 7, give error
                    view.idError = true;
                     isError = true;          
                }
                else if(this.model.checkExistingID(newId)){ //if id already exist, give error
                    view.existIdError = true;
                    isError = true;
                }
                else{
                    view.idError = false; 
                    view.existIdError = false;
                    newStudent.id = newId; //initialise id if no error
                }
                //check name
                if(!isCharacter(this.view.nameField.getText())|| this.view.nameField.getText().length() == 0){ //check if name is character or null
                    view.nameError = true;
                    isError = true;
                }
                else{
                     view.nameError = false;
                     newStudent.name = this.view.nameField.getText(); //initialise name if no error
                }     
                //check gender
                if(!this.view.genderField.getText().equalsIgnoreCase("F")&&!this.view.genderField.getText().equalsIgnoreCase("M")){
                    view.genderError = true; //if gender not in a right form, give error
                    isError = true;
                }
                else{
                     view.genderError = false;
                     newStudent.gender = this.view.genderField.getText();
                }             
                if(!checkBday(this.view.bdayField.getText())){
                    view.bdayError = true; //if bday not in a right form, give error
                    isError = true;
                }
                else{
                     view.bdayError = false;
                     newStudent.birthday = this.view.bdayField.getText();
                }               
                if(!this.view.majorField.getText().equalsIgnoreCase("BSC")&& //if major is not chosed in these 6 majors, give error
                        !this.view.majorField.getText().equalsIgnoreCase("BCIS")&&
                        !this.view.majorField.getText().equalsIgnoreCase("BEN")&&
                        !this.view.majorField.getText().equalsIgnoreCase("MSC")&&
                        !this.view.majorField.getText().equalsIgnoreCase("MEN")&&
                        !this.view.majorField.getText().equalsIgnoreCase("DSC")){
                    view.majorError = true;
                    isError = true;
                }
                else{
                     view.majorError = false;
                     newStudent.major = this.view.majorField.getText();
                }        
                if(!isError)
                    this.model.createStudent(newStudent);  //if there is no single error, create student
                else
                    this.model.regiErrorDetected(); //if there is any error, don't register and give warning
                break;
            default:
                break;
        }
    }
}
