package lab6.PrototypePattern;

public class Tester {
    public static void main(String[] args) {
        AirPlane airPlane = new AirPlane(330, 85, 215, "Boeing 737");
        System.out.println(airPlane);
        System.out.println("=========================");
        AirPlaneFactory airPlaneFactory = new AirPlaneFactory(airPlane);
        AirPlane copy = airPlaneFactory.copy();
        System.out.println(copy);
    }
}
