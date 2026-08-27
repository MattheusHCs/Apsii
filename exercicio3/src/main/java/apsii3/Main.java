package apsii3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        
        Livro livro = new Livro();

        System.out.println("=== CADASTRO DO LIVRO ==");

        System.out.print("Nome do livro: ");
        livro.setNome(scanner.nextLine());

        System.out.print("Preço do livro: ");
        livro.setPreco(scanner.nextDouble());
        scanner.nextLine();

        System.out.print("Autor do livro: ");
        livro.setAutor(scanner.nextLine());
        


        CD cd = new CD();

        System.out.println("\n=== CADASTRO DO CD ===");

        System.out.print("Nome do CD: ");
        cd.setNome(scanner.nextLine());

        System.out.print("Preço do CD: ");
        cd.setPreco(scanner.nextDouble());

        System.out.println("Números de faixa: ");
        cd.setNumFaixas(scanner.nextInt());
        
        

        System.out.println("\n=== INFORMAÇÕES DO CD ===");
        cd.exibirInformacoes();

        scanner.close();
    }
}
