package lab8.intermediary;

// Конкретный компонент - Форум
class ForumComponent extends Component {
    public ForumComponent(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Сообщение, написанное на форуме: " + message);
        mediator.sendMessage(this, message);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Сообщение, полученное форумом: " + message);
    }
}
