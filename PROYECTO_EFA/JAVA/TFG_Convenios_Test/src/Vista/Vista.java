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
import javax.swing.ImageIcon;
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
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JMenu;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Panel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.SystemColor;


public class Vista extends JFrame {

	public JPanel contentPane;
	
	/**
	 * PANEL PRINCIPAL
	 */
	public JPanel panelPrincipal;
		public JButton btnInicio;
		public JLabel lblLogoInicio;
		public JLabel labelTitulo;
		public JLabel lblLogo;
		
		public JPanel panelMenu;
			public JButton btnPanelAlumnos;
			public JButton btnPanelEmpresas;
			public JButton btnPanelPeriodos;
			public JButton btnPanelPracticas;
			public JButton btnPanelInstrucciones;
	/**
	 *PANEL INSTRUCCIONES 	
	 */
	public JPanel panelInstrucciones;
	public JLabel lblInstrucciones;
	
	
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
		
		/**
		 * PANEL LISTA EMPRESA
		 */
	public JPanel panelListaEmpresas;	

		public JButton btnPanelAddEmpresa;
		public JButton btnPanelModificarEmpresa;
		public JButton btnEliminarEmpresa;
	
		public JTextField txtFiltroListaEmpresa;
		public JList listEmpresas;
		public DefaultListModel modelEmpresas;
		
		public JButton btnBuscarListaEmpresas;
		public JButton btnPanelConvenio;
		
	/**
	* PANEL NUEVA EMPRESA
	*/
	public JPanel panelNuevaActualizarEmpresa;
		public JLabel lblTituloNuevoEmpresa;
		public JLabel lblTituloModificarEmpresa;
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
		public JButton btnModificarEmpresa;
		public JButton btnNuevaPoblacionEmpresa;
			
	/**
	 * PANEL CONVENIO
	 */
		
	public JPanel panelConvenios;
		public JComboBox comboBoxListaCursoConvenio;
		
		public JList listConvenios;
		public DefaultListModel modelConvenios;
		
		public JButton btnActualizarConvenio;
		
		
		
		public JPanel panelCrearNuevoConvenio;
		public JComboBox comboBoxTipoConvenioPanelConvenio;
		public JLabel lblNombreEmpresaConvenios;
		public JButton btnPanelCrearNuevoConvenio;
		public JButton btnCrearConvenio;
		public JLabel lblError2Convenio;
		
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
		public JButton btnAnadirPoblacionAlumno;
		public JButton btnAnadirPoblacionEmpresa;
		public JLabel lblErroresNuevaPoblacion;	
	
	/**
	 * PANEL PERIODOS	
	 */
	public JPanel panelPeriodos;
		public JLabel lblTituloPeriodos;
		public JComboBox comboBoxListaCursoPeriodo;
		public JComboBox comboBoxListaTipoPeriodo;
		public JDateChooser dateChooserFechaInicioPeriodo;
		public JDateChooser dateChooserFechaFinPeriodo;
		public JComboBox comboBoxListaProfesorPeriodo;
		public JButton btnCrearPeriodo;
		public JButton btnEliminarPeriodo;
		
		public JList listPeriodos;
		public DefaultListModel modelPeriodos;	
		public JLabel lblTipoPeriodos;
		public JLabel lblFechaInicioPeriodos;
		public JLabel lblFechaFinPeriodos;
		public JLabel lblNombreProfesorPeriodos;
		
	
	/**
	 * PANEL PRACTICAS
	 */
	public JPanel panelPracticas;
		public JLabel lblTituloPracticas;
		
		public JList listPeriodosPracticas;
		public DefaultListModel modelPeriodosPracticas;
		public JButton btnAsignarPeriodoPracticas;
		
		public JLabel lblTituloListaAlumnosPracticas;
		public JScrollPane listPaneAlumnosPracticas;
		public JList listAlumnosPracticas;
		public DefaultListModel modelAlumnosPracticas;
		
		public JLabel lblTituloListaEmpresasPracticas;
		public JScrollPane listPaneEmpresasPracticas;
		public JList listEmpresasPracticas;
		public DefaultListModel modelEmpresasPracticas;
		public JButton btnAsignarEmpresaPracticas;
		
		public JLabel lblTituloListaAnexarPracticas;
		public JScrollPane listPaneAnexarPracticas;
		public JList listAnexarPracticas;
		public DefaultListModel modelAnexarPracticas;
		public JButton btnEliminarAnexarPracticas;
		
		public JButton btnPanelDocumentos;
		
	/**
	* PANEL DOCUMENTOS
	*/
	public JPanel panelDocumentos;
		public JLabel lblTituloDocumentos;
		public JButton btnGuardarDocumentos;
		public JCheckBox checkBoxAnexo0;
		public JCheckBox checkBoxAnexo0A;
		public JCheckBox checkBoxAnexo1;
		public JCheckBox checkBoxAnexo2;
		public JCheckBox checkBoxAnexo3;
		public JCheckBox checkBoxAnexo4FCT;
		public JCheckBox checkBoxAnexo4PFE;
		public JLabel lblFCToPFEDocumentos;
		public JButton btnAtrasDocumentos;
		public JLabel lblInfoRutaDocumentos;
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
			
