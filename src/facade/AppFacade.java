package facade;

import application.Leitor;

/**
* @author Guilherme Kraemer
*\file AppFacade.java
*
* Classe que representa uma fachada para o sistema, abstraindo o funcionamento  
* 
*/

/**
* @author Guilherme Kraemer
* @class public class AppFacade
* @brief Implementa métodos para inicializar os subsistemas e acessar os serviços
* dos restaurantes 
*/

public class AppFacade {
    /**
	 * @var pagamentos - fachada para o subsistema de pagamentos
     * @var restaurantes - fachada para o subsistema de restaurantes
	 */
    protected SistemaDePagamentos pagamentos;
    protected SistemaDeRestaurantes restaurantes;

    /**
	 * @brief Método usado para inicializar os subsistemas
	 * @param void
	 * @return void
	 */
    public void inicializarSubsistemas(){

        pagamentos = new SistemaDePagamentos();
        pagamentos.configurarPagamentos();

        restaurantes = new SistemaDeRestaurantes();
        restaurantes.criarCardapios();
        restaurantes.abrirRestaurantes();
        
    }

    /**
	 * @brief Método que acessa o subsistema de restaurantes para mostrar os cardápios
	 * @param void
	 * @return void
	 */
    public void mostrarCardapios(){
        restaurantes.mostrarCardapios();
    }

    /**
	 * @brief Método usado para definir modo de pagamento, acessar subsistema e efetuar pedido
	 * @param void
	 * @return int - (0 = sucesso) - (1 = falha)
	 */
    public int executarPedido(String nomePrato){
        int flag = 0;

        while(flag == 0){

            System.out.println("Escolha e digite o modo de pagamento: Credito, Debito ou Dinheiro\n");
            String temp = Leitor.lerString();

            if(temp.equals("Credito")){
                flag = 1;
                return restaurantes.executarPedido(nomePrato, pagamentos.getCredito());
            }
            else if(temp.equals("Debito")){
                flag = 1;
                return restaurantes.executarPedido(nomePrato, pagamentos.getDebito());
            }
            else if(temp.equals("Dinheiro")){
                flag = 1;
                return restaurantes.executarPedido(nomePrato, pagamentos.getDinheiro());
            }
            else {
                System.out.println("Método de pagamento inválido, tente novamente!\n");
            }
        }
        return 1;
    }

    /**
	 * @brief Método usado para avançar os estágios dos pedidos, 
     * alterando a variável do tipo EstadoPedido
	 * @param void
	 * @return void
	 */
    public void atenderPedidos(){
        while(restaurantes.r1.getPedidos().size() > 0){  // while não aceitou operador OR ||
            restaurantes.atenderPedidos();
        }
        while(restaurantes.r2.getPedidos().size() > 0){
            restaurantes.atenderPedidos();
        }
    }
}
