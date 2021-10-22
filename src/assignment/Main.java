package assignment;

/**
 * This is a main class of Student Information Application.
 * Controller class controls Model Observable and View Observer
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