			labelTitulo = new JLabel("GENERADOR DE DOCUMENTOS");
			labelTitulo.setBackground(new Color(255, 255, 255));
			labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitulo.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 60));
			labelTitulo.setForeground(Color.WHITE);
			labelTitulo.setBounds(10, 10, 1538, 114);
			panelPrincipal.add(labelTitulo);
			
			lblLogoInicio = new JLabel("");
			lblLogoInicio.setBackground(new Color(255, 255, 255));
			lblLogoInicio.setIcon(new ImageIcon("imagenes/MORATALAZ_BLANCO_INICIO.png"));
			lblLogoInicio.setBounds(450, 180, 643, 300);
			panelPrincipal.add(lblLogoInicio);
			
			btnInicio = new JButton("Iniciar Aplicación");
			btnInicio.setBounds(540, 600, 479, 76);
			btnInicio.setBackground(new Color(255, 255, 255));
			btnInicio.setForeground(new Color(0, 128, 0));
			btnInicio.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 40));
			panelPrincipal.add(btnInicio);
			
			panelMenu = new JPanel();
			panelMenu.setBackground(new Color(0, 204, 51));
			panelMenu.setBorder(new MatteBorder(5, 3, 5, 3, (Color) new Color(0, 0, 0)));
			panelMenu.setBounds(20, 132, 324, 648);
			panelPrincipal.add(panelMenu);
			panelMenu.setLayout(null);
			
			btnPanelAlumnos = new JButton("Alumnos");
			btnPanelAlumnos.setBackground(Color.WHITE);
			btnPanelAlumnos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
			btnPanelAlumnos.setBounds(53, 67, 219, 37);
			panelMenu.add(btnPanelAlumnos);
			
			btnPanelEmpresas = new JButton("Empresas");
			btnPanelEmpresas.setBackground(Color.WHITE);
			btnPanelEmpresas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
			btnPanelEmpresas.setBounds(53, 147, 219, 37);
			panelMenu.add(btnPanelEmpresas);
			
			btnPanelPeriodos = new JButton("Periodos");
			btnPanelPeriodos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
			btnPanelPeriodos.setBackground(Color.WHITE);
			btnPanelPeriodos.setBounds(53, 227, 219, 37);
			panelMenu.add(btnPanelPeriodos);
			
			btnPanelPracticas = new JButton("Prácticas");
			btnPanelPracticas.setBackground(Color.WHITE);
			btnPanelPracticas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
			btnPanelPracticas.setBounds(53, 307, 219, 37);
			panelMenu.add(btnPanelPracticas);
			
			btnPanelInstrucciones = new JButton("Instrucciones");
			btnPanelInstrucciones.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
			btnPanelInstrucciones.setBackground(Color.WHITE);
			btnPanelInstrucciones.setBounds(53, 505, 219, 37);
			panelMenu.add(btnPanelInstrucciones);
			
			lblLogo = new JLabel("");
			lblLogo.setBounds(60, 0, 271, 127);
			lblLogo.setBackground(Color.WHITE);
			lblLogo.setVisible(false);
			lblLogo.setIcon(new ImageIcon("imagenes/MORATALAZ_BLANCO.png"));
			panelPrincipal.add(lblLogo);
			
			/**
			 * PANEL INSTRUCCIONES	
			*/ 
			
			panelInstrucciones = new JPanel();
			panelInstrucciones.setBackground(Color.WHITE);
			panelInstrucciones.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			panelInstrucciones.setBounds(368, 132, 1157, 648);
			panelPrincipal.add(panelInstrucciones);
			panelInstrucciones.setLayout(null);
			
			lblInstrucciones = new JLabel("");
			lblInstrucciones.setBounds(49, 101, 1070, 535);
			lblInstrucciones.setBackground(Color.WHITE);
			lblInstrucciones.setVisible(true);
			lblInstrucciones.setIcon(new ImageIcon("imagenes/instrucciones.png"));
			panelInstrucciones.add(lblInstrucciones);
			
			JLabel lblTituloInstrucciones = new JLabel("INSTRUCCIONES");
			lblTituloInstrucciones.setFont(new Font("Agency FB", Font.BOLD, 50));
			lblTituloInstrucciones.setBounds(49, 21, 297, 70);
			panelInstrucciones.add(lblTituloInstrucciones);
		
		
			
			/**
			 * PANEL ALUMNOS	
			*/
			
			panelListaAlumno = new JPanel();
			panelListaAlumno.setBackground(Color.WHITE);
			panelListaAlumno.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			panelListaAlumno.setBounds(368, 132, 1157, 648);
			panelPrincipal.add(panelListaAlumno);
			panelListaAlumno.setLayout(null);
			
			JLabel lblTituloAlumnos = new JLabel("ALUMNOS");
			lblTituloAlumnos.setFont(new Font("Agency FB", Font.BOLD, 50));
			lblTituloAlumnos.setBounds(49, 21, 183, 55);
			panelListaAlumno.add(lblTituloAlumnos);
		
			
			listAlumnos = new JList<String>();
			listAlumnos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			listAlumnos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            modelAlumnos = new DefaultListModel<>();
            
     
            JScrollPane listPaneAlumnos = new JScrollPane();
            listPaneAlumnos.setBounds(49, 219, 721, 389);
            listPaneAlumnos.setViewportView(listAlumnos);
            listAlumnos.setLayoutOrientation(JList.VERTICAL);
            panelListaAlumno.add(listPaneAlumnos);
            
            JLabel lblFiltroAlumno = new JLabel("Curso -->");
            lblFiltroAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
            lblFiltroAlumno.setBounds(49, 114, 124, 38);
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
            
            JLabel lblNombrelListaAlumno = new JLabel("NOMBRE COMPLETO");
            lblNombrelListaAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
            lblNombrelListaAlumno.setBounds(49, 173, 721, 36);
            panelListaAlumno.add(lblNombrelListaAlumno);

		/**
		 * PANEL NUEVO ALUMNO
	    */
           
		panelNuevoActualizarAlumno = new JPanel();
		panelNuevoActualizarAlumno.setBounds(368, 132, 1157, 648);
		panelNuevoActualizarAlumno.setBackground(Color.WHITE);
		panelNuevoActualizarAlumno.setForeground(new Color(102, 255, 204));
		panelNuevoActualizarAlumno.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panelNuevoActualizarAlumno.setLayout(null);
		panelPrincipal.add(panelNuevoActualizarAlumno);
		
			lblNIFAlumno = new JLabel();
			lblNIFAlumno.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblNIFAlumno.setText("NIF");
			lblNIFAlumno.setBounds(52, 100, 311, 40);
			panelNuevoActualizarAlumno.add(lblNIFAlumno);
			
			lblNombreCompletoAlumno = new JLabel();
			lblNombreCompletoAlumno.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblNombreCompletoAlumno.setText("NOMBRE COMPLETO");
			lblNombreCompletoAlumno.setBounds(50, 150, 313, 40);
			panelNuevoActualizarAlumno.add(lblNombreCompletoAlumno);
			
			lblTelefonoAlumno = new JLabel();
			lblTelefonoAlumno.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblTelefonoAlumno.setText("TELÉFONO");
			lblTelefonoAlumno.setBounds(52, 300, 311, 40);
			panelNuevoActualizarAlumno.add(lblTelefonoAlumno);
			
			lblCorreoAlumno = new JLabel();
			lblCorreoAlumno.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblCorreoAlumno.setText("CORREO");
			lblCorreoAlumno.setBounds(50, 250, 313, 40);
			panelNuevoActualizarAlumno.add(lblCorreoAlumno);
			
			lblFechaNacimientoAlumno = new JLabel();
			lblFechaNacimientoAlumno.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblFechaNacimientoAlumno.setText("FECHA NACIMIENTO");
			lblFechaNacimientoAlumno.setBounds(50, 200, 313, 40);
			panelNuevoActualizarAlumno.add(lblFechaNacimientoAlumno);
			
			txtNIFUSUAlumno = new JTextField();
			txtNIFUSUAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtNIFUSUAlumno.setColumns(10);
			txtNIFUSUAlumno.setBounds(380, 100, 401, 40);
			panelNuevoActualizarAlumno.add(txtNIFUSUAlumno);
			
			restrictedtxtNIFAlumno = new RestrictedTextField(txtNIFUSUAlumno);
			restrictedtxtNIFAlumno.setLimit(9);
			
			txtNombreCompletoUSUAlumno = new JTextField();
			txtNombreCompletoUSUAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtNombreCompletoUSUAlumno.setColumns(10);
			txtNombreCompletoUSUAlumno.setBounds(380, 150, 401, 40);
			panelNuevoActualizarAlumno.add(txtNombreCompletoUSUAlumno);
			
			txtTelefonoUSUAlumno = new JTextField();
			txtTelefonoUSUAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtTelefonoUSUAlumno.setColumns(10);
			txtTelefonoUSUAlumno.setBounds(380, 300, 401, 40);
			panelNuevoActualizarAlumno.add(txtTelefonoUSUAlumno);
			
			restrictedtxtTelefonoUSUAlumno = new RestrictedTextField(txtTelefonoUSUAlumno);
			restrictedtxtTelefonoUSUAlumno.setLimit(9);
			
			txtCorreoUSUAlumno = new JTextField();
			txtCorreoUSUAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtCorreoUSUAlumno.setColumns(10);
			txtCorreoUSUAlumno.setBounds(380, 250, 401, 40);
			panelNuevoActualizarAlumno.add(txtCorreoUSUAlumno);
			
			dateChooserFechaNacimientoUSUAlumno = new JDateChooser("dd/MM/yyyy", " ##/##/####", '_');
			dateChooserFechaNacimientoUSUAlumno.setBounds(380, 200, 171, 40);
			dateChooserFechaNacimientoUSUAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			panelNuevoActualizarAlumno.add(dateChooserFechaNacimientoUSUAlumno);
			
			lblTituloNuevoAlumno = new JLabel();
			lblTituloNuevoAlumno.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 50));
			lblTituloNuevoAlumno.setText("NUEVO ALUMNO");
			lblTituloNuevoAlumno.setBounds(49, 21, 693, 55);
			panelNuevoActualizarAlumno.add(lblTituloNuevoAlumno);
			
			lblNombreCursoAlumno = new JLabel();
			lblNombreCursoAlumno.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblNombreCursoAlumno.setText("NOMBRE CURSO");
			lblNombreCursoAlumno.setBounds(52, 450, 311, 40);
			panelNuevoActualizarAlumno.add(lblNombreCursoAlumno);
			
			lblPoblacionAlumno = new JLabel();
			lblPoblacionAlumno.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblPoblacionAlumno.setText("POBLACION");
			lblPoblacionAlumno.setBounds(52, 350, 311, 40);
			panelNuevoActualizarAlumno.add(lblPoblacionAlumno);
			
			lblCodigoPostalAlumno = new JLabel();
			lblCodigoPostalAlumno.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblCodigoPostalAlumno.setText("CODIGO POSTAL");
			lblCodigoPostalAlumno.setBounds(52, 400, 311, 40);
			panelNuevoActualizarAlumno.add(lblCodigoPostalAlumno);
			
			comboBoxNombreCursoUSUAlumno = new JComboBox();
			comboBoxNombreCursoUSUAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			comboBoxNombreCursoUSUAlumno.setBounds(380, 450, 401, 40);
			panelNuevoActualizarAlumno.add(comboBoxNombreCursoUSUAlumno);
			
			comboBoxPoblacionUSUAlumno = new JComboBox();
			comboBoxPoblacionUSUAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			comboBoxPoblacionUSUAlumno.setBounds(380, 350, 401, 40);
			panelNuevoActualizarAlumno.add(comboBoxPoblacionUSUAlumno);
			
			comboBoxCodigoPostalUSUAlumno = new JComboBox();
			comboBoxCodigoPostalUSUAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			comboBoxCodigoPostalUSUAlumno.setBounds(380, 400, 171, 40);
			panelNuevoActualizarAlumno.add(comboBoxCodigoPostalUSUAlumno);
			
			btnAnadirAlumno = new JButton("A\u00D1ADIR ALUMNO");
			btnAnadirAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
			btnAnadirAlumno.setBounds(52, 530, 270, 60);
			panelNuevoActualizarAlumno.add(btnAnadirAlumno);
			
			btnNuevaPoblacionAlumno = new JButton("NUEVA POBLACION");
			btnNuevaPoblacionAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
			btnNuevaPoblacionAlumno.setBounds(791, 350, 231, 40);
			panelNuevoActualizarAlumno.add(btnNuevaPoblacionAlumno);
			
			btnNuevoCursoAlumno = new JButton("NUEVO CURSO");
			btnNuevoCursoAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
			btnNuevoCursoAlumno.setBounds(791, 450, 231, 40);
			panelNuevoActualizarAlumno.add(btnNuevoCursoAlumno);
			
			lblErroresNuevoAlumno = new JLabel();
			lblErroresNuevoAlumno.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblErroresNuevoAlumno.setBounds(347, 530, 352, 60);
			panelNuevoActualizarAlumno.add(lblErroresNuevoAlumno);
			
			btnModificarAlumno = new JButton("MODIFICAR ALUMNO");
			btnModificarAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
			btnModificarAlumno.setBounds(52, 530, 270, 60);
			panelNuevoActualizarAlumno.add(btnModificarAlumno);
			
			lblTituloModificarAlumno = new JLabel();
			lblTituloModificarAlumno.setText("MODIFICAR ALUMNO");
			lblTituloModificarAlumno.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 50));
			lblTituloModificarAlumno.setBounds(49, 21, 687, 55);
			panelNuevoActualizarAlumno.add(lblTituloModificarAlumno);


    	/**
    	 * PANEL EMPRESAS
     	*/

			panelListaEmpresas = new JPanel();
			panelListaEmpresas.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			panelListaEmpresas.setBackground(Color.WHITE);
			panelListaEmpresas.setBounds(368, 132, 1157, 648);
			panelPrincipal.add(panelListaEmpresas);
			panelListaEmpresas.setLayout(null);
			
			JLabel lblTituloEmpresa = new JLabel("EMPRESAS");
			lblTituloEmpresa.setFont(new Font("Agency FB", Font.BOLD, 50));
			lblTituloEmpresa.setBounds(49, 21, 200, 60);
			panelListaEmpresas.add(lblTituloEmpresa);
            
			listEmpresas = new JList<String>();
			listEmpresas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			listEmpresas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            modelEmpresas = new DefaultListModel<>();
            
            JScrollPane listPaneEmpresas = new JScrollPane();
            listPaneEmpresas.setBounds(49, 175, 710, 445);
            listPaneEmpresas.setViewportView(listEmpresas);
            listEmpresas.setLayoutOrientation(JList.VERTICAL);
            panelListaEmpresas.add(listPaneEmpresas);
			
            
            btnPanelAddEmpresa = new JButton("AÑADIR NUEVA");
            btnPanelAddEmpresa.setBackground(Color.GREEN);
            btnPanelAddEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
            btnPanelAddEmpresa.setBounds(874, 536, 205, 55);
            panelListaEmpresas.add(btnPanelAddEmpresa);
            
            
            btnPanelModificarEmpresa = new JButton("MODIFICAR");
            btnPanelModificarEmpresa.setBackground(Color.ORANGE);
            btnPanelModificarEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
            btnPanelModificarEmpresa.setBounds(874, 328, 205, 55);
            panelListaEmpresas.add(btnPanelModificarEmpresa);
            
            
            btnEliminarEmpresa = new JButton("ELIMINAR");
            btnEliminarEmpresa.setBackground(Color.RED);
            btnEliminarEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
            btnEliminarEmpresa.setBounds(874, 411, 205, 55);
            panelListaEmpresas.add(btnEliminarEmpresa);
            
            btnPanelConvenio = new JButton("VER CONVENIO");
            btnPanelConvenio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
            btnPanelConvenio.setBackground(new Color(0, 204, 255));
            btnPanelConvenio.setBounds(874, 210, 205, 55);
            panelListaEmpresas.add(btnPanelConvenio);
            
            txtFiltroListaEmpresa = new JTextField();
            txtFiltroListaEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 20));
            txtFiltroListaEmpresa.setColumns(10);
            txtFiltroListaEmpresa.setBounds(50, 102, 542, 42);
            panelListaEmpresas.add(txtFiltroListaEmpresa);
            
            btnBuscarListaEmpresas = new JButton("BUSCAR");
            btnBuscarListaEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btnBuscarListaEmpresas.setBounds(621, 101, 138, 42);
            panelListaEmpresas.add(btnBuscarListaEmpresas);
            
        /**
		 * PANEL NUEVA EMPRESA
		 */
		panelNuevaActualizarEmpresa = new JPanel();
		panelNuevaActualizarEmpresa.setBounds(368, 132, 1157, 648);
		panelNuevaActualizarEmpresa.setBackground(Color.WHITE);
		panelNuevaActualizarEmpresa.setForeground(new Color(102, 255, 204));
		panelNuevaActualizarEmpresa.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panelNuevaActualizarEmpresa.setLayout(null);
		panelPrincipal.add(panelNuevaActualizarEmpresa);
			
			lblTituloNuevoEmpresa = new JLabel();
			lblTituloNuevoEmpresa.setFont(new Font("Agency FB", Font.BOLD, 50));
			lblTituloNuevoEmpresa.setText("NUEVA EMPRESA");
			lblTituloNuevoEmpresa.setBounds(49, 21, 702, 55);
			panelNuevaActualizarEmpresa.add(lblTituloNuevoEmpresa);
		
			lblCIFEmpresa = new JLabel();
			lblCIFEmpresa.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblCIFEmpresa.setText("CIF");
			lblCIFEmpresa.setBounds(49, 100, 157, 35);
			panelNuevaActualizarEmpresa.add(lblCIFEmpresa);
			
			lblNombreEmpresa = new JLabel();
			lblNombreEmpresa.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblNombreEmpresa.setText("NOMBRE");
			lblNombreEmpresa.setBounds(49, 140, 157, 35);
			panelNuevaActualizarEmpresa.add(lblNombreEmpresa);
				
			lblDireccionEmpresa = new JLabel();
			lblDireccionEmpresa.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblDireccionEmpresa.setText("DIRECCIÓN");
			lblDireccionEmpresa.setBounds(49, 180, 157, 35);
			panelNuevaActualizarEmpresa.add(lblDireccionEmpresa);
			
			lblTelefono1Empresa = new JLabel();
			lblTelefono1Empresa.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblTelefono1Empresa.setText("TELÉFONO 1");
			lblTelefono1Empresa.setBounds(49, 300, 157, 35);
			panelNuevaActualizarEmpresa.add(lblTelefono1Empresa);
				
			lblTelefono2Empresa = new JLabel();
			lblTelefono2Empresa.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblTelefono2Empresa.setText("TELÉFONO 2");
			lblTelefono2Empresa.setBounds(49, 340, 157, 35);
			panelNuevaActualizarEmpresa.add(lblTelefono2Empresa);
			
			lblEmailEmpresa = new JLabel();
			lblEmailEmpresa.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblEmailEmpresa.setText("CORREO");
			lblEmailEmpresa.setBounds(49, 380, 157, 35);
			panelNuevaActualizarEmpresa.add(lblEmailEmpresa);
			
			lblFaxEmpresa = new JLabel();
			lblFaxEmpresa.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblFaxEmpresa.setText("FAX");
			lblFaxEmpresa.setBounds(49, 420, 157, 35);
			panelNuevaActualizarEmpresa.add(lblFaxEmpresa);
			
			lblPaginaWebEmpresa = new JLabel();
			lblPaginaWebEmpresa.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblPaginaWebEmpresa.setText("PÁGINA WEB");
			lblPaginaWebEmpresa.setBounds(543, 100, 268, 35);
			panelNuevaActualizarEmpresa.add(lblPaginaWebEmpresa);
			
			lblDNIGerenteEmpresa = new JLabel();
			lblDNIGerenteEmpresa.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblDNIGerenteEmpresa.setText("DNI GERENTE");
			lblDNIGerenteEmpresa.setBounds(543, 180, 268, 35);
			panelNuevaActualizarEmpresa.add(lblDNIGerenteEmpresa);
			
			lblNombreGerenteEmpresa = new JLabel();
			lblNombreGerenteEmpresa.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblNombreGerenteEmpresa.setText("NOMBRE GERENTE");
			lblNombreGerenteEmpresa.setBounds(543, 220, 268, 35);
			panelNuevaActualizarEmpresa.add(lblNombreGerenteEmpresa);
			
			lblDNIPersonaContactoEmpresa = new JLabel();
			lblDNIPersonaContactoEmpresa.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblDNIPersonaContactoEmpresa.setText("DNI PERSONA DE CONTACTO");
			lblDNIPersonaContactoEmpresa.setBounds(543, 260, 268, 35);
			panelNuevaActualizarEmpresa.add(lblDNIPersonaContactoEmpresa);
			
			lblPersonaContactoEmpresaEmpresa = new JLabel();
			lblPersonaContactoEmpresaEmpresa.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblPersonaContactoEmpresaEmpresa.setText("PERSONA DE CONTACTO");
			lblPersonaContactoEmpresaEmpresa.setBounds(543, 300, 268, 35);
			panelNuevaActualizarEmpresa.add(lblPersonaContactoEmpresaEmpresa);
			
			lblFechaActualizacionEmpresa = new JLabel();
			lblFechaActualizacionEmpresa.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblFechaActualizacionEmpresa.setText("<html><body>FECHA ACTUALIZACIÓN  <br> DATOS <br></body></html>");
			lblFechaActualizacionEmpresa.setBounds(543, 380, 268, 65);
			panelNuevaActualizarEmpresa.add(lblFechaActualizacionEmpresa);
			
			lblOrganismoPublicoEmpresa = new JLabel();
			lblOrganismoPublicoEmpresa.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblOrganismoPublicoEmpresa.setText("ORGANISMO PÚBLICO");
			lblOrganismoPublicoEmpresa.setBounds(543, 140, 268, 35);
			panelNuevaActualizarEmpresa.add(lblOrganismoPublicoEmpresa);
			
			lblObservacionesEmpresa = new JLabel();
			lblObservacionesEmpresa.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblObservacionesEmpresa.setText("OBSERVACIONES");
			lblObservacionesEmpresa.setBounds(543, 340, 268, 35);
			panelNuevaActualizarEmpresa.add(lblObservacionesEmpresa);
			
			lblPoblacionEmpresa = new JLabel();
			lblPoblacionEmpresa.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblPoblacionEmpresa.setText("POBLACIÓN");
			lblPoblacionEmpresa.setBounds(49, 220, 157, 35);
			panelNuevaActualizarEmpresa.add(lblPoblacionEmpresa);
			
			lblCodigoPostalEmpresa = new JLabel();
			lblCodigoPostalEmpresa.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblCodigoPostalEmpresa.setText("CÓDIGO POSTAL");
			lblCodigoPostalEmpresa.setBounds(49, 260, 157, 35);
			panelNuevaActualizarEmpresa.add(lblCodigoPostalEmpresa);
			
			txtCIFEmpresa = new JTextField();
			txtCIFEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtCIFEmpresa.setBounds(215, 100, 283, 35);
			panelNuevaActualizarEmpresa.add(txtCIFEmpresa);
			
			restrictedtxtCIFEmpresa = new RestrictedTextField(txtCIFEmpresa);
			restrictedtxtCIFEmpresa.setLimit(10);
			
			txtNombreEmpresa = new JTextField();
			txtNombreEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtNombreEmpresa.setBounds(216, 140, 283, 35);
			panelNuevaActualizarEmpresa.add(txtNombreEmpresa);
				
			txtDireccionEmpresa = new JTextField();
			txtDireccionEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtDireccionEmpresa.setBounds(215, 180, 283, 35);
			panelNuevaActualizarEmpresa.add(txtDireccionEmpresa);
			
			txtTelefono1Empresa = new JTextField();
			txtTelefono1Empresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtTelefono1Empresa.setBounds(215, 300, 283, 35);
			panelNuevaActualizarEmpresa.add(txtTelefono1Empresa);
			
			restrictedtxtTelefono1Empresa = new RestrictedTextField(txtTelefono1Empresa);
			restrictedtxtTelefono1Empresa.setLimit(9);
			
			txtTelefono2Empresa = new JTextField();
			txtTelefono2Empresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtTelefono2Empresa.setBounds(216, 340, 281, 35);
			panelNuevaActualizarEmpresa.add(txtTelefono2Empresa);
			
			restrictedtxtTelefono2Empresa = new RestrictedTextField(txtTelefono2Empresa);
			restrictedtxtTelefono2Empresa.setLimit(9);
			
			txtEmailEmpresa = new JTextField();
			txtEmailEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtEmailEmpresa.setBounds(216, 380, 281, 35);
			panelNuevaActualizarEmpresa.add(txtEmailEmpresa);
			
			txtFaxEmpresa = new JTextField();
			txtFaxEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtFaxEmpresa.setBounds(217, 420, 281, 35);
			panelNuevaActualizarEmpresa.add(txtFaxEmpresa);
			
			txtPaginaWebEmpresa = new JTextField();
			txtPaginaWebEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtPaginaWebEmpresa.setBounds(821, 100, 300, 35);
			panelNuevaActualizarEmpresa.add(txtPaginaWebEmpresa);
			
			txtDNIGerenteEmpresa = new JTextField();
			txtDNIGerenteEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtDNIGerenteEmpresa.setBounds(821, 180, 300, 35);
			panelNuevaActualizarEmpresa.add(txtDNIGerenteEmpresa);
			
			restrictedtxtDNIGerenteEmpresa = new RestrictedTextField(txtDNIGerenteEmpresa);
			restrictedtxtDNIGerenteEmpresa.setLimit(9);
			
			txtNombreGerenteEmpresa = new JTextField();
			txtNombreGerenteEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtNombreGerenteEmpresa.setBounds(821, 220, 300, 35);
			panelNuevaActualizarEmpresa.add(txtNombreGerenteEmpresa);
			
			txtPersonaContactoEmpresa = new JTextField();
			txtPersonaContactoEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtPersonaContactoEmpresa.setBounds(821, 300, 300, 35);
			panelNuevaActualizarEmpresa.add(txtPersonaContactoEmpresa);
			
			txtDNIPersonaContactoEmpresaEmpresa = new JTextField();
			txtDNIPersonaContactoEmpresaEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtDNIPersonaContactoEmpresaEmpresa.setBounds(821, 260, 300, 35);
			panelNuevaActualizarEmpresa.add(txtDNIPersonaContactoEmpresaEmpresa);
			
			restrictedtxtDNIPersonaContactoEmpresaEmpresa = new RestrictedTextField(txtDNIPersonaContactoEmpresaEmpresa);
			restrictedtxtDNIPersonaContactoEmpresaEmpresa.setLimit(9);
			
			lblFechaActualizacionUSUEmpresa = new JLabel();
			lblFechaActualizacionUSUEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			lblFechaActualizacionUSUEmpresa.setBounds(821, 380, 300, 35);
			panelNuevaActualizarEmpresa.add(lblFechaActualizacionUSUEmpresa);
			
			checkBoxOrganismoPublicoUSUEmpresa = new JCheckBox();
			checkBoxOrganismoPublicoUSUEmpresa.setBackground(Color.WHITE);
			checkBoxOrganismoPublicoUSUEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 50));
			checkBoxOrganismoPublicoUSUEmpresa.setBounds(821, 140, 300, 35);
			panelNuevaActualizarEmpresa.add(checkBoxOrganismoPublicoUSUEmpresa);
			
			txtObservacionesEmpresa = new JTextField();
			txtObservacionesEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtObservacionesEmpresa.setBounds(821, 340, 300, 35);
			panelNuevaActualizarEmpresa.add(txtObservacionesEmpresa);
		
			comboBoxPoblacionUSUEmpresa = new JComboBox();
			comboBoxPoblacionUSUEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			comboBoxPoblacionUSUEmpresa.setBounds(215, 220, 283, 35);
			panelNuevaActualizarEmpresa.add(comboBoxPoblacionUSUEmpresa);
			
			comboBoxCodigoPostalUSUEmpresa = new JComboBox();
			comboBoxCodigoPostalUSUEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			comboBoxCodigoPostalUSUEmpresa.setBounds(215, 260, 106, 35);
			panelNuevaActualizarEmpresa.add(comboBoxCodigoPostalUSUEmpresa);
			
			btnAnadirEmpresa = new JButton("AÑADIR EMPRESA");
			btnAnadirEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
			btnAnadirEmpresa.setBounds(49, 538, 235, 68);
			panelNuevaActualizarEmpresa.add(btnAnadirEmpresa);	
			
			btnModificarEmpresa = new JButton("MODIFICAR EMPRESA");
			btnModificarEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
			btnModificarEmpresa.setBounds(49, 538, 217, 68);
			panelNuevaActualizarEmpresa.add(btnModificarEmpresa);	
			
			lblTituloModificarEmpresa = new JLabel();
			lblTituloModificarEmpresa.setText("MODIFICAR EMPRESA");
			lblTituloModificarEmpresa.setFont(new Font("Agency FB", Font.BOLD, 50));
			lblTituloModificarEmpresa.setBounds(49, 21, 702, 55);
			panelNuevaActualizarEmpresa.add(lblTituloModificarEmpresa);
			
			btnNuevaPoblacionEmpresa = new JButton("NUEVA POBLACIÓN");
			btnNuevaPoblacionEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
			btnNuevaPoblacionEmpresa.setBounds(331, 260, 165, 35);
			panelNuevaActualizarEmpresa.add(btnNuevaPoblacionEmpresa);
			
			lblErroresNuevaEmpresa = new JLabel();
			lblErroresNuevaEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
			lblErroresNuevaEmpresa.setBounds(383, 538, 724, 68);
			panelNuevaActualizarEmpresa.add(lblErroresNuevaEmpresa);

		
		/**
		 * PANEL CONVENIOS
		 */
			
			panelConvenios = new JPanel();
			panelConvenios.setBackground(Color.WHITE);
			panelConvenios.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			panelConvenios.setBounds(368, 132, 1157, 648);
			panelPrincipal.add(panelConvenios);
			panelConvenios.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("CONVENIOS");
			lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 50));
			lblNewLabel.setBounds(49, 21, 245, 55);
			panelConvenios.add(lblNewLabel);
			
			panelCrearNuevoConvenio = new JPanel();
			panelCrearNuevoConvenio.setBackground(Color.WHITE);
			panelCrearNuevoConvenio.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Crear Nuevo Convenio", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			panelCrearNuevoConvenio.setBounds(62, 342, 1040, 269);
			panelConvenios.add(panelCrearNuevoConvenio);
			panelCrearNuevoConvenio.setLayout(null);
			
			comboBoxListaCursoConvenio = new JComboBox();
			comboBoxListaCursoConvenio.setBounds(25, 101, 507, 38);
			panelCrearNuevoConvenio.add(comboBoxListaCursoConvenio);
			comboBoxListaCursoConvenio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			comboBoxListaCursoConvenio.setBackground(Color.WHITE);
	        
	        JLabel lblNewLabel_2 = new JLabel("CURSO");
	        lblNewLabel_2.setBounds(25, 43, 136, 45);
	        panelCrearNuevoConvenio.add(lblNewLabel_2);
	        lblNewLabel_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
	        
	        comboBoxTipoConvenioPanelConvenio = new JComboBox();
	        comboBoxTipoConvenioPanelConvenio.setModel(new DefaultComboBoxModel(new String[] {"", "FCT", "PFE"}));
	        comboBoxTipoConvenioPanelConvenio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
	        comboBoxTipoConvenioPanelConvenio.setBounds(658, 101, 266, 38);
	        panelCrearNuevoConvenio.add(comboBoxTipoConvenioPanelConvenio);
	        
	        JLabel lblNewLabel_2_1 = new JLabel("TIPO DE CONVENIO");
	        lblNewLabel_2_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
	        lblNewLabel_2_1.setBounds(658, 43, 272, 45);
	        panelCrearNuevoConvenio.add(lblNewLabel_2_1);
	        
	        btnCrearConvenio = new JButton("Crear Convenio");
	        btnCrearConvenio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
	        btnCrearConvenio.setBounds(25, 195, 217, 38);
	        panelCrearNuevoConvenio.add(btnCrearConvenio);
	        
	        lblNombreEmpresaConvenios = new JLabel("");
	        lblNombreEmpresaConvenios.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblNombreEmpresaConvenios.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
	        lblNombreEmpresaConvenios.setBounds(314, 21, 788, 55);
	        panelConvenios.add(lblNombreEmpresaConvenios);
				
	        
	    	listConvenios = new JList<String>();
	    	listConvenios.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
	    	listConvenios.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            modelConvenios = new DefaultListModel<>();
            
     
            JScrollPane listPanelConvenios = new JScrollPane();
            listPanelConvenios.setBounds(62, 118, 1040, 130);
            listPanelConvenios.setViewportView(listConvenios);
            listConvenios.setLayoutOrientation(JList.VERTICAL);
            panelConvenios.add(listPanelConvenios);
            
            btnActualizarConvenio = new JButton("Actualizar");
            btnActualizarConvenio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
            btnActualizarConvenio.setBounds(64, 271, 158, 45);
            panelConvenios.add(btnActualizarConvenio);
            
            btnPanelCrearNuevoConvenio = new JButton("Crear Nuevo Convenio");
            btnPanelCrearNuevoConvenio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
            btnPanelCrearNuevoConvenio.setBounds(232, 271, 308, 45);
            panelConvenios.add(btnPanelCrearNuevoConvenio);
		
           
            
		/**
		 *  Panel nueva Poblacion
		 */
		panelNuevaPoblacion = new JPanel();
		panelNuevaPoblacion.setBounds(368, 132, 1157, 648);
		panelNuevaPoblacion.setBackground(Color.WHITE);
		panelNuevaPoblacion.setForeground(new Color(102, 255, 204));
		panelNuevaPoblacion.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panelNuevaPoblacion.setLayout(null);
		panelPrincipal.add(panelNuevaPoblacion);
		
			lblCodigoPostalPoblacion = new JLabel();
			lblCodigoPostalPoblacion.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblCodigoPostalPoblacion.setText("CÓDIGO POSTAL");
			lblCodigoPostalPoblacion.setBounds(49, 140, 300, 40);
			panelNuevaPoblacion.add(lblCodigoPostalPoblacion);
			
			lblNombrePoblacion = new JLabel();
			lblNombrePoblacion.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblNombrePoblacion.setText("NOMBRE POBLACIÓN");
			lblNombrePoblacion.setBounds(49, 190, 300, 40);
			panelNuevaPoblacion.add(lblNombrePoblacion);
			
			lblProvinciaPoblacion = new JLabel();
			lblProvinciaPoblacion.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
			lblProvinciaPoblacion.setText("PROVINCIA");
			lblProvinciaPoblacion.setBounds(49, 240, 300, 40);
			panelNuevaPoblacion.add(lblProvinciaPoblacion);
			
			txtCodigoPostalUSUPoblacion = new JTextField();
			txtCodigoPostalUSUPoblacion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtCodigoPostalUSUPoblacion.setColumns(10);
			txtCodigoPostalUSUPoblacion.setBounds(359, 140, 323, 40);
			panelNuevaPoblacion.add(txtCodigoPostalUSUPoblacion);
			
			txtNombreUSUPoblacion = new JTextField();
			txtNombreUSUPoblacion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtNombreUSUPoblacion.setColumns(10);
			txtNombreUSUPoblacion.setBounds(359, 190, 323, 40);
			panelNuevaPoblacion.add(txtNombreUSUPoblacion);
			
			txtProvinciaUSUPoblacion = new JTextField();
			txtProvinciaUSUPoblacion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			txtProvinciaUSUPoblacion.setColumns(10);
			txtProvinciaUSUPoblacion.setBounds(359, 240, 323, 40);
			panelNuevaPoblacion.add(txtProvinciaUSUPoblacion);
		
			lblTituloNuevaPoblacion = new JLabel();
			lblTituloNuevaPoblacion.setFont(new Font("Agency FB", Font.BOLD, 50));
			lblTituloNuevaPoblacion.setText("NUEVA POBLACION");
			lblTituloNuevaPoblacion.setBounds(49, 21, 550, 55);
			panelNuevaPoblacion.add(lblTituloNuevaPoblacion);
			
			btnAnadirPoblacionAlumno = new JButton("AÑADIR POBLACION");
			btnAnadirPoblacionAlumno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
			btnAnadirPoblacionAlumno.setBounds(49, 503, 300, 61);
			panelNuevaPoblacion.add(btnAnadirPoblacionAlumno);
			
			btnAnadirPoblacionEmpresa = new JButton("AÑADIR POBLACION");
			btnAnadirPoblacionEmpresa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
			btnAnadirPoblacionEmpresa.setBounds(49, 503, 300, 61);
			panelNuevaPoblacion.add(btnAnadirPoblacionEmpresa);
			
			lblErroresNuevaPoblacion = new JLabel();
			lblErroresNuevaPoblacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblErroresNuevaPoblacion.setBounds(247, 523, 352, 56);
			panelNuevaPoblacion.add(lblErroresNuevaPoblacion);
	
			/**
			 * Panel nuevo Curso
			*/
			panelNuevoCurso = new JPanel();
			panelNuevoCurso.setBounds(368, 132, 1157, 648);
			panelNuevoCurso.setBackground(Color.WHITE);
			panelNuevoCurso.setForeground(new Color(102, 255, 204));
			panelNuevoCurso.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			panelNuevoCurso.setLayout(null);
			panelPrincipal.add(panelNuevoCurso);
			
				lblNombreCurso = new JLabel();
				lblNombreCurso.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
				lblNombreCurso.setText("NOMBRE");
				lblNombreCurso.setBounds(49, 110, 300, 40);
				panelNuevoCurso.add(lblNombreCurso);
				
				lblNombreAbrevCurso = new JLabel();
				lblNombreAbrevCurso.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
				lblNombreAbrevCurso.setText("NOMBRE ABREVIADO");
				lblNombreAbrevCurso.setBounds(49, 160, 300, 40);
				panelNuevoCurso.add(lblNombreAbrevCurso);
				
				lblClaveCurso = new JLabel();
				lblClaveCurso.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
				lblClaveCurso.setText("CLAVE");
				lblClaveCurso.setBounds(49, 210, 300, 40);
				panelNuevoCurso.add(lblClaveCurso);
				
				lblHorasFCTCurso = new JLabel();
				lblHorasFCTCurso.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
				lblHorasFCTCurso.setText("HORAS FCT");
				lblHorasFCTCurso.setBounds(49, 260, 300, 40);
				panelNuevoCurso.add(lblHorasFCTCurso);
				
				lblEsPublicoCurso = new JLabel();
				lblEsPublicoCurso.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
				lblEsPublicoCurso.setText("ENSEÑANZA PÚBLICA");
				lblEsPublicoCurso.setBounds(49, 310, 300, 40);
				panelNuevoCurso.add(lblEsPublicoCurso);
				
				txtNombreUSUCurso = new JTextField();
				txtNombreUSUCurso.setColumns(10);
				txtNombreUSUCurso.setBounds(360, 110, 219, 40);
				panelNuevoCurso.add(txtNombreUSUCurso);
				
				txtNombreAbrevUSUCurso = new JTextField();
				txtNombreAbrevUSUCurso.setColumns(10);
				txtNombreAbrevUSUCurso.setBounds(360, 160, 219, 40);
				panelNuevoCurso.add(txtNombreAbrevUSUCurso);
				
				txtClaveUSUCurso = new JTextField();
				txtClaveUSUCurso.setColumns(10);
				txtClaveUSUCurso.setBounds(360, 210, 219, 40);
				panelNuevoCurso.add(txtClaveUSUCurso);
				
				txtHorasFCTUSUCurso = new JTextField();
				txtHorasFCTUSUCurso.setColumns(10);
				txtHorasFCTUSUCurso.setBounds(360, 260, 219, 40);
				panelNuevoCurso.add(txtHorasFCTUSUCurso);
				
				lblTituloNuevoCurso = new JLabel();
				lblTituloNuevoCurso.setBackground(Color.WHITE);
				lblTituloNuevoCurso.setFont(new Font("Agency FB", Font.BOLD, 50));
				lblTituloNuevoCurso.setText("NUEVO CURSO");
				lblTituloNuevoCurso.setBounds(49, 21, 898, 55);
				panelNuevoCurso.add(lblTituloNuevoCurso);
				
				checkBoxEsPublicoUSUCurso = new JCheckBox();
				checkBoxEsPublicoUSUCurso.setBackground(Color.WHITE);
				checkBoxEsPublicoUSUCurso.setFont(new Font("Tahoma", Font.PLAIN, 50));
				checkBoxEsPublicoUSUCurso.setBounds(360, 310, 219, 40);
				panelNuevoCurso.add(checkBoxEsPublicoUSUCurso);
				
				btnAnadirCurso = new JButton("AÑADIR CURSO");
				btnAnadirCurso.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
				btnAnadirCurso.setBounds(49, 503, 250, 76);
				panelNuevoCurso.add(btnAnadirCurso);
			
				lblErroresNuevoCurso = new JLabel();
				lblErroresNuevoCurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblErroresNuevoCurso.setBounds(247, 523, 352, 56);
				panelNuevoCurso.add(lblErroresNuevoCurso);		
		
			/**
			 * PANEL PERIODOS
			*/
			
			panelPeriodos = new JPanel();
			panelPeriodos.setBackground(Color.WHITE);
			panelPeriodos.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			panelPeriodos.setBounds(368, 132, 1157, 648);
			panelPrincipal.add(panelPeriodos);
			panelPeriodos.setLayout(null);
			
				lblTituloPeriodos = new JLabel("PERIODOS");
				lblTituloPeriodos.setFont(new Font("Agency FB", Font.BOLD, 50));
				lblTituloPeriodos.setBounds(49, 21, 216, 55);
				panelPeriodos.add(lblTituloPeriodos);
			
				
				listPeriodos = new JList<String>();
				listPeriodos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
				listPeriodos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		        modelPeriodos = new DefaultListModel<>();
		        
	            JScrollPane listPanePeriodos = new JScrollPane();
		        listPanePeriodos.setBounds(462, 125, 653, 409);
		        listPanePeriodos.setViewportView(listPeriodos);
		        listPeriodos.setLayoutOrientation(JList.VERTICAL);
		        panelPeriodos.add(listPanePeriodos);
		        
		        comboBoxListaCursoPeriodo = new JComboBox();
		        comboBoxListaCursoPeriodo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		        comboBoxListaCursoPeriodo.setBackground(Color.WHITE);
		        comboBoxListaCursoPeriodo.setBounds(39, 273, 382, 40);
		        panelPeriodos.add(comboBoxListaCursoPeriodo);
		        
		        btnCrearPeriodo = new JButton("CREAR PERIODO");
		        btnCrearPeriodo.setBackground(Color.ORANGE);
		        btnCrearPeriodo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		        btnCrearPeriodo.setBounds(39, 545, 382, 55);
		        panelPeriodos.add(btnCrearPeriodo);
		        
		        btnEliminarPeriodo = new JButton("ELIMINAR PERIODO");
		        btnEliminarPeriodo.setBackground(Color.RED);
		        btnEliminarPeriodo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		        btnEliminarPeriodo.setBounds(462, 545, 653, 55);
		        panelPeriodos.add(btnEliminarPeriodo);
		        
		        JLabel lblCursoPeriodos = new JLabel("CURSO");
		        lblCursoPeriodos.setHorizontalAlignment(SwingConstants.LEFT);
		        lblCursoPeriodos.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
		        lblCursoPeriodos.setBounds(39, 223, 136, 40);
		        panelPeriodos.add(lblCursoPeriodos);
		        
		        JLabel lblTituloListaPeriodos = new JLabel("LISTA DE PERIODOS");
		        lblTituloListaPeriodos.setHorizontalAlignment(SwingConstants.CENTER);
		        lblTituloListaPeriodos.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		        lblTituloListaPeriodos.setBounds(462, 68, 653, 47);
		        panelPeriodos.add(lblTituloListaPeriodos);
		        
		        JLabel lblTituloNuevoPeriodo = new JLabel("NUEVO PERIODO");
		        lblTituloNuevoPeriodo.setHorizontalAlignment(SwingConstants.CENTER);
		        lblTituloNuevoPeriodo.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		        lblTituloNuevoPeriodo.setBounds(39, 144, 382, 47);
		        panelPeriodos.add(lblTituloNuevoPeriodo);
		        
		        lblTipoPeriodos = new JLabel("TIPO");
		        lblTipoPeriodos.setHorizontalAlignment(SwingConstants.LEFT);
		        lblTipoPeriodos.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
		        lblTipoPeriodos.setBounds(39, 323, 136, 40);
		        panelPeriodos.add(lblTipoPeriodos);
		        
		        lblFechaInicioPeriodos = new JLabel("FECHA INICIO");
		        lblFechaInicioPeriodos.setHorizontalAlignment(SwingConstants.LEFT);
		        lblFechaInicioPeriodos.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
		        lblFechaInicioPeriodos.setBounds(39, 373, 136, 40);
		        panelPeriodos.add(lblFechaInicioPeriodos);
		        
		        lblFechaFinPeriodos = new JLabel("FECHA FIN");
		        lblFechaFinPeriodos.setHorizontalAlignment(SwingConstants.LEFT);
		        lblFechaFinPeriodos.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
		        lblFechaFinPeriodos.setBounds(39, 423, 136, 40);
		        panelPeriodos.add(lblFechaFinPeriodos);
		        
		        lblNombreProfesorPeriodos = new JLabel("PROFESOR");
		        lblNombreProfesorPeriodos.setHorizontalAlignment(SwingConstants.LEFT);
		        lblNombreProfesorPeriodos.setFont(new Font("Berlin Sans FB", Font.ITALIC, 20));
		        lblNombreProfesorPeriodos.setBounds(39, 473, 136, 40);
		        panelPeriodos.add(lblNombreProfesorPeriodos);
		        
		        comboBoxListaTipoPeriodo = new JComboBox();
		        comboBoxListaTipoPeriodo.setModel(new DefaultComboBoxModel(new String[] {"", "FCT", "PFE"}));
		        comboBoxListaTipoPeriodo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		        comboBoxListaTipoPeriodo.setBackground(Color.WHITE);
		        comboBoxListaTipoPeriodo.setBounds(176, 323, 245, 40);
		        panelPeriodos.add(comboBoxListaTipoPeriodo);
		        
		        comboBoxListaProfesorPeriodo = new JComboBox();
		        comboBoxListaProfesorPeriodo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		        comboBoxListaProfesorPeriodo.setBackground(Color.WHITE);
		        comboBoxListaProfesorPeriodo.setBounds(176, 473, 245, 40);
		        panelPeriodos.add(comboBoxListaProfesorPeriodo);
		        
		        dateChooserFechaInicioPeriodo = new JDateChooser("dd/MM/yyyy", " ##/##/####", '_');
		        dateChooserFechaInicioPeriodo.getCalendarButton().setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		        dateChooserFechaInicioPeriodo.setBounds(176, 373, 245, 40);
		        dateChooserFechaInicioPeriodo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		        panelPeriodos.add(dateChooserFechaInicioPeriodo);
				
		        dateChooserFechaFinPeriodo = new JDateChooser("dd/MM/yyyy", " ##/##/####", '_');
		        dateChooserFechaFinPeriodo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		        dateChooserFechaFinPeriodo.setBounds(176, 423, 245, 40);
		        panelPeriodos.add(dateChooserFechaFinPeriodo);
		
		
		/**
		 * PANEL PRACTICAS
		 */
		
		panelPracticas = new JPanel();
		panelPracticas.setBackground(Color.WHITE);
		panelPracticas.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panelPracticas.setBounds(368, 132, 1157, 648);
		panelPrincipal.add(panelPracticas);
		panelPracticas.setLayout(null);
		
			lblTituloPracticas = new JLabel("PRÁCTICAS");
			lblTituloPracticas.setFont(new Font("Agency FB", Font.BOLD, 50));
			lblTituloPracticas.setBounds(49, 21, 190, 55);
			panelPracticas.add(lblTituloPracticas);
		
			JLabel lblTituloListaPeriodosPracticas = new JLabel("PERIODOS");
	        lblTituloListaPeriodosPracticas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
	        lblTituloListaPeriodosPracticas.setBounds(49, 102, 134, 47);
	        panelPracticas.add(lblTituloListaPeriodosPracticas);
			
			listPeriodosPracticas = new JList<String>();
			listPeriodosPracticas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			listPeriodosPracticas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	        modelPeriodosPracticas = new DefaultListModel<>();
	        
            JScrollPane listPanePeriodosPracticas = new JScrollPane();
	        listPanePeriodosPracticas.setBounds(249, 74, 559, 100);
	        listPanePeriodosPracticas.setViewportView(listPeriodosPracticas);
	        listPeriodosPracticas.setLayoutOrientation(JList.VERTICAL);
	        panelPracticas.add(listPanePeriodosPracticas);
	        
	        btnAsignarPeriodoPracticas = new JButton("ASIGNAR PERIODO");
	        btnAsignarPeriodoPracticas.setBackground(Color.ORANGE);
	        btnAsignarPeriodoPracticas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
	        btnAsignarPeriodoPracticas.setBounds(864, 100, 218, 55);
	        panelPracticas.add(btnAsignarPeriodoPracticas);
	        
	        lblTituloListaAlumnosPracticas = new JLabel("ALUMNOS");
	        lblTituloListaAlumnosPracticas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
	        lblTituloListaAlumnosPracticas.setBounds(49, 227, 134, 47);
	        lblTituloListaAlumnosPracticas.setVisible(false);
	        panelPracticas.add(lblTituloListaAlumnosPracticas);
			
			listAlumnosPracticas = new JList<String>();
			listAlumnosPracticas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			listAlumnosPracticas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	        modelAlumnosPracticas = new DefaultListModel<>();
	        
            listPaneAlumnosPracticas = new JScrollPane();
            listPaneAlumnosPracticas.setBounds(249, 208, 559, 100);
            listPaneAlumnosPracticas.setViewportView(listAlumnosPracticas);
	        listAlumnosPracticas.setLayoutOrientation(JList.VERTICAL);
	        listPaneAlumnosPracticas.setVisible(false);
	        panelPracticas.add(listPaneAlumnosPracticas);
	        
	        lblTituloListaEmpresasPracticas = new JLabel("<html><body>CONVENIOS </br> EMPRESAS<br></body></html>");
	        lblTituloListaEmpresasPracticas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
	        lblTituloListaEmpresasPracticas.setBounds(49, 353, 134, 50);
	        lblTituloListaEmpresasPracticas.setVisible(false);
	        panelPracticas.add(lblTituloListaEmpresasPracticas);
			
			listEmpresasPracticas = new JList<String>();
			listEmpresasPracticas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			listEmpresasPracticas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	        modelEmpresasPracticas = new DefaultListModel<>();
	        
            listPaneEmpresasPracticas = new JScrollPane();
            listPaneEmpresasPracticas.setBounds(249, 335, 559, 100);
            listPaneEmpresasPracticas.setViewportView(listEmpresasPracticas);
            listEmpresasPracticas.setLayoutOrientation(JList.VERTICAL);
            listPaneEmpresasPracticas.setVisible(false);
	        panelPracticas.add(listPaneEmpresasPracticas);
	        
	        btnAsignarEmpresaPracticas = new JButton("ASIGNAR EMPRESA");
	        btnAsignarEmpresaPracticas.setBackground(Color.CYAN);
	        btnAsignarEmpresaPracticas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
	        btnAsignarEmpresaPracticas.setBounds(864, 295, 218, 55);
	        btnAsignarEmpresaPracticas.setVisible(false);
	        panelPracticas.add(btnAsignarEmpresaPracticas);
	        
	        lblTituloListaAnexarPracticas = new JLabel("ANEXOS");
	        lblTituloListaAnexarPracticas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
	        lblTituloListaAnexarPracticas.setBounds(49, 445, 790, 47);
	        lblTituloListaAnexarPracticas.setVisible(false);
	        panelPracticas.add(lblTituloListaAnexarPracticas);
			
			listAnexarPracticas = new JList<String>();
			listAnexarPracticas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			listAnexarPracticas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	        modelAnexarPracticas = new DefaultListModel<>();
	        
            listPaneAnexarPracticas = new JScrollPane();
            listPaneAnexarPracticas.setBounds(49, 500, 790, 120);
            listPaneAnexarPracticas.setViewportView(listAnexarPracticas);
            listAnexarPracticas.setLayoutOrientation(JList.VERTICAL);
            listPaneAnexarPracticas.setVisible(false);
	        panelPracticas.add(listPaneAnexarPracticas);
	        
	        btnEliminarAnexarPracticas = new JButton("ELIMINAR");
	        btnEliminarAnexarPracticas.setBackground(Color.RED);
	        btnEliminarAnexarPracticas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
	        btnEliminarAnexarPracticas.setBounds(864, 500, 218, 55);
	        btnEliminarAnexarPracticas.setVisible(false);
	        panelPracticas.add(btnEliminarAnexarPracticas);
	        
	        btnPanelDocumentos = new JButton("DOCUMENTOS");
			btnPanelDocumentos.setBackground(Color.PINK);
			btnPanelDocumentos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			btnPanelDocumentos.setBounds(864, 565, 218, 55);
			btnPanelDocumentos.setVisible(false);
			panelPracticas.add(btnPanelDocumentos);

		/**
		* PANEL DOCUMENTOS
		*/

		panelDocumentos = new JPanel();
		panelDocumentos.setBackground(Color.WHITE);
		panelDocumentos.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panelDocumentos.setBounds(368, 132, 1157, 648);
		panelPrincipal.add(panelDocumentos);
		panelDocumentos.setLayout(null);

			lblTituloDocumentos = new JLabel("DOCUMENTOS");
			lblTituloDocumentos.setFont(new Font("Agency FB", Font.BOLD, 50));
			lblTituloDocumentos.setBounds(49, 21, 252, 55);
			panelDocumentos.add(lblTituloDocumentos);

			JLabel lblTituloSeleccionDocumentos = new JLabel("SELECCIONA LOS DOCUMENTOS QUE DESEA GUARDAR");
			lblTituloSeleccionDocumentos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
			lblTituloSeleccionDocumentos.setBounds(49, 102, 618, 47);
			panelDocumentos.add(lblTituloSeleccionDocumentos);

			lblInfoRutaDocumentos = new JLabel("LOS DOCUMENTOS SE HAN EN EL DISCO LOCAL C:");
			lblInfoRutaDocumentos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			lblInfoRutaDocumentos.setForeground(new Color(255, 140, 0));
			lblInfoRutaDocumentos.setBounds(580, 580, 534, 47);
			lblInfoRutaDocumentos.setVisible(false);
			panelDocumentos.add(lblInfoRutaDocumentos);

			lblFCToPFEDocumentos = new JLabel("DOCUMENTOS DE -> ");
			lblFCToPFEDocumentos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
			lblFCToPFEDocumentos.setBounds(226, 183, 271, 47);
			panelDocumentos.add(lblFCToPFEDocumentos);
			
			btnGuardarDocumentos = new JButton("GUARDAR");
			btnGuardarDocumentos.setBackground(new Color(64, 224, 208));
			btnGuardarDocumentos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			btnGuardarDocumentos.setBounds(226, 511, 271, 55);
			btnGuardarDocumentos.setVisible(true);
			panelDocumentos.add(btnGuardarDocumentos);
			
			btnAtrasDocumentos = new JButton("ATRÁS");
			btnAtrasDocumentos.setBackground(new Color(127, 255, 212));
			btnAtrasDocumentos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
			btnAtrasDocumentos.setBounds(49, 580, 128, 55);
			btnAtrasDocumentos.setVisible(true);
			panelDocumentos.add(btnAtrasDocumentos);
			
			checkBoxAnexo0 = new JCheckBox("     ANEXO 0");
			checkBoxAnexo0.setBackground(new Color(255, 255, 255));
			checkBoxAnexo0.setFont(new Font("Tahoma", Font.PLAIN, 20));
			checkBoxAnexo0.setBounds(226, 248, 166, 33);
			panelDocumentos.add(checkBoxAnexo0);
			
			checkBoxAnexo0A = new JCheckBox("     ANEXO 0A");
			checkBoxAnexo0A.setBackground(new Color(255, 255, 255));
			checkBoxAnexo0A.setFont(new Font("Tahoma", Font.PLAIN, 20));
			checkBoxAnexo0A.setBounds(226, 283, 166, 33);
			panelDocumentos.add(checkBoxAnexo0A);
			
			checkBoxAnexo1 = new JCheckBox("     ANEXO 1");
			checkBoxAnexo1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			checkBoxAnexo1.setBackground(Color.WHITE);
			checkBoxAnexo1.setBounds(226, 318, 166, 33);
			panelDocumentos.add(checkBoxAnexo1);
			
			checkBoxAnexo2 = new JCheckBox("     ANEXO 2");
			checkBoxAnexo2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			checkBoxAnexo2.setBackground(Color.WHITE);
			checkBoxAnexo2.setBounds(226, 353, 166, 33);
			panelDocumentos.add(checkBoxAnexo2);
			
			checkBoxAnexo3 = new JCheckBox("     ANEXO 3");
			checkBoxAnexo3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			checkBoxAnexo3.setBackground(Color.WHITE);
			checkBoxAnexo3.setBounds(226, 388, 166, 33);
			panelDocumentos.add(checkBoxAnexo3);
			
			checkBoxAnexo4FCT = new JCheckBox("     ANEXO 4");
			checkBoxAnexo4FCT.setFont(new Font("Tahoma", Font.PLAIN, 20));
			checkBoxAnexo4FCT.setBackground(Color.WHITE);
			checkBoxAnexo4FCT.setBounds(226, 423, 166, 33);
			panelDocumentos.add(checkBoxAnexo4FCT);
			
			checkBoxAnexo4PFE = new JCheckBox("     ANEXO 4");
			checkBoxAnexo4PFE.setFont(new Font("Tahoma", Font.PLAIN, 20));
			checkBoxAnexo4PFE.setBackground(Color.WHITE);
			checkBoxAnexo4PFE.setBounds(226, 388, 166, 33);
			checkBoxAnexo4PFE.setVisible(false);
			panelDocumentos.add(checkBoxAnexo4PFE);
		        
	}
}
