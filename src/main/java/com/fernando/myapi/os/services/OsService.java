package com.fernando.myapi.os.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.myapi.os.domain.Cliente;
import com.fernando.myapi.os.domain.OS;
import com.fernando.myapi.os.domain.Tecnico;
import com.fernando.myapi.os.domain.enums.Prioridade;
import com.fernando.myapi.os.domain.enums.Status;
import com.fernando.myapi.os.dtos.OSDTO;
import com.fernando.myapi.os.repositories.OSRepository;
import com.fernando.myapi.os.services.exceptions.ObjectNotFoundException;

@Service
public class OsService {

	@Autowired
	private OSRepository osRepository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public OS findById(Integer id) {
		Optional<OS> obj = osRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!"));
	}
	
	
	public List<OS> findAll(){
		return osRepository.findAll();
	}


	public OS create(@Valid OSDTO obj) {
		return fromDTO(obj);
	}


	public OS update(@Valid OSDTO obj) {
		findById(obj.getId());
		return fromDTO(obj);
	}
	
	private OS fromDTO(OSDTO obj) {
		OS newObj = new OS();
		newObj.setId(obj.getId());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setPrioridade(Prioridade.toEnum(obj.getPrioridade().getCod()));
		newObj.setStatus(Status.toEnum(obj.getStatus().getCod()));
		
		Tecnico tec = tecnicoService.findById(obj.getTecnico());
		Cliente cli = clienteService.findById(obj.getCliente());
		
		newObj.setTecnico(tec);
		newObj.setCliente(cli);
		
		if (newObj.getStatus().getCod().equals(2)) {
			newObj.setDtaFechamento(LocalDateTime.now());
		}
		
		return osRepository.save(newObj); 
	}
}
