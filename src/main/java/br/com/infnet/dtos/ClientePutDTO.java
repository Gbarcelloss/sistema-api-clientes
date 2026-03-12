package br.com.infnet.dtos;


import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ClientePutDTO {

    @Min(value = 1, message = "Por favor, informe o id do cliente.")
    private Integer idCliente;

    @Size(min = 8, max = 150, message = "Por favor, informe um nome de 8 a 150 caracteres.")
    @NotBlank(message = "Por favor, informe o nome do cliente.")
    private String nome;

    @Pattern(regexp = "^[0-9]{11}$", message = "Por favor, informe um cpf com exatamente 11 números.")
    @NotBlank(message = "Por favor, informe o cpf do cliente.")
    private String cpf;

    @Email(message = "Por favor, informe um endereço de email válido.")
    @NotBlank(message = "Por favor, informe o email do cliente.")
    private String email;


}
