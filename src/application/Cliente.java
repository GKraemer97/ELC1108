package application;

import facade.AppFacade;

/**
* @author Guilherme Kraemer
*\file Cliente.java
*
*Classe de demonstração do sistema
*/

/**
* @author Guilherme Kraemer
* @class public class Cliente
* @brief Classe implementa a execução do sistema
*/

public class Cliente {

    /**
	 * @brief Método main, inicialização e interface de usuário pelo console
	 * @param args
	 * @return void
	 */
    public static void main(String[] args) {

        AppFacade facade = new AppFacade();
        int flag = 1;

        System.out.println("\nBem-vindo ao FoodChampions!\n");
        System.out.println("App de pedido de comida oficial da Copa do Mundo FIFA!\n");

        facade.inicializarSubsistemas();

        while(flag == 1){

            System.out.println("Para visualizar restaurantes e cardápios, digite 1.\n");
            System.out.println("Para efetuar um pedido, digite 2.\n");
            System.out.println("Para sair do app, digite 3.\n");

            String temp = Leitor.lerString();

            if(temp.equals("1")){
                facade.mostrarCardapios();

                System.out.println("\nPara efetuar um pedido, digite 2.\n");
                System.out.println("Para voltar ao menu principal, digite 3.\n");

                temp = Leitor.lerString();
                
                if(temp.equals("3")){
                    temp = String.valueOf(4); //para não cair fora do while
                }
            }
            if(temp.equals("2")){

                System.out.println("Digite o nome do prato escolhido, conforme consta no cardápio\n");
                String temp2 = Leitor.lerString();
                
                int function_return = 0;

                function_return = facade.executarPedido(temp2);

                if(function_return == 0){
                    facade.atenderPedidos();
                }
            }
            if(temp.equals("3")){
                flag = 0; //encerra o programa
            }

        }
        System.out.println("Volte sempre!\n");
    }
}