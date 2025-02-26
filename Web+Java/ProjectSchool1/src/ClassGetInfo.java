/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TopLapTop
 */
public class ClassGetInfo {
   private String Name;
     private String Subject;
       private String Degree;
        private int ID;

    public ClassGetInfo(String Name, String Subject, String Degree, int ID) {
        this.Name = Name;
        this.Subject = Subject;
        this.Degree = Degree;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

  

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public void setDegree(String Degree) {
        this.Degree = Degree;
    }

    public String getName() {
        return Name;
    }

    public String getSubject() {
        return Subject;
    }

    public String getDegree() {
        return Degree;
    }
    
    
}
