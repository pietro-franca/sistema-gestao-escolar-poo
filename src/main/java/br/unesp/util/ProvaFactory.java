/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.util;

import br.unesp.model.Disciplina;
import br.unesp.model.Prova;
import java.util.Scanner;

/**
 *
 * @author Pietro
 */
public class ProvaFactory implements AvaliacaoFactory<Prova> 
{    
    @Override
    public Prova criar(String nome, String data, Disciplina disciplina, Scanner scanner)
    {
        System.out.print("Tempo da prova: ");
        String tempo = scanner.nextLine();
        return new Prova(nome, data, disciplina, tempo);
    }
}
