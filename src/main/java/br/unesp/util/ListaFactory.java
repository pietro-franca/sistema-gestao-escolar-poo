/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.util;

import br.unesp.model.Disciplina;
import br.unesp.model.Lista;
import java.util.Scanner;

/**
 *
 * @author Pietro
 */
public class ListaFactory implements AvaliacaoFactory<Lista> 
{    
    @Override
    public Lista criar(String nome, String data, Disciplina disciplina, Scanner scanner) 
    {
        System.out.print("Numero de exercicios: ");
        int numExc = scanner.nextInt();
        return new Lista(nome, data, disciplina, numExc);
    }
}
