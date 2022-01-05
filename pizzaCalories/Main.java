package pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            String pizzaInput = sc.nextLine();

            String pizzaName = pizzaInput.split("\\s+")[1];
            int numberOfToppings = Integer.parseInt(pizzaInput.split("\\s+")[2]);

            String doughInput = sc.nextLine();

            String flourType = doughInput.split("\\s+")[1];
            String bakingTechnique = doughInput.split("\\s+")[2];
            double weight = Double.parseDouble(doughInput.split("\\s+")[3]);



            Pizza pizza = new Pizza(pizzaName,numberOfToppings);
            Dough dough = new Dough(flourType,bakingTechnique,weight);
            pizza.setDough(dough);
            String toppingsInput = sc.nextLine();
            while (!toppingsInput.equals("END")){

                String toppingType = toppingsInput.split("\\s+")[1];
                double toppingWeight = Double.parseDouble(toppingsInput.split("\\s+")[2]);
                Toppings toppings = new Toppings(toppingType,toppingWeight);

                pizza.addTopping(toppings);

                toppingsInput = sc.nextLine();
            }

            System.out.printf ("%s - %.2f",pizza.getName(),pizza.getOverAllCalories());

        }
        catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());

        }

    }
}
