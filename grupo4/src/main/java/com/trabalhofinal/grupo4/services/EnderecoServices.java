package com.trabalhofinal.grupo4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.trabalhofinal.grupo4.dto.CepDTO;
import com.trabalhofinal.grupo4.entities.Endereco;
import com.trabalhofinal.grupo4.repository.EnderecoRepository;

@Service
public class EnderecoServices {

	@Autowired
	EnderecoRepository enderecoRepo;

	public List<Endereco> listarEnderecos() {
		return enderecoRepo.findAll();
	}

	public Endereco buscarEnderecoPorId(Integer id) {

		return enderecoRepo.findById(id).orElse(null);
	}

	public Endereco salvarEndereco(Endereco endereco) {
        // Crie uma instância do RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Faça uma chamada à API ViaCEP para obter os dados do CEP
        String viaCEPUrl = "https://viacep.com.br/ws/" + endereco.getCep() + "/json";
        CepDTO viaCEPResponse = restTemplate.getForObject(viaCEPUrl, CepDTO.class);
        try {

            endereco.setRua(viaCEPResponse.getLogradouro());
            endereco.setBairro(viaCEPResponse.getBairro());
            endereco.setCidade(viaCEPResponse.getLocalidade());
            endereco.setComplemento(viaCEPResponse.getComplemento());
            endereco.setUf(viaCEPResponse.getUf());
        } catch (NullPointerException e) {
            System.out.println(e);

        }

        // Retorna os dados da instâcia Endereco. E precisa ter os
        // parametros
        // instancia e
        // objeto com os dados..
        return enderecoRepo.save(endereco); // salvar os dados do novo Endereco e salva no objeto endereco.
    }

	public Endereco atualizarEndereco(Endereco endereco) {
		return enderecoRepo.save(endereco);
	}

	public Boolean deletarEndereco(Endereco endereco) {
		if (endereco == null)
			return false;

		Endereco enderecoExistente = buscarEnderecoPorId(endereco.getIdEndereco());

		if (enderecoExistente == null)
			return false;

		enderecoRepo.delete(endereco);

		Endereco enderecoContinuaExistindo = buscarEnderecoPorId(endereco.getIdEndereco());

		if (enderecoContinuaExistindo == null)
			return true;

		return false;

	}

}
