package com.fernando.myapi.os.domain.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum Status {

	ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERADO(2, "ENCERRADO");

	private Integer cod;
	private String descricao;

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Status toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (Status x : Status.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Status invalida!" + cod);
	}
}
