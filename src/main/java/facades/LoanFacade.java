package facades;

import dtos.BooksDTO;
import dtos.LoansDTO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class LoanFacade {
    private static EntityManagerFactory emf;
    private static LoanFacade instance; 
    
    private LoanFacade() {
        
    }
    
    
        public static LoanFacade getLoanFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new LoanFacade();
        }
        return instance;
    }
        
        
        public long getLoanCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long loanCount = (long)em.createQuery("SELECT COUNT(l) FROM Loan l").getSingleResult();
            return loanCount;
        }finally{  
            em.close();
        }
        
    }
        public LoansDTO getAllLoans() {
        EntityManager em = emf.createEntityManager();
        try {
            return new LoansDTO(em.createNamedQuery("Loan.getAll").getResultList());
        } finally {
            em.close();
        }

    
}
}
