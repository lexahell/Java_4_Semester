package lab6.AbstractFactoryPattern;

public class PetSayerFactory implements AbstractFactory{
    @Override
    public AbstractProduct createProductA() {
        return new DogSayerProduct();
    }

    @Override
    public AbstractProduct createProductB() {
        return new CatSayerProduct();
    }
}
