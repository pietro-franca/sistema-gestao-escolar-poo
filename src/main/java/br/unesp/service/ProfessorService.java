/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.service;

import br.unesp.model.*;
import java.util.Scanner;
import br.unesp.service.interfaces.IProfessorService;
import br.unesp.service.interfaces.ITurmaService;
/**
 *
 * @author Pietro
 */
public class ProfessorService implements IProfessorService
{
    ITurmaService turmaService;
    
    public ProfessorService (ITurmaService turmaService)
    {
        this.turmaService = turmaService;
    }
    
    @Override
    public void adicionarNovoProfessor(Escola escola, Scanner scanner) 
    {
        Turma turma = turmaService.selecionarTurma(escola, scanner);
        if (turma == null) return;
    
        System.out.print("Nome do professor: ");
        String nome = scanner.nextLine();
        
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Professor profNovo = new Professor(nome, genero, idade, email);
        
        String resposta;
        do {
            System.out.print("Adicionar uma disciplina (nome): ");
            String nomeDisciplina = scanner.nextLine();
            
            Disciplina disciplina = new Disciplina(nomeDisciplina);
            profNovo.adicionarDisciplina(disciplina);

            System.out.print("Adicionar outra disciplina? (s/n): ");
            resposta = scanner.nextLine();
        } while (resposta.equalsIgnoreCase("s"));

        turmaService.adicionarParticipanteNaTurma(profNovo, turma);
        System.out.println("Professor " + nome + " adicionado à turma " + turma.nome + ".");
    }
}
