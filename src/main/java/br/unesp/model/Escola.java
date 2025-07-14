/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.model;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * 
 */
public class Escola 
{
    public String nome;
    public List<Turma> turmas = new ArrayList<>(); //LISTAS
    
    public Escola (String nome)
    {
        this.nome = nome;
    }
    
    public void adicionarTurma(Turma turma)
    {
        turmas.add(turma);
    }
}
