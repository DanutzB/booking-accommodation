package ro.sda.bookingaccommodation.core.service;

import ro.sda.bookingaccommodation.core.entity.Client;

public interface ClientService {

    Client createClient(Client client);

    Client readClient(Long clientId);

    Client updateClient(Client client);

    void deleteClient(Client client);
}
