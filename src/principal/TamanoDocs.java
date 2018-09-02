package principal;

import java.io.File;

public class TamanoDocs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inicio del programa.");
		long totalTiempo;
        long tiempoInicio;
		
        tiempoInicio = System.currentTimeMillis();
        
        //String ruta = "/Users/marcusfenix/Dropbox/detector_icci/WebContent/utilidades/Vocabularios"; //Ruta Mac
        //String ruta = "C:/Users/Oscar/Dropbox/detector_icci/WebContent/utilidades/Vocabularios"; //Ruta Windows
        //String ruta = "C:/Users/oschacon/Dropbox/detector_icci/WebContent/utilidades/Vocabularios"; //Ruta Windows Trabajo
        //String ruta = "/home/marcusfenix/Dropbox/detector_icci/WebContent/utilidades/VocabulariosPS_2"; //Ruta Linux
        String ruta = "/home/marcusfenix/Escritorio/corpus/VocabulariosPS"; //Ruta Linux
        
        File ArchivoIn = new File(ruta);
        if(ArchivoIn.exists() && ArchivoIn.isDirectory())
        {
        	File ArchivoOut = new File(ruta+"/PromedioTamanoPS.txt");      	
        	
        	if(ArchivoOut.exists())
        	{
        		ArchivoOut.delete();
        	}
        	Archivos arch = new Archivos();
        	arch.LeerArchivos(ArchivoIn);
        }
        
        totalTiempo = System.currentTimeMillis() - tiempoInicio;
		
		System.out.println("Tiempo demorado: " + (float) totalTiempo/1000 + " Segundos.");
	}

}
