package offense.management.filehandle;

import java.util.*;

public class FileHandleController {

  /***************************************************************************
   * Check username and password from the file
   * @param username 	- The username to be check
   * @param password 	- The password to be check
   * @return 0 (int)	- username doesn't exist
   * @return 1 (int)	- username exist but wrong password
   * @return 2 (int)	- both username and password exist as (TEACHER)
   * @return 3 (int)	- both username and password exist as (STUDENT)
   ***************************************************************************/
	  public static int accountCheck(String username, String password) {
	    return FileHandle.accountCheck(username, password);
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
	  public static void addDataInPending(String fname, String lname, String username, String password, String section, String batch) {
	    FileHandle.addDataInPending(fname, lname, username, password, section, batch);
	  }

	  
	  
  /***************************************************************************
   * Add data to the user info file
   * @param firstN 		- First name of the user
   * @param lastN 		- Last name of the user
   * @param userN 		- Username of the user
   * @param pass 		- Password of the user
   ***************************************************************************/
	  public static void addDataInUserInfo(String firstN, String lastN, String userN, String pass, String section, String batch) {
	    FileHandle.addDataInUserInfo(firstN, lastN, userN, pass, FileHandle.generateID(), section, batch);
	  }

	  
	  
  /***************************************************************************
   * Convert the data from userData file in an array
   * @param data 		- the variable where to store the data from userData file
   ***************************************************************************/ 
	  public static void convertUserDataFromFileToArray(ArrayList<ArrayList<String>> data) {
		  FileHandle.convertUserDataFromFileToArray(data);
	  }
	  
	  
	  
  /***************************************************************************
   * Get the name from the file
   * @return The name retrieved from the file
   ***************************************************************************/
	  public static String getName() {
	    return FileHandle.getName();
	  }
	  
	  
	  
  /***************************************************************************
   * Get the ID from the file
   * @return The ID retrieved from the file
   ***************************************************************************/
	  public static String getID() {
	    return FileHandle.getId();
	  }

	  
	  
  /***************************************************************************
   * Convert data from a file to an ArrayList
   * @param data 		- an ArrayList data to be stored with data from file
   * @return Integer representing the success of the conversion
   ***************************************************************************/
	  public static int convertDataFile(ArrayList<ArrayList<String>> data) {
	    return FileHandle.convertDataFile(data);
	  }
	  
	  
	  
  /***************************************************************************
   * Convert file data from pending file to 2D array
   * @param data 		- The 2D data to be stored with data from file
   * @return Integer representing the success of the conversion
   ***************************************************************************/
	  public static int convertDataFilePending(ArrayList<ArrayList<String>> data) {
	    return FileHandle.convertDataFilePending(data);
	  }

	  
	  
  /***************************************************************************
   * Convert 2D data
   * @param data 		- The 2D data to be stored with data from file
   * @return Integer representing the success of the conversion
   ***************************************************************************/
	  public static int convertDataWhole(ArrayList<ArrayList<String>> data) {
	    return FileHandle.convertDataWhole(data);
	  }

	  
	  
  /***************************************************************************
   * Remove data from pending file
   * @param data 		- The data to be remove
   ***************************************************************************/
	  public static void removeDataPending(String data) {
	    FileHandle.removeDataPending(data);
	  }

	  
	  
  /***************************************************************************
   * Remove data from pending file with ID
   * @param data 		- The data to remove
   * @param id 			- The ID associated with the data
   ***************************************************************************/
	  public static void removeDataPending(String data, String id) {
	    FileHandle.removeDataPending(data, id);
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
	  public static int addOffenseToUser(String offense, String severity, String commit, String report, String reportBy, String department, String id) {
	    return FileHandle.addOffenseToUser(offense, severity, commit, report, reportBy, department, id);
	  }

	  
	  
  /***************************************************************************
   * Convert 2D offense data for a user
   * @param data 		- The 2D offense data
   * @param id 			- The ID of the user
   ***************************************************************************/
	  public static void userOffenses(ArrayList<ArrayList<String>> data, String id) {
	    FileHandle.userOffenses(data, id);
	  }

	  
	  
  /***************************************************************************
   * Write pending excuse for a user
   * @param excuse 		- The excuse to be written
   * @param id 			- The ID of the user
   * @param offId 		- The offense ID
   ***************************************************************************/
	  public static void writePending(String excuse, String id, String offId) {
	    FileHandle.writePending(excuse, id, offId);
	  }

	  
	  
  /***************************************************************************
   * Convert 2D array for pending data
   * @param data 		- The 2D array of pending data
   * @param id 			- The ID of the user
   ***************************************************************************/
	  public static void covert2DArrayPending(ArrayList<ArrayList<String>> data, String id) {
	    FileHandle.covert2DArrayPending(data, id);
	  }

	  
	  
  /***************************************************************************
   * Convert 2D array for pending data
   * @param data 		- The 2D array of pending data
   ***************************************************************************/
	  public static void covert2DArrayPending(ArrayList<ArrayList<String>> data) {
	    FileHandle.covert2DArrayPending(data);
	  }
  
  
	  
  /***************************************************************************
   * Update offense record for a user
   * @param id 			- The ID of the user
   ***************************************************************************/
	  public static void updateOffenseRecord(String id) {
	    FileHandle.updateOffenseRecord(id);
	  }

	  
	  
  /***************************************************************************
   * Update notification file with provided data
   * @param data1 		- The first piece of data
   * @param data2 		- The second piece of data
   * @param data3 		- The third piece of data
   ***************************************************************************/
	  public static void updateNotifFile(String data1, String data2, String data3) {
	    FileHandle.updateNotifFile(data1, data2, data3);
	  }

	  
	  
  /***************************************************************************
   * Convert 2D array for notification data
   * @param data 		- The 2D array of notification data
   * @param userId 		- The ID of the user
   ***************************************************************************/
	  public static void convertNotif2d(ArrayList<ArrayList<String>> data, String userId) {
	    FileHandle.convertNotif2d(data, userId);
	  }

	  
	  
  /***************************************************************************
   * Remove user from notification file
   * @param userId 		- The ID of the user to be removed
   ***************************************************************************/
	  public static void removeFromNotifFile(String userId) {
	    FileHandle.removeFromNotifFile(userId);
	  }

	  
	  
}