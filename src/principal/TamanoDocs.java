package principal;

import java.io.File;

public class TamanoDocs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inicio del programa.");
		long totalTiempo;
        long tiempoInicio;
		
        tiempoInicio = System.currentTimeMillis();
        
        String ruta = "/home/${user}/${Destop}/corpus/${vocabularios}"; //Ruta Linux
        
        File ArchivoIn = new File(ruta);
        if(ArchivoIn.exists() && ArchivoIn.isDirectory())
        {
        	File ArchivoOut = new File(ruta+"/${AverageVoc}.txt");      	
        	
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
