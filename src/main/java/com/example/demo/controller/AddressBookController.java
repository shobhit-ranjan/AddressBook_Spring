package com.example.demo.controller;

import com.example.demo.DTO.ResponceDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.AddressBookDTO;
import com.example.demo.Entity.AddressBookEntity;
import com.example.demo.Service.AddressBookService;
import com.example.demo.DTO.ResponceDTO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/address")
@Slf4j
public class AddressBookController {

	@Autowired
	AddressBookService addressbookservice;

	/**
	 * we will get the address of the person who is id is matched; as an sno; the
	 * response will be returned as responce dto
	 * 
	 */

	/**
	 * 
	 * @param sno
	 * @return ResponseEntity
	 */

	@GetMapping("/{sno}")
	public ResponseEntity<ResponceDTO> getAddress(@PathVariable int sno) {
		AddressBookEntity address = addressbookservice.get(sno);
		ResponceDTO responcedto = new ResponceDTO("Your Info IS", address);
		return new ResponseEntity<ResponceDTO>(responcedto, HttpStatus.OK);
	}

	/**
	 * we will get the complete list of address we have and that saved and returned
	 * responce dto
	 */

	/**
	 * 
	 * @return ResponseEntity
	 */
	@GetMapping("/")
	public ResponseEntity<ResponceDTO> getAllAddress() {
		List<AddressBookEntity> addresslist = addressbookservice.getall();
		ResponceDTO responcedto = new ResponceDTO("Your Info IS", addresslist);
		log.info("Its Up And Running");
		return new ResponseEntity<ResponceDTO>(responcedto, HttpStatus.OK);
	}

	/**
	 * we take the id ie sno from the user and detete it the remaing list will be
	 * show will the deleted message
	 */
	/**
	 * 
	 * @param sno
	 * @return ResponseEntity
	 */
	@DeleteMapping("/del/{sno}")
	public ResponseEntity<ResponceDTO> delete(@PathVariable int sno) {
		ResponceDTO respondto = new ResponceDTO("DELETED!", addressbookservice.delete(sno));
		return new ResponseEntity<ResponceDTO>(respondto, HttpStatus.OK);

	}

	/**
	 * Will show complete List of Employee DATA will be added in body in json format
	 * and will be saved in the list
	 */
	/**
	 * 
	 * @param addressdto
	 * @return ResponseEntity
	 */
	@PostMapping("/addaddress")
	public ResponseEntity<ResponceDTO> post(@RequestBody AddressBookDTO addressdto) {
		ResponceDTO respondto = new ResponceDTO("Added Your Info", addressbookservice.add(addressdto));
		return new ResponseEntity<ResponceDTO>(respondto, HttpStatus.OK);
	}

}
