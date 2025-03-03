package application;

import java.util.Scanner;

/**
* @author Guilherme Kraemer
*\file Leitor.java
*
*Classe responsável pela entrada de dados no sistema
*/

/**
* @author Guilherme Kraemer
*@class public class Leitor
*@brief Classe implementa métodos para entrada de dados com tratamento de exceções
*/

public class Leitor {
    /**
	 * @var input - instancia da classe Scanner, usada para entrada de dados
	 */
    public static Scanner input;
    
    /**
	 * @brief Método usado para retornar int de uma leitura de String, 
     * pois nextInt() não estava funcionando como esperado
	 * @param void
	 * @return int
	 */

    public static int lerInt() {

        input = new Scanner(System.in);

        while (true) {
            try {
                return Integer.parseInt(input.next());
            }
            catch (java.util.InputMismatchException e){
                if(input.hasNext()){
                    System.out.println("3");
                    input.next();
                } 
            }
            catch(java.util.NoSuchElementException e){
                if(input.hasNext()){
                    System.out.println("4");
                    input.next();
                }
            }
        }
    }

    /**
	 * @brief Método usado para leitura de Strings, com tratamento de exceções
	 * @param void
	 * @return String
	 */

    public static String lerString() {

        input = new Scanner(System.in);

        while (true) {
            try {
                return input.next();
            }
            catch (java.util.InputMismatchException e){
                if(input.hasNext()){
                    System.out.println("1");
                    input.next();
                } 
                
            }
            catch(java.util.NoSuchElementException e){
                if(input.hasNext()){
                    System.out.println("2");
                    input.next();
                }
            }
        }
    }

    /**
	 * @brief Método usado para limpeza do buffer de entrada, se necessário
	 * @param void
	 * @return void
	 */

    public static void clearBuffer() {
        if(input.hasNextLine()) {
            input.nextLine();
        }
    }

}
