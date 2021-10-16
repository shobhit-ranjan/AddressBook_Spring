package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;
import com.example.demo.Entity.*;

@Component
public interface AddressBookRepo extends JpaRepository<AddressBookEntity, Integer> {

}
