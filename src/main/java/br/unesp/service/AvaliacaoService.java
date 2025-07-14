/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.service;

import br.unesp.model.*;
import br.unesp.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import br.unesp.service.interfaces.IAvaliacaoService;

/**
 *
 * @author Pietro
 */
public class AvaliacaoService implements IAvaliacaoService
{   
    TurmaService turmaService  = new TurmaService();
    Map<Integer, AvaliacaoFactory<? extends AtividadeAvaliativa>> factories = new HashMap<>();
    
    @Override
    public void adicionarNovaAvaliacao(Escola escola, Scanner scanner) 
    {
        Turma turma = turmaService.selecionarTurma(escola, scanner);
        if (turma == null) return;
        
        factories.put(1, new ProvaFactory());
        factories.put(2, new ListaFactory());
        factories.put(3, new TrabalhoFactory());

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
            System.out.print("  " + i + " - " + p.nome + " (Disciplinas: ");
            
            for (Disciplina d : p.disciplinas) 
            {
                System.out.print(d.nome + "; ");
            }
            System.out.println(")");
        }

        System.out.print("Professor responsável pela avaliação: ");
        int indiceProf = scanner.nextInt();
        scanner.nextLine();

        Professor profSelecionado = professores.get(indiceProf);
        
        System.out.println("Escolha uma disciplina do professor:");
        for (int i = 0; i < profSelecionado.disciplinas.size(); i++) 
        {
            System.out.println("  " + i + " - " + profSelecionado.disciplinas.get(i).nome);
        }
        
        int indiceDisc = scanner.nextInt(); scanner.nextLine();
        Disciplina disciplina = profSelecionado.disciplinas.get(indiceDisc);
        
        System.out.print("Nome da avaliação: ");
        String nomeAvaliacao = scanner.nextLine();
        
        System.out.print("Data (dd/mm): ");
        String dataAvaliacao = scanner.nextLine();
           
        AtividadeAvaliativa novaAvaliacao = null;
        int tipo;

        do
        {
            System.out.println("Tipo da avaliação:\n1 - Prova\n2 - Lista\n3 - Trabalho");
            tipo = scanner.nextInt();
            scanner.nextLine();

            AvaliacaoFactory<? extends AtividadeAvaliativa> factory = factories.get(tipo);
            
            if (factory == null)
            {
                System.out.println("\nTipo Inválido!\n");
                tipo = 0;
            }
            else
                novaAvaliacao = factory.criar(nomeAvaliacao, dataAvaliacao, disciplina, scanner);
        } 
        while(tipo == 0);

        turma.novaAvaliacao(novaAvaliacao, profSelecionado);
        System.out.println("Avaliação adicionada com sucesso à turma " + turma.nome);
    }
    
    @Override
    public void corrigirAvaliacao(Escola escola, Scanner scanner) 
    {
        Turma turma = turmaService.selecionarTurma(escola, scanner);
        if (turma == null) return;

        List<Aluno> alunos = turma.alunos;
        if (alunos.isEmpty()) 
        {
            System.out.println("Nenhum aluno encontrado!");
            return;
        }

        System.out.println("Lista de alunos: ");
        for (int i = 0; i < alunos.size(); i++) 
        {
            System.out.println("  "+ i + " - " + alunos.get(i).nome);
        }

        System.out.print("Escolha um aluno: ");
        int indiceAluno = scanner.nextInt();
        scanner.nextLine();
        
        Aluno aluno = alunos.get(indiceAluno);

        List<AtividadeAvaliativa> avaliacoes = aluno.avaliacoesAluno;
        if (avaliacoes.isEmpty()) 
        {
            System.out.println("Sem avaliações para esse aluno.");
            return;
        }

        System.out.println("Avaliações do aluno: ");
        for (int i = 0; i < avaliacoes.size(); i++) 
        {
            AtividadeAvaliativa a = avaliacoes.get(i);
            System.out.println("  " + i + " - " + a.nome + " (" + a.disciplina.nome + ")");
        }

        System.out.print("Escolha uma avaliação: ");
        int indiceAvaliacao = scanner.nextInt(); 
        scanner.nextLine();
        
        AtividadeAvaliativa avaliacao = avaliacoes.get(indiceAvaliacao);

        Professor professor = turma.getProfessorDaAvaliacao(avaliacao);
        if (professor == null) 
        {
            System.out.println("Professor não encontrado.");
            return;
        }

        System.out.print("Digite a nota: ");
        String input = scanner.nextLine().replace(",", ".");
        double nota = Double.parseDouble(input);

        professor.corrigirAvaliacao(aluno, avaliacao, nota);
        System.out.println("Nota atribuída com sucesso.");
    }
}
