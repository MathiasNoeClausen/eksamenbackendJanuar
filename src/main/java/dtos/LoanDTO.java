package dtos;

import entities.Book;
import entities.Loan;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class LoanDTO {
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date checkoutDate;
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @Temporal(TemporalType.DATE)
    private Date returnedDate;

    public LoanDTO() {
    }
    
    public LoanDTO(Loan loan) {
        this.checkoutDate = loan.getCheckoutDate();
        this.dueDate = loan.getDueDate();
        this.returnedDate = loan.getReturnedDate();
    }

    public LoanDTO(Date checkoutDate, Date dueDate, Date returnedDate) {
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.returnedDate = returnedDate;
    }

    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }
    
              public List<LoanDTO>toDTO(List<Loan>loans){
        List<LoanDTO>dtoes = new ArrayList();
            for(Loan l: loans){
                dtoes.add(new LoanDTO(l));
            }
            return dtoes;
    }
    
}
