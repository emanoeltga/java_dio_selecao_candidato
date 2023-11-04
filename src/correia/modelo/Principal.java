package correia.modelo;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Principal {

	private static Double SALARIO_BASE = 2000.0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] candidatos = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO", "MÔNICA", "FABRÍCIO", "MIRELA",
				"DANIELA", "JORGE" };
		ArrayList<String> cadidatos_selecionados = new ArrayList<String>();
		int totalSelecionados = 0;
		int proximoCandidato = 0; 
		while(totalSelecionados <5 && proximoCandidato < candidatos.length) {
			String candidato = candidatos[proximoCandidato++];
			double valorPretendido = valorPretendido();
			System.out.println("O candidato " + candidato + " está pedindo " + valorPretendido);
			if (selecione(valorPretendido)) {
				cadidatos_selecionados.add(candidato);
				totalSelecionados++;
			}
		}
		System.out.println("Total de selecionados: " + totalSelecionados);
		System.out.println("Total de consultados: " + proximoCandidato);
		System.out.println("Lista dos Selecionados:");
		for(int i=0; i < cadidatos_selecionados.size();i++) {
			
			System.out.println(" * " + (i+1)+" - " +cadidatos_selecionados.get(i) + " foi selecionado ");
			ligacao(cadidatos_selecionados.get(i));
		}
		
	}
	//Seleciona os Salarios da Vez
	public static boolean selecione(double salarioPretendido) {
		if (SALARIO_BASE > salarioPretendido) {
			System.out.println("Ligar para Candidato");
			return true;
		} else if (SALARIO_BASE == salarioPretendido) {
			System.out.println("Ligar para Candidato com contra Proposta.");
			return true;
		} else {
			System.out.println("Aguardando o resultado dos demais Candidatos.");
			return false;
		}
	}
	//Gerar os Salários
	public static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}

	// Tentativas
	public static void ligacao(String candidato) {

		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if (continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("            CONTATO REALIZADO COM SUCESSO");

		} while (continuarTentando && tentativasRealizadas < 3);

		if (atendeu)
			System.out.println("            CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
		else
			System.out.println("           NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MAXIMO TENTATIVAS "
					+ tentativasRealizadas + " REALIZADA");

	}

	// retorna as tentaivas de ligação
	public static boolean atender() {
		return new Random().nextInt(3) == 1;
	}

}
