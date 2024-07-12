package pt.bitclinic.desafio_springpro_03.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.bitclinic.desafio_springpro_03.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
