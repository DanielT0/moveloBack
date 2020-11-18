package com.movelo.moveloapp.models.db;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.movelo.moveloapp.models.Arbol;
import com.movelo.moveloapp.models.Biciusuario;

@Entity
@Table(name = "arbol_biciusuario")
public class ArbolBiciusuario {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "arbol_id")
    private Arbol arbol;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    private Biciusuario usuario;

    public ArbolBiciusuario(Arbol arbol, Biciusuario usuario) {
        this.arbol = arbol;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Arbol getArbol() {
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    public Biciusuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Biciusuario usuario) {
        this.usuario = usuario;
    }

    public ArbolBiciusuario() {
    }

}
