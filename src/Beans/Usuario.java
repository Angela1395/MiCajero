package Beans;

import java.sql.Date;

public class Usuario {
	String username;
	String password;
	int saldo;
	
		public Usuario (String username, String password,int saldo) {
			this.username = username;
			this.password = password;
			this.saldo = saldo;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getSaldo() {
			return saldo;
		}
}


