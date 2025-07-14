/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.model;

import br.unesp.model.interfaces.Avaliavel;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * 
 */
public class Turma 
{    
    public String nome;
    public int ano;
    
    //Turma -> List<Professor> / Turma -> List<Aluno> (RELAÇÃO DE 1 PARA MUITOS) (CARDINALIDADE 1:N)
    //COMO TAMBÉM TEMOS: Professor -> Turma / Aluno -> Turma 
    //ENTÃO: Turma <-> Professor / Turma <-> Aluno (RELAÇÃO BIDIRECIONAL)
    
    public List<Professor> professores = new ArrayList<>();
    public List<Aluno> alunos = new ArrayList<>();
    public Map<AtividadeAvaliativa, Professor> atividadesAvaliativas = new HashMap<>(); //LINKA AVALIAÇÃO COM O RESPECTIVO PROFESSOR
    
    public Turma(String nome, int ano)
    {
        this.nome = nome;
        this.ano = ano;
    }
    
    //POLIMORFISMO ESTÁTICO (SOBRECARGA DE MÉTODOS) 
    
    public void adicionaPessoa(Aluno aluno) //MESMO NOME, MAS O PARÂMETRO É DA CLASSE "Aluno"
    {
        alunos.add(aluno);
    }
    
    public void adicionaPessoa(Professor professor) //MESMO NOME, MAS O PARÂMETRO É DA CLASSE "Professor"
    {
        professores.add(professor);
    }
    
    //POLIMORFISMO DE SUBTIPO AO PASSAR "AtividadeAvaliativa avaliacao" COMO PARAMETRO EM "novaAvaliacao( )"
    
    public void novaAvaliacao(AtividadeAvaliativa avaliacao, Professor professor)
    {
        atividadesAvaliativas.put(avaliacao, professor);
        
        for(Avaliavel a : alunos)
        {
            a.receberAvaliacao(avaliacao);
        }
        
        professor.adicionarAvaliacao(avaliacao);
    }
    
    public Professor getProfessorDaAvaliacao(AtividadeAvaliativa avaliacao) 
    {
        return atividadesAvaliativas.get(avaliacao);
    }
}
