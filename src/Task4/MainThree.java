import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// клас Logger (Singleton)
class Logger {
    private static Logger instance;
    private FileWriter fileWriter;

    private Logger() {
        try {
            fileWriter = new FileWriter("log.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        try {
            System.out.println(message);
            fileWriter.write(message + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// інтерфейс Notification
interface Notification {
    void send(String message);
}

// класи сповіщень
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Push Notification sent: " + message);
    }
}

// клас NotificationFactory
class NotificationFactory {
    public static Notification createNotification(String type) {
        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SMSNotification();
            case "push" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown notification type: " + type);
        };
    }
}

// інтерфейс Subscriber
interface Subscriber {
    void update(String news);
}

// клас NewsAgency
class NewsAgency {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println("Subscriber added.");
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
        System.out.println("Subscriber removed.");
    }

    public void notifySubscribers(String news) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(news);
        }
    }

    public void generateNews(String news) {
        System.out.println("News generated: " + news);
        notifySubscribers(news);
    }
}

// клас SubscriberUser
class SubscriberUser implements Subscriber {
    private final String name;

    public SubscriberUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}

// основний клас програми
public class MainThree {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Program started.");

        // Використання NotificationFactory
        Notification email = NotificationFactory.createNotification("email");
        Notification sms = NotificationFactory.createNotification("sms");
        Notification push = NotificationFactory.createNotification("push");

        email.send("Hello via Email!");
        sms.send("Hello via SMS!");
        push.send("Hello via Push Notification!");

        // Використання NewsAgency та Observer
        NewsAgency agency = new NewsAgency();

        Subscriber user1 = new SubscriberUser("Alice");
        Subscriber user2 = new SubscriberUser("Bob");

        agency.subscribe(user1);
        agency.subscribe(user2);

        agency.generateNews("Breaking News: Design Patterns in Action!");

        agency.unsubscribe(user1);

        agency.generateNews("Update: Observer Pattern Simplified.");

        logger.log("Program ended.");
    }
}
