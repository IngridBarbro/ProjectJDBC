
package artistmanagementsystem;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);   
    static boolean runAgain = true;
    public static void main(String[] args) throws SQLException{
   
     ArtistManagement am = new ArtistManagement();
    
     Meny m = new Meny();

        do {
            m.Interface();

            int menychoice = sc.nextInt();
            sc.nextLine();
            switch(menychoice){
            
                case 1:
                    am.ShowAll();
                    break;
                case 2:
                    am.add();
                    break;
                case 3:
                    am.update();
                    break;
                case 4:
                    am.delete();
                    break;
                case 5:
                    am.FindById();
                    break;
                case 6: 
                    runAgain = false;
                    break;
                        
            }
            
         

        } while (runAgain);
     
     
     
//    am.add();
//    am.ShowAll();
//    am.update();
//    am.ShowAll();
//    am.delete();
//    am.FindById();
    
    
        
    } 
    
}
