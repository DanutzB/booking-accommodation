package ro.sda.bookingaccommodation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.Client;
import ro.sda.bookingaccommodation.core.service.ClientService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/client")
public class ClientRestService {

    @Autowired
    private ClientService clientService;

    @Path("/find-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> findAll(){
        return clientService.findAll();
    }


    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Client findById(@PathParam("id") long id){
        return clientService.findById(id);
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void deleteClient(@QueryParam("clientId") long id){
        clientService.deleteClient(id);
    }

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Client create(Client client){
        return clientService.createClient(client);
    }



}
