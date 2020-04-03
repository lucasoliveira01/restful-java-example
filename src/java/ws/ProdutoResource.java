/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Cliente;
import model.DAO;
import model.Produto;

/**
 *
 * @author Lucas
 */
@Path("produto")
public class ProdutoResource {

    private DAO dao;

    public ProdutoResource() throws ClassNotFoundException, SQLException {
        dao = new DAO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insereProduto(String json) throws SQLException {
        Gson gson = new Gson();
        Produto p = gson.fromJson(json, Produto.class);
        dao.inserirProduto(p);
    }

    @GET
    public String retornaProdutos(String json) throws SQLException {
        ArrayList<Produto> produtos = dao.buscaProdutos();
        Gson gson = new Gson();
        return gson.toJson(produtos);
    }

    @DELETE
    @Path("/{id}")
    public void deletaProduto(final @PathParam("id") int id) throws SQLException {
        dao.deletarProduto(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizaProduto(String json, final @PathParam("id") int id) throws SQLException {
        Gson gson = new Gson();
        Produto p = gson.fromJson(json, Produto.class);
        dao.atualizaProduto(p, id);
    }
}
