/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unesp.model.interfaces;

import br.unesp.model.Turma;

/**
 *
 * @author Pietro
 */
public interface ParticipanteDeTurma 
{    
    public void adicionarNaTurma(Turma turma); //POLIMORFISMO DINÂMICO (SOBRESCRITA DE MÉTODOS) -> AÇÕES DIFERENTES PARA PROFESSORES E ALUNOS
}
