package br.ifsp.contacts.repository;

import br.ifsp.contacts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByNomeContainingIgnoreCase(String nome);
}