package Controlador;
import java.io.IOException;

import java.util.Map;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

public class DatosDocumentos {

	  public void manipulatePdf(String nombreArchivoSinExtension,String tipo,String nombreDirector, String dNIDirector, String nombreEfa) throws IOException {
		
		try {
			//Initialize PDF document
		      //RUTA ACTUAL
				String rutaActual = "DOCUMENTOS/"+tipo+"/"+nombreArchivoSinExtension+".pdf";
				//RUTA AL MODIFICAR EL ARCHIVO
				String rutaModificado = "C:/DOCUMENTOS_PRUEBAS_TFG/formulario.pdf";
			  PdfDocument pdfDoc = new PdfDocument(new PdfReader(rutaActual), new PdfWriter(rutaModificado));

		        PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);

		        Map <String, PdfFormField> fields = form.getFormFields();
				  fields.get("nombreDirector").setValue(nombreDirector);
				  fields.get("dNIDirector").setValue(dNIDirector);
				  fields.get("nombreEfa").setValue(nombreEfa); 
				  fields.get("nombreEmpresa").setValue("Agroni"); 
				  pdfDoc.close();
		        pdfDoc.close();
		        System.out.println("pdfCreado");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		DatosDocumentos datosDocumentos =  new DatosDocumentos();
		try {
			datosDocumentos.manipulatePdf("FCT_Anexo 0FORM", "FCT", "JUAN CARLOS LOPEZ CAMIN", "77382232P","EFA MORATALAZ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}


