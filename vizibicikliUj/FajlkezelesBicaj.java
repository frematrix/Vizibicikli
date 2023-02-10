package vizibicikliUj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class FajlkezelesBicaj {

	public static List<Kolcsonzes> beolvasas(BufferedReader br, String fajl, String elvalaszto) throws UnsupportedEncodingException {
		
		List<Kolcsonzes> beolvasottLista = new ArrayList<Kolcsonzes>();
		Kolcsonzes ujKolcsonzo;
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fajl), "UTF-8"));
			
			br.readLine();
			
			while (br.ready()) {
				
				String[] csvSor = br.readLine().split(elvalaszto);
				
				ujKolcsonzo = new Kolcsonzes(csvSor[0], csvSor[1].charAt(0), csvSor[2], csvSor[3], csvSor[4], csvSor[5]);
				
				beolvasottLista.add(ujKolcsonzo);
			}
			
			br.close();
			
		} catch (IOException e) {
			System.out.println("Nem található a fájl.");
			e.printStackTrace();
		}
		
		return beolvasottLista;
	}

}
