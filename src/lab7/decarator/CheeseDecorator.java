package lab7.decarator;

public class CheeseDecorator implements Pizza{
    private Pizza pizza;

    public  CheeseDecorator(Pizza pizza){
        this.pizza = pizza;
    }
    @Override
    public String getDescription(){
        return pizza.getDescription() + ", Cheese";
    }
    @Override
    public double getCost() {
        return pizza.getCost() + 1.50;
    }
}
