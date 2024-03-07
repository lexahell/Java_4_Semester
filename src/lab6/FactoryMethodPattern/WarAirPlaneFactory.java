package lab6.FactoryMethodPattern;

public class WarAirPlaneFactory extends AirPlaneFactory{
    public AirPlane createAirPlane(AirPlaneType type) {
        AirPlane airPlane;
        switch (type) {
            case RAPTOR -> airPlane = new Raptor();
            case HERCULES -> airPlane = new Hercules();
            default -> airPlane = null;
        }
        return airPlane;
    }
}
