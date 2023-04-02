package demo;

import domain.Author;
import domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class InsertAuthorForBook {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Author Name: ");
            String aname = sc.next();
            System.out.println("Enter Book Name: ");
            String bname = sc.next();

                    Configuration cfg;
                    SessionFactory factory;
                    Session ses;
                    Transaction tx;

                    cfg = new Configuration();
                    cfg = cfg.configure();
                    cfg = cfg.addAnnotatedClass(Author.class);
                    cfg = cfg.addAnnotatedClass(Book.class);
                    factory = cfg.buildSessionFactory();
                    ses = factory.openSession();

            //create object of Author
            Author a1 = new Author();
            a1.setAuthorName(aname);

            //create object of book
            Book b1 = new Book();
            b1.setBookName(bname);

            //add Author to Book
            b1.addAuthor(a1);

            //save objects
            tx=ses.beginTransaction();
            ses.save(a1);
            ses.save(b1);
            tx.commit();
            System.out.println("AUTHOR ADDED SUCCESSFULLY");


        }
    }

