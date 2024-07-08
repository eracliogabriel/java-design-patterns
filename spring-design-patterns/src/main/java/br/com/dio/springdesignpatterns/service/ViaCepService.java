package br.com.dio.springdesignpatterns.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.dio.springdesignpatterns.model.Endereco;

@FeignClient(name = "viacep", url = "http://viacep.com.br/ws")
public interface ViaCepService {
    @GetMapping("/{cep}/json/")
	Endereco consultarCep(String cep);
}
