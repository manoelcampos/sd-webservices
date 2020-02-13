package com.manoelcampos.server.rest;

import com.manoelcampos.server.model.Cliente;
import com.manoelcampos.server.model.Endereco;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cliente")
@Transactional
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {
        
    @GET
    @Path("{id}")
    public Cliente findById(@PathParam("id") long id) {
        /*Como a classe Cliente tem um atributo List<Endereco>
        e precisamos que tais endereços sejam carregados ao fazer o acesso
        ao serviço REST, a melhor prática é fazer um join para buscar
        tais endereços e evitar o erro LazyInitializationException.
        https://vladmihalcea.com/the-best-way-to-handle-the-lazyinitializationexception/.
        Observe que é usado um left join para, caso o cliente não tenha endereços,
        ele seja retornado assim mesmo.
        */
        String jpql = "select c from Cliente c left join fetch c.enderecos where c.id = ?1";
        Cliente cliente = Cliente.find(jpql, id).firstResult();
        if(cliente == null){
            //Se o objeto não for encontrado no BD, retorna código HTTP 404: página não encontrada.
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        /* Como existe um relacionamento bi-direcional entre Cliente e Endereco,
        quando a biblioteca JAX-RS for converter um objeto Cliente para JSON,
        vai ocorrer loop infinito.
        Para evitar isso, a forma mais fácil é apagar o cliente de dentro do endereço.
        Como estamos fazendo isso apenas nos objetos em memória, isto não afeta o cadastro.
        As anotações @JsonIgnoreProperties e @JsonIgnore da biblioteca Jackson
        (no Quarkus: quarkus-resteasy-jackson) deveriam funcionar, mas não estão.
         */
        for (Endereco endereco : cliente.enderecos) {
            endereco.cliente = null;
        }

        return cliente;
    }

    @POST
    public long insert(Cliente cliente) {
        Cliente.persist(cliente);
        return cliente.id;
    }
    
    @PUT
    public boolean update(Cliente cliente) {
        if(Cliente.update(cliente))
            return true;

        //Se o objeto não for encontrado no BD, retorna código HTTP 404: página não encontrada.
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") long id) {
        Cliente cliente = Cliente.findById(id);
        if(cliente == null){
            //Se o objeto não for encontrado no BD, retorna código HTTP 404: página não encontrada.
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        cliente.delete();
        return true;
    }
    
    
}
