package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import Atxy2k.CustomTextField.RestrictedTextField;
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
		public JLabel lblPoblacionAlumno;
		
		public JTextField txtNIFUSUAlumno;
		public RestrictedTextField restrictedtxtNIFAlumno;
		public JTextField txtNombreCompletoUSUAlumno;
		public JTextField txtTelefonoUSUAlumno;
		public RestrictedTextField restrictedtxtTelefonoUSUAlumno;
		public JTextField txtCorreoUSUAlumno;
		public JDateChooser dateChooserFechaNacimientoUSUAlumno;
		public JComboBox comboBoxNombreCursoUSUAlumno;
		public JComboBox comboBoxPoblacionUSUAlumno;
		public JComboBox comboBoxCodigoPostalUSUAlumno;
		public JButton btnAnadirAlumno;
		public JButton btnNuevaEmpresa;
	/**
	 * PANEL NUEVA EMPRESA
	 */
	public JPanel panelNuevaEmpresa;
		public JLabel lblTituloNuevoEmpresa;
		public JLabel lblCIFEmpresa;
		public JLabel lblNombreEmpresa;
		public JLabel lblDireccionEmpresa;
		public JLabel lblTelefono1Empresa;
		public JLabel lblTelefono2Empresa;
		public JLabel lblEmailEmpresa;
		public JLabel lblFaxEmpresa;
		public JLabel lblPaginaWebEmpresa;
		public JLabel lblDNIGerenteEmpresa;
		public JLabel lblNombreGerenteEmpresa;
		public JLabel lblPersonaContactoEmpresa;
		public JLabel lblCargoContactoEmpresaEmpresa;
		public JLabel lblFechaActualizacionEmpresa;
		public JLabel lblOrganismoPublicoEmpresa;
		public JLabel lblObservacionesEmpresa;
		public JLabel lblPoblacionEmpresa;
		
		public JTextField txtCIFEmpresa;
		public RestrictedTextField restrictedtxtCIFEmpresa;
		public JTextField txtNombreEmpresa;
		public JTextField txtDireccionEmpresa;
		public JTextField txtTelefono1Empresa;
		public RestrictedTextField restrictedtxtTelefono1Empresa;
		public RestrictedTextField restrictedtxtTelefono2Empresa;
		public JTextField txtTelefono2Empresa;
		public JTextField txtEmailEmpresa;
		public JTextField txtFaxEmpresa;
		public JTextField txtPaginaWebEmpresa;
		public JTextField txtDNIGerenteEmpresa;
		public JTextField txtNombreGerenteEmpresa;
		public JTextField txtPersonaContactoEmpresa;
		public JTextField txtCargoContactoEmpresaEmpresa;
		public JLabel lblFechaActualizacionUSUEmpresa;
		public JTextField txtObservacionesEmpresa;
		
		public JCheckBox checkBoxOrganismoPublicoUSUEmpresa;
		public JComboBox comboBoxPoblacionUSUEmpresa;
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
			txtNIFUSUAlumno.setBounds(468, 88, 219, 19);
			panelNuevoAlumno.add(txtNIFUSUAlumno);
			
			restrictedtxtNIFAlumno = new RestrictedTextField(txtNIFUSUAlumno);
			restrictedtxtNIFAlumno.setLimit(9);
			
			txtNombreCompletoUSUAlumno = new JTextField();
			txtNombreCompletoUSUAlumno.setColumns(10);
			txtNombreCompletoUSUAlumno.setBounds(468, 124, 219, 19);
			panelNuevoAlumno.add(txtNombreCompletoUSUAlumno);
			
			txtTelefonoUSUAlumno = new JTextField();
			txtTelefonoUSUAlumno.setColumns(10);
			txtTelefonoUSUAlumno.setBounds(468, 245, 219, 19);
			panelNuevoAlumno.add(txtTelefonoUSUAlumno);
			
			restrictedtxtTelefonoUSUAlumno = new RestrictedTextField(txtTelefonoUSUAlumno);
			restrictedtxtTelefonoUSUAlumno.setLimit(9);
			restrictedtxtTelefonoUSUAlumno.setOnlyNums(true);
			
			txtCorreoUSUAlumno = new JTextField();
			txtCorreoUSUAlumno.setColumns(10);
			txtCorreoUSUAlumno.setBounds(468, 202, 219, 19);
			panelNuevoAlumno.add(txtCorreoUSUAlumno);
			
			dateChooserFechaNacimientoUSUAlumno = new JDateChooser("dd/MM/yyyy", " ##/##/####", '_');
			dateChooserFechaNacimientoUSUAlumno.setBounds(468, 162, 219, 19);
			panelNuevoAlumno.add(dateChooserFechaNacimientoUSUAlumno);
			
			lblTituloNuevoAlumno = new JLabel();
			lblTituloNuevoAlumno.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblTituloNuevoAlumno.setText("NUEVO ALUMNO");
			lblTituloNuevoAlumno.setBounds(296, 21, 236, 35);
			panelNuevoAlumno.add(lblTituloNuevoAlumno);
			
			lblNombreCursoAlumno = new JLabel();
			lblNombreCursoAlumno.setText("NOMBRE CURSO");
			lblNombreCursoAlumno.setBounds(212, 325, 159, 19);
			panelNuevoAlumno.add(lblNombreCursoAlumno);
			
			lblPoblacionAlumno = new JLabel();
			lblPoblacionAlumno.setText("POBLACION");
			lblPoblacionAlumno.setBounds(212, 284, 149, 19);
			panelNuevoAlumno.add(lblPoblacionAlumno);
			
			comboBoxNombreCursoUSUAlumno = new JComboBox();
			comboBoxNombreCursoUSUAlumno.setBounds(468, 325, 219, 19);
			panelNuevoAlumno.add(comboBoxNombreCursoUSUAlumno);
			
			comboBoxPoblacionUSUAlumno = new JComboBox();
			comboBoxPoblacionUSUAlumno.setBounds(468, 284, 219, 19);
			panelNuevoAlumno.add(comboBoxPoblacionUSUAlumno);
			
			comboBoxCodigoPostalUSUAlumno = new JComboBox();
			comboBoxCodigoPostalUSUAlumno.setBounds(730, 284, 110, 19);
			panelNuevoAlumno.add(comboBoxCodigoPostalUSUAlumno);
			
			btnAnadirAlumno = new JButton("A\u00D1ADIR ALUMNO");
			btnAnadirAlumno.setBounds(306, 422, 189, 76);
			panelNuevoAlumno.add(btnAnadirAlumno);
			
			btnNuevaEmpresa = new JButton("NUEVA EMPRESA");
			btnNuevaEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnNuevaEmpresa.setBounds(696, 560, 153, 40);
			panelNuevoAlumno.add(btnNuevaEmpresa);
	
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
			
			lblTituloNuevoEmpresa = new JLabel();
			lblTituloNuevoEmpresa.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblTituloNuevoEmpresa.setText("NUEVA EMPRESA");
			lblTituloNuevoEmpresa.setBounds(300, 21, 217, 35);
			panelNuevaEmpresa.add(lblTituloNuevoEmpresa);
		
			lblCIFEmpresa = new JLabel();
			lblCIFEmpresa.setText("CIF");
			lblCIFEmpresa.setBounds(199, 85, 110, 19);
			panelNuevaEmpresa.add(lblCIFEmpresa);
			
			lblNombreEmpresa = new JLabel();
			lblNombreEmpresa.setText("NOMBRE");
			lblNombreEmpresa.setBounds(199, 114, 136, 19);
			panelNuevaEmpresa.add(lblNombreEmpresa);
				
			lblDireccionEmpresa = new JLabel();
			lblDireccionEmpresa.setText("DIRECCION");
			lblDireccionEmpresa.setBounds(199, 143, 96, 19);
			panelNuevaEmpresa.add(lblDireccionEmpresa);
			
			lblTelefono1Empresa = new JLabel();
			lblTelefono1Empresa.setText("TELEFONO 1");
			lblTelefono1Empresa.setBounds(199, 226, 96, 19);
			panelNuevaEmpresa.add(lblTelefono1Empresa);
				
			lblTelefono2Empresa = new JLabel();
			lblTelefono2Empresa.setText("TELEFONO 2");
			lblTelefono2Empresa.setBounds(199, 253, 136, 19);
			panelNuevaEmpresa.add(lblTelefono2Empresa);
			
			lblEmailEmpresa = new JLabel();
			lblEmailEmpresa.setText("CORREO");
			lblEmailEmpresa.setBounds(199, 196, 136, 19);
			panelNuevaEmpresa.add(lblEmailEmpresa);
			
			lblFaxEmpresa = new JLabel();
			lblFaxEmpresa.setText("FAX");
			lblFaxEmpresa.setBounds(199, 280, 136, 19);
			panelNuevaEmpresa.add(lblFaxEmpresa);
			
			lblPaginaWebEmpresa = new JLabel();
			lblPaginaWebEmpresa.setText("PAGINA WEB");
			lblPaginaWebEmpresa.setBounds(199, 306, 136, 19);
			panelNuevaEmpresa.add(lblPaginaWebEmpresa);
			
			lblDNIGerenteEmpresa = new JLabel();
			lblDNIGerenteEmpresa.setText("DNI GERENTE");
			lblDNIGerenteEmpresa.setBounds(199, 362, 136, 19);
			panelNuevaEmpresa.add(lblDNIGerenteEmpresa);
			
			lblNombreGerenteEmpresa = new JLabel();
			lblNombreGerenteEmpresa.setText("NOMBRE GERENTE");
			lblNombreGerenteEmpresa.setBounds(199, 393, 136, 19);
			panelNuevaEmpresa.add(lblNombreGerenteEmpresa);
			
			lblPersonaContactoEmpresa = new JLabel();
			lblPersonaContactoEmpresa.setText("PERSONA DE CONTACTO");
			lblPersonaContactoEmpresa.setBounds(199, 422, 204, 19);
			panelNuevaEmpresa.add(lblPersonaContactoEmpresa);
			
			lblCargoContactoEmpresaEmpresa = new JLabel();
			lblCargoContactoEmpresaEmpresa.setText("CARGO PERSONA DE CONTACTO");
			lblCargoContactoEmpresaEmpresa.setBounds(199, 451, 222, 19);
			panelNuevaEmpresa.add(lblCargoContactoEmpresaEmpresa);
			
			lblFechaActualizacionEmpresa = new JLabel();
			lblFechaActualizacionEmpresa.setText("FECHA ACTUALIZACION DATOS");
			lblFechaActualizacionEmpresa.setBounds(199, 509, 192, 19);
			panelNuevaEmpresa.add(lblFechaActualizacionEmpresa);
			
			lblOrganismoPublicoEmpresa = new JLabel();
			lblOrganismoPublicoEmpresa.setText("ORGANISMO PUBLICO");
			lblOrganismoPublicoEmpresa.setBounds(199, 333, 136, 19);
			panelNuevaEmpresa.add(lblOrganismoPublicoEmpresa);
			
			lblObservacionesEmpresa = new JLabel();
			lblObservacionesEmpresa.setText("OBSERVACIONES");
			lblObservacionesEmpresa.setBounds(199, 480, 136, 19);
			panelNuevaEmpresa.add(lblObservacionesEmpresa);
			
			lblPoblacionEmpresa = new JLabel();
			lblPoblacionEmpresa.setText("POBLACION");
			lblPoblacionEmpresa.setBounds(199, 167, 136, 19);
			panelNuevaEmpresa.add(lblPoblacionEmpresa);
			
			txtCIFEmpresa = new JTextField();
			txtCIFEmpresa.setBounds(458, 85, 190, 19);
			panelNuevaEmpresa.add(txtCIFEmpresa);
			
			restrictedtxtCIFEmpresa = new RestrictedTextField(txtCIFEmpresa);
			restrictedtxtCIFEmpresa.setLimit(10);
			
			txtNombreEmpresa = new JTextField();
			txtNombreEmpresa.setBounds(458, 114, 190, 19);
			panelNuevaEmpresa.add(txtNombreEmpresa);
				
			txtDireccionEmpresa = new JTextField();
			txtDireccionEmpresa.setBounds(458, 143, 190, 19);
			panelNuevaEmpresa.add(txtDireccionEmpresa);
			
			txtTelefono1Empresa = new JTextField();
			txtTelefono1Empresa.setBounds(458, 226, 190, 19);
			panelNuevaEmpresa.add(txtTelefono1Empresa);
			
			restrictedtxtTelefono1Empresa = new RestrictedTextField(txtTelefono1Empresa);
			restrictedtxtTelefono1Empresa.setLimit(9);
			restrictedtxtTelefono1Empresa.setOnlyNums(true);
			
			txtTelefono2Empresa = new JTextField();
			txtTelefono2Empresa.setBounds(458, 253, 190, 19);
			panelNuevaEmpresa.add(txtTelefono2Empresa);
			
			restrictedtxtTelefono2Empresa = new RestrictedTextField(txtTelefono2Empresa);
			restrictedtxtTelefono2Empresa.setLimit(9);
			restrictedtxtTelefono2Empresa.setOnlyNums(true);
			
			txtEmailEmpresa = new JTextField();
			txtEmailEmpresa.setBounds(458, 196, 190, 19);
			panelNuevaEmpresa.add(txtEmailEmpresa);
			
			txtFaxEmpresa = new JTextField();
			txtFaxEmpresa.setBounds(458, 280, 190, 19);
			panelNuevaEmpresa.add(txtFaxEmpresa);
			
			txtPaginaWebEmpresa = new JTextField();
			txtPaginaWebEmpresa.setBounds(458, 306, 190, 19);
			panelNuevaEmpresa.add(txtPaginaWebEmpresa);
			
			txtDNIGerenteEmpresa = new JTextField();
			txtDNIGerenteEmpresa.setBounds(458, 362, 190, 19);
			panelNuevaEmpresa.add(txtDNIGerenteEmpresa);
			
			txtNombreGerenteEmpresa = new JTextField();
			txtNombreGerenteEmpresa.setBounds(458, 393, 190, 19);
			panelNuevaEmpresa.add(txtNombreGerenteEmpresa);
			
			txtPersonaContactoEmpresa = new JTextField();
			txtPersonaContactoEmpresa.setBounds(458, 422, 190, 19);
			panelNuevaEmpresa.add(txtPersonaContactoEmpresa);
			
			txtCargoContactoEmpresaEmpresa = new JTextField();
			txtCargoContactoEmpresaEmpresa.setBounds(458, 451, 190, 19);
			panelNuevaEmpresa.add(txtCargoContactoEmpresaEmpresa);
			
			lblFechaActualizacionUSUEmpresa = new JLabel();
			lblFechaActualizacionUSUEmpresa.setBounds(458, 509, 190, 19);
			panelNuevaEmpresa.add(lblFechaActualizacionUSUEmpresa);
			
			checkBoxOrganismoPublicoUSUEmpresa = new JCheckBox();
			checkBoxOrganismoPublicoUSUEmpresa.setBackground(Color.WHITE);
			checkBoxOrganismoPublicoUSUEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 50));
			checkBoxOrganismoPublicoUSUEmpresa.setBounds(458, 334, 28, 21);
			panelNuevaEmpresa.add(checkBoxOrganismoPublicoUSUEmpresa);
			
			txtObservacionesEmpresa = new JTextField();
			txtObservacionesEmpresa.setBounds(458, 480, 190, 19);
			panelNuevaEmpresa.add(txtObservacionesEmpresa);
		
			comboBoxPoblacionUSUEmpresa = new JComboBox();
			comboBoxPoblacionUSUEmpresa.setBounds(458, 169, 190, 19);
			panelNuevaEmpresa.add(comboBoxPoblacionUSUEmpresa);
			
			btnAnadirEmpresa = new JButton("A\u00D1ADIR EMPRESA");
			btnAnadirEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnAnadirEmpresa.setBounds(300, 550, 217, 50);
			panelNuevaEmpresa.add(btnAnadirEmpresa);			
	}
}