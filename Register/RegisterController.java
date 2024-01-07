/*
 * RegisterController: Manages the user registration process for a system with student and teacher roles.
 * This class extends the Component class and handles user input through mouse clicks and actions.
 * The registration process involves choosing the role (student/teacher) and entering necessary details.
 * The class uses a graphical user interface (GUI) implemented with Swing components.
 * Various control flow variables are used to determine the state of the registration process.
 * Warning messages are displayed for cases where a username already exists or if required fields are not filled.
 * Upon successful registration, user data is either added to the system or sent as a request to the administrator.
 */
package offense.management.register;

// USER-DEFINED PACKAGE
import offense.management.component.Component;
import offense.management.login.LoginController;
import offense.management.filehandle.FileHandleController;

// PRE-DEFINED PACKAGE
import javax.swing.*;
import java.awt.event.*;

// RegisterController class that inherits from Component class
// - this class has the control flow of the Register Window
public class RegisterController extends Component implements MouseListener, ActionListener {

    // GLOBAL DECLARATION OF COMPONENTS
    private JTextField firstnameTxt, lastnameTxt, usernameTxt;
    private JPasswordField passwordTxt;
    private JLabel cancelButton, registerButton, studentButton, teacherButton, canel1Button;
    private JComboBox<String> sectionBox, batchBox;

    // CONTROL FLOW VARIABLES
    private static int mark = 0;
    private static int teacherStudent = 0; // use switch panel, whether to student or to teacher
    private static String fname = null;
    private static String lname = null;
    private static String user = null;
    private static String pass = null;
    private static String section = "1A";
    private static String batch = "30";

