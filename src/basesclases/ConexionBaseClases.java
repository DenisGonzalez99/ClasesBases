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

        //Connection conexion;
        //Statement sentencia = null;
        try {
            int opcion;
            boolean seguir = true;
            int opcion1;
            while (seguir) {
                /**
                 * ************************************ Menú
                 */////////////////////////////////////////
                //Acabará cuando el cliente pulse la tecla 0
                System.out.println("<---------------------------------------------------------------------------------------->");
                System.out.println("<|--------------------------------------------------------------------------------------|>");
                System.out.println("<|                                      <<Menú>>                                        |>");
                System.out.println("<|--------------------------------------------------------------------------------------|>");
                System.out.println("║Pulsa (1)           >>>>>>Listar departamentos <<<<<<<                                 ║");
                System.out.println("║Pulsa (2)           >>>>>>Listar empleados <<<<<<<                                     ║");
                System.out.println("║Pulsa (3)           >>>>>>Buscar empleado por su nombre <<<<<<<                        ║");
                System.out.println("║Pulsa (4)           >>>>>>buscar departamento por su nombre <<<<<<<                    ║");
                System.out.println("║Pulsa (5)           >>>>>>Crear un empleado <<<<<<<                                    ║");
                System.out.println("║Pulsa (6)           >>>>>>Crear un departamento <<<<<<<                                ║");
                System.out.println("║Pulsa (7)           >>>>>>Borrar un empleado <<<<<<<                                   ║");
                System.out.println("║Pulsa (8)           >>>>>>Borrar un departamento <<<<<<<                               ║");
                System.out.println("║Pulsa (0)           >>>>>>Salir <<<<<<<                                                ║");
                System.out.println("<|--------------------------------------------------------------------------------------|>");
                System.out.println("<---------------------------------------------------------------------------------------->");

                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("<---------------------------------------------------------------------------------------->");
                        System.out.println("<|--------------------------------------------------------------------------------------|>");
                        System.out.println("||                           <<Menú de Listar departamentos>>                           ||");
                        System.out.println("||--------------------------------------------------------------------------------------||");
                        System.out.println("║║Pulsa (1)           >>>>>>Listar un departamento<<<<<<<                                ║║");
                        System.out.println("║║Pulsa (2)           >>>>>>Listar tosdos los departamentos<<<<<<<                       ║║");
                        System.out.println("<|--------------------------------------------------------------------------------------|>");
                        System.out.println("<---------------------------------------------------------------------------------------->");
                        opcion1 = sc.nextInt();
                        switch (opcion1) {
                            case 1:
                                System.out.println("Inserte el número del departamento que quieras buscar");
                                dept_no = sc.nextInt();
                                departamento = deps.ReadNum(dept_no);
                                // Cabecera
                                System.out.printf("+--------------------------------------------------+ %n");
                                System.out.printf("|%-10s |%-20s |%-15s |%n", "Dpt_no", "Nom.Dep", "Ciudad");
                                System.out.printf("+--------------------------------------------------+ %n");
                                //Imprime el departamento
                                System.out.printf("|%-10d |%-20s |%-15s |%n", departamento.getDept_no(), departamento.getDnombre(), departamento.getLoc());
                                System.out.printf("+--------------------------------------------------+ %n");
                                break;

                            case 2:
                                ArrayList<Departamento> departamentosAL = new ArrayList<>();
                                departamentosAL = deps.ReadTodos();
                                System.out.printf("+--------------------------------------------------+ %n");
                                System.out.printf("|%-10s |%-20s |%-15s |%n", "Dpt_no", "Nom.Dep", "Ciudad");
                                System.out.printf("+--------------------------------------------------+ %n");
                                //Recorre el array e imprime
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
                                System.out.println("Inserte el número del empleado que quieras buscar");
                                emp_no = sc.nextInt();      //Introducimos el emp_no por teclado
                                empleado = emps.ReadNum(emp_no);        //Llamamos al metodo

                                //Imprimimos la respuesta
                                System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");
                                System.out.printf("|%-10s |%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%n", "Emp_no", "Apellido", "Oficio", "Dir", "Fecha", "Salario", "Comision", "dept_no");
                                System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");
                                System.out.printf("|%-10s |%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%n", empleado.getEmp_no(), empleado.getApellido(), empleado.getOficio(), empleado.getDir(), empleado.getFecha_alt(), empleado.getSalario(), empleado.getComision(), empleado.getDept_no());
                                System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");

                                break;

                            case 2:
                                ArrayList<Empleado> empleadosAL = new ArrayList<>();        //Creamos ArrayList
                                empleadosAL = emps.ReadTodos();
                                //Cabecera
                                System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");
                                System.out.printf("|%-10s |%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%n", "Emp_no", "Apellido", "Oficio", "Dir", "Fecha", "Salario", "Comision", "dept_no");
                                System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");

                                for (int i = 0; i < empleadosAL.size(); i++) {      //Imprimimos el array
                                    System.out.printf("|%-10s |%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%n", empleadosAL.get(i).getEmp_no(), empleadosAL.get(i).getApellido(), empleadosAL.get(i).getOficio(), empleadosAL.get(i).getDir(), empleadosAL.get(i).getFecha_alt(), empleadosAL.get(i).getSalario(), empleadosAL.get(i).getComision(), empleadosAL.get(i).getDept_no());
                                }
                                System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");

                                break;
                        }

                        break;
                    case 3:

                        System.out.println("Inserte el apellido del empleado que quieres buscar");
                        apellido = sc.next();       //Apellido por teclado
                        ArrayList<Empleado> empleadosAL = new ArrayList<>();
                        empleadosAL = emps.ReadTodosNombre(apellido);       //Llamamos al metodo
                        System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");
                        System.out.printf("|%-10s |%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%n", "Emp_no", "Apellido", "Oficio", "Dir", "Fecha", "Salario", "Comision", "dept_no");
                        System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");

                        for (int i = 0; i < empleadosAL.size(); i++) {      //Imprimimos el array
                            System.out.printf("|%-10s |%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%n", empleadosAL.get(i).getEmp_no(), empleadosAL.get(i).getApellido(), empleadosAL.get(i).getOficio(), empleadosAL.get(i).getDir(), empleadosAL.get(i).getFecha_alt(), empleadosAL.get(i).getSalario(), empleadosAL.get(i).getComision(), empleadosAL.get(i).getDept_no());
                        }
                        System.out.printf("+---------------------------------------------------------------------------------------------------------------------------------------+ %n");

                        break;
                    case 4:
                        System.out.println("Inserte el nombre del departamento que quieres buscar");
                        dnombre = sc.next();

                        ArrayList<Departamento> departamentosAL = new ArrayList<>();
                        departamentosAL = deps.ReadTodosNombre(dnombre);        //Llamamos al metodo
                        //Cabecera
                        System.out.printf("+--------------------------------------------------+ %n");
                        System.out.printf("|%-10s |%-20s |%-15s |%n", "Dpt_no", "Nom.Dep", "Ciudad");
                        System.out.printf("+--------------------------------------------------+ %n");
                        for (int i = 0; i < departamentosAL.size(); i++) {  //Imprimimos el Array
                            System.out.printf("|%10d |%-20s |%-15s |%n", departamentosAL.get(i).getDept_no(), departamentosAL.get(i).getDnombre(), departamentosAL.get(i).getLoc());
                        }
                        System.out.printf("+--------------------------------------------------+ %n");
                        break;
                    case 5:     //Leemos por teclado todos los datos del empleado
                        System.out.println("Vamos a crear un empleado");
                        System.out.print("Inserte el número del empleado---->");
                        emp_no = sc.nextInt();
                        empleado.setEmp_no(emp_no);
                        System.out.print("Introduce el apellido seguido de una ',' y luego el oficio---->");
                        String strin = sc.next();
                        String[] partsss = strin.split(",");
                        String partemp11 = partsss[0]; // apellido
                        String partemp2 = partsss[1]; // oficina                      
                        empleado.setApellido(partsss[0]);
                        empleado.setOficio(partsss[1]);
                        System.out.println("Introduce  el dir");
                        System.out.print("Recuerda que el dir tiene que coincidir con otro empleado---->");
                        dir = sc.nextInt();
                        empleado.setDir(dir);
                        System.out.println("Introduce su fecha de contratación");
                        System.out.print("Recuerda que la fecha se tiene que poner asi: yyyy-mm-dd---->");
                        String fecha = sc.next();       //cREO UNA VARIABLE NUEVA PARA LA FECHA
                        fecha_alt = Date.valueOf(fecha);
                        empleado.setFecha_alt(fecha_alt);
                        System.out.print("Insete  el salario---->");
                        salario = sc.nextDouble();
                        empleado.setSalario(salario);
                        System.out.print("Inserte la comisión---->");
                        comision = sc.nextDouble();
                        empleado.setComision(comision);
                        System.out.print("Inserte el número del departamento---->");
                        dept_no = sc.nextInt();
                        empleado.setDept_no(dept_no);

                        emps.Create(empleado);
                        System.out.println("Empleado creado con exito");

                        break;
                    case 6:                     //Leemos por teclado los datos del departamento
                        System.out.println("Vamos a crear un departamento.");
                        System.out.println("Primero el numero del departamento");
                        System.out.println("Seguido de un espacio y pones el nombre del departamento separado por una ',' y tecleas la localizacion---->");
                        dept_no = sc.nextInt();
                        departamento.setDept_no(dept_no);

                        String string = sc.nextLine();
                        String[] partss = string.split(",");
                        String part11 = partss[0]; // dnombre
                        String part2 = partss[1]; // loc                      
                        departamento.setDnombre(partss[0]);
                        departamento.setLoc(partss[1]);

                        deps.Create(departamento);
                        System.out.println("Departamento creado con exito");

                        break;

                    case 7:
                        System.out.println("Inserte el número del empleado que quieres borrar");
                        emp_no = sc.nextInt();
                        emps.Delete(emp_no);        //Llamamos al metodo de borrar empleado
                        System.out.println("Empleado borrado con exito");
                        break;

                    case 8:
                        System.out.println("Inserte el número del departamento que quieres borrar");
                        dept_no = sc.nextInt();
                        deps.Delete(dept_no);       //Llamamos al metodo de borrar departamento
                        System.out.println("Departamento borrado con exito");

                        break;
                    case 0:            //Salir
                        seguir = false;
                        break;

                }
            }
        } catch (SQLException ex) {     //Control de errores
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
