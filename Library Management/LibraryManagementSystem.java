import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Library library = new Library();

        while(true){
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1: 
                    System.out.print("Enter Book ID: ");
                    String bookID = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Availability (Available/Checked Out): ");
                    String availability = scanner.nextLine();
                    library.addBook(bookID, title, author, genre, availability);
                    break;
                case 2:
                    library.viewBooks();
                    break;
                case 3: 
                    System.out.print("Enter Book ID or Title to Search: ");
                    String query = scanner.nextLine();
                    library.searchBook(query);
                    break;
                case 4: 
                    System.out.print("Enter Book ID to update: ");
                    bookID = scanner.nextLine();
                    System.out.print("Enter new Title (or press Enter to keep unchanged): ");
                    title = scanner.nextLine();
                    System.out.print("Enter new Author (or press Enter to keep unchanged): ");
                    author = scanner.nextLine();
                    System.out.print("Enter new Genre (or press Enter to keep unchanged): ");
                    genre = scanner.nextLine();
                    System.out.print("Enter new Availability (Available/Checked Out, or press Enter to keep unchanged): ");
                    availability = scanner.nextLine();
                    library.updateBook(bookID, title, author, genre, availability);
                    break;
                case 5: 
                    System.out.print("Enter Book ID to delete: ");
                    bookID = scanner.nextLine();
                    library.deleteBook(bookID);
                    break;
                case 6: 
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");                
            }
        }
    }
}