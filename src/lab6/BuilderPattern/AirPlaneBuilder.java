package lab6.BuilderPattern;

public interface AirPlaneBuilder {
    public AirPlaneBuilder setSpeed();

    public AirPlaneBuilder setWeight();

    public AirPlaneBuilder setCapacity();

    public AirPlaneBuilder setName();

    public AirPlane build();
}
