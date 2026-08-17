import java.util.ArrayList;

public class Estudante {
    private ArrayList<Double> notas;
    private String nome;

    public Estudante (String nome){
        this.nome = nome;
        this.notas = new ArrayList<Double>();
    }
    
    public String getNome(){
        return nome;
    }

    public void setNumero(String nome){
        this.nome = nome;
    }

    public ArrayList<Double> getNotas(){
        return notas;
    }
}
