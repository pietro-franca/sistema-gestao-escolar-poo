/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unesp.persistencia;

import br.unesp.model.Escola;

/**
 *
 * @author Pietro
 */
public interface IPersistencia {
    Escola carregar(String caminho);
    void salvar(Escola escola, String caminho);
}

