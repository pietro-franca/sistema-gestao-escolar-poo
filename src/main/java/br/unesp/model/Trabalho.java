/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.model;

/**
 *
 * 
 */
public class Trabalho extends AtividadeAvaliativa 
{
    public int tamGrupo;
    
    public Trabalho(String nome, String data, Disciplina disciplina, int tamGrupo)
    {
        super(nome, data, disciplina);
        this.tamGrupo = tamGrupo;
    }
    
    @Override
    public void corrigindo()
    {
        System.out.println("Corrigindo Trabalho...");
    }
}
