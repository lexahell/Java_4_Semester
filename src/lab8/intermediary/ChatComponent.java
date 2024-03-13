package lab8.intermediary;

// Конкретный компонент - Чат
class ChatComponent extends Component {
    public ChatComponent(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Сообщение, написанное в чате: " + message);
        mediator.sendMessage(this, message);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Сообщение, полученное чатом: " + message);
    }
}
