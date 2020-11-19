package com.movelo.moveloapp.services;

import java.util.List;

import com.movelo.moveloapp.models.Arbol;
import com.movelo.moveloapp.models.Biciusuario;
import com.movelo.moveloapp.models.Usuario;
import com.movelo.moveloapp.models.db.ArbolBiciusuario;

public interface ArbolService {

    public Arbol getArbol(Double precio);

    public List<Arbol> getArbolesUsuario(Biciusuario usuario);

    public List<Arbol> getTodosArboles();

    public ArbolBiciusuario anadirArbol(ArbolBiciusuario arbolUsuario);
}
