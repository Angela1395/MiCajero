package Controlador;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import BBDD.Conexion;
import Beans.Usuario;
import Modelo.Usuarios;
import Vista.ListaUsuarios;


public class Central {
	
	public boolean comprobarUsuario(String username, String password) {
		// Llamar al modelo para coger los datos de la base de datos
		Usuario usuario = new Usuarios().recogerUsuarioConContrasenia(username, password);
		if(usuario != null) {
			new ListaUsuarios(); // Abrir la nueva ventana
			return true;
		}
		return false;
	}
	
	public boolean rellenarFormulario(String username, String password) {
		// Llamar al formulario y rellenar
		return true;
	}
	
	public void abrirFormulario() {
		// Llamar al formulario y rellenar
		new Vista.FormularioUsuario();
	}
	
}
