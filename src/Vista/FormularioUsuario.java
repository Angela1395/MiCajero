package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Central;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FormularioUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwordField;

	/**
	 * Create the frame.
	 */
	public FormularioUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(127, 81, 70, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setBounds(127, 135, 70, 13);
		panel.add(lblNewLabel_1);
		
		JButton createButton = new JButton("Crear");
		createButton.setBackground(new Color(255, 250, 250));
		createButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		createButton.setBounds(160, 198, 130, 28);
		panel.add(createButton);
		
		usernameField = new JTextField();
		usernameField.setBounds(226, 78, 96, 19);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(226, 132, 96, 19);
		panel.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Inserte los datos del nuevo usuario");
		lblNewLabel_2.setForeground(new Color(128, 0, 128));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 20, 440, 19);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Angela\\Desktop\\ADA DAW\\programacion 1\u00BA rep\\programacion 3 tr\\Cajero\\Captura de pantalla 2021-05-10 123225.png"));
		btnNewButton_1.setForeground(new Color(255, 250, 250));
		btnNewButton_1.setBounds(401, 0, 59, 66);
		panel.add(btnNewButton_1);
		
		this.setVisible(true);
		
		/* Acciones */
		
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				boolean creado = new Central().rellenarFormulario(username, password);
				if(creado) {
					dispose();
				}
				
			}
		});
		
		
	}

}
