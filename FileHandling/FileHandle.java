package offense.management.filehandle;

import java.io.*;
import java.util.*;


class FileHandle{

  private static String fullName = null;
  private static String id;
  private static int offenseId = 0;
  private static String userData = "Database\\UserData.dat";
  private static String userPending = "Database\\UserPendingAccount.dat";
  private static String offenseRecord = "Database\\offenseRecord.dat";
  private static String pendingRecord = "Database\\pendingOffense.dat";
  private static String notifRecord = "Database\\notifRecord.dat";

  
  
  /***************************************************************************
   * Check username and password from the file
   * @param username 	- The username to be check
   * @param password 	- The password to be check
   * @return 0 (int)	- username doesn't exist
   * @return 1 (int)	- username exist but wrong password
   * @return 2 (int)	- both username and password exist as (TEACHER)
   * @return 3 (int)	- both username and password exist as (STUDENT)
   ***************************************************************************/
	    static int accountCheck(String username, String password){
	      int returnVal = 0;
	      try{
	        Scanner scan = new Scanner(new File(userData));
	
	        //set scanner to scan the whole content of the file
	          scan.useDelimiter("\\Z");
	
	        //Check if the "username" is contained in the file
	          if(scan.next().contains(username)){
	            Scanner scanIn = new Scanner(new File(userData));
	            while(scanIn.hasNextLine()){
	
	              //Tokenized a line of data from file and store to part variable
	                String[] part = scanIn.nextLine().split("\t");
	
	                if(part[2].equals(username)){
	                  returnVal = 1;
	                }
	              //chack if password match for the acccount username
	                if(part[2].equals(username) && part[3].equals(password)){
	              	  if(part[5].equals("null") && part[6].equals("null")) {
	              		  returnVal = 2;
	              	  }
	              	  else {
	              		  returnVal = 3;
	              	  }
	          	    fullName = part[0] + " " + part[1];
	                  id = part[4];
	                  return returnVal;
	                }
	
	            } 
	          }
	
	      }catch(Exception e){}
	    
	      return returnVal;
	    }
    
    
	/***************************************************************************
	 * Add data to the pending file
	 * @param fname 		- First name of the user
	 * @param lname 		- Last name of the user
	 * @param username 	- Username of the user
	 * @param password 	- Password of the user
	 * @param section 	- Section of the user
	 * @param batch 		- Batch of the user
	 ***************************************************************************/
	      static void addDataInPending(String fname, String lname, String username, String password, String section, String bacth){
	        try{
	
	          //Write the data into the file
	            FileWriter writer = new FileWriter(userPending, true);
	            writer.write(fname + "\t" + lname + "\t" + username + "\t" + password + "\t" + section + "\t" + bacth + "\n");
	            writer.close();
	
	        }catch(Exception e){}
	      }

  /***************************************************************************
   * Add data to the user info file
   * @param firstN 		- First name of the user
   * @param lastN 		- Last name of the user
   * @param userN 		- Username of the user
   * @param pass 		- Password of the user
   ***************************************************************************/     
	    static void addDataInUserInfo(String fname, String lname, String username, String password, int id, String section, String batch){
	       try{
	
	          //Write the data into the file
	            FileWriter writer = new FileWriter(userData, true);
	            writer.write(fname + "\t" + lname + "\t" + username + "\t" + password + "\t" + "CITE-OFFENSE-" + id + "\t" + section + "\t" + batch + "\n");
	            writer.close();
	
	        }catch(Exception e){}
	    }
	    
	    
    /***************************************************************************
     * Convert the data from userData file in an array
     * @param data 		- the variable where to store the data from userData file
     ***************************************************************************/ 
      static void convertUserDataFromFileToArray(ArrayList<ArrayList<String>> data) {
    	    try {
    	        Scanner scanUserFile = new Scanner(new File(userData));

    	        while(scanUserFile.hasNextLine()) {
    	            String[] part = scanUserFile.nextLine().split("\t");

    	            if(!(part[5].equals("null"))) {
    	                ArrayList<String> userData = new ArrayList<>();
    	                userData.add(part[0]);
    	                userData.add(part[1]);
    	                userData.add(part[2]);
    	                userData.add(part[3]);
    	                userData.add(part[4]);
    	                userData.add(part[5]);
    	                userData.add(part[6]);

    	                data.add(userData);
    	            }
    	        }
    	    } catch (Exception e) {};
    	}	    
	    
      
  /***************************************************************************
   * Get the name from the file
   * @return The name retrieved from the file
   ***************************************************************************/
      static String getName(){
        return fullName;
      }
    
      
      
