package lab6.AbstractFactoryPattern;

public class CatSayerProduct implements AbstractProduct{
    @Override
    public void relateToName(String name) {
        System.out.println("My cat`s name is "+name);
    }
}
