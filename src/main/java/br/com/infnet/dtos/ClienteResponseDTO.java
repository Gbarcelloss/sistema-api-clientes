package br.com.infnet.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClienteResponseDTO {

    private Integer status;
    private String mensagem;

}
