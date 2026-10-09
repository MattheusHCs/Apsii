import java.util.*;

public class Cliente {
    private String nome;
    private List<Aluguel> alugueis = new ArrayList<>();

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionaAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    // REFATORAÇÃO 2 (Extract Method):
    // o extrato() fazia tudo (calculava, somava e montava o texto)
    // Agora só monta o texto, e os cálculos estão em métodos com nome claro
    public String extrato() {
        String resultado = "Registro de Alugueis de " + getNome() + "\n";

        for (Aluguel aluguel : alugueis) {
            resultado += "\t" + aluguel.getFita().getTitulo() + "\t" + aluguel.getValor() + "\n";
        }

        resultado += "Valor total devido: " + getValorTotal() + "\n";
        resultado += "Você ganhou " + getPontosTotais() + " pontos de alugador frequente";
        return resultado;
    }

    private double getValorTotal() {
        double total = 0;
        for (Aluguel aluguel : alugueis) {
            total += aluguel.getValor();
        }
        return total;
    }

    private int getPontosTotais() {
        int pontos = 0;
        for (Aluguel aluguel : alugueis) {
            pontos += aluguel.getPontos();
        }
        return pontos;
    }
}
