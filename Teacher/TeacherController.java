package offense.management.teacher;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import offense.management.component.Component;
import offense.management.filehandle.FileHandleController;
import offense.management.login.LoginController;

public class TeacherController extends Component implements MouseListener, ActionListener{
	//GLOBAL DECLARATION OF COMPONENTS
	  JLabel fileOffenseBtn, searchBtn, listBtn, logoutBtn, clearBtn, submitBtn;
	  JTextField commitTxt, reportTxt, reportByTxt, departmentTxt, IDTxt, searchUser;
	  JTextArea addOffenseTxt;
	  JCheckBox minorCB, majorCB, seriousCB, verySCB;
	  JButton allBtn, filterBtn, searchUserBtn;
	  JComboBox<String> sectionCombo, batchCombo;
	  
	  //DATA
	  ArrayList<String> pendingData;
	  ArrayList<ArrayList<String>> appealData;
	  
	  //CONTROL FLOW VARIABLES
		  static int mark = 0;
		  static int idCheck = 0;
		  static int allListMark = 0;
		  static int searchMark = 0;
		  static String severity = "MINOR";
		  static String offense = null;
		  static String commit = null;
		  static String report = null;
		  static String reportBy = null;
		  static String deparment = null;
		  static String searchData = null;
		  static String section = "1A";
		  static String batch = "30";
	
