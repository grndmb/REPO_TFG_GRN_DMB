package Controlador;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

import persistencia.Alumno;
import persistencia.Anexar;
import persistencia.DatosEfa;

public class DatosDocumentos {
	//CREA LA CARPETA DOCUMENTOS_APP_TFG
	public void crearDirectorio() {
		File carpeta = new File("C:/DOCUMENTOS_APP_TFG");
		carpeta.mkdir();
	}
	//RELLENA EL FCT_ANEXO 0FORM.pdf
	  public void rellenarPDF_FCTAnexo0(String nombreArchivoSinExtension,String tipo,Anexar anexado, DatosEfa datosEfa, String cif) throws IOException {
		
		try {
			//Initialize PDF document
		      //RUTA ACTUAL
				String rutaActual = "DOCUMENTOS/"+tipo+"/"+nombreArchivoSinExtension+".pdf";
				//RUTA AL MODIFICAR EL ARCHIVO
				String rutaModificado = "C:/DOCUMENTOS_APP_TFG/"+nombreArchivoSinExtension+"_"+cif+".pdf";
			    PdfDocument pdfDoc = new PdfDocument(new PdfReader(rutaActual), new PdfWriter(rutaModificado));

		        PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);

		        Map <String, PdfFormField> fields = form.getFormFields();
		          fields.get("numeroConvenio").setValue(anexado.getConvenio().getIdConvenio());
		          fields.get("nombreDirectorEfa").setValue(datosEfa.getNombreDirector());
				  fields.get("dNIDirector").setValue(datosEfa.getDniDirector());
				  fields.get("nombreEfa").setValue(datosEfa.getNombre());
				  fields.get("nombrePoblacionEfa").setValue(datosEfa.getPoblacion().getNombre());
				  fields.get("provinciaPoblacionEfa").setValue(datosEfa.getPoblacion().getProvincia());
				  fields.get("direccionEfa").setValue(datosEfa.getDireccion());
				  fields.get("codigoPostalEfa").setValue(Integer.toString(datosEfa.getPoblacion().getCodigoPostal()));
				  fields.get("telefonoEfa").setValue(Integer.toString(datosEfa.getTelefono()));
				  fields.get("cifEfa").setValue("A41021957");
				  fields.get("emailEfa").setValue("info@efamoratalaz.com");
				  fields.get("codigoEfa").setValue("13003877");
				  
				  fields.get("nombreDirectorEmpresa").setValue(anexado.getConvenio().getEmpresa().getNombreGerente());
				  fields.get("dniDirectorEmpresa").setValue(anexado.getConvenio().getEmpresa().getDniGerente());
				  fields.get("nombreEmpresa").setValue(anexado.getConvenio().getEmpresa().getNombreEmpresa());
				  fields.get("nombrePoblacionEmpresa").setValue(anexado.getConvenio().getEmpresa().getPoblacion().getNombre());
				  fields.get("provinciaPoblacionEmpresa").setValue(anexado.getConvenio().getEmpresa().getPoblacion().getProvincia());
				  fields.get("direccionEmpresa").setValue(anexado.getConvenio().getEmpresa().getDireccionEmpresa());
				  fields.get("codigoPostalEmpresa").setValue(Integer.toString(anexado.getConvenio().getEmpresa().getPoblacion().getCodigoPostal()));
				  fields.get("cifEmpresa").setValue(anexado.getConvenio().getEmpresa().getCifEmpresa());
				  fields.get("telefono1Empresa").setValue(Integer.toString(anexado.getConvenio().getEmpresa().getTelefono1()));
				  fields.get("emailEmpresa").setValue(anexado.getConvenio().getEmpresa().getEmailEmpresa());

				  fields.get("manzanares").setValue("Manzanares");
				  fields.get("fechaAnexo").setValue(String.valueOf(anexado.getConvenio().getFechaAnexo()));
				  
				  
				  pdfDoc.close();
				  
				  System.out.println("pdfCreado");
				  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//RELLENA EL PFE_ANEXO 0FORM.pdf 
	  public void rellenarPDF_PFEAnexo0(String nombreArchivoSinExtension,String tipo,Anexar anexado, DatosEfa datosEfa,String cif) throws IOException {
			
			try {
				//Initialize PDF document
			      //RUTA ACTUAL
					String rutaActual = "DOCUMENTOS/"+tipo+"/"+nombreArchivoSinExtension+".pdf";
					//RUTA AL MODIFICAR EL ARCHIVO
					String rutaModificado = "C:/DOCUMENTOS_APP_TFG/"+nombreArchivoSinExtension+"_"+cif+".pdf";
					//String rutaModificado = "C:/Users/david/Desktop/PDF/pruebaAnexo0.pdf";

				  PdfDocument pdfDoc = new PdfDocument(new PdfReader(rutaActual), new PdfWriter(rutaModificado));

			        PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);

			        Map <String, PdfFormField> fields = form.getFormFields();
			          fields.get("idConvenio").setValue(anexado.getConvenio().getIdConvenio());
			          fields.get("nombreDirectorEfa").setValue(datosEfa.getNombreDirector());
					  fields.get("dniDirectorEfa").setValue(datosEfa.getDniDirector());
					  fields.get("nombreEfa").setValue(datosEfa.getNombre());
					  fields.get("nombrePoblacionEfa").setValue(datosEfa.getPoblacion().getNombre());
					  fields.get("provinciaPoblacionEfa").setValue(datosEfa.getPoblacion().getProvincia());
					  fields.get("direccionEfa").setValue(datosEfa.getDireccion());
					  fields.get("codigoPostalEfa").setValue(Integer.toString(datosEfa.getPoblacion().getCodigoPostal()));
					  fields.get("telefonoEfa").setValue(Integer.toString(datosEfa.getTelefono()));
					  fields.get("cifEfa").setValue("A41021957");
					  fields.get("emailEfa").setValue("info@efamoratalaz.com");
					  fields.get("codigoEfa").setValue("13003877");
					  
					  fields.get("nombreDirectorEmpresa").setValue(anexado.getConvenio().getEmpresa().getNombreGerente());
					  fields.get("dniDirectorEmpresa").setValue(anexado.getConvenio().getEmpresa().getDniGerente());
					  fields.get("nombreEmpresa").setValue(anexado.getConvenio().getEmpresa().getNombreEmpresa());
					  fields.get("nombrePoblacionEmpresa").setValue(anexado.getConvenio().getEmpresa().getPoblacion().getNombre());
					  fields.get("provinciaPoblacionEmpresa").setValue(anexado.getConvenio().getEmpresa().getPoblacion().getProvincia());
					  fields.get("direccionEmpresa").setValue(anexado.getConvenio().getEmpresa().getDireccionEmpresa());
					  fields.get("codigoPostalEmpresa").setValue(Integer.toString(anexado.getConvenio().getEmpresa().getPoblacion().getCodigoPostal()));
					  fields.get("cifEmpresa").setValue(anexado.getConvenio().getEmpresa().getCifEmpresa());
					  fields.get("telefono1Empresa").setValue(Integer.toString(anexado.getConvenio().getEmpresa().getTelefono1()));
					  fields.get("emailEmpresa").setValue(anexado.getConvenio().getEmpresa().getEmailEmpresa());

					  fields.get("resolucion").setValue("");
					  
				      String yearAux = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)); 
					  fields.get("a�oCurso").setValue(yearAux); 
					  
