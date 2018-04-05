
package artistmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class ArtistManagement{
  private final String  DB_CONNECTION="jdbc:mysql://localhost:3306/artist";
  private final String  DB_USER = "root";
  private final String  DB_PASSWORD = "lexicon";
  static Scanner sc = new Scanner(System.in);
  static Connection dBConnection;
       
    public void add() throws SQLException{
    Connection dbConnection = null;
    dbConnection = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
    PreparedStatement p =dbConnection.prepareStatement("INSERT INTO ARTIST(ID, NAME, AGE, LASTNAME) values(?,?,?,?)");
   
    System.out.println("Id:");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.println("Name:");
    String name = sc.nextLine();
    System.out.println("Age:");
    int age = sc.nextInt();
    sc.nextLine();
    System.out.println("LastName:");
    String lastName = sc.nextLine();
    Artist a = new Artist(id, name, age, lastName);
    p.setInt (1,a.getId());
    p.setString(2,a.getName());
    p.setInt(3,a.getAge());
    p.setString(4,a.getLastName());
    p.execute();
    p.close();
    
    
    }
  
    public void delete() throws SQLException{
        Connection dbConnection = null;
        dbConnection = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
    
        System.out.println("Remove artist from Database");
        System.out.println("Can you give ID?");
        int id = sc.nextInt();
        sc.nextLine();
        PreparedStatement s =dbConnection.prepareStatement("DELETE FROM Artist WHERE ID =?");
        s.setInt(1, id);
        s.execute();
        s.close();
    
    }
    
    public void update() throws SQLException
    {   int choice;
        Connection dbConnection = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
        System.out.println("Update NAME, AGE OR LASTNAME, 1,2,3 and GIVE ID, Give 4 to exit");
        choice = sc.nextInt();
        sc.nextLine();
        
        switch(choice){
            case 1:
                System.out.println("Give ID");
               int  id = sc.nextInt();
                sc.nextLine();
                System.out.println("Give NAME");
                String name = sc.nextLine();
                PreparedStatement p =dbConnection.prepareStatement("UPDATE Artist SET Name = ? WHERE ID = ?");
                p.setInt(2,id);
                p.setString(1, name);
                p.execute();
                p.close(); 
                break;
            case 2:
                System.out.println("Give ID");
                id = sc.nextInt();
                sc.nextLine();
                System.out.println("Give AGE");
                int age = sc.nextInt();
                sc.nextLine(); 
                PreparedStatement q =dbConnection.prepareStatement("UPDATE Artist SET Age = ? WHERE ID = ?");
                q.setInt(2,id);
                q.setInt(1,age);
                
                q.execute();
                q.close();
                
                break;
            case 3:
                System.out.println("Give ID");
                id = sc.nextInt();
                sc.nextLine();
                System.out.println("Give LASTNAME");
                String lastName = sc.nextLine();
               
                PreparedStatement r =dbConnection.prepareStatement("UPDATE Artist SET lastName = ? WHERE ID = ?");
                r.setInt(2,id);
                r.setString(1,lastName);
                
                r.execute();
                r.close();
                break;
                
           
                
                   
        }        
               
    }
    public void ShowAll() throws SQLException{
       
        Connection dbConnection = null;
        dBConnection = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
        Statement st= dBConnection.createStatement();
  
        ResultSet list = st.executeQuery("SELECT * FROM Artist");
      
        while(list.next()){
          System.out.println(list.getInt("ID")+" " +list.getString("NAME")+" "+list.getString("LASTNAME")+" "+list.getInt("AGE"));
         }
     
       
        }
    
    
    public void FindById() throws SQLException{
        Connection dbConnection = null;
        dbConnection = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
    
        System.out.println("List artist with a ID number");
        System.out.println("Can you give ID?");
        int id = sc.nextInt();
        sc.nextLine();
        PreparedStatement s =dbConnection.prepareStatement("SELECT ID, NAME, AGE, LASTNAME FROM ARTIST WHERE ID =?");
        s.setInt(1, id);
      
        ResultSet rs = s.executeQuery();
        while(rs.next()){
         System.out.println("Artist with id "+ id+ " : "+" ID: "+rs.getInt("ID")+" NAMN: "+rs.getString("NAME")+" AGE: "+rs.getInt("AGE")+" LASTNAME: "+rs.getString("LASTNAME"));
        }
        s.execute();
        s.close();
       
       
          
        }
   
            
        }
    
       
    
   
    

