package offense.management.login;

import offense.management.component.Component;
import offense.management.register.RegisterController;
import offense.management.admin.AdminController;
import offense.management.user.UserController;
import offense.management.filehandle.FileHandleController;
import offense.management.teacher.TeacherController;

import javax.swing.*;
import java.awt.event.*;

/**
 * The LoginController class manages the control flow of the login window.
 * It handles user input, authentication, and navigation to other components.
 */
public class LoginController extends Component implements MouseListener {

    private JTextField usernameTxt;
    private JPasswordField passwordTxt;
    private JLabel loginButton, registerLbl;
    private static int warnMark = 0;
    private static String userHold = null;
    private static String passHold = null;

    /**
     * Constructs an instance of the LoginController class.
     * Initializes the GUI components and sets up the login window.
     */
    public LoginController() {
        // Set background image for the login window
        	ImageIcon bgImg = new ImageIcon("Images//login.png");

        // Create the login input panel
	        JPanel loginInputPanel = new JPanel();
	        LoginView.addPanel(window, loginInputPanel, 10, 170, 363, 290, bgC);

        // Create and configure text fields for username and password
	        usernameTxt = new JTextField();
	        LoginView.addTextField(loginInputPanel, usernameTxt, 30, 63, 300, 40, "Roboto", 20);
	        usernameTxt.addMouseListener(this);
	
	        passwordTxt = new JPasswordField();
	        LoginView.addJPasswordField(loginInputPanel, passwordTxt, 30, 190, 300, 40, "Roboto", 20);
	        usernameTxt.addMouseListener(this);

        // Create the login button panel
	        JPanel loginButtonPanel = new JPanel();
	        LoginView.addPanel(window, loginButtonPanel, 10, 460, 363, 60, btnC);

        // Create and configure the login button
	        loginButton = new JLabel("LOGIN");
	        LoginView.addLabel(loginButtonPanel, loginButton, 55, 8, 250, 38, 28, "Roboto", bgC);
	        loginButton.addMouseListener(this);

        // Create the register label panel
	        JPanel loginRegisterPanel = new JPanel();
	        LoginView.addPanel(window, loginRegisterPanel, 10, 550, 363, 60, bgC);
	        loginRegisterPanel.setOpaque(false);

        // Create and configure the register label
	        registerLbl = new JLabel("REGISTER");
	        LoginView.addLabel(loginRegisterPanel, registerLbl, 198, 35, 150, 20, 18, "Roboto", 0xFF0000);
	        registerLbl.addMouseListener(this);

        // Create the background panel with the login image
	        JPanel loginPanel = new JPanel();
	        LoginView.addPanel(window, loginPanel, 10, 0, bgImg.getIconWidth(), bgImg.getIconHeight(), bgC);
	        LoginView.addImage(loginPanel, bgImg, 0, 0);

        // Display warning label based on warnMark value
	        JLabel warningLbl;
	        if (warnMark == 1) {
	            warningLbl = new JLabel("Fill Up The Blank");
	            LoginView.addLabel(loginInputPanel, warningLbl, 0, 235, 363, 30, 25, "Roboto", 0xFF0000);
	            usernameTxt.setText(userHold);
	            passwordTxt.setText(passHold);
	        } else if (warnMark == 2) {
	            warningLbl = new JLabel("Account Does Not Exist");
	            LoginView.addLabel(loginInputPanel, warningLbl, 0, 235, 363, 30, 25, "Roboto", 0xFF0000);
	        } else if (warnMark == 3) {
	            warningLbl = new JLabel("Wrong Password");
	            LoginView.addLabel(loginInputPanel, warningLbl, 0, 235, 363, 30, 25, "Roboto", 0xFF0000);
	            usernameTxt.setText(userHold);
	        }

        // Set the login window as visible
        	window.setVisible(true);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void mouseClicked(MouseEvent event) {
        if (event.getSource() == loginButton) {
            // Clear the login window
            	LoginView.clearFrame(window);

            if (usernameTxt.getText().isEmpty() || passwordTxt.getText().isEmpty()) {
                // If any of the input fields is empty, initialize warnMark to 1
                	warnMark = 1;
                	
                userHold = usernameTxt.getText();
                passHold = passwordTxt.getText();
                new LoginController();
            } else if (usernameTxt.getText().equals("ADMIN") && passwordTxt.getText().equals("ADMIN123")) {
                // Navigate to AdminController if login as admin
	                warnMark = 0;
	                new AdminController();
            } else {
                // Check data inputted and initialize warnMark depending on the condition met
                	int numMark = FileHandleController.accountCheck(usernameTxt.getText(), passwordTxt.getText());
                
                if (numMark == 0) {
                    // Data inputted is not found in user data file
	                    warnMark = 2;
	                    new LoginController();
                } else if (numMark == 1) {
                    // Username data exists but wrong inputted password
	                    userHold = usernameTxt.getText();
	                    warnMark = 3;
	                    new LoginController();
                } else if (numMark == 3) {
                    // Both the inputted data is found from the file as a student
	                    warnMark = 0;
	                    new UserController();
                } else if (numMark == 2) {
                    // Both the inputted data is found from the file as a teacher
	                    warnMark = 0;
	                    new TeacherController();
                }
            }
        }

        if (event.getSource() == registerLbl) {
            // Navigate to RegisterController when the register label is clicked
	            LoginView.clearFrame(window);
	            warnMark = 0;
	            new RegisterController();
        }
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        if (event.getSource() == loginButton) {
            // Change the login button attributes when the cursor enters on it
            	LoginView.changeButton(loginButton, "Roboto", 33, 0xFFFFFF);
        }

        if (event.getSource() == registerLbl) {
            // Change the register label attributes when the cursor enters on it
            	LoginView.changeButton(registerLbl, "Roboto", 22, 0x2400FF);
        }
    }

    @Override
    public void mouseExited(MouseEvent event) {
        if (event.getSource() == loginButton) {
            // Change the login button attributes when the cursor exits on it
            	LoginView.changeButton(loginButton, "Roboto", 28, bgC);
        }

        if (event.getSource() == registerLbl) {
            // Change the register label attributes when the cursor exits on it
            	LoginView.changeButton(registerLbl, "Roboto", 18, 0xFF0000);
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {
        // No specific action for mouse press events in this context
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        // No specific action for mouse release events in this context
    }
}
