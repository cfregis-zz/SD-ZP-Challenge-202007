package com.zup.clients.service;

import com.zup.clients.model.Client;
import com.zup.clients.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class ClientService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ClientRepository clientRepository;

	public Iterable<Client> listAllClients() {
        logger.debug("ClientService::listAllClients called");
        Iterable<Client> clients = clientRepository.findAll();
        return clients;
	}

	public Client getClientById(Integer id) {
        logger.debug("ClientService::getClientById called");
        Optional<Client> client = clientRepository.findById(id);
        if(client.isPresent()) {
        	Client c = client.get();
        	return c;
        } else {
        	return null;
        }
		
	}

	public Client saveClient(Client client) {
        logger.debug("ClientService::saveClient called");

        return clientRepository.save(client);
	}

	public void deleteClient(Integer id) {
        logger.debug("ClientService::deleteClient called");        
        clientRepository.deleteById(id);
	}
}
