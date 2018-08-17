/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeedatabase;
import java.sql.*;
/**
 *
 * @author Steven
 */
public class Connector {
//    DatabaseFrame frame = new DatabaseFrame();
    
    public String getCloseConException(String str){
        return str;
    }
    public Connection connectToDatabase() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/";
        String database = "employeedatabase";
        String userName = "root";
        String password = "oveshoalm21";
        
        return DriverManager.getConnection(url+database,userName,password);
    }
    public void closeConnection(Connection con){
        try{
            con.close();
    }
        catch(SQLException sqle){

        }
    }
}
