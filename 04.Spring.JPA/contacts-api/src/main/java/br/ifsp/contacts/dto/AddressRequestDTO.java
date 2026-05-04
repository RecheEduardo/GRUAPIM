package br.ifsp.contacts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AddressRequestDTO(
        @NotBlank(message = "A rua nao pode estar vazia")
        String rua,

        @NotBlank(message = "A cidade nao pode estar vazia")
        String cidade,

        @NotBlank(message = "O estado nao pode estar vazio")
        @Size(min = 2, max = 2, message = "O estado deve ter exatamente 2 caracteres")
        @Pattern(regexp = "[A-Z]{2}", message = "O estado deve ser uma sigla com duas letras maiusculas")
        String estado,

        @NotBlank(message = "O CEP nao pode estar vazio")
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 99999-999")
        String cep
) {
}
