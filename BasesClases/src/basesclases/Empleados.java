package basesclases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.ResultSet;
import java.sql.Statement;


public class Empleados {
    
    private Connection conexion;         //Conexión con la bbdd
    private ArrayList<Empleado> empleados;      //Array de empleados

    Statement sentencia = null;     //sentencia sql

        public Empleados() {
        
        try {       //Conexion con la base de datos ejemplo con usuario ejemplo y contraseña ejemplo
            
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex){
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
        
public int Create (Empleado emps) throws SQLException{      //Crea un empleado
    int filas = 0;
        String sql = "INSERT INTO empleados VALUES" +"( ?, ?, ?, ?, ?, ?, ?, ? )";
        PreparedStatement sentencia;
       
            sentencia = conexion.prepareStatement(sql);  
            
            sentencia.setInt(1, emps.getEmp_no());          //Hace referencia a la primera ?
            sentencia.setString(2, emps.getApellido());     //Hace referencia a la segunda ?
            sentencia.setString(3, emps.getOficio());       //Hace referencia a la tercera ?
            sentencia.setInt(4, emps.getDir());             //Hace referencia a la cuarta ?
            sentencia.setDate(5, emps.getFecha_alt());      //Hace referencia a la quinta ?
            sentencia.setDouble(6, emps.getSalario());      //Hace referencia a la sexta ?
            sentencia.setDouble(7, emps.getComision());     //Hace referencia a la septima ?
            sentencia.setInt(8, emps.getDept_no());         //Hace referencia a la octava ?
            
            filas = sentencia.executeUpdate();

        return filas;
}
public String Update (int emp_no, Empleado emp) throws SQLException{        //Modifica un empleado
     String sql = "UPDATE empleados set salario = 2500 where emp_no= "+emp_no ;

        
            sentencia = conexion.createStatement();

            sentencia.execute(sql);

            ResultSet rs = sentencia.getResultSet();
            sentencia.close();
            return sql;
    
}
public Empleado Read (String apellido)throws SQLException {     //Lee un empleado por el apellido

        Empleado emp = null;

        String sql = "select * from empleados where apellido = '"+apellido +"'";
       
            sentencia = conexion.createStatement();
            sentencia.execute(sql);         //Ejecuta la sentencia

            ResultSet rs = sentencia.getResultSet();  
        while (rs.next()) {
            emp = new Empleado(rs.getInt("emp_no"),rs.getString("Apellido"),rs.getString("oficio"),rs.getInt("dir"),rs.getDate("fecha_alt"),rs.getDouble("salario"),rs.getDouble("comision"),rs.getInt("dept_no"));
        }
            rs.close();
            sentencia.close();
            return emp;
    }
    public ArrayList<Empleado> ReadTodosNombre(String apellido) throws SQLException {       //Lee los empleados por el nombre
        //Se crea un arrayList por la posibilidad de que dos o mas empleados tengan un mismo nombre

        Empleado emp = null;
        ArrayList<Empleado> emps = new ArrayList<>();

        String sql = "select * from empleados where apellido = '"+apellido +"'";

        sentencia = conexion.createStatement();
        sentencia.execute(sql);     //Ejecucion de la sentencia sql
        ResultSet rs = sentencia.getResultSet();
        while (rs.next()) {
            emp = new Empleado(rs.getInt("emp_no"),rs.getString("apellido"),rs.getString("oficio"),rs.getInt("dir"),rs.getDate("fecha_alt"),rs.getDouble("salario"),rs.getDouble("comision"),rs.getInt("dept_no"));
            emps.add(emp);      //Añada al arrayList un empleado 
        }
        rs.close();
        sentencia.close();

        return emps;

    }

public Empleado ReadNum (int emp_no)throws SQLException {       //Lee un empleado por su nomero

        Empleado emp = null;

        String sql = "select * from empleados where emp_no = "+emp_no;
       
            sentencia = conexion.createStatement();
            sentencia.execute(sql);         //Ejecucion de la sentencia

            ResultSet rs = sentencia.getResultSet();  
        while (rs.next()) {
            emp = new Empleado(rs.getInt("emp_no"),rs.getString("Apellido"),rs.getString("oficio"),rs.getInt("dir"),rs.getDate("fecha_alt"),rs.getDouble("salario"),rs.getDouble("comision"),rs.getInt("dept_no"));

        }
            rs.close();

            sentencia.close();
       

        return emp;
   
}

    public ArrayList<Empleado> ReadTodos() throws SQLException {        //lee todos los empleados

        Empleado emp = null;
        ArrayList<Empleado> emps = new ArrayList<>();

        String sql = "select * from empleados";

        sentencia = conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs = sentencia.getResultSet();
        while (rs.next()) {
            emp = new Empleado(rs.getInt("emp_no"),rs.getString("apellido"),rs.getString("oficio"),rs.getInt("dir"),rs.getDate("fecha_alt"),rs.getDouble("salario"),rs.getDouble("comision"),rs.getInt("dept_no"));
            emps.add(emp);      //Añada al arrayList un empleado
        }
        rs.close();
        sentencia.close();

        return emps;

    }
public void Delete (int emp_no)throws SQLException {            //Borra un empleado
        String sql = "delete from empleados where emp_no = "+emp_no;
        
            sentencia = conexion.createStatement();
            sentencia.execute(sql);

            ResultSet rs = sentencia.getResultSet();
            
            sentencia.close();
    }
        
    
}
