package Vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import Beans.Usuario;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import Controlador.Central;

public class ListaUsuarios extends JFrame {

	private JPanel contentPane;
	private JTable Usuarios;

	/**
	 * Create the frame.
	 */
	public ListaUsuarios(ArrayList<Usuario> usuarios) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Usuarios = new JTable();
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("nombre");
		dtm.addColumn("saldo");
		for(Usuario usuario: usuarios) {
			Object[] fila = new Object[3];
			fila[0] = usuario.getUsername();
			fila[1] = usuario.getSaldo();
			dtm.addRow(fila);			
		}
		Usuarios.setModel(dtm);
		Usuarios.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 128), new Color(0, 0, 128), new Color(0, 0, 128), new Color(0, 0, 128)));
		Usuarios.setBackground(new Color(248, 248, 255));
		Usuarios.setColumnSelectionAllowed(true);
		Usuarios.setBounds(20, 33, 266, 193);
		panel.add(Usuarios);

		JButton VerButton = new JButton("Ver");
		VerButton.setBackground(new Color(255, 250, 250));
		VerButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		VerButton.setForeground(new Color(0, 0, 0));
		VerButton.setBounds(317, 174, 85, 21);
		panel.add(VerButton);
		
		JButton EliminarButton = new JButton("Borrar");
		EliminarButton.setBackground(new Color(255, 250, 250));
		EliminarButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		EliminarButton.setBounds(317, 205, 85, 21);
		panel.add(EliminarButton);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(new Color(128, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(69, 20, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Saldo");
		lblNewLabel_1.setForeground(new Color(128, 0, 128));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(194, 20, 52, 13);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\Angela\\Desktop\\ADA DAW\\programacion 1\u00BA rep\\programacion 3 tr\\Cajero\\Captura de pantalla 2021-05-10 123225.png"));
		btnNewButton_1_1.setForeground(new Color(255, 250, 250));
		btnNewButton_1_1.setBounds(367, 0, 59, 66);
		panel.add(btnNewButton_1_1);
		
		this.setVisible(true);
	
		/* Acciones */
		VerButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int i = Usuarios.getSelectedRow(); // Numero de la fila seleccionada
			Usuario usuario = usuarios.get(i);
			new Central().abrirFicha(usuario);
			}
		});
		
		EliminarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = Usuarios.getSelectedRow(); // Numero de la fila seleccionada
				Usuario usuario = usuarios.get(i);
				new Central().eliminar(usuario);
			}
		});
		
	}
	
}
