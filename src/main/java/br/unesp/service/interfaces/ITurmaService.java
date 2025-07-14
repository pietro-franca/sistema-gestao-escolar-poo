/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unesp.service.interfaces;

import br.unesp.model.Escola;
import br.unesp.model.Turma;
import br.unesp.model.interfaces.ParticipanteDeTurma;
import java.util.Scanner;

/**
 *
 * @author Pietro
 */
public interface ITurmaService 
{    
    public void adicionarNovaTurma(Escola escola, Scanner scanner);
    public Turma selecionarTurma(Escola escola, Scanner scanner);
    public void adicionarParticipanteNaTurma (ParticipanteDeTurma pessoa, Turma turma);
}
