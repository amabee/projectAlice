package projectAlice;
import java.util.*;
import Jwiki.*;
import org.apache.commons.net.whois.WhoisClient;
import java.text.SimpleDateFormat;


public class aliceAI {
    static Scanner scan = new Scanner(System.in);
    static String command;
    static String respond;
    static String res;
    static String resTitle;
    static String results;
   
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
                respond = "Search result: " + WikiResult();
            }
            else if(command.equalsIgnoreCase("time") || command.equalsIgnoreCase("date")){
                respond = Time();
            }
            else if(command.equalsIgnoreCase("whois")){
                respond = WhoIs();
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
        resTitle = wiki.getDisplayTitle(); 
        res = wiki.getExtractText();
       //String prnt = resTitle + res;
       return res;
    }
    public static String Time(){
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy  hh:mm:ss");
        return (sdf.format(date));
    }
    public static String WhoIs(){
        WhoisClient whois = new WhoisClient();
        try{
            System.out.print("Enter Domain: ");
            String host = scan.next();
            whois.connect(WhoisClient.DEFAULT_HOST, 43);
                results = whois.query(host);
        }
        catch(Exception e){
            return e.getMessage();
        }
        return results;
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
