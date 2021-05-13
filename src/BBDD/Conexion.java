package BBDD;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
	 static String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    static String dbName = "5Y1yYvV8n4";
	    static String host = "remotemysql.com";
	    static int port = 3306;
	    static String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName + timeZone;
	    static String user = "5Y1yYvV8n4";
	    static String pass = "OhPOO74e6J";
	    static String driver = "com.mysql.cj.jdbc.Driver";

	    static Connection conexion;
	    static Statement consulta;
	    static ResultSet resultado;
	    
	    public static void conectar(){
	    	try {
	        Class.forName(driver) ;
	        conexion = DriverManager.getConnection(url, user, pass);
	        System.out.println("Base de datos situada en :\n "+url);
	        consulta = conexion.createStatement();
	      }catch(Exception e){
	        JOptionPane.showMessageDialog(null, e.getMessage());
	        e.printStackTrace();
	      }
	    }
	    
	    public static ResultSet ejecutarSentencia(String sentencia){
	      try {
	        resultado = consulta.executeQuery(sentencia);
	      }catch(Exception e){
	        JOptionPane.showMessageDialog(null, e.getMessage());
	        System.out.println("Error: " + sentencia);
	      }
	      return resultado;
	    }
	      
	    public static boolean ejecutarUpdate(String sentencia){
	    	try{
	    		consulta.executeUpdate(sentencia);
	    		System.out.println("Done: " + sentencia);
	    		return true;
	    	}catch(SQLException e){
	    		JOptionPane.showMessageDialog(null, e.getMessage());
		        System.out.println("Error: " + sentencia);
		        return false;
	    	} 
	    }
	    
	    public static void EjecutarUpdateEliminar(String Sentencia){
	        try{
	            consulta.executeUpdate(Sentencia);
	            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente.");
	            System.out.println("Done.");
	        }catch(SQLException e){
	            JOptionPane.showMessageDialog(null, e.getMessage());
	            JOptionPane.showMessageDialog(null, "No se ha eliminado.");
	        } 
	    }
	    
	    public static void cerrar(){
	      try{
	        consulta.close();
	      }catch(Exception e){}
	    }
}
