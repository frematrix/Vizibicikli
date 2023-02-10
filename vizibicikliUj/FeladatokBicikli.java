package vizibicikliUj;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class FeladatokBicikli {
	
	static Scanner sc = new Scanner(System.in);

	public void hanySorosALista(List<Kolcsonzes> kolcsonzesek) {
		
		System.out.println("5. feladat: Napi kölcsönzések száma: "+kolcsonzesek.size());
		
	}

	public void nevBekeresKolcsonzottE(List<Kolcsonzes> kolcsonzesek) {
		
		System.out.print("\n6. feladat: Kérek egy nevet: ");
		
		String nev;
		nev = sc.nextLine();
		
		System.out.println(nev+ " kölcsönzései: ");
		
		int i=0;
		
			while (i<kolcsonzesek.size() && !nev.equals(kolcsonzesek.get(i).getNev())) {
				
				i++;
			}
			
			if (i<kolcsonzesek.size()) {
				
				for (Kolcsonzes kolcsonzes : kolcsonzesek) {
					
					if (nev.equals(kolcsonzes.getNev())) {
						
						System.out.println(kolcsonzes.getElvitelOra() + ":" + kolcsonzes.getElvitelPerc()+"-"
					+kolcsonzes.getVisszaOra()+":"+kolcsonzes.getVisszaPerc());
							
					} 
				}
			}
			
			else {
				
				System.out.println("Nem volt ilyen kölcsönző!");
			}
		
	}

	public void IdopontBekeresKiKolcsonzott(List<Kolcsonzes> kolcsonzesek) {
		
		System.out.print("\n7. feladat: Adjon meg egy időpontot óra:perc alakban: ");
		
		
		String idopont;
		idopont = sc.nextLine();
		int aktualisIdo;
		int kezdesiIdo;
		int befejezesiIdo;
		
		System.out.println("A vízen lévő járművek: ");
		
		String[] beolvasas = idopont.split(":");
		
		aktualisIdo = (Integer.parseInt(beolvasas[0])*60) + Integer.parseInt(beolvasas[1]);
		
		for (int i = 0; i < kolcsonzesek.size(); i++) {
			
			kezdesiIdo = Integer.parseInt(kolcsonzesek.get(i).getElvitelOra())*60+
					Integer.parseInt(kolcsonzesek.get(i).getElvitelPerc());
			befejezesiIdo = Integer.parseInt(kolcsonzesek.get(i).getVisszaOra())*60+
					Integer.parseInt(kolcsonzesek.get(i).getVisszaPerc());
			
			if (aktualisIdo>=kezdesiIdo && aktualisIdo<=befejezesiIdo) {
				System.out.println(kolcsonzesek.get(i).getElvitelOra()+":"+kolcsonzesek.get(i).getElvitelPerc()+
						"-"+kolcsonzesek.get(i).getVisszaOra()+":"+kolcsonzesek.get(i).getVisszaPerc()+" : "+
						kolcsonzesek.get(i).getNev());
			}
			
		}
		
	}

	public void napiBevetel(List<Kolcsonzes> kolcsonzesek) {
		
		int kezdes;
		int vege;
		double[] mennyiFelOra = new double[kolcsonzesek.size()];
		int felOrakOsszege=0;
		
		
		for (int i = 0; i < kolcsonzesek.size(); i++) {
			
			kezdes = Integer.parseInt(kolcsonzesek.get(i).getElvitelOra())*60+
					Integer.parseInt(kolcsonzesek.get(i).getElvitelPerc());
			vege = Integer.parseInt(kolcsonzesek.get(i).getVisszaOra())*60+
					Integer.parseInt(kolcsonzesek.get(i).getVisszaPerc());
			
			mennyiFelOra[i] = Math.ceil(((double)vege-kezdes)/30);
			felOrakOsszege += mennyiFelOra[i];
		
		}
	
		System.out.println("\n8. feladat: A napi bevétel: "+felOrakOsszege*2400+" Ft");
	}

	public void FJarmuRongalok(String fajl, List<Kolcsonzes> kolcsonzesek) throws IOException {
		
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fajl),"UTF-8");
		
		
		
		for (int i = 0; i < kolcsonzesek.size(); i++) {
			
			String szoveg= kolcsonzesek.get(i).getElvitelOra() + ":" + kolcsonzesek.get(i).getElvitelPerc()+"-"
					+kolcsonzesek.get(i).getVisszaOra()+":"+kolcsonzesek.get(i).getVisszaPerc() + " : " 
					+ kolcsonzesek.get(i).getNev();
			
			if (kolcsonzesek.get(i).getJarmuAzon()=='F') {
				
				out.write(szoveg+"\n");
			}
			
		}
		
		out.close();
		
	}

	public void statisztika(List<Kolcsonzes> kolcsonzesek) {
		
		System.out.println("\n10. feladat: Statisztika");
		
		Map<Character, Integer> statisztika = new TreeMap<Character, Integer>();//treemap abc sorrendben nyomtat
		
		for (Kolcsonzes kolcsonzes : kolcsonzesek) {
			
			if (statisztika.containsKey(kolcsonzes.getJarmuAzon())) {
				statisztika.replace(kolcsonzes.getJarmuAzon(), statisztika.get(kolcsonzes.getJarmuAzon())+1);
			}
			
			else {
				statisztika.put(kolcsonzes.getJarmuAzon(), 1);
			}
			
		}
		for(Map.Entry<Character, Integer> item : statisztika.entrySet()) {
			System.out.println(item.getKey() + " - " + item.getValue());
		}
	}

	
	

}
