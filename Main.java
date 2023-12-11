package offense.management;

//USER DEFINED PACKAGE
  import offense.management.component.Component;
  import offense.management.login.LoginController;

//PRE-DEFINED PACKAGE
  import javax.swing.*;
  import java.awt.Color;

class Main extends Component{
  
  public static void main(String args[]){

    window.setSize(847, 670);
    window.setLayout(null);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setLocationRelativeTo(null);
    window.getContentPane().setBackground(Color.black);

    appealFrame.setSize(500, 500);
    appealFrame.setLayout(null);
    appealFrame.setDefaultLookAndFeelDecorated(true);
    appealFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    appealFrame.setResizable(false);
    appealFrame.getContentPane().setBackground(new Color(0xCCCCCC));

    new LoginController();
  }
}

