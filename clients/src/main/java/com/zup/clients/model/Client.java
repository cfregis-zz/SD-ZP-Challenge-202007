package com.zup.clients.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "client")
@DynamicUpdate
@SequenceGenerator(initialValue = 1, name = "clientGen", sequenceName = "clientGen", allocationSize = 1)
public class Client implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -2509666391404726965L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientGen")
	private Integer id;

	@NotNull
	@Size(max = 254)
	@Column(name = "name", nullable = false, length = 254)
	private String name;

	@NotNull
	@ApiModelProperty(required = true,example = "2020-01-01")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateBirthday;

	@NotNull
	@Size(max = 254)
	@Column(name = "mail",  nullable = false, length = 254)
	private String mail;

	@NotNull
	@Size(max = 15)
	@Column(name = "cpf",  nullable = false, length = 15)
	private String cpf;

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LocalDate getDateBirthday() {
		return dateBirthday;
	}

	public void setDateBirthday(LocalDate dateBirthday) {
		this.dateBirthday = dateBirthday;
	}
}
