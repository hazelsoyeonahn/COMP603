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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Model model = new Model();
       View view = new View();
       Controller control = new Controller(view, model);
       model.addObserver(view);
    }
    
}
