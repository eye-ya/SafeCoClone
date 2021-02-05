package com.safeco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	private Long id;
	private String first;
	private String middle;
	private String last;

	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String residence;
	private String phone;
	private String email;
	private String make;
	private String model;
	private int year;
	private String usages;
	private int accidents;
	private int experience;
	private boolean dui;
	private String quote;

	public Customer(Long id, String first, String middle, String last, String street, String city, String state,
			String zipcode, String residence, String phone, String email, String make, String model, int year,
			String usages, int accidents, int experience, boolean dui, String quote) {
		super();
		this.id = id;
		this.first = first;
		this.middle = middle;
		this.last = last;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.residence = residence;
		this.phone = phone;
		this.email = email;
		this.make = make;
		this.model = model;
		this.year = year;
		this.usages = usages;
		this.accidents = accidents;
		this.experience = experience;
		this.dui = dui;
		this.quote = quote;
	}

	public Customer() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getUsages() {
		return usages;
	}

	public void setUsages(String usages) {
		this.usages = usages;
	}

	public int getAccidents() {
		return accidents;
	}

	public void setAccidents(int accidents) {
		this.accidents = accidents;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public boolean isDui() {
		return dui;
	}

	public void setDui(boolean dui) {
		this.dui = dui;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

}
