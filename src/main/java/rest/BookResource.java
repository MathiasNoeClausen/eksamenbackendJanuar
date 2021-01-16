
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.BookDTO;
import dtos.BooksDTO;
import errorhandling.NotFoundException;
import facades.BookFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;


@Path("book")
public class BookResource {
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final BookFacade FACADE =  BookFacade.getBookFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();



    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }


    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getBookCount() {
        long count = FACADE.getBookCount();
        //System.out.println("--------------->"+count);
        return "{\"count\":"+count+"}";  //Done manually so no need for a DTO
    }

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllBooks() {
        BooksDTO books = FACADE.getAllBooks();
        return GSON.toJson(books);
    }
    
//    @GET
//    @Path("{id}")
//    @Produces({MediaType.APPLICATION_JSON})
//        public String getBookById(@PathParam("id") Long id) throws NotFoundException {
//        return GSON.toJson(FACADE.getBookById(id));
//    }
        
    @GET
    @Path("{title}")
    @Produces({MediaType.APPLICATION_JSON})
        public String getBookByTitle(@PathParam("title") String title){
        
        return GSON.toJson(FACADE.getBookByTitle(title));
    }
       // 
   @POST   
   @Produces({MediaType.APPLICATION_JSON})
   @Consumes({MediaType.APPLICATION_JSON})
   public String addBook(BookDTO b) {
       BookDTO book = FACADE.addBook(b);
       return GSON.toJson(book);
   }
   @DELETE
   @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String deletePerson(@PathParam("id") long id){
        BookDTO pDeleted = FACADE.deleteBook(id);
        return GSON.toJson(pDeleted);
    }
}
