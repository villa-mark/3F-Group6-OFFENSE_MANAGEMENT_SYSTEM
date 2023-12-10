package offense.management.filehandle;

import java.io.*;
import java.util.*;


class FileHandle{

  static String fullName = null;
  static String id;
  static int offenseId = 0;
  static String userData = "Database\\UserData.dat";
  static String userPending = "Database\\UserPendingAccount.dat";
  static String offenseRecord = "Database\\offenseRecord.dat";
  static String pendingRecord = "Database\\pendingOffense.dat";

  /**********************************************************************************
   * Update "UserPendingAccount.dat" File with new Data from User
   * @Params name -> the user name
   * @Params username -> the user inputed username
   * @Params password -> the user inputed password
  ***********************************************************************************/
      static void addDataInPendingFile(String fname, String lname, String username, String password){
        try{

          //Write the data into the file
            FileWriter writer = new FileWriter(userPending, true);
            writer.write(fname + "\t" + lname + "\t" + username + "\t" + password + "\n");
            writer.close();

        }catch(Exception e){}
      }

    static void addDataInUserInfoFile(String fname, String lname, String username, String password, int id){
       try{

          //Write the data into the file
            FileWriter writer = new FileWriter(userData, true);
            writer.write(fname + "\t" + lname + "\t" + username + "\t" + password + "\t" + "CITE-OFFENSE-" + id + "\n");
            writer.close();

        }catch(Exception e){}
    }
  /**********************************************************************************
   * Check "user.dat" File if the Following data exist
   * @Params username   -> the user inputed username
   * @Params password   -> the user inputed password
   * return value integer
        0 == username doesn't exist
        1 == username exist but wrong password
        2 == both username and password exist
  ***********************************************************************************/
      static int isExist(String username, String password){
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
                //chack is password match for the acccount username
                  if(part[2].equals(username) && part[3].equals(password)){
                    returnVal = 2;
                    fullName = part[0] + " " + part[1];
                    id = part[4];
                    return returnVal;
                  }

              } 
            }

        }catch(Exception e){}
      
        return returnVal;
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
      static String getName(){
        return fullName;
      }
//***********************************************************************************/
      static String getId(){
        return id;
      }
//***********************************************************************************/
      static int convertDataFromFileToArrayList(ArrayList<String> data) {
        try (Scanner scan = new Scanner(new File(userPending))) {
          while(scan.hasNextLine()) {
            String[] part = scan.nextLine().split("\t");
            data.add(part[2]);
          }
          return data.size();
        }catch(Exception e) {}
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
  static int convertData2D(ArrayList<ArrayList<String>> data) {
        try (Scanner scan = new Scanner(new File(userPending))) {
          int num = 0;
          while(scan.hasNextLine()) {
            String[] part = scan.nextLine().split("\t");
            data.add(new ArrayList<>());
            data.get(num).add(part[0]);
            data.get(num).add(part[1]);
            data.get(num).add(part[2]);
            data.get(num).add(part[3]);
            num++;
          }
          return data.size();
        }catch(Exception e) {}
        return 0;
        
      }
      static int convertData2DPending(ArrayList<ArrayList<String>> data) {
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
//***********************************************************************************/
      static void removeData(String data){
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
//***********************************************************************************/
      static void deleteAllDataInFile(String directory) {
        try {
          try (FileWriter fileWrite = new FileWriter(directory)) {
            fileWrite.write("");
          }
        }catch(IOException e) {}
      }
      static int writeDataSingleUser(String offense, String severity, String commit, String report, String reportBy, String deparment, String id){
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
      static void writeExcusePendingUser(String excuse, String id, String offenseIDG){
        try{
            FileWriter writer = new FileWriter(pendingRecord, true);
            writer.write(id + "\t" + excuse + "\t" + offenseIDG + "\n");
            writer.close();
        }catch(Exception e){}
      }

      static void convert2DOffenseData(ArrayList<ArrayList<String>> data, String id){
        try (Scanner scan = new Scanner(new File(offenseRecord))) {
          int col = 0;
          int row = 0;
          ArrayList<ArrayList<String>> tempDataArray = new ArrayList<>();
  
          tempDataArray.add(new ArrayList<>());
          while(scan.hasNextLine()) {
            String tempData = scan.nextLine();
            if(tempData.isEmpty()){
              tempDataArray.add(new ArrayList<>());
              row = 0;
              col++;
              continue;
            }
            tempDataArray.get(col).add(tempData);
            row++;
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
          System.out.print(data);
          tempDataArray.clear();  // Clear the tempDataArray after processing
          
          }catch(Exception e) {}
        }


      static void convert2DOffenseData(ArrayList<ArrayList<String>> data){
        try (Scanner scan = new Scanner(new File(offenseRecord))) {
          int col = 0;
          int row = 0;
         
          data.add(new ArrayList<>());
          while(scan.hasNextLine()) {
            String tempData = scan.nextLine();
            if(tempData.isEmpty()){
              data.add(new ArrayList<>());
              row = 0;
              col++;
              continue;
            }
            data.get(col).add(tempData);
            row++;
          }
        }catch(Exception e) {}
      }

    static void convert2DPending(ArrayList<ArrayList<String>> data, String id){
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
      static void convert2DPending(ArrayList<ArrayList<String>> data){
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
      static int generateIDOff(){
        try (Scanner scan = new Scanner(new File(offenseRecord))) {
          int numIDOff = 0;
          while(scan.hasNextLine()) {
            String tempData = scan.nextLine();
            numIDOff++;
          }
          return numIDOff;
        }catch(Exception e) {}
        return 0;
      }


      static void removeDataAdminPending(String data, String id){
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

      static void updateOffense(String id){
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
}