package lab6.BuilderPattern;

public class AirPlaneEngineer {
    private AirPlaneBuilder airPlaneBuilder;
    public AirPlaneEngineer(AirPlaneBuilder airPlaneBuilder) {
        this.airPlaneBuilder = airPlaneBuilder;
    }
    public AirPlane manufactureAirPlane() {
        return this.airPlaneBuilder.setSpeed().setWeight().setCapacity().setName().build();
    }
}
