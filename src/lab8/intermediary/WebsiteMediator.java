package lab8.intermediary;

import java.util.ArrayList;
import java.util.List;

// Конкретный посредник
class WebsiteMediator implements Mediator {
    private List<Component> components;

    public WebsiteMediator() {
        this.components = new ArrayList<>();
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public void sendMessage(Component sender, String message) {
        for (Component component : components) {
            // Посредник направляет сообщение всем компонентам, кроме отправителя
            if (component != sender) {
                component.receiveMessage(message);
            }
        }
    }
}
