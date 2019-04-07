package ro.sda.bookingaccommodation.core.repository;

import ro.sda.bookingaccommodation.core.base.EntityRepository;
import ro.sda.bookingaccommodation.core.entity.Client;

public interface ClientRepository extends EntityRepository<Client> {

    public Client findByName(String name);


}
