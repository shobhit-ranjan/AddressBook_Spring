package com.example.demo.DTO;




import lombok.Data;
@Data
public class AddressBookDTO {

	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private String state;
	private String country;

	

	public AddressBookDTO(String firstname, String lastname, String address, String city, String state, String country) {
		super();
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
	}



	
	

	

}
