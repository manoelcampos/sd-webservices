package com.manoelcampos.server.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um Cliente do sistema.
 * Veja a classe {@link Cidade} para detalhes
 * importantíssimos de como tais classes de negócio foram modeladas.
 *
 * @author Manoel Campos da Silva Filho
 */
@Entity
public class Cliente  extends PanacheEntity implements Serializable {
    public String nome;
    public LocalDate dataCadastro;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    public List<Endereco> enderecos;

    public Cliente(){
        enderecos = new ArrayList<>();
    }

    public void setEnderecos(final List<Endereco> enderecos) {
        for (Endereco endereco : enderecos) {
            endereco.cliente = this;
        }
        
        this.enderecos = enderecos;
    }

    public static boolean update(Cliente cliente) {
        Cliente existente = Cliente.findById(cliente.id);
        if(existente != null){
            existente.nome = cliente.nome;
            existente.dataCadastro = cliente.dataCadastro;
            existente.enderecos = cliente.enderecos;
            existente.persist();
            return true;
        }

        return false;
    }

}
