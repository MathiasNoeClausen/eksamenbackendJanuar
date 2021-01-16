
package dtos;

import entities.Book;
import java.util.ArrayList;
import java.util.List;

public class BookDTO {
    
    
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private int publishYear;

    public BookDTO() {
    }
    
    
    public BookDTO(Book book) {
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.publisher = book.getPublisher();
        this.publishYear = book.getPublishYear();
    }

    public BookDTO(String title, String author, String publisher, int publishYear) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
    }
    
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
    
          public List<BookDTO>toDTO(List<Book>books){
        List<BookDTO>dtoes = new ArrayList();
            for(Book b: books){
                dtoes.add(new BookDTO(b));
            }
            return dtoes;
    }
    
    
}
