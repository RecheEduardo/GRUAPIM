package br.ifsp.contacts.controller;

import br.ifsp.contacts.dto.AddressRequestDTO;
import br.ifsp.contacts.dto.AddressResponseDTO;
import br.ifsp.contacts.dto.ContactMapper;
import br.ifsp.contacts.exception.ResourceNotFoundException;
import br.ifsp.contacts.model.Address;
import br.ifsp.contacts.model.Contact;
import br.ifsp.contacts.repository.AddressRepository;
import br.ifsp.contacts.repository.ContactRepository;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;

    public AddressController(ContactRepository contactRepository, AddressRepository addressRepository) {
        this.contactRepository = contactRepository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("/contacts/{contactId}")
    public Page<AddressResponseDTO> getAddressesByContact(
            @PathVariable Long contactId,
            @ParameterObject Pageable pageable
    ) {
        if (!contactRepository.existsById(contactId)) {
            throw new ResourceNotFoundException("Contato nao encontrado: " + contactId);
        }
        return addressRepository.findByContactId(contactId, pageable).map(ContactMapper::toResponse);
    }

    @PostMapping("/contacts/{contactId}")
    public AddressResponseDTO createAddress(
            @PathVariable Long contactId,
            @Valid @RequestBody AddressRequestDTO dto
    ) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contato nao encontrado: " + contactId));

        Address address = ContactMapper.toEntity(dto);
        address.setContact(contact);
        return ContactMapper.toResponse(addressRepository.save(address));
    }
}
