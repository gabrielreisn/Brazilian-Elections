package Vereadores;

import java.util.List;
import java.util.LinkedList;

public class Coligação {
	
	private String nomeDaColigação;
	private int candidadosEleitos;
	List<Partido> partidosDacoligação = new LinkedList<Partido>();
	
	
	public Coligação(String nomeDaColigação){
		this.nomeDaColigação = nomeDaColigação;
	}
	
	public String toString(){
		return ("nome da coligação: "+this.nomeDaColigação);
	}
}
