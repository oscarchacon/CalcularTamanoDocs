package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Archivos {
	int i = 0;
	
	public void LeerArchivos(File directorio)
	{
		List<Integer> TamanoDoc = new ArrayList<Integer>();
		Path dir = FileSystems.getDefault().getPath(directorio.getPath());
		DirectoryStream<Path> stream;
		try {
			stream = Files.newDirectoryStream(dir, "*.txt");
			for(Path nombreArchivo : stream)  
			{
				int tamano = 0;
				tamano = this.ObtenerTamanoDoc(nombreArchivo.toFile());
				TamanoDoc.add(tamano);
				i++;
			}
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(i);
			e1.printStackTrace();
		}
		System.out.println("Archivos leidos: "+i);
		if(TamanoDoc.size() > 0)
		{
			this.IngresarPromedio(directorio.getAbsolutePath(), TamanoDoc);
		}
	}
	
	public int ObtenerTamanoDoc(File archivo)
	{
		int tamano = 0;
		String linea;
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			while((linea=br.readLine())!=null)
			{
				String[] aux = linea.trim().split(",");
				tamano += Integer.parseInt(aux[1].trim());
			}
			br.close();
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
			e1.printStackTrace();
		}
		if(tamano == 0)
		{
			System.out.println("Archivo: "+archivo.getPath());
		}
		return tamano;
	}
	
	public void IngresarPromedio(String directorio, List<Integer> TamanoDocs)
	{
		String rutaarchivo = directorio+"/PromedioTamanoPS.txt";
		File archivoDoc = new File(rutaarchivo);
		if(archivoDoc.exists())
		{
			archivoDoc.delete();
		}
		int suma = 0;
		for(int tamano : TamanoDocs)
		{
			suma += tamano;
		}
		float promedio = 0;
		promedio = (float) suma / TamanoDocs.size();
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(archivoDoc));
			out.write(Float.toString(promedio));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
