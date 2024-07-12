package pt.bitclinic.desafio_springpro_03.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import pt.bitclinic.desafio_springpro_03.entities.Client;

public class ClientDTO {

	@JsonIgnore	
	private Long id;
	@NotBlank(message = "Campo necessário")
	private String name;
	private String cpf;
	@Min(value = 0L,message = "Income tem de ser um valor positivo >= 0.0")
	private Double income;
	@PastOrPresent(message = "Data inválida, deve ser uma data no passado ou no presente")
	private LocalDate birthDate;
	
	@Min(value = 0L, message ="Children tem de ser um valor positivo >= 0")
	private Integer children;
	
	public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}

	public ClientDTO(Client entity) {
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		income = entity.getIncome();
		birthDate = entity.getBirthDate();
		children = entity.getChildren();
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public Double getIncome() {
		return income;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Integer getChildren() {
		return children;
	}

}
