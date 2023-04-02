package demo;

import domain.Author;
import domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DisplayAuthorHaveMoreBook {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book Id: ");
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

        Book b1 = ses.load(Book.class, id);
        System.out.println("Book Name: "+b1.getBookName());

        List<Author> authorList = b1.getAuthorList();
        System.out.println("======================================================");
        for (Author a : authorList) {
            if(id== b1.getBookId()){
                       System.out.println(a.getAuthorName());
        }
    }
    }
}
