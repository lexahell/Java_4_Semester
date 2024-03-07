package lab6.AbstractFactoryPattern;

public class FatherSayerProduct implements AbstractProduct{

    @Override
    public void relateToName(String name) {
        System.out.println("My father`s name is "+name);
    }
}