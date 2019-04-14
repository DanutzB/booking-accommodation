package ro.sda.bookingaccommodation.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.Property;
import ro.sda.bookingaccommodation.core.service.PropertyService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/property")
public class PropertyRestService {
    @Autowired
    private PropertyService propertyService;

    @Path("/find-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Property>findAll(){
        return propertyService.findAll();
    }

    @Path("find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Property findById(@PathParam("id") Long id){
        return propertyService.findById(id);
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void deleteHost(@QueryParam("propertyId") long id){
        propertyService.deleteProperty(id);
    }

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Property create(Property property){
        return propertyService.createProperty(property);
    }


}
