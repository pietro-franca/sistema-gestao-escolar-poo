/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.model;

/**
 *
 * 
 */
public class AtividadeAvaliativa 
{ 
    public String nome;
    public String data;
    public Disciplina disciplina; //RELAÇÃO SIMPLES E DIRECIONADA (1:1) (AtividadeAvaliativa -> Disciplina) (mas não ocorre o contrário)
    
    public AtividadeAvaliativa(String nome, String data, Disciplina disciplina)
    {
        this.nome = nome;
        this.data = data;
        this.disciplina = disciplina;
    }
    
    public void corrigindo() //POLIMORFISMO DINÂMICO (DIFERENTE PARA PROVAS, TRABALHOS E LISTAS) 
    {
        System.out.println("Corrigindo a Atividade Avaliativa...");
    }
}
