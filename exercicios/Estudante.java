import java.util.ArrayList;

public class Estudante {
    private ArrayList<Double> notas;
    private String nome;
    private ArrayList<Integer> pesos;

    public Estudante (String nome){
        this.nome = nome;
        this.notas = new ArrayList<>();
        this.pesos = new ArrayList<>();
    }
    
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public ArrayList<Double> getNotas(){
        return notas;
    }

    public ArrayList<Integer> getPesos(){
        return pesos;
    }

    public void insereNotas(Double nota) {
        if (notas.size() < 5) {
            notas.add(nota);
        } else {
            System.out.println("O estudante já possui 5 notas.");
        }
    }

    public void inserePesos(Integer peso){
        if (pesos.size() < 5){
            pesos.add(peso);
        } else {
            System.out.println("A grade já possui 5 pesos.");
        }
    }

    public double calculaMedia(){
        double media = 0.0;
        for (int i = 0; i < notas.size(); i++) {
            media = media + notas.get(i);
        }
        media = media/notas.size();   
        return media;
    }

    public double calculaMedia(Integer[] pesos) {
        double soma = 0.0;
        int somaPesos = 0;

        for (int i = 0; i < notas.size(); i++) {
            soma += notas.get(i) * pesos[i];
            somaPesos += pesos[i];
        }

        return soma / somaPesos;
    }
    
    public double menorNota(){
        double menor = notas.get(0);
        for (int i = 0; i < notas.size(); i++) {
            if (menor > notas.get(i)){
                menor = notas.get(i);
            }
        }
        return menor;
    }
}
