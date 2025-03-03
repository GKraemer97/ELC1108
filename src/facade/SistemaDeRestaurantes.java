package facade;

import java.util.LinkedList;
import bridge.Cardapio;
import bridge.CardapioGaucho;
import bridge.CardapioTexano;
import bridge.Restaurante;
import bridge.RestauranteBr;
import bridge.RestauranteEua;
import command.PagamentoCommand;
import state.EstadoPedido;
import state.Pedido;
import state.PedidoCriado;
import state.PedidoEntregue;
import state.PedidoPago;
import state.PedidoPronto;

/**
* @author Guilherme Kraemer
*\file SistemaDeRestaurantes.java
*
* Classe que representa uma fachada para o subsistema de restaurantes
* 
*/

/**
* @author Guilherme Kraemer
* @class public class SistemaDeRestaurantes
* @brief Implementa métodos de fachada para acessar serviços dos restaurantes,
* delegando o trabalho aos restaurantes quando possível
*/

public class SistemaDeRestaurantes {
    /**
	 * @var c1 - cardapio para um restaurante
     * @var c2 - cardapio para um restaurante
     * @var r1 - instância de um restaurante
     * @var r2 - instância de um restaurante
	 */
    protected Cardapio c1, c2;
    protected Restaurante r1, r2;

    public SistemaDeRestaurantes() {
    }

    /**
	 * @brief Método usado para criar e adicionar itens aos cardápios
	 * @param void
	 * @return void
	 */
    public void criarCardapios(){
        c1 = new CardapioGaucho();
        c1.adicionarItem("Carreteiro", 15);
        c1.adicionarItem("Galinhada", 12);
        c1.adicionarItem("Churrasco", 20);
        c1.adicionarItem("Cachaça", 8);

        c2 = new CardapioTexano();
        c2.adicionarItem("Chili", 15);
        c2.adicionarItem("Bife", 20);
        c2.adicionarItem("Tacos", 8);
        c2.adicionarItem("Cerveja", 6);
    }

    /**
	 * @brief Método usado para criar os restaurantes
	 * @param void
	 * @return void
	 */
    public void abrirRestaurantes(){
        r1 = new RestauranteBr("Fogo de Chao", c1, new LinkedList<Pedido>());
        r2 = new RestauranteEua("Steak Palace", c2, new LinkedList<Pedido>());
    }

    /**
	 * @brief Método usado para mostrar cardápios, delegando o trabalho aos próprios restaurantes
	 * @param void
	 * @return void
	 */
    public void mostrarCardapios(){
        System.out.println("\n" + r1.nome + " (Restaurante brasileiro)");
        r1.mostrarCardapio();

        System.out.println("\n" + r2.nome + " (Restaurante americano)");
        r2.mostrarCardapio();
    }

    /**
	 * @brief Método usado para executar pedidos, verificando primeiro o prato pedido
     * consta no cardápio
	 * @param void
	 * @return int
	 */
    public int executarPedido(String nomePrato, PagamentoCommand formaDePagamento) {
        int flag = 0;

        for(int i = 0; i < c1.tamanhoCardapio(); i++){
            if(nomePrato.equals(c1.getProdutos(i).nome)){
                r1.executarPedido(nomePrato, c1.getProdutos(i).preco, formaDePagamento);
                flag = 1;
                return 0;
            }
        }

        for(int i = 0; i < c2.tamanhoCardapio(); i++){
            if(nomePrato.equals(c2.getProdutos(i).nome)){
                r2.executarPedido(nomePrato, c2.getProdutos(i).preco, formaDePagamento);
                flag = 1;
                return 0;
            }
        }

        if(flag == 0){
            System.out.println(nomePrato + " não consta em nenhum cardápio, escolha novamente!\n");
        }
        return 1; 

    }

    /**
	 * @brief Método usado para avançar estágios dos pedidos. A fundo, sempre faz a chamada de um
     * método da classe Pedido ( estado = estado.fazerAlgo() ), de acordo com o estado atual(EstadoPedido)
     * do pedido
	 * @param void
	 * @return void
	 */
    public void atenderPedidos(){

        if(r1.getPedidos().size() > 0){

            //verifica em que estado se encontra o pedido atualmente
            EstadoPedido e1 = r1.getPedidos().peekLast().getEstado();

            if(e1 instanceof PedidoCriado){
                //prepara o pedido
                r1.getPedidos().peekLast().prepararPedido();
            }

            else if(e1 instanceof PedidoPronto){
                //entrega o pedido
                r1.getPedidos().peekLast().entregarPedido();
            }

            else if(e1 instanceof PedidoEntregue){
                //cobra o pagamento do pedido
                r1.getPedidos().peekLast().receberPagamento();
            }

            else if(e1 instanceof PedidoPago){
                //conclui o pedido removendo-o da fila
                r1.getPedidos().removeLast();
            }
            else{
                //System.out.println("Caí aqui\n"); debug
            }
        }

        if(r2.getPedidos().size() > 0){

            EstadoPedido e2 = r2.getPedidos().peekLast().getEstado();

            if(e2 instanceof PedidoCriado){
                //prepara o pedido
                r2.getPedidos().peekLast().prepararPedido();
            }

            else if(e2 instanceof PedidoPronto){
                //entrega o pedido
                r2.getPedidos().peekLast().entregarPedido();
            }

            else if(e2 instanceof PedidoEntregue){
                //cobra o pagamento do pedido
                r2.getPedidos().peekLast().receberPagamento();
            }
        
            else if(e2 instanceof PedidoPago){
                //conclui o pedido removendo-o da fila
                r2.getPedidos().removeLast();
            }
            else {
                //System.out.println("Caí aqui\n"); debug
            }
        }
    }
}
