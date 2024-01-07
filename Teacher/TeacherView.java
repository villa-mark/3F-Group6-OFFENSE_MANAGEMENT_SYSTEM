package offense.management.teacher;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;


class TeacherView {
	
	
	/*********************************************************************************
	 * ADD_LABEL METHODS
	 	  - allows to modify LABEL component instantly 
	 	  
	 @param JPanel panel	- A JPanel object where to add the label component
	 @param JLabel label	- the JLabel object to be modified
	 @param int x			- the integer value to what x-axis the label should be placed
	 @param int y 			- the integer value to what y-axis the label should be placed
	 @param int width		- the integer value of the label width
	 @param int height 		- the integer value of the label height
	 @param int fontSize	- the integer value of the font size
	 @param String fontStyle- the font style
	 @param int color 		- the integer value of the color
	 
	 BY DEFAULT:
	 	* the BACKGROUND is set to NULL
	 	* the TEXT is BOLD
	 	* the TEXT is CENTERED
	 *********************************************************************************/
		static void addLabel(JPanel panel, JLabel label, int x, int y, int width, int height, int fontSize, String fontStyle, int color){
		    label.setBounds(x, y, width, height);
		    label.setBackground(null);
		    label.setForeground(new Color(color));
		    label.setFont(new Font(fontStyle, Font.BOLD, fontSize));
		    label.setHorizontalAlignment(JLabel.CENTER);
		
		    panel.add(label);
		}
		
		
		
		
	/*********************************************************************************
	 * ADD_LABEL METHODS
	 	  - allows to modify LABEL component instantly 
	 	  
	 @param JPanel panel	- A JPanel object where to add the label component
	 @param JLabel label	- the JLabel object to be modified
	 @param int x			- the integer value to what x-axis the label should be placed
	 @param int y 			- the integer value to what y-axis the label should be placed
	 @param int width		- the integer value of the label width
	 @param int height 		- the integer value of the label height
	 @param int fontSize	- the integer value of the font size
	 @param String fontStyle- the font style
	 @param int color 		- the integer value of the color
	 
	 BY DEFAULT:
	 	* the BACKGROUND is set to NULL
	 	* the TEXT is BOLD
	 	* the TEXT is CENTERED
	 *********************************************************************************/
		static void addLabel(JPanel panel, JLabel label, int x, int y, int width, int height, int fontSize, String fontStyle, int color, int bgColor){
		    label.setBounds(x, y, width, height);
		    label.setBackground(new Color(bgColor));
		    label.setForeground(new Color(color));
		    label.setFont(new Font(fontStyle, Font.BOLD, fontSize));
		    label.setHorizontalAlignment(JLabel.LEFT);
		
		    panel.add(label);
		}
			
			
			
			
 	/*********************************************************************************
 	 * ADD_BUTTON METHODS
 	 	  - allows to modify/change BUTTON component instantly 
 	 	  
 	 @param JPanel panel	- A JPanel object where to add the button component
 	 @param JButton button	- the JButton object to be modified
 	 @param int x			- the integer value to what x-axis the panel should be placed
 	 @param int y 			- the integer value to what y-axis the panel should be placed
 	 @param int width		- the integer value of the panel width
 	 @param int height 		- the integer value of the panel height
 	 @param int fontSize	- the integer value of the font size
 	 @param String fontStyle- the font style
 	 @param int color 		- the integer value of the color
 	 @param int foreColor 	- the integer value of the foreground color
 	 
 	 BY DEFAULT:
 	 	* the TEXT is BOLD
 	 	* the BORDER is NULL
 	 *********************************************************************************/
		  static void addButton(JPanel panel, JButton button, int x, int y, int width, int height, int fontSize, String fontStyle, int color, int foreColor){
		    button.setBounds(x, y, width, height);
		    button.setFont(new Font(fontStyle, Font.BOLD, fontSize));
		    button.setBackground(new Color(color));
		    button.setForeground(new Color(foreColor));
		    button.setBorder(null);
		    button.setFocusable(false);
		
		    panel.add(button);
		  }
	  
		  
		  
	  
	 /*********************************************************************************
		 * ADD_TEXTFIELD METHODS  --> method overloading
		 	  - allows to modify TEXTFIELD component instantly 
		 	  
		 @param JPanel panel			- A JPanel object where to add the textfield component
		 @param JTextField textField	- the JTextField object to be modified
		 @param int x					- the integer value to what x-axis the textfield should be placed
		 @param int y 					- the integer value to what y-axis the textfield should be placed
		 @param int width				- the integer value of the textfield width
		 @param int height 				- the integer value of the textfield height
		 @param String fontStyle		- the font style
		 @param int fontSize			- the integer value of the font size
		 
		 BY DEFAULT:
		 	* the BORDER is NULL
		 	* the TEXT is PLAIN
	 *********************************************************************************/
		  static void addTextField(JPanel panel, JTextField textField, int x, int y, int width, int height, String fontStyle, int fontSize){
		      textField.setBounds(x, y, width, height);
		      textField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
		      textField.setBorder(null);
		    
		      panel.add(textField); 
		  }  
	  
	  
		  
		  
	 /*********************************************************************************
	 * ADD_TEXTFIELD METHODS  --> method overloading
	 	  - allows to modify TEXTFIELD component instantly 
	 	  
	 @param JPanel panel			- A JPanel object where to add the textfield component
	 @param JTextField textField	- the JTextField object to be modified
	 @param int x					- the integer value to what x-axis the textfield should be placed
	 @param int y 					- the integer value to what y-axis the textfield should be placed
	 @param int width				- the integer value of the textfield width
	 @param int height 				- the integer value of the textfield height
	 @param String fontStyle		- the font style
	 @param int fontSize			- the integer value of the font size
	 @param Strinf text				- the text to be displayed in the textfield
	 
	 BY DEFAULT:
	 	* the BORDER is NULL
	 	* the TEXT is PLAIN
	 	* the FOREGROUND color is set to 0x838383
	 *********************************************************************************/
		  static void addTextField(JPanel panel, JTextField textField, int x, int y, int width, int height, String fontStyle, int fontSize, String text){
		      textField.setBounds(x, y, width, height);
		      textField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
		      textField.setBorder(null);
		      textField.setText(text);
		      textField.setForeground(new Color(0x838383));
		    
		      panel.add(textField); 
		  }  
		  
		  
		  
		  
	 /*********************************************************************************
	 * ADD_TEXTAREA METHODS
	 	  - allows to modify TEXTAREA component instantly 
	 	  
	 @param JPanel panel			- A JPanel object where to add the textfield component
	 @param JTextArea textField		- the JTextArea object to be modified
	 @param int x					- the integer value to what x-axis the textfield should be placed
	 @param int y 					- the integer value to what y-axis the textfield should be placed
	 @param int width				- the integer value of the textfield width
	 @param int height 				- the integer value of the textfield height
	 @param String fontStyle		- the font style
	 @param int fontSize			- the integer value of the font size
	 
	 BY DEFAULT:
	 	* the TEXT is PLAIN
	 	* LINEWRAP is set to TRUE
	 	* WRAPSTYLEWORD is set to TRUE
	 *********************************************************************************/
	    static void addTextArea(JPanel panel, JTextArea textField, int x, int y, int width, int height, String fontStyle, int fontSize){
	    	textField.setBounds(0, 0, width, height);  // Set the bounds of the text area relative to the scroll pane
	        textField.setBackground(Color.WHITE);
	        textField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
	        textField.setLineWrap(true);
	        textField.setWrapStyleWord(true);

	        JScrollPane scroll = new JScrollPane(textField);
	        scroll.setBounds(x, y, width, height);  // Set the bounds of the scroll pane within the panel
	        scroll.setBorder(null);
	        
	        panel.add(scroll);
	    }  
	
	      
	      
	      
     /*********************************************************************************
  	 * ADD_CHECKBOX METHODS  
  	 	  - allows to modify CHECKBOX component instantly 
  	 	  
  	 @param JPanel panel			- A JPanel object where to add the textfield component
  	 @param JTextField textField	- the JTextField object to be modified
  	 @param int x					- the integer value to what x-axis the textfield should be placed
  	 @param int y 					- the integer value to what y-axis the textfield should be placed
  	 @param int width				- the integer value of the textfield width
  	 @param int height 				- the integer value of the textfield height
  	 @param String fontStyle		- the font style
  	 @param int fontSize			- the integer value of the font size
  	 @param Strinf text				- the text to be displayed in the textfield
  	 
  	 BY DEFAULT:
  	 	* the BORDER is NULL
  	 	* the TEXT is PLAIN
  	 	* the FOREGROUND color is set to 0x838383
  	 *********************************************************************************/
	    static void addCheckBox(JPanel panel, JCheckBox checkBox, int x, int y, int width, int height){
	      checkBox.setBounds(x, y, width, height);
	      checkBox.setBackground(null);
	
	      panel.add(checkBox);
	    }
	
	    
	    
	    
    /*********************************************************************************
 	 * ADD_PANEL METHODS
 	 	  - allows to modify PANEL component instantly 
 	 	  
 	 @param JFrame frame	- A JFrame object where to add the panel component
 	 @param JPanel panel	- the JPanel object to be modified
 	 @param int x			- the integer value to what x-axis the panel should be placed
 	 @param int y 			- the integer value to what y-axis the panel should be placed
 	 @param int width		- the integer value of the panel width
 	 @param int height 		- the integer value of the panel height
 	 @param int color		- the integer value of panel color
 	 
 	 BY DEFAULT:
 	 	* the OPACITY is set to TRUE
 	 	* the LAYOUT manager is NULL
 	 *********************************************************************************/
	    static void addPanel(JFrame frame, JPanel panel, int x, int y, int width, int height, int color){
	      panel.setBounds(x, y, width, height);
	      panel.setOpaque(true);
	      panel.setBackground(new Color(color));
	      panel.setLayout(null);  
	
	      frame.add(panel);
	    }
	    
	    
	    
	    
    /*********************************************************************************
 	 * ADD_PANEL METHODS
 	 	  - allows to modify PANEL component instantly 
 	 	  
 	 @param JFrame frame	- A JFrame object where to add the panel component
 	 @param JPanel panel	- the JPanel object to be modified
 	 @param int x			- the integer value to what x-axis the panel should be placed
 	 @param int y 			- the integer value to what y-axis the panel should be placed
 	 @param int width		- the integer value of the panel width
 	 @param int height 		- the integer value of the panel height
 	 @param int color		- the integer value of panel color
 	 
 	 BY DEFAULT:
 	 	* the OPACITY is set to TRUE
 	 	* the LAYOUT manager is NULL
 	 *********************************************************************************/
	    static void addPanel(JPanel panelAbove, JPanel panel, int x, int y, int width, int height, int color){
	      panel.setBounds(x, y, width, height);
	      panel.setOpaque(true);
	      panel.setBackground(new Color(color));
	      panel.setLayout(null);  
	
	      panelAbove.add(panel);
	    }
		    
	    
	    
	    
    /*********************************************************************************
	 * ADD_IMAGE METHODS
	 	  - add IMAGE to a panel
	 	  
	 @param JPanel panel	- the JPanel object where to the add JLabel obj
	 @param ImageIcon img	- the ImageIcon object to be added
	 @param int x			- the integer value to what x-axis the panel should be placed
	 @param int y 			- the integer value to what y-axis the panel should be placed
	 
	 BY DEFAULT:
	 	* the label width and height would base to the image width and height
	 *********************************************************************************/
	    static void addImage(JPanel panel, ImageIcon img, int x, int y){
	      JLabel label = new JLabel(img);
	      label.setBounds(x, y, img.getIconWidth(), img.getIconHeight());
	      panel.add(label);
	    }
	    
	    
	    
	    
    /*********************************************************************************
  	 * CLEAR_FRAME METHODS
  	 	  - Clear all the frame contents and repaint it
  	 	  
  	 @param JFrame frame	- A JFrame object to be cleaned
  	 *********************************************************************************/
	    static void clearFrame(JFrame frame){
	      frame.getContentPane().removeAll();
	      frame.repaint();
	      frame.validate();
	    }
	
	    
	    
	    
    /*********************************************************************************
 	 * CHANGE_BUTTON METHODS
 	 	  - allows to modify/change LABEL component instantly 
 	 	  
 	 @param JLabel label	- the JLabel object to be modified
 	 @param String fontStyle- the font style
 	 @param int fontSize	- the integer value of the font size
 	 @param int color 		- the integer value of the color
 	 
 	 BY DEFAULT:
 	 	* the TEXT is BOLD
 	 *********************************************************************************/
	    static void changeButton(JLabel label, String fontStyle, int fontSize, int color){
	      label.setFont(new Font(fontStyle, Font.BOLD, fontSize));
	      label.setForeground(new Color(color));
	    }
	    
	    
	 static void addComboBox(JPanel panel, JComboBox<String> combo, int x, int y, int width, int height) {
		 combo.setBounds(x, y, width, height);
		 combo.setFont(new Font("Roboto", Font.BOLD, 20));
		 
		 panel.add(combo);
	 }
}
