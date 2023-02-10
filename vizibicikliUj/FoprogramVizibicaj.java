package vizibicikliUj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


public class FoprogramVizibicaj {
	
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
	
		List<Kolcsonzes> kolcsonzesek = FajlkezelesBicaj.beolvasas(br, "kolcsonzesek.txt", ";");
		
		FeladatokBicikli feladatObj = new FeladatokBicikli();
		
		feladatObj.hanySorosALista(kolcsonzesek);
		
		feladatObj.nevBekeresKolcsonzottE(kolcsonzesek);
		
		feladatObj.IdopontBekeresKiKolcsonzott(kolcsonzesek);
		
		feladatObj.napiBevetel(kolcsonzesek);
		
		feladatObj.FJarmuRongalok("F.txt", kolcsonzesek);
		
		feladatObj.statisztika(kolcsonzesek);
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
