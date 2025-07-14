/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.service;

import br.unesp.model.*;
import br.unesp.service.interfaces.IEscolaService;

/**
 *
 * @author Pietro
 */
public class EscolaService implements IEscolaService
{   
    @Override
    public void exibirDados(Escola escola)
    {
        System.out.println("\nESCOLA " + escola.nome);
        
        for(Turma t: escola.turmas)
        {
            System.out.println("\nTURMA " + t.nome + " - " + t.ano);
            System.out.println("\n Professores:");
            
            for(Professor p: t.professores)
            {
                int i=1;
                if(p.genero.equals("Masculino"))
                {
                    System.out.println("\n  - Prof. " + p.nome + ", Email: " + p.email + ", Idade: " + p.idade);
                    
                    System.out.print("    -> Disciplinas: ");
                    for(Disciplina disc : p.disciplinas)
                    {
                        System.out.print(disc.nome + "; ");
                    }
                    
                    System.out.println("\n    -> Avaliacoes: ");
                    for(AtividadeAvaliativa atv: p.avaliacoesProfessor)
                    {
                        System.out.println("      " + i + ". " + atv.nome + " | Data: " + atv.data + ";");
                        i++;
                    }
                    
                    if(p.orientado != null)
                    {
                        System.out.println("\n    -> Aluno Orientado: " + p.orientado.nome);
                    }
                }
                else
                {
                    System.out.println("\n  - Profa. " + p.nome + ", Email: " + p.email + ", Idade: " + p.idade);
                    
                    System.out.print("    -> Disciplinas: ");
                    for(Disciplina disc : p.disciplinas)
                    {
                        System.out.print(disc.nome + "; ");
                    }
                            
                    System.out.println("\n    -> Avaliacoes: ");
                    for(AtividadeAvaliativa atv: p.avaliacoesProfessor)
                    {
                        System.out.println("      " + i + ". " + atv.nome + " | Data: " + atv.data + ";");
                        i++;
                    }
                    
                    if(p.orientado != null)
                    {
                        System.out.println("\n    -> Aluno Orientado: " + p.orientado.nome);
                    }
                }
            }
            
            System.out.println("\n Alunos:");
            int j=1;
            
            for(Aluno a: t.alunos)
            {
                System.out.print("\n  " + j + ". " + a.nome + ", Genero: " + a.genero + ", Idade: " + a.idade); 
                if(a.orientador != null)
                {
                    System.out.println(", Orientador: " + a.orientador.nome);
                }
                else System.out.println("");
                
                j++;
                for(AtividadeAvaliativa atv: a.avaliacoesAluno)
                {
                    System.out.println("    - " + atv.nome + ", Data: " + atv.data + ", Nota: " + a.notas.get(atv));
                }
            }
        }
    }
}
