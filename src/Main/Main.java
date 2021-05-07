package Main;

import java.awt.EventQueue;

import BBDD.Conexion;
import Vista.Login;

public class Main {
	public static void main(String[] args) {
		Conexion.conectar();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
