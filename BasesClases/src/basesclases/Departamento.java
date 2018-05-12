/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basesclases;

/**
 *
 * @author Usuario 1 DAM
 */
public class Departamento {     //Declaramos las variables del departamento
     public int dept_no;
     public String dnombre;
     protected String loc;

    public Departamento() {
    }

    public Departamento(int dept_no, String dnombre, String loc) {
        this.dept_no = dept_no;
        this.dnombre = dnombre;
        this.loc = loc;
   
<<<<<<< HEAD
    } 
=======
    }
    
>>>>>>> 5a227b6f8d7dd660a57bea78f19de8eded5cf7ba
    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }    
}
