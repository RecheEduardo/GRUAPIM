package br.ifsp.contacts.dto;

import br.ifsp.contacts.model.Address;
import br.ifsp.contacts.model.Contact;

import java.util.List;

public final class ContactMapper {

    private ContactMapper() {
    }

    public static Contact toEntity(ContactRequestDTO dto) {
        Contact contact = new Contact();
        contact.setNome(dto.nome());
        contact.setTelefone(dto.telefone());
        contact.setEmail(dto.email());

        List<Address> addresses = dto.addresses().stream()
                .map(ContactMapper::toEntity)
                .toList();
        contact.setAddresses(addresses);

        return contact;
    }

    public static Address toEntity(AddressRequestDTO dto) {
        return new Address(dto.rua(), dto.cidade(), dto.estado(), dto.cep());
    }

    public static ContactResponseDTO toResponse(Contact contact) {
        List<AddressResponseDTO> addresses = contact.getAddresses().stream()
                .map(ContactMapper::toResponse)
                .toList();

        return new ContactResponseDTO(
                contact.getId(),
                contact.getNome(),
                contact.getTelefone(),
                contact.getEmail(),
                addresses
        );
    }

    public static AddressResponseDTO toResponse(Address address) {
        return new AddressResponseDTO(
                address.getId(),
                address.getRua(),
                address.getCidade(),
                address.getEstado(),
                address.getCep()
        );
    }
}
