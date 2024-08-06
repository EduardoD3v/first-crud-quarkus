package edu4rdo.projects;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;


@Entity
public class Produto extends PanacheEntity {
    public String nome;
    public String descricao;
    public BigDecimal valor;

    @CreationTimestamp
    public Date dataCriação;
    @UpdateTimestamp
    public Date dataAtualizacao;
}
