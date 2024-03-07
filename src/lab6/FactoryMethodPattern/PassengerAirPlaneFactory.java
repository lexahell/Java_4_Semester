package lab6.FactoryMethodPattern;

public class PassengerAirPlaneFactory extends AirPlaneFactory{
    public AirPlane createAirPlane(AirPlaneType type) {
        AirPlane airPlane;
        switch (type) {
            case BOEING -> airPlane = new Boeing();
            default -> airPlane = null;
        }
        return airPlane;
    }
}
