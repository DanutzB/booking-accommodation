package ro.sda.bookingaccommodation.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.Availability;
import ro.sda.bookingaccommodation.core.service.AvailabilityService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Path("/availability")
public class AvailabilityRestService {

    @Autowired
    private AvailabilityService availabilityService;

    @Path("/find-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Availability>findAll(){
        return availabilityService.findAll();
    }

    @Path("/find")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Availability>findByFromDateLessThanEqualAndToDateGreaterThanEqual(@QueryParam("fromDate") String fromDate, @QueryParam("toDate") String toDate) throws ParseException {
        Date from = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
        Date to = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
        return availabilityService.findByFromDateLessThanEqualAndToDateGreaterThanEqual(from, to);
    }

    @Path("find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Availability findById(@PathParam("id") Long id){
        return availabilityService.findById(id);
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void deleteAvailability(@QueryParam("availabilityId") long id){
        availabilityService.deleteAvailability(id);
    }

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Availability create(Availability availability){
        return availabilityService.createAvailability(availability);
    }


}
