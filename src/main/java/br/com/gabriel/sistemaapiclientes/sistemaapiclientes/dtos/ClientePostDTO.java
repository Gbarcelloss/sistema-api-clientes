package br.com.gabriel.sistemaapiclientes.sistemaapiclientes.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientePostDTO {

	@Size(min = 8, max = 150, message = "Por favor, informe um nome de 8 a 150 caracteres.")
	@NotBlank(message = "Por favor, informe o nome do cliente.")
	private String nome;

	@Pattern(regexp = "^[0-9]{11}$", message = "Por favor, informe um CPF com exatamente 11 números.")
	@NotBlank(message = "Por favor, informe o CPF do cliente.")
	private String cpf;

	@Email(message = "Por favor, informe um endereço de email válido.")
	@NotBlank(message = "Por favor, informe o email do cliente.")
	private String email;
}
