package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {

	public static void main(String[] args) {
		try {
			String address = "http://www.pciconcursos.com.br/";
			URL url = new URL(address);
			InputStreamReader input = new InputStreamReader( url.openStream() ); 
			BufferedReader buffer = new BufferedReader( input );
			
			String str = "";
			while( (str = buffer.readLine()) != null ) {
				System.out.println(str);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
