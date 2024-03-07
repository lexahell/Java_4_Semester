package lab6.PrototypePattern;

public class AirPlaneFactory{
    private AirPlane airPlane;
    public AirPlaneFactory(AirPlane airPlane) {
        this.airPlane = airPlane;
    }
    public void setAirPlane(AirPlane airPlane) {
        this.airPlane = airPlane;
    }
    public AirPlane copy() {
        return (AirPlane) airPlane.copy();
    }
}
