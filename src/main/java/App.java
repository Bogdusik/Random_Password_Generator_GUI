/**
 * Main application entry point for the Password Generator GUI.
 * Launches the graphical user interface for password generation.
 */
public class App {
    /**
     * Main method to start the application.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create and display the GUI
        PasswordGeneratorGUI passwordGeneratorGUI = new PasswordGeneratorGUI();
        passwordGeneratorGUI.setVisible(true);
    }
}
