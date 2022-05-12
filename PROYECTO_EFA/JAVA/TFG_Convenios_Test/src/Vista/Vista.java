package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import com.toedter.calendar.JDateChooser;

import Atxy2k.CustomTextField.RestrictedTextField;
import Controlador.Controlador;

import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;


public class Vista extends JFrame {

	public JPanel contentPane;
	
	/**
	 * PANEL PRINCIPAL
	 */
	public JPanel panelPrincipal;
		public JButton btnInicio;
		public JLabel labelTitulo;
		public JPanel panelMenu;
		public JButton btnPanelAlumnos;
		public JButton btnPanelEmpresas;
		public JButton btnPanelPracticas;
		public JButton btnPanelDocumentos;

		
		
	// -----------------------------------------------------------
		
	/**
	 * PANEL LISTA ALUMNOS	
	 */
		
	public JPanel panelListaAlumno;
		public JComboBox comboBoxListaCursoAlumno;
		public JButton btnPanelAddAlumno;
		public JButton btnPanelModificarAlumno;
		public JButton btnEliminarAlumno;
		
		public JList listAlumnos;
		public DefaultListModel modelAlumnos;

	
		
	/**
	 * PANEL NUEVO ALUMNO
	 */
	public JPanel panelNuevoActualizarAlumno;
		public JLabel lblNIFAlumno;
		public JLabel lblNombreCompletoAlumno;
		public JLabel lblTelefonoAlumno;
		public JLabel lblCorreoAlumno;
		public JLabel lblFechaNacimientoAlumno;
		public JLabel lblTituloNuevoAlumno;
		public JLabel lblTituloModificarAlumno;
		public JLabel lblNombreCursoAlumno;
		public JLabel lblPoblacionAlumno;
		public JLabel lblCodigoPostalAlumno;
		
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
		public JButton btnNuevoCursoAlumno;
		public JButton btnNuevaPoblacionAlumno;
		public JButton btnAnadirAlumno;
		public JButton btnModificarAlumno;
		public JLabel lblErroresNuevoAlumno;
		
		// --------------------------------------------------
		
		
		/**
		 * PANEL LISTA EMPRESA
		 */
	public JPanel panelListaEmpresas;	

		public JButton btnPanelAddEmpresa;
		public JButton btnPanelModificarEmpresa;
		public JButton btnEliminarEmpresa;
	
		public JList listEmpresas;
		public DefaultListModel modelEmpresas;
		
		
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
		public JLabel lblDNIPersonaContactoEmpresa;
		public JLabel lblPersonaContactoEmpresaEmpresa;			
		public JLabel lblFechaActualizacionEmpresa;
		public JLabel lblOrganismoPublicoEmpresa;
		public JLabel lblObservacionesEmpresa;
		public JLabel lblPoblacionEmpresa;
		public JLabel lblCodigoPostalEmpresa;
			
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
		public RestrictedTextField restrictedtxtDNIGerenteEmpresa;
		public JTextField txtNombreGerenteEmpresa;
		public JTextField txtPersonaContactoEmpresa;
		public JTextField txtDNIPersonaContactoEmpresaEmpresa;
		public RestrictedTextField restrictedtxtDNIPersonaContactoEmpresaEmpresa;
		public JLabel lblFechaActualizacionUSUEmpresa;
		public JTextField txtObservacionesEmpresa;
		public JLabel lblErroresNuevaEmpresa;
		public JCheckBox checkBoxOrganismoPublicoUSUEmpresa;
		public JComboBox comboBoxPoblacionUSUEmpresa;
		public JComboBox comboBoxCodigoPostalUSUEmpresa;
		public JButton btnAnadirEmpresa;
		public JButton btnNuevaPoblacionEmpresa;
			
		
		
	// ---------------------------------------------------------------------
	/**
	 * PANEL NUEVO CURSO
	 */
	public JPanel panelNuevoCurso;

		public JLabel lblTituloNuevoCurso;
		public JLabel lblNombreCurso;
		public JLabel lblNombreAbrevCurso;
		public JLabel lblClaveCurso;
		public JLabel lblHorasFCTCurso;
		public JLabel lblEsPublicoCurso;
			
		public JTextField txtNombreUSUCurso;
		public JTextField txtNombreAbrevUSUCurso;
		public JTextField txtClaveUSUCurso;
		public JTextField txtHorasFCTUSUCurso;
		public JCheckBox checkBoxEsPublicoUSUCurso;
		public JButton btnAnadirCurso;
		public JLabel lblErroresNuevoCurso;
	
	/**
	 * PANEL NUEVA POBLACION
	 */
	public JPanel panelNuevaPoblacion;

		public JLabel lblTituloNuevaPoblacion;
		public JLabel lblCodigoPostalPoblacion;
		public JLabel lblNombrePoblacion;
		public JLabel lblProvinciaPoblacion;
				