  /***************************************************************************
   * Get the ID from the file
   * @return The ID retrieved from the file
   ***************************************************************************/
      static String getId(){
        return id;
      }
      
    
      
  /***************************************************************************
   * Convert data from a file to an ArrayList
   * @param data 		- an ArrayList data to be stored with data from file
   * @return Integer representing the success of the conversion
   ***************************************************************************/
      static int convertDataFile(ArrayList<ArrayList<String>> data) {
        try (Scanner scan = new Scanner(new File(userPending))) {
          int indexIncrement = 0;
          while(scan.hasNextLine()) {
            String[] part = scan.nextLine().split("\t");
            data.add(new ArrayList<>());
            data.get(indexIncrement).add(part[2]);
            data.get(indexIncrement).add(part[4]);
            indexIncrement++;
          }
          return data.size();
        }catch(Exception e) {}
        return 0;
        
      }
      
      
      
      
  /***************************************************************************
   * Convert file data from pending file to 2D array
   * @param data 		- The 2D data to be stored with data from file
   * @return Integer representing the success of the conversion
   ***************************************************************************/
      static int convertDataFilePending(ArrayList<ArrayList<String>> data) {
        try (Scanner scan = new Scanner(new File(pendingRecord))) {
          int num = 0;
          while(scan.hasNextLine()) {
            String[] part = scan.nextLine().split("\t");
            data.add(new ArrayList<>());
            data.get(num).add(part[0]);
            data.get(num).add(part[1]);
            data.get(num).add(part[2]);
            num++;
          }
          return data.size();
        }catch(Exception e) {}
        return 0;
        
      }
      
      
      
  /***************************************************************************
   * Convert 2D data
   * @param data 		- The 2D data to be stored with data from file
   * @return Integer representing the success of the conversion
   ***************************************************************************/
	  static int convertDataWhole(ArrayList<ArrayList<String>> data) {
	        try (Scanner scan = new Scanner(new File(userPending))) {
	          int num = 0;
	          while(scan.hasNextLine()) {
	            String[] part = scan.nextLine().split("\t");
	            data.add(new ArrayList<>());
	            data.get(num).add(part[0]);
	            data.get(num).add(part[1]);
	            data.get(num).add(part[2]);
	            data.get(num).add(part[3]);
	            data.get(num).add(part[4]);
	            data.get(num).add(part[5]);
	            
	            num++;
	          }
	          return data.size();
	        }catch(Exception e) {}
	        return 0;
	        
	      }
      
      
      
  /***************************************************************************
   * Remove data from pending file
   * @param data 		- The data to be remove
   ***************************************************************************/
      static void removeDataPending(String data){
       try{
          ArrayList<String> dataArray = new ArrayList<String>();
          int dataSize = convertData(dataArray);
          deleteAllDataInFile(userPending);

          FileWriter writer = new FileWriter(userPending, true);
          int index = 0;
          while(index != dataSize){
            if((dataArray.get(index).contains(data))){
            }else{
              writer.write(dataArray.get(index)+ "\n");
            }
            index++;
          }
          dataArray.clear();
          writer.close();
        }catch(Exception e){}
      }
      
      
      
