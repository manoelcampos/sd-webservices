package com.manoelcampos.server.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Representa um endereço de um cliente.
 * Veja a classe {@link Cidade} para detalhes
 * importantíssimos de como tais classes de negócio foram modeladas.
 *
 * <p>Como existe um relacionamento 1..N entre Cliente e Endereco,
 * ao acessar o serviço que obtém um cliente em formato JSON
 * ocorrer o erro StackOverflow, pois o relacionamento entre estas duas
 * classes é bi-direcional: o cliente tem uma lista de endereços e cada endereço tem
 * um objeto indicando quem é o cliente para aquele endereço.
 * Com isto, a biblioteca Jackson (implementação da API Json-P)
 * entra em loop infinito ao tentar gerar o JSON para um cliente que possui endereços.
 * Para evitar tal erro, era suposto usar a anotação @JsonIgnore do Jackson
 * no método getCliente() na classe Endereco. No entanto, isto não funcionou.
 * A única maneira foi simplesmente remover tal método e deixar apenas o setter.</p>
 * 
 * @author Manoel Campos da Silva Filho
 */
@Entity
public class Endereco  extends PanacheEntity implements Serializable {
    public String logradouro;

    @ManyToOne()
    public Cliente cliente;

    @ManyToOne
    public Cidade cidade;

    public static boolean update(Endereco endereco) {
        Endereco existente = Endereco.findById(endereco.id);
        if(existente != null){
            existente.logradouro = endereco.logradouro;
            existente.cliente = endereco.cliente;
            existente.cidade = endereco.cidade;
            existente.persist();
            return true;
        }

        return false;
    }
}
