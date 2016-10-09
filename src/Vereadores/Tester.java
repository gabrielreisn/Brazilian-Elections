package Vereadores;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;


public class Tester {

	public static void main(String[] args) {
		//Map<Integer,Candidato> candidatos = new HashMap<>();
		HashSet<Candidato>hashCandidato = new HashSet<Candidato>();
		HashSet<Partido>hashPartido = new HashSet<Partido>();
		HashSet<Coligação>hashColigação = new HashSet<Coligação>();
		
		
		NumberFormat nf = NumberFormat.getInstance(Locale.forLanguageTag("pt-BR"));
		Number numeroDeVotos = null;
		Number porcentVotosValidos = null;
		
		FileReader file = null;
		
		try {
			file = new FileReader(args[0]);
			
		} catch (FileNotFoundException e1) {
			System.out.println(e1+" :arquivo não encontrado");
			e1.printStackTrace();
		}
		
		Scanner in = new Scanner(file);
		//in.skip(in.nextLine());		//adicionar ao final para ignorar os parametros
		//in.skip("\n");
		
		in.nextLine();
		
		while(in.hasNext()){
			
			
			in.useDelimiter(";");
			in.next();	//pula o numero inicial seq
			
			int numeroDoCandidato = Integer.parseInt(in.next());		//le o numero do candidato
			String nomeDoCandidato = in.next();							//le o nome do candidato
			//System.out.println(in.findInLine("-"));
			
			String nomeDoPartido=null;
			String nomeDaColigação=null;
			
			//if((in.findInLine("-").equals("-"))){
				in.useDelimiter("- ");	//demilitador da divisão "partido - coligação"
				nomeDoPartido = in.next();
				//in.skip("- ");			//remove o "-" da coligação
				in.useDelimiter(";");
				nomeDaColigação = in.next();
				//System.out.println("gatooo");
				/*
			}else if(in.findInLine("-").equals(null)){
				nomeDoPartido = in.next();
				//nomeDaColigação = " ";
				//in.useDelimiter(";");
			}
			*/
			try {
				numeroDeVotos = nf.parse(in.next());
				porcentVotosValidos =nf.parse(in.next());
			} catch (ParseException e) {
				System.out.println("numero impossivel de realizar um parse");
				e.printStackTrace();
			}
			
			hashCandidato.add(new Candidato(nomeDoCandidato,numeroDoCandidato,numeroDeVotos.intValue(),porcentVotosValidos.floatValue()));
			hashPartido.add(new Partido(nomeDoPartido, numeroDoCandidato));
			hashColigação.add(new Coligação(nomeDaColigação));
			
			System.out.println("candidato add");
			
			
			//Candidato c1 = new Candidato(nome,numero,n.intValue(),n2.floatValue());
			//Partido p = new Partido("pps",numero);
		
			if(in.hasNextLine()){
				in.nextLine();
			}
			
			
			
			
		}
		
		in.close();
		
		for (Candidato c : hashCandidato){
			System.out.println(c);
		}
		
		for (Partido p : hashPartido){
			System.out.println(p);
		}
		
		for (Coligação col : hashColigação){
			System.out.println(col);
			//System.out.println(hashColigação.size());
			
		}
		
	}

}
