package pizzaCalories;

public class Toppings {
    private String toppingType;
    private double weight;

    //•	Meat – 1.2;
    //•	Veggies – 0.8;
    //•	Cheese – 1.1;
    //•	Sauce – 0.9;

    public Toppings(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!toppingType.equals("Meat") && !toppingType.equals("Veggies")
                && !toppingType.equals("Cheese") && !toppingType.equals("Sauce")){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        double calories;
        double toppingTypeModifier = 0;
        switch (toppingType){
            case "Meat":
                toppingTypeModifier = 1.2;
                break;
            case "Veggies":
                toppingTypeModifier = 0.8;
                break;
            case "Cheese":
                toppingTypeModifier = 1.1;
                break;
            case "Sauce":
                toppingTypeModifier = 0.9;
                break;
        }
        calories = (2 * weight) * toppingTypeModifier;
        return calories;
    }
}
