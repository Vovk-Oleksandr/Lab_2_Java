import java.util.List;
import java.util.ArrayList;

// базовий клас Media
abstract class Media {
    private String title;

    public Media(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract void displayInfo();
}

// клас Book
class Book extends Media {
    private String author;

    public Book(String title, String author) {
        super(title);
        this.author = author;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book: " + getTitle() + ", Author: " + author);
    }
}

// клас Magazine
class Magazine extends Media {
    private int issueNumber;

    public Magazine(String title, int issueNumber) {
        super(title);
        this.issueNumber = issueNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println("Magazine: " + getTitle() + ", Issue: " + issueNumber);
    }
}

// клас DVD
class DVD extends Media {
    private int duration;

    public DVD(String title, int duration) {
        super(title);
        this.duration = duration;
    }

    @Override
    public void displayInfo() {
        System.out.println("DVD: " + getTitle() + ", Duration: " + duration + " minutes");
    }
}

// клас Library
class Library<T extends Media> {
    private List<T> collection;

    public Library() {
        collection = new ArrayList<>();
    }

    public void addMedia(T media) {
        collection.add(media);
        System.out.println(media.getTitle() + " has been added to the library.");
    }

    public void removeMedia(String title) {
        collection.removeIf(media -> media.getTitle().equals(title));
        System.out.println(title + " has been removed from the library.");
    }

    public void searchMedia(String title) {
        for (T media : collection) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: ");
                media.displayInfo();
                return;
            }
        }
        System.out.println(title + " not found in the library.");
    }

    public void displayAllMedia() {
        if (collection.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        System.out.println("Library collection:");
        for (T media : collection) {
            media.displayInfo();
        }
    }
}

// основний клас програми
public class MainTwo{
    public static void main(String[] args) {
        Library<Media> library = new Library<>();

        // додавання медіа-ресурсів
        library.addMedia(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        library.addMedia(new Magazine("National Geographic", 2023));
        library.addMedia(new DVD("Inception", 148));

        // перегляд усіх ресурсів
        library.displayAllMedia();

        // пошук ресурсу
        library.searchMedia("The Great Gatsby");

        // видалення ресурсу
        library.removeMedia("Inception");

        // перегляд після видалення
        library.displayAllMedia();
    }
}
