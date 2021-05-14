package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.sql.Date;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Beans.Movimiento;
import Beans.Usuario;
import Controlador.Central;

import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FichaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	int ingreso = 0;
	int gasto = 0;

	/**
	 * Create the frame.
	 */
	public FichaUsuario(Usuario usuario, ArrayList<Movimiento> movimientos) {
		setTitle(usuario.getUsername());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(usuario.getSaldo() +  " \u20AC");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(62, 30, 495, 26);
		panel.add(lblNewLabel);
		
		JLabel labelIngreso = new JLabel("X \u20AC");
		labelIngreso.setHorizontalAlignment(SwingConstants.CENTER);
		labelIngreso.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		labelIngreso.setForeground(new Color(0, 128, 0));
		labelIngreso.setBounds(89, 55, 111, 35);
		panel.add(labelIngreso);
		
		JLabel labelGasto = new JLabel("X \u20AC");
		labelGasto.setHorizontalAlignment(SwingConstants.CENTER);
		labelGasto.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		labelGasto.setForeground(new Color(255, 0, 0));
		labelGasto.setBounds(393, 45, 131, 54);
		panel.add(labelGasto);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(213, 112, 178, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton botonIngreso = new JButton("Ingreso");
		botonIngreso.setFont(new Font("Times New Roman", Font.BOLD, 12));
		botonIngreso.setBackground(new Color(255, 250, 250));
		botonIngreso.setBounds(89, 111, 85, 21);
		panel.add(botonIngreso);
		
		JButton botonGasto = new JButton("Gasto\r\n");
		botonGasto.setForeground(new Color(0, 0, 0));
		botonGasto.setFont(new Font("Times New Roman", Font.BOLD, 12));
		botonGasto.setBackground(new Color(255, 250, 250));
		botonGasto.setBounds(424, 111, 85, 21);
		panel.add(botonGasto);
		
		table = new JTable();
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("fecha");
		dtm.addColumn("saldo");
		for(Movimiento movimiento: movimientos) {
			Object[] fila = new Object[3];
			fila[0] = movimiento.getFecha();
			fila[1] = movimiento.getIngreso();
			dtm.addRow(fila);			
		}
		table.setModel(dtm);
		table.setBounds(52, 171, 521, 266);
		panel.add(table);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\Angela\\Desktop\\ADA DAW\\programacion 1\u00BA rep\\programacion 3 tr\\Cajero\\Captura de pantalla 2021-05-10 123225.png"));
		btnNewButton_1_1.setForeground(new Color(255, 250, 250));
		btnNewButton_1_1.setBounds(547, 0, 59, 66);
		panel.add(btnNewButton_1_1);
		
		this.setVisible(true);
		
		/* OPERACIONES */
		
		for(Movimiento movimiento: movimientos) {
			int saldo = movimiento.getIngreso();
			if(saldo > 0) {
				ingreso += saldo;
			}else {
				gasto += saldo;
			}
			
		}
		labelIngreso.setText(ingreso + " \u20AC");
		labelGasto.setText(gasto + " \u20AC");
		
		
		/* ACCIONES */
		
		botonIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int saldo = Integer.parseInt(textField.getText());
				new Central().realizarIngreso(usuario, saldo);
				Object[] fila = new Object[2];
				fila[0] = (new Date(System.currentTimeMillis())).toString();
				fila[1] = saldo;
				dtm.addRow(fila);
				ingreso += saldo;
				labelIngreso.setText(ingreso + " \u20AC");
			}
		});
		
		botonGasto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int saldo = -1 * Integer.parseInt(textField.getText());
				new Central().realizarGasto(usuario, saldo);
				Object[] fila = new Object[2];
				fila[0] = (new Date(System.currentTimeMillis())).toString();
				fila[1] = saldo;
				dtm.addRow(fila);
				gasto += saldo;
				labelGasto.setText(gasto + " \u20AC");
			}
		});
	}

}
