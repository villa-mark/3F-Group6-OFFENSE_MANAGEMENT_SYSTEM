package offense.management.register;

import javax.swing.*;
import java.awt.*;

public class RegisterController{
  public static void main(String args[]){
    JFrame frame = new JFrame();
    frame.setSize(835, 670);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.getContentPane().setBackground(Color.black);

    ImageIcon bgImg = new ImageIcon("register.png");
    JLabel imgHold = new JLabel(bgImg);
    RegisterView.addImage(frame, imgHold, bgImg, 10, 0);

    ImageIcon bgImg2 = new ImageIcon("woman.png");
    JLabel imgHold2 = new JLabel(bgImg2);
    RegisterView.addImage(frame, imgHold2, bgImg2, bgImg.getIconWidth(), 0);

    JPanel RegisterPanel = new JPanel();
    RegisterView.addPanel(frame, RegisterPanel, 10,152,359, 470, 0xCCCCCC);

    JLabel firstnameLbl = new JLabel("First Name:");
    RegisterView.addLabel(RegisterPanel, firstnameLbl, 40, 10, 120, 40, 20, "Roboto");

    JTextField firstnameTxt = new JTextField();
    RegisterView.addTextField(RegisterPanel, firstnameTxt, 40, 50, 270, 40, "Roboto", 20);

    JLabel lastnameLbl = new JLabel("Last Name:");
    RegisterView.addLabel(RegisterPanel, lastnameLbl, 40, 90, 120, 40, 20, "Roboto");

    JTextField lastnameTxt = new JTextField();
    RegisterView.addTextField(RegisterPanel, lastnameTxt, 40, 130, 270, 40, "Roboto", 20);

    JLabel usernameLbl = new JLabel("Username:");
    RegisterView.addLabel(RegisterPanel, usernameLbl, 40, 170, 120, 40, 20, "Roboto");

    JTextField usernameTxt = new JTextField();
    RegisterView.addTextField(RegisterPanel, usernameTxt, 40, 210, 270, 40, "Roboto", 20);

    JLabel passwordLbl = new JLabel("Password:");
    RegisterView.addLabel(RegisterPanel, passwordLbl, 40, 250, 120, 40, 20, "Roboto");

    JPasswordField passwordTxt = new JPasswordField();
    RegisterView.addJPasswordField(RegisterPanel, passwordTxt, 40, 290, 270, 40, "Roboto", 20);

    JButton cancelButton = new JButton("CANCEL");
    RegisterView.addButton(RegisterPanel, cancelButton, 15, 420,160, 30, "Roboto", 22, 0xC5C5C5, 0x626262  );

    JButton registerButton = new JButton("REGISTER");
    RegisterView.addButton(RegisterPanel, registerButton, 185, 420,160, 30, "Roboto", 22, 0xC5C5C5, 0x626262  );



    frame.setVisible(true);
  }
}
