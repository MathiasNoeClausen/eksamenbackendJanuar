package utils;

import entities.Book;
import entities.Loan;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupBooks {
        public static void main(String[] args) {
    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    
    
    Book book = new Book("Harry Potter", "J.K Rowling", "Bloomsbury", 1997);
    Book book1 = new Book("Alice in Wonderland", "Lewis Carroll", "Macmillan", 1865);
    Book book2 = new Book("Lord of the Rings", "J.R.R Tolkien", "Allen & Unwin", 1954);
    Date date = new Date(2021, 01, 16);
    Loan loan = new Loan(date, date, date); 
    Loan loan1 = new Loan(date, date, date); 
    Loan loan2 = new Loan(date, date, date); 
    loan.setBook(book);
    loan1.setBook(book1);
    loan2.setBook(book2);
          //  System.out.println(loan.getCheckoutDate());
    
    em.getTransaction().begin();
    em.persist(book);
    em.persist(book1);
    em.persist(book2);
    em.getTransaction().commit();
    
    
    }  
}
