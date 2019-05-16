package gui.uteis;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


/**
* A interface {@link TableModel} define 9 métodos, sendo que 2 deles cuidam da
* parte de listeners. Esses dois métodos (addTableModelListener e
* removeTableModelListener) nós delegaremos para a classe
* {@link AbstractTableModel}. Os outros 7 nós implementaremos. Uma pequena
* explicação de cada um deles (para mais detalhes, consulte a documentação):<br>
* <ul>
* <li>getColumnClass: retorna a classe de determinada coluna. Útil para os
* renderers saberem como exibir determinada informação.</li>
* <li>getColumnCount: retorna o número de colunas que nossa tabela terá
* (geralmente é o número de atributos do objeto que será exibido).</li>
* <li>getColumnName: retorna o nome da coluna. Será usado no cabeçalho da
* tabela.</li>
* <li>getRowCount: retorna o número de registros. Geralmente é a quantidade de
* elementos que há em nossa lista.</li>
* <li>getValueAt: retorna o valor que está contido em determinada célula. Para
* resgatarmos esse valor, primeiro pegamos o objeto da linha e depois, a partir
* do número da coluna, retornamos uma de suas propriedades.</li>
* <li>isCellEditable: informa se determinada célula pode ser editada ou não.</li>
* <li>setValueAt: é chamado quanto o valor de determinada célula é alterada.
* Devemos modificar nosso objeto para refletir essa mudança.</li>
* </ul>
*/

public class ProductoTableModel{}

//public class ProductoTableModel extends AbstractTableModel {
//
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * Essa lista armazenará os objetos do tipo {@link Cliente} atualmente
//     * exibidos na tablela.
//     */
//    private List<ProdutoTable> listaProdutos;
//    private Connection conexao;
//    // ==============================================================
//    // Construtores.
//    // ==============================================================
//
//    /**
//     * Constutor que simplesmente instancia o nosso {@link List} que usaremos
//     * para guardar os valores.
//     */
//    public ProductoTableModel() {
//        // no construtor, instanciamos o List
//        listaProdutos = new ArrayList<ProdutoTable>();
//    }
//
//    /**
//     * Criamos um construtor de conveniência para já popular a lista.
//     *
//     * @param lista
//     *            a lista de clientes a ser adicionada.
//     */
//    public ProductoTableModel(Connection c, List<ProdutoTable> lista) {
//        this();
//        this.conexao = c;
//        listaProdutos.addAll(lista);
//    }
//
//    // ==============================================================
//    // Métodos implementados.
//    // ==============================================================
//
//    @Override
//    public Class<?> getColumnClass(int coluna) {
//        // todas as colunas representam uma String
//        return String.class;
//    }
//
//    @Override
//    public int getColumnCount() {
//        // esse método deve retornar o número de colunas. No caso, 3 (uma para o
//        // nome, uma para o sobrenome e uma para o apelido).
//        return 8;
//    }
//
//    @Override
//    public String getColumnName(int coluna) {
//        // vamos retornar o nome de cada coluna
//        switch (coluna) {
//        case 0:
//            return "Codigo";
//        case 1:
//            return "Produto";
//        case 2:
//            return "Cantidad";
//        case 3:
//            return "Precio Lista";
//        case 4:
//            return "Precio Bruto";
//        case 5:
//            return "Desc";
//        case 6:
//            return "Imp";
//        case 7:
//            return "Total";
//        default:
//            return ""; // isso jamais deve ocorrer
//        }
//    }
//
//    @Override
//    public int getRowCount() {
//        // retorna o número de linhas, ou seja, a quantidade de entradas na
//        // nossa lista.
//        return listaProdutos.size();
//    }
//
//    @Override
//    public Object getValueAt(int linha, int coluna) {
//        // vai retornar o valor de determinada célula. A linha representa a
//        // posição do Cliente na nossa lista e a coluna vai ser: 1 - nome, 2 -
//        // sobrenome e 3 - apelido
//        // primeiro vamos pegar o Cliente da linha
//        ProdutoTable p = listaProdutos.get(linha);
//        // façamos um switch
//        switch (coluna) {
//        case 0:
//            return p.getCodigo();
//        case 1:
//            return p.getProduto();
//        case 2:
//            return p.getCant();
//        case 3:
//            return p.getPrecioLista();
//        case 4:
//            return p.getPrecioBruto();
//        case 5:
//            return p.getDesc();
//        case 6:
//            return p.getImp();
//        case 7:
//            return p.getTotal();
//        default:
//            return null;
//        }
//    }
//
//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        return false;
//    }
//
//    @Override
//    public void setValueAt(Object valor, int linha, int coluna) {
//        // aqui devemos atualizar o valor de nossos Clientes
//        // vemos em qual linha ele está
//        ProdutoTable c = listaProdutos.get(linha);
//        // e vemos o que será atualizado
//        switch (coluna) {
//        case 0:
//            c.equals(valor);
//            break;
//        }
//
//        // é importante notificar os listeners a cada alteração
//        fireTableDataChanged();
//    }
//
//    // ==============================================================
//    // Até aqui seria o mínimo necessário para um TableModel funcional, mas
//    // ainda não há métodos para adicionar, remover ou resgatar objetos. Vamos
//    // criá-los.
//    // ==============================================================
//
//    /**
//     * Adiciona um novo {@link Cliente} e notifica os listeners que um novo
//     * registro foi adicionado.
//     */
//    public void adiciona(ProdutoTable l) {
//        listaProdutos.add(l);
//        // informamos os listeners que a linha (size - 1) foi adicionada
//        fireTableRowsInserted(listaProdutos.size() - 1, listaProdutos.size() - 1);
//    }
//
//    /**
//     * Similar ao {@link #adiciona(Cliente)}, porém para remover. Recebe o
//     * índice do cliente a ser removido. Se não souber o índice, use o método
//     * {@link #getIndice(Cliente)} antes.
//     */
//    public void remove(int indice) {
//        listaProdutos.remove(indice);
//        fireTableRowsDeleted(indice, indice);
//    }
//
//    /**
//     * Retorna o índice de determinado cliente.
//     */
//    public int getIndice(Ventas c) {
//        return listaProdutos.indexOf(c);
//    }
//    /**
//     * Retorna o cliente de determinado índice.
//     */
//    public ProdutoTable getIndice(int i) {
//        return listaProdutos.get(i);
//    }
//
//    /**
//     * Adiciona todos os clientes na lista à este modelo.
//     */
//    public void adicionaLista(List<ProdutoTable> lista) {
//        int i = listaProdutos.size();
//        listaProdutos.addAll(lista);
//        fireTableRowsInserted(i, i + lista.size());
//    }
//
//    public BigDecimal getValorTotal(){
//        BigDecimal total = new BigDecimal("0");
//        for (ProdutoTable p : listaProdutos){
//            total = total.add(p.getTotal());
//        }
//        return total;
//    }
//
//    /**
//     * Esvazia a lista.
//     */
//    public void limpaLista() {
//        int i = listaProdutos.size();
//        listaProdutos.clear();
//        fireTableRowsDeleted(0, i - 1);
//    }
//
//}
