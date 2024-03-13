package lab7.facade;

public class HomeCinema {
    private Projector projector;
    private AudioSystem audioSystem;
    private DVDPlayer dvdPlayer;

    public HomeCinema(){
        this.projector = new Projector();
        this.audioSystem = new AudioSystem();
        this.dvdPlayer = new DVDPlayer();
    }

    public void watchMovie(){
        System.out.println("Get ready to watch a movie...");
        projector.turnOn();
        projector.setInput("DVD");
        audioSystem.turnOn();
        audioSystem.setVolume(10);
        dvdPlayer.turnOn();
        dvdPlayer.play();
    }
}