    // CONSTRUCTOR
    public RegisterController() {

        // THIS IS THE PANEL WHERE USER CHOOSE HIS/HER ROLE
        // ADD A PANEL WHERE TO PUT REGISTER COMPONENTS
        JPanel registerInputPanel = new JPanel();
        ImageIcon bgImg = new ImageIcon("Images//teacherStudent.png");
        RegisterView.addPanel(window, registerInputPanel, 10, 140, 363, 400, bgC);
        registerInputPanel.setOpaque(false);

        // STUDENT BUTTON
        studentButton = new JLabel("STUDENT");
        RegisterView.addLabel(registerInputPanel, studentButton, 105, 65, 160, 30, 25, "Roboto", bgC);
        studentButton.addMouseListener(this);

        // TEACHER BUTTON
        teacherButton = new JLabel("TEACHER");
        RegisterView.addLabel(registerInputPanel, teacherButton, 100, 140, 160, 30, 25, "Roboto", bgC);
        teacherButton.addMouseListener(this);

        // CANCEL BUTTON
        canel1Button = new JLabel("CANCEL");
        RegisterView.addLabel(registerInputPanel, canel1Button, 100, 340, 160, 30, 25, "Roboto", bgC);
        canel1Button.addMouseListener(this);

        // EXECUTE FOLLOWING CODES IF THE CONDITION IS MET
        // TEACHER_STUDENT == 1 -> STUDENT INPUT COMPONENT
        // TEACHER_STUDENT == 2 -> TEACHER INPUT COMPONENT
        // TEACHER_STUDENT == 0 -> DOES NOT EXECUTE THIS CODE
        if (teacherStudent == 1) {
            RegisterView.clearFrame(window);
            RegisterView.clearPanel(registerInputPanel);
            bgImg = new ImageIcon("Images//registerStudent.png");

            RegisterView.addPanel(window, registerInputPanel, 10, 140, 363, 400, bgC);
            registerInputPanel.setOpaque(false);

            firstnameTxt = new JTextField();
            RegisterView.addTextField(registerInputPanel, firstnameTxt, 30, 15, 296, 35, "Roboto", 18);

            lastnameTxt = new JTextField();
            RegisterView.addTextField(registerInputPanel, lastnameTxt, 30, 75, 296, 35, "Roboto", 18);

            String[] sectionData = {"1A", "1B", "1C", "1D", "1E", "1F",
                    "2A", "2B", "2C", "2D", "2E", "2F",
                    "3A", "3B", "3C", "3D", "3E", "3F",};
            sectionBox = new JComboBox<>(sectionData);
            RegisterView.addComboBox(registerInputPanel, sectionBox, 30, 138, 150, 35);
            sectionBox.addActionListener(this);

            String[] batchData = {"30", "31", "32", "33", "34", "35"};
            batchBox = new JComboBox<>(batchData);
            RegisterView.addComboBox(registerInputPanel, batchBox, 30, 198, 150, 35);
            batchBox.addActionListener(this);

            usernameTxt = new JTextField();
            RegisterView.addTextField(registerInputPanel, usernameTxt, 30, 255, 296, 35, "Roboto", 18);

            passwordTxt = new JPasswordField();
            RegisterView.addJPasswordField(registerInputPanel, passwordTxt, 30, 315, 296, 35, "Roboto", 18);

        } else if (teacherStudent == 2) {
            RegisterView.clearFrame(window);
            RegisterView.clearPanel(registerInputPanel);
            bgImg = new ImageIcon("Images//register.png");

            RegisterView.addPanel(window, registerInputPanel, 10, 140, 363, 400, bgC);
            registerInputPanel.setOpaque(false);

            firstnameTxt = new JTextField();
            RegisterView.addTextField(registerInputPanel, firstnameTxt, 35, 50, 296, 40, "Roboto", 20);

            lastnameTxt = new JTextField();
            RegisterView.addTextField(registerInputPanel, lastnameTxt, 35, 130, 296, 40, "Roboto", 20);

            usernameTxt = new JTextField();
            RegisterView.addTextField(registerInputPanel, usernameTxt, 35, 210, 296, 40, "Roboto", 20);

            passwordTxt = new JPasswordField();
            RegisterView.addJPasswordField(registerInputPanel, passwordTxt, 35, 290, 296, 40, "Roboto", 20);
        }

        // ADD CANCEL AND SUBMIT BUTTON
        if (teacherStudent == 1 || teacherStudent == 2) {
            JPanel buttonPanel = new JPanel(); // PANEL WHERE TO ADD THE BUTTON
            RegisterView.addPanel(window, buttonPanel, 10, 545, 363, 70, btnC);
            buttonPanel.setOpaque(false);

            cancelButton = new JLabel("CANCEL");
            RegisterView.addLabel(buttonPanel, cancelButton, 18, 13, 160, 30, 20, "Roboto", bgC);
            cancelButton.addMouseListener(this);

            registerButton = new JLabel("REGISTER");
            RegisterView.addLabel(buttonPanel, registerButton, 185, 13, 160, 30, 20, "Roboto", bgC);
            registerButton.addMouseListener(this);

            JLabel warnLbl;
            // DISPLAY WARNINGS DEPENDING ON THE CONDITION MET
            // MARK == 1 -> USERNAME ALREADY EXISTS
            // MARK == 2 -> ALL THE BLANK MUST BE FILLED OUT
            if (mark == 1) {
                warnLbl = new JLabel("Try Another Username");

                if (teacherStudent == 1) {
                    RegisterView.addLabel(registerInputPanel, warnLbl, 0, 350, 363, 40, 22, "Roboto", 0xFF0000);
                } else {
                    RegisterView.addLabel(registerInputPanel, warnLbl, 0, 340, 363, 40, 28, "Roboto", 0xFF0000);
                }

                firstnameTxt.setText(fname);
                lastnameTxt.setText(lname);
            } else if (mark == 2) {
                warnLbl = new JLabel("Fill in The Blank");

                if (teacherStudent == 1) {
                    RegisterView.addLabel(registerInputPanel, warnLbl, 0, 350, 363, 40, 22, "Roboto", 0xFF0000);
                } else {
                    RegisterView.addLabel(registerInputPanel, warnLbl, 0, 340, 363, 40, 28, "Roboto", 0xFF0000);
                }

                firstnameTxt.setText(fname);
                lastnameTxt.setText(lname);
                usernameTxt.setText(user);
                passwordTxt.setText(pass);
            }
        }

        // THIS IS THE PANEL TO ADD THE BACKGROUND IMAGE
        JPanel registerPanel = new JPanel();
        RegisterView.addPanel(window, registerPanel, 10, 0, bgImg.getIconWidth(), bgImg.getIconHeight(), bgC);
        RegisterView.addImage(registerPanel, bgImg, 0, 0);

        window.setVisible(true);
    }

