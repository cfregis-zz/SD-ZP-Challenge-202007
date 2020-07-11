package com.zup.clients.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name = "address")
@DynamicUpdate
@SequenceGenerator(initialValue = 1, name = "addressGen", sequenceName = "addressGen", allocationSize = 1)
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5153845897997686333L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressGen")
	private Integer id;

	@NotNull
	@Size(max = 254)
	@Column(name = "street", nullable = false, length = 254)
	private String street;
	
	@NotNull
	@Size(max = 254)
	@Column(name = "city", nullable = false, length = 254)
	private String city;
	
	@NotNull
	@Size(max = 2)
	@Column(name = "province", nullable = false, length = 2)
	private String province;
	
	@NotNull
	@Column(name="postalCode", nullable = false)
	private String postalCode;


	@JsonIgnore
	@OneToOne(mappedBy = "address")
	private Client client;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
