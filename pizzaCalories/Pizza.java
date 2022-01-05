package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Toppings> toppings;

    public Pizza(String name,int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);

    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name == null || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }
    private void setToppings(int numberOfToppings) {
        if (numberOfToppings > 9 || numberOfToppings < 0){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        toppings = new ArrayList<>(numberOfToppings);
    }
    public void addTopping (Toppings topping){
        if (toppings.size() > 9){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        toppings.add(topping);
    }
    public double getOverAllCalories(){
        double calories = 0;
        calories += dough.calculateCalories();
        for (Toppings topping :
                toppings) {
            calories += topping.calculateCalories();
        }
        return calories;
    }
}
