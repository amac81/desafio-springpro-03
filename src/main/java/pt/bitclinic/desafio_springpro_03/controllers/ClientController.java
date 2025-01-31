package pt.bitclinic.desafio_springpro_03.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import jakarta.validation.Valid;
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
	public ResponseEntity<Page<ClientDTO>> getAll(Pageable pageable) {
		Page<ClientDTO> page = service.findAll(pageable); 
		
		return ResponseEntity.ok(page);
	}
	
	@PostMapping
	public ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientDTO dto) {
		dto = service.insert(dto); 
		
		//to generate the correct HTTP response code 201 - Created
		//good programming practice Post 
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(dto.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> updateById(@PathVariable Long id, @Valid @RequestBody ClientDTO dto) {
		dto = service.update(id, dto); 
		
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
