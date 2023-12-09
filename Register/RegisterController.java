package offense.management.register;

import javax.swing.*;
import java.awt.*;
import offense.management.component.Component;
import offense.management.login.LoginController;
import java.awt.event.*;

public class RegisterController extends Component implements MouseListener{

  JTextField firstnameTxt, lastnameTxt, usernameTxt;
  JPasswordField passwordTxt;
  JLabel cancelButton, registerButton;

  public RegisterController(){
    ImageIcon bgImg = new ImageIcon("register.png");

    JPanel registerInputPanel = new JPanel();
    RegisterView.addPanel(window, registerInputPanel, 10, 140, 363, 370, bgC);
    registerInputPanel.setOpaque(false);

    firstnameTxt = new JTextField();
    RegisterView.addTextField(registerInputPanel, firstnameTxt, 35, 50, 296, 40, "Roboto", 20);

    lastnameTxt = new JTextField();
    RegisterView.addTextField(registerInputPanel, lastnameTxt, 35, 130, 296, 40, "Roboto", 20);

    usernameTxt = new JTextField();
    RegisterView.addTextField(registerInputPanel, usernameTxt, 35, 210, 296, 40, "Roboto", 20);

    passwordTxt = new JPasswordField();
    RegisterView.addJPasswordField(registerInputPanel, passwordTxt, 35, 290, 296, 40, "Roboto", 20);

    JPanel buttonPanel = new JPanel();
    RegisterView.addPanel(window, buttonPanel, 10, 515, 363, 100, btnC);
    buttonPanel.setOpaque(false);

    cancelButton = new JLabel("CANCEL");
    RegisterView.addLabel(buttonPanel, cancelButton, 18, 43,160, 30, 20, "Roboto", bgC);
    cancelButton.addMouseListener(this);

    registerButton = new JLabel("REGISTER");
    RegisterView.addLabel(buttonPanel, registerButton, 185, 43,160, 30, 20, "Roboto", bgC);
    registerButton.addMouseListener(this);


    JPanel registerPanel = new JPanel();
    RegisterView.addPanel(window, registerPanel, 10,0, bgImg.getIconWidth(), bgImg.getIconHeight(), bgC);
    RegisterView.addImage(registerPanel, bgImg, 0, 0);

    window.setVisible(true);
  }

@SuppressWarnings("deprecation")
@Override
  public void mouseClicked(MouseEvent event){
    if(event.getSource() == cancelButton){
      RegisterView.clearFrame(window);
      new LoginController();
     }
    if(event.getSource() == registerButton){
      RegisterView.clearFrame(window);
      new LoginController();
     }
  }
@Override
  public void mouseEntered(MouseEvent event){
    if(event.getSource() == cancelButton){
        RegisterView.changeButton(cancelButton, "Roboto", 25, 0xFFFFFF);
      }
    if(event.getSource() == registerButton){
        RegisterView.changeButton(registerButton, "Roboto", 23, 0xFFFFFF);
      }
  }
@Override
  public void mouseExited(MouseEvent event){
    if(event.getSource() == cancelButton){
        RegisterView.changeButton(cancelButton, "Roboto", 20, bgC);
      }
    if(event.getSource() == registerButton){
        RegisterView.changeButton(registerButton, "Roboto", 20, bgC);
      }
  }
@Override
  public void mousePressed(MouseEvent event){
    
  }
@Override
  public void mouseReleased(MouseEvent event){
    
  }
}