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

    public Departamentos() {

        try {       //Conexion con la base de datos 

            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int Create(Departamento dep) throws SQLException {       //Insertar departamento
        int filas = 0;
        String sql = "INSERT INTO departamentos VALUES" + " ( ?, ?, ? )";
        PreparedStatement sentencia;

        sentencia = conexion.prepareStatement(sql);

        sentencia.setInt(1, dep.getDept_no());      //Hace referencia a la primera ?
        sentencia.setString(2, dep.getDnombre());   //Hace referencia a la segunda ?
        sentencia.setString(3, dep.getLoc());       //Hace referencia a la tercera ?
        filas = sentencia.executeUpdate();
        return filas;

    }

    public String Update(int dept_no, Departamento dep) throws SQLException {   //Modificar departamento

        String sql = "UPDATE departamentos set loc = 'cuenca' where dept_no= " + dept_no;
        Statement sentencia = null;

        sentencia = conexion.createStatement();

        sentencia.execute(sql);

        ResultSet rs = sentencia.getResultSet();

        sentencia.close();

        return sql;

    }

    public ArrayList<Departamento> ReadTodosNombre(String dnombre) throws SQLException {    //Lee  los departamentos con el nombre dado
//Se crea un arrayList por la posibilidad de que dos departamentos tengan un mismo nombre y asi evitamos un error 
        Departamento dep = null;
//        ArrayList<Departamento> deps = new ArrayList<>();
        Statement sentencia = null;

        String sql = "select * from departamentos where dnombre = '" + dnombre + "'";

        sentencia = conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs = sentencia.getResultSet();
        while (rs.next()) {
            dep = new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getString("loc"));
            departamentos.add(dep);
        }
        rs.close();
        sentencia.close();

        return departamentos;

    }

    public Departamento ReadNum(int dpt_no) throws SQLException {       //Lee los departamentos por su dpt_no

        Departamento dep = null;
        Statement sentencia = null;

        String sql = "select * from departamentos where dept_no = " + dpt_no;

        sentencia = conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs = sentencia.getResultSet();
        while (rs.next()) {
            dep = new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getString("loc"));

        }

        sentencia.close();

        return dep;

    }

    public ArrayList<Departamento> ReadTodos() throws SQLException {    //Lee todos los departamentos

        Departamento dep = null;
        Statement sentencia = null;

        String sql = "select * from departamentos";

        sentencia = conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs = sentencia.getResultSet();
        while (rs.next()) {
            dep = new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getString("loc"));
            departamentos.add(dep);
        }
        rs.close();
        sentencia.close();

        return departamentos;

    }

    public void Delete(int dept_no) throws SQLException {   //Borra un departamento

        String sql = "delete from departamentos where dept_no = " + dept_no;
        Statement sentencia = null;

        sentencia = conexion.createStatement();
        sentencia.execute(sql);

        ResultSet rs = sentencia.getResultSet();

        sentencia.close();

    }

    public void Close() throws SQLException {   //Cierra la conexion
        conexion.close();
    }

}
