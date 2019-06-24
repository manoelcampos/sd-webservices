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
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    @Inject 
    private DAO<Usuario> dao;
    
    @GET
    @Path("{id}")
    public Usuario findById(@PathParam("id") long id) {
        Usuario usuario = dao.findById(id);
        if(usuario == null){
            //Se o objeto não for encontrado no BD, retorna código HTTP 404: página não encontrada.
            throw new WebApplicationException(Response.Status.NOT_FOUND);        
        }
        
        return usuario;
    }

    @GET
    @Path("cpf/{cpf : \\d{11}}")
    public Usuario findByCpf(@PathParam("cpf") String cpf) {
        Usuario usuario = dao.findByField("cpf", cpf);
        if(usuario == null){
            //Se o objeto não for encontrado no BD, retorna código HTTP 404: página não encontrada.
            throw new WebApplicationException(Response.Status.NOT_FOUND);        
        }
        
        return usuario;
    }
    
    @POST
    public long insert(Usuario usuario) {
        return dao.save(usuario);
    }
    
    @PUT
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
