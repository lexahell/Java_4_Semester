package lab8.memento;

import java.util.ArrayList;
import java.util.List;

// Класс, который будет хранить список снимков состояния
class Caretaker {
    private List<Memento> mementos = new ArrayList<>();

    // Добавление снимка в список
    public void addMemento(Memento memento) {
        mementos.add(memento);
    }

    // Получение последнего снимка из списка
    public Memento getLastMemento() {
        if (!mementos.isEmpty()) {
            return mementos.get(mementos.size() - 1);
        }
        return null;
    }

    // Удаление последнего снимка из списка
    public void undo() {
        if (!mementos.isEmpty()) {
            mementos.remove(mementos.size() - 1);
        }
    }
}
