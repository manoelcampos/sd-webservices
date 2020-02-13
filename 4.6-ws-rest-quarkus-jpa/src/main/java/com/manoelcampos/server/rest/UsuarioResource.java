package com.manoelcampos.server.rest;

import com.manoelcampos.server.model.Cliente;
import com.manoelcampos.server.model.Usuario;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuario")
@Transactional
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    @GET
    @Path("{id}")
    public Usuario findById(@PathParam("id") long id) {
        Usuario usuario = Usuario.findById(id);
        if(usuario == null){
            //Se o objeto não for encontrado no BD, retorna código HTTP 404: página não encontrada.
            throw new WebApplicationException(Response.Status.NOT_FOUND);        
        }
        
        return usuario;
    }

    @GET
    @Path("cpf/{cpf : \\d{11}}")
    public Usuario findByCpf(@PathParam("cpf") String cpf) {
        Usuario usuario = Usuario.find("cpf", cpf).firstResult();
        if(usuario == null){
            //Se o objeto não for encontrado no BD, retorna código HTTP 404: página não encontrada.
            throw new WebApplicationException(Response.Status.NOT_FOUND);        
        }
        
        return usuario;
    }
    
    @POST
    public long insert(Usuario usuario) {
        Usuario.persist(usuario);
        return usuario.id;
    }
    
    @PUT
    public boolean update(Usuario usuario) {
        if(Usuario.update(usuario))
            return true;

        //Se o objeto não for encontrado no BD, retorna código HTTP 404: página não encontrada.
        throw new WebApplicationException(Response.Status.NOT_FOUND);    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") long id) {
        Usuario usuario = Usuario.findById(id);
        if(usuario == null){
            //Se o objeto não for encontrado no BD, retorna código HTTP 404: página não encontrada.
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        usuario.delete();
        return true;
    }
}
