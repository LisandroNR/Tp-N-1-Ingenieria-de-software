import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private Map<String, List<EventListeners>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListeners listener) {
        List<EventListeners> users = listeners.get(eventType);
        if (users != null && !users.contains(listener)) {
            users.add(listener);
        }
    }

    public void unsubscribe(String eventType, EventListeners listener) {
        List<EventListeners> users = listeners.get(eventType);
        if (users != null) {
            users.remove(listener);
        }
    }

    public void notify(String eventType, String data) {
        List<EventListeners> users = listeners.get(eventType);
        if (users != null) {
            for (EventListeners listener : users) {
                listener.update(data);
            }
        }
    }
}
