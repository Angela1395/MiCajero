package Controlador;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import BBDD.Conexion;
import Beans.Movimiento;
import Beans.Usuario;
import Modelo.Movimientos;
import Modelo.Usuarios;
import Vista.ListaUsuarios;


public class Central {
	
	public boolean comprobarUsuario(String username, String password) {
		// Llamar al modelo para coger los datos de la base de datos
		Usuario usuario = new Usuarios().recogerUsuarioConContrasenia(username, password);
		if(usuario != null) {
			ArrayList<Usuario> usuarios = new Usuarios().recogerTodosUsuarios();
			new ListaUsuarios(usuarios); // Abrir la nueva ventana
			return true;
		}
		return false;
	}
	
	public boolean rellenarFormulario(String username, String password) {
		// Llamar al modelo con los datos a insertar
		Usuario usuario = new Usuario(username, password, 0);
		return new Usuarios().insertarUsuario(usuario);
	}
	
	public void abrirFormulario() {
		// Llamar al formulario y rellenar
		new Vista.FormularioUsuario();
	}
	
	public void abrirFicha(Usuario usuario) {
		ArrayList<Movimiento> movimientos = new Movimientos().recogerMovimientosUsuario(usuario);
		new Vista.FichaUsuario(usuario, movimientos);
	}
	
	public void realizarIngreso(Usuario usuario, int saldo) {
		String username = usuario.getUsername();
		Date fecha = new Date(System.currentTimeMillis());
		Movimiento movimiento = new Movimiento(username, fecha, saldo);
		new Movimientos().insertarMovimiento(movimiento);
	}
	
}
