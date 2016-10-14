package Vereadores;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import java.util.Scanner;

	

public class Tester {

	public static void main(String[] args) {
		Map<Integer,Candidato> hashCandidato = new HashMap<>();
		Map<String,Partido> hashPartido = new HashMap<>();
		Map<String,Coligação> hashColigação = new HashMap<>();
		List<Candidato> candidatosEleitos = new LinkedList<>();
		
		NumberFormat nf = NumberFormat.getInstance(Locale.forLanguageTag("pt-BR"));
		Number numeroDeVotos = null;
		Number porcentVotosValidos = null;
		
		String flagCandidatoEleito = null;
		int numeroDeCandidatosEleitos=0;
		
		FileReader file = null;
		
		try {
			file = new FileReader(args[0]);
			
		} catch (FileNotFoundException e1) {
			System.out.println(e1+" :arquivo não encontrado");
			e1.printStackTrace();
		}
		
		Scanner in = new Scanner(file);
		
		in.nextLine();
		
		while(in.hasNext()){
			
			
			in.useDelimiter(";");
			flagCandidatoEleito = in.next();	//le o numero inicial seq (flag *)
			
			
			int numeroDoCandidato = Integer.parseInt(in.next());		//le o numero do candidato
			String nomeDoCandidato = in.next();							//le o nome do candidato
			
			String s = in.next();						//DAQUI ATE
			String[] parts = null;
			String nomeDoPartido;							//RESOLVE O PROBLEMA PARTIDO - COLIGAÇÃO
			String nomeDaColigação;
			
			if(s.contains("-")){
				parts = s.split(" - ");
				nomeDoPartido = parts[0]; 
				nomeDaColigação = parts[1];
			}
			else{
				nomeDoPartido = s;
				nomeDaColigação = s;
			}											//AQUI
			
			
			try {
				numeroDeVotos = nf.parse(in.next());
				in.useDelimiter("%\n");
				in.skip(";");
				porcentVotosValidos =nf.parse(in.next());
				
			} catch (ParseException e) {
				System.out.println("numero impossivel de realizar um parse");
				e.printStackTrace();
			}
			
			
			if(!hashCandidato.containsKey(numeroDoCandidato)){
				hashCandidato.put(numeroDoCandidato,(new Candidato(nomeDoCandidato,numeroDoCandidato,numeroDeVotos.intValue(),porcentVotosValidos.floatValue())));
			}
			
			if(!hashPartido.containsKey(nomeDoPartido)){
				hashPartido.put(nomeDoPartido,(new Partido(nomeDoPartido, numeroDoCandidato)));
			}
			
			if(nomeDaColigação!=null && !hashColigação.containsKey(nomeDaColigação)){
				hashColigação.put(nomeDaColigação,(new Coligação(nomeDaColigação)));
			}
			
			if(flagCandidatoEleito.contains("*")){								//TRATA CASO DE CANDIDATO ELEITO	
				numeroDeCandidatosEleitos++;
				
				Candidato c = hashCandidato.get(numeroDoCandidato);
				candidatosEleitos.add(c);
				
				Partido p = hashPartido.get(nomeDoPartido);
				p.adicionaCandidadoEleito(c);
			}																//FIM
			
			
			Candidato cand = hashCandidato.get(numeroDoCandidato);
			Partido	  part = hashPartido.get(nomeDoPartido);
			Coligação col  = hashColigação.get(nomeDaColigação);
			
			
			cand.setPartido(part);
			
			part.adicionaCandidato(cand);
			
			
			if(col!=null){
			 col.adicionaPartido(part);
			 part.setColigação(col);
			}
		}
		
		in.close();
		
		List<Coligação> coligações = new LinkedList<>();
		coligações.addAll(hashColigação.values());
		Collections.sort(coligações);
		
		List<Partido> partidos = new LinkedList<>();
		partidos.addAll(hashPartido.values());
		Collections.sort(partidos);
		
		List<Candidato> Candidatos = new LinkedList<>();
		Candidatos.addAll(hashCandidato.values());
		Collections.sort(Candidatos);
		
		int totalDeVotosNominais=0;
		
		int index=1;
		System.out.println("Número de vagas: "+numeroDeCandidatosEleitos);
		System.out.println("\nVereadores eleitos:");
		
		for (Candidato c : candidatosEleitos){
			System.out.println(index+" - "+c);
			index++;
		}
		
		System.out.println("\nCandidatos mais votados (em ordem decrescente de votação e respeitando número de vagas):");
		
		index=1;
		for (Candidato c : Candidatos){
			if(index<(numeroDeCandidatosEleitos+1)){
				System.out.println(index+" - "+c);
			}
			index++;
		}
		
		System.out.println("\nTeriam sido eleitos se a votação fosse majoritária, e não foram eleitos:");
		System.out.println("(com sua posição no ranking de mais votados)");
		
		index =1;
		for (Candidato c : Candidatos){								//RESOLVE O PROBLEMA "CANDIDATOS COM VOTO MAJORITARIO QUE NAO FORAM ELEITOS
			if(index<(numeroDeCandidatosEleitos+1)){
				if(!candidatosEleitos.contains(c)){
					System.out.println(index+" - "+c);			
				}
			}
			index++;
		}	  //FIM
		
		
		System.out.println("\nEleitos, que se beneficiaram do sistema proporcional:");
		System.out.println("(com sua posição no ranking de mais votados)");
		
		index =1;
		for (Candidato c : Candidatos){								//RESOLVE O PROBLEMA "CANDIDATOS PUXADOS PELA COLIGAÇÃO"
			if(index>(numeroDeCandidatosEleitos+1)){
				if(candidatosEleitos.contains(c)){
					System.out.println(index+" - "+c);			
				}
			}
			index++;
		}		//FIM
		
		System.out.println("\nVotação (nominal) das coligações e número de candidatos eleitos:");
		
		for (Coligação col : coligações){
			System.out.println(index+" - "+col);
			
			totalDeVotosNominais = totalDeVotosNominais + col.votosDaColigação();
			
			index++;
		}
		
		System.out.println("\nVotação (nominal) dos partidos e número de candidatos eleitos:");
		
		index=1;
		for (Partido p : partidos){
			System.out.println(index+" - "+p);
			index++;
		}
		
		System.out.println("\nTotal de votos nominais: "+totalDeVotosNominais);
		
		
	}

}
