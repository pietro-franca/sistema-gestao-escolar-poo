/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unesp.model.interfaces;

import br.unesp.model.AtividadeAvaliativa;

/**
 *
 * @author Pietro
 */
public interface Avaliavel 
{
    public void receberAvaliacao(AtividadeAvaliativa avaliacao);
    public void adicionarNota(AtividadeAvaliativa avaliacao, double nota);
}
