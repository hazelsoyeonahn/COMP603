/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        try{
            Integer.parseInt(id);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    
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
            case "Search":
                //id search button
                int id = Integer.parseInt(this.view.idInput.getText()); //get searchable id
                
                this.model.checkID(id);
                break;
            case "Register new student":
                //register new student button
                this.model.registerIdPage();
                break;
            case "Show list of student":
                //show list of student button
            case "Back to Main":
                //back to main page button
                this.model.backToMain();
                break;
            case "Create student information":
                //create student button on registerIdPage
                boolean isError = false;
                if(this.view.idField.getText().length() != 7 || !isNumeric(this.view.idField.getText())){
                    view.idError = true;
                    isError = true;
                }
                else
                    view.idError = false;
                if(!isCharacter(this.view.nameField.getText())|| this.view.nameField.getText().length() == 0){
                    view.nameError = true;
                    isError = true;
                }
                else
                    view.nameError = false;
                if(!this.view.genderField.getText().equalsIgnoreCase("F")&&!this.view.genderField.getText().equalsIgnoreCase("M")){
                    view.genderError = true;
                    isError = true;
                }
                else
                    view.genderError = false;
                if(!checkBday(this.view.bdayField.getText())){
                    view.bdayError = true;
                    isError = true;
                }
                else
                    view.bdayError = false;
                if(!this.view.majorField.getText().equals("BSC")||
                        !this.view.majorField.getText().equals("BSIS")||
                        !this.view.majorField.getText().equals("BEN")||
                        !this.view.majorField.getText().equals("MSC")||
                        !this.view.majorField.getText().equals("MEN")||
                        !this.view.majorField.getText().equals("DSC")){
                    view.majorError = true;
                    isError = true;
                }
                else
                    view.majorError = false;
                if(!isError)
                    this.model.createStudent(); 
                else
                    this.model.errorRegi();
                break;
            default:
                break;
        }
    }
}
