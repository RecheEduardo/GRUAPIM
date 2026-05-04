package br.ifsp.contacts.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public record ContactRequestDTO(
        @NotBlank(message = "O nome nao pode estar vazio")
        String nome,

        @NotBlank(message = "O telefone nao pode estar vazio")
        @Size(min = 8, max = 15, message = "O telefone deve ter entre 8 e 15 caracteres")
        @Pattern(regexp = "\\d+", message = "O telefone deve conter apenas numeros")
        String telefone,

        @NotBlank(message = "O email nao pode estar vazio")
        @Email(message = "O email deve ter um formato valido")
        String email,

        @NotEmpty(message = "O contato deve ter pelo menos um endereco")
        List<@Valid AddressRequestDTO> addresses
) {
}
