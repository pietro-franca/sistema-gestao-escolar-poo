/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.model;

/**
 *
 * 
 */
abstract class Pessoa 
{
    public String nome;
    public String genero;
    public int idade;
    
    public Pessoa(String nome, String genero, int idade)
    {
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
    }
}
