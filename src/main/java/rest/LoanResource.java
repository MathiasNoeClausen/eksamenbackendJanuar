package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.BooksDTO;
import dtos.LoansDTO;

import facades.LoanFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

@Path("loan")
public class LoanResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final LoanFacade FACADE = LoanFacade.getLoanFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    @GET
    @Path("count")
    @Produces({MediaType.APPLICATION_JSON})
    public String getLoanCount() {
        long count = FACADE.getLoanCount();
        return "{\"count\":" + count + "}";
    }

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllLoans() {
        LoansDTO loans = FACADE.getAllLoans();
        return GSON.toJson(loans);
    }

}
