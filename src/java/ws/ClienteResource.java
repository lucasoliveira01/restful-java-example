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
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Cliente;
import model.DAO;

/**
 *
 * @author Lucas de Oliveira da Silva
 */
@Path("cliente")
public class ClienteResource {
    private DAO dao;
            
    public ClienteResource() throws ClassNotFoundException, SQLException
    {
        dao = new DAO();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insereCliente(String json) throws SQLException
    {
        Gson gson = new Gson();
        Cliente c = gson.fromJson(json, Cliente.class);
        dao.inserirCliente(c);
    }   
    
    @GET
    public String retornaClientes(String json) throws SQLException
    {
        ArrayList<Cliente> clientes = dao.buscaClientes();
        Gson gson = new Gson();
        return gson.toJson(clientes);
    } 
    
    @DELETE
    @Path("/{id}")
    public void deletaCliente(final @PathParam("id") int id) throws SQLException
    {
        dao.deletarCliente(id);
    } 
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizaCliente(String json, final @PathParam("id") int id) throws SQLException
    {
        Gson gson = new Gson();
        Cliente c = gson.fromJson(json, Cliente.class);
        dao.atualizaCliente(c, id);
    }  
}