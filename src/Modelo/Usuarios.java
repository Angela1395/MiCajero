package Modelo;

import java.sql.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BBDD.Conexion;
import Beans.Usuario;



public class Usuarios {

	public void insertarUsuario(Usuario usuario) {
			String username = usuario.getUsername();
			String password = usuario.getPassword();
			Conexion.ejecutarUpdate("insert into Usuario (username, password) values ('"+username+"', '"+password+"');");
	}
	
	public Usuario recogerUsuarioConContrasenia(String username, String password) {
		ResultSet resultado = Conexion.ejecutarSentencia("select * from Usuario where username='"+username+"' AND password='"+password+"';");
		try {
			if(resultado.next()) {
				int saldo = resultado.getInt("saldo");
				String user = resultado.getString("username");
				String pass = resultado.getString("password");
				Usuario usuarioRecogido = new Usuario(user, pass, saldo);
				return usuarioRecogido;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Usuario recogerUsuario(String usernameUsuario) {
		ResultSet resultado = Conexion.ejecutarSentencia("select * from Usuario where username='"+usernameUsuario+"';");
		try {
			if(resultado.next()) {
				int saldo = resultado.getInt("saldo");
				String username = resultado.getString("username");
				String password = resultado.getString("password");
				Usuario usuarioRecogido = new Usuario(password, username, saldo);
				return usuarioRecogido;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Usuario> recogerTodosUsuarios(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ResultSet resultado = Conexion.ejecutarSentencia("SELECT * FROM Usuario	;");
		try {
			while(resultado.next()) {
				int saldo = resultado.getInt("saldo");
				String username = resultado.getString("username");
				String password = resultado.getString("password");
				usuarios.add(new Usuario(password, username, saldo));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
}

