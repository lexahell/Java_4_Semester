package lab6.BuilderPattern;

public class AirPlane {
    private int speed;
    private int weight;
    private int capacity;
    private String name;
    public AirPlane(int speed, int weight, int capacity, String name) {
        this.speed = speed;
        this.weight = weight;
        this.capacity = capacity;
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean doQualityCheck() {
        return (speed > 0 && weight > 0 && capacity > 0 && (name != null && !name.trim().isEmpty()));
    }

    @Override
    public String toString() {
        return "AirPlane{" +
                "speed=" + speed +
                ", weight=" + weight +
                ", capacity=" + capacity +
                ", name='" + name + '\'' +
                '}';
    }
}
