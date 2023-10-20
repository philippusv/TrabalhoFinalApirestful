package com.trabalhofinal.grupo4.services;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaSecuritySer {
	
//CRUD
//recuperar todos os alunos
//recuperar um aluno pela sua chave primária
//salvar um novo aluno
//atualizar um determinado aluno
//deletar um determinado aluno
	
	@Autowired  // essa anotação é para injeção de dependencia, recursos de outro lugar
	AlunoRepository alunoRepo;
	
	public List<Aluno> listarAlunos(){
		return alunoRepo.findAll();
	}
	
	public Aluno buscarAlunoPorId(Integer id) {
//		return alunoRepo.findById(id).get();
//		Optional<Aluno> alunoBanco = alunoRepo.findById(id);
//		if(alunoBanco.isPresent())
//			return alunoBanco.get();
//		else
//			return null;
		
		return alunoRepo.findById(id).orElse(null);
	}
	
	public Aluno salvarAluno(Aluno aluno) {
		return alunoRepo.save(aluno);
	}
	
	public Aluno atualizarAluno(Aluno aluno) {
		return alunoRepo.save(aluno);
	}
	
	public void deletarAluno(Aluno aluno) {
		alunoRepo.delete(aluno);
		//Aluno confereAlunoDeletado = buscarAlunoPorId(aluno.getNumeroMatricaAluno());
	}
}