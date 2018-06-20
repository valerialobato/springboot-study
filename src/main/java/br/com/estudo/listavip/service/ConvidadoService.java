package br.com.estudo.listavip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.listavip.model.Convidado;
import br.com.estudo.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {
	
	@Autowired
	ConvidadoRepository repository;
	
	public Iterable<Convidado> obterTodos(){
		return repository.findAll();
	}
	
	public void salvarConvidado(Convidado convidado) {
		repository.save(convidado);
	}

}
