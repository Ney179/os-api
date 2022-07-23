package com.fernando.myapi.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.myapi.os.domain.Cliente;
import com.fernando.myapi.os.domain.OS;
import com.fernando.myapi.os.domain.Tecnico;
import com.fernando.myapi.os.domain.enums.Prioridade;
import com.fernando.myapi.os.domain.enums.Status;
import com.fernando.myapi.os.repositories.ClienteRepository;
import com.fernando.myapi.os.repositories.OSRepository;
import com.fernando.myapi.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private OSRepository osRepository;

	public void instanciaDB() {
		Tecnico t1 = new Tecnico(null, "Fernando Gomes", "144.785.300-84", "(16) 9 9788-8888");
		Tecnico t2 = new Tecnico(null, "Josias Alvarenga", "929.168.690-50", "(16) 9 8996-5698");
		
		Cliente c1 = new Cliente(null, "Mirian Souza", "598.508.200-80", "(16) 9 9785-5454");
		Cliente c2 = new Cliente(null, "Ana Luiza Lima", "671.923.400-57", "(16) 9 9687-5698");
		Cliente c3 = new Cliente(null, "Larissa Meneguel", "840.764.300-93", "(16) 9 9863-9658");
		Cliente c4 = new Cliente(null, "Sabrina Lima", "164.837.840-40", "(16) 9 9836-9632");
		
		OS os1 = new OS(null, Prioridade.ALTA, "Testes create OD", Status.ANDAMENTO, t1, c1);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2));
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		osRepository.saveAll(Arrays.asList(os1));
	}
}
