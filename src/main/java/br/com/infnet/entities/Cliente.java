package br.com.infnet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Cliente {

	private Integer idCliente;
	private String nome;
    private String cpf;
    private String email;


}
