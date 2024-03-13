package lab8.memento;


// Пример использования
public class Main {
    public static void main(String[] args) {
        // Создаем объект Originator
        Originator originator = new Originator();
        // Создаем объект Caretaker
        Caretaker caretaker = new Caretaker();

        // Устанавливаем состояние объекта Originator
        originator.setState("Состояние 1");
        // Сохраняем состояние в снимок
        caretaker.addMemento(originator.saveStateToMemento());

        // Изменяем состояние объекта Originator
        originator.setState("Состояние 2");
        // Сохраняем новое состояние в снимок
        caretaker.addMemento(originator.saveStateToMemento());
        originator.setState("Состояние 100");
        System.out.println("Текущее состояние: " + originator.getState());
        // Восстанавливаем предыдущее состояние из снимка
        originator.setStateFromMemento(caretaker.getLastMemento());
        System.out.println("Текущее состояние после восстановления: " + originator.getState());

        // Отменяем последнее действие (возвращаемся к предыдущему состоянию)
        caretaker.undo();
        originator.setStateFromMemento(caretaker.getLastMemento());
        System.out.println("Текущее состояние после отмены: " + originator.getState());
    }
}