  /***************************************************************************
   * Remove data from pending file with ID
   * @param data 		- The data to remove
   * @param id 			- The ID associated with the data
   ***************************************************************************/
      static void removeDataPending(String data, String id){
       try{
          ArrayList<String> dataArray = new ArrayList<String>();
          int dataSize = convertData(dataArray, 1);
          deleteAllDataInFile(pendingRecord);

          FileWriter writer = new FileWriter(pendingRecord, true);
          int index = 0;
          while(index != dataSize){
            if((dataArray.get(index).contains(data) && dataArray.get(index).contains(id))){
            }else{
              writer.write(dataArray.get(index)+ "\n");
            }
            index++;
          }
          dataArray.clear();
          writer.close();
        }catch(Exception e){}
      }
      
      
      
  /***************************************************************************
   * Add offense data to a user
   * @param offense 	- The offense
   * @param severity 	- The severity of the offense
   * @param commit 		- The date of the offense
   * @param report 		- The report of the offense
   * @param reportBy 	- The person who reported the offense
   * @param department 	- The department related to the offense
   * @param id 			- The ID of the user
   * @return Integer representing the success of writing the data
   ***************************************************************************/
      static int addOffenseToUser(String offense, String severity, String commit, String report, String reportBy, String deparment, String id){
        try{
          Scanner scan = new Scanner(new File(userData));
          scan.useDelimiter("\\Z");
          offenseId++;
          if(scan.next().contains(id)){
            FileWriter writer = new FileWriter(offenseRecord, true);
            writer.write(offense + "\n");
            writer.write(severity + "\n");
            writer.write("NOT FILED\n");
            writer.write(commit + "\n");
            writer.write(report + "\n");
            writer.write(reportBy + "\n");
            writer.write(deparment + "\n");
            writer.write("OffMan" + generateIDOff() + "\n");
            writer.write( id + "\n\n");

            writer.close();
            return 1;
          }
        }catch(Exception e){}
        return 0;
      }
      
      
      
  /***************************************************************************
   * Convert 2D offense data for a user
   * @param data 		- The 2D offense data
   * @param id 			- The ID of the user
   ***************************************************************************/
      static void userOffenses(ArrayList<ArrayList<String>> data, String id){
        try (Scanner scan = new Scanner(new File(offenseRecord))) {
          int col = 0;
          ArrayList<ArrayList<String>> tempDataArray = new ArrayList<>();
  
          tempDataArray.add(new ArrayList<>());
          while(scan.hasNextLine()) {
            String tempData = scan.nextLine();
            if(tempData.isEmpty()){
              tempDataArray.add(new ArrayList<>());
              col++;
              continue;
            }
            tempDataArray.get(col).add(tempData);
          }
          int start = 0;
          while (start < tempDataArray.size()) {
              if (tempDataArray.get(start).get(8).equals(id)) {
                  ArrayList<String> rowData = new ArrayList<>();  // Create a new ArrayList to store the row data
                  for (int index = 0; index < 9; index++) {  // Iterate over the columns
                      rowData.add(tempDataArray.get(start).get(index));  // Add each column value to the rowData list
                  }
                  data.add(rowData);  // Add the rowData to the data list
              }
              start++;
          }
          tempDataArray.clear();  // Clear the tempDataArray after processing
          
          }catch(Exception e) {}
        }
      
      
      
      
  /***************************************************************************
   * Write pending excuse for a user
   * @param excuse 		- The excuse to be written
   * @param id 			- The ID of the user
   * @param offId 		- The offense ID
   ***************************************************************************/
      static void writePending(String excuse, String id, String offenseIDG){
        try{
            FileWriter writer = new FileWriter(pendingRecord, true);
            writer.write(id + "\t" + excuse + "\t" + offenseIDG + "\n");
            writer.close();
        }catch(Exception e){}
      }
      
      
      
