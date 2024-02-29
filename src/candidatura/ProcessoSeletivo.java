package candidatura;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public final static double SALARIO_BASE = 2000.00;

    public static void main(String[] args) throws Exception {
        ArrayList<String> candidatosSelecionados = imprimirSelecionados(); 

        for (String candidato : candidatosSelecionados) {
            entrarEmContato(candidato);
        }

    }

    static void entrarEmContato(String candidato){

        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso");
            }
        } while (continuarTentando && tentativasRealizadas < 3);

        if(atendeu) {
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato +" NA " + tentativasRealizadas + " TENTATIVA");
        } else {
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato +", NÚMERO MAXIMO TENTATIVAS " + tentativasRealizadas + " REALIZADA");
        }
    }

    static ArrayList<String> imprimirSelecionados() {
        ArrayList<String> candidatosSelecionados = selecaoCandidatos();

        for (String candidato : candidatosSelecionados) {
            System.out.println("Candidado selecionado: " + candidato);
        }

        return candidatosSelecionados;
    }

    static boolean atender() {
        return ThreadLocalRandom.current().nextInt(3) == 1;
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800.00, 2100.00);
    }

    static ArrayList<String> selecaoCandidatos() {
        String[] candidatos = { "Bianca", "Osmar", "Natan", "Lucas", "Nathan", "Claudia", "Loide", "Ivanir", "Marli",
                "Gabriela" };

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

    static void analisarCandidato(double salarioPretendido) {

        if (SALARIO_BASE > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (SALARIO_BASE == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        } else {
            System.out.println("Aguardando demais candidatos");
        }
    }
}
