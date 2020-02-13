package com.manoelcampos.server.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Representa um Usuário que pode acessar o sistema.
 * Veja a classe {@link Cidade} para detalhes
 * importantíssimos de como tais classes de negócio foram modeladas.
 *
 * @author Manoel Campos da Silva Filho
 */
@Entity
public class Usuario extends PanacheEntity implements Serializable {
    public String nome;
    public String cpf;
    
    @ManyToOne
    public Cidade cidade;

    public static boolean update(Usuario usuario) {
        Usuario existente = Usuario.findById(usuario.id);
        if(existente != null){
            existente.nome = usuario.nome;
            existente.cpf = usuario.cpf;
            existente.cidade = usuario.cidade;
            existente.persist();
            return true;
        }

        return false;
    }
}
