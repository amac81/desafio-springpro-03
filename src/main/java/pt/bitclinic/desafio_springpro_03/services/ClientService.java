package pt.bitclinic.desafio_springpro_03.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pt.bitclinic.desafio_springpro_03.dto.ClientDTO;
import pt.bitclinic.desafio_springpro_03.entities.Client;
import pt.bitclinic.desafio_springpro_03.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {

		Optional<Client> result = repository.findById(id);
		Client product = result.get();
		ClientDTO dto = new ClientDTO(product);

		return dto;
	}
	
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		
		List<Client> result = repository.findAll();
		
		//with lambda expression
		return result.stream().map(x -> new ClientDTO(x)).toList();
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		
		Client entity = new Client(); 
		copyDtoToEntity(dto, entity);
		
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		
		return new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
	
		//does not go to the database; object monitored by JPA
		Client entity = repository.getReferenceById(id); 
		
		copyDtoToEntity(dto, entity);		
		entity = repository.save(entity);
		
		return new ClientDTO(entity);
	
	}
	
	
	public void deleteById(Long id) {		
		repository.deleteById(id);			
	}
	
	private void copyDtoToEntity(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());				
	}

	
	

}