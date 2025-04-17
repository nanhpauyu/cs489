package org.example.dentalservice.repository;

import org.example.dentalservice.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AddressRespository extends JpaRepository<Address, Integer> {
    @Query("SELECT a, p FROM Address a LEFT JOIN Patient p ON p.address.id = a.id ORDER BY a.city ASC")
    public List<Object[]> findAllAddressesWithPatients();


}
