package offense.management.filehandle;

public class FileHandleController{
   public static int accountCheck(String username, String password){
      return FileHandle.isExist(username, password);
  }

  public static void addDataInPending(String fname, String lname, String username, String password){
      FileHandle.addDataInPendingFile(fname, lname, username, password);
  }
  public static void addDataInUserInfo(String data){
    FileHandle.addDataInUserInfoFile(data, FileHandle.generateID());
  }
  public static String getName(){
    return FileHandle.getName();
  }
}