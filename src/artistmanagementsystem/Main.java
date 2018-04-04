
package artistmanagementsystem;

import java.sql.SQLException;



public class Main {
   
    
    public static void main(String[] args) throws SQLException{
     ArtistManagement am = new ArtistManagement();
    
    am.add();
    am.ShowAll();
    am.update();
    am.ShowAll();
    am.delete();
    am.FindById();
    
    
        
    } 
    
}
