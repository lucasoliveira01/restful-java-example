package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {

    private final Connection con;

    public DAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "");
    }
    
    //---------------------CLIENTE---------------------

    public void inserirCliente(Cliente c) throws SQLException {
        String sql = "insert into cliente (Usuario, Senha) values ('" + c.getUsuario() + "', '" + c.getSenha() + "')";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }

    public ArrayList<Cliente> buscaClientes() throws SQLException {

        ArrayList<Cliente> list = new ArrayList<Cliente>();

        String sql = "select * from cliente";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Cliente c = new Cliente();
            c.setId(rs.getInt("Id"));
            c.setUsuario(rs.getString("Usuario"));
            c.setSenha(rs.getString("Senha"));
            list.add(c);
        }

        return list;
    }

    public void deletarCliente(int id) throws SQLException {
        String sql = "delete from cliente where id = " + id;
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }

    public void atualizaCliente(Cliente c, int id) throws SQLException {
        String sql = "update cliente set usuario = '" + c.getUsuario() + "' , senha = '" + c.getSenha() + "' where id = " + id;
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }
    
    //---------------------PRODUTO---------------------

    public void inserirProduto(Produto p) throws SQLException {
        String sql = "insert into produto (Nome, Preco) values ('" + p.getNome()+ "', " + p.getPreco() + ")";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }

    public ArrayList<Produto> buscaProdutos() throws SQLException {
        ArrayList<Produto> list = new ArrayList<>();

        String sql = "select * from produto";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Produto p = new Produto();
            p.setCodigo(rs.getInt("Codigo"));
            p.setNome(rs.getString("Nome"));
            p.setPreco(rs.getFloat("Preco"));
            list.add(p);
        }

        return list;
    }

    public void deletarProduto(int id) throws SQLException {
        String sql = "delete from produto where codigo = " + id;
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }

    public void atualizaProduto(Produto p, int id) throws SQLException {
        String sql = "update produto set nome = '" + p.getNome() + "', preco = '" + p.getPreco() + "' where codigo = " + id;
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }
    
    //---------------------COMPRA---------------------   
        

    public void inserirCompra(Compra c) throws SQLException {
        String sql = "insert into compra (Id, Codigo, Quantidade) values ('" + c.getId()+ "', " + c.getCodigo()+ "," + c.getQuantidade() + ")";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }

    public ArrayList<Compra> buscaCompras() throws SQLException {
        ArrayList<Compra> list = new ArrayList<>();

        String sql = "select * from compra";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Compra c = new Compra();
            c.setId_compra(rs.getInt("IdCompra"));
            c.setCodigo(rs.getInt("Codigo"));
            c.setId(rs.getInt("Id"));
            c.setQuantidade(rs.getInt("Quantidade"));
            list.add(c);
        }

        return list;
    }

    public void deletarCompra(int id) throws SQLException {
        String sql = "delete from compra where IdCompra = " + id;
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }

    public void atualizaCompra(Compra c, int id) throws SQLException {
        String sql = "update compra set id = " + c.getId()+ ", codigo = " + c.getCodigo() + ", quantidade = " + c.getQuantidade()+ " where IdCompra = " + id;
        PreparedStatement stm = con.prepareStatement(sql);
        stm.execute();
    }

}
