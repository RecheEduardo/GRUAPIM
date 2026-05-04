package br.ifsp.contacts.dto;

import java.util.List;

public record ContactResponseDTO(
        Long id,
        String nome,
        String telefone,
        String email,
        List<AddressResponseDTO> addresses
) {
}
