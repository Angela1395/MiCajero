package Modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BBDD.Conexion;
import Beans.Movimiento;
import Beans.Usuario;

public class Movimientos {
	
	public void insertarMovimiento(Movimiento movimiento) {
		String usuario = movimiento.getUsuario();
		Date fecha = movimiento.getFecha();
		int saldo = movimiento.getIngreso();
		
		Conexion.ejecutarUpdate("insert into Movimientos (Usuario, Fecha, Saldo) values ('"+usuario+"', '" + fecha.toString() + "', "+saldo+");");
	}
	public Movimiento recogerMovimiento(String usuarioMovimiento) {
		ResultSet resultado = Conexion.ejecutarSentencia("select * from movimientos where username='"+usuarioMovimiento+"';");
		try {
			if(resultado.next()) {
				int ingreso = resultado.getInt("ingreso");
				String usuario = resultado.getString("usuario");
				Date fecha = resultado.getDate("fecha");
				Movimiento movimientoRecogido = new Movimiento(usuario, fecha, ingreso);
				return movimientoRecogido;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Movimiento> recogerTodosMovimientos(){
		ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
		ResultSet resultado = Conexion.ejecutarSentencia("SELECT * FROM movimientos;");
		try {
			while(resultado.next()) {
				int ingreso = resultado.getInt("ingreso");
				String usuario = resultado.getString("usuario");
				Date fecha = resultado.getDate("fecha");
				movimientos.add(new Movimiento(usuario, fecha, ingreso));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return movimientos;
	}
	
	public ArrayList<Movimiento> recogerMovimientosUsuario(Usuario usuario){
		ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
		ResultSet resultado = Conexion.ejecutarSentencia("SELECT * FROM Movimientos WHERE Usuario='"+usuario.getUsername()+"'");
		try {
			while(resultado.next()) {
				String user = resultado.getString("Usuario");
				Date fecha = resultado.getDate("Fecha");
				int saldo = resultado.getInt("Saldo");
				movimientos.add(new Movimiento(user, fecha, saldo));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return movimientos;
	}
}
