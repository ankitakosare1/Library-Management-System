import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(String bookID, String title, String author, String genre, String availability){
        if(getBookByID(bookID) != null){
            System.out.println("Error: Book ID must be unique");
            return;
        }
        if(title.isEmpty() || author.isEmpty()){
            System.out.println("Error: Title and Author cannot be empty");
            return;
        }
        if(!availability.equals("Available") && !availability.equals("Checked Out")){
            System.out.println("Error: Invalid availability status.");
            return;
        }
        books.add(new Book(bookID, title, author, genre, availability));
        System.out.println("Book added successfully.");
    }

    public void viewBooks(){
        if(books.isEmpty()){
            System.out.println("No books in the library");
        }
        else{
            books.forEach(System.out::println);
        }
    }

    public void searchBook(String query){
        for(Book book: books){
            if(book.getBookID().equals(query) || book.getTitle().equalsIgnoreCase(query)){
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found");
    }

    public void updateBook(String bookID, String title, String author, String genre, String availability){
        Book book = getBookByID(bookID);
        
        if(book != null){
            if(title != null && !title.isEmpty()) book.setTitle(title);
            if(author != null && !author.isEmpty()) book.setAuthor(author);
            if(genre != null && !genre.isEmpty()) book.setGenre(genre);

            // If availability is empty, keep the current value
            if (availability != null && !availability.isEmpty()) {
                if (availability.equals("Available") || availability.equals("Checked Out")) {
                    book.setAvailability(availability);
                } else {
                    System.out.println("Error: Invalid availability status");
                    return;
                }
            }

            System.out.println("Book updated successfully");
        }
        else{
            System.out.println("Book not found");
        }
    }

    public void deleteBook(String bookID){
        Book book = getBookByID(bookID);
        if(book != null){
            books.remove(book);
            System.out.println("Book deleted successfully");
        }
        else{
            System.out.println("Book not found.");
        }
    }

    private Book getBookByID(String bookID){
        return books.stream().filter(b -> b.getBookID().equals(bookID)).findFirst().orElse(null);
    }
}
