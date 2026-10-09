public class Aluguel {

    // REFATORAÇÃO 3 (Replace Magic Number with Constant):
    //  os números soltos viram constantes com nome, para que a regra de preço
    // seja entendida e alterada em um só lugar
    private static final double VALOR_BASE_NORMAL = 2;
    private static final int DIAS_INCLUSOS_NORMAL = 2;
    private static final double VALOR_DIA_LANCAMENTO = 3;
    private static final double VALOR_BASE_INFANTIL = 1.5;
    private static final int DIAS_INCLUSOS_INFANTIL = 3;
    private static final double VALOR_DIA_EXTRA = 1.5;

    private int diasAlugada;
    private Fita fita;

    public Aluguel(Fita fita, int diasAlugada) {
        this.fita = fita;
        this.diasAlugada = diasAlugada;
    }

    public Fita getFita() {
        return fita;
    }

    public int getDiasAlugada() {
        return diasAlugada;
    }

    // REATORAÇÃO 1 (Extract Method e o Move Method):
    // o cálculo do valor estava no Cliente.extrato(), mas usa só dados do
    // Aluguel e da Fita (Feature Envy). Agora fica na classe que tem os dados
    public double getValor() {
        double valor = 0;
        switch (fita.getCodigoDePreco()) {
            case Fita.NORMAL:
                valor += VALOR_BASE_NORMAL;
                if (diasAlugada > DIAS_INCLUSOS_NORMAL)
                    valor += (diasAlugada - DIAS_INCLUSOS_NORMAL) * VALOR_DIA_EXTRA;
                break;
            case Fita.LANCAMENTO:
                valor += diasAlugada * VALOR_DIA_LANCAMENTO;
                break;
            case Fita.INFANTIL:
                valor += VALOR_BASE_INFANTIL;
                if (diasAlugada > DIAS_INCLUSOS_INFANTIL)
                    valor += (diasAlugada - DIAS_INCLUSOS_INFANTIL) * VALOR_DIA_EXTRA;
                break;
        }
        return valor;
    }

    // REFATORAÇÃO 1 (Extract Method e o Move Method):
    // mesma ideia para os pontos de alugador frequente
    public int getPontos() {
        if (fita.getCodigoDePreco() == Fita.LANCAMENTO && diasAlugada > 1)
            return 2;
        return 1;
    }
}