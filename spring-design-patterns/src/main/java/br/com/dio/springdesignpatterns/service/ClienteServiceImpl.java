package br.com.dio.springdesignpatterns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.dio.springdesignpatterns.model.Cliente;
import br.com.dio.springdesignpatterns.model.ClienteRepository;
import br.com.dio.springdesignpatterns.model.Endereco;
import br.com.dio.springdesignpatterns.model.EnderecoRepository;

public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	@Autowired
	ViaCepService viaCepService;
	
	@Override
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if(clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}
	
	private void salvarClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}
}
