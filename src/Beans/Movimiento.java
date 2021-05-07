package Beans;
import java.sql.Date;

public class Movimiento {
	String usuario;
	Date fecha;
	int ingreso;

	public Movimiento (String usuario, Date fecha, int ingreso) {
		this.usuario = usuario;
		this.fecha = fecha;
		this.ingreso = ingreso;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha( Date fecha) {
		this.fecha = fecha;
	}
	public int getIngreso() {
		return ingreso;
	}
}
