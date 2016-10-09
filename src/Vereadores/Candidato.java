package Vereadores;


public class Candidato {
	private int numero;
	private String nome;
	private Partido partido;
	private Coligação colicação;
	private int votos;
	private float percentVotosValidos;


	public Candidato(String nome,int numero,int votos,float porcentagemDeVotos){
		this.nome = nome;
		this.numero = numero;
		this.votos = votos;
		this.percentVotosValidos = porcentagemDeVotos;
	}
	
	
	public String toString(){
		return ("nome:"+this.nome +"num: "+this.numero+"votos: "+this.votos+"percent: "+this.percentVotosValidos);
	}

	
}