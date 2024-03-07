package lab6.FactoryMethodPattern;

public class Tester {
    public static void main(String[] args) {
        AirPlaneFactory passengerAirPlaneFactory = new PassengerAirPlaneFactory();
        AirPlane passengerAirPlane = passengerAirPlaneFactory.createAirPlane(AirPlaneType.BOEING);
        passengerAirPlane.printName();
        System.out.println("======================");
        AirPlaneFactory warAirPlaneFactory = new WarAirPlaneFactory();
        AirPlane warAirPlane = warAirPlaneFactory.createAirPlane(AirPlaneType.HERCULES);
        warAirPlane.printName();
    }
}
