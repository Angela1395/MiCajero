package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.TextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

import Controlador.Central;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.Button;
import javax.swing.JSlider;
import javax.swing.JToggleButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	
	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setBounds(237, 92, 96, 19);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBackground(new Color(255, 250, 250));
		loginButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		loginButton.setBounds(245, 177, 109, 19);
		panel.add(loginButton);
		
		txtPassword = new JTextField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtPassword.setBounds(237, 121, 96, 19);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(139, 95, 67, 13);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPassword.setBounds(139, 124, 67, 13);
		panel.add(lblPassword);
		
		JLabel lblNewLabel_2 = new JLabel("MI CAJERO AUTOMATICO");
		lblNewLabel_2.setForeground(new Color(128, 0, 128));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Bodoni MT", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(10, 10, 476, 33);
		panel.add(lblNewLabel_2);
		
		JButton registrationButton = new JButton("Registrate");
		registrationButton.setBackground(new Color(255, 250, 250));
		registrationButton.setForeground(new Color(0, 0, 0));
		registrationButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		registrationButton.setBounds(137, 176, 85, 21);
		panel.add(registrationButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setForeground(new Color(255, 250, 250));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Angela\\Desktop\\ADA DAW\\programacion 1\u00BA rep\\programacion 3 tr\\Cajero\\Captura de pantalla 2021-05-10 123225.png"));
		btnNewButton_1.setBounds(437, 0, 59, 66);
		panel.add(btnNewButton_1);
		
		
		/* Acciones */
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Recoger los datos de los input
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				// Llamar al controlador para comprobar usuario
				boolean correcto = new Central().comprobarUsuario(username, password);
				// Controlar si es correcto o no
				if(correcto) {
					dispose(); // Cerrar la ventana sin cerrar la aplicacion
				}else {
					JOptionPane.showMessageDialog(null, "Usuario no valido");
				}
			}
		});
		
		registrationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Llamar al controlador para abrir la ventana de registro
				new Central().abrirFormulario();
			}
		});
	}
}
