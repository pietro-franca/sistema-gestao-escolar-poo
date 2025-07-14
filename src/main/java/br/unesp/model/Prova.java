/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.model;

/**
 *
 * 
 */
public class Prova extends AtividadeAvaliativa //HERANÇA (HERDA DA CLASSE "AtividadeAvaliativa")
{ 
    public String tempoProva;
    
    public Prova(String nome, String data, Disciplina disciplina, String tempoProva)
    {
        super(nome, data, disciplina);
        this.tempoProva = tempoProva;
    }
    
    @Override
    public void corrigindo()
    {
        System.out.println("Corrigindo Prova...");
    }
}
