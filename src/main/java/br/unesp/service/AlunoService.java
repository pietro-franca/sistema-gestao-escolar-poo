/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.service;

import br.unesp.model.*;
import java.util.List;
import java.util.Scanner;
import br.unesp.service.interfaces.IAlunoService;
import br.unesp.service.interfaces.ITurmaService;

/**
 *
 * @author Pietro
 */
public class AlunoService implements IAlunoService
{  
    ITurmaService turmaService;
    
    public AlunoService (ITurmaService turmaService)
    {
        this.turmaService = turmaService;
    }
    
    @Override
    public void adicionarNovoAluno(Escola escola, Scanner scanner) 
    {
        Turma turma = turmaService.selecionarTurma(escola, scanner);
        if (turma == null) return;
    
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();
        
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        
        Aluno alunoNovo = new Aluno(nome, genero, idade);
        
        System.out.println("Adicionar orientador? (s/n)");
        String resposta = scanner.nextLine();
        
        if(resposta.equalsIgnoreCase("s"))
        {
            List<Professor> professores = turma.professores;
            if (professores.isEmpty()) 
            {
                System.out.println("Nenhum professor encontrado!");
                return;
            }

            System.out.println("Lista de Professores: ");
            for (int i = 0; i < professores.size(); i++) 
            {
                Professor p = professores.get(i);
                System.out.println("  " + i + " - " + p.nome);
            }

            System.out.print("Professor orientador: ");
            int indiceProf = scanner.nextInt();
            scanner.nextLine();

            Professor profOrientador = professores.get(indiceProf);
            alunoNovo.definirOrientador(profOrientador);
        }
              
        turmaService.adicionarParticipanteNaTurma(alunoNovo, turma);
        System.out.println("Aluno adicionado.");
    }
}
