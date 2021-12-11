public class UnhealthyMeal extends Item implements PasSain {
	private double valeurNutritive;
	private int tailleSup;
	private String nom;

	public UnhealthyMeal(String nom, double valeurNutritive, int tailleSup) {
		this.nom = nom;
		this.valeurNutritive = valeurNutritive;
		this.tailleSup = tailleSup;
	}

	public UnhealthyMeal(String nom) {
		this(nom, (int) (Math.random() * 6) + 15, (int) (Math.random() * 3) + 1);
	}
}