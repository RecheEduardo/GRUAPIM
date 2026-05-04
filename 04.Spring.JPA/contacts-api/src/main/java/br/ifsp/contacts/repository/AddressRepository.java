package br.ifsp.contacts.repository;

import br.ifsp.contacts.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Page<Address> findByContactId(Long contactId, Pageable pageable);
}
