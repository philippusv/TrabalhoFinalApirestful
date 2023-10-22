package com.trabalhofinal.grupo4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trabalhofinal.grupo4.entities.Produto;
import com.trabalhofinal.grupo4.repository.ProdutoRepository;

import io.jsonwebtoken.io.IOException;

@Service
public class ProdutoServices {

	@Autowired
	ProdutoRepository produtoRepo;

	public List<Produto> listarProdutoServices() {
		return produtoRepo.findAll();
	}

	public Produto buscarProdutoServicesPorId(Integer id) {

		return produtoRepo.findById(id).orElse(null);
	}

	public Produto salvarProdutoServices(Produto produtoServices) {
		return produtoRepo.save(produtoServices);
	}

	public Produto atualizarProdutoServices(Produto produtoServices) {
		return produtoRepo.save(produtoServices);
	}

	public Boolean deletarProduto(Produto produto) {
		if (produto == null)
			return false;

		Produto produtoExistente = buscarProdutoServicesPorId(produto.getIdProduto());

		if (produtoExistente == null)
			return false;

		produtoRepo.delete(produto);

		Produto produtoContinuaExistindo = buscarProdutoServicesPorId(produto.getIdProduto());

		if (produtoContinuaExistindo == null)
			return true;

		return false;

	}

	public Produto salvarProdutoComFoto(String strProduto, MultipartFile arqImg)
			throws JsonMappingException, JsonProcessingException {
		Produto produto = new Produto();

		try {
			ObjectMapper objMp = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			produto = objMp.readValue(strProduto, Produto.class);
		} catch (IOException e) {
			System.out.println("Erro ao converter a string Produto: " + e.toString());
		}

//editora.setImagemFileName(arqImg.getBytes());
		produto.setImagem(arqImg.getBytes());
		return produtoRepo.save(produto);
	}
}
