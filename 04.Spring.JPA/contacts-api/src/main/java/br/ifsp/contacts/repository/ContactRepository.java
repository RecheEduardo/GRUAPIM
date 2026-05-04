package br.ifsp.contacts.repository;

import br.ifsp.contacts.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByNomeContainingIgnoreCase(String nome);
    Page<Contact> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}