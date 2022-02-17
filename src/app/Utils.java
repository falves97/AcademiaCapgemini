package app;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Utils {
    /**
     * O métedo deve recebver um número n e imprimir uma escada contendo n linhas sendo a última
     * linha composta por n caracteres '*'
     * Ex: para n = 3, será impresso
     * '  *'
     * ' **'
     * '***'
     *
     * @param n é o número de linhas que serão impressas, sendo a última linha com 'n' caracteres '*'
     * @return str sendo a estring no formato e uma escada formatada com 'n' linhas
     * @throws IllegalArgumentException caso o valor de 'n' seja menor ou igual a 0, caso onde não se consegue fazer a escada
     */
    public static String escada(int n) throws IllegalArgumentException {
        String str = "";

        if (n <= 0) {
            throw new IllegalArgumentException("O valor de 'n' não pode ser menor que zero!");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                /*
                  Calcula com base na linha atual quantos espaços em branco deve imprimir.
                  Se n = 6 e i = 0, então enquanto j < 5, ele concatenará espaços em branco, 5 nesse caso.
                 */
                if (j < (n - i - 1)) {
                    str = str + " ";
                }
                else {
                    str = str + "*";
                }
            }

            if ((i + 1) != n){
                str = str + "\n";
            }
        }

        return str;
    }

    /**
     * Calcula quantos carteres mínimos são necessário para tornar a senha passada por parâmentro em uma senha forte.
     * Para isso ela deve conter:
     * Possui no mínimo 6 caracteres.
     * Contém no mínimo 1 digito.
     * Contém no mínimo 1 letra em minúsculo.
     * Contém no mínimo 1 letra em maiúsculo.
     * Contém no mínimo 1 caractere especial. Os caracteres especiais são: !@#$%^&*()-+
     *
     * @param senha senha que será analisada quantos caracteres faltam para ser uma senha forte
     * @return retorna o mínimo de caracteres faltantes para ser considerada uma senha forte
     */
    public static int senhaForte(String senha) {
        int sumMatch = 0;
        int tamanhoMin = 6;

        /*
          verifica se contém no mínimo 1 digito.
         */
        boolean match = Pattern.matches("(.*)(\\d+)(.*)", senha);
        if (match) {
            sumMatch++;
        }

         /*
          verifica se contém no mínimo 1 letra em minúsculo.
         */
        match = Pattern.matches("(.*)(\\p{Lower}+)(.*)", senha);
        if (match) {
            sumMatch++;
        }

        /*
          verifica se contém no mínimo 1 letra em maiúsculo.
         */
        match = Pattern.matches("(.*)(\\p{Upper}+)(.*)", senha);
        if (match) {
            sumMatch++;
        }

        /*
          verifica se contém no mínimo 1 caractere especial. Os caracteres especiais são: !@#$%^&*()-+
         */
        match = Pattern.matches("(.*)([!@#$%^&*()\\-+]+)(.*)", senha);
        if (match) {
            sumMatch++;
        }

        int minCaracrteres = 4 - sumMatch;

        /*
          verifica se possui no mínimo 6 caracteres.
         */
        if ((tamanhoMin - senha.length()) > minCaracrteres){
            minCaracrteres =  (tamanhoMin - senha.length());
        }

        return minCaracrteres;
    }

    /**
     * Recebe uma string qualquer e calcula quantos pares de substrings são anagramas uma da outra.
     * @param palavra que será verificada a quantidade de anagramas em suas substrings
     * @return um inteiro com a quantidade de pares de substring que são anagramas.
     */
    public static int anagramas(String palavra) {
        int numAnagramas = 0;
       ArrayList<String> anagramas = new ArrayList<>();

        for (int i = 0; i < palavra.length(); i++) {

            for (int j = 0; (j + i) < palavra.length(); j++) {

                for (int k = 0; (k + i) < palavra.length(); k++) {
                    String primeiraPalavra = palavra.substring(j, (j + i) + 1);
                    String segundaPalavra = palavra.substring(k, (k + i) + 1);
                    boolean contem = contemTodosOsCaracteres(primeiraPalavra, segundaPalavra);

                    if (contem && (j != k) && !anagramas.contains(primeiraPalavra)) {
                        contemTodosOsCaracteres(primeiraPalavra, segundaPalavra);
                        anagramas.add(primeiraPalavra);
                        anagramas.add(segundaPalavra);
                        numAnagramas++;
                    }
                }
            }
        }

        return numAnagramas;
    }

    /**
     * Verifica se uma string é anagrama da outra, ou seja, se todos os e de uma estão na outra,
     * sem sobra de caracteres.
     *
     * @param primeira
     * @param segunda
     * @return true se forem anagramas uma da outra e false caso contrário.
     */
    private static boolean contemTodosOsCaracteres(String primeira, String segunda) {
        for (int i = 0; i < primeira.length(); i++) {
            if (!segunda.contains(primeira.substring(i, i + 1))) {
                return false;
            }
            segunda = segunda.replace(primeira.substring(i, i + 1), "");
        }

        return true;
    }
}
