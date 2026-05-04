package br.ifsp.contacts.dto;

public record AddressResponseDTO(
        Long id,
        String rua,
        String cidade,
        String estado,
        String cep
) {
}
