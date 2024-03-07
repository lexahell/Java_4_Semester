package lab6.AbstractFactoryPattern;

public class GrandfatherSayerProduct implements AbstractProduct{
    @Override
    public void relateToName(String name) {
        System.out.println("My grandfather`s name is "+name);
    }
}