
package facades;

import dtos.BookDTO;
import dtos.BooksDTO;
import entities.Book;
import errorhandling.NotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

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
           public BookDTO addBook(BookDTO b) {
            EntityManager em = emf.createEntityManager();
            Book book = new Book(b.getTitle(),b.getAuthor(),b.getPublisher(),b.getPublishYear());
            
            try {
            
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
            } finally {
                em.close();
            }
            return new BookDTO(book);
        }
//        public BookDTO getBookById(Long id) throws NotFoundException {
//            EntityManager em = emf.createEntityManager();
//            try {
//                Book book = em.find(Book.class, id);
//                if (book == null) {
//                    throw new NotFoundException(String.format("Book with id: (%d) not found.", id));
//                } else {
//                    return new BookDTO(book);
//                }
//            } finally {
//                em.close();
//            }
//        }
        public BookDTO getBookByTitle(String title){
            EntityManager em = emf.createEntityManager();
            TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :title", Book.class);
            query.setParameter("title", "%"+title+"%");
            Book book = query.getSingleResult();
            
            
            return new  BookDTO(book);
        }
        
        public BookDTO deleteBook(Long id) {
            EntityManager em = emf.createEntityManager();
            Book book = em.find(Book.class, id);
            try {
                em.getTransaction().begin();
                em.remove(book);
                em.getTransaction().commit();
            } finally {
                em.close();
            }
            return new BookDTO(book);
        }
}