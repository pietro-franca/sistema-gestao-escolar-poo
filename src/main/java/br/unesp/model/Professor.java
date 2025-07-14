/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.model;

import java.util.List;
import java.util.ArrayList;
import br.unesp.model.interfaces.*;
/**
 *
 * 
 */
public class Professor extends Pessoa implements ParticipanteDeTurma, Avaliador //HERANÇA (HERDA DA CLASSE "Pessoa")
{    
    public String email;
    public List<Disciplina> disciplinas = new ArrayList<>(); //Professor -> List<Disciplina> (RELAÇÃO UNIDIRECIONAL) (CARDINALIDADE 1:N)
    public Aluno orientado;
    
    public List<Turma> turmas = new ArrayList<>();
    public List<AtividadeAvaliativa> avaliacoesProfessor = new ArrayList<>();
    
    public Professor (String nome, String genero, int idade, String email)
    {
        super(nome, genero, idade);
        this.email = email;
    }
    
    //POLIMORFISMO DINÂMICO (SOBRESCRITA DO MÉTODO "adicionarNaTurma( )" DA SUPERCLASSE PESSOA)
    
    @Override
    public void adicionarNaTurma(Turma turma)
    {
        turmas.add(turma);
        turma.adicionaPessoa(this);
    }
    
    //POLIMORFISMO DINÂMICO AO SOBRESCREVER A FUNÇÃO DA SUPERCLASSE "Pessoa"
    //POLIMORFISMO DE SUBTIPO AO PASSAR "AtividadeAvaliativa avaliacao" COMO PARÂMETRO EM "adicionarAvaliacao( )"
    
    @Override
    public void adicionarAvaliacao(AtividadeAvaliativa avaliacao)
    {
        avaliacoesProfessor.add(avaliacao);
    }
    
    //POLIMORFISMO DE SUBTIPO AO PASSAR "AtividadeAvaliativa avaliacao" COMO PARAMETRO EM "corrigirAvaliacao( )"
    
    @Override
    public void corrigirAvaliacao(Avaliavel aluno, AtividadeAvaliativa avaliacao, double nota) 
    {
        System.out.printf("%s: ", this.nome);
        avaliacao.corrigindo();      
        aluno.adicionarNota(avaliacao, nota);
    }
    
    public void adicionarDisciplina(Disciplina disciplina) 
    {
        disciplinas.add(disciplina);
    }
}
