package ro.sda.bookingaccommodation.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.Booking;
import ro.sda.bookingaccommodation.core.service.BookingService;
import ro.sda.bookingaccomodation.commons.email.EmailService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/booking")
public class BookingRestService {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private EmailService emailService;

    @Path("/find-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Booking>findAll(){
        return bookingService.findAll();
    }

    @Path("find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Booking findById(@PathParam("id") Long id){
        return bookingService.findById(id);
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void deleteBooking(@QueryParam("bookingId") long id){
        bookingService.deleteBooking(id);
    }

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Booking create(Booking booking){
        Booking bookingDone = bookingService.createBooking(booking);
        emailService.sendEmail("danieldatabase79@gmail.com", "booking confirmation", "Booking details");

        return bookingDone;
    }



}
