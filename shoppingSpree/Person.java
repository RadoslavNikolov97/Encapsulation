package shoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private final List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }
    public void buyProduct(String name,Product product){
        if (product.getCost() > money){
            System.out.printf("%s can't afford %s%n",name,product.getName());
        }
        else {
            money -= product.getCost();
            products.add(product);
            System.out.printf("%s bought %s%n",name,product.getName());

        }
    }

    @Override
    public String toString() {
        //George - Milk, Milk
        if (products.size() >= 1){
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" - ");
        for (Product product :
                products) {
           sb.append(product.getName()).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);

        return sb.toString();
    }
        else {
            //Maria – Nothing bought
            return String.format("%s - Nothing bought",name);
        }
    }
}
