package Etapa2_Pesquisa_e_Ordenacao;

import java.util.Scanner;

public class PrincipalCandidatos {


    public static void ordenaCandidatosPorPartido(Candidato[] candidatos) {

        char[] lettersToCompare = {'A','B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        int[] candidatosToNumber = new int[candidatos.length];

        String partidoToUpperCase;
        char[] partidoToChar;

        for(int i = 0; i < candidatos.length; i++){
            partidoToUpperCase = candidatos[i].getPartido().toUpperCase();
            partidoToChar = partidoToUpperCase.toCharArray();

            for (int j = 0; j < lettersToCompare.length; j++)
                if (partidoToChar[0] == lettersToCompare[j]){
                    candidatosToNumber[i] = j;
                    break;
                }
        }


        int min;

        for (int i = 0; i < candidatos.length; i++){
            min = i;

            for (int j = i + 1; j < candidatos.length; j++){
                if (candidatosToNumber[min] > candidatosToNumber[j]){
                    min = j;
                }
            }

            Candidato temp = candidatos[i];
            candidatos[i] = candidatos[min];
            candidatos[min] = temp;

            int tempNumber = candidatosToNumber[i];
            candidatosToNumber[i] = candidatosToNumber[min];
            candidatosToNumber[min] = tempNumber;
        }

    }


    public static void ordenaCandidatosPorVotos(Candidato[] candidatos) {

        for (int i = 0; i < candidatos.length - 1; i++) {
            int i1 = i;
            int i2 = i+1;
            while((i1 > -1 && i2 < candidatos.length) && candidatos[i2].getIntencoesVotos() > candidatos[i1].getIntencoesVotos()){
                Candidato temp = candidatos[i1];
                candidatos[i1] = candidatos[i2];
                candidatos[i2] = temp;

                i1--;
                i2--;
            }
        }
    }


    public static void ordenaCandidatosPorNome(Candidato[] candidatos) {

        char[] lettersToCompare = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        int[] candidatosToNumber = new int[candidatos.length];

        String nomeToUpperCase;
        char[] nomeToChar;

        for(int i = 0; i < candidatos.length; i++){
            nomeToUpperCase = candidatos[i].getNome().toUpperCase();
            nomeToChar = nomeToUpperCase.toCharArray();

            for (int j = 0; j < lettersToCompare.length; j++)
                if (nomeToChar[0] == lettersToCompare[j]){
                    candidatosToNumber[i] = j;
                    break;
                }
        }


        int min;

        for (int i = 0; i < candidatos.length; i++){
            min = i;

            for (int j = i + 1; j < candidatos.length; j++){
                if (candidatosToNumber[min] > candidatosToNumber[j]){
                    min = j;
                }
            }

            Candidato temp = candidatos[i];
            candidatos[i] = candidatos[min];
            candidatos[min] = temp;

            int tempNumber = candidatosToNumber[i];
            candidatosToNumber[i] = candidatosToNumber[min];
            candidatosToNumber[min] = tempNumber;
        }


    }


    public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome){

        char[] lettersToCompare = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        int inf = 0;
        int sup = candidatos.length-1;
        int med = (int)((sup+inf)/2);

        char nomeLetter = nome.toUpperCase().charAt(0);
        int nomeLetterPosition = 0;

        char medLetter;
        int medLetterPosition = 0;

        for(int i = 0; i < lettersToCompare.length; i++){
            if (nomeLetter == lettersToCompare[i]){
                nomeLetterPosition = i;
                break;
            }
        }

        while(med>=inf){

            medLetter = candidatos[med].getNome().toUpperCase().charAt(0);

            for(int i = 0; i < lettersToCompare.length; i++){
                if (medLetter == lettersToCompare[i]){
                    medLetterPosition = i;
                    break;
                }
            }


            if (candidatos[med].getNome().equals(nome)) return med;

            else if (nomeLetterPosition < medLetterPosition) sup = med-1;

            else inf = med+1;

            med = (int)(sup+inf)/2;


        }


        return -1;
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int length = (int) ((Math.random() * 100) + 1);

        Candidato[] candidatos = new Candidato[length];


        for (int i = 0; i < candidatos.length; i++) {
            String nome;
            String partido;
            int intencoesVotos = (int) (Math.random() * 10000);

            if (intencoesVotos >= 0 && intencoesVotos <= 1000) nome = "Jotaro";
            else if (intencoesVotos > 1000 && intencoesVotos <= 2000) nome = "Hinoa";
            else if (intencoesVotos > 2000 && intencoesVotos <= 3000) nome = "Marcy";
            else if (intencoesVotos > 3000 && intencoesVotos <= 4000) nome = "Luffy";
            else if (intencoesVotos > 4000 && intencoesVotos <= 5000) nome = "Akami";
            else if (intencoesVotos > 5000 && intencoesVotos <= 6000) nome = "Ichigo";
            else if (intencoesVotos > 6000 && intencoesVotos <= 7000) nome = "Nami";
            else if (intencoesVotos > 7000 && intencoesVotos <= 8000) nome = "Ryuko";
            else if (intencoesVotos > 8000 && intencoesVotos <= 9000) nome = "Zoro";
            else nome = "Himawari";

            if (intencoesVotos % 2 == 0) partido = "PDT";
            else if (intencoesVotos % 3 == 0) partido = "DEM";
            else partido = "MDB";

            candidatos[i] = new Candidato(nome, partido, intencoesVotos);
        }

        ordenaCandidatosPorPartido(candidatos);
        ordenaCandidatosPorVotos(candidatos);
        ordenaCandidatosPorNome(candidatos);


        for (Candidato candidato : candidatos)
            System.out.println(candidato);



        System.out.println("\nDigite o nome do candidato a ser buscado: ");
        String nome = input.nextLine();

        while (nome.isEmpty()) {
            System.out.println("\nERRO: Nome inválido! \nDigite o nome do candidato a ser buscado novamente: ");
            nome = null;
            nome = input.nextLine();
        }

        input.close();

        int index = pesquisaBinariaCandidatos(candidatos, nome);

        System.out.println(index != -1 ? candidatos[index] : "\n Nome não existente. \nTente verificar o nome digitado (como letras maiúsculas e minúsculas), pois não há alguém com esse nome entre os candidatos!");
    }

}
