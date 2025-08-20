import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

class Book {
    private String title;
    private String author;
    private String code;
    private boolean available;

    public Book(String title, String author, String code) {
        this.title = title;
        this.author = author;
        this.code = code;
        this.available = true;
    }

    public void displayData() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Code: " + code);
        System.out.println("Available: " + (available ? "Yes" : "No"));
    }

    public void markBorrowed() {
        this.available = false;
    }

    public void markAvailable() {
        this.available = true;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCode() { return code; }
    public boolean isAvailable() { return available; }
}

class User {
    private String name;
    private String userId;
    private ArrayList<Book> borrowedBooks;
    private static final int MAX_BOOKS = 3;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
    }

    public void displayData() {
        System.out.println("Name: " + name);
        System.out.println("User ID: " + userId);
        System.out.println("Books borrowed: " + borrowedBooks.size() + "/" + MAX_BOOKS);
    }

    public boolean addLoan(Book book) {
        if (borrowedBooks.size() < MAX_BOOKS && book.isAvailable()) {
            borrowedBooks.add(book);
            book.markBorrowed();
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.markAvailable();
            return true;
        }
        return false;
    }

    public boolean hasBook(Book book) {
        return borrowedBooks.contains(book);
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public String getName() { return name; }
    public String getUserId() { return userId; }
}

class LoanRecord {
    private User user;
    private Book book;
    private Date loanDate;
    private Date dueDate;
    private static final int LOAN_DAYS = 7;
    private static final double FINE_PER_DAY = 500.0;

    public LoanRecord(User user, Book book) {
        this.user = user;
        this.book = book;
        this.loanDate = new Date();
        this.dueDate = new Date(loanDate.getTime() + (LOAN_DAYS * 24 * 60 * 60 * 1000));
    }

    public double calculateFine() {
        Date today = new Date();
        if (today.after(dueDate)) {
            long daysLate = (today.getTime() - dueDate.getTime()) / (24 * 60 * 60 * 1000);
            return daysLate * FINE_PER_DAY;
        }
        return 0.0;
    }

    public void displayRecord() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("User: " + user.getName());
        System.out.println("Book: " + book.getTitle());
        System.out.println("Loan date: " + sdf.format(loanDate));
        System.out.println("Due date: " + sdf.format(dueDate));
        double fine = calculateFine();
        if (fine > 0) {
            System.out.println("Fine: $" + fine);
        }
    }

    public User getUser() { return user; }
    public Book getBook() { return book; }
}

class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<LoanRecord> loanHistory;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.loanHistory = new ArrayList<>();
    }

    public void registerBook(String title, String author, String code) {
        books.add(new Book(title, author, code));
    }

    public void registerUser(String name, String userId) {
        users.add(new User(name, userId));
    }

    public boolean loanBook(String userId, String bookCode) {
        User user = findUser(userId);
        Book book = findBook(bookCode);

        if (user != null && book != null && book.isAvailable() && user.getBorrowedBooks().size() < 3) {
            if (user.addLoan(book)) {
                loanHistory.add(new LoanRecord(user, book));
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String userId, String bookCode) {
        User user = findUser(userId);
        Book book = findBook(bookCode);

        if (user != null && book != null && user.hasBook(book)) {
            if (user.returnBook(book)) {
                for (LoanRecord record : loanHistory) {
                    if (record.getUser().equals(user) && record.getBook().equals(book)) {
                        double fine = record.calculateFine();
                        if (fine > 0) {
                            System.out.println("Late return fine: $" + fine);
                        } else {
                            System.out.println("Book returned on time. No fine.");
                        }
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void displayAvailableBooks() {
        System.out.println("\n=== Available Books ===");
        for (Book book : books) {
            if (book.isAvailable()) {
                book.displayData();
                System.out.println("-------------------");
            }
        }
    }

    public void displayUsers() {
        System.out.println("\n=== Registered Users ===");
        for (User user : users) {
            user.displayData();
            System.out.println("-------------------");
        }
    }

    public void displayLoanHistory() {
        System.out.println("\n=== Loan History ===");
        for (LoanRecord record : loanHistory) {
            record.displayRecord();
            System.out.println("-------------------");
        }
    }

    private User findUser(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    private Book findBook(String bookCode) {
        for (Book book : books) {
            if (book.getCode().equals(bookCode)) {
                return book;
            }
        }
        return null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        
        library.registerBook("The Great Gatsby", "F. Scott Fitzgerald", "BK001");
        library.registerBook("1984", "George Orwell", "BK002");
        library.registerBook("To Kill a Mockingbird", "Harper Lee", "BK003");
        library.registerUser("John Doe", "U001");
        library.registerUser("Jane Smith", "U002");

        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Register Book");
            System.out.println("2. Register User");
            System.out.println("3. Loan Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Available Books");
            System.out.println("6. Display Users");
            System.out.println("7. Display Loan History");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book code: ");
                    String bookCode = scanner.nextLine();
                    library.registerBook(title, author, bookCode);
                    System.out.println("Book registered successfully!");
                    break;

                case 2:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    String userId = scanner.nextLine();
                    library.registerUser(name, userId);
                    System.out.println("User registered successfully!");
                    break;

                case 3:
                    System.out.print("Enter user ID: ");
                    String loanUserId = scanner.nextLine();
                    System.out.print("Enter book code: ");
                    String loanBookCode = scanner.nextLine();
                    if (library.loanBook(loanUserId, loanBookCode)) {
                        System.out.println("Book loaned successfully!");
                    } else {
                        System.out.println("Failed to loan book. Check user ID, book code, and availability.");
                    }
                    break;

                case 4:
                    System.out.print("Enter user ID: ");
                    String returnUserId = scanner.nextLine();
                    System.out.print("Enter book code: ");
                    String returnBookCode = scanner.nextLine();
                    if (library.returnBook(returnUserId, returnBookCode)) {
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Failed to return book. Check user ID and book code.");
                    }
                    break;

                case 5:
                    library.displayAvailableBooks();
                    break;

                case 6:
                    library.displayUsers();
                    break;

                case 7:
                    library.displayLoanHistory();
                    break;

                case 8:
                    System.out.println("Thank you for using the Library Management System!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
