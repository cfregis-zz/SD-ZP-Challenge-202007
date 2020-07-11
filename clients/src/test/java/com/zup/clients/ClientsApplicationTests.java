package com.zup.clients;

import com.zup.clients.model.Address;
import com.zup.clients.model.Client;
import com.zup.clients.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientsApplicationTests {
	@Autowired
	ClientService clientService;

	@Test
	void contextLoads() {
		Client client = new Client();
		client.setCpf("07681063463");
		client.setName("Carlos Filipe");
		client.setMail("filipe.regis@hotmail.com");
		client.setDateBirthday(LocalDate.of(1991,9,22));

		Address address = new Address();
		address.setCity("recife");
		address.setPostalCode("50860015");
		address.setProvince("PE");
		address.setStreet("av tapajos");
		client.setAddress(address);
		Client persistedClient = clientService.saveClient(client);
		assertNotNull(persistedClient);

		persistedClient.setName("Carlos Filipe da Cruz Régis");

		Client updatedClient = clientService.saveClient(persistedClient);
		assertEquals(updatedClient.getName(), "Carlos Filipe da Cruz Régis");

		clientService.deleteClient(updatedClient.getId());

		assertNull(clientService.getClientById(updatedClient.getId()));

	}

}
