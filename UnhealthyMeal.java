public class UnhealthyMeal extends Consumable {
    public UnhealthyMeal(String name, int nutritiveValue, int additionalSize, int x, int y) throws InvalidNameException {
        super(name, nutritiveValue, additionalSize, x, y);
    }

    public UnhealthyMeal(String name, int x, int y) throws InvalidNameException {
        this(name, (int) (Math.random() * 6) + 20, (int) (Math.random() * 3) + 5, x, y);
        //           random integer in [20, 25]      random integer in [5, 7]
    }

    public UnhealthyMeal clone() {
    	try {
    		return new UnhealthyMeal(this.name, this.nutritiveValue,this.additionalSize, this.x, this.y);
    	} catch (InvalidNameException error) {
			System.out.println("Erreur : " + error.getMessage());
    		return null;
    	}
    }
}
