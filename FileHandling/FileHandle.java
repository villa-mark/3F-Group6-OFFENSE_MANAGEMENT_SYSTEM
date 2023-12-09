package offense.management.filehandle;

import java.io.*;
import java.util.*;


class FileHandle{

  static String fullName = null;
  static String id;
  String userData = "UserData.dat";
  String userPending = "UserPendingAccount.dat";
  /**********************************************************************************
   * Update "UserPendingAccount.dat" File with new Data from User
   * @Params name -> the user name
   * @Params username -> the user inputed username
   * @Params password -> the user inputed password
  ***********************************************************************************/
      static void addDataInPendingFile(String fname, String lname, String username, String password, int id){
        try{

          //Write the data into the file
            FileWriter writer = new FileWriter(userPending, true);
            writer.write(fname + "\t" + lname + "\t" + username + "\t" + password + "\n");
            writer.close();

        }catch(Exception e){}
      }

    static void addDataInUserInfoFile(String data, int id){
       try{

          //Write the data into the file
            FileWriter writer = new FileWriter(userData, true);
            writer.write(data + "\t" + "CITE-OFFENSE-" + id + "\n");
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
          Scanner scan = new Scanner(new File("userdata.dat"));

          //set scanner to scan the whole content of the file
            scan.useDelimiter("\\Z");

          //Check if the "username" is contained in the file
            if(scan.next().contains(username)){
              returnVal = 1;

              Scanner scanIn = new Scanner(new File("userdata.dat"));
              while(scanIn.hasNextLine()){

                //Tokenized a line of data from file and store to part variable
                  String[] part = scanIn.nextLine().split(",',");

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
          Scanner scan = new Scanner(new File("userdata.dat"));
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
      static String getID(){
        return id;
      }
//***********************************************************************************/
      static int convertDataFromFileToArrayList(ArrayList<String> data) {
        try (Scanner scan = new Scanner(userPending)) {
          while(scan.hasNextLine()) {
            data.add(scan.nextLine());
          }
          return data.size();
        }catch(IOException e) {}
        return 0;
        
      }
//***********************************************************************************/
      static void removeData(String data){
       try{
          ArrayList<String> dataArray = new ArrayList<String();
          int dataSize = convertDataFromFileToArrayList(dataArray);
          deleteAllDataInFile();

          FileWriter writer = new FileWriter(userPending, true);
          int index = 0;
          while(index != dataSize){
            if(!scan.nextLine().equals(data)){
              writer.write(dataArray.get(index)"\n");
            }
            index++;
          }
           writer.close();
        }catch(Exception e){}
      }
//***********************************************************************************/
      static void deleteAllDataInFile() {
        try {
          try (FileWriter fileWrite = new FileWriter(userPending)) {
            fileWrite.write("");
          }
        }catch(IOException e) {}
      }

}