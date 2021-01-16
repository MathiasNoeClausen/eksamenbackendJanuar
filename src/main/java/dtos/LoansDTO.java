package dtos;


import entities.Loan;
import java.util.ArrayList;
import java.util.List;

public class LoansDTO {
   
     
          List<LoanDTO> all = new ArrayList();

    public LoansDTO(List<Loan> loanEntities) {
        loanEntities.forEach((b) -> {
            all.add(new LoanDTO(b));
        });
    }

    public LoansDTO() {
    }

    public List<LoanDTO> getAll() {
        return all;
    }

    public void setAll(List<LoanDTO> all) {
        this.all = all;
    }
}

