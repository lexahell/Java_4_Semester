package lab8.memento;

// Класс снимка, который хранит состояние объекта
class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
