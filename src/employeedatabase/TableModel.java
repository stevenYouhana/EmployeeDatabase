/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeedatabase;
import javax.swing.table.*;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Steven
 */
public class TableModel extends AbstractTableModel{
    private ResultSet resultSet;
    private ResultSetMetaData rsMeta;
    private ArrayList data;
    
    private String[] columnNames = new String[]
    {"EmpID","EmpName","Address","Suburb","Postcode","HomePhone","Mobile","Email"};
    
    public TableModel(ResultSet rs){
        try{
            resultSet = rs;
            rsMeta = rs.getMetaData();
            data = new ArrayList();
            int cols = getColumnCount();
            
            while(rs.next()){
                Object[] row = new Object[cols];
                for(int i = 0; i<row.length; i++){
                    row[i] = resultSet.getObject(i+1);
                } 
                data.add(row);
            }
            
        }
        catch(SQLException sqle){
             System.out.println(sqle.toString());
        }
    }
    public Object getValue(int row, int col){
        if(row<data.size()){
            return ((Object[])data.get(row))[col];
        }
        else{
            return null;
        }
    }
    public int getRowCount(){
        return data.size();
    }
    public String getColumnName(int col){
        return columnNames[col];
    }
    public int getColumnCount(){
        try{
            return rsMeta.getColumnCount();
        }
        catch(SQLException sqle){
            sqle.getStackTrace();
            return 0;
        }        
    }
    @Override
    public Object getValueAt(int row, int col){
        if(row<data.size()){
            return ((Object[])data.get(row))[col];
        }
        else{
            return null;
        }
    }
}
