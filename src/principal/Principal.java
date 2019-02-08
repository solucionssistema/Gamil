package principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Usuario.Usuario;
import fakeNameGenerator.FakeNameGenerator;

public class Principal {

	public static void main(String[] args) {
		
		ArrayList<Usuario> arrayUsuario = new ArrayList<Usuario>();
		FakeNameGenerator fakeName =new  FakeNameGenerator();	
		
		int i=1, u=0;
		
		while(i>0) {
			arrayUsuario.add(fakeName.irAFakeNameGenerator());
			grabarArchivo(arrayUsuario.get(u).getFirstName(),arrayUsuario.get(u).getLastName(),arrayUsuario.get(u).getUserName(),arrayUsuario.get(u).getPassword(), u);
			u++;
		}
		
	}
	
	
	
	
	public static void grabarArchivo(String firstName, String lastName, String userName, String password, int u) {
		
		BufferedWriter bw = null;
	    FileWriter fw = null;
	   
	    try {
	        String data = firstName + "	" + lastName + "	" +userName + "	" + password+u ;
	        File file = new File("Usuario.txt");
	        // Si el archivo no existe, se crea!
	        if (!file.exists()) {
	        	file.createNewFile();
	            
	        }
	        // flag true, indica adjuntar información al archivo.
	        fw = new FileWriter(file.getAbsoluteFile(), true);
	        bw = new BufferedWriter(fw);
	        bw.write(data);
	        bw.newLine();
	        System.out.println("Usuario agregado: "+ data + "\n");
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            //Cierra instancias de FileWriter y BufferedWriter
	            if (bw != null)
	                bw.close();
	            if (fw != null)
	                fw.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}   
	

}
