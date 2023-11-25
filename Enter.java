import java.io.*;

public class Enter{
    public static void main(String[] args){
       boolean _istrue = false;
       BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in)
       );

       while(!_istrue){
          try{
             System.out.println("Enter Username :");
             String username = reader.readLine();
           if(username.equals("Admin")){
              _istrue = true;
              System.out.println("Welcome, " + username);
           }else{
            System.out.println("Invalid username,retry !");
           }
          }catch(Exception e){
            System.out.println(e);
          }
       }

    }
}
