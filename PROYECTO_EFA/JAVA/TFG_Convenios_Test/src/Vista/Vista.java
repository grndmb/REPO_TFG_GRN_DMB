package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import Controlador.Controlador;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Vista extends JFrame {

	public JPanel contentPane;
	public JPanel panelNuevoAlumno;
		public JLabel lblNIF;
		public JLabel lblNombreCompleto;
		public JLabel lblTelefono;
		public JLabel lblCorreo;
		public JLabel lblFechaNacimiento;
		public JLabel lblTituloNuevoAlumno;
		public JLabel lblNombreCursoAlumno;
		public JLabel lblCodigoPostalAlumno;
		public JLabel lblSeleccionado;
		
		public JTextField txtNIFUSU;
		public JTextField txtNombreCompletoUSU;
		public JTextField txtTelefonoUSU;
		public JTextField txtCorreoUSU;
		public JTextField txtFechaNacimientoUSU;
		public JComboBox comboBoxNombreCursoUSU;
		public JTextField txtCodigoPostalUSU;
		public JCheckBox checkBoxSeleccionado;
		
		public JButton btnAnadirAlumno;

		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					Controlador controlador = new Controlador(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 647);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(102, 255, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/**
		 * Panel nuevo alumno
		 */
		panelNuevoAlumno = new JPanel();

		
		JPanel panelNuevoAlumno = new JPanel();
		panelNuevoAlumno.setBounds(0, 0, 859, 610);
		panelNuevoAlumno.setBackground(Color.WHITE);
		panelNuevoAlumno.setForeground(new Color(102, 255, 204));
		panelNuevoAlumno.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panelNuevoAlumno.setLayout(null);
		contentPane.add(panelNuevoAlumno);
		
			lblNIF = new JLabel();
			lblNIF.setText("NIF");
			lblNIF.setBounds(212, 88, 110, 19);
			panelNuevoAlumno.add(lblNIF);
			
			
			lblNombreCompleto = new JLabel();
			lblNombreCompleto.setText("NOMBRE COMPLETO");
			lblNombreCompleto.setBounds(212, 124, 136, 19);
			panelNuevoAlumno.add(lblNombreCompleto);
			
			lblTelefono = new JLabel();
			lblTelefono.setText("TELEFONO");
			lblTelefono.setBounds(212, 245, 96, 19);
			panelNuevoAlumno.add(lblTelefono);
			
			lblCorreo = new JLabel();
			lblCorreo.setText("CORREO");
			lblCorreo.setBounds(212, 202, 96, 19);
			panelNuevoAlumno.add(lblCorreo);
			
			lblFechaNacimiento = new JLabel();
			lblFechaNacimiento.setText("FECHA NACIMIENTO");
			lblFechaNacimiento.setBounds(212, 162, 136, 19);
			panelNuevoAlumno.add(lblFechaNacimiento);
			
			txtNIFUSU = new JTextField();
			txtNIFUSU.setColumns(10);
			txtNIFUSU.setBounds(468, 88, 96, 19);
			panelNuevoAlumno.add(txtNIFUSU);
			
			txtNombreCompletoUSU = new JTextField();
			txtNombreCompletoUSU.setColumns(10);
			txtNombreCompletoUSU.setBounds(468, 124, 96, 19);
			panelNuevoAlumno.add(txtNombreCompletoUSU);
			
			txtTelefonoUSU = new JTextField();
			txtTelefonoUSU.setColumns(10);
			txtTelefonoUSU.setBounds(468, 245, 96, 19);
			panelNuevoAlumno.add(txtTelefonoUSU);
			
			txtCorreoUSU = new JTextField();
			txtCorreoUSU.setColumns(10);
			txtCorreoUSU.setBounds(468, 202, 96, 19);
			panelNuevoAlumno.add(txtCorreoUSU);
			
			txtFechaNacimientoUSU = new JTextField();
			txtFechaNacimientoUSU.setColumns(10);
			txtFechaNacimientoUSU.setBounds(468, 162, 96, 19);
			panelNuevoAlumno.add(txtFechaNacimientoUSU);
			
			lblTituloNuevoAlumno = new JLabel();
			lblTituloNuevoAlumno.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblTituloNuevoAlumno.setText("NUEVO ALUMNO");
			lblTituloNuevoAlumno.setBounds(296, 21, 236, 35);
			panelNuevoAlumno.add(lblTituloNuevoAlumno);
			
			lblNombreCursoAlumno = new JLabel();
			lblNombreCursoAlumno.setText("NOMBRE CURSO");
			lblNombreCursoAlumno.setBounds(212, 325, 96, 19);
			panelNuevoAlumno.add(lblNombreCursoAlumno);
			
			lblCodigoPostalAlumno = new JLabel();
			lblCodigoPostalAlumno.setText("CODIGO POSTAL");
			lblCodigoPostalAlumno.setBounds(212, 284, 96, 19);
			panelNuevoAlumno.add(lblCodigoPostalAlumno);
			
			comboBoxNombreCursoUSU = new JComboBox();
			comboBoxNombreCursoUSU.setBounds(468, 325, 96, 19);
			panelNuevoAlumno.add(comboBoxNombreCursoUSU);
			
			txtCodigoPostalUSU = new JTextField();
			txtCodigoPostalUSU.setColumns(10);
			txtCodigoPostalUSU.setBounds(468, 284, 96, 19);
			panelNuevoAlumno.add(txtCodigoPostalUSU);
			
			btnAnadirAlumno = new JButton("A\u00D1ADIR ALUMNO");
			btnAnadirAlumno.setBounds(306, 422, 189, 76);
			panelNuevoAlumno.add(btnAnadirAlumno);
			
			lblSeleccionado = new JLabel();
			lblSeleccionado.setText("SELECCIONADO");
			lblSeleccionado.setBounds(212, 367, 96, 19);
			panelNuevoAlumno.add(lblSeleccionado);
			
			checkBoxSeleccionado = new JCheckBox("");
			checkBoxSeleccionado.setBackground(Color.WHITE);
			checkBoxSeleccionado.setFont(new Font("Tahoma", Font.PLAIN, 50));
			checkBoxSeleccionado.setBounds(468, 367, 28, 26);
			panelNuevoAlumno.add(checkBoxSeleccionado);
	}
}