		public JTextField txtCodigoPostalUSUPoblacion;
		public JTextField txtNombreUSUPoblacion;
		public JTextField txtProvinciaUSUPoblacion;
		public JButton btnAnadirPoblacion;;
		public JLabel lblErroresNuevaPoblacion;	
		
	
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
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		setAlwaysOnTop(true);
		setTitle("EFA MORATALAZ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1560, 844);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(102, 255, 204));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/**
		 * Panel Principal
		 */
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 1556, 807);
		panelPrincipal.setBackground(new Color(53, 100, 54));
		panelPrincipal.setForeground(new Color(255, 255, 255));
		panelPrincipal.setVisible(false);
		panelPrincipal.setFont(new Font("Freestyle Script", Font.PLAIN, 40));
		contentPane.add(panelPrincipal);
			panelPrincipal.setLayout(null);
			
			labelTitulo = new JLabel("EFA MORATALAZ");
			labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitulo.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 60));
			labelTitulo.setForeground(Color.WHITE);
			labelTitulo.setBounds(0, 0, 1538, 114);
			panelPrincipal.add(labelTitulo);
			
			btnInicio = new JButton("Iniciar Aplicaci\u00F3n");
			btnInicio.setBounds(530, 450, 479, 76);
			btnInicio.setBackground(new Color(255, 255, 255));
			btnInicio.setForeground(new Color(0, 128, 0));
			btnInicio.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 40));
			panelPrincipal.add(btnInicio);
			
			panelMenu = new JPanel();
			panelMenu.setBackground(new Color(51, 204, 102));
			panelMenu.setBorder(new MatteBorder(5, 3, 5, 3, (Color) new Color(0, 0, 0)));
			panelMenu.setBounds(10, 132, 324, 648);
			panelPrincipal.add(panelMenu);
			panelMenu.setLayout(null);
			
			btnPanelAlumnos = new JButton("Alumnos");
			btnPanelAlumnos.setBackground(Color.WHITE);
			btnPanelAlumnos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
			btnPanelAlumnos.setBounds(49, 50, 219, 37);
			panelMenu.add(btnPanelAlumnos);
			
			btnPanelEmpresas = new JButton("Empresas");
			btnPanelEmpresas.setBackground(Color.WHITE);
			btnPanelEmpresas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
			btnPanelEmpresas.setBounds(49, 130, 219, 37);
			panelMenu.add(btnPanelEmpresas);
			
			btnPanelPracticas = new JButton("Practicas");
			btnPanelPracticas.setBackground(Color.WHITE);
			btnPanelPracticas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
			btnPanelPracticas.setBounds(49, 210, 219, 37);
			panelMenu.add(btnPanelPracticas);
			
			btnPanelDocumentos = new JButton("Documentos");
			btnPanelDocumentos.setBackground(Color.WHITE);
			btnPanelDocumentos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
			btnPanelDocumentos.setBounds(49, 491, 219, 37);
			panelMenu.add(btnPanelDocumentos);
			
			JLabel lblLogo = new JLabel("");
			lblLogo.setBounds(10, 10, 324, 104);
			panelPrincipal.add(lblLogo);
			
			
			
		
			
			// -----------------------------------------------------------------
			
			/**
			 * PANEL ALUMNOS	
			 */
			
			panelListaAlumno = new JPanel();
			panelListaAlumno.setBackground(Color.WHITE);
			panelListaAlumno.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			panelListaAlumno.setBounds(368, 132, 1138, 648);
			panelPrincipal.add(panelListaAlumno);
			panelListaAlumno.setLayout(null);
			
			JLabel lblTituloAlumnos = new JLabel("ALUMNOS");
			lblTituloAlumnos.setFont(new Font("Agency FB", Font.BOLD, 50));
			lblTituloAlumnos.setBounds(136, 26, 992, 55);
			panelListaAlumno.add(lblTituloAlumnos);
		
			
			listAlumnos = new JList<String>();
			listAlumnos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			listAlumnos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            modelAlumnos = new DefaultListModel<>();
            
     
            JScrollPane listPaneAlumnos = new JScrollPane();
            listPaneAlumnos.setBounds(50, 219, 721, 389);
            listPaneAlumnos.setViewportView(listAlumnos);
            listAlumnos.setLayoutOrientation(JList.VERTICAL);
            panelListaAlumno.add(listPaneAlumnos);
            
            JLabel lblFiltroAlumno = new JLabel("Curso -->");
            lblFiltroAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
            lblFiltroAlumno.setBounds(50, 114, 124, 38);
            panelListaAlumno.add(lblFiltroAlumno);
            
            comboBoxListaCursoAlumno = new JComboBox();
            comboBoxListaCursoAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
            comboBoxListaCursoAlumno.setBackground(Color.WHITE);
            comboBoxListaCursoAlumno.setBounds(184, 114, 584, 38);
            panelListaAlumno.add(comboBoxListaCursoAlumno);
            
            btnPanelAddAlumno = new JButton("AÑADIR NUEVO");
            btnPanelAddAlumno.setBackground(Color.GREEN);
            btnPanelAddAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
            btnPanelAddAlumno.setBounds(874, 518, 205, 55);
            panelListaAlumno.add(btnPanelAddAlumno);
            
            btnPanelModificarAlumno = new JButton("MODIFICAR");
            btnPanelModificarAlumno.setBackground(Color.ORANGE);
            btnPanelModificarAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
            btnPanelModificarAlumno.setBounds(874, 230, 205, 55);
            panelListaAlumno.add(btnPanelModificarAlumno);
            
            btnEliminarAlumno = new JButton("ELIMINAR");
            btnEliminarAlumno.setBackground(Color.RED);
            btnEliminarAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
            btnEliminarAlumno.setBounds(874, 312, 205, 55);
            panelListaAlumno.add(btnEliminarAlumno);
            
            JLabel lblTituloDNIListaAlumno = new JLabel("DNI");
            lblTituloDNIListaAlumno.setFont(new Font("Tahoma", Font.PLAIN, 30));
            lblTituloDNIListaAlumno.setHorizontalAlignment(SwingConstants.CENTER);
            lblTituloDNIListaAlumno.setBounds(50, 173, 228, 36);
            panelListaAlumno.add(lblTituloDNIListaAlumno);
            
            JLabel lblNombrelListaAlumno = new JLabel("NOMBRE COMPLETO");
            lblNombrelListaAlumno.setHorizontalAlignment(SwingConstants.CENTER);
            lblNombrelListaAlumno.setFont(new Font("Tahoma", Font.PLAIN, 30));
            lblNombrelListaAlumno.setBounds(301, 173, 470, 36);
            panelListaAlumno.add(lblNombrelListaAlumno);
            
            JSeparator separator = new JSeparator();
            separator.setBackground(Color.BLACK);
            separator.setForeground(Color.BLACK);
            separator.setOrientation(SwingConstants.VERTICAL);
            separator.setBounds(274, 13, 1, 535);
            listAlumnos.add(separator);

		/**
		 * PANEL NUEVO ALUMNO
		 */ 
		panelNuevoActualizarAlumno = new JPanel();
		panelNuevoActualizarAlumno.setBounds(368, 132, 1138, 648);
		panelNuevoActualizarAlumno.setBackground(Color.WHITE);
		panelNuevoActualizarAlumno.setForeground(new Color(102, 255, 204));
		panelNuevoActualizarAlumno.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panelNuevoActualizarAlumno.setLayout(null);
		panelPrincipal.add(panelNuevoActualizarAlumno);
		
			lblNIFAlumno = new JLabel();
			lblNIFAlumno.setText("NIF");
			lblNIFAlumno.setBounds(319, 91, 110, 19);
			panelNuevoActualizarAlumno.add(lblNIFAlumno);
			
			lblNombreCompletoAlumno = new JLabel();
			lblNombreCompletoAlumno.setText("NOMBRE COMPLETO");
			lblNombreCompletoAlumno.setBounds(319, 127, 136, 19);
			panelNuevoActualizarAlumno.add(lblNombreCompletoAlumno);
			
			lblTelefonoAlumno = new JLabel();
			lblTelefonoAlumno.setText("TELEFONO");
			lblTelefonoAlumno.setBounds(319, 248, 96, 19);
			panelNuevoActualizarAlumno.add(lblTelefonoAlumno);
			
			lblCorreoAlumno = new JLabel();
			lblCorreoAlumno.setText("CORREO");
			lblCorreoAlumno.setBounds(319, 205, 96, 19);
			panelNuevoActualizarAlumno.add(lblCorreoAlumno);
			
			lblFechaNacimientoAlumno = new JLabel();
			lblFechaNacimientoAlumno.setText("FECHA NACIMIENTO");
			lblFechaNacimientoAlumno.setBounds(319, 165, 136, 19);
			panelNuevoActualizarAlumno.add(lblFechaNacimientoAlumno);
			
			txtNIFUSUAlumno = new JTextField();
			txtNIFUSUAlumno.setColumns(10);
			txtNIFUSUAlumno.setBounds(517, 91, 219, 19);
			panelNuevoActualizarAlumno.add(txtNIFUSUAlumno);
			
			restrictedtxtNIFAlumno = new RestrictedTextField(txtNIFUSUAlumno);
			restrictedtxtNIFAlumno.setLimit(9);
			
			txtNombreCompletoUSUAlumno = new JTextField();
			txtNombreCompletoUSUAlumno.setColumns(10);
			txtNombreCompletoUSUAlumno.setBounds(517, 127, 219, 19);
			panelNuevoActualizarAlumno.add(txtNombreCompletoUSUAlumno);
			
			txtTelefonoUSUAlumno = new JTextField();
			txtTelefonoUSUAlumno.setColumns(10);
			txtTelefonoUSUAlumno.setBounds(517, 248, 219, 19);
			panelNuevoActualizarAlumno.add(txtTelefonoUSUAlumno);
			
			restrictedtxtTelefonoUSUAlumno = new RestrictedTextField(txtTelefonoUSUAlumno);
			restrictedtxtTelefonoUSUAlumno.setLimit(9);
			
			txtCorreoUSUAlumno = new JTextField();
			txtCorreoUSUAlumno.setColumns(10);
			txtCorreoUSUAlumno.setBounds(517, 205, 219, 19);
			panelNuevoActualizarAlumno.add(txtCorreoUSUAlumno);
			
			dateChooserFechaNacimientoUSUAlumno = new JDateChooser("dd/MM/yyyy", " ##/##/####", '_');
			dateChooserFechaNacimientoUSUAlumno.setBounds(517, 165, 219, 19);
			panelNuevoActualizarAlumno.add(dateChooserFechaNacimientoUSUAlumno);
			
			lblTituloNuevoAlumno = new JLabel();
			lblTituloNuevoAlumno.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblTituloNuevoAlumno.setText("NUEVO ALUMNO");
			lblTituloNuevoAlumno.setBounds(403, 24, 236, 35);
			panelNuevoActualizarAlumno.add(lblTituloNuevoAlumno);
			
			lblNombreCursoAlumno = new JLabel();
			lblNombreCursoAlumno.setText("NOMBRE CURSO");
			lblNombreCursoAlumno.setBounds(319, 364, 159, 19);
			panelNuevoActualizarAlumno.add(lblNombreCursoAlumno);
			
			lblPoblacionAlumno = new JLabel();
			lblPoblacionAlumno.setText("POBLACION");
			lblPoblacionAlumno.setBounds(319, 287, 149, 19);
			panelNuevoActualizarAlumno.add(lblPoblacionAlumno);
			
			lblCodigoPostalAlumno = new JLabel();
			lblCodigoPostalAlumno.setText("CODIGO POSTAL");
			lblCodigoPostalAlumno.setBounds(319, 326, 149, 19);
			panelNuevoActualizarAlumno.add(lblCodigoPostalAlumno);
			
			comboBoxNombreCursoUSUAlumno = new JComboBox();
			comboBoxNombreCursoUSUAlumno.setBounds(517, 364, 219, 19);
			panelNuevoActualizarAlumno.add(comboBoxNombreCursoUSUAlumno);
			
			comboBoxPoblacionUSUAlumno = new JComboBox();
			comboBoxPoblacionUSUAlumno.setBounds(517, 287, 219, 19);
			panelNuevoActualizarAlumno.add(comboBoxPoblacionUSUAlumno);
			
			comboBoxCodigoPostalUSUAlumno = new JComboBox();
			comboBoxCodigoPostalUSUAlumno.setBounds(517, 326, 219, 19);
			panelNuevoActualizarAlumno.add(comboBoxCodigoPostalUSUAlumno);
			
			btnAnadirAlumno = new JButton("A\u00D1ADIR ALUMNO");
			btnAnadirAlumno.setBounds(403, 423, 189, 76);
			panelNuevoActualizarAlumno.add(btnAnadirAlumno);
			
			btnNuevaPoblacionAlumno = new JButton("NUEVA POBLACION");
			btnNuevaPoblacionAlumno.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnNuevaPoblacionAlumno.setBounds(766, 287, 149, 19);
			panelNuevoActualizarAlumno.add(btnNuevaPoblacionAlumno);
			
			btnNuevoCursoAlumno = new JButton("NUEVO CURSO");
			btnNuevoCursoAlumno.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnNuevoCursoAlumno.setBounds(766, 363, 149, 19);
			panelNuevoActualizarAlumno.add(btnNuevoCursoAlumno);
			
			lblErroresNuevoAlumno = new JLabel();
			lblErroresNuevoAlumno.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblErroresNuevoAlumno.setBounds(337, 528, 352, 56);
			panelNuevoActualizarAlumno.add(lblErroresNuevoAlumno);
			
			btnModificarAlumno = new JButton("MODIFICAR ALUMNO");
			btnModificarAlumno.setBounds(403, 423, 189, 76);
			panelNuevoActualizarAlumno.add(btnModificarAlumno);
			
			lblTituloModificarAlumno = new JLabel();
			lblTituloModificarAlumno.setText("MODIFICAR ALUMNO");
			lblTituloModificarAlumno.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblTituloModificarAlumno.setBounds(403, 24, 300, 50);
			panelNuevoActualizarAlumno.add(lblTituloModificarAlumno);

        // -----------------------------------------------------------------
     
     	// -----------------------------------------------------------------
     	/**
     	 * PANEL EMPRESAS
     	 */

			panelListaEmpresas = new JPanel();
			panelListaEmpresas.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			panelListaEmpresas.setBackground(Color.WHITE);
			panelListaEmpresas.setBounds(368, 132, 1138, 648);
			panelPrincipal.add(panelListaEmpresas);
			panelListaEmpresas.setLayout(null);
			
			JLabel lblTituloEmpresa = new JLabel("EMPRESA");
			lblTituloEmpresa.setFont(new Font("Agency FB", Font.BOLD, 50));
			lblTituloEmpresa.setBounds(155, 40, 172, 60);
			panelListaEmpresas.add(lblTituloEmpresa);
            
			listEmpresas = new JList<String>();
			listEmpresas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			listEmpresas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            modelEmpresas = new DefaultListModel<>();
            
            JScrollPane listPaneEmpresas = new JScrollPane();
            listPaneEmpresas.setBounds(49, 109, 710, 447);
            listPaneEmpresas.setViewportView(listEmpresas);
            listEmpresas.setLayoutOrientation(JList.VERTICAL);
            panelListaEmpresas.add(listPaneEmpresas);
			
            
            btnPanelAddEmpresa = new JButton("AÑADIR NUEVO");
            btnPanelAddEmpresa.setBackground(Color.GREEN);
            btnPanelAddEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
            btnPanelAddEmpresa.setBounds(874, 518, 205, 55);
            panelListaEmpresas.add(btnPanelAddEmpresa);
            
            
            btnPanelModificarEmpresa = new JButton("MODIFICAR");
            btnPanelModificarEmpresa.setBackground(Color.ORANGE);
            btnPanelModificarEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
            btnPanelModificarEmpresa.setBounds(874, 230, 205, 55);
            panelListaEmpresas.add(btnPanelModificarEmpresa);
            
            
            btnEliminarEmpresa = new JButton("ELIMINAR");
            btnEliminarEmpresa.setBackground(Color.RED);
            btnEliminarEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
            btnEliminarEmpresa.setBounds(874, 312, 205, 55);
            panelListaEmpresas.add(btnEliminarEmpresa);
            
        /**
		 * PANEL NUEVA EMPRESA
		 */
		panelNuevaEmpresa = new JPanel();
		panelNuevaEmpresa.setBounds(368, 132, 1138, 648);
		panelNuevaEmpresa.setBackground(Color.WHITE);
		panelNuevaEmpresa.setForeground(new Color(102, 255, 204));
		panelNuevaEmpresa.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panelNuevaEmpresa.setLayout(null);
		panelPrincipal.add(panelNuevaEmpresa);
			
			lblTituloNuevoEmpresa = new JLabel();
			lblTituloNuevoEmpresa.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblTituloNuevoEmpresa.setText("NUEVA EMPRESA");
			lblTituloNuevoEmpresa.setBounds(457, 20, 217, 35);
			panelNuevaEmpresa.add(lblTituloNuevoEmpresa);
		
			lblCIFEmpresa = new JLabel();
			lblCIFEmpresa.setText("CIF");
			lblCIFEmpresa.setBounds(374, 84, 110, 19);
			panelNuevaEmpresa.add(lblCIFEmpresa);
			
			lblNombreEmpresa = new JLabel();
			lblNombreEmpresa.setText("NOMBRE");
			lblNombreEmpresa.setBounds(374, 113, 136, 19);
			panelNuevaEmpresa.add(lblNombreEmpresa);
				
			lblDireccionEmpresa = new JLabel();
			lblDireccionEmpresa.setText("DIRECCION");
			lblDireccionEmpresa.setBounds(374, 142, 96, 19);
			panelNuevaEmpresa.add(lblDireccionEmpresa);
			
			lblTelefono1Empresa = new JLabel();
			lblTelefono1Empresa.setText("TELEFONO 1");
			lblTelefono1Empresa.setBounds(374, 246, 96, 19);
			panelNuevaEmpresa.add(lblTelefono1Empresa);
				
			lblTelefono2Empresa = new JLabel();
			lblTelefono2Empresa.setText("TELEFONO 2");
			lblTelefono2Empresa.setBounds(374, 273, 136, 19);
			panelNuevaEmpresa.add(lblTelefono2Empresa);
			
			lblEmailEmpresa = new JLabel();
			lblEmailEmpresa.setText("CORREO");
			lblEmailEmpresa.setBounds(374, 220, 136, 19);
			panelNuevaEmpresa.add(lblEmailEmpresa);
			
			lblFaxEmpresa = new JLabel();
			lblFaxEmpresa.setText("FAX");
			lblFaxEmpresa.setBounds(374, 300, 136, 19);
			panelNuevaEmpresa.add(lblFaxEmpresa);
			
			lblPaginaWebEmpresa = new JLabel();
			lblPaginaWebEmpresa.setText("PAGINA WEB");
			lblPaginaWebEmpresa.setBounds(374, 326, 136, 19);
			panelNuevaEmpresa.add(lblPaginaWebEmpresa);
			
			lblDNIGerenteEmpresa = new JLabel();
			lblDNIGerenteEmpresa.setText("DNI GERENTE");
			lblDNIGerenteEmpresa.setBounds(374, 384, 136, 19);
			panelNuevaEmpresa.add(lblDNIGerenteEmpresa);
			
			lblNombreGerenteEmpresa = new JLabel();
			lblNombreGerenteEmpresa.setText("NOMBRE GERENTE");
			lblNombreGerenteEmpresa.setBounds(374, 415, 136, 19);
			panelNuevaEmpresa.add(lblNombreGerenteEmpresa);
			
			lblDNIPersonaContactoEmpresa = new JLabel();
			lblDNIPersonaContactoEmpresa.setText("DNI PERSONA DE CONTACTO");
			lblDNIPersonaContactoEmpresa.setBounds(374, 444, 204, 19);
			panelNuevaEmpresa.add(lblDNIPersonaContactoEmpresa);
			
			lblPersonaContactoEmpresaEmpresa = new JLabel();
			lblPersonaContactoEmpresaEmpresa.setText("PERSONA DE CONTACTO");
			lblPersonaContactoEmpresaEmpresa.setBounds(374, 473, 222, 19);
			panelNuevaEmpresa.add(lblPersonaContactoEmpresaEmpresa);
			
			lblFechaActualizacionEmpresa = new JLabel();
			lblFechaActualizacionEmpresa.setText("FECHA ACTUALIZACION DATOS");
			lblFechaActualizacionEmpresa.setBounds(374, 531, 192, 19);
			panelNuevaEmpresa.add(lblFechaActualizacionEmpresa);
			
			lblOrganismoPublicoEmpresa = new JLabel();
			lblOrganismoPublicoEmpresa.setText("ORGANISMO PUBLICO");
			lblOrganismoPublicoEmpresa.setBounds(374, 355, 136, 19);
			panelNuevaEmpresa.add(lblOrganismoPublicoEmpresa);
			
			lblObservacionesEmpresa = new JLabel();
			lblObservacionesEmpresa.setText("OBSERVACIONES");
			lblObservacionesEmpresa.setBounds(374, 502, 136, 19);
			panelNuevaEmpresa.add(lblObservacionesEmpresa);
			
			lblPoblacionEmpresa = new JLabel();
			lblPoblacionEmpresa.setText("POBLACION");
			lblPoblacionEmpresa.setBounds(374, 166, 136, 19);
			panelNuevaEmpresa.add(lblPoblacionEmpresa);
			
			lblCodigoPostalEmpresa = new JLabel();
			lblCodigoPostalEmpresa.setText("CODIGO POSTAL");
			lblCodigoPostalEmpresa.setBounds(374, 194, 149, 19);
			panelNuevaEmpresa.add(lblCodigoPostalEmpresa);
			
			txtCIFEmpresa = new JTextField();
			txtCIFEmpresa.setBounds(633, 84, 190, 19);
			panelNuevaEmpresa.add(txtCIFEmpresa);
			
			restrictedtxtCIFEmpresa = new RestrictedTextField(txtCIFEmpresa);
			restrictedtxtCIFEmpresa.setLimit(10);
			
			txtNombreEmpresa = new JTextField();
			txtNombreEmpresa.setBounds(633, 113, 190, 19);
			panelNuevaEmpresa.add(txtNombreEmpresa);
				
			txtDireccionEmpresa = new JTextField();
			txtDireccionEmpresa.setBounds(633, 142, 190, 19);
			panelNuevaEmpresa.add(txtDireccionEmpresa);
			
			txtTelefono1Empresa = new JTextField();
			txtTelefono1Empresa.setBounds(633, 246, 190, 19);
			panelNuevaEmpresa.add(txtTelefono1Empresa);
			
			restrictedtxtTelefono1Empresa = new RestrictedTextField(txtTelefono1Empresa);
			restrictedtxtTelefono1Empresa.setLimit(9);
			restrictedtxtTelefono1Empresa.setOnlyNums(true);
			
			txtTelefono2Empresa = new JTextField();
			txtTelefono2Empresa.setBounds(633, 273, 190, 19);
			panelNuevaEmpresa.add(txtTelefono2Empresa);
			
			restrictedtxtTelefono2Empresa = new RestrictedTextField(txtTelefono2Empresa);
			restrictedtxtTelefono2Empresa.setLimit(9);
			restrictedtxtTelefono2Empresa.setOnlyNums(true);
			
			txtEmailEmpresa = new JTextField();
			txtEmailEmpresa.setBounds(633, 220, 190, 19);
			panelNuevaEmpresa.add(txtEmailEmpresa);
			
			txtFaxEmpresa = new JTextField();
			txtFaxEmpresa.setBounds(633, 300, 190, 19);
			panelNuevaEmpresa.add(txtFaxEmpresa);
			
			txtPaginaWebEmpresa = new JTextField();
			txtPaginaWebEmpresa.setBounds(633, 326, 190, 19);
			panelNuevaEmpresa.add(txtPaginaWebEmpresa);
			
			txtDNIGerenteEmpresa = new JTextField();
			txtDNIGerenteEmpresa.setBounds(633, 384, 190, 19);
			panelNuevaEmpresa.add(txtDNIGerenteEmpresa);
			
			restrictedtxtDNIGerenteEmpresa = new RestrictedTextField(txtDNIGerenteEmpresa);
			restrictedtxtDNIGerenteEmpresa.setLimit(9);
			
			txtNombreGerenteEmpresa = new JTextField();
			txtNombreGerenteEmpresa.setBounds(633, 415, 190, 19);
			panelNuevaEmpresa.add(txtNombreGerenteEmpresa);
			
			txtPersonaContactoEmpresa = new JTextField();
			txtPersonaContactoEmpresa.setBounds(633, 473, 190, 19);
			panelNuevaEmpresa.add(txtPersonaContactoEmpresa);
			
			txtDNIPersonaContactoEmpresaEmpresa = new JTextField();
			txtDNIPersonaContactoEmpresaEmpresa.setBounds(633, 444, 190, 19);
			panelNuevaEmpresa.add(txtDNIPersonaContactoEmpresaEmpresa);
			
			restrictedtxtDNIPersonaContactoEmpresaEmpresa = new RestrictedTextField(txtDNIPersonaContactoEmpresaEmpresa);
			restrictedtxtDNIPersonaContactoEmpresaEmpresa.setLimit(9);
			
			lblFechaActualizacionUSUEmpresa = new JLabel();
			lblFechaActualizacionUSUEmpresa.setBounds(633, 531, 190, 19);
			panelNuevaEmpresa.add(lblFechaActualizacionUSUEmpresa);
			
			checkBoxOrganismoPublicoUSUEmpresa = new JCheckBox();
			checkBoxOrganismoPublicoUSUEmpresa.setBackground(Color.WHITE);
			checkBoxOrganismoPublicoUSUEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 50));
			checkBoxOrganismoPublicoUSUEmpresa.setBounds(633, 353, 28, 21);
			panelNuevaEmpresa.add(checkBoxOrganismoPublicoUSUEmpresa);
			
			txtObservacionesEmpresa = new JTextField();
			txtObservacionesEmpresa.setBounds(633, 502, 190, 19);
			panelNuevaEmpresa.add(txtObservacionesEmpresa);
		
			comboBoxPoblacionUSUEmpresa = new JComboBox();
			comboBoxPoblacionUSUEmpresa.setBounds(633, 168, 190, 19);
			panelNuevaEmpresa.add(comboBoxPoblacionUSUEmpresa);
			
			comboBoxCodigoPostalUSUEmpresa = new JComboBox();
			comboBoxCodigoPostalUSUEmpresa.setBounds(633, 194, 190, 19);
			panelNuevaEmpresa.add(comboBoxCodigoPostalUSUEmpresa);
			
			btnAnadirEmpresa = new JButton("A\u00D1ADIR EMPRESA");
			btnAnadirEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnAnadirEmpresa.setBounds(457, 576, 217, 50);
			panelNuevaEmpresa.add(btnAnadirEmpresa);	
			
			btnNuevaPoblacionEmpresa = new JButton("NUEVA POBLACION");
			btnNuevaPoblacionEmpresa.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnNuevaPoblacionEmpresa.setBounds(849, 168, 149, 19);
			panelNuevaEmpresa.add(btnNuevaPoblacionEmpresa);
			
			lblErroresNuevaEmpresa = new JLabel();
			lblErroresNuevaEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblErroresNuevaEmpresa.setBounds(745, 570, 352, 56);
			panelNuevaEmpresa.add(lblErroresNuevaEmpresa);
	
            
		/**
		 * Panel nueva Poblacion
		 */
		panelNuevaPoblacion = new JPanel();
		panelNuevaPoblacion.setBounds(368, 132, 1138, 648);
		panelNuevaPoblacion.setBackground(Color.WHITE);
		panelNuevaPoblacion.setForeground(new Color(102, 255, 204));
		panelNuevaPoblacion.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panelNuevaPoblacion.setLayout(null);
		panelPrincipal.add(panelNuevaPoblacion);
		
			lblCodigoPostalPoblacion = new JLabel();
			lblCodigoPostalPoblacion.setText("CODIGO POSTAL");
			lblCodigoPostalPoblacion.setBounds(234, 157, 110, 19);
			panelNuevaPoblacion.add(lblCodigoPostalPoblacion);
			
			lblNombrePoblacion = new JLabel();
			lblNombrePoblacion.setText("NOMBRE POBLACION");
			lblNombrePoblacion.setBounds(234, 203, 136, 19);
			panelNuevaPoblacion.add(lblNombrePoblacion);
			
			lblProvinciaPoblacion = new JLabel();
			lblProvinciaPoblacion.setText("PROVINCIA");
			lblProvinciaPoblacion.setBounds(234, 248, 96, 19);
			panelNuevaPoblacion.add(lblProvinciaPoblacion);
			
			txtCodigoPostalUSUPoblacion = new JTextField();
			txtCodigoPostalUSUPoblacion.setColumns(10);
			txtCodigoPostalUSUPoblacion.setBounds(432, 157, 219, 19);
			panelNuevaPoblacion.add(txtCodigoPostalUSUPoblacion);
			
			txtNombreUSUPoblacion = new JTextField();
			txtNombreUSUPoblacion.setColumns(10);
			txtNombreUSUPoblacion.setBounds(432, 203, 219, 19);
			panelNuevaPoblacion.add(txtNombreUSUPoblacion);
			
			txtProvinciaUSUPoblacion = new JTextField();
			txtProvinciaUSUPoblacion.setColumns(10);
			txtProvinciaUSUPoblacion.setBounds(432, 248, 219, 19);
			panelNuevaPoblacion.add(txtProvinciaUSUPoblacion);
		
			lblTituloNuevaPoblacion = new JLabel();
			lblTituloNuevaPoblacion.setHorizontalAlignment(SwingConstants.CENTER);
			lblTituloNuevaPoblacion.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblTituloNuevaPoblacion.setText("NUEVA POBLACION");
			lblTituloNuevaPoblacion.setBounds(296, 21, 268, 35);
			panelNuevaPoblacion.add(lblTituloNuevaPoblacion);
			
			btnAnadirPoblacion = new JButton("A\u00D1ADIR POBLACION");
			btnAnadirPoblacion.setBounds(306, 422, 189, 76);
			panelNuevaPoblacion.add(btnAnadirPoblacion);
			
			lblErroresNuevaPoblacion = new JLabel();
			lblErroresNuevaPoblacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblErroresNuevaPoblacion.setBounds(247, 523, 352, 56);
			panelNuevaPoblacion.add(lblErroresNuevaPoblacion);
	
			/**
			 * Panel nuevo Curso
			 */
			panelNuevoCurso = new JPanel();
			panelNuevoCurso.setBounds(368, 132, 1138, 648);
			panelNuevoCurso.setBackground(Color.WHITE);
			panelNuevoCurso.setForeground(new Color(102, 255, 204));
			panelNuevoCurso.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			panelNuevoCurso.setLayout(null);
			panelPrincipal.add(panelNuevoCurso);
			
				lblNombreCurso = new JLabel();
				lblNombreCurso.setText("NOMBRE");
				lblNombreCurso.setBounds(235, 123, 110, 19);
				panelNuevoCurso.add(lblNombreCurso);
				
				lblNombreAbrevCurso = new JLabel();
				lblNombreAbrevCurso.setText("NOMBRE ABREVIADO");
				lblNombreAbrevCurso.setBounds(235, 169, 136, 19);
				panelNuevoCurso.add(lblNombreAbrevCurso);
				
				lblClaveCurso = new JLabel();
				lblClaveCurso.setText("CLAVE");
				lblClaveCurso.setBounds(235, 214, 96, 19);
				panelNuevoCurso.add(lblClaveCurso);
				
				lblHorasFCTCurso = new JLabel();
				lblHorasFCTCurso.setText("HORAS FCT");
				lblHorasFCTCurso.setBounds(235, 263, 96, 19);
				panelNuevoCurso.add(lblHorasFCTCurso);
				
				lblEsPublicoCurso = new JLabel();
				lblEsPublicoCurso.setText("ENSE�ANZA PUBLICA");
				lblEsPublicoCurso.setBounds(235, 307, 136, 19);
				panelNuevoCurso.add(lblEsPublicoCurso);
				
				txtNombreUSUCurso = new JTextField();
				txtNombreUSUCurso.setColumns(10);
				txtNombreUSUCurso.setBounds(433, 123, 219, 19);
				panelNuevoCurso.add(txtNombreUSUCurso);
				
				txtNombreAbrevUSUCurso = new JTextField();
				txtNombreAbrevUSUCurso.setColumns(10);
				txtNombreAbrevUSUCurso.setBounds(433, 169, 219, 19);
				panelNuevoCurso.add(txtNombreAbrevUSUCurso);
				
				txtClaveUSUCurso = new JTextField();
				txtClaveUSUCurso.setColumns(10);
				txtClaveUSUCurso.setBounds(433, 214, 219, 19);
				panelNuevoCurso.add(txtClaveUSUCurso);
				
				txtHorasFCTUSUCurso = new JTextField();
				txtHorasFCTUSUCurso.setColumns(10);
				txtHorasFCTUSUCurso.setBounds(433, 263, 219, 19);
				panelNuevoCurso.add(txtHorasFCTUSUCurso);
				
				lblTituloNuevoCurso = new JLabel();
				lblTituloNuevoCurso.setHorizontalAlignment(SwingConstants.CENTER);
				lblTituloNuevoCurso.setFont(new Font("Tahoma", Font.BOLD, 24));
				lblTituloNuevoCurso.setText("NUEVO CURSO");
				lblTituloNuevoCurso.setBounds(296, 21, 236, 35);
				panelNuevoCurso.add(lblTituloNuevoCurso);
				
				checkBoxEsPublicoUSUCurso = new JCheckBox();
				checkBoxEsPublicoUSUCurso.setBackground(Color.WHITE);
				checkBoxEsPublicoUSUCurso.setFont(new Font("Tahoma", Font.PLAIN, 50));
				checkBoxEsPublicoUSUCurso.setBounds(433, 307, 28, 21);
				panelNuevoCurso.add(checkBoxEsPublicoUSUCurso);
				
				btnAnadirCurso = new JButton("A\u00D1ADIR CURSO");
				btnAnadirCurso.setBounds(306, 422, 189, 76);
				panelNuevoCurso.add(btnAnadirCurso);
			
				lblErroresNuevoCurso = new JLabel();
				lblErroresNuevoCurso.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblErroresNuevoCurso.setBounds(247, 523, 352, 56);
				panelNuevoCurso.add(lblErroresNuevoCurso);
			
			
		
		 	
	}
}
