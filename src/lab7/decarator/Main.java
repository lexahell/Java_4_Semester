package lab7.decarator;

public class Main {
    public static void main(String[] args){
        Pizza pizza = new PlainPizza();

        pizza = new CheeseDecorator(pizza);
        pizza = new PepperoniDecorator(pizza);

        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: $" + pizza.getCost());
    }
}
