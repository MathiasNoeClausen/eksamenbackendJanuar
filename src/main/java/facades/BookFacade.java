
package facades;

import dtos.BookDTO;
import dtos.BooksDTO;
import entities.Book;
import errorhandling.NotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class BookFacade {
    
    private static EntityManagerFactory emf;
    private static BookFacade instance; 
    
    private BookFacade() {
        
    }
    
    
        public static BookFacade getBookFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BookFacade();
        }
        return instance;
    }
        
        public long getBookCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long bookCount = (long)em.createQuery("SELECT COUNT(b) FROM Book b").getSingleResult();
            return bookCount;
        }finally{  
            em.close();
        }
        
    }
        public BooksDTO getAllBooks() {
        EntityManager em = emf.createEntityManager();
        try {
            return new BooksDTO(em.createNamedQuery("Book.getAll").getResultList());
        } finally {
            em.close();
        }

    
}
        public BookDTO getBookById(Long id) throws NotFoundException {
            EntityManager em = emf.createEntityManager();
            try {
                Book book = em.find(Book.class, id);
                if (book == null) {
                    throw new NotFoundException(String.format("Book with id: (%d) not found.", id));
                } else {
                    return new BookDTO(book);
                }
            } finally {
                em.close();
            }
        }
}