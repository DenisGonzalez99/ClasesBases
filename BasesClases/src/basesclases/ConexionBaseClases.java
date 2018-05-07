package basesclases;


import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
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
       // departamento.setDept_no(1);
       // departamento.setDnombre("Denis");
       // departamento.setLoc("Madrid");
        /*
        Empleado empleado = new Empleado();
        empleado.setEmp_no(1);
        empleado.setApellido("Perez");
        empleado.setOficio("Madrid");
        empleado.setDir(5);
        
        empleado.setFecha_alt(Date.valueOf(LocalDate.MAX)); //ARREGLAR
        empleado.setSalario(1200);
        empleado.setComision(1);
        empleado.setDept_no(10);
        */

        Departamentos deps = new Departamentos();
        Empleados emps = new Empleados();
        /*
        try {
            
          // deps.Create(departamento);
        //  deps.Read("Denis");
          //  deps.Update(1, departamento);
            //deps.Delete(1);
         //emps.Create(empleado);
         // emps.Read("nombre");
       //  emps.Update(1, empleado);
       //emps.Delete(1);
        } catch(SQLException ex){
           System.out.println("Error al insertar: "+ex.getSQLState() + " "+ ex.getMessage());
       }   finally{
       try{
           deps.Close();
          } catch(SQLException ex){
              System.out.println("Error al cerrar BBDD: "+ex.getSQLState()+ " "+ ex.getMessage());
          }
        }
        */
        
        int opcion;
        boolean seguir = true;
        
        while(seguir){
            
        System.out.println("<------------------------------------------------------------>");
        System.out.println("<------------------------------------------------------------>");
        System.out.println("|A continuacion te voy a dar las opciones que pues escoger    |");
        System.out.println("|-------------------------------------------------------------|");
        System.out.println("|Pulsa (1) si quieres Listar departamentos                    |");
        System.out.println("|Pulsa (2) si quieres Listar empleados                        |");
        System.out.println("|Pulsa (3) si quires buscar un empleado por su nombre         |");
        System.out.println("|Pulsa (4) si quieres buscar un departamento por su nombre    |");
        System.out.println("|Pulsa (5) si quieres crear un empleado                       |");
        System.out.println("|Pulsa (6) si quieres crear un departamento                   |");  //FUNCIONA
        System.out.println("|Pulsa (7) si quieres borrar un empleado                      |");  //FUNCIONA
        System.out.println("|Pulsa (8) si quieres borrar un departamento                  |");  //FUNCIONA
        System.out.println("|Pulsa (0) si quieres salir                                   |");  //FUNCIONA
        System.out.println("<------------------------------------------------------------->");
        System.out.println("<------------------------------------------------------------->");

        
       opcion = sc.nextInt();

       
       switch(opcion){
	case 1:
		
            //
		break; 
	case 2:
		//
            break;
        case 3:
            
            System.out.println("Dinos el nombre del departamento");

            
            break;
        case 4:
            System.out.println("Dinos el nombre del departamento");
            String strings = sc.nextLine();
            String[] parts = strings.split("");
            String part1 = parts[0]; // dnombre
            
            deps.Read(parts[0]);                 
            
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
