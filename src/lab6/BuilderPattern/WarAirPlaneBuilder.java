package lab6.BuilderPattern;

public class WarAirPlaneBuilder implements AirPlaneBuilder {
    private int speed;
    private int weight;
    private int capacity;
    private String name;
    @Override
    public AirPlaneBuilder setSpeed() {
        this.speed = 2500;
        return this;
    }

    @Override
    public AirPlaneBuilder setWeight() {
        this.weight = 25;
        return this;
    }

    @Override
    public AirPlaneBuilder setCapacity() {
        this.capacity = 1;
        return this;
    }

    @Override
    public AirPlaneBuilder setName() {
        this.name = "Су-35";
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
