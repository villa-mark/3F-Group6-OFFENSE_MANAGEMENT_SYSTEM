package offense.management.login;

//USER DEFINED PACKAGE
  import offense.management.component.Component;
  import offense.management.register.RegisterController;
  import offense.management.admin.AdminController;
  import offense.management.user.UserController;
  import offense.management.filehandle.FileHandleController;

//PRE-DEFINED PACKAGE
  import javax.swing.*;
  import java.awt.*;
  import java.awt.event.*;

public class LoginController extends Component implements MouseListener{

  //GLOBAL DECLARATION OF COMPONENTS
    JTextField usernameTxt;
    JPasswordField passwordTxt;
    JLabel loginButton, registerLbl;

    //CONTROL FLOW VARIABLES
      static int warnMark = 0;
      static String userHold = null;
      static String passHold = null;

  //CONSTRUCTOR
    public LoginController(){

      //LOGIN PANEL BACKGROUND
        ImageIcon bgImg = new ImageIcon("Images//login.png");

      //DECLARE INPUT PANEL LOCALLY
          JPanel loginInputPanel = new JPanel();
          LoginView.addPanel(window, loginInputPanel, 10, 170, 363, 290, bgC);

        //TEXTFIELDS COMPONENTS
          usernameTxt = new JTextField();
          LoginView.addTextField(loginInputPanel, usernameTxt, 30, 63, 300, 40, "Roboto", 20);
          usernameTxt.addMouseListener(this);

          passwordTxt = new JPasswordField();
          LoginView.addJPasswordField(loginInputPanel, passwordTxt, 30, 190, 300, 40, "Roboto", 20);
          usernameTxt.addMouseListener(this);

      //DECLARE LOGIN BUTTON PANEL LOCALLY
        JPanel loginButtonPanel = new JPanel();
        LoginView.addPanel(window, loginButtonPanel, 10, 460, 363, 60, btnC);
      
      //BUTTON COMPONENTS -> login
        loginButton = new JLabel("LOGIN");
        LoginView.addLabel(loginButtonPanel, loginButton, 55, 8,250, 38, 28, "Roboto", bgC);
        loginButton.addMouseListener(this);

      //DECLARE LABEL REGISTER PANEL LOCALLY
        JPanel loginRegisterPanel = new JPanel();
        LoginView.addPanel(window, loginRegisterPanel, 10, 550, 363, 60, bgC);
        loginRegisterPanel.setOpaque(false);
    
        registerLbl = new JLabel("REGISTER");
        LoginView.addLabel(loginRegisterPanel, registerLbl, 198, 35, 150, 20, 18, "Roboto", 0xFF0000);
        registerLbl.addMouseListener(this);

      //ADD THE IMAGE AS BACKGROUND
        JPanel loginPanel = new JPanel();
        LoginView.addPanel(window, loginPanel, 10,0, bgImg.getIconWidth(), bgImg.getIconHeight(), bgC);
        LoginView.addImage(loginPanel, bgImg, 0, 0);

      //FOR WARNING LABEL
        JLabel warningLbl;

        /*CONDITION TO DISPLAY WARNING
            WARNMARK 1 -> IF ANY OF THE INPUT FIELD IS EMPTY
            WARNMARK 2 -> IF DATA INPUTED IS NOT FOUND IN THE FILE
            WARNMARK 3 -> IF USERNAME IS RIGHT BUT PASSWORD IS WRONG*/
          if(warnMark == 1){
            warningLbl = new JLabel("Fill Up The Blank");
            LoginView.addLabel(loginInputPanel, warningLbl, 0, 235, 363, 30, 25, "Roboto", 0xFF0000);
            usernameTxt.setText(userHold);
            passwordTxt.setText(passHold);
          }else if(warnMark == 2){
            warningLbl = new JLabel("Account Does Not Exist");
            LoginView.addLabel(loginInputPanel, warningLbl, 0, 235, 363, 30, 25, "Roboto", 0xFF0000);
          }else if(warnMark == 3){
            warningLbl = new JLabel("Wrong Password");
            LoginView.addLabel(loginInputPanel, warningLbl, 0, 235, 363, 30, 25, "Roboto", 0xFF0000);
            usernameTxt.setText(userHold);
          }

      //SET FRAME AS VISIBLE
        window.setVisible(true);
    }

@SuppressWarnings("deprecation")

@Override
  public void mouseClicked(MouseEvent event){
      if(event.getSource() == loginButton){
        LoginView.clearFrame(window);

        //IF ANY OF THE INPUT FIELD IS EMPTY, INITIALIZE "WARNMARK" TO "1" 
          if(usernameTxt.getText().isEmpty() || passwordTxt.getText().isEmpty()){
            warnMark = 1;//Fill up the blank
            userHold = usernameTxt.getText();
            passHold = passwordTxt.getText();
            new LoginController();
          }
        //CALL --> AdminController  <-- IF THE CONDITION IS MET
          else if(usernameTxt.getText().equals("ADMIN") && passwordTxt.getText().equals("ADMIN123")){
            warnMark = 0;
            new AdminController();
          }
        //CHECK DATA INPUTED AND INITIALIZED WARNMARK DEPENDING TO THE CONDITION MET
          else{
            /*INITIALIZE NUMMARK DEPENDING TO THE RETURN OF ACCOUNTCHECK METHODS
              0 -> DATA INPUTED IS NOT FOUND IN USERDATA FILE
              1 -> USERNAME DATA EXIST BUT WRONG INPUTED PASSWORD
              2 -> ID BOTH THE INPUTED DATA IS FOUND THE FILE*/
                int numMark = FileHandleController.accountCheck(usernameTxt.getText(), passwordTxt.getText());
                  if(numMark == 0){
                    warnMark = 2; //Account does not Exist
                    new LoginController();
                  }else if(numMark == 1){
                    userHold = usernameTxt.getText();
                    warnMark = 3; //Account Exist but wrong password
                    new LoginController();
                  }else if(numMark == 2){
                    warnMark = 0;
                    new UserController();
                  }
          }
      }
      
      //CALL --> RegisterController  <-- WHEN THE CONDITION IS MET
        if(event.getSource() == registerLbl){
          LoginView.clearFrame(window);
          warnMark = 0;
          new RegisterController();
        }
  }
@Override
  public void mouseEntered(MouseEvent event){
     if(event.getSource() == loginButton){
        LoginView.changeButton(loginButton, "Roboto", 33, 0xFFFFFF);
      }
      if(event.getSource() == registerLbl){
        LoginView.changeButton(registerLbl, "Roboto", 22, 0x2400FF);
      }
  }
@Override
  public void mouseExited(MouseEvent event){
    if(event.getSource() == loginButton){
        LoginView.changeButton(loginButton, "Roboto", 28, bgC);
      }
      if(event.getSource() == registerLbl){
        LoginView.changeButton(registerLbl, "Roboto", 18, 0xFF0000);
      }
  }
@Override
  public void mousePressed(MouseEvent event){
    
  }
@Override
  public void mouseReleased(MouseEvent event){
    
  }
}
