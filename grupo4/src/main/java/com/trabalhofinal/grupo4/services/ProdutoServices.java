package com.trabalhofinal.grupo4.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trabalhofinal.grupo4.entities.Produto;
import com.trabalhofinal.grupo4.repository.ProdutoRepository;

import io.jsonwebtoken.io.IOException;

@Service
public class ProdutoServices {

	@Autowired
	ProdutoRepository produtoRepo;

	// IMAGEM
	private String raiz = "C:\\DEVSERRATEC\\TrabalhoFinalApirestful\\grupo4\\src\\main\\java\\com\\trabalhofinal\\grupo4";

	// diretorio das fotos
	private String diretorioFotos = "fotos";

	public void salvarFoto(MultipartFile foto) {
		this.salvar(this.diretorioFotos, foto);
	}

	public void salvar(String diretorio, MultipartFile arquivo) {
		// diretorio
		Path diretorioPath = Path.of(this.raiz, diretorio); // Use Path.of para criar o caminho.

		// diretorio + arquivo
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());

		try {
			Files.createDirectories(diretorioPath); // Cria o diretório, se não existir.
			Files.copy(arquivo.getInputStream(), arquivoPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			throw new RuntimeException("Problemas ao tentar salvar o arquivo.");
		}
	}

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

		return produtoContinuaExistindo == null;
	}

	public Produto salvarProdutoComFoto(String strProduto, MultipartFile arqImg)
			throws java.io.IOException {
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
