package offense.management.filehandle;

import java.util.*;

public class FileHandleController{
   public static int accountCheck(String username, String password){
      return FileHandle.isExist(username, password);
  }

  public static void addDataInPending(String fname, String lname, String username, String password){
      FileHandle.addDataInPendingFile(fname, lname, username, password);
  }
  public static void addDataInUserInfo(String firstN, String lastN, String userN, String pass){
    FileHandle.addDataInUserInfoFile(firstN, lastN, userN, pass, FileHandle.generateID());
  }
  public static String getName(){
    return FileHandle.getName();
  }
  public static String getID(){
    return FileHandle.getId();
  }
  public static int convertDataFile(ArrayList<String> data){
    return FileHandle.convertDataFromFileToArrayList(data);
  }
  public static int convertDataFilePending(ArrayList<ArrayList<String>> data){
    return FileHandle.convertData2DPending(data);
  }
  public static int convertDataWhole(ArrayList<ArrayList<String>> data){
    return FileHandle.convertData2D(data);
  }
  public static void removeDataPending(String data){
    FileHandle.removeData(data);
  }
  public static void removeDataPending(String data, String id){
    FileHandle.removeDataAdminPending(data, id);
  }
  public static int addOffenseToUser(String offense, String severity, String commit, String report, String reportBy, String deparment, String id){
    return FileHandle.writeDataSingleUser(offense, severity, commit, report, reportBy, deparment, id);
  }

  public static void userOffenses(ArrayList<ArrayList<String>> data, String id){
    FileHandle.convert2DOffenseData(data, id);
  }

  public static void writePending(String excuse, String id, String offId){
    FileHandle.writeExcusePendingUser(excuse, id, offId);
  }

  public static void covert2DArrayPending(ArrayList<ArrayList<String>> data, String id){
    FileHandle.convert2DPending(data, id);
  }
  public static void covert2DArrayPending(ArrayList<ArrayList<String>> data){
    FileHandle.convert2DPending(data);
  }
  public static void updateOffenseRecord(String id){
    FileHandle.updateOffense(id);
  }
  
}