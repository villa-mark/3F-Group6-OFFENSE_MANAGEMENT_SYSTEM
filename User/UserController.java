package offense.management.user;

//user-defined packages
import offense.management.login.LoginController;
import offense.management.component.Component;
import offense.management.filehandle.FileHandleController;

//pre-defined packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class UserController extends Component implements MouseListener{

  //global declaration of components
  private static JPanel logoutPanel;
  private JButton recordButton, pendingButton, 
  		  appealBtn, explainBtn, 
  		  closeBtn, submitBtn,
  		  notifClose, notifClear;
  private JLabel[] offenses;
  private JTextArea explainAppealField;

  //control-flow variables
  private static int mark = 0;
  private static int explainFrame = 0;
  private static int numEx = 0;
  
  //data structure
  private ArrayList<ArrayList<String>> userOffense = new ArrayList<>();
  private ArrayList<ArrayList<String>> pendingAppeal = new ArrayList<>();

  //Contructors
  public UserController(){

    //initializing ImageIcon
    ImageIcon bgImg = new ImageIcon("Images//user.png");
    ImageIcon notif = new ImageIcon("Images//notif.png");
    recordButton = new JButton("RECORD");
    pendingButton = new JButton("PENDING");
    
    //execute this block if the condition is met
    //display the notification box
      if(mark == 4) {
        JPanel notifPnl = new JPanel(null);
          
        notifPnl.setBounds(200, 50, 400, 400);
        notifPnl.setBackground(new Color(btnC));
          recordButton.setEnabled(false);
          pendingButton.setEnabled(false);
          window.add(notifPnl);
          
          JLabel notifLbl = new JLabel("NOTIFICATION");
          UserView.addLabel(notifPnl, notifLbl, 120, 10, 150, 50, 20, "Roboto", 0x0fe0e0);
          
          JPanel notifOpen = new JPanel();
          UserView.addPanel(notifPnl, notifOpen, 20, 75, 360, 255, bgC);
          
          ArrayList<ArrayList<String>> notifDataIn = new ArrayList<>();
          FileHandleController.convertNotif2d(notifDataIn, FileHandleController.getID());
          
          JLabel[] notifLblDisplay = new JLabel[notifDataIn.size()];
          int incrementNum = 0;

          while(incrementNum != notifDataIn.size()) {
            notifLblDisplay[incrementNum] = new JLabel("Approved by the Admin: "+ notifDataIn.get(incrementNum).get(1));
            UserView.addLabel(notifOpen, notifLblDisplay[incrementNum], 10, (incrementNum * 35), 350, 30, 20, "Roboto");
            incrementNum++;
          }

          notifClose = new JButton("CLOSE");
          UserView.addButton(notifPnl, notifClose, 40, 340, 150, 35, 25, "Roboto", bgC, 0x000000);
          notifClose.addMouseListener(this);
          
          notifClear = new JButton("CLEAR");
          UserView.addButton(notifPnl, notifClear, 210, 340, 150, 35, 25, "Roboto", bgC, 0x000000);
          notifClear.addMouseListener(this);
          
          notifPnl.repaint();
          notifPnl.revalidate();
      }
    
    
    JPanel userInfoPanel = new JPanel();
    UserView.addPanel(window, userInfoPanel, 140, 10, 490, 100, bgC);
    userInfoPanel.setOpaque(false);

    JLabel nameLbl = new JLabel(FileHandleController.getName());
    UserView.addLabel(userInfoPanel, nameLbl, 5, 15, 485, 40, 25, "Roboto");

    JLabel IDLbl = new JLabel("ID: " + FileHandleController.getID());
    UserView.addLabel(userInfoPanel, IDLbl, 5, 50, 485, 40, 20, "Roboto");

    logoutPanel = new JPanel();
    ImageIcon logout1 = new ImageIcon("Images//logoutRed.png");
    ImageIcon logout = new ImageIcon("Images//logoutBlack.png");
    UserView.addPanel(window, logoutPanel, 760,23, logout1.getIconWidth(), logout1.getIconHeight(), 0x6B6257);

    JLabel outLbl = new JLabel(logout);
    outLbl.setBounds(0, 0, logout.getIconWidth(), logout.getIconHeight());
    logoutPanel.add(outLbl);

    JPanel panelMark = new JPanel();
    UserView.addPanel(window, panelMark, 680,30 + logout1.getIconHeight(), 140, 50, 0x6B6257);
    panelMark.setOpaque(true);

    JLabel label = new JLabel("logout");

    logoutPanel.addMouseListener(new MouseAdapter(){
      public void mouseEntered(MouseEvent e){
        outLbl.setIcon(logout1);
        UserView.addLabel(panelMark, label, 20, 0, 100, 40, 20, "Roboto", 0x000000);
        panelMark.repaint();
        panelMark.revalidate();
      }
      public void mouseExited(MouseEvent e){
        outLbl.setIcon(logout);
        panelMark.remove(label);
        panelMark.repaint();
        panelMark.revalidate();
      }
      public void mouseClicked(MouseEvent e){
        UserView.clearFrame(window);
        mark = 0;
        explainFrame = 0;
        numEx = 0;
        new LoginController();
      }
    });

    JPanel notifPanel = new JPanel();
    UserView.addPanel(window, notifPanel, 700,23, notif.getIconWidth()+20, notif.getIconHeight(), 0x6B6257);
    UserView.addImage(notifPanel, notif, 0, 0);
    
    
    ArrayList<ArrayList<String>> notifData = new ArrayList<>();
    FileHandleController.convertNotif2d(notifData, FileHandleController.getID());
 
    if(notifData.size() != 0) {
        JLabel notifLbl = new JLabel("*");
        UserView.addLabel(panelMark, notifLbl, notif.getIconWidth()-15, 0, 30, 40, 40, "Roboto", 0xFF0000);
        notifPanel.add(notifLbl);
    }
    
    JLabel notifLblT = new JLabel("notification");
    notifPanel.addMouseListener(new MouseAdapter(){
      public void mouseEntered(MouseEvent e){
        UserView.addLabel(panelMark, notifLblT, 20, 0, 100, 40, 17, "Roboto", 0x000000);
        panelMark.repaint();
        panelMark.revalidate();
      }
      public void mouseExited(MouseEvent e){
        panelMark.remove(notifLblT);
        panelMark.repaint();
        panelMark.revalidate();
      }
      public void mouseClicked(MouseEvent e){
        mark = 4;
        UserView.clearFrame(window);
        new UserController();
      }
    });
    JPanel buttonPanel = new JPanel();
    UserView.addPanel(window, buttonPanel, 60, 150, 712, 50, 0x000000);
    buttonPanel.setOpaque(false);


    if(mark == 0 || mark == 1) {
    	recordButton.setEnabled(true);
      pendingButton.setEnabled(true);
    }
    recordButton.addMouseListener(this);
    pendingButton.addMouseListener(this);

    if(mark == 0 || mark == 4){
      UserView.addButton(buttonPanel, recordButton, 0, 1, 358, 49, 28, "Roboto", btnC, 0xD9D9D9);
      UserView.addButton(buttonPanel, pendingButton, 358, 1, 358, 49, 28, "Roboto", 0xD9D9D9, btnC);
    }else if(mark == 1 || mark == 4){
      UserView.addButton(buttonPanel, recordButton, 0, 1, 358, 49, 28, "Roboto", 0xD9D9D9, btnC);
      UserView.addButton(buttonPanel, pendingButton, 358, 1, 358, 49, 28, "Roboto", btnC, 0xD9D9D9);
    }
 
    if(mark == 0 || mark == 4){
      JPanel recordPanel = new JPanel();
      UserView.addPanel(window, recordPanel, 65, 205, 700, 380, 0xD9D9D9);

      try{
        FileHandleController.getID();
        FileHandleController.userOffenses(userOffense, FileHandleController.getID());

        // System.out.print(userOffense);
        if(userOffense.size() == 0){
          JLabel warnEmpty = new JLabel("NO RECORD");
          UserView.addLabel(recordPanel, warnEmpty, 0, 190, 700, 30, 35, "Roboto", 0x000000);
        }else{
          int col = 0;
          int y = 20;
          offenses = new JLabel[userOffense.size()];
          JLabel[] filedNotFiled = new JLabel[userOffense.size()];
          JLabel[] severityLbl = new JLabel[userOffense.size()];

          if(explainFrame == 1 || explainFrame == 2){
              window.setLocation(510,20);
              JPanel appealPanel = new JPanel();
              UserView.addPanel(appealFrame, appealPanel, 0, 0, 500, 580, 0xD9D9D9);
              appealPanel.setOpaque(false);

              JLabel offLbl = new JLabel("Offense:");
              UserView.addLabel(appealPanel, offLbl, 10, 10, 450, 40, 28, "Roboto", 0x000000);
              JLabel offDLbl = new JLabel(userOffense.get(numEx).get(0));
              UserView.addLabel(appealPanel, offDLbl, 10, 50, 450, 40, 23, "Roboto", 0xF04545);

              JLabel comLbl = new JLabel("Date Committed:");
              UserView.addLabel(appealPanel, comLbl, 10, 110, 170, 30, 20, "Roboto");
              JLabel comDLbl = new JLabel(userOffense.get(numEx).get(3));
              UserView.addLabel(appealPanel, comDLbl, 180, 110, 170, 30, 20, "Roboto");

              JLabel repLbl = new JLabel("Date Reported:");
              UserView.addLabel(appealPanel, repLbl, 10, 150, 170, 30, 20, "Roboto");
              JLabel repDLbl = new JLabel(userOffense.get(numEx).get(4));
              UserView.addLabel(appealPanel, repDLbl, 180, 150, 170, 30, 20, "Roboto");

              JLabel repByLbl = new JLabel("Reported By:");
              UserView.addLabel(appealPanel, repByLbl, 10, 190, 170, 30, 20, "Roboto");
              JLabel repByDLbl = new JLabel(userOffense.get(numEx).get(5));
              UserView.addLabel(appealPanel, repByDLbl, 180, 190, 170, 30, 20, "Roboto");

              JLabel depLbl = new JLabel("Department:");
              UserView.addLabel(appealPanel, depLbl, 10, 230, 170, 30, 20, "Roboto");
              JLabel depDLbl = new JLabel(userOffense.get(numEx).get(6));
              UserView.addLabel(appealPanel, depDLbl, 180, 230, 170, 30, 20, "Roboto");

              appealBtn = new JButton("APPEAL");
              appealBtn.addMouseListener(this);

              explainBtn = new JButton("EXPLANATION");
              explainBtn.addMouseListener(this);

              if(explainFrame == 1){
                UserView.addButton(appealPanel, appealBtn, 10, 270, 225, 30, 20, "Roboto", 0xFFFFFF, 0x686363);
                UserView.addButton(appealPanel, explainBtn, 235, 270, 225, 30, 20, "Roboto", 0x686363, 0xFFFFFF);
              }else{
                UserView.addButton(appealPanel, appealBtn, 10, 270, 225, 30, 20, "Roboto", 0x686363, 0xFFFFFF);
                UserView.addButton(appealPanel, explainBtn, 235, 270, 225, 30, 20, "Roboto", 0xFFFFFF, 0x686363);
              }
              explainAppealField = new JTextArea(); 
              UserView.addTextArea(appealPanel, explainAppealField, 10, 300, 450, 110, "Roboto", 20);

              closeBtn = new JButton("CLOSE");
              UserView.addButton(appealPanel, closeBtn, 10, 410, 225, 30, 23, "Roboto", 0x9B5151, 0xFFFFFF);
              closeBtn.addMouseListener(this);

              submitBtn = new JButton("SUBMIT");
              UserView.addButton(appealPanel, submitBtn, 235, 410, 225, 30, 23, "Roboto", 0x63975E, 0x000000);
              submitBtn.addMouseListener(this);

            appealFrame.setVisible(true);
          }
          int index = 0;
          int not = 0;
          while(col != userOffense.size()){
        	    if(userOffense.get(col).get(8).equals(FileHandleController.getID())){
        	        offenses[index] = new JLabel(userOffense.get(col).get(0));
        	        UserView.addLabel(recordPanel, offenses[index], 20, y, 350, 30, 20, "Roboto", 0x000000);
        	        offenses[index].setBackground(Color.white);
        	        offenses[index].setOpaque(true);

        	        filedNotFiled[index] = new JLabel(userOffense.get(index).get(2));
        	        UserView.addLabel(recordPanel, filedNotFiled[index], 370, y, 150, 30, 18, "Roboto", 0x000000);
        	        if(userOffense.get(index).get(2).equals("NOT FILED")){
        	            filedNotFiled[index].setBackground(new Color(0xF04545));
        	            offenses[index].addMouseListener(this);
        	        } else {
        	            filedNotFiled[index].setBackground(new Color(0x45F060));
        	        }
        	        filedNotFiled[index].setOpaque(true);

        	        severityLbl[index] = new JLabel(userOffense.get(index).get(1));
        	        UserView.addLabel(recordPanel, severityLbl[index], 520, y, 150, 30, 18, "Roboto", 0x000000);
        	        severityLbl[index].setBackground(new Color(0xF04545));
        	        severityLbl[index].setOpaque(true);

        	        y+=35;
        	        index++;
        	    } else {
        	        ++not;
        	        if(not == userOffense.size()-1){
        	            JLabel warnEmpty = new JLabel("NO RECORD");
        	            UserView.addLabel(recordPanel, warnEmpty, 0, 190, 700, 30, 35, "Roboto", 0x000000);
        	        }
        	    }
        	    ++col;
        	}

        	// Set the preferred size of the panel
        	recordPanel.setPreferredSize(new Dimension(700, (userOffense.size() - not) * 40));

        	// Create the JScrollPane with the modified panel
        	JScrollPane scroll = new JScrollPane(recordPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        	scroll.setBounds(65, 205, 700, 380); // Set bounds for the scroll pane to match the panel
        	scroll.setBorder(null);
        	window.add(scroll);
         
          
        }
     }catch(Exception e){}

    }else{
    	try {
    	    JPanel pendingPanel = new JPanel();
    	    UserView.addPanel(window, pendingPanel, 65, 205, 700, 380, 0xD9D9D9);

    	    FileHandleController.covert2DArrayPending(pendingAppeal, FileHandleController.getID());
    	    if (pendingAppeal.size() == 0) {
    	        JLabel warnEmpty = new JLabel("NO PENDING");
    	        UserView.addLabel(pendingPanel, warnEmpty, 0, 190, 700, 30, 35, "Roboto", 0x000000);
    	    } else {
    	        int colN = 0;
    	        JLabel[] pendingL = new JLabel[pendingAppeal.size()];
    	        int y = 20;
    	        while (colN != pendingAppeal.size()) {
    	            pendingL[colN] = new JLabel(pendingAppeal.get(colN).get(1));
    	            UserView.addLabel(pendingPanel, pendingL[colN], 20, y, 650, 30, 20, "Roboto", 0x000000);
    	            pendingL[colN].setBackground(Color.white);
    	            pendingL[colN].setOpaque(true);
    	            y += 35;
    	            ++colN;
    	        }
    	    }
    	    pendingPanel.setPreferredSize(new Dimension(700, (pendingAppeal.size()) * 40));
    	    JScrollPane scroll = new JScrollPane(pendingPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    	    scroll.setBorder(null);
    	    scroll.setBounds(65, 205, 700, 380); // Set the bounds for the scroll pane
    	    window.add(scroll); // Add the scroll pane to the window
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
      }
      
      JPanel userPanel = new JPanel();
      UserView.addPanel(window, userPanel, 10,0, bgImg.getIconWidth(), bgImg.getIconHeight(), bgC);
      UserView.addImage(userPanel, bgImg, 0, 0);

      window.setVisible(true);
  }

  @Override
  public void mouseClicked(MouseEvent event){
      if(event.getSource() == recordButton){
        UserView.clearFrame(window);
        mark = 0;
        explainFrame = 0;
        new UserController();
      }
      if(event.getSource() == pendingButton){
        UserView.clearFrame(window);
        mark = 1;
        explainFrame = 0;
        new UserController();
      }
      if(mark == 0){
        int num = 0;
        while(num != userOffense.size()){
          if(event.getSource() == offenses[num]){
            UserView.clearFrame(window);
            explainFrame = 1;
            numEx = num;
            new UserController();
          }
          num++;
        }
      }
      if(event.getSource() == appealBtn){
        UserView.clearFrame(appealFrame);
        explainFrame = 1;
        new UserController();
      }
      if(event.getSource() == explainBtn){
        UserView.clearFrame(appealFrame);
        explainFrame = 2;
        new UserController();
      }
      if(event.getSource() == closeBtn){
        UserView.clearFrame(appealFrame);
        window.setLocationRelativeTo(null);
        explainFrame = 0;
        appealFrame.dispose();
        new UserController();
      }
      if(event.getSource() == submitBtn && !(explainAppealField.getText().equals(""))){
        UserView.clearFrame(appealFrame);
        window.setLocationRelativeTo(null);
        explainFrame = 0;
        appealFrame.dispose();
        FileHandleController.writePending(explainAppealField.getText(), FileHandleController.getID(), userOffense.get(numEx).get(7));
        userOffense.clear();
        new UserController();
      }
      if(event.getSource() == notifClose) {
    	  mark = 0;
    	  UserView.clearFrame(window);
    	  new UserController();
      }
      if(event.getSource() == notifClear) {
    	  mark = 4;
    	  FileHandleController.removeFromNotifFile(FileHandleController.getID());
    	  UserView.clearFrame(window);
    	  new UserController();
      }
  }
@Override
  public void mouseEntered(MouseEvent event){
      if(mark == 0){
        int num = 0;
        while(num != userOffense.size()){
          if(event.getSource() == offenses[num]){
            UserView.changeButton(offenses[num], "Roboto", 23, 0xFFFFFF);
              offenses[num].setBackground(new Color(0xA19595));
          }
          num++;
        }
      }
      if(event.getSource() == recordButton){
        if(mark == 1){
          UserView.changeButton(recordButton, "Roboto", 32, 0xFFFFFF);
          recordButton.setBackground(new Color(0xA19595));
        }
      }
      if(event.getSource() == pendingButton){
        if(mark == 0){
          UserView.changeButton(pendingButton, "Roboto", 32, 0xFFFFFF);
          pendingButton.setBackground(new Color(0xA19595));
        }
      }
  }
@Override
  public void mouseExited(MouseEvent event){
      if(mark == 0){
        int num = 0;
        while(num != userOffense.size()){
          if(event.getSource() == offenses[num]){
            UserView.changeButton(offenses[num], "Roboto", 20, 0x000000);
            offenses[num].setBackground(Color.white);
          }
          num++;
        }
      }
      if(event.getSource() == recordButton){
        if(mark == 1){
          UserView.changeButton(recordButton, "Roboto", 28, 0x626262);
          recordButton.setBackground(new Color(0xD9D9D9));
        }
      }
      if(event.getSource() == pendingButton){
        if(mark == 0){
           UserView.changeButton(pendingButton, "Roboto", 28, 0x626262);
           pendingButton.setBackground(new Color(0xD9D9D9));
        }
      }
  }
@Override
  public void mousePressed(MouseEvent event){
    
  }
@Override
  public void mouseReleased(MouseEvent event){
    
  }
}
