package lab8.memento;

// Класс, представляющий состояние, которое нужно сохранить
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    // Создание снимка
    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    // Восстановление состояния из снимка
    public void setStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
