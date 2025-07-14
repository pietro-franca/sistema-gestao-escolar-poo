/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.service;

import br.unesp.model.Escola;
import br.unesp.model.Turma;
import java.util.List;
import java.util.Scanner;
import br.unesp.model.interfaces.ParticipanteDeTurma;
import br.unesp.service.interfaces.ITurmaService;

/**
 *
 * @author Pietro
 */
public class TurmaService implements ITurmaService 
{  
    @Override
    public void adicionarNovaTurma(Escola escola, Scanner scanner) 
    {
        System.out.print("Nome da turma: ");
        String nomeTurma = scanner.nextLine();

        System.out.print("Ano letivo: ");
        int anoTurma = scanner.nextInt();
        scanner.nextLine();

        Turma novaTurma = new Turma(nomeTurma, anoTurma);
        escola.adicionarTurma(novaTurma);

        System.out.println("Turma '" + nomeTurma + "' adicionada com sucesso para o ano de " + anoTurma + ".");
    }
    
    @Override
    public Turma selecionarTurma(Escola escola, Scanner scanner) 
    {
        List<Turma> turmas = escola.turmas;
        if (turmas.isEmpty()) 
        {
            System.out.println("Nenhuma turma encontrada!");
            return null;
        }

        System.out.println("\nLista de Turmas:");
        for (int i = 0; i < turmas.size(); i++) 
        {
            System.out.println("  " + i + " - " + turmas.get(i).nome + " (" + turmas.get(i).ano + ")");
        }

        System.out.print("Escolha uma turma: ");
        int indiceTurma = scanner.nextInt();
        scanner.nextLine();

        return turmas.get(indiceTurma);
    }
    
    @Override
    public void adicionarParticipanteNaTurma (ParticipanteDeTurma pessoa, Turma turma)
    {
        pessoa.adicionarNaTurma(turma);
    }
}
