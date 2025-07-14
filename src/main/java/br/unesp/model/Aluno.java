/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import br.unesp.model.interfaces.*;
/**
 *
 * 
 */
public class Aluno extends Pessoa implements ParticipanteDeTurma, Avaliavel, Orientavel //HERANÇA (HERDA DA CLASSE "Pessoa")
{ 
    
    public Turma turma; //Turma <-> Aluno (RELAÇÃO BIDIRECIONAL)
    public Professor orientador; //Orientado (Aluno) <-> Orientador (Professor) (RELAÇÃO BIDIRECIONAL) (CARDINALIDADE 1:1)
    
    public List<AtividadeAvaliativa> avaliacoesAluno = new ArrayList<>();
    public Map<AtividadeAvaliativa, Double> notas = new HashMap<>(); //LINKA AVALIAÇÃO COM A RESPECTIVA NOTA
    
    public Aluno (String nome, String genero, int idade)
    {
        super(nome, genero, idade);
    }
    
    //POLIMORFISMO DINÂMICO (SOBRESCRITA DO MÉTODO "adicionarNaTurma( )" DA SUPERCLASSE PESSOA)
    
    @Override
    public void adicionarNaTurma(Turma turma)
    {
        this.turma = turma;
        turma.adicionaPessoa(this);
    }
    
    //POLIMORFISMO DINÂMICO AO SOBRESCREVER A FUNÇÃO DA SUPERCLASSE "Pessoa"
    //POLIMORFISMO DE SUBTIPO AO PASSAR "AtividadeAvaliativa avaliacao" COMO PARAMETRO EM "adicionarAvaliacao( )"
    
    @Override
    public void receberAvaliacao(AtividadeAvaliativa avaliacao)
    {
        avaliacoesAluno.add(avaliacao);
        notas.put(avaliacao, null);
    }
    
    @Override
    public void definirOrientador(Professor orientador)
    {
        if(orientador.orientado == null) //CHECA SE JÁ HÁ UM ORIENTADO, A FIM DE GARANTIR CARDINALIDADE (1:1)
        {
            this.orientador = orientador;
            orientador.orientado = this;
        }
        else System.out.println("Esse orientador já possui um orientado!");
    }
    
    //POLIMORFISMO DE SUBTIPO AO PASSAR "AtividadeAvaliativa avaliacao" COMO PARAMETRO EM "adicionarNota( )"
    
    @Override
    public void adicionarNota(AtividadeAvaliativa avaliacao, double nota)
    {
        notas.replace(avaliacao, null, nota);
    }
}
