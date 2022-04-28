package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import Controlador.Controlador;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class Vista extends JFrame {

	public JPanel contentPane;
	
	/**
	 * PANEL PRINCIPAL
	 */
	public JPanel panelInicio;
		public JButton btnInicio;
	
	/**
	 * PANEL NUEVO ALUMNO
	 */
	public JPanel panelNuevoAlumno;
		public JLabel lblNIFAlumno;
		public JLabel lblNombreCompletoAlumno;
		public JLabel lblTelefonoAlumno;
		public JLabel lblCorreoAlumno;
		public JLabel lblFechaNacimientoAlumno;
		public JLabel lblTituloNuevoAlumno;
		public JLabel lblNombreCursoAlumno;
		public JLabel lblCodigoPostalAlumno;
		public JLabel lblSeleccionadoAlumno;
		
		public JTextField txtNIFUSUAlumno;
		public JTextField txtNombreCompletoUSUAlumno;
		public JTextField txtTelefonoUSUAlumno;
		public JTextField txtCorreoUSUAlumno;
		public JTextField txtFechaNacimientoUSUAlumno;
		public JComboBox comboBoxNombreCursoUSUAlumno;
		public JComboBox comboBoxCodigoPostalUSUAlumno;
		public JCheckBox checkBoxSeleccionadoUSUAlumno;
		public JButton btnAnadirAlumno;
		
	/**
	 * PANEL NUEVA EMPRESA
	 */
	public JPanel panelNuevaEmpresa;
		public JLabel lblCIFempresa;
		public JLabel lblNombreEmpresa;
		public JLabel lblDireccionEmpresa;
		public JLabel lblTelefono1Empresa;
		public JLabel lblTelefono2Empresa;
		public JLabel lblEmailEmpresa;
		public JLabel lblFaxEmpresa;
		public JLabel lblPaginaWebEmpresa;
		public JLabel lblSeleccionado;
		
		public JTextField txtNIFUSU;
		public JTextField txtNombreCompletoUSU;
		public JTextField txtTelefonoUSU;
		public JTextField txtCorreoUSU;
		public JTextField txtFechaNacimientoUSU;
		public JComboBox comboBoxNombreCursoUSU;
		public JComboBox comboBoxCodigoPostalUSU;
		public JCheckBox checkBoxSeleccionado;
		public JButton btnAnadirEmpresa;
		
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
		 * Panel inicio
		 */
		panelInicio = new JPanel();
		panelInicio.setBounds(0, 0, 859, 610);
		panelInicio.setBackground(Color.WHITE);
		panelInicio.setForeground(new Color(102, 255, 204));
		panelInicio.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panelInicio.setLayout(null);
		contentPane.add(panelInicio);
			
			btnInicio = new JButton("INICIAR");
			btnInicio.setFont(new Font("Tahoma", Font.PLAIN, 60));
			btnInicio.setBounds(300, 422, 255, 76);
			panelInicio.add(btnInicio);
		
		/**
		 * Panel nuevo alumno
		 */
		panelNuevoAlumno = new JPanel();
		panelNuevoAlumno.setBounds(0, 0, 859, 610);
		panelNuevoAlumno.setBackground(Color.WHITE);
		panelNuevoAlumno.setForeground(new Color(102, 255, 204));
		panelNuevoAlumno.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panelNuevoAlumno.setLayout(null);
		contentPane.add(panelNuevoAlumno);
		
			lblNIFAlumno = new JLabel();
			lblNIFAlumno.setText("NIF");
			lblNIFAlumno.setBounds(212, 88, 110, 19);
			panelNuevoAlumno.add(lblNIFAlumno);
			
			
			lblNombreCompletoAlumno = new JLabel();
			lblNombreCompletoAlumno.setText("NOMBRE COMPLETO");
			lblNombreCompletoAlumno.setBounds(212, 124, 136, 19);
			panelNuevoAlumno.add(lblNombreCompletoAlumno);
			
			lblTelefonoAlumno = new JLabel();
			lblTelefonoAlumno.setText("TELEFONO");
			lblTelefonoAlumno.setBounds(212, 245, 96, 19);
			panelNuevoAlumno.add(lblTelefonoAlumno);
			
			lblCorreoAlumno = new JLabel();
			lblCorreoAlumno.setText("CORREO");
			lblCorreoAlumno.setBounds(212, 202, 96, 19);
			panelNuevoAlumno.add(lblCorreoAlumno);
			
			lblFechaNacimientoAlumno = new JLabel();
			lblFechaNacimientoAlumno.setText("FECHA NACIMIENTO");
			lblFechaNacimientoAlumno.setBounds(212, 162, 136, 19);
			panelNuevoAlumno.add(lblFechaNacimientoAlumno);
			
			txtNIFUSUAlumno = new JTextField();
			txtNIFUSUAlumno.setColumns(10);
			txtNIFUSUAlumno.setBounds(468, 88, 96, 19);
			panelNuevoAlumno.add(txtNIFUSUAlumno);
			
			txtNombreCompletoUSUAlumno = new JTextField();
			txtNombreCompletoUSUAlumno.setColumns(10);
			txtNombreCompletoUSUAlumno.setBounds(468, 124, 96, 19);
			panelNuevoAlumno.add(txtNombreCompletoUSUAlumno);
			
			txtTelefonoUSUAlumno = new JTextField();
			txtTelefonoUSUAlumno.setColumns(10);
			txtTelefonoUSUAlumno.setBounds(468, 245, 96, 19);
			panelNuevoAlumno.add(txtTelefonoUSUAlumno);
			
			txtCorreoUSUAlumno = new JTextField();
			txtCorreoUSUAlumno.setColumns(10);
			txtCorreoUSUAlumno.setBounds(468, 202, 96, 19);
			panelNuevoAlumno.add(txtCorreoUSUAlumno);
			
			txtFechaNacimientoUSUAlumno = new JTextField();
			txtFechaNacimientoUSUAlumno.setColumns(10);
			txtFechaNacimientoUSUAlumno.setBounds(468, 162, 96, 19);
			panelNuevoAlumno.add(txtFechaNacimientoUSUAlumno);
			
			lblTituloNuevoAlumno = new JLabel();
			lblTituloNuevoAlumno.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblTituloNuevoAlumno.setText("NUEVO ALUMNO");
			lblTituloNuevoAlumno.setBounds(296, 21, 236, 35);
			panelNuevoAlumno.add(lblTituloNuevoAlumno);
			
			lblNombreCursoAlumno = new JLabel();
			lblNombreCursoAlumno.setText("NOMBRE CURSO");
			lblNombreCursoAlumno.setBounds(212, 325, 159, 19);
			panelNuevoAlumno.add(lblNombreCursoAlumno);
			
			lblCodigoPostalAlumno = new JLabel();
			lblCodigoPostalAlumno.setText("CODIGO POSTAL");
			lblCodigoPostalAlumno.setBounds(212, 284, 149, 19);
			panelNuevoAlumno.add(lblCodigoPostalAlumno);
			
			comboBoxNombreCursoUSUAlumno = new JComboBox();
			comboBoxNombreCursoUSUAlumno.setBounds(468, 325, 219, 19);
			panelNuevoAlumno.add(comboBoxNombreCursoUSUAlumno);
			
			comboBoxCodigoPostalUSUAlumno = new JComboBox();
			comboBoxCodigoPostalUSUAlumno.setBounds(468, 284, 73, 19);
			panelNuevoAlumno.add(comboBoxCodigoPostalUSUAlumno);
			
			btnAnadirAlumno = new JButton("A\u00D1ADIR ALUMNO");
			btnAnadirAlumno.setBounds(306, 422, 189, 76);
			panelNuevoAlumno.add(btnAnadirAlumno);
			
			lblSeleccionadoAlumno = new JLabel();
			lblSeleccionadoAlumno.setText("SELECCIONADO");
			lblSeleccionadoAlumno.setBounds(212, 367, 96, 19);
			panelNuevoAlumno.add(lblSeleccionadoAlumno);
			
			checkBoxSeleccionadoUSUAlumno = new JCheckBox("");
			checkBoxSeleccionadoUSUAlumno.setBackground(Color.WHITE);
			checkBoxSeleccionadoUSUAlumno.setFont(new Font("Tahoma", Font.PLAIN, 50));
			checkBoxSeleccionadoUSUAlumno.setBounds(468, 367, 28, 26);
			panelNuevoAlumno.add(checkBoxSeleccionadoUSUAlumno);
		/**
		 * Panel nueva empresa
		*/
		panelNuevaEmpresa = new JPanel();
		panelNuevaEmpresa.setBounds(0, 0, 859, 610);
		panelNuevaEmpresa.setBackground(Color.WHITE);
		panelNuevaEmpresa.setForeground(new Color(102, 255, 204));
		panelNuevaEmpresa.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panelNuevaEmpresa.setLayout(null);
		contentPane.add(panelNuevaEmpresa);
			
			lblCIFempresa = new JLabel();
			lblCIFempresa.setText("CIF");
			lblCIFempresa.setBounds(212, 88, 110, 19);
			panelNuevoAlumno.add(lblCIFempresa);
				
			
			lblNombreEmpresa = new JLabel();
			lblNombreEmpresa.setText("NOMBRE");
			lblNombreEmpresa.setBounds(212, 124, 136, 19);
			panelNuevoAlumno.add(lblNombreEmpresa);
				
			lblTelefonoAlumno = new JLabel();
			lblTelefonoAlumno.setText("TELEFONO");
			lblTelefonoAlumno.setBounds(212, 245, 96, 19);
			panelNuevoAlumno.add(lblTelefonoAlumno);
			
			lblCorreoAlumno = new JLabel();
			lblCorreoAlumno.setText("CORREO");
			lblCorreoAlumno.setBounds(212, 202, 96, 19);
			panelNuevoAlumno.add(lblCorreoAlumno);
				
			lblFechaNacimientoAlumno = new JLabel();
			lblFechaNacimientoAlumno.setText("FECHA NACIMIENTO");
			lblFechaNacimientoAlumno.setBounds(212, 162, 136, 19);
			panelNuevoAlumno.add(lblFechaNacimientoAlumno);
				
			txtNIFUSUAlumno = new JTextField();
			txtNIFUSUAlumno.setColumns(10);
			txtNIFUSUAlumno.setBounds(468, 88, 96, 19);
			panelNuevoAlumno.add(txtNIFUSUAlumno);
				
			txtNombreCompletoUSUAlumno = new JTextField();
			txtNombreCompletoUSUAlumno.setColumns(10);
			txtNombreCompletoUSUAlumno.setBounds(468, 124, 96, 19);
			panelNuevoAlumno.add(txtNombreCompletoUSUAlumno);
				
			txtTelefonoUSUAlumno = new JTextField();
			txtTelefonoUSUAlumno.setColumns(10);
			txtTelefonoUSUAlumno.setBounds(468, 245, 96, 19);
			panelNuevoAlumno.add(txtTelefonoUSUAlumno);
				
			txtCorreoUSUAlumno = new JTextField();
			txtCorreoUSUAlumno.setColumns(10);
			txtCorreoUSUAlumno.setBounds(468, 202, 96, 19);
			panelNuevoAlumno.add(txtCorreoUSUAlumno);
				
			txtFechaNacimientoUSUAlumno = new JTextField();
			txtFechaNacimientoUSUAlumno.setColumns(10);
			txtFechaNacimientoUSUAlumno.setBounds(468, 162, 96, 19);
			panelNuevoAlumno.add(txtFechaNacimientoUSUAlumno);
				
			lblTituloNuevoAlumno = new JLabel();
			lblTituloNuevoAlumno.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblTituloNuevoAlumno.setText("NUEVO ALUMNO");
			lblTituloNuevoAlumno.setBounds(296, 21, 236, 35);
			panelNuevoAlumno.add(lblTituloNuevoAlumno);
				
			lblNombreCursoAlumno = new JLabel();
			lblNombreCursoAlumno.setText("NOMBRE CURSO");
			lblNombreCursoAlumno.setBounds(212, 325, 159, 19);
			panelNuevoAlumno.add(lblNombreCursoAlumno);
				
			lblCodigoPostalAlumno = new JLabel();
			lblCodigoPostalAlumno.setText("CODIGO POSTAL");
			lblCodigoPostalAlumno.setBounds(212, 284, 149, 19);
			panelNuevoAlumno.add(lblCodigoPostalAlumno);
				
			comboBoxNombreCursoUSUAlumno = new JComboBox();
			comboBoxNombreCursoUSUAlumno.setBounds(468, 325, 219, 19);
			panelNuevoAlumno.add(comboBoxNombreCursoUSUAlumno);
				
			comboBoxCodigoPostalUSUAlumno = new JComboBox();
			comboBoxCodigoPostalUSUAlumno.setBounds(468, 284, 73, 19);
			panelNuevoAlumno.add(comboBoxCodigoPostalUSUAlumno);
				
			btnAnadirAlumno = new JButton("A\u00D1ADIR ALUMNO");
			btnAnadirAlumno.setBounds(306, 422, 189, 76);
			panelNuevoAlumno.add(btnAnadirAlumno);
				
			lblSeleccionadoAlumno = new JLabel();
			lblSeleccionadoAlumno.setText("SELECCIONADO");
			lblSeleccionadoAlumno.setBounds(212, 367, 96, 19);
			panelNuevoAlumno.add(lblSeleccionadoAlumno);
				
			checkBoxSeleccionadoUSUAlumno = new JCheckBox("");
			checkBoxSeleccionadoUSUAlumno.setBackground(Color.WHITE);
			checkBoxSeleccionadoUSUAlumno.setFont(new Font("Tahoma", Font.PLAIN, 50));
			checkBoxSeleccionadoUSUAlumno.setBounds(468, 367, 28, 26);
			panelNuevoAlumno.add(checkBoxSeleccionadoUSUAlumno);		
	}
}