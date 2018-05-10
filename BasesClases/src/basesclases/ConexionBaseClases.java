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
        Departamentos deps = new Departamentos();
        Empleados emps = new Empleados();
        Connection conexion;

        Statement sentencia = null;



        try {

            int opcion;
            boolean seguir = true;
            int opcion1;
            while (seguir) {

                System.out.println("<---------------------------------------------------------------------------------------->");
                System.out.println("<|--------------------------------------------------------------------------------------|>");
                System.out.println("<|                                      <<Menú>>                                        |>");
                System.out.println("<|--------------------------------------------------------------------------------------|>");
                System.out.println("║Pulsa (1)           >>>>>>Listar departamentos <<<<<<<                                 ║");  //FUNCIONA
                System.out.println("║Pulsa (2)           >>>>>>Listar empleados <<<<<<<                                     ║");  //Funciona
                System.out.println("║Pulsa (3)           >>>>>>Buscar empleado por su nombre <<<<<<<                        ║");  //FUNCIONA
                System.out.println("║Pulsa (4)           >>>>>>buscar departamento por su nombre <<<<<<<                    ║");  //FUNCIONA
                System.out.println("║Pulsa (5)           >>>>>>Crear un empleado <<<<<<<                                    ║");  //FUNCIONA
                System.out.println("║Pulsa (6)           >>>>>>Crear un departamento <<<<<<<                                ║");  //FUNCIONA
                System.out.println("║Pulsa (7)           >>>>>>Borrar un empleado <<<<<<<                                   ║");  //FUNCIONA
                System.out.println("║Pulsa (8)           >>>>>>Borrar un departamento <<<<<<<                               ║");  //FUNCIONA
                System.out.println("║Pulsa (0)           >>>>>>Salir <<<<<<<                                                ║");  //FUNCIONA
                System.out.println("<|--------------------------------------------------------------------------------------|>");
                System.out.println("<---------------------------------------------------------------------------------------->");

                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("<---------------------------------------------------------------------------------------->");
                        System.out.println("<|--------------------------------------------------------------------------------------|>");
                        System.out.println("||                           <<Menú de Listar departamentos>>                           ||");
                        System.out.println("||--------------------------------------------------------------------------------------||");
                        System.out.println("║║Pulsa (1)           >>>>>>Listar un departamento<<<<<<<                                ║║");        //funciona
                        System.out.println("║║Pulsa (2)           >>>>>>Listar tosdos los departamentos<<<<<<<                       ║║");        //funciona
                        System.out.println("<|--------------------------------------------------------------------------------------|>");
                        System.out.println("<---------------------------------------------------------------------------------------->");
                        opcion1 = sc.nextInt();
                        switch (opcion1) {
                            case 1:         //FUNCIONA
                                System.out.println("Introduce el número del departamento que quieras buscar");
                                dept_no = sc.nextInt();
//                departamento.setDept_no(dept_no);
                                departamento = deps.ReadNum(dept_no);
                                // imprimo departamento
                                System.out.printf("+--------------------------------------------------+ %n");
                                System.out.printf("|%-10s |%-20s |%-15s |%n", "Dpt_no", "Nom.Dep", "Ciudad");
                                System.out.printf("+--------------------------------------------------+ %n");

                                System.out.printf("|%-10d |%-20s |%-15s |%n", departamento.getDept_no(), departamento.getDnombre(), departamento.getLoc());
                                System.out.printf("+--------------------------------------------------+ %n");
                                break;

                            case 2:     //FUNCIONA
                                ArrayList<Departamento> departamentosAL = new ArrayList<>();
                                departamentosAL = deps.ReadTodos();
                                System.out.printf("+--------------------------------------------------+ %n");
                                System.out.printf("|%-10s |%-20s |%-15s |%n", "Dpt_no", "Nom.Dep", "Ciudad");
                                System.out.printf("+--------------------------------------------------+ %n");
                                for (int i = 0; i < departamentosAL.size(); i++) {
                                    System.out.printf("|%-10d |%-20s |%-15s |%n", departamentosAL.get(i).getDept_no(), departamentosAL.get(i).getDnombre(), departamentosAL.get(i).getLoc());
                                }
                                System.out.printf("+--------------------------------------------------+ %n");
                                break;
                            
                        }
                        break;

                    case 2:
                        System.out.println("<---------------------------------------------------------------------------------------->");
                        System.out.println("<|--------------------------------------------------------------------------------------|>");
                        System.out.println("||                             <<Menú de Listar empleados>>                             ||");
                        System.out.println("<|--------------------------------------------------------------------------------------|>");
                        System.out.println("║Pulsa (1)            >>>>>>Listar un empleado<<<<<<<                                   ║");
                        System.out.println("║Pulsa (2)            >>>>>>Listar tosdos los empleados<<<<<<<                          ║");
                        System.out.println("<|--------------------------------------------------------------------------------------|>");
                        System.out.println("<---------------------------------------------------------------------------------------->");

                        opcion1 = sc.nextInt();
                        switch (opcion1) {
                            case 1:
                                System.out.println("Introduce el número del empleado que quieras buscar");
                                emp_no = sc.nextInt();
                                empleado = emps.ReadNum(emp_no);
                                System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");
                                System.out.printf("|%-10s |%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%n", "Emp_no", "Apellido", "Oficio", "Dir", "Fecha", "Salario", "Comision", "dept_no");
                                System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");
                                System.out.printf("|%-10s |%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%n", empleado.getEmp_no(), empleado.getApellido(), empleado.getOficio(), empleado.getDir(), empleado.getFecha_alt(), empleado.getSalario(), empleado.getComision(), empleado.getDept_no());
                                System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");

                                break;

                            case 2:
                                ArrayList<Empleado> empleadosAL = new ArrayList<>();
                                empleadosAL = emps.ReadTodos();
                                System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");
                                System.out.printf("|%-10s |%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%n", "Emp_no", "Apellido", "Oficio", "Dir", "Fecha", "Salario", "Comision", "dept_no");
                                System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");

                                for (int i = 0; i < empleadosAL.size(); i++) {
                                    System.out.printf("|%-10s |%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%n", empleadosAL.get(i).getEmp_no(), empleadosAL.get(i).getApellido(), empleadosAL.get(i).getOficio(), empleadosAL.get(i).getDir(), empleadosAL.get(i).getFecha_alt(), empleadosAL.get(i).getSalario(), empleadosAL.get(i).getComision(), empleadosAL.get(i).getDept_no());
                                }
                                System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");

                                break;
                        }

                        break;
                    case 3:

                        System.out.println("Introduce el nombre del empleado que quieres buscar");
                        apellido = sc.next();
                                ArrayList<Empleado> empleadosAL = new ArrayList<>();
                                empleadosAL = emps.ReadTodosNombre(apellido);
                                System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");
                                System.out.printf("|%-10s |%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%n", "Emp_no", "Apellido", "Oficio", "Dir", "Fecha", "Salario", "Comision", "dept_no");
                                System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");

                                for (int i = 0; i < empleadosAL.size(); i++) {
                                    System.out.printf("|%-10s |%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%n", empleadosAL.get(i).getEmp_no(), empleadosAL.get(i).getApellido(), empleadosAL.get(i).getOficio(), empleadosAL.get(i).getDir(), empleadosAL.get(i).getFecha_alt(), empleadosAL.get(i).getSalario(), empleadosAL.get(i).getComision(), empleadosAL.get(i).getDept_no());
                                }
                                System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");

                        break;
                    case 4:         //FUNCIONA
                        System.out.println("Introduce el nombre del departamento que quieres buscar");
                        dnombre = sc.next();

                                ArrayList<Departamento> departamentosAL = new ArrayList<>();
                                departamentosAL = deps.ReadTodosNombre(dnombre);
                                System.out.printf("+--------------------------------------------------+ %n");
                                System.out.printf("|%-10s |%-20s |%-15s |%n", "Dpt_no", "Nom.Dep", "Ciudad");
                                System.out.printf("+--------------------------------------------------+ %n");
                                for (int i = 0; i < departamentosAL.size(); i++) {
                                    System.out.printf("|%10d |%-20s |%-15s |%n", departamentosAL.get(i).getDept_no(), departamentosAL.get(i).getDnombre(), departamentosAL.get(i).getLoc());
                                }
                                System.out.printf("+--------------------------------------------------+ %n");
                        break;
                    case 5:
                        System.out.println("Vamos a crear un empleado");
                        System.out.println("Primero inserta el número del empleado");
                        emp_no = sc.nextInt();
                        empleado.setEmp_no(emp_no);
                        System.out.println("Introduce el apellido seguido de una ',' y luego el oficio");
                        String strin = sc.next();
                        String[] partsss = strin.split(",");
                        String partemp11 = partsss[0]; // apellido
                        String partemp2 = partsss[1]; // oficina                      
                        empleado.setApellido(partsss[0]);
                        empleado.setOficio(partsss[1]);
                        System.out.println("Introduce  el dir");
                        System.out.println("Recuerda que el dir tiene que coincidir con otro empleado");
                        dir = sc.nextInt();
                        empleado.setDir(dir);
                        System.out.println("Introduce su fecha de contratación");
                        System.out.println("Recuerda que la fecha se tiene que poner asi: yyyy-mm-dd");
                        String fecha = sc.next();       //cREO UNA VARIABLE NUEVA PARA LA FECHA
                        fecha_alt = Date.valueOf(fecha);
                        empleado.setFecha_alt(fecha_alt);
                        System.out.println("Insete  el salario");
                        salario = sc.nextDouble();
                        empleado.setSalario(salario);
                        System.out.println("Inserte la comisión");
                        comision = sc.nextDouble();
                        empleado.setComision(comision);
                        System.out.println("Inserte el número del departamento");
                        dept_no = sc.nextInt();
                        empleado.setDept_no(dept_no);

                        emps.Create(empleado);

                        break;
                    case 6:                     //FUNCIONA
                        System.out.println("Vamos a crear un departamento.");
                        System.out.println("Primero el numero del departamento, seguido de un espacio y pones el nombre del departamento por ultimo pones una ',' y pones la localización.");

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
                        System.out.println("Inserte el número del empleado que quieres borrar");
                        emp_no = sc.nextInt();
                        emps.Delete(emp_no);
                        break;

                    case 8:                     //FUNCIONA
                        System.out.println("Inserte el número del departamento que quieres borrar");
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
}
