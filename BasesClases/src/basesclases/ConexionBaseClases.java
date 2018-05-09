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

                System.out.println("<---------------------------------------------------------------------------------------->");
                System.out.println("<|--------------------------------------------------------------------------------------|>");
                System.out.println("||            <<A continuacion te voy a dar las opciones que pues escoger>>             ||");
                System.out.println("||--------------------------------------------------------------------------------------||");
                System.out.println("||Pulsa (1)           >>>>>> si quieres Listar departamentos <<<<<<<                    ||");  //FUNCIONA
                System.out.println("||Pulsa (2)           >>>>>> si quieres Listar empleados <<<<<<<                        ||");  //Funciona
                System.out.println("||Pulsa (3)           >>>>>> si quieres buscar un empleado por su nombre <<<<<<<        ||");  //FUNCIONA
                System.out.println("||Pulsa (4)           >>>>>> si quieres buscar un departamento por su nombre <<<<<<<    ||");  //FUNCIONA
                System.out.println("||Pulsa (5)           >>>>>> si quieres crear un empleado <<<<<<<                       ||");  //FUNCIONA
                System.out.println("||Pulsa (6)           >>>>>> si quieres crear un departamento <<<<<<<                   ||");  //FUNCIONA
                System.out.println("||Pulsa (7)           >>>>>> si quieres borrar un empleado <<<<<<<                      ||");  //FUNCIONA
                System.out.println("||Pulsa (8)           >>>>>> si quieres borrar un departamento <<<<<<<                  ||");  //FUNCIONA
                System.out.println("||Pulsa (0)           >>>>>> si quieres salir <<<<<<<                                   ||");  //FUNCIONA
                System.out.println("<|--------------------------------------------------------------------------------------|>");
                System.out.println("<---------------------------------------------------------------------------------------->");

                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("<---------------------------------------------------------------------------------------->");
                        System.out.println("<|--------------------------------------------------------------------------------------|>");
                        System.out.println("||            <<A continuacion te voy a dar las opciones que pues escoger>>             ||");
                        System.out.println("||--------------------------------------------------------------------------------------||");
                        System.out.println("||Pulsa (1)           >>>>>> si quieres listar un departamento<<<<<<<                   ||");        //funciona
                        System.out.println("||Pulsa (2)           >>>>>> si quieres Listar tosdos los departamentos<<<<<<<          ||");        //funciona
                    //    System.out.println("||Pulsa (3)           >>>>>> si quieres Salir de este menú<<<<<<<                       ||");        //funciona

                        System.out.println("<|--------------------------------------------------------------------------------------|>");
                        System.out.println("<---------------------------------------------------------------------------------------->");
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

                                System.out.printf("|%10d |%-20s |%-15s |%n", departamento.getDept_no(), departamento.getDnombre(), departamento.getLoc());
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
                        break;

                    case 2:
                        System.out.println("<---------------------------------------------------------------------------------------->");
                        System.out.println("<|--------------------------------------------------------------------------------------|>");
                        System.out.println("||            <<A continuacion te voy a dar las opciones que pues escoger>>             ||");
                        System.out.println("<|--------------------------------------------------------------------------------------|>");
                        System.out.println("||Pulsa (1)            >>>>>> si quieres listar un empleado<<<<<<<                      ||");//funciona
                        System.out.println("||Pulsa (2)            >>>>>> si quieres Listar tosdos los empleados<<<<<<<             ||");
                        System.out.println("<|--------------------------------------------------------------------------------------|>");
                        System.out.println("<---------------------------------------------------------------------------------------->");

                        opcion1 = sc.nextInt();
                        switch (opcion1) {
                            case 1:
                                System.out.println("Introduce el numero del empleado que quieras buscar");
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

                        System.out.println("Dinos el nombre del empleado");
                        apellido = sc.next();
                        empleado = emps.Read(apellido);

                        System.out.printf("+----------------------------------------------------------------------------------------------------------------------+ %n");
                        System.out.printf("|%-10s |%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%n", "Emp_no", "Apellido", "Oficio", "Dir", "Fecha", "Salario", "Comision", "dept_no");
                        System.out.printf("+----------------------------------------------------------------------------------------------------------------------+ %n");
                        System.out.printf("|%-10s |%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%n", empleado.getEmp_no(), empleado.getApellido(), empleado.getOficio(), empleado.getDir(), empleado.getFecha_alt(), empleado.getSalario(), empleado.getComision(), empleado.getDept_no());
                        System.out.printf("+----------------------------------------------------------------------------------------------------------------------+ %n");

                        break;
                    case 4:         //FUNCIONA
                        System.out.println("Dinos el nombre del departamento");
                        dnombre = sc.next();

                        departamento = deps.Read(dnombre);

                        System.out.printf("+--------------------------------------------------+ %n");
                        System.out.printf("|%-10s |%-20s |%-15s |%n", "Dpt_no", "Nom.Dep", "Ciudad");
                        System.out.printf("+--------------------------------------------------+ %n");

                        System.out.printf("|%-10d |%-20s |%-15s |%n", departamento.getDept_no(), departamento.getDnombre(), departamento.getLoc());
                        System.out.printf("+--------------------------------------------------+ %n");
                        break;
                    case 5:
                        System.out.println("Vamos a crear un empleado");
                        System.out.println("Primero inserta el emp_no");
                        emp_no = sc.nextInt();
                        empleado.setEmp_no(emp_no);
                        System.out.println("Ahora mete el apellido seguido de una ',' y luego la oficina");
                        System.out.println("Recuerda que la fecha se tiene que poner asi: yyyy-mm-dd");
                        String strin = sc.next();
                        String[] partsss = strin.split(",");
                        String partemp11 = partsss[0]; // apellido
                        String partemp2 = partsss[1]; // oficina                      
                        empleado.setApellido(partsss[0]);
                        empleado.setOficio(partsss[1]);
                        System.out.println("Ahora dinos el dir");
                        System.out.println("Recuerda que el dir tiene que coincidir con otro empleado");
                        dir = sc.nextInt();
                        empleado.setDir(dir);
                        System.out.println("Ahora dinos su fecha");
                        String fecha = sc.next();       //cREO UNA VARIABLE NUEVA PARA LA FECHA
                        fecha_alt = Date.valueOf(fecha);
                        empleado.setFecha_alt(fecha_alt);
                        System.out.println("Ahora el salario");
                        salario = sc.nextDouble();
                        empleado.setSalario(salario);
                        System.out.println("Ahora la comision");
                        comision = sc.nextDouble();
                        empleado.setComision(comision);
                        System.out.println("Ahora el dpt_no");
                        dept_no = sc.nextInt();
                        empleado.setDept_no(dept_no);

                        emps.Create(empleado);

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
