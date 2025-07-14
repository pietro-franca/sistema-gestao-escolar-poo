/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.util;

import br.unesp.model.Disciplina;
import br.unesp.model.Trabalho;
import java.util.Scanner;

/**
 *
 * @author Pietro
 */
public class TrabalhoFactory implements AvaliacaoFactory<Trabalho> 
{    
    @Override
    public Trabalho criar(String nome, String data, Disciplina disciplina, Scanner scanner)
    {
        System.out.print("Tempo da prova: ");
        int tamGrupo = scanner.nextInt();
        return new Trabalho(nome, data, disciplina, tamGrupo);
    }
}
