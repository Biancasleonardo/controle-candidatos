package candidatura;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public final static double SALARIO_BASE = 2000.00;
    public static void main(String[] args) throws Exception {
        imprimirSelecionados();

    }

    static void imprimirSelecionados(){
       ArrayList<String> candidatosSelecionados = selecaoCandidatos(); 

       for (String candidato : candidatosSelecionados) {
        System.out.println("Candidado selecionado: " + candidato);
       }
    }

    // static boolean atender(){
    //     return ThreadLocalRandom.current().nextInt(3)==1;
    // }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800.00, 2100.00);
    }

    static ArrayList<String> selecaoCandidatos(){
        String[] candidatos = {"Bianca", "Osmar", "Natan", "Lucas", "Nathan", "Claudia", "Loide", "Ivanir", "Marli", "Gabriela"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        ArrayList<String> novaListaCandidatos = new ArrayList<>();

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            analisarCandidato(salarioPretendido);

            System.out.println("O candidato: " + candidato + " solicitou um salário de: " + salarioPretendido);

            if (SALARIO_BASE >= salarioPretendido) {
                candidatosSelecionados++;
                novaListaCandidatos.add(candidato);
            }
            candidatoAtual++;
        }
        return novaListaCandidatos;
    }

    static void analisarCandidato(double salarioPretendido){

        if (SALARIO_BASE > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (SALARIO_BASE == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        } else {
            System.out.println("Aguardando demais candidatos");
        }
    }
}
