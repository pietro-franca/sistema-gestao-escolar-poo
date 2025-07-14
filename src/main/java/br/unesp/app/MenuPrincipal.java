/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.app;

import br.unesp.model.Escola;
import br.unesp.service.interfaces.*;
import java.util.Scanner;

/**
 *
 * @author Pietro
 */

public class MenuPrincipal 
{
    private final Escola escola;
    private final IEscolaService escolaService;
    private final ITurmaService turmaService;
    private final IAlunoService alunoService;
    private final IProfessorService professorService;
    private final IAvaliacaoService avaliacaoService;
    private final Scanner scanner;

    public MenuPrincipal(Escola escola, IEscolaService escolaService,
                         ITurmaService turmaService,
                         IAlunoService alunoService,
                         IProfessorService professorService,
                         IAvaliacaoService avaliacaoService) 
    {
        this.escola = escola;
        this.escolaService = escolaService;
        this.turmaService = turmaService;
        this.alunoService = alunoService;
        this.professorService = professorService;
        this.avaliacaoService = avaliacaoService;
        this.scanner = new Scanner(System.in);
    }

    public void executar() 
    {
        int opcao;
        do 
        {
            System.out.println("\nSISTEMA DE GESTÃO ESCOLAR\n");
            System.out.println("1 - Exibir dados da escola");
            System.out.println("2 - Adicionar nova turma");
            System.out.println("3 - Adicionar novo professor");
            System.out.println("4 - Adicionar novo aluno");
            System.out.println("5 - Adicionar nova avaliação");
            System.out.println("6 - Corrigir avaliação");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) 
            {
                case 1 -> escolaService.exibirDados(escola);
                case 2 -> turmaService.adicionarNovaTurma(escola, scanner);
                case 3 -> professorService.adicionarNovoProfessor(escola, scanner);
                case 4 -> alunoService.adicionarNovoAluno(escola, scanner);
                case 5 -> avaliacaoService.adicionarNovaAvaliacao(escola, scanner);
                case 6 -> avaliacaoService.corrigirAvaliacao(escola, scanner);
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}

