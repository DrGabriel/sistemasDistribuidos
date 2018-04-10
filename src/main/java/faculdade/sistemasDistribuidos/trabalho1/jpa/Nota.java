package faculdade.sistemasDistribuidos.trabalho1.jpa;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import faculdade.sistemasDistribuidos.trabalho1.validacao.FiltrosNota;

@Entity
public class Nota {
	
	@Id
	private String matriculaAluno;
	@Id
	private String codigoDisciplina;
	private BigDecimal nota;
	
	public String getMatriculaAluno() {
		return matriculaAluno;
	}
	
	public void setMatriculaAluno(String matriculaAluno) {
		if(matriculaAluno.matches(FiltrosNota.filtroMatriculaAluno())) {
			this.matriculaAluno = matriculaAluno;
		}else {
			throw new IllegalArgumentException("A matricula do aluno deve seguir o padrao ddddddddd-d, onde d é um digito 0-9");
		}
		
	}
	
	public String getCodigoDisciplina() {
		return codigoDisciplina;
	}
	
	public void setCodigoDisciplina(String codigoDisciplina) {
		if(codigoDisciplina.matches(FiltrosNota.filtroCodigodisciplina())) {
			this.codigoDisciplina = codigoDisciplina;
		}else {
			throw new IllegalArgumentException("A matricula do aluno deve seguir o padrao AAddd, onde A é uma letra de A-Z, maiuscula e d é um digito 0-9");
		}
	}
	
	public BigDecimal getNota() {
		return nota;
	}
	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}
	
}
