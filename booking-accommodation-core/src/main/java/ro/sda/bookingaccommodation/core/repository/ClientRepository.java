package ro.sda.bookingaccommodation.core.repository;

import ro.sda.bookingaccommodation.core.base.EntityRepository;
import ro.sda.bookingaccommodation.core.entity.Client;

import java.util.List;

public interface ClientRepository extends EntityRepository<Client> {

    public Client findByName(String name);
}
