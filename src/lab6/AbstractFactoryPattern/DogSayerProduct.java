package lab6.AbstractFactoryPattern;

public class DogSayerProduct implements AbstractProduct{
    @Override
    public void relateToName(String name) {
        System.out.println("My dog`s name is "+name);
    }
}
