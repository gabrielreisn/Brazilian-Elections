package Vereadores;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class Tester {

	public static void main(String[] args) {
		Map<Integer,Candidato> candidatos = new HashMap<>();
		
		NumberFormat n = NumberFormat.getCurrencyInstance();
		
		Candidato c1 = new Candidato("FABRÍCIO GANDINI",23123,Integer.parseInt("7.611"),4.21);
		//Candidato c2 = new Candidato("DENNINHO",23444,6167,);
		
		//CRIAR CLASSE ABSTRATA P POLIMORFISMO [NOME,VOTOS,NUMERO/ID]
	}

}
