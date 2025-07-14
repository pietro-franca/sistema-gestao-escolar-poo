/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.model.interfaces;

import br.unesp.model.AtividadeAvaliativa;

/**
 *
 * @author Pietro
 */
public interface Avaliador 
{    
    public void adicionarAvaliacao(AtividadeAvaliativa avaliacao); //POLIMORFISMO DINÂMICO (SOBRESCRITA DE MÉTODOS)
    public void corrigirAvaliacao(Avaliavel aluno, AtividadeAvaliativa avaliacao, double nota);
}
