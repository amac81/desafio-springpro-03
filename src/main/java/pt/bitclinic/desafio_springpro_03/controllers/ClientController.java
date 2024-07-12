package pt.bitclinic.desafio_springpro_03.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pt.bitclinic.desafio_springpro_03.dto.ClientDTO;
import pt.bitclinic.desafio_springpro_03.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> getById(@PathVariable Long id) {
		ClientDTO dto = service.findById(id); 
		
		return ResponseEntity.ok(dto);
	}

	@GetMapping
	public List<ClientDTO> getAll() {
		return service.findAll();
	}
	
	@PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto) {
		dto = service.insert(dto); 
		
		//to generate the correct HTTP response code 201 - Created
		//good programming practicePost 
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(dto.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> updateById(@PathVariable Long id, @RequestBody ClientDTO dto) {
		dto = service.update(id, dto); 
		
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
