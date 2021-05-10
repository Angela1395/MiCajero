package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

public class FichaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public FichaUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X \u20AC");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(0, 27, 495, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("X \u20AC");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1.setBounds(75, 55, 111, 35);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("X \u20AC");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(313, 46, 131, 54);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(160, 112, 178, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ingreso");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(255, 250, 250));
		btnNewButton.setBounds(52, 111, 85, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gasto\r\n");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(255, 250, 250));
		btnNewButton_1.setBounds(359, 111, 85, 21);
		panel.add(btnNewButton_1);
		
		table = new JTable();
		table.setBackground(new Color(240, 248, 255));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 128), new Color(0, 0, 128), new Color(0, 0, 128), new Color(0, 0, 128)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.setBounds(75, 178, 359, 128);
		panel.add(table);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\Angela\\Desktop\\ADA DAW\\programacion 1\u00BA rep\\programacion 3 tr\\Cajero\\Captura de pantalla 2021-05-10 123225.png"));
		btnNewButton_1_1.setForeground(new Color(255, 250, 250));
		btnNewButton_1_1.setBounds(446, 0, 59, 66);
		panel.add(btnNewButton_1_1);
	}

}
