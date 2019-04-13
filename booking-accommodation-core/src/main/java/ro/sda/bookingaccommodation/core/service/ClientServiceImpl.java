package ro.sda.bookingaccommodation.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.Client;
import ro.sda.bookingaccommodation.core.repository.ClientRepository;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client readClient(Long clientId) {
        return clientRepository.findById(clientId);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public void deleteClient(Long clientId) {
        clientRepository.delete(clientId);
    }

    @Override
    public List<Client>findAll(){
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id);
    }
}
