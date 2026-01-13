package Etapa1_ArraysBidimensionais_Arquivos_Recursao;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Labirinto {

    private char[][] labirinto = new char[18][8];


    public void criaLabirinto(String filename){

        String compactFile = "";

        try(BufferedReader buffer = new BufferedReader(new FileReader("/"+filename))){

            String line;

            do{
                line = buffer.readLine();
                compactFile += line;
            }while (line != null);

        }catch(FileNotFoundException fn){
            System.out.println("ERROR: File not found");
            fn.printStackTrace();

        }catch(IOException io){
            System.out.println("ERROR: I/O exception");
            io.printStackTrace();
        }

        String[] clearedFile = compactFile.split(",");

        compactFile = "";

        for (String letter : clearedFile)
            compactFile += letter;

        char[] fileToFill = compactFile.toCharArray();

        int cont = 0;
        for (int i = 0; i < labirinto[0].length; i++)
            for (int j = 0; j < labirinto.length; j++){
                labirinto[j][i] = fileToFill[cont];
                cont++;
            }

    }

    public boolean percorreLabirinto(){
        if (labirinto == null || labirinto[0] == null) System.out.println("Labirinto inválido");

        return percorreLabirinto(0,0,0,0);
    }

    private boolean percorreLabirinto(int posHor, int posVer, int lastPosHor, int lastPosVer){

        boolean isVerUp = ((posVer - 1) > - 1) && ((posVer - 1) != lastPosVer);
        boolean isVerDown = ((posVer + 1) < labirinto[0].length) && ((posVer + 1) != lastPosVer);
        boolean isHorLeft = ((posHor - 1) > - 1) && ((posHor - 1) != lastPosHor);
        boolean isHorRight = ((posHor + 1) < labirinto.length) && ((posHor + 1) != lastPosHor);

        if (isVerUp && (labirinto[posHor][posVer - 1] == 'D')) return true;
        if (isVerDown && (labirinto[posHor][posVer + 1] == 'D')) return true;
        if (isHorLeft && (labirinto[posHor - 1][posVer] == 'D')) return true;
        if (isHorRight && (labirinto[posHor + 1][posVer] == 'D')) return true;


        if (isVerUp && (labirinto[posHor][posVer - 1] == ' ') && (percorreLabirinto(posHor, posVer-1, posHor, posVer))) return true;
        else if (isVerDown && (labirinto[posHor][posVer + 1] == ' ') && (percorreLabirinto(posHor, posVer+1, posHor, posVer))) return true;
        else if (isHorLeft && (labirinto[posHor - 1][posVer] == ' ') && (percorreLabirinto(posHor-1, posVer, posHor, posVer))) return true;
        else if (isHorRight && (labirinto[posHor + 1][posVer] == ' ') && (percorreLabirinto(posHor+1, posVer, posHor, posVer))) return true;

        return false;
    }

}
