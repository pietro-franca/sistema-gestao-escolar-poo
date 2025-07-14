/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.model;

/**
 *
 * 
 */
public class Lista extends AtividadeAvaliativa //HERANÇA (HERDA DA CLASSE "AtividadeAvaliativa")
{ 
    public int numExercicios;
    
    public Lista(String nome, String data, Disciplina disciplina, int numExercicios)
    {
        super(nome, data, disciplina);
        this.numExercicios = numExercicios;
    }
    
    @Override
    public void corrigindo()
    {
        System.out.println("Corrigindo Lista...");
    }
}
