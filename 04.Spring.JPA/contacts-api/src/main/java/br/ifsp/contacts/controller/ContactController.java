package br.ifsp.contacts.controller;

import br.ifsp.contacts.dto.ContactMapper;
import br.ifsp.contacts.dto.ContactPatchDTO;
import br.ifsp.contacts.dto.ContactRequestDTO;
import br.ifsp.contacts.dto.ContactResponseDTO;
import br.ifsp.contacts.exception.ResourceNotFoundException;
import br.ifsp.contacts.model.Contact;
import br.ifsp.contacts.repository.ContactRepository;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping
    public Page<ContactResponseDTO> getAllContacts(@ParameterObject Pageable pageable) {
        return contactRepository.findAll(pageable).map(ContactMapper::toResponse);
    }

    @GetMapping("/{id}")
    public ContactResponseDTO getContactById(@PathVariable Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato nao encontrado: " + id));
        return ContactMapper.toResponse(contact);
    }

    @PostMapping
    public ContactResponseDTO createContact(@Valid @RequestBody ContactRequestDTO dto) {
        Contact savedContact = contactRepository.save(ContactMapper.toEntity(dto));
        return ContactMapper.toResponse(savedContact);
    }

    @PutMapping("/{id}")
    public ContactResponseDTO updateContact(@PathVariable Long id, @Valid @RequestBody ContactRequestDTO dto) {
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato nao encontrado: " + id));

        existingContact.setNome(dto.nome());
        existingContact.setTelefone(dto.telefone());
        existingContact.setEmail(dto.email());
        existingContact.setAddresses(dto.addresses().stream().map(ContactMapper::toEntity).toList());

        return ContactMapper.toResponse(contactRepository.save(existingContact));
    }

    @PatchMapping("/{id}")
    public ContactResponseDTO updateContactFields(@PathVariable Long id, @Valid @RequestBody ContactPatchDTO dto) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato nao encontrado: " + id));

        if (dto.nome() != null) {
            contact.setNome(dto.nome());
        }
        if (dto.telefone() != null) {
            contact.setTelefone(dto.telefone());
        }
        if (dto.email() != null) {
            contact.setEmail(dto.email());
        }

        return ContactMapper.toResponse(contactRepository.save(contact));
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        if (!contactRepository.existsById(id)) {
            throw new ResourceNotFoundException("Contato nao encontrado: " + id);
        }
        contactRepository.deleteById(id);
    }

    @GetMapping("/search")
    public Page<ContactResponseDTO> getContactsByName(
            @RequestParam("name") String contactName,
            @ParameterObject Pageable pageable
    ) {
        return contactRepository.findByNomeContainingIgnoreCase(contactName, pageable)
                .map(ContactMapper::toResponse);
    }
}