	//CONTRUCSTOR
	  public TeacherController(){
	    ImageIcon bgImg = new ImageIcon("Images//admin.png");
	    ImageIcon bgImg2 = new ImageIcon("Images//adminS.png");
	    
	    //Teacher label
		    JPanel teacherLblPnl = new JPanel();
		    TeacherView.addPanel(window, teacherLblPnl, 200, 0, 450, 100, 0xCCCCCC);
		    JLabel teacherLbl = new JLabel("TEACHER");
		    TeacherView.addLabel(teacherLblPnl, teacherLbl, 20, 20, 400, 50, 40, "Roboto", 0x000000);
	
	    JPanel optionPanel = new JPanel();
	    TeacherView.addPanel(window, optionPanel, 26,114, 211, 400, 0x797166);
	    optionPanel.setOpaque(false);
	
	    fileOffenseBtn = new JLabel("File Offense");
	    TeacherView.addLabel(optionPanel, fileOffenseBtn, 0, 50, 211, 40, 22, "Roboto", 0xE8E8E8);
	    fileOffenseBtn.addMouseListener(this);
	
	    searchBtn = new JLabel("Search");
	    TeacherView.addLabel(optionPanel, searchBtn, 0, 120, 211, 40, 22, "Roboto", 0xE8E8E8);
	    searchBtn.addMouseListener(this);
	
	    listBtn = new JLabel("List");
	    TeacherView.addLabel(optionPanel, listBtn, 0, 190, 211, 40, 22, "Roboto", 0xE8E8E8);
	    listBtn.addMouseListener(this);
	
	      if(mark == 0){
	        TeacherView.addLabel(optionPanel, fileOffenseBtn, 0, 50, 211, 60, 28, "Roboto", 0xFFFFFF);
	        fileOffenseBtn.setBackground(new Color(0x6B6257));
	        fileOffenseBtn.setOpaque(true);
	      }else if(mark == 1){
	        TeacherView.addLabel(optionPanel, searchBtn, 0, 110, 211, 60, 28, "Roboto", 0xFFFFFF);
	        searchBtn.setBackground(new Color(0x6B6257));
	        searchBtn.setOpaque(true);
	      }else{
	        TeacherView.addLabel(optionPanel, listBtn, 0, 180, 211, 60, 28, "Roboto", 0xFFFFFF);
	        listBtn.setBackground(new Color(0x6B6257));
	        listBtn.setOpaque(true);
	      }
	
	    JPanel logutPanel = new JPanel();
	    TeacherView.addPanel(window, logutPanel, 26,520, 211, 80, 0x626262);
	    logutPanel.setOpaque(false);
	
	    logoutBtn = new JLabel("LOGOUT");
	    TeacherView.addLabel(logutPanel, logoutBtn, 30, 20, 150, 40, 22, "Roboto", 0xE8E8E8);
	    logoutBtn.addMouseListener(this);
	
	    if(mark == 0){
	      section = "1A";
		  batch = "30";
	      JPanel displayPanel = new JPanel();
	      TeacherView.addPanel(window, displayPanel, 249,114, 551, 440, 0xE8E8E8);
	      displayPanel.setOpaque(false);
	
	        addOffenseTxt = new JTextArea();
	        TeacherView.addTextArea(displayPanel, addOffenseTxt, 20, 45, 500, 90, "Roboto", 20);
	
	        minorCB = new JCheckBox();
	        TeacherView.addCheckBox(displayPanel, minorCB, 25, 182, 30, 30);
	        minorCB.addItemListener(new ItemListener(){
	          public void itemStateChanged(ItemEvent e){
	            if(e.getStateChange() == ItemEvent.SELECTED){
	              severity = "MINOR";
	              majorCB.setSelected(false);
	              seriousCB.setSelected(false);
	              verySCB.setSelected(false);
	            }
	          }
	        });
	
	        majorCB = new JCheckBox();
	        TeacherView.addCheckBox(displayPanel, majorCB, 25, 218, 30, 30);
	        majorCB.addItemListener(new ItemListener(){
	          public void itemStateChanged(ItemEvent e){
	            if(e.getStateChange() == ItemEvent.SELECTED){
	              severity = "MAJOR";
	              minorCB.setSelected(false);
	              seriousCB.setSelected(false);
	              verySCB.setSelected(false);
	            }
	          }
	        });
	
	        seriousCB = new JCheckBox();
	        TeacherView.addCheckBox(displayPanel, seriousCB, 260, 182, 30, 30);
	        seriousCB.addItemListener(new ItemListener(){
	          public void itemStateChanged(ItemEvent e){
	            if(e.getStateChange() == ItemEvent.SELECTED){
	              severity = "SERIOUS";
	              minorCB.setSelected(false);
	              majorCB.setSelected(false);
	              verySCB.setSelected(false);
	            }
	          }
	        });

	        verySCB = new JCheckBox();
	        TeacherView.addCheckBox(displayPanel, verySCB, 260, 218, 30, 30);
	        verySCB.addItemListener(new ItemListener(){
	          public void itemStateChanged(ItemEvent e){
	            if(e.getStateChange() == ItemEvent.SELECTED){
	              severity = "VERY SERIOUS";
	              minorCB.setSelected(false);
	              majorCB.setSelected(false);
	              seriousCB.setSelected(false);
	            }
	          }
	        });
	
	        commitTxt = new JTextField();
	        TeacherView.addTextField(displayPanel, commitTxt, 235, 262, 230, 30, "Roboto", 18, " MM/DD/YY");
	        commitTxt.addMouseListener(this);
	
	        reportTxt = new JTextField();
	        TeacherView.addTextField(displayPanel, reportTxt, 235, 297, 230, 30, "Roboto", 18, " MM/DD/YY");
	        reportTxt.addMouseListener(this);
	
	        reportByTxt = new JTextField();
	        TeacherView.addTextField(displayPanel, reportByTxt, 235, 332, 230, 30, "Roboto", 18);
	
	        departmentTxt = new JTextField();
	        TeacherView.addTextField(displayPanel, departmentTxt, 235, 367, 230, 30, "Roboto", 18);
	
	        IDTxt = new JTextField();
	        TeacherView.addTextField(displayPanel, IDTxt, 175, 402, 150, 30, "Roboto", 18);
	        
	        JLabel warnId;
	        if(idCheck == 1 || idCheck == 2){
	          if(idCheck == 1){warnId = new JLabel("ID does not Exist!!!");}
	          else{warnId = new JLabel("Fill the blank");}
	          TeacherView.addLabel(displayPanel, warnId, 330, 402, 180, 30, 18, "Roboto", 0xFD0000);
	          addOffenseTxt.setText(offense);
	          commitTxt.setText(commit);
	          reportTxt.setText(report);
	          reportByTxt.setText(reportBy);
	          departmentTxt.setText(deparment);
	        }else if(idCheck == 3){
	          warnId = new JLabel("FILED");
	          TeacherView.addLabel(displayPanel, warnId, 330, 402, 100, 30, 25, "Roboto", 0x14FF00);
	        }
	        

	      JPanel cancelSubmitPanel = new JPanel();
	      TeacherView.addPanel(window, cancelSubmitPanel, 249, 555, 551, 50, 0x626262);
	      cancelSubmitPanel.setOpaque(false);
	
	        submitBtn = new JLabel("SUBMIT");
	        TeacherView.addLabel(cancelSubmitPanel, submitBtn, 300, 5, 150, 40, 18, "Roboto", 0xE8E8E8);
	        submitBtn.addMouseListener(this);
	    
	        clearBtn = new JLabel("CLEAR");
	        TeacherView.addLabel(cancelSubmitPanel, clearBtn, 91, 5, 150, 40, 18, "Roboto", 0xE8E8E8);
	        clearBtn.addMouseListener(this);
	        
	    }
	    else if(mark == 1){
	    	section = "1A";
			batch = "30";
			  
	    	JPanel allListPnl = new JPanel();
	    	TeacherView.addPanel(window, allListPnl, 245, 115, 555, 485, 0xE8E8E8);
	    	
	    	searchUser = new JTextField();
	    	TeacherView.addTextField(allListPnl, searchUser, 10, 30, 435, 40, "Roboto", 20);
	    	
	    	searchUserBtn = new JButton("SEARCH");
	    	TeacherView.addButton(allListPnl, searchUserBtn, 445, 30, 100, 40, 20, "Roboto", btnC, 0x000000);
	    	searchUserBtn.addMouseListener(this);
	    	
	    	JPanel panelSearch = new JPanel();
	    	panelSearch.setLayout(null);
	    	panelSearch.setOpaque(false);
	    	
	    	if(searchMark == 1) {
	    		int nameY = 10;
	    		int sectionY = 30;
	    		int batchY = 50;
	    		
	    		ArrayList<ArrayList<String>> data = new ArrayList<>();
	    		
	    		FileHandleController.convertUserDataFromFileToArray(data);
	    		
	    		int countIncrement = 0;
	    		int numberExist = 0;
	    		while(countIncrement != data.size()) {
	    			if(searchData.equals(data.get(countIncrement).get(0)) || 
	    					searchData.equals(data.get(countIncrement).get(1)) || 
	    					searchData.equals(data.get(countIncrement).get(4)) || 
	    					searchData.equals(data.get(countIncrement).get(0) + " " + 
	    					searchData.equals(data.get(countIncrement).get(1)))) {
	    				JLabel userName = new JLabel("Name: " + data.get(countIncrement).get(0) + " " + data.get(countIncrement).get(1));
			    		TeacherView.addLabel(panelSearch, userName, 10, nameY, 495, 20, 18, "Roboto", 0x000000, 0x444444);
			    		
			    		JLabel userSection = new JLabel("Section: " + data.get(countIncrement).get(5));
			    		TeacherView.addLabel(panelSearch, userSection, 10, sectionY, 495, 20, 18, "Roboto", 0x000000, 0x444444);
			    		
			    		JLabel userBatch = new JLabel("Batch: " + data.get(countIncrement).get(6));
			    		TeacherView.addLabel(panelSearch, userBatch, 10, batchY, 495, 20, 18, "Roboto", 0x000000, 0x444444);
			    		nameY += 80;
			    		sectionY += 80;
			    		batchY += 80;
			    		numberExist++;
	    			}
	    			countIncrement++;
	    		}
	    		if(numberExist == 0) {
	    			JLabel noSearchExist = new JLabel("NO USER EXIST");
	    			TeacherView.addLabel(panelSearch, noSearchExist, 0, 150, 535, 60, 30, "Roboto", 0xFF0000);
	    		}
	    		
	    		panelSearch.setPreferredSize(new Dimension(535, (numberExist * 90)));
	    		
		    	JScrollPane scroll = new JScrollPane(panelSearch, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		    	scroll.setBounds(10, 80, 535, 390); // Set bounds for the scroll pane to match the panel
		    	scroll.setBorder(null);
		    	scroll.setBackground(new Color(0xBEBEBE));
		    	allListPnl.add(scroll);
	    	}
	    }
	    else if(mark == 2){
	    	JPanel allListPnl = new JPanel();
	    	TeacherView.addPanel(window, allListPnl, 245, 115, 555, 485, 0xE8E8E8);
	    	
	    	allBtn = new JButton("ALL");
	    	allBtn.addMouseListener(this);
	    	
	    	filterBtn = new JButton("FILTER");
	    	filterBtn.addMouseListener(this);
	    	
	    	JPanel allListPnlContent = new JPanel();
	    	allListPnlContent.setLayout(null);
	    	allListPnlContent.setOpaque(false);
	    	
	    	if(allListMark == 0) {
	    		section = "1A";
	    		batch = "30";	
	    		
	    		TeacherView.addButton(allListPnl, allBtn, 20, 20, 100, 40, 20, "Roboto", 0xFFFFFF, 0x000000);
	    		TeacherView.addButton(allListPnl, filterBtn, 120, 20, 100, 40, 20, "Roboto", btnC, 0xFFFFFF);
	    		int nameY = 10;
	    		int sectionY = 30;
	    		int batchY = 50;
	    		
	    		ArrayList<ArrayList<String>> data = new ArrayList<>();
	    		
	    		FileHandleController.convertUserDataFromFileToArray(data);
	    		
	    		int countIncrement = 0;
	    		while(countIncrement != data.size()) {
	    			JLabel userName = new JLabel("Name: " + data.get(countIncrement).get(0) + " " + data.get(countIncrement).get(1));
		    		TeacherView.addLabel(allListPnlContent, userName, 10, nameY, 495, 20, 18, "Roboto", 0x000000, 0x444444);
		    		
		    		JLabel userSection = new JLabel("Section: " + data.get(countIncrement).get(5));
		    		TeacherView.addLabel(allListPnlContent, userSection, 10, sectionY, 495, 20, 18, "Roboto", 0x000000, 0x444444);
		    		
		    		JLabel userBatch = new JLabel("Batch: " + data.get(countIncrement).get(6));
		    		TeacherView.addLabel(allListPnlContent, userBatch, 10, batchY, 495, 20, 18, "Roboto", 0x000000, 0x444444);
		    		nameY += 80;
		    		sectionY += 80;
		    		batchY += 80;
		    		countIncrement++;
	    		}
	    		
	    		allListPnlContent.setPreferredSize(new Dimension(515, (data.size() * 90)));
	    		
		    	JScrollPane scroll = new JScrollPane(allListPnlContent, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		    	scroll.setBounds(20, 60, 515, 400); // Set bounds for the scroll pane to match the panel
		    	scroll.setBorder(null);
		    	scroll.setBackground(new Color(0xBEBEBE));
		    	allListPnl.add(scroll);
	    	}else {
	    		TeacherView.addButton(allListPnl, allBtn, 20, 20, 100, 40, 20, "Roboto", btnC, 0xFFFFFF);
	    		TeacherView.addButton(allListPnl, filterBtn, 120, 20, 100, 40, 20, "Roboto", 0xFFFFFF, 0x000000);
	    		
	    		ArrayList<ArrayList<String>> data = new ArrayList<>();
	    		
	    		FileHandleController.convertUserDataFromFileToArray(data);
	    		
	    		String[] sectionData = {"Section 1A", "Section 1B", "Section 1C", "Section 1D", "Section 1E", "Section 1F",
	    								"Section 2A", "Section 2B", "Section 2C", "Section 2D", "Section 2E", "Section 2F",
	    								"Section 3A", "Section 3B", "Section 3C", "Section 3D", "Section 3E", "Section 3F",};
	    		sectionCombo = new JComboBox<>(sectionData);
	    		TeacherView.addComboBox(allListPnl, sectionCombo, 280, 20, 130, 40);
	    		sectionCombo.setSelectedItem("Section " + section);
	    		sectionCombo.addActionListener(this);
	    		
	    		String[] batchData = {"Batch 30", "Batch 31", "Batch 32", "Batch 33", "Batch 34", "Batch 35"};
	    		batchCombo = new JComboBox<>(batchData);
	    		TeacherView.addComboBox(allListPnl, batchCombo, 410, 20, 120, 40);
	    		batchCombo.setSelectedItem("Batch " + batch);
	    		batchCombo.addActionListener(this);
	    		
	    		int countIncrement = 0;
	    		int numberExist = 0;
	    		
	    		int nameY = 10;
	    		int sectionY = 30;
	    		int batchY = 50;
	    		
	    		while(countIncrement != data.size()) {
	    			if(section.equals(data.get(countIncrement).get(5)) && batch.equals(data.get(countIncrement).get(6))){
	    				
	    				JLabel userName = new JLabel("Name: " + data.get(countIncrement).get(0) + " " + data.get(countIncrement).get(1));
			    		TeacherView.addLabel(allListPnlContent, userName, 10, nameY, 495, 20, 18, "Roboto", 0x000000, 0x444444);
			    		
			    		JLabel userSection = new JLabel("Section: " + data.get(countIncrement).get(5));
			    		TeacherView.addLabel(allListPnlContent, userSection, 10, sectionY, 495, 20, 18, "Roboto", 0x000000, 0x444444);
			    		
			    		JLabel userBatch = new JLabel("Batch: " + data.get(countIncrement).get(6));
			    		TeacherView.addLabel(allListPnlContent, userBatch, 10, batchY, 495, 20, 18, "Roboto", 0x000000, 0x444444);
			    		nameY += 80;
			    		sectionY += 80;
			    		batchY += 80;
			    		numberExist++;
	    			}
	    			countIncrement++;
	    		}
	    		if(numberExist == 0) {
	    			JLabel noSearchExist = new JLabel("NO USER EXIST");
	    			TeacherView.addLabel(allListPnlContent, noSearchExist, 0, 150, 535, 60, 30, "Roboto", 0xFF0000);
	    		}
	    		
	    		allListPnlContent.setPreferredSize(new Dimension(535, (numberExist * 100)));
	    		
		    	JScrollPane scroll = new JScrollPane(allListPnlContent, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		    	scroll.setBounds(10, 80, 535, 390); // Set bounds for the scroll pane to match the panel
		    	scroll.setBorder(null);
		    	scroll.setBackground(new Color(0xBEBEBE));
		    	allListPnl.add(scroll);
	    		
	    	}
	    }
	
	    JPanel teacherPanel = new JPanel();
	      if(mark == 0){
	        TeacherView.addPanel(window, teacherPanel, 10,0, bgImg.getIconWidth(), bgImg.getIconHeight(), 0xCCCCCC);
	        TeacherView.addImage(teacherPanel, bgImg, 0, 0);
	      }else{
	        TeacherView.addPanel(window, teacherPanel, 10,0, bgImg2.getIconWidth(), bgImg2.getIconHeight(), 0xCCCCCC);
	        TeacherView.addImage(teacherPanel, bgImg2, 0, 0);
	      }
	
	    window.setVisible(true);
}

	  @Override
	  public void actionPerformed(ActionEvent event){
	      if(event.getSource() == sectionCombo) {
	    	  section = sectionCombo.getSelectedItem() + "";
	    	  section = section.substring(8);
	    	  TeacherView.clearFrame(window);
	    	  mark = 2;
	    	  allListMark = 1;
	    	  
	    	  new TeacherController();
	      }
		  if(event.getSource() == batchCombo) {
			  batch = batchCombo.getSelectedItem() + "";
			  batch = batch.substring(6);
			  TeacherView.clearFrame(window);
			  mark = 2;
			  allListMark = 1;
			  
			  new TeacherController();
	      }
	  }
	  @Override
	  public void mouseClicked(MouseEvent event){
	      if(event.getSource() == fileOffenseBtn){
	        TeacherView.clearFrame(window);
	        mark = 0;
	        idCheck = 0;
	        searchMark = 0;
	        allListMark = 0;
	        new TeacherController();
	      }
	      if(event.getSource() == searchBtn){
	    	  TeacherView.clearFrame(window);
	          mark = 1;
	          searchMark = 0;
	          allListMark = 0;
	          new TeacherController();
	        }
	        if(event.getSource() == listBtn){
	          TeacherView.clearFrame(window);
	          mark = 2;
	          searchMark = 0;
	          allListMark = 0;
	          new TeacherController();
	        }
	      if(event.getSource() == logoutBtn){
	        TeacherView.clearFrame(window);
	        mark = 0;
	        idCheck = 0;
	        searchMark = 0;
	        section = "1A";
			batch = "30";
	        new LoginController();
	      }
	      if(event.getSource() == clearBtn){
	        TeacherView.clearFrame(window);
	        mark = 0;
	        offense = null;
	        commit = null;
	        report = null;
	        reportBy = null;
	        deparment = null;
	        new TeacherController();
	      }
	      if(event.getSource() == submitBtn){
	        TeacherView.clearFrame(window);
	        if(addOffenseTxt.getText().isEmpty() || commitTxt.getText().isEmpty() ||  reportTxt.getText().isEmpty() ||  reportByTxt.getText().isEmpty() ||  departmentTxt.getText().isEmpty() ||  IDTxt.getText().isEmpty()){
	          idCheck = 2;
	        }else{
	          mark = 0;
	          int checkId = FileHandleController.addOffenseToUser(addOffenseTxt.getText(), severity, commitTxt.getText(), reportTxt.getText(), reportByTxt.getText(), departmentTxt.getText(), IDTxt.getText());
	          if(checkId == 0){
	            idCheck = 1;
	          }else{idCheck = 3;}
	        }
	        offense = addOffenseTxt.getText();
	        commit = commitTxt.getText();
	        report = reportTxt.getText();
	        reportBy = reportByTxt.getText();
	        deparment = departmentTxt.getText();
	        new TeacherController();
	      }
	      if(event.getSource() == commitTxt){
	        if(commitTxt.getText().equals(" MM/DD/YY") || commitTxt.getText().isEmpty()){
	           commitTxt.setText(null);
	           commitTxt.setForeground(Color.black);
	        }
	      }
	      if(event.getSource() == reportTxt){
	       if(reportTxt.getText().equals(" MM/DD/YY") || reportTxt.getText().isEmpty()){
	           reportTxt.setText(null);
	           reportTxt.setForeground(Color.black);
	        }
	      }
	      if(event.getSource() == allBtn) {
	    	  allListMark = 0;
	    	  mark = 2;
	    	  TeacherView.clearFrame(window);
	    	  new TeacherController();
	      }
	      if(event.getSource() == filterBtn) {
	    	  allListMark = 1;
	    	  mark = 2;
	    	  TeacherView.clearFrame(window);
	    	  new TeacherController();
	      }
	      if(event.getSource() == searchUserBtn) {
	    	  searchData = searchUser.getText();
	    	  searchMark = 1;
	    	  mark = 1;
	    	  TeacherView.clearFrame(window);
	    	  new TeacherController();  
;	      }
	  }
	@Override
	  public void mouseEntered(MouseEvent event){
	    if(event.getSource() == fileOffenseBtn){
	        if(mark == 1 || mark == 2){
	          idCheck = 0;
	          TeacherView.changeButton(fileOffenseBtn, "Roboto", 25, 0x000000);
	        }
	      }
	    if(event.getSource() == searchBtn){
	        if(mark == 0 || mark == 2){
	        	TeacherView.changeButton(searchBtn, "Roboto", 25, 0x000000);
	         }
	       }
	     if(event.getSource() == listBtn){
	          if(mark == 0 || mark == 1){
	        	TeacherView.changeButton(listBtn, "Roboto", 25, 0x000000);
	         }
	       }
	     
	    if(event.getSource() == logoutBtn){
	        TeacherView.changeButton(logoutBtn, "Roboto", 25, 0xFD0000);
	      }
	    if(event.getSource() == submitBtn){
	        TeacherView.changeButton(submitBtn, "Roboto", 19, 0x00FF47);
	      }
	    if(event.getSource() == clearBtn){
	        TeacherView.changeButton(clearBtn, "Roboto", 19, 0xFF0000);
	      }
	  }
	@Override
	  public void mouseExited(MouseEvent event){
	    if(event.getSource() == fileOffenseBtn){
	        if(mark == 1 || mark == 2){
	          TeacherView.changeButton(fileOffenseBtn, "Roboto", 22, 0xE8E8E8);
	        }
	      }
	    if(event.getSource() == searchBtn){
	        if(mark == 0 || mark == 2){
	        	TeacherView.changeButton(searchBtn, "Roboto", 22, 0xE8E8E8);
	         }
	       }
	     if(event.getSource() == listBtn){
	          if(mark == 0 || mark == 1){
	        	TeacherView.changeButton(listBtn, "Roboto", 22, 0xE8E8E8);
	         }
	       }
	    if(event.getSource() == logoutBtn){
	        TeacherView.changeButton(logoutBtn, "Roboto", 22, 0xE8E8E8);
	      }
	    if(event.getSource() == submitBtn){
	        TeacherView.changeButton(submitBtn, "Roboto", 18, 0xE8E8E8);
	      }
	    if(event.getSource() == clearBtn){
	        TeacherView.changeButton(clearBtn, "Roboto", 18, 0xE8E8E8);
	      }
	  }
	@Override
	  public void mousePressed(MouseEvent event){
	    
	  }
	@Override
	  public void mouseReleased(MouseEvent event){
	    
	  }
	  
	
	
}
