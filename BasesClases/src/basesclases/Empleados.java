package basesclases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;




public class Empleados {
    
    private Connection conexion;
    private ArrayList<Empleado> empleados;

    Statement sentencia = null;

        public Empleados() {
        
        try{
            
        
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex){
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
        
public int Create (Empleado emps) throws SQLException{
    int filas = 0;
        String sql = "INSERT INTO empleados VALUES" +"( ?, ?, ?, ?, ?, ?, ?, ? )";
        PreparedStatement sentencia;
       
            sentencia = conexion.prepareStatement(sql);  
            
            sentencia.setInt(1, emps.getEmp_no());
            sentencia.setString(2, emps.getApellido());
            sentencia.setString(3, emps.getOficio());
            sentencia.setInt(4, emps.getDir());
            sentencia.setDate(5, emps.getFecha_alt());
            sentencia.setDouble(6, emps.getSalario());
            sentencia.setDouble(7, emps.getComision());
            sentencia.setInt(8, emps.getDept_no());
            
            filas = sentencia.executeUpdate();

        return filas;

    
    
    
}
public String Update (int emp_no, Empleado emp) throws SQLException{
     String sql = "UPDATE empleados set salario = 2500 where emp_no= "+emp_no ;

        
            sentencia = conexion.createStatement();

            sentencia.execute(sql);

            ResultSet rs = sentencia.getResultSet();

        //    rs.close();

            sentencia.close();

            return sql;
    
    
}
public Departamento Read (String apellido)throws SQLException {

        Departamento emp = null;

        String sql = "select oficio from empleados where apellido ="+apellido;
       
            sentencia = conexion.createStatement();
            sentencia.execute(sql);

            ResultSet rs = sentencia.getResultSet();  

            rs.close();

            sentencia.close();
       

        return emp;
    
    
    
    
}
public void Delete (int emp_no)throws SQLException {
        
        
        String sql = "delete from empleados where emp_no = "+emp_no;
        
        sentencia = conexion.createStatement();
            sentencia.execute(sql);

            ResultSet rs = sentencia.getResultSet();

          //  rs.close();

            sentencia.close();
            
           // return sql;
        
        
        

    }
        
    
}
