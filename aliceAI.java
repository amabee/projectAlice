package projectAlice;
import java.util.*;
import Jwiki.*;
import java.time.LocalDateTime;

public class aliceAI {
    static Scanner scan = new Scanner(System.in);
    static String command;
    static String respond;
    static String res;
   
    public static String hellow(){
        while(true){
            System.out.print("\nHello Master. How can I help you? => ");
            command = scan.nextLine();
            if(command.isEmpty()){
                continue;
            }
            else if(command.equalsIgnoreCase("Exit")){
                respond = "Response: Sayonara";
            }
            else if(command.equalsIgnoreCase("help")){
                respond = "Response: List of Commands: 'help' , \n'version => [Displays program version]' , \n'whoami => [Displays the Assistant's name]' , \n'wiki => [usage:\n ~to be update]'";
            }
            else if(command.equalsIgnoreCase("version")){
                respond = "Response:" + VerInfo();     
            }
            else if(command.equalsIgnoreCase("whoami")){
                respond = "Response: "+myName();
            }
            else if(command.equalsIgnoreCase("wiki")){
                respond = "Search result: \nTitle: \nDescription: " + WikiResult();
            }
            else if(command.equalsIgnoreCase("time") || command.equalsIgnoreCase("date")){
                respond = Time();
            }
            else{
                continue;
            }
            return respond;
    }
    }
    public static String VerInfo(){
        return "Version 1.0.0";
    }
    public static String myName(){
        return "I am Alice Sir :)";
    }
    public static String WikiResult(){
        System.out.print("What to search?: ");
        Jwiki wiki = new Jwiki(scan.nextLine()); 
        res = wiki.getDisplayTitle(); 
        res = wiki.getExtractText();
       //String wikisearch = scan.nextLine();
       return res;
    }
    public static String Time(){
        LocalDateTime time = LocalDateTime.now();
        String timeFormat = time.toString();
        return timeFormat;
    }
    public static void main(String []args){
        while(true){
            System.out.print(hellow());
            if(!command.equalsIgnoreCase("exit")){
                continue;
            }
            else{
                break;
            }
        }
    }
}
