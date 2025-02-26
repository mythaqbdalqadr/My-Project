/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TopLapTop
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class DataBase {
  
 public static Connection GetConection() throws SQLException, ClassNotFoundException{
    Class.forName("oracle.jdbc.OracleDriver");
   String Url="jdbc:oracle:thin:@localhost:1521:orcl";
   String UserName="Project";
   String Password="Project";
      
   return DriverManager.getConnection( Url,UserName,Password);
      
 }
 public  static void AddStudent(String FirstName,String MidName,String LastName,String Gender
         ,int IsActive,Date BirthDate,String BirthPlace,String Img ) throws SQLException, ClassNotFoundException{

     Connection conn=DataBase.GetConection();
     String query=" insert into Student(StudentID,F_Name,M_Name,E_Name,Gender,IsActive,BirthDate,BirthPlace,Img) values(sqStudent.NEXTVAL,?,?,?,?,?,?,?,?)";
     PreparedStatement st=conn.prepareStatement(query);
   //st.setInt(1,ID);
     st.setString(1, FirstName);
          st.setString(2, MidName);
               st.setString(3, LastName);
                    st.setString(4, Gender);
                         st.setInt(5, IsActive);
                             st.setDate(6, BirthDate);
                                   st.setString(7, BirthPlace);
     st.setString(8, Img);
     st.executeUpdate();
     
     
 }
 public static ArrayList<Student> GetStudents() throws SQLException, ClassNotFoundException{
     ArrayList<Student>ss=new ArrayList<>();
     Connection conn=DataBase.GetConection();
          String query="select * from Student  order by STUDENTID";
     PreparedStatement st=conn.prepareStatement(query);
     ResultSet R=st.executeQuery(query);
     while(R.next()){
        int ID=R.getInt(1);
        String FirstName=R.getString(2);
        String MidName=R.getString(3);
        String LastName=R.getString(4);
        String Gender=R.getString(5);
        int IsActive=R.getInt(6);
        String BirthDate=R.getString(7);
        String BirthPlace =R.getString(8);
        String Img=R.getString(9);
        Student s=new Student(ID, FirstName, MidName, LastName, BirthDate, BirthPlace, Gender,String.valueOf( IsActive), Img);
         ss.add(s);
         
     }
     
    return ss; 
  
     
 }

 public static void DeleteStudent(int ID) throws SQLException, ClassNotFoundException{
   Connection conn=DataBase.GetConection();
   
   String query="delete from Student WHERE StudentID=?";
   
   PreparedStatement st=conn.prepareStatement(query);
     st.setInt(1, ID);
     st.executeUpdate();
     
     
 }
 public static void UpdateStudent(int ID,String FirstName,String MidName,String LastName,String Gender
         ,int IsActive,Date BirthDate,String BirthPlace,String Img) throws SQLException, ClassNotFoundException{
        Connection conn=DataBase.GetConection();
       
   String query=" update Student set  F_NAME=?, M_NAME=?, E_NAME=?, GENDER=?, ISACTIVE=?, BIRTHDATE=?, BIRTHPLACE=?, IMG=? where StudentID=?";
   PreparedStatement st=conn.prepareStatement(query);
     st.setString(1,FirstName );
        st.setString(2,MidName );
           st.setString(3,LastName );
            st.setString(4,Gender );
             st.setInt(5,IsActive );
              st.setDate(6,BirthDate );
               st.setString(7,BirthPlace );
                st.setString(8,Img );
                 st.setInt(9,ID );
     st.executeUpdate();
     
 }
    public static Student SearchStudentByID(int ID) throws SQLException,
            ClassNotFoundException{
         Connection conn=DataBase.GetConection();
          String query="select * from Student where StudentID="+ID;//+ID;//+ID;
     PreparedStatement st=conn.prepareStatement(query);
     //st.setInt(1,ID);
     ResultSet R1=st.executeQuery(query);
     while(R1.next()){
        int IDs=R1.getInt(1);
        String FirstName=R1.getString(2);
        String MidName=R1.getString(3);
        String LastName=R1.getString(4);
        String Gender=R1.getString(5);
        int IsActive=R1.getInt(6);
        String BirthDate=R1.getString(7);
        String BirthPlace =R1.getString(8);
        String Img=R1.getString(9);
        Student s=new Student(IDs, FirstName, MidName, LastName, BirthDate, BirthPlace, Gender,String.valueOf( IsActive), Img);
         return s;
         
     }
     return null;
    }
    
   public static  Student SearchStudentByName(String Name) throws SQLException, ClassNotFoundException{
             Connection conn=DataBase.GetConection();
          String query="select * from Student where F_NAME ||' '||M_Name ||' '||E_NAME ='"+Name+"'";//+ID;//+ID;
     PreparedStatement st=conn.prepareStatement(query);
     //st.setInt(1,ID);
     ResultSet R1=st.executeQuery(query);
     while(R1.next()){
        int IDs=R1.getInt(1);
        String FirstName=R1.getString(2);
        String MidName=R1.getString(3);
        String LastName=R1.getString(4);
        String Gender=R1.getString(5);
        int IsActive=R1.getInt(6);
        String BirthDate=R1.getString(7);
        String BirthPlace =R1.getString(8);
        String Img=R1.getString(9);
        Student s=new Student(IDs, FirstName, MidName, LastName, BirthDate, BirthPlace, Gender,String.valueOf( IsActive), Img);
         return s;
         
     }
  
       
       
     return null;
       
   }
    
    
   
   public static void AddSubject(String Name,String Img,String Mints) throws SQLException, ClassNotFoundException{
          Connection conn=DataBase.GetConection();
     String query="insert into Subjects ( SUBJECTID, SUBJECTNAME, IMG, MINTS) values(sqSubject.NEXTVAL,?,?,?)";
     PreparedStatement st=conn.prepareStatement(query);
     st.setString(1, Name);
      st.setString(2, Img);
       st.setString(3, Mints);
       st.executeUpdate();
       
       
       
       
   }
    public static ArrayList<Subjects> GetSubject() throws SQLException, ClassNotFoundException{
        ArrayList<Subjects>ss=new ArrayList<>();
          Connection conn=DataBase.GetConection();
     String query="select * from Subjects order by SUBJECTID";
     PreparedStatement st=conn.prepareStatement(query);   
        ResultSet r=st.executeQuery(query);
        while(r.next()){
          int ID=r.getInt(1);
          String Name=r.getString(2);
          String Img=r.getString(3);
       String Mints=r.getString(4);
       Subjects s=new Subjects(ID, Name, Mints, Img);
       ss.add(s);
          
            
            
            
            
        }
        
        
     return ss;
        
    }
   
 public static  void DeleteSubject(int ID) throws SQLException, ClassNotFoundException{
              Connection conn=DataBase.GetConection();
     String query="delete from Subjects where  SUBJECTID="+ID;
     PreparedStatement st=conn.prepareStatement(query);
     st.executeUpdate();
     
     
 }  
     public static void UpdateSubject(int ID,String Name,String Img,String Mints) throws SQLException, ClassNotFoundException{
          Connection conn=DataBase.GetConection();
     String query="Update Subjects set  SUBJECTNAME=?, IMG=?,MINTS=? where SubjectID =?";
     PreparedStatement st=conn.prepareStatement(query);
     st.setString(1, Name);
      st.setString(2, Img);
       st.setString(3, Mints);
         st.setInt(4, ID);
       st.executeUpdate();
       
       
       
       
   }
 
 
   public static Subjects SearchSubjectByID(int ID) throws SQLException, ClassNotFoundException{
      Connection conn=DataBase.GetConection();
     String query="select * from Subjects WHERE SubjectID="+ID;
     PreparedStatement st=conn.prepareStatement(query); 
      ResultSet s=st.executeQuery(query);
      while(s.next()){
       int Id=s.getInt(1);
       String Name=s.getString(2);
       String Img=s.getString(3);
       String Mint=s.getString(4);
          return new Subjects(Id, Name,Mint, Img);
          
          
      }
     return null;
       
       
   }
      public static Subjects SearchSubjectByName(String ID) throws SQLException, ClassNotFoundException{
      Connection conn=DataBase.GetConection();
     String query="select * from Subjects WHERE SubjectName='"+ID+"'";
     PreparedStatement st=conn.prepareStatement(query); 
      ResultSet s=st.executeQuery(query);
      while(s.next()){
       int Id=s.getInt(1);
       String Name=s.getString(2);
       String Img=s.getString(3);
       String Mint=s.getString(4);
          return new Subjects(Id, Name,Mint, Img);
          
          
      }
     return null;
       
       
   }
   
   public  static void AddTeacher(String FirstName,String MidName,String LastName,String Gender
         ,int IsActive,Date BirthDate,String BirthPlace,String Img ,String Degree) throws SQLException, ClassNotFoundException{

     Connection conn=DataBase.GetConection();
     String query=" insert into Teacher(TeacherID,F_Name,M_Name,E_Name,Gender,IsActive,BirthDate,BirthPlace,Img,DEGREE) values(sqTeacher.NEXTVAL,?,?,?,?,?,?,?,?,?)";
     PreparedStatement st=conn.prepareStatement(query);
   //st.setInt(1,ID);
     st.setString(1, FirstName);
          st.setString(2, MidName);
               st.setString(3, LastName);
                    st.setString(4, Gender);
                         st.setInt(5, IsActive);
                             st.setDate(6, BirthDate);
                                   st.setString(7, BirthPlace);
     st.setString(8, Img);
        st.setString(9, Degree);
     st.executeUpdate();
     
     
 }    
      
       public static ArrayList<Teachers> GetTeachers() throws SQLException, ClassNotFoundException{
     ArrayList<Teachers>ss=new ArrayList<>();
     Connection conn=DataBase.GetConection();
          String query="select * from Teacher  order by TeacherID";
     PreparedStatement st=conn.prepareStatement(query);
     ResultSet R=st.executeQuery(query);
     while(R.next()){
        int ID=R.getInt(1);
        String FirstName=R.getString(2);
        String MidName=R.getString(3);
        String LastName=R.getString(4);
        String Gender=R.getString(5);
        int IsActive=R.getInt(6);
        String BirthDate=R.getString(7);
        String BirthPlace =R.getString(8);
        String Img=R.getString(9);
        String Degree=R.getString(10);
        Teachers s=new Teachers(ID, FirstName, MidName, LastName, BirthDate, BirthPlace, Gender,String.valueOf( IsActive), Img,Degree);
         ss.add(s);
         
     }
     
    return ss; 
  
     
 }
      
      public static void DeleteTeacher(int ID) throws SQLException, ClassNotFoundException{
   Connection conn=DataBase.GetConection();
   String query="delete from Teacher WHERE TeacherID=?";
   PreparedStatement st=conn.prepareStatement(query);
     st.setInt(1, ID);
     st.executeUpdate();
     
     
 } 
       
        public static void UpdateTeacher(int ID,String FirstName,String MidName,String LastName,String Gender
         ,int IsActive,Date BirthDate,String BirthPlace,String Img,String Degree) throws SQLException, ClassNotFoundException{
        Connection conn=DataBase.GetConection();
       
   String query=" update Teacher set  F_NAME=?, M_NAME=?, E_NAME=?, GENDER=?, ISACTIVE=?, BIRTHDATE=?, BIRTHPLACE=?, IMG=?,Degree=? where TeacherID=?";
   PreparedStatement st=conn.prepareStatement(query);
     st.setString(1,FirstName );
        st.setString(2,MidName );
           st.setString(3,LastName );
            st.setString(4,Gender );
             st.setInt(5,IsActive );
              st.setDate(6,BirthDate );
               st.setString(7,BirthPlace );
                st.setString(8,Img );
                  st.setString(9,Degree);
                 st.setInt(10,ID );
     st.executeUpdate();
     
 }
       
         public static Teachers SearchTeacherByID(int ID) throws SQLException,
            ClassNotFoundException{
         Connection conn=DataBase.GetConection();
          String query="select * from Teacher where TeacherID="+ID;//+ID;//+ID;
     PreparedStatement st=conn.prepareStatement(query);
     //st.setInt(1,ID);
     ResultSet R1=st.executeQuery(query);
     while(R1.next()){
        int IDs=R1.getInt(1);
        String FirstName=R1.getString(2);
        String MidName=R1.getString(3);
        String LastName=R1.getString(4);
        String Gender=R1.getString(5);
        int IsActive=R1.getInt(6);
        String BirthDate=R1.getString(7);
        String BirthPlace =R1.getString(8);
        String Img=R1.getString(9);
        String Degree=R1.getString(10);
        Teachers s=new Teachers(IDs, FirstName, MidName, LastName, BirthDate, BirthPlace, Gender,String.valueOf( IsActive), Img,Degree);
         return s;
         
     }
     return null;
    }
      
    public static Teachers SearchTeacherByName(String ID) throws SQLException,
            ClassNotFoundException{
         Connection conn=DataBase.GetConection();
          String query="select * from Teacher where F_NAME ||' '||M_Name ||' '||E_NAME='"+ID+"'";//+ID;//+ID;
     PreparedStatement st=conn.prepareStatement(query);
     //st.setInt(1,ID);
     ResultSet R1=st.executeQuery(query);
     while(R1.next()){
        int IDs=R1.getInt(1);
        String FirstName=R1.getString(2);
        String MidName=R1.getString(3);
        String LastName=R1.getString(4);
        String Gender=R1.getString(5);
        int IsActive=R1.getInt(6);
        String BirthDate=R1.getString(7);
        String BirthPlace =R1.getString(8);
        String Img=R1.getString(9);
        String Degree=R1.getString(10);
        Teachers s=new Teachers(IDs, FirstName, MidName, LastName, BirthDate, BirthPlace, Gender,String.valueOf( IsActive), Img,Degree);
         return s;
         
     }
     return null;
    }
    
    public static void Teaching(int TeacherID,int SubjectID) throws SQLException, ClassNotFoundException{
           Connection conn=DataBase.GetConection();
     String query="insert into Teaching( TEACHERID,SUBJECTID, TEACHING_DATE) values(?,?,sysDate) ";
     PreparedStatement st=conn.prepareStatement(query); 
      st.setInt(1, TeacherID);
       st.setInt(2, SubjectID);
       st.executeUpdate();
    
    }
     
public static void Degree(int StudentID,int TeacherID,int SubjectID) throws SQLException, ClassNotFoundException{
      Connection conn=DataBase.GetConection();
     String query="insert into Gride (  GRIDES, STUDENTID, TEACHERID,SUBJECTID,REGISTER_DATE) "
             + "values(?,?,?,?,sysDate)";
     PreparedStatement st=conn.prepareStatement(query); 
     st.setInt(1, 0);
     st.setInt(2, StudentID);
      st.setInt(3, TeacherID);
       st.setInt(4, SubjectID);
      st.executeUpdate();
}

 public static int GetSubjectWithTeacher(int SubjectID) throws SQLException, ClassNotFoundException{
         Connection conn=DataBase.GetConection();
     String query="select * from Teaching    where SubjectID="+SubjectID;
     PreparedStatement st=conn.prepareStatement(query); 
   ResultSet r=st.executeQuery();
   while(r.next()){
      return r.getInt(1);
   }
     
     
     
     return -1;
     
     
     
 }   
   
 public static ArrayList<String>RegisterSubject() throws SQLException, ClassNotFoundException{
      ArrayList<String> S=new ArrayList<>();
       Connection conn=DataBase.GetConection();
     String query="select Subjects.SUBJECTNAME   from Subjects join Teaching on(Subjects.SUBJECTID=Teaching.SUBJECTID) Order by Subjects.SUBJECTNAME ";
     
     PreparedStatement st=conn.prepareStatement(query); 
   ResultSet r=st.executeQuery();
     while(r.next()){
        String Name=r.getString(1);
        S.add(Name);
 
     }
     
     
     return S;
     
     
     
 }
public static ArrayList<ClassGetInfo>GetAllDegree() throws SQLException, ClassNotFoundException{
         ArrayList<ClassGetInfo> S=new ArrayList<>();
       Connection conn=DataBase.GetConection();
     String query=" select distinct sd.F_NAME || ' ' || sd.M_NAME || ' ' ||sd.E_NAME as Name ,sb.SubjectName, g.GRIDES ,g.StudentID from " +
" Student sd join GRIDE g on(sd.StudentID=g.StudentID) join Subjects sb on(sb.SubjectID=g.SubjectID)";
     
     PreparedStatement st=conn.prepareStatement(query); 
   ResultSet r=  st.executeQuery(query);
   while(r.next()){
  ClassGetInfo f=new ClassGetInfo(r.getString(1),r.getString(2),r.getString(3),r.getInt(4));
      S.add(f);  
   }
     
     return S;
    
}
public static ArrayList<String> LoadSubjectToGiveDegree(int ID) throws SQLException, ClassNotFoundException{
    ArrayList<String> S=new ArrayList<>();
       Connection conn=DataBase.GetConection();
     String query=" select sb.SubjectName from  Student sd join Gride g on(sd.StudentID=g.StudentID) join Subjects sb on(sb.SubjectID=g.SubjectID) where sd.StudentID="+ID;
     
     PreparedStatement st=conn.prepareStatement(query); 
   
   ResultSet r=  st.executeQuery(query);
    while(r.next()){
     S.add(r.getString(1));
        
    }
    return S;
    
    
}
public static String GetNameStudentOfGride(int ID) throws SQLException, ClassNotFoundException{
   
       Connection conn=DataBase.GetConection();
     String query=" select sd.F_NAME || ' ' || sd.M_NAME || ' ' ||sd.E_NAME as Name from  Student sd join Gride g on(sd.StudentID=g.StudentID) join Subjects sb on(sb.SubjectID=g.SubjectID) where sd.StudentID="+ID;
     
     PreparedStatement st=conn.prepareStatement(query); 
   
   ResultSet r=  st.executeQuery(query);
    while(r.next()){
    return r.getString(1);
        
    }
    return "";
   
    
    
}

public static void AddDegree(int ID,String Subject,double Gride) throws SQLException, ClassNotFoundException{
    Subjects s=DataBase.SearchSubjectByName(Subject);
    int Id=s.getID();
    String query=" update  GRIDE set GRIDES=? where StudentID=? And SubjectID=?";
         Connection conn=DataBase.GetConection();
     
     PreparedStatement st=conn.prepareStatement(query); 
   st.setDouble(1, Gride);
   st.setInt(2, ID);
   st.setInt(3, Id);
   st.executeUpdate();
  
    
}


public static  ArrayList<ClassGetInfo> GetRepotOfStudent() throws SQLException, ClassNotFoundException{
   ArrayList<ClassGetInfo>S=new ArrayList<>();
         Connection conn=DataBase.GetConection();
       String query="  select distinct sd.F_NAME || ' ' || sd.M_NAME || ' ' || sd.E_NAME , sum(g.GRIDES),Avg(g.GRIDES)  from " +
"  Student sd join GRIDE g on(sd.StudentID=g.StudentID) group by sd.F_NAME || ' ' || sd.M_NAME || ' ' || sd.E_NAME  order by Avg(g.GRIDES) desc ";
     PreparedStatement st=conn.prepareStatement(query);
    ResultSet r=st.executeQuery(query);
    while(r.next()){
        ClassGetInfo e=new ClassGetInfo("", "", "", 0);
       e.setName(r.getString(1));
       e.setSubject(r.getString(2)); 
       e.setDegree(r.getString(3)); 
        S.add(e);
        
    }
    return S;
    
}


}

