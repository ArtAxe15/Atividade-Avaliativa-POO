import java.util.ArrayList;
import java.util.Scanner;

public class Teste {

    public static Estudante[] aprovados(Estudante[] estudantes) {

        int quantidadeAprovados = 0;

        for (Estudante estudante : estudantes) {
            if (estudante.calculaMedia() >= 6) {
                quantidadeAprovados++;
            }
        }

        if (quantidadeAprovados == 0) {
            return null;
        }

        Estudante[] aprovados = new Estudante[quantidadeAprovados];

        int posicao = 0;

        for (Estudante estudante : estudantes) {
            if (estudante.calculaMedia() >= 6) {
                aprovados[posicao] = estudante;
                posicao++;
            }
        }

        return aprovados;
    }

    public static void main(String[] args) {

        try (Scanner teclado = new Scanner(System.in)) {
            ArrayList<Estudante> estudantes = new ArrayList<>();
            
            // ==============================
            // CADASTRO DOS PESOS
            // ==============================
            
            Integer[] pesos = new Integer[5];
            
            System.out.println("=== CADASTRO DOS PESOS ===");
            
            for (int i = 0; i < 5; i++) {
                boolean pesoValido = false;

                while (!pesoValido) {

                    System.out.print("Digite o peso da avaliação " + (i + 1) + ": ");
                    String entrada = teclado.nextLine();

                    try {
                        int peso = Integer.parseInt(entrada);

                        if (peso < 0 || peso > 10) {
                            System.out.println("O peso deve ser maior que 0 e menor que 10.");
                        } else {
                            pesos[i] = peso;
                            pesoValido = true;
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Digite apenas um número inteiro válido.");
                    }
                }
            }
            
            int opcao;
            
            do {
                
                System.out.println("\n==============================");
                System.out.println("     SISTEMA DE ESTUDANTES");
                System.out.println("==============================");
                System.out.println("1 - Cadastrar estudante");
                System.out.println("2 - Ver todos os alunos aprovados");
                System.out.println("3 - Ver média de um aluno");
                System.out.println("4 - Ver média ponderada de um aluno");
                System.out.println("5 - Finalizar");
                System.out.println("==============================");
                System.out.print("Escolha uma opção: ");
                
                opcao = teclado.nextInt();
                teclado.nextLine(); // limpa o ENTER
                
                switch (opcao) {
                    
                    case 1 -> {
                        System.out.print("\nDigite o nome do estudante: ");
                        String nome = teclado.nextLine();
                        
                        Estudante estudante = new Estudante(nome);
                        
                        System.out.println("\nDigite as 5 notas:");
                        
                        for (int i = 0; i < 5; i++) {
                            double nota = 0;
                            boolean notaValida = false;

                            while (!notaValida) {

                                System.out.print("Nota " + (i + 1) + ": ");

                                String entrada = teclado.nextLine();

                                try {
                                    nota = Double.parseDouble(entrada.replace(",", "."));

                                    if (nota < 0 || nota > 10) {
                                        System.out.println("A nota deve estar entre 0 e 10.");
                                    } else {
                                        notaValida = true;
                                    }

                                } catch (NumberFormatException e) {
                                    System.out.println("Digite apenas um número válido.");
                                }
                            }

                            estudante.insereNotas(nota);
                    }

                        estudantes.add(estudante);

                        System.out.println("\nEstudante cadastrado com sucesso!");
                    }
                    
                    
                    case 2 -> {
                        if (estudantes.isEmpty()) {
                            System.out.println("\nNenhum estudante cadastrado.");
                            break;
                        }
                        
                        // Converte ArrayList para array
                        Estudante[] estudantesArray =
                                estudantes.toArray(new Estudante[0]);
                        
                        Estudante[] resultado = aprovados(estudantesArray);
                        
                        if (resultado == null) {
                            
                            System.out.println("\nNenhum estudante foi aprovado.");
                            
                        } else {
                            
                            System.out.println("\n=== ESTUDANTES APROVADOS ===");
                            
                            for (Estudante aluno : resultado) {
                                
                                System.out.println(
                                        aluno.getNome()
                                                + " - Média: "
                                                + aluno.calculaMedia()
                                );
                            }
                        }
                    }
                    
                    
                    case 3 -> {
                        if (estudantes.isEmpty()) {
                            System.out.println("\nNenhum estudante cadastrado.");
                            break;
                        }
                        
                        System.out.print("\nDigite o nome do estudante: ");
                        String nomeBusca = teclado.nextLine();
                        
                        boolean encontrado = false;
                        
                        for (Estudante aluno : estudantes) {
                            
                            if (aluno.getNome().equalsIgnoreCase(nomeBusca)) {
                                
                                System.out.println(
                                        "Média de "
                                                + aluno.getNome()
                                                + ": "
                                                + aluno.calculaMedia()
                                );
                                
                                encontrado = true;
                                break;
                            }
                        }
                        
                        if (!encontrado) {
                            System.out.println("Estudante não encontrado.");
                        }
                    }
                    
                    
                    case 4 -> {
                        if (estudantes.isEmpty()) {
                            System.out.println("\nNenhum estudante cadastrado.");
                            break;
                        }
                        
                        System.out.print("\nDigite o nome do estudante: ");
                        String nomePonderada = teclado.nextLine();
                        
                        boolean encontradoPonderada = false;
                        
                        for (Estudante aluno : estudantes) {
                            
                            if (aluno.getNome().equalsIgnoreCase(nomePonderada)) {
                                
                                System.out.println(
                                        "Média ponderada de "
                                                + aluno.getNome()
                                                + ": "
                                                + aluno.calculaMedia(pesos)
                                );
                                
                                encontradoPonderada = true;
                                break;
                            }
                        }
                        
                        if (!encontradoPonderada) {
                            System.out.println("Estudante não encontrado.");
                        }
                    }
                    
                    
                    case 5 -> System.out.println("\nPrograma finalizado.");
                    
                    
                    default -> System.out.println("\nOpção inválida.");
                }
                
            } while (opcao != 5);
        }
    }
}
