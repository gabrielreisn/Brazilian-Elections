package Vereadores;

import java.util.List;
import java.util.LinkedList;

public class Partido {
	private String nomeDoPartido;
	private int numeroDoPartido;
	private List<Candidato> candidatosDoPartido = new LinkedList<Candidato>();
	private List<Candidato> candidatosEleitos = new LinkedList<Candidato>();
	private List<Coligação> coligaçõesDoPartido = new LinkedList<Coligação>();
	
	public Partido(String nomeDoPartido,int numeroDoPartido){
		this.nomeDoPartido = nomeDoPartido;
		
	    this.numeroDoPartido = Integer.parseInt(Integer.toString(numeroDoPartido).substring(0, 2));
		
	}
	
	public String toString(){
		return ("nome do partido: "+this.nomeDoPartido+"numero do partido: "+this.numeroDoPartido);
	}

	public void adicionaCandidato(Candidato c){
		this.candidatosDoPartido.add(c);
	}
	
	public void adicionaCandidadoEleito(Candidato c){
		this.candidatosEleitos.add(c);
	}
	
	public void adicionaColigação(Coligação col){
		this.coligaçõesDoPartido.add(col);
	}

}
