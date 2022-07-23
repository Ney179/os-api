package com.fernando.myapi.os.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import com.fernando.myapi.os.domain.OS;

import lombok.Data;


@Data
public class OSDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private LocalDateTime dataAbertura;
	private LocalDateTime dtaFechamento;
	private Integer prioridade;
	
	@NotEmpty(message = "O campo OBSERVAÇÔES é requerido")
	private String observacoes;
	private Integer status;	
	private Integer tecnico;	
	private Integer cliente;
	
	public OSDTO() {
		super();
	}

	public OSDTO(OS obj) {
		super();
		this.id = obj.getId();
		this.dataAbertura = obj.getDataAbertura();
		this.dtaFechamento = obj.getDataFechamento();
		this.prioridade = obj.getPrioridade().getCod();
		this.observacoes = obj.getObservacoes();
		this.status = obj.getStatus().getCod();
		this.tecnico = obj.getTecnico().getId();
		this.cliente = obj.getCliente().getId();
	}
}


