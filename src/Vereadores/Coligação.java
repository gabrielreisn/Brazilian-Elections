package Vereadores;

import java.util.List;
import java.util.LinkedList;

public class Coligação {
	
	private String nomeDaColigação;
	private List<Partido> partidosDacoligação = new LinkedList<Partido>();
	
	
	public Coligação(String nomeDaColigação){
		this.nomeDaColigação = nomeDaColigação;
	}
	
	public void adicionaPartido(Partido p){
		//String name = p.getNomeDoPartido();
		
		if(!this.partidosDacoligação.contains(p)){
			this.partidosDacoligação.add(p);
		}
	}
	
	public void PartidosDaColigação(){
		System.out.println("partidos da coligação("+this.nomeDaColigação+")");
		
		for(Partido p : partidosDacoligação){
			System.out.println(p.getNomeDoPartido());
		}
		
	}
	
	public List<Partido> getPartidosDacoligação(){
		return this.partidosDacoligação;
	}
	
	public String getNomeDaColigação(){
		return this.nomeDaColigação;
	}
	
	
	public int votosDaColigação(){
		int votos=0;
		
		for(Partido p :partidosDacoligação){
			votos = votos + p.votosDoPartido();
		}
		
		return votos;
	}
	
	public int CandidatosEleitos(){
		int qtd=0;
		
		for(Partido p :partidosDacoligação){
			qtd = qtd + p.QuantidadeDeCandidatosEleitos();
		}
		
		return qtd;
	}
	
	@Override
	public String toString(){
		
		return ("Coligação: "+this.nomeDaColigação+", "+votosDaColigação()+" votos, "+CandidatosEleitos()+" candidatos eleitos");
		
	}
}
