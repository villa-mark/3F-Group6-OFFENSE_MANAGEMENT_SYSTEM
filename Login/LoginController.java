package offense.management.login;

import javax.swing.*;
import java.awt.*;
import offense.management.component.Component;
import offense.management.register.RegisterController;
import offense.management.admin.AdminController;
import offense.management.user.UserController;
import offense.management.filehandle.FileHandleController;
import java.awt.event.*;

public class LoginController extends Component implements MouseListener{

  JTextField usernameTxt;
  JPasswordField passwordTxt;
  JLabel loginButton, registerLbl;
  static int warnMark = 0;
  static String userHold = null;
  static String passHold = null;

  public LoginController(){
    ImageIcon bgImg = new ImageIcon("login.png");
 
    JPanel loginInputPanel = new JPanel();
    LoginView.addPanel(window, loginInputPanel, 10, 170, 363, 290, bgC);
    loginInputPanel.setOpaque(false);

    usernameTxt = new JTextField();
    LoginView.addTextField(loginInputPanel, usernameTxt, 30, 63, 300, 40, "Roboto", 20);
    usernameTxt.addMouseListener(this);

    passwordTxt = new JPasswordField();
    LoginView.addJPasswordField(loginInputPanel, passwordTxt, 30, 190, 300, 40, "Roboto", 20);
    usernameTxt.addMouseListener(this);

    JPanel loginButtonPanel = new JPanel();
    LoginView.addPanel(window, loginButtonPanel, 10, 460, 363, 60, btnC);
    loginButtonPanel.setOpaque(false);

    loginButton = new JLabel("LOGIN");
    LoginView.addLabel(loginButtonPanel, loginButton, 55, 8,250, 38, 28, "Roboto", bgC);
    loginButton.addMouseListener(this);

    JPanel loginRegisterPanel = new JPanel();
    LoginView.addPanel(window, loginRegisterPanel, 10, 550, 363, 60, bgC);
    loginRegisterPanel.setOpaque(false);
  
    registerLbl = new JLabel("REGISTER");
    LoginView.addLabel(loginRegisterPanel, registerLbl, 198, 35, 150, 20, 18, "Roboto", 0xFF0000);
    registerLbl.addMouseListener(this);

    JPanel loginPanel = new JPanel();
    LoginView.addPanel(window, loginPanel, 10,0, bgImg.getIconWidth(), bgImg.getIconHeight(), bgC);
    LoginView.addImage(loginPanel, bgImg, 0, 0);

    JLabel warningLbl;
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

    window.setVisible(true);
  }

@SuppressWarnings("deprecation")
@Override
  public void mouseClicked(MouseEvent event){
      if(event.getSource() == loginButton){
        LoginView.clearFrame(window);
        if(usernameTxt.getText().isEmpty() || passwordTxt.getText().isEmpty()){
          warnMark = 1; //fill up blank
          userHold = usernameTxt.getText();
          passHold = passwordTxt.getText();
          new LoginController();
        }
        else if(usernameTxt.getText().equals("ADMIN") && passwordTxt.getText().equals("ADMIN123")){
          warnMark = 0;
          new AdminController();
        }
        else{
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
