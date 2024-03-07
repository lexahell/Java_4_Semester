package lab6.BuilderPattern;

public class PassengerAirPLaneBuilder implements AirPlaneBuilder{
    private int speed;
    private int weight;
    private int capacity;
    private String name;
    @Override
    public AirPlaneBuilder setSpeed() {
        this.speed = 330;
        return this;
    }

    @Override
    public AirPlaneBuilder setWeight() {
        this.weight = 85;
        return this;
    }

    @Override
    public AirPlaneBuilder setCapacity() {
        this.capacity = 215;
        return this;
    }

    @Override
    public AirPlaneBuilder setName() {
        this.name = "Boeing 737";
        return this;
    }

    @Override
    public AirPlane build() {
        AirPlane airPlane = new AirPlane(
                this.speed,
                this.weight,
                this.capacity,
                this.name
        );
        if (airPlane.doQualityCheck()) {
            return airPlane;
        } else {
            return null;
        }
    }
}
