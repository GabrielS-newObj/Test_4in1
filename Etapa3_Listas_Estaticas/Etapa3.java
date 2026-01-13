package Etapa3_Listas_Estaticas;

public class Etapa3 {


    public boolean checkBrackets(Stack<Character> s1){

        char symbol;

        int openedBrackets = 0;
        int closedBrackets = 0;


        while (!s1.isEmpty()){
            symbol = s1.pop();

            if (symbol == '(') {
                if (openedBrackets == closedBrackets - 1) openedBrackets--;

                openedBrackets++;
            }
            else if (symbol == ')') {
                if (openedBrackets <= closedBrackets) openedBrackets--;

                closedBrackets++;
            }

            if (closedBrackets > openedBrackets) return false;

        }

        return openedBrackets == closedBrackets;
    }



}
