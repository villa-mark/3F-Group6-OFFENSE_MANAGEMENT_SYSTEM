package offense.management;

import offense.management.component.Component;
import offense.management.login.LoginController;
import javax.swing.JFrame;
import java.awt.Color;

class Main extends Component{
  public static void main(String args[]){
    window.setSize(847, 670);
    window.setLayout(null);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setLocationRelativeTo(null);
    window.getContentPane().setBackground(Color.black);

    new LoginController();
  }
}