  /***************************************************************************
   * Convert 2D array for pending data
   * @param data 		- The 2D array of pending data
   * @param id 			- The ID of the user
   ***************************************************************************/
    static void covert2DArrayPending(ArrayList<ArrayList<String>> data, String id){
        try (Scanner scan = new Scanner(new File(pendingRecord))) {
    
          int row = 0;

          while(scan.hasNextLine()) {
            String tempData = scan.nextLine();
            String[] part = tempData.split("\t");

            if(part[0].equals(id)){
              data.add(new ArrayList<>());
              data.get(row).add(part[0]);
              data.get(row).add(part[1]);
              data.get(row).add(part[2]);
              row++;
            }
          }
        }catch(Exception e) {}
      } 
      
      
      
/***************************************************************************
 * Convert 2D array for pending data
 * @param data 		- The 2D array of pending data
 ***************************************************************************/
    static void covert2DArrayPending(ArrayList<ArrayList<String>> data){
      try (Scanner scan = new Scanner(new File(pendingRecord))) {
  
        int row = 0;

        while(scan.hasNextLine()) {
          String tempData = scan.nextLine();
          String[] part = tempData.split("\t");

          data.add(new ArrayList<>());
          data.get(row).add(part[0]);
          data.get(row).add(part[1]);
          data.get(row).add(part[2]);
          row++;
        }
      }catch(Exception e) {}
    }
      
      
      
/***************************************************************************
 * Update offense record for a user
 * @param id 			- The ID of the user
 ***************************************************************************/
    static void updateOffenseRecord(String id){
      try{
        ArrayList<ArrayList<String>> dataArray = new ArrayList<>();
        convert2DOffenseData(dataArray);
        deleteAllDataInFile(offenseRecord);

        int index = 0;
        
        while(index != dataArray.size()){
          FileWriter writer = new FileWriter(offenseRecord, true);
          if(dataArray.get(index).get(7).equals(id)){
            writer.write(dataArray.get(index).get(0) + "\n");
            writer.write(dataArray.get(index).get(1) + "\n");
            writer.write("FILED\n");
            writer.write(dataArray.get(index).get(3) + "\n");
            writer.write(dataArray.get(index).get(4) + "\n");
            writer.write(dataArray.get(index).get(5) + "\n");
            writer.write(dataArray.get(index).get(6) + "\n");
            writer.write(dataArray.get(index).get(7) + "\n");
            writer.write(dataArray.get(index).get(8) + "\n\n");
          }else{
            writer.write(dataArray.get(index).get(0) + "\n");
            writer.write(dataArray.get(index).get(1) + "\n");
            writer.write(dataArray.get(index).get(2) + "\n");
            writer.write(dataArray.get(index).get(3) + "\n");
            writer.write(dataArray.get(index).get(4) + "\n");
            writer.write(dataArray.get(index).get(5) + "\n");
            writer.write(dataArray.get(index).get(6) + "\n");
            writer.write(dataArray.get(index).get(7) + "\n");
            writer.write(dataArray.get(index).get(8) + "\n\n");
          }
          writer.close();
          index++;
        }

      }catch(Exception e){}
    } 
      
      
      
/***************************************************************************
 * Update notification file with provided data
 * @param data1 		- The first piece of data
 * @param data2 		- The second piece of data
 * @param data3 		- The third piece of data
 ***************************************************************************/     
    static void updateNotifFile(String data1, String data2, String data3) {
  	  try {
  		  FileWriter writer = new FileWriter(notifRecord, true);
  		  writer.write(data1 + "\t" + data2 + "\t" + data3 + "\n");
  		  writer.close();
  	  }catch(Exception e) {};
    }  
      
      
      
/***************************************************************************
 * Convert 2D array for notification data
 * @param data 		- The 2D array of notification data
 * @param userId 		- The ID of the user
 ***************************************************************************/   
    static void convertNotif2d(ArrayList<ArrayList<String>> data, String userId) {
  	  try {
  		  Scanner scanIn = new Scanner(new File(notifRecord));
  		  int indexCount = 0;
  		  while(scanIn.hasNextLine()) {
  			  String[] part = scanIn.nextLine().split("\t");
  		
  			  if(part[0].equals(userId)) {
  				  data.add(new ArrayList<>());
  				  data.get(indexCount).add(part[0]);
  				  data.get(indexCount).add(part[1]);
  				  data.get(indexCount).add(part[2]);
  				  indexCount++;
  			  }
  		  }
  	  }catch(Exception e) {};
    }   
      
      
      
/***************************************************************************
 * Remove user from notification file
 * @param userId 		- The ID of the user to be removed
 ***************************************************************************/     
    static void removeFromNotifFile(String userId) {
  	    try {
  	        ArrayList<ArrayList<String>> tempData = new ArrayList<>();
  	        
  	        File fileNotif = new File(notifRecord);
  	        Scanner scanner = new Scanner(fileNotif);

  	        while(scanner.hasNextLine()) {
  	            String[] part = scanner.nextLine().split("\t");

  	            if(!(part[0].equals(userId))) {
  	                ArrayList<String> data = new ArrayList<>();
  	                data.add(part[0]);
  	                data.add(part[1]);
  	                data.add(part[2]);
  	                tempData.add(data);
  	            }
  	        }

  	        FileWriter writeRemove = new FileWriter(fileNotif);

  	        if(tempData.size() == 0) {
  	            writeRemove.write("");
  	        } else {
  	            for (ArrayList<String> data : tempData) {
  	                writeRemove.write(data.get(0) + "\t" + data.get(1) + "\t" + data.get(2) + "\n");
  	            }
  	        }
  	        scanner.close();
  	        writeRemove.close();

  	    } catch(Exception e) {
  	        // Handle the exception, e.g., logging or rethrowing
  	    }
  	}
      
      
  
//***********************************************************************************/
    static int generateIDOff(){
        try (Scanner scan = new Scanner(new File(offenseRecord))) {
          int numIDOff = 0;
          while(scan.hasNextLine()) {
            scan.nextLine();
            numIDOff++;
          }
          return numIDOff;
        }catch(Exception e) {}
        return 0;
      }
//***********************************************************************************/
      static int generateID(){
        try{
          Scanner scan = new Scanner(new File(userData));
          int num = 0;
          while(scan.hasNextLine()){
            scan.nextLine();
            num++;
          }
          return num;
        }catch(Exception e){}
        return 0;
      }
//***********************************************************************************/
      static int convertData(ArrayList<String> data) {
          try (Scanner scan = new Scanner(new File(userPending))) {
            while(scan.hasNextLine()) {
              data.add(scan.nextLine());
            }
            return data.size();
          }catch(Exception e) {}
          return 0;
          
        }
//***********************************************************************************/
      static int convertData(ArrayList<String> data, int num) {
          try (Scanner scan = new Scanner(new File(pendingRecord))) {
            while(scan.hasNextLine()) {
              data.add(scan.nextLine());
            }
            return data.size();
          }catch(Exception e) {}
          return 0;
          
        }
//***********************************************************************************/
      static void deleteAllDataInFile(String directory) {
          try {
            try (FileWriter fileWrite = new FileWriter(directory)) {
              fileWrite.write("");
            }
          }catch(IOException e) {}
        }
//***********************************************************************************/
      static void convert2DOffenseData(ArrayList<ArrayList<String>> data){
          try (Scanner scan = new Scanner(new File(offenseRecord))) {
            int col = 0;
           
            data.add(new ArrayList<>());
            while(scan.hasNextLine()) {
              String tempData = scan.nextLine();
              if(tempData.isEmpty()){
                data.add(new ArrayList<>());
                col++;
                continue;
              }
              data.get(col).add(tempData);
            }
          }catch(Exception e) {}
        }
//***********************************************************************************/

}