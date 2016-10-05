package Vereadores;

public class Candidato {
	private int numero;
	private String nome;
	private Partido partido;
	private Coligação colicação;
	private int votos;
	private double percentVotosValidos;


	public Candidato(String nome,int numero,int votos,double porcentagemDeVotos){
		this.nome = nome;
		this.numero = numero;
		this.votos = votos;
		this.percentVotosValidos = porcentagemDeVotos;
	}
	

	
}