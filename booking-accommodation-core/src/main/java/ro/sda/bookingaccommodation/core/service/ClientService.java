package ro.sda.bookingaccommodation.core.service;

import ro.sda.bookingaccommodation.core.entity.Client;

import java.util.List;

public interface ClientService {

    Client createClient(Client client);

    Client readClient(Long clientId);

    Client updateClient(Client client);

    void deleteClient(Long clientId);

    List<Client> findAll();
    Client findById(Long id);

}
