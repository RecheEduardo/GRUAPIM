package br.ifsp.contacts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ContactPatchDTO(
        String nome,

        @Size(min = 8, max = 15, message = "O telefone deve ter entre 8 e 15 caracteres")
        @Pattern(regexp = "\\d+", message = "O telefone deve conter apenas numeros")
        String telefone,

        @Email(message = "O email deve ter um formato valido")
        String email
) {
}
