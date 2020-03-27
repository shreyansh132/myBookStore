package com.shreyansh.bookStore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Id;

@Entity
@DynamicUpdate
@Table(name = "address")
public class CustomerAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id", nullable = false)
	private Integer addressId;
	
	@Column(name = "customer_id", nullable = false)
	private String customerID;
	
	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "address2", nullable = false)
	private String address2;

	@Column(name = "district", nullable = false)
	private String district;

	@Column(name = "phone", nullable = false)
	private String phone;

	@Column(name = "location", nullable = false)
	private String location;

	@Column(name = "postal_code", nullable = false)
	private String postal_code;

	public CustomerAddress() {
	}
	
	public CustomerAddress(Integer addressId, String customerID, String address, String address2, String district,
			String phone, String location, String postal_code) {
		super();
		this.addressId = addressId;
		this.customerID = customerID;
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.phone = phone;
		this.location = location;
		this.postal_code = postal_code;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	@Override
	public String toString() {
		return "CustomerAddress [addressId=" + addressId + ", customerID=" + customerID + ", address=" + address
				+ ", address2=" + address2 + ", district=" + district + ", phone=" + phone + ", location=" + location
				+ ", postal_code=" + postal_code + "]";
	}
}
