/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unesp.service.interfaces;

import br.unesp.model.Escola;
import java.util.Scanner;

/**
 *
 * @author Pietro
 */
public interface IAvaliacaoService 
{    
    public void adicionarNovaAvaliacao(Escola escola, Scanner scanner);
    public void corrigirAvaliacao(Escola escola, Scanner scanner);
}
