package lab8.intermediary;

import java.util.ArrayList;
import java.util.List;

// Пример использования
public class Main {
    public static void main(String[] args) {
        WebsiteMediator mediator = new WebsiteMediator();
        ChatComponent chat = new ChatComponent(mediator);
        ForumComponent forum = new ForumComponent(mediator);

        mediator.addComponent(chat);
        mediator.addComponent(forum);

        chat.sendMessage("Привет всем!");
        forum.sendMessage("Важное объявление!");
    }
}
