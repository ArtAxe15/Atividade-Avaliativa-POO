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

        for (int i = 0; i < estudantes.length; i++) {
            if (estudantes[i].calculaMedia() >= 6) {
                aprovados[posicao] = estudantes[i];
                posicao++;
            }
        }

        return aprovados;
    }


    public static void main(String[] args) {

        // Aqui você pode criar e testar os estudantes
        Estudante aluno1 = new Estudante("Artur");
        Estudante aluno2 = new Estudante("Charlie");
        Estudante aluno3 = new Estudante("Nicolas");
        Estudante aluno4 = new Estudante("Guilherme");
        Estudante aluno5 = new Estudante("Arthur");

        aluno1.insereNotas(8.8);
        aluno1.insereNotas(8.8);
        aluno1.insereNotas(8.8);
        aluno1.insereNotas(8.8);
        aluno1.insereNotas(8.8);
        aluno1.insereNotas(8.8);

        aluno2.insereNotas(8.8);
        aluno2.insereNotas(8.8);
        aluno2.insereNotas(8.8);
        aluno2.insereNotas(8.8);
        aluno2.insereNotas(8.8);

        aluno3.insereNotas(5.0);
        aluno3.insereNotas(5.0);
        aluno3.insereNotas(5.0);
        aluno3.insereNotas(5.0);
        aluno3.insereNotas(5.0);

        aluno4.insereNotas(5.0);
        aluno4.insereNotas(5.0);
        aluno4.insereNotas(5.0);
        aluno4.insereNotas(5.0);
        aluno4.insereNotas(5.0);

        aluno5.insereNotas(5.0);
        aluno5.insereNotas(5.0);
        aluno5.insereNotas(5.0);
        aluno5.insereNotas(5.0);
        aluno5.insereNotas(5.0);

        // Criando o array com todos os estudantes
        Estudante[] estudantes = {aluno1, aluno2, aluno3, aluno4, aluno5};

        // Chamando o método que encontra os aprovados
        Estudante[] resultado = aprovados(estudantes);

        if (resultado == null) {
            System.out.println("Nenhum estudante foi aprovado.");
        } else {
            System.out.println("Estudantes aprovados:");

            for (Estudante resultado1 : resultado) {
                System.out.println(resultado1.getNome() + " - Média: " + resultado1.calculaMedia());
            }
        }
    }
}