package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Vista extends JFrame {

	public JPanel contentPane;
	public JPanel panelNuevoAlumno;
		public JLabel txtNIF;
		public JLabel txtNombreCompleto;
		public JLabel txtTelefono;
		public JLabel txtCorreo;
		public JLabel txtFechaNacimiento;
		public JTextField txtNIFUSU;
		public JTextField txtNombreCompletoUSU;
		public JTextField txtTelefonoUSU;
		public JTextField txtCorreoUSU;
		public JTextField txtFechaNacimientoUSU;
		public JLabel txtTituloNuevoAlumno;
		public JLabel txtNombreCursoAlumno;
		public JLabel txtCodigoPostalAlumno;
		public JTextField txtNombreCursoUSU;
		public JTextField txtCodigoPostalUSU;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
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
		
			txtNIF = new JLabel();
			txtNIF.setText("NIF");
			txtNIF.setBounds(212, 88, 110, 19);
			panelNuevoAlumno.add(txtNIF);
			
			
			txtNombreCompleto = new JLabel();
			txtNombreCompleto.setText("NOMBRE COMPLETO");
			txtNombreCompleto.setBounds(212, 124, 136, 19);
			panelNuevoAlumno.add(txtNombreCompleto);
			
			txtTelefono = new JLabel();
			txtTelefono.setText("TELEFONO");
			txtTelefono.setBounds(212, 245, 96, 19);
			panelNuevoAlumno.add(txtTelefono);
			
			txtCorreo = new JLabel();
			txtCorreo.setText("CORREO");
			txtCorreo.setBounds(212, 202, 96, 19);
			panelNuevoAlumno.add(txtCorreo);
			
			txtFechaNacimiento = new JLabel();
			txtFechaNacimiento.setText("FECHA NACIMIENTO");
			txtFechaNacimiento.setBounds(212, 162, 136, 19);
			panelNuevoAlumno.add(txtFechaNacimiento);
			
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
			
			txtTituloNuevoAlumno = new JLabel();
			txtTituloNuevoAlumno.setFont(new Font("Tahoma", Font.BOLD, 24));
			txtTituloNuevoAlumno.setText("NUEVO ALUMNO");
			txtTituloNuevoAlumno.setBounds(296, 21, 236, 35);
			panelNuevoAlumno.add(txtTituloNuevoAlumno);
			
			txtNombreCursoAlumno = new JLabel();
			txtNombreCursoAlumno.setText("NOMBRE CURSO");
			txtNombreCursoAlumno.setBounds(212, 325, 96, 19);
			panelNuevoAlumno.add(txtNombreCursoAlumno);
			
			txtCodigoPostalAlumno = new JLabel();
			txtCodigoPostalAlumno.setText("CODIGO POSTAL");
			txtCodigoPostalAlumno.setBounds(212, 284, 96, 19);
			panelNuevoAlumno.add(txtCodigoPostalAlumno);
			
			txtNombreCursoUSU = new JTextField();
			txtNombreCursoUSU.setColumns(10);
			txtNombreCursoUSU.setBounds(468, 325, 96, 19);
			panelNuevoAlumno.add(txtNombreCursoUSU);
			
			txtCodigoPostalUSU = new JTextField();
			txtCodigoPostalUSU.setColumns(10);
			txtCodigoPostalUSU.setBounds(468, 284, 96, 19);
			panelNuevoAlumno.add(txtCodigoPostalUSU);
			
			JButton btnAnadirAlumno = new JButton("A\u00D1ADIR ALUMNO");
			btnAnadirAlumno.setBounds(306, 422, 189, 76);
			panelNuevoAlumno.add(btnAnadirAlumno);
			
			JLabel txtSeleccionado = new JLabel();
			txtSeleccionado.setText("SELECCIONADO");
			txtSeleccionado.setBounds(212, 367, 96, 19);
			panelNuevoAlumno.add(txtSeleccionado);
			
			JCheckBox chbSeleccionado = new JCheckBox("");
			chbSeleccionado.setBackground(Color.WHITE);
			chbSeleccionado.setFont(new Font("Tahoma", Font.PLAIN, 20));
			chbSeleccionado.setBounds(468, 367, 28, 26);
			panelNuevoAlumno.add(chbSeleccionado);
	}
}