package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.AddressBookDTO;
import com.example.demo.Entity.AddressBookEntity;
import com.example.demo.Repo.AddressBookRepo;

@Service
public class AddressBookService {
	@Autowired

	AddressBookRepo addrepo;
	private List<AddressBookEntity> addressbooklist = new ArrayList<>();

	public List<AddressBookEntity> getall() {
		return addrepo.findAll();
	}

	public AddressBookEntity get(int sno) {
		return addrepo.getById(sno);

	}

	public List<AddressBookEntity> delete(int sno) {
		addrepo.deleteById(sno);
		return addrepo.findAll();
	}

	public AddressBookEntity add(AddressBookDTO addressDTO) {
		AddressBookEntity address = new AddressBookEntity(addressbooklist.size() + 1, addressDTO);
		addrepo.save(address);
		return address;
	}

}
