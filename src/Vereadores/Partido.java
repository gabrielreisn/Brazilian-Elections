package Vereadores;

import java.util.List;
import java.util.LinkedList;

public class Partido implements Comparable<Partido> {
	private String nomeDoPartido;
	
	@SuppressWarnings("unused")
	private int numeroDoPartido;
	private List<Candidato> candidatosDoPartido = new LinkedList<Candidato>();
	private List<Candidato> candidatosEleitos = new LinkedList<Candidato>();
	private Coligação coligaçãoDoPartido;
	
	public Partido(String nomeDoPartido,int numeroDoPartido){
		this.nomeDoPartido = nomeDoPartido;
		
	    this.numeroDoPartido = Integer.parseInt(Integer.toString(numeroDoPartido).substring(0, 2));
		
	}
	
	@Override
	public String toString(){
		return (this.nomeDoPartido+", "+votosDoPartido()+" votos, "+QuantidadeDeCandidatosEleitos()+" candidatos eleitos");
	}

	public void adicionaCandidato(Candidato c){
		this.candidatosDoPartido.add(c);
	}
	
	public void adicionaCandidadoEleito(Candidato c){
		this.candidatosEleitos.add(c);
	}
	
	public void setColigação(Coligação col){
		this.coligaçãoDoPartido = col;
	}
	
	public String getNomeDoPartido(){
		return this.nomeDoPartido;
	}
	
	public void getCandidatosDoPartido(){
		for(Candidato c :candidatosDoPartido){
			System.out.println(c.getNomeCandidato());
		}
	}
	
	public Coligação getColigaçãoDoPartido(){
		return this.coligaçãoDoPartido;
	}
	
	public String getNomeDaColigação(){
		return this.coligaçãoDoPartido.getNomeDaColigação();
	}
	
	public int votosDoPartido(){
		int votos=0;
		
		for (Candidato c :candidatosDoPartido ){
			votos = votos + c.getVotosDoCandidato();
		}
		
		return votos;
	}
	
	public int QuantidadeDeCandidatosEleitos(){
		return this.candidatosEleitos.size();
	}

	@Override
	public int compareTo(Partido o) {
		int comparedVotes = o.votosDoPartido();
		
		if(this.votosDoPartido() > comparedVotes){
			return -1;
		}
		
		return 1;
	}
	
}
