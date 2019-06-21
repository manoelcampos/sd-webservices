package com.manoelcampos.server.rest;

import com.manoelcampos.server.dao.DAO;
import com.manoelcampos.server.model.Usuario;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuario")
@Transactional
public class UsuarioResource {
    @Inject 
    private DAO<Usuario> dao;
    
    /**
     * Um método de exemplo que recebe o nome de uma pessoa e diz olá pra ela.
     * @param name Nome da pessoa
     * @return uma mensagem de olá
     */
    @GET
    @Path("hello/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("name") String name) {
        return "Hello " + name;
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario findById(@PathParam("id") long id) {
        if(true){
            Usuario usuario = new Usuario();
            usuario.setNome("2");
            return usuario;
        }
        
        Usuario usuario = dao.findById(id);
        if(usuario == null){
            //Se o objeto não for encontrado no BD, retorna código HTTP 404: página não encontrada.
            throw new WebApplicationException(Response.Status.NOT_FOUND);        
        }
        
        return usuario;
    }

    @GET
    @Path("cpf/{cpf : \\d{11}}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario findByCpf(@PathParam("cpf") String cpf) {
        Usuario usuario = dao.findByField("cpf", cpf);
        if(usuario == null){
            //Se o objeto não for encontrado no BD, retorna código HTTP 404: página não encontrada.
            throw new WebApplicationException(Response.Status.NOT_FOUND);        
        }
        
        return usuario;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public long insert(Usuario usuario) {
        return dao.save(usuario);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean update(Usuario usuario) {
        return dao.save(usuario) > 0;
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") long id) {
        Usuario usuario = dao.findById(id);
        if(usuario == null){
            //Se o objeto não for encontrado no BD, retorna código HTTP 404: página não encontrada.
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return dao.delete(usuario);
    }
    
    
}
