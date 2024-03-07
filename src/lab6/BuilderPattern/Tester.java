package lab6.BuilderPattern;

public class Tester {
    public static void main(String[] args) {
        AirPlaneBuilder airPlaneBuilder = new PassengerAirPLaneBuilder();
        AirPlaneEngineer airPlaneEngineer = new AirPlaneEngineer(airPlaneBuilder);
        AirPlane airPlane = airPlaneEngineer.manufactureAirPlane();
        if (airPlane != null) {
            System.out.println(airPlane);
        }
    }
}