    @SuppressWarnings("deprecation")
    @Override
    /*
     * CONTROL FLOW MARK 0 -> RESET THE CONTENT OF ANY TEXTFIELD IN THE REGISTER WINDOW
     * 1 -> USERNAME ALREADY EXISTS 2 -> TEXTFIELD MUST BE FILLED OUT
     * 
     * TEACHER_STUDENT 0 -> DOES NOT EXECUTE ANY 1 -> STUDENT 2 -> TEACHER
     */
    public void mouseClicked(MouseEvent event) {
        if (event.getSource() == cancelButton) {
            RegisterView.clearFrame(window);
            mark = 0;
            teacherStudent = 0;
            new RegisterController();
        }
        if (event.getSource() == canel1Button) {
            RegisterView.clearFrame(window);
            mark = 0;
            teacherStudent = 0;
            new LoginController();
        }
        if (event.getSource() == studentButton) {
            RegisterView.clearFrame(window);
            mark = 0;
            teacherStudent = 1;
            new RegisterController();
        }
        if (event.getSource() == teacherButton) {
            RegisterView.clearFrame(window);
            mark = 0;
            teacherStudent = 2;
            new RegisterController();
        }

        if (event.getSource() == registerButton) {
            RegisterView.clearFrame(window);
            // FOR STUDENT
            if (teacherStudent == 1) {
                // ASSIGN 2 TO MARK IF ANY OF THE TEXTFIELD IS EMPTY
                // ELSE CHECK IF THE ACCOUNT REGISTERED EXISTS OR NOT
                // IF EXISTS, SEND A REQUEST TO THE ADMIN
                // ELSE ASK THE USER FOR ANOTHER USERNAME
                if (firstnameTxt.getText().isEmpty() || lastnameTxt.getText().isEmpty() || usernameTxt.getText().isEmpty()
                        || passwordTxt.getText().isEmpty()) {
                    mark = 2;
                    teacherStudent = 1;
                    fname = firstnameTxt.getText();
                    lname = lastnameTxt.getText();
                    user = usernameTxt.getText();
                    pass = passwordTxt.getText();
                    new RegisterController();
                } else {
                    int numMark = FileHandleController.accountCheck(usernameTxt.getText(), passwordTxt.getText());
                    if (numMark == 0) {
                        FileHandleController.addDataInPending(firstnameTxt.getText(), lastnameTxt.getText(),
                                usernameTxt.getText(), passwordTxt.getText(), section, batch);
                        mark = 0;
                        teacherStudent = 0;
                        new LoginController();
                    } else {
                        mark = 1;
                        fname = firstnameTxt.getText();
                        lname = lastnameTxt.getText();
                        new RegisterController();
                    }
                }
            }
            // FOR TEACHER
            else if (teacherStudent == 2) {
                // ASSIGN 2 TO MARK IF ANY OF THE TEXTFIELD IS EMPTY
                // ELSE CHECK IF THE ACCOUNT REGISTERED EXISTS OR NOT
                // IF EXISTS, SEND A REQUEST TO THE ADMIN
                // ELSE ASK THE USER FOR ANOTHER USERNAME
                if (firstnameTxt.getText().isEmpty() || lastnameTxt.getText().isEmpty() || usernameTxt.getText().isEmpty()
                        || passwordTxt.getText().isEmpty()) {
                    mark = 2;
                    teacherStudent = 2;
                    fname = firstnameTxt.getText();
                    lname = lastnameTxt.getText();
                    user = usernameTxt.getText();
                    pass = passwordTxt.getText();
                    new RegisterController();
                } else {
                    int numMark = FileHandleController.accountCheck(usernameTxt.getText(), passwordTxt.getText());
                    if (numMark == 0) {
                        FileHandleController.addDataInPending(firstnameTxt.getText(), lastnameTxt.getText(),
                                usernameTxt.getText(), passwordTxt.getText(), null, null);
                        mark = 0;
                        teacherStudent = 0;
                        new LoginController();
                    } else {
                        mark = 1;
                        fname = firstnameTxt.getText();
                        lname = lastnameTxt.getText();
                        new RegisterController();
                    }
                }
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        if (event.getSource() == cancelButton) {
            RegisterView.changeButton(cancelButton, "Roboto", 25, 0xFFFFFF);
        }
        if (event.getSource() == registerButton) {
            RegisterView.changeButton(registerButton, "Roboto", 23, 0xFFFFFF);
        }
        if (event.getSource() == canel1Button) {
            RegisterView.changeButton(canel1Button, "Roboto", 30, 0xFFFFFF);
        }
        if (event.getSource() == teacherButton) {
            RegisterView.changeButton(teacherButton, "Roboto", 30, 0xFFFFFF);
        }
        if (event.getSource() == studentButton) {
            RegisterView.changeButton(studentButton, "Roboto", 30, 0xFFFFFF);
        }
    }

    @Override
    public void mouseExited(MouseEvent event) {
        if (event.getSource() == cancelButton) {
            RegisterView.changeButton(cancelButton, "Roboto", 20, bgC);
        }
        if (event.getSource() == registerButton) {
            RegisterView.changeButton(registerButton, "Roboto", 20, bgC);
        }
        if (event.getSource() == canel1Button) {
            RegisterView.changeButton(canel1Button, "Roboto", 25, bgC);
        }
        if (event.getSource() == studentButton) {
            RegisterView.changeButton(studentButton, "Roboto", 25, bgC);
        }
        if (event.getSource() == teacherButton) {
            RegisterView.changeButton(teacherButton, "Roboto", 25, bgC);
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {

    }

    @Override
    public void mouseReleased(MouseEvent event) {

    }
    
	@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == sectionBox) {
		  	  section = sectionBox.getSelectedItem() + "";
		    }
			  if(event.getSource() == batchBox) {
			  batch = batchBox.getSelectedItem() + "";
		    }
		}



}