					  fields.get("manzanares").setValue("Manzanares");
					  fields.get("fechaAnexo").setValue(String.valueOf(anexado.getConvenio().getFechaAnexo()));
					  
					  
					  pdfDoc.close();
			        
					  
					  System.out.println("pdfCreado");
					  
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	  
	//RELLENA EL FCT_ANEXO 1FORM
	  public void rellenarPDF_FCTAnexo1(String nombreArchivoSinExtension,String tipo,Anexar anexado,  ArrayList<Alumno> listaAlumnos, DatosEfa datosEfa, String cif) throws IOException {
		
		try {
			//Initialize PDF document
		      //RUTA ACTUAL
				String rutaActual = "DOCUMENTOS/"+tipo+"/"+nombreArchivoSinExtension+".pdf";
				//RUTA AL MODIFICAR EL ARCHIVO
				String rutaModificado = "C:/DOCUMENTOS_APP_TFG/"+nombreArchivoSinExtension+"_"+cif+".pdf";
			    PdfDocument pdfDoc = new PdfDocument(new PdfReader(rutaActual), new PdfWriter(rutaModificado));
		        PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);

		        Map <String, PdfFormField> fields = form.getFormFields();
		          fields.get("idConvenio").setValue(anexado.getConvenio().getIdConvenio());
		          fields.get("fechaAnexo").setValue(String.valueOf(anexado.getConvenio().getFechaAnexo()));
				  fields.get("nombreEfa").setValue(datosEfa.getNombre());
				  fields.get("nombreEmpresa").setValue(anexado.getConvenio().getEmpresa().getNombreEmpresa());
				  fields.get("direccionEmpresa").setValue(anexado.getConvenio().getEmpresa().getDireccionEmpresa());
				  fields.get("nombreCurso").setValue(anexado.getAlumno().getCurso().getNombreCurso());
				  
				  int comprobarMes = LocalDate.now().getMonthValue();
				  String cursoAcademico = this.cursoAcademicoYear(comprobarMes);
				  fields.get("cursoAcademico").setValue("eyyy");
				  
				  for (int i = 0; i < listaAlumnos.size(); i++) {
					  fields.get("nombreAlumno" + (i + 1)).setValue(listaAlumnos.get(i).getNombreCompleto());
					  fields.get("dniAlumno" + (i + 1)).setValue(listaAlumnos.get(i).getNif());
					  fields.get("poblacionAlumno" + (i + 1)).setValue(listaAlumnos.get(i).getPoblacion().getNombre());
					  fields.get("horasPracticasAlumno" + (i + 1)).setValue(String.valueOf(anexado.getAlumno().getCurso().getHorasFct()));
					  fields.get("fechaInicioAlumno" + (i + 1)).setValue(String.valueOf(anexado.getPractica().getFechaInicio()));
					  fields.get("fechaFinAlumno" + (i + 1)).setValue(String.valueOf(anexado.getPractica().getFechaInicio()));
				  }
				  
				  
				  fields.get("nombreProfesorPractica").setValue(anexado.getPractica().getProfesor().getNombre());
				  fields.get("nombrePersonaContactoEmpresa").setValue(anexado.getConvenio().getEmpresa().getPersonaContacto());
				  fields.get("manzanares").setValue("Manzanares");
				  fields.get("fechaAnexo").setValue(String.valueOf(anexado.getConvenio().getFechaAnexo()));
				  fields.get("nombreDirectorEfa").setValue(datosEfa.getNombreDirector());
				  fields.get("nombreDirectorEmpresa").setValue(anexado.getConvenio().getEmpresa().getNombreGerente());

				  
				  pdfDoc.close();
				  
				  System.out.println("pdfCreado");
				  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	  
	//RELLENA EL PFE_ANEXO 1FORM
	  public void rellenarPDF_PFEAnexo1(String nombreArchivoSinExtension,String tipo,Anexar anexado,  ArrayList<Alumno> listaAlumnos, DatosEfa datosEfa, String cif) throws IOException {
		
		try {
			//Initialize PDF document
		      //RUTA ACTUAL
				String rutaActual = "DOCUMENTOS/"+tipo+"/"+nombreArchivoSinExtension+".pdf";
				//RUTA AL MODIFICAR EL ARCHIVO
				String rutaModificado = "C:/DOCUMENTOS_APP_TFG/"+nombreArchivoSinExtension+"_"+cif+".pdf";
			    PdfDocument pdfDoc = new PdfDocument(new PdfReader(rutaActual), new PdfWriter(rutaModificado));

		        PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);

		        Map <String, PdfFormField> fields = form.getFormFields();
		          fields.get("idConvenio").setValue(anexado.getConvenio().getIdConvenio());
		          fields.get("fechaAnexo").setValue(String.valueOf(anexado.getConvenio().getFechaAnexo()));
				  fields.get("nombreEfa").setValue(datosEfa.getNombre());
				  fields.get("nombreEmpresa").setValue(anexado.getConvenio().getEmpresa().getNombreEmpresa());
				  fields.get("direccionEmpresa").setValue(anexado.getConvenio().getEmpresa().getDireccionEmpresa());
				  fields.get("cifEmpresa").setValue(anexado.getConvenio().getEmpresa().getCifEmpresa());
				  fields.get("emailEmpresa").setValue(anexado.getConvenio().getEmpresa().getEmailEmpresa());
				  fields.get("claveCurso").setValue(anexado.getAlumno().getCurso().getClave());
				  fields.get("familiaProfesionalCurso").setValue("No mires, pa que miras");
				  fields.get("nombreCurso").setValue(anexado.getAlumno().getCurso().getNombreCurso());
				  
				  int comprobarMes = LocalDate.now().getMonthValue();
				  String cursoAcademico = this.cursoAcademicoYear(comprobarMes);
				  fields.get("cursoAcademico").setValue(cursoAcademico);
				  
				  for (int i = 0; i < listaAlumnos.size(); i++) {
					  fields.get("nombreAlumno" + (i + 1)).setValue(listaAlumnos.get(i).getNombreCompleto());
					  fields.get("dniAlumno" + (i + 1)).setValue(listaAlumnos.get(i).getNif());
					  fields.get("poblacionAlumno" + (i + 1)).setValue(listaAlumnos.get(i).getPoblacion().getNombre());
					  fields.get("fechaInicioAlumno" + (i + 1)).setValue(String.valueOf(anexado.getPractica().getFechaInicio()));
					  fields.get("fechaFinAlumno" + (i + 1)).setValue(String.valueOf(anexado.getPractica().getFechaInicio()));
					  fields.get("horasAlumno" + (i + 1)).setValue("100");

				  }
				  
				  
				  fields.get("nombreProfesorPractica").setValue(anexado.getPractica().getProfesor().getNombre());
				  fields.get("dniProfesorPractica").setValue(anexado.getPractica().getProfesor().getDniProfesor());
				  fields.get("nombrePersonaContactoEmpresa").setValue(anexado.getConvenio().getEmpresa().getPersonaContacto());
				  fields.get("dniPersonaContacto").setValue(anexado.getConvenio().getEmpresa().getDniPersonaContacto());
				  
				  fields.get("manzanares").setValue("Manzanares");
				  fields.get("fechaAnexo").setValue(String.valueOf(anexado.getConvenio().getFechaAnexo()));
				  fields.get("nombreDirectorEfa").setValue(datosEfa.getNombreDirector());
				  fields.get("nombreDirectorEmpresa").setValue(anexado.getConvenio().getEmpresa().getNombreGerente());

				  
				  pdfDoc.close();
				  
				  System.out.println("pdfCreado");
				  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	  
	  
	  
	public String cursoAcademicoYear(int test) {
		
		String cursoAcademicoYear = "";
		
		if(test < 8) {
			  cursoAcademicoYear = String.valueOf(LocalDate.now().getYear() - 1) + "/" + String.valueOf(LocalDate.now().getYear());
			  
		  }else if(test > 8) {
			  cursoAcademicoYear = String.valueOf(LocalDate.now().getYear()) + "/" + String.valueOf(LocalDate.now().getYear() + 1);
		  }
		
		return cursoAcademicoYear;
	}
	  
	  
	  
	  
	public static void main(String[] args) throws Exception {
		DatosDocumentos datosDocumentos =  new DatosDocumentos();
		try {
			//datosDocumentos.manipulatePdf("FCT_Anexo 0FORM", "FCT", "JUAN CARLOS LOPEZ CAMIN", "77382232P","EFA MORATALAZ");
			
			//datosDocumentos.rellenarPDF_PFEAnexo0("", null, null, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}


