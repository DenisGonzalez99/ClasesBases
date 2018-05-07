package basesclases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBaseClases {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        //Departamento
        int dept_no;
        String dnombre;
        String loc;
        //Empleado
        int emp_no;
        String apellido;
        String oficio;
        int dir;
        Date fecha_alt;
        double salario;
        double comision;
        int dept_no_em;

        Departamento departamento = new Departamento();
        Empleado empleado = new Empleado();
        Connection conexion;

        Statement sentencia = null;


        Departamentos deps = new Departamentos();
        Empleados emps = new Empleados();

        try {
                         
            int opcion;
            boolean seguir = true;
            int opcion1;
            while (seguir) {

                System.out.println("<--------------------------------------------------------------->");
                System.out.println("<|-------------------------------------------------------------|>");
                System.out.println("||A continuacion te voy a dar las opciones que pues escoger    ||");
                System.out.println("||-------------------------------------------------------------||");
                System.out.println("||Pulsa (1) si quieres Listar departamentos                    ||");  //FUNCIONA
                System.out.println("||Pulsa (2) si quieres Listar empleados                        ||");
                System.out.println("||Pulsa (3) si quires buscar un empleado por su nombre         ||");
                System.out.println("||Pulsa (4) si quieres buscar un departamento por su nombre    ||");
                System.out.println("||Pulsa (5) si quieres crear un empleado                       ||");  //FUNCIONA
                System.out.println("||Pulsa (6) si quieres crear un departamento                   ||");  //FUNCIONA
                System.out.println("||Pulsa (7) si quieres borrar un empleado                      ||");  //FUNCIONA
                System.out.println("||Pulsa (8) si quieres borrar un departamento                  ||");  //FUNCIONA
                System.out.println("||Pulsa (0) si quieres salir                                   ||");  //FUNCIONA
                System.out.println("<|-------------------------------------------------------------|>");
                System.out.println("<--------------------------------------------------------------->");

                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:                 
                        System.out.println("<--------------------------------------------------------------->");
                        System.out.println("<|-------------------------------------------------------------|>");
                        System.out.println("||A continuacion te voy a dar las opciones que pues escoger    ||");        
                        System.out.println("||-------------------------------------------------------------||");
                        System.out.println("||Pulsa (1) si quieres listar un departamento                  ||");        //funciona
                        System.out.println("||Pulsa (2) si quieres Listar tosdos los departamentos         ||");        //funciona
                        System.out.println("<|-------------------------------------------------------------|>");
                        System.out.println("<--------------------------------------------------------------->");
                        opcion1 = sc.nextInt();
                        switch (opcion1) {

                            case 1:         //FUNCIONA
                                System.out.println("Introduce el numero del departamento que quieras buscar");
                                dept_no = sc.nextInt();
//                departamento.setDept_no(dept_no);
                                departamento = deps.ReadNum(dept_no);
                                // imprimo departamento
                                System.out.printf("+--------------------------------------------------+ %n");
                                System.out.printf("|%-10s |%-20s |%-15s |%n", "Dpt_no", "Nom.Dep", "Ciudad");
                                System.out.printf("+--------------------------------------------------+ %n");

                                System.out.printf("|%10d |%-20s |%-15s |%n", departamento.getDept_no(),departamento.getDnombre(),departamento.getLoc());
                                System.out.printf("+--------------------------------------------------+ %n");
                                break;

                            case 2:     //FUNCIONA
                                ArrayList<Departamento> departamentosAL = new ArrayList<>();
                                departamentosAL = deps.ReadTodos();
                                System.out.printf("+--------------------------------------------------+ %n");
                                System.out.printf("|%-10s |%-20s |%-15s |%n", "Dpt_no", "Nom.Dep", "Ciudad");
                                System.out.printf("+--------------------------------------------------+ %n");
                                for (int i = 0; i < departamentosAL.size(); i++) {
                                    System.out.printf("|%10d |%-20s |%-15s |%n", departamentosAL.get(i).getDept_no(), departamentosAL.get(i).getDnombre(), departamentosAL.get(i).getLoc());
                                }
                                System.out.printf("+--------------------------------------------------+ %n");
                                break;
                        }

                    case 2:
                        //
                        break;
                    case 3:

                        System.out.println("Dinos el nombre del departamento");
                        

                        break;
                    case 4:         //FUNCIONA
                        System.out.println("Dinos el nombre del departamento");
                         dnombre = sc.next();
                         

                        departamento = deps.Read(dnombre);

                                System.out.printf("+--------------------------------------------------+ %n");
                                System.out.printf("|%-10s |%-20s |%-15s |%n", "Dpt_no", "Nom.Dep", "Ciudad");
                                System.out.printf("+--------------------------------------------------+ %n");

                                System.out.printf("|%10d |%-20s |%-15s |%n", departamento.getDept_no(),departamento.getDnombre(),departamento.getLoc());
                                System.out.printf("+--------------------------------------------------+ %n");
                        break;
                    case 5:
                        //
                        break;
                    case 6:                     //FUNCIONA
                        System.out.println("Vamos a crear un departamento");
                        System.out.println("Mete cada dato según te digamos, y despues de meter cada dato presiona Enter");
                        System.out.println("Primero el numero del departamento, luego dejas un espacio y pones el nombre del departamento por ultimo pones una ',' y pones la localización");

                        dept_no = sc.nextInt();
                        departamento.setDept_no(dept_no);

                        String string = sc.nextLine();
                        String[] partss = string.split(",");
                        String part11 = partss[0]; // dnombre
                        String part2 = partss[1]; // loc                      
                        departamento.setDnombre(partss[0]);
                        departamento.setLoc(partss[1]);

                        deps.Create(departamento);

                        break;

                    case 7:                                             //FUNCIONA
                        System.out.println("Dinos el numero del empleado que quieres borrar");
                        emp_no = sc.nextInt();
                        emps.Delete(emp_no);
                        break;

                    case 8:                     //FUNCIONA
                        System.out.println("Dinos el numero del departamento que quieres borrar");
                        dept_no = sc.nextInt();
                        deps.Delete(dept_no);

                        break;
                    case 0:            //FUNCIONA
                        seguir = false;
                        break;

                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar: " + ex.getSQLState() + " " + ex.getMessage());
        } finally {
            try {
                deps.Close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar BBDD: " + ex.getSQLState() + " " + ex.getMessage());
            }
        }

    }
}/*Crear un programa que presente las siguientes opciones:
Listar Departamentos. Aquí debe dar la opción de listar un solo departamento o todos.
Listar Empleados. Aquí debe dar la opción de listar un solo empleado o todos.
Buscar empleado por nombre.
Buscar departamento por nombre
Crear empleado
Crear departamento
Borrar empleado
Borrar departamento
 */
