package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import Controlador.Controlador;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField txtNIF;
	private JTextField txtNombreCompleto;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtFechaNacimiento;
	private JTextField txtNIFUSU;
	private JTextField txtNombreCompletoUSU;
	private JTextField txtTelefonoUSU;
	private JTextField txtCorreoUSU;
	private JTextField txtFechaNacimientoUSU;
	private JTextField txtTituloNuevoAlumno;
	private JTextField txtNombreCursoAlumno;
	private JTextField txtCodigoPostalAlumno;
	private JTextField txtNombreCursoUSU;
	private JTextField txtCodigoPostalUSU;

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
					centreWindow(frame);
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
		JPanel panelNuevoAlumno = new JPanel();
		panelNuevoAlumno.setBounds(0, 0, 859, 610);
		panelNuevoAlumno.setBackground(Color.WHITE);
		panelNuevoAlumno.setForeground(new Color(102, 255, 204));
		panelNuevoAlumno.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panelNuevoAlumno.setLayout(null);
		contentPane.add(panelNuevoAlumno);
		

		txtNIF = new JTextField();
		txtNIF.setText("NIF");
		txtNIF.setBounds(121, 144, 110, 19);
		panelNuevoAlumno.add(txtNIF);
		txtNIF.setColumns(10);
		
		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setText("NOMBRE COMPLETO");
		txtNombreCompleto.setColumns(10);
		txtNombreCompleto.setBounds(121, 173, 96, 19);
		panelNuevoAlumno.add(txtNombreCompleto);
		
		txtTelefono = new JTextField();
		txtTelefono.setText("TELEFONO");
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(121, 341, 96, 19);
		panelNuevoAlumno.add(txtTelefono);
		
		txtCorreo = new JTextField();
		txtCorreo.setText("CORREO");
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(121, 231, 96, 19);
		panelNuevoAlumno.add(txtCorreo);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setText("FECHA NACIMIENTO.");
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(121, 202, 96, 19);
		panelNuevoAlumno.add(txtFechaNacimiento);
		
		txtNIFUSU = new JTextField();
		txtNIFUSU.setColumns(10);
		txtNIFUSU.setBounds(491, 144, 96, 19);
		panelNuevoAlumno.add(txtNIFUSU);
		
		txtNombreCompletoUSU = new JTextField();
		txtNombreCompletoUSU.setColumns(10);
		txtNombreCompletoUSU.setBounds(491, 173, 96, 19);
		panelNuevoAlumno.add(txtNombreCompletoUSU);
		
		txtTelefonoUSU = new JTextField();
		txtTelefonoUSU.setColumns(10);
		txtTelefonoUSU.setBounds(515, 264, 96, 19);
		panelNuevoAlumno.add(txtTelefonoUSU);
		
		txtCorreoUSU = new JTextField();
		txtCorreoUSU.setColumns(10);
		txtCorreoUSU.setBounds(491, 231, 96, 19);
		panelNuevoAlumno.add(txtCorreoUSU);
		
		txtFechaNacimientoUSU = new JTextField();
		txtFechaNacimientoUSU.setColumns(10);
		txtFechaNacimientoUSU.setBounds(420, 362, 96, 19);
		panelNuevoAlumno.add(txtFechaNacimientoUSU);
		
		txtTituloNuevoAlumno = new JTextField();
		txtTituloNuevoAlumno.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtTituloNuevoAlumno.setText("NUEVO ALUMNO");
		txtTituloNuevoAlumno.setColumns(10);
		txtTituloNuevoAlumno.setBounds(313, 20, 236, 35);
		panelNuevoAlumno.add(txtTituloNuevoAlumno);
		
		txtNombreCursoAlumno = new JTextField();
		txtNombreCursoAlumno.setText("NOMBRE CURSO");
		txtNombreCursoAlumno.setColumns(10);
		txtNombreCursoAlumno.setBounds(121, 264, 96, 19);
		panelNuevoAlumno.add(txtNombreCursoAlumno);
		
		txtCodigoPostalAlumno = new JTextField();
		txtCodigoPostalAlumno.setText("CODIGO POSTAL");
		txtCodigoPostalAlumno.setColumns(10);
		txtCodigoPostalAlumno.setBounds(121, 299, 96, 19);
		panelNuevoAlumno.add(txtCodigoPostalAlumno);
		
		txtNombreCursoUSU = new JTextField();
		txtNombreCursoUSU.setColumns(10);
		txtNombreCursoUSU.setBounds(420, 202, 96, 19);
		panelNuevoAlumno.add(txtNombreCursoUSU);
		
		txtCodigoPostalUSU = new JTextField();
		txtCodigoPostalUSU.setColumns(10);
		txtCodigoPostalUSU.setBounds(491, 299, 96, 19);
		panelNuevoAlumno.add(txtCodigoPostalUSU);

		txtNIF = new JTextField();
			txtNIF.setText("NIF");
			txtNIF.setBounds(212, 88, 110, 19);
			panelNuevoAlumno.add(txtNIF);
			txtNIF.setColumns(10);
			
			txtNombreCompleto = new JTextField();
			txtNombreCompleto.setText("NOMBRE COMPLETO");
			txtNombreCompleto.setColumns(10);
			txtNombreCompleto.setBounds(212, 124, 110, 19);
			panelNuevoAlumno.add(txtNombreCompleto);
			
			txtTelefono = new JTextField();
			txtTelefono.setText("TELEFONO");
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(212, 245, 96, 19);
			panelNuevoAlumno.add(txtTelefono);
			
			txtCorreo = new JTextField();
			txtCorreo.setText("CORREO");
			txtCorreo.setColumns(10);
			txtCorreo.setBounds(212, 202, 96, 19);
			panelNuevoAlumno.add(txtCorreo);
			
			txtFechaNacimiento = new JTextField();
			txtFechaNacimiento.setText("FECHA NACIMIENTO");
			txtFechaNacimiento.setColumns(10);
			txtFechaNacimiento.setBounds(212, 162, 110, 19);
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
			
			txtTituloNuevoAlumno = new JTextField();
			txtTituloNuevoAlumno.setFont(new Font("Tahoma", Font.BOLD, 24));
			txtTituloNuevoAlumno.setText("NUEVO ALUMNO");
			txtTituloNuevoAlumno.setColumns(10);
			txtTituloNuevoAlumno.setBounds(296, 21, 236, 35);
			panelNuevoAlumno.add(txtTituloNuevoAlumno);
			
			txtNombreCursoAlumno = new JTextField();
			txtNombreCursoAlumno.setText("NOMBRE CURSO");
			txtNombreCursoAlumno.setColumns(10);
			txtNombreCursoAlumno.setBounds(212, 325, 96, 19);
			panelNuevoAlumno.add(txtNombreCursoAlumno);
			
			txtCodigoPostalAlumno = new JTextField();
			txtCodigoPostalAlumno.setText("CODIGO POSTAL");
			txtCodigoPostalAlumno.setColumns(10);
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
			
	}
	
	public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y - 18);
    }
}