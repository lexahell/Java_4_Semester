package lab7.decarator;

public class PepperoniDecorator implements Pizza{
    private Pizza pizza;

    public PepperoniDecorator(Pizza pizza){
        this.pizza = pizza;
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }
    @Override
    public double getCost(){
        return pizza.getCost() + 2.00;
    }
}
