package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.demo.DTO.*;

@Entity

@Data
@NoArgsConstructor
public class AddressBookEntity {
	@Id
	private int sno;
	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private String country;

	public AddressBookEntity(int sno, AddressBookDTO addressbookdto) {
		super();
		this.sno = sno;
		this.firstname = addressbookdto.getFirstname();
		this.lastname = addressbookdto.getLastname();
		this.address = addressbookdto.getAddress();
		this.city = addressbookdto.getCity();
		this.country=addressbookdto.getCountry();
	}

	

}
