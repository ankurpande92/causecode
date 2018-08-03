package com.causecode.model;

import java.io.Serializable;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

/**
 * Store is model class for mapping Store table with Store object
 * 
 * @author Ankur Pande
 *
 */
@Entity
@Table(name="STORE")
public class Store implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;
	@Id
	@Column(name="STORE_ID")
	private Integer storeId;
	
	@Column(name="LATITUDE")
	private BigDecimal latitude;
	
	@Column(name="LONGITUDE")
	private BigDecimal longitude;
	
	@Column(name="STORE_NAME")
	private String storeName;
	
	@Column(name="STORE_ADDRESS")
	private String storeAddress;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="ZIPCODE_ID")
	private Zipcode zipcode;

	public Zipcode getZipcode() {
		return zipcode;
	}


	public void setZipcode(Zipcode zipcode) {
		this.zipcode = zipcode;
	}


	public Integer getStoreId() {
		return storeId;
	}


	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
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


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public String getStoreAddress() {
		return storeAddress;
	}


	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	
	

}
