import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Runner.addBooks();
    }
}
class Runner{
    private static String title, genre;
    private static int pageNum; 
    private static String[][] userPrompts = {
        {"title", "Book Title: "},
        {"genre","Book Genre: "},
        {"pageNum", "Number of Pages: "},
    };

    public static void addBooks(){
        String input;
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Enter to Quit");
            while(true){
                for(String[] prompt: userPrompts){
                    System.out.print(prompt[1]);
                    input = scanner.nextLine();
                    if(input.equals("")){
                        return;
                    }
                    switch(prompt[0]){
                        case "title":
                            title = input;
                            break;
                        case "genre":
                            genre = input;
                            break;
                        case "pageNum":
                            pageNum = Integer.parseInt(input);
                            break;
                    }
                }
                Book book = new Book(title,genre,pageNum);
                Library.addBook(book);
            }
        } catch (Exception e){
            System.out.println("Error probably not a number for pages");
        } finally {
            System.out.println(Library.books);
        }
    }
}

class Library {
    static List<Book> books = new ArrayList<Book>();
    public static void addBook(Book book){
       books.add(book);
    }
}

class Book {
    private String title,genre;
    private int numPages;
    public Book(String title, String genre, int numPages){
        this.title = title;
        this.genre = genre;
        this.numPages = numPages;
    }
    @Override
    public String toString(){
        return "Title: " + this.title + " Genre: " + this.genre + " Pages: " + this.numPages;
    }
}