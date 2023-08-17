package br.com.fiap.domain.view;

import br.com.fiap.domain.entity.Deposito;
import br.com.fiap.domain.entity.Produto;
import br.com.fiap.domain.entity.ProdutoEstocado;
import br.com.fiap.domain.repository.DepositoRepository;
import br.com.fiap.domain.repository.ProdutoRepository;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProdutoEstocadoView {
    List<Produto> produtos = new ArrayList<>();
    List<Deposito> depositos = new ArrayList<>();
    List<ProdutoEstocado> produtosEstocados = new ArrayList<>();

    public List<ProdutoEstocado> formEstocar() {
        produtos = ProdutoRepository.findAll();
        depositos = DepositoRepository.findAll();
        if (produtos.size() > 0 && depositos.size() > 0) {
            Produto produto = (Produto) JOptionPane.showInputDialog( null, "Escolha o produto", "Seleção de Produtos", JOptionPane.QUESTION_MESSAGE, null, produtos.toArray(), produtos.get( 0 ) );
            if (Objects.isNull( produto )) return produtosEstocados;

            Deposito deposito = (Deposito) JOptionPane.showInputDialog( null, "Escolha o depósito", "Seleção de Depósitos", JOptionPane.QUESTION_MESSAGE, null, depositos.toArray(), depositos.get( 0 ) );
            if (Objects.isNull( deposito )) return produtosEstocados;

            Integer quantidade = 0;
            do {
                quantidade = Integer.valueOf( JOptionPane.showInputDialog( "Informe a quantidade de Itens do produto " + produto.getNome() + " que deseja encaminhar para o estoque" ) );
            } while (quantidade <= 0);

        } else {
            JOptionPane.showMessageDialog( null, "Não é possível estocar. Verifique se existem produtos e depósitos disponíveis " );
        }
        return produtosEstocados;
    }

}