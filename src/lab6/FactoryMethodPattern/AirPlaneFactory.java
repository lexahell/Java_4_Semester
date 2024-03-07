package lab6.FactoryMethodPattern;

public abstract class AirPlaneFactory {
    public AirPlane buyAirPlane(AirPlaneType type) {
        return createAirPlane(type);
    }
    protected abstract AirPlane createAirPlane(AirPlaneType type);
}
