package vizibicikliUj;

public class Kolcsonzes {
	
	private String nev;
	private char jarmuAzon;
	private String elvitelOra;
	private String elvitelPerc;
	private String visszaOra;
	private String visszaPerc;
	
	public Kolcsonzes(String nev, char jarmuAzon, String elvitelOra, String elvitelPerc, String visszaOra, String visszaPerc) {
		this.nev = nev;
		this.jarmuAzon = jarmuAzon;
		this.elvitelOra = elvitelOra;
		this.elvitelPerc = elvitelPerc;
		this.visszaOra = visszaOra;
		this.visszaPerc = visszaPerc;
	}
	

	
	public String getNev() {
		return nev;
	}


	public char getJarmuAzon() {
		return jarmuAzon;
	}

	public String getElvitelOra() {
		
		if (elvitelOra.length()==1) {
			return String.valueOf(0)+elvitelOra;
		}
		else {
			return elvitelOra;
		}
	}
	
	public String getElvitelPerc() {
		
		if (elvitelPerc.length()==1) {
			return String.valueOf(0)+elvitelPerc;
		}
		else {
			return elvitelPerc;
		}
	}
	
	public String getVisszaOra() {
		
		if (visszaOra.length()==1) {
			return String.valueOf(0)+visszaOra;
		}
		else {
			return visszaOra;
		}
	}

	public String getVisszaPerc() {
		if (visszaPerc.length()==1) {
			return String.valueOf(0)+visszaPerc;
		}
		else {
			return visszaPerc;
		}
		
	}

	public void setElvitelOra(String elvitelOra) {
		
			this.elvitelOra = elvitelOra;
	
	}

	public void setElvitelPerc(String elvitelPerc) {

			this.elvitelPerc = elvitelPerc;
		
		
	}

	public void setVisszaOra(String visszaOra) {
		
			this.visszaOra = visszaOra;
		
		
	}

	public void setVisszaPerc(String visszaPerc) {
		this.visszaPerc = visszaPerc;
	}

	

	@Override
	public String toString() {
		return elvitelOra + ":"+elvitelPerc + "-" + visszaOra
				+ ":" + visszaPerc;
	}
	
	
	

	
}
