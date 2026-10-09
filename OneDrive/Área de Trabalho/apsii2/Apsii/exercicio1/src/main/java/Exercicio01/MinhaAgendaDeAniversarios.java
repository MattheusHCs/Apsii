package Exercicio01;

import java.util.ArrayList;

public class MinhaAgendaDeAniversarios implements AgendaDeAniversarios {

	private ArrayList<Aniversariante> listaDeAniversariantes = new ArrayList<Aniversariante>();

	public void adicionarAniversariante(String nome, int dia, int mes) {
		Aniversariante novo = new Aniversariante(nome, dia, mes);
		listaDeAniversariantes.add(novo);
	}

	public ArrayList<String> obterAniversariantesDoDia(int dia, int mes) {
		ArrayList<String> nomes = new ArrayList<String>();

		for (int i = 0; i < listaDeAniversariantes.size(); i++) {
			Aniversariante pessoa = listaDeAniversariantes.get(i);

			if (pessoa.getDataAniversario().getDia() == dia && pessoa.getDataAniversario().getMes() == mes) {
				nomes.add(pessoa.getNome());
			}
		}

		return nomes;
	}

	public void removerAniversariante(String nomeAniversariante) {
		for (int i = listaDeAniversariantes.size() - 1; i >= 0; i--) {
			Aniversariante pessoa = listaDeAniversariantes.get(i);

			if (pessoa.getNome().equals(nomeAniversariante)) {
				listaDeAniversariantes.remove(i);
			}
		}
	}
}