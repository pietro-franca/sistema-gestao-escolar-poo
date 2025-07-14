/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unesp.util;

import br.unesp.model.AtividadeAvaliativa;
import br.unesp.model.Disciplina;
import java.util.Scanner;

/**
 *
 * @author Pietro
 * @param <T>
 */
public interface AvaliacaoFactory <T extends AtividadeAvaliativa> 
{    
    T criar(String nome, String data, Disciplina disciplina, Scanner scanner);
}
