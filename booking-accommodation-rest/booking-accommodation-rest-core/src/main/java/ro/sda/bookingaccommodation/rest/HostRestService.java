package ro.sda.bookingaccommodation.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import ro.sda.bookingaccommodation.core.entity.Host;
import ro.sda.bookingaccommodation.core.service.HostService;

@Service
@Path("/host")
public class HostRestService {

    @Autowired
    private HostService hostService;

    @Path("/find-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Host>findAll(){
        return hostService.findAll();
    }

    @Path("find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Host findById(@PathParam("id") Long id){
        return hostService.findById(id);
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void deleteHost(@QueryParam("hostId") long id){
        hostService.deleteHost(id);
    }

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Host create(Host host){
        return hostService.createHost(host);
    }


}
