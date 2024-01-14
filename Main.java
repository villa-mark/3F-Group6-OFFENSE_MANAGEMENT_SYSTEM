package offense.management;

//User-Defined Packages
	import offense.management.component.Component;
	import offense.management.login.LoginController;

//Pre-Defined Packages for GUIs
	import javax.swing.*;
	import java.awt.Color;

/**
 * The main class that serves as the entry point for the offense management application.
 * It sets up the main window and initializes the login functionality through the LoginController.
 */
class Main extends Component {

    public static void main(String args[]) {
    	
        // Set up the main window attributes
	        window.setSize(847, 670);
	        window.setLayout(null);
	        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        window.setResizable(false);
	        window.setLocationRelativeTo(null);
	        window.getContentPane().setBackground(Color.black);

        // Set up the sub window attributes
	        appealFrame.setSize(500, 500);
	        appealFrame.setLayout(null);
	        appealFrame.setDefaultLookAndFeelDecorated(true);
	        appealFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        appealFrame.setResizable(false);
	        appealFrame.getContentPane().setBackground(new Color(0xCCCCCC));

        // Initialize the LoginController to set up the login functionality.
	        new LoginController();
    }
}
