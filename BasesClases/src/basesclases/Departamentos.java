package basesclases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Departamentos {

    private Connection conexion;
    private ArrayList<Departamento> departamentos;
                Scanner sc = new Scanner(System.in);

    Statement sentencia = null;

    public Departamentos() {

        try {

            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int Create(Departamento dep) throws SQLException {

        int filas = 0;
        String sql = "INSERT INTO departamentos VALUES"+ " ( ?, ?, ? )";
        PreparedStatement sentencia;
       
            sentencia = conexion.prepareStatement(sql);
            
            sentencia.setInt(1, dep.getDept_no());
            sentencia.setString(2, dep.getDnombre());
            sentencia.setString(3, dep.getLoc());
            

            
                 //       System.out.printf("|%-5s |%-10s |%-15s |%-10s |%n","No", "Apellido", "Nom.Dep", "Ciudad");

            
            filas = sentencia.executeUpdate();
           return filas;
            
    }

    public String Update(int dept_no, Departamento dep) throws SQLException {

        

        String sql = "UPDATE departamentos set loc = 'Cuenca' where dept_no= "+dept_no ;

        
            sentencia = conexion.createStatement();

            sentencia.execute(sql);

            ResultSet rs = sentencia.getResultSet();
            

        //    rs.close();

            sentencia.close();

            return sql;
       
       

    }

    public Departamento Read(String dnombre) throws SQLException {

        Departamento dep = null;
                            


        String sql = "select * from departamentos where dnombre = "+dnombre;
       
            sentencia = conexion.createStatement();
            sentencia.execute(sql);

            ResultSet rs = sentencia.getResultSet();  

            rs.close();

            sentencia.close();
       

        return dep;

    }

    public void Delete(int dept_no) throws SQLException {
        
        
        String sql = "delete from departamentos where dept_no = "+dept_no;
        
        sentencia = conexion.createStatement();
            sentencia.execute(sql);

            ResultSet rs = sentencia.getResultSet();

          //  rs.close();

            sentencia.close();
            
           // return sql;
        
        
        

    }

    public void Close() throws SQLException {
        conexion.close();
    }

}
