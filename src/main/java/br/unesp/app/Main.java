/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.app;

import br.unesp.model.Escola;
import br.unesp.service.*;
import br.unesp.service.interfaces.*;

/**
 *
 * @author Pietro
 */
public class Main 
{
    public static void main(String[] args) 
    {
        Escola escola = new Escola("UNESP - Rio Claro");
        IEscolaService escolaService = new EscolaService();
        ITurmaService turmaService = new TurmaService();
        IAlunoService alunoService = new AlunoService(turmaService);
        IProfessorService professorService = new ProfessorService(turmaService);
        IAvaliacaoService avaliacaoService = new AvaliacaoService();
        
        MenuPrincipal menu = new MenuPrincipal(
                escola,
                escolaService,
                turmaService,
                alunoService,
                professorService,
                avaliacaoService
        );
        
        menu.executar();
    }
}
