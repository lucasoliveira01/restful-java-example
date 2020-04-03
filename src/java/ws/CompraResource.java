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
import model.Compra;
import model.DAO;

/**
 *
 * @author Lucas
 */
@Path("compra")
public class CompraResource {

    private DAO dao;

    public CompraResource() throws ClassNotFoundException, SQLException {
        dao = new DAO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insereCompra(String json) throws SQLException {
        Gson gson = new Gson();
        Compra c = gson.fromJson(json, Compra.class);
        dao.inserirCompra(c);
    }

    @GET
    public String retornaCompras(String json) throws SQLException {
        ArrayList<Compra> compras = dao.buscaCompras();
        Gson gson = new Gson();
        return gson.toJson(compras);
    }

    @DELETE
    @Path("/{id}")
    public void deletaCompra(final @PathParam("id") int id) throws SQLException {
        dao.deletarCompra(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizaCompra(String json, final @PathParam("id") int id) throws SQLException {
        Gson gson = new Gson();
        Compra c = gson.fromJson(json, Compra.class);
        dao.atualizaCompra(c, id);
    }
}
