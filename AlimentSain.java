public class AlimentSain extends Item {
	private double valeurNutritive;
	private int tailleSup;
	private String nom;

	public AlimentSain(String nom, double valeurNutritive, int tailleSup) {
		this.nom = nom;
		this.valeurNutritive = valeurNutritive;
		this.tailleSup = tailleSup;
	}

	public AlimentSain(String nom) {
		this(nom, (int) (Math.random() * 6) + 15, (int) (Math.random() * 3) + 1);
	}
}