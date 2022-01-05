package shoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] shoppersInput = sc.nextLine().split(";");

        Map<String,Person> shoppers = new LinkedHashMap<>();

        try {

            for (String shopper : shoppersInput) {
                String name = shopper.split("=")[0];
                double money = Double.parseDouble(shopper.split("=")[1]);
                Person person = new Person(name, money);
                shoppers.put(person.getName(),person);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        String[] productsInput = sc.nextLine().split(";");
        Map<String,Product> products = new LinkedHashMap<>();

        try {

            for (String product : productsInput) {
                String name = product.split("=")[0];
                double cost = Double.parseDouble(product.split("=")[1]);
                Product product1 = new Product(name, cost);
                products.put(product1.getName(),product1);
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        String command = sc.nextLine();
        while (!command.equals("END")){
            String name = command.split("\\s+")[0];
            String product = command.split("\\s+")[1];
            if (shoppers.containsKey(name)){

                shoppers.get(name).buyProduct(name,products.get(product));
            }
            command = sc.nextLine();
        }

        shoppers.values().forEach(System.out::println);
    }
}


