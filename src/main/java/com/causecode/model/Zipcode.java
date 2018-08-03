package com.causecode.model;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;

/**
 * Zipcode is model class for mapping zipcode table with zipcode object
 * 
 * @author Ankur Pande
 *
 */
@Entity
@Table(name="ZIPCODE")
public class Zipcode implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;
	
	@JsonManagedReference
	@OneToMany(mappedBy="zipcode")
	private Set<Store> stores = new HashSet<Store>(0);

	@Id
	@Column(name="ZIPCODE_ID" )
	private Integer zipcode_id;
	
	@Column(name="LATITUDE")
	private BigDecimal latitude;
	
	@Column(name="LONGITUDE")
	private BigDecimal longitude;
	
	@Column(name="COUNTRY")
	private String country;
	

	@Column(name="STATE")
	private String state;


	public Integer getZipcode_id() {
		return zipcode_id;
	}

	public void setZipcode_id(Integer zipcode_id) {
		this.zipcode_id = zipcode_id;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	public Set<Store> getStores() {
		return stores;
	}

	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}

}
