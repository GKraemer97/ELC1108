package bridge;

import java.util.LinkedList;
import command.PagamentoCommand;
import state.Pedido;

/**
* @author Guilherme Kraemer
*\file Restaurante.java
*
* Classe abstrata para representar um restaurante
*/

/**
* @author Guilherme Kraemer
* @class public abstract class Restaurante
* @brief Fornece os métodos para manipular o Cardapio fazendo a chamada através da instância cardapio,
* declara o header do método usado para gerar um novo pedido
*/

public abstract class Restaurante {
    /**
	 * @var nome - representa o nome do restaurante
     * @var cardapio - Cardapio do restaurante
     * @var pedidos - Lista que armazena os pedidos efetuados ao respectivo restaurante
	 */
    public String nome;
    public Cardapio cardapio;
    protected LinkedList<Pedido> pedidos;

    public Restaurante(String nome, Cardapio cardapio, LinkedList<Pedido> pedidos) {
        this.nome = nome;
        this.cardapio = cardapio;
        this.pedidos = pedidos;
    }

    public void mostrarCardapio(){
        cardapio.mostrarCardapio();
    }

    public void adicionarItem(String nome, int preco){
        cardapio.adicionarItem(nome, preco);
    }

    public void eliminarCardapio(){
        cardapio.eliminarCardapio();
    }

    
    public LinkedList<Pedido> getPedidos() {
        return pedidos;
    }

    public abstract void executarPedido(String nomePrato, int preco, PagamentoCommand formaDePagamento);
    
    
}
