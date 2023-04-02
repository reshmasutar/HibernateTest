package demo;

import domain.Author;
import domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DisplayBookHaveOneAuthor {
    public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);
               System.out.println("Enter Author Id: ");
               int id = sc.nextInt();

                Configuration cfg;
                SessionFactory factory;
                Session ses;

                cfg = new Configuration();
                cfg = cfg.configure();
                cfg = cfg.addAnnotatedClass(Book.class);
                cfg = cfg.addAnnotatedClass(Author.class);
                factory = cfg.buildSessionFactory();
                ses = factory.openSession();

                //Author a1 = ses.load(Author.class, id);
                Author a1 = ses.load(Author.class, id);
                System.out.println("Author Name: "+a1.getAuthorName());

                List<Book> bookList = a1.getBookList();
                System.out.println("======================================================");
                for (Book b : bookList) {
                    if(id==a1.getAuthorId()){
                        System.out.println("Book Name: "+b.getBookName());
                    }
                }

    }
}
