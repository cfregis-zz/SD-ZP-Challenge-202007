package com.zup.clients.controller;

import com.zup.clients.model.Client;
import com.zup.clients.service.ClientService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/client")
@Api( value="online clients", description="Operations pertaining to clients in Online Store", consumes = "Clientes")
public class ClientController {

	@Autowired
    private ClientService clientService;

    @ApiOperation(value = "View a list of available clients",response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
	public Iterable<Client> list() {
        Iterable<Client> clientList = clientService.listAllClients();
        System.out.println("ClientController::list():List Size:"+clientList.toString());
        return clientList;
	}

    @ApiOperation(value = "Search a client with an ID",response = Client.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
	public Client getById(@PathVariable Integer id) {
    	Client client = this.clientService.getClientById(id);
        return client;
	}
	
	@ApiOperation(value = "Add a client")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public Client add(@RequestBody Client domainObject) {
		System.out.println(domainObject.toString());
		return clientService.saveClient(domainObject);
	}

    @ApiOperation(value = "Update a client")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
	public Client update(@RequestBody Client client) {
    	return this.clientService.saveClient(client);
	}

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @ApiOperation(value = "Delete a client")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity delete(@PathVariable Integer id) {
    	clientService.deleteClient(id);
        return new ResponseEntity(HttpStatus.OK);
	}

}
