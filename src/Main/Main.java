package Main;

import java.awt.EventQueue;
import BBDD.Conexion;
import Vista.Principal;

public class Main {
	public static void main(String[] args) {
		Conexion.conectar();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
