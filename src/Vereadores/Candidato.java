package Vereadores;


public class Candidato implements Comparable<Candidato> {
	@SuppressWarnings("unused")
	private int numero;
	private String nome;
	private Partido partido;
	private int votos;
	@SuppressWarnings("unused")
	private float percentVotosValidos;


	public Candidato(String nome,int numero,int votos,float porcentagemDeVotos){
		this.nome = nome;
		this.numero = numero;
		this.votos = votos;
		this.percentVotosValidos = porcentagemDeVotos;
	}
	
	@Override
	public String toString(){
		if(this.partido.getNomeDoPartido()!=this.partido.getNomeDaColigação()){
			return (this.nome +" ("+this.partido.getNomeDoPartido()+", "+this.votos+" votos) - Coligação: "+this.partido.getColigaçãoDoPartido().getNomeDaColigação());
		}
		else{
			return (this.nome +" ("+this.partido.getNomeDoPartido()+", "+this.votos+" votos)");
		}
	}

	public void setPartido(Partido p){
		this.partido = p;
	}
	
	public String getNomeCandidato(){
		return this.nome;
	}
	
	public int getVotosDoCandidato(){
		return this.votos;
	}

	@Override
	public int compareTo(Candidato o) {
		int comparedVotes = o.getVotosDoCandidato();
		
		if(this.votos> comparedVotes){
			return -1;
		}
		
		return 1;
	}
}