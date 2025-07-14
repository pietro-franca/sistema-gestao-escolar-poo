/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.persistencia;

import br.unesp.model.Escola;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Felipe Matsuo
 */
public class EscolaPersistencia implements IPersistencia{
    private final XStream xstream;

    public EscolaPersistencia() {
        xstream = new XStream();
        xstream.allowTypesByWildcard(new String[]{"br.unesp.**"});
        xstream.alias("escola", Escola.class);
    }

    @Override
    public Escola carregar(String caminho) {
        try {
            File arquivo = new File(caminho);
            if (arquivo.exists()) {
                return (Escola) xstream.fromXML(new FileReader(arquivo));
            } else {
                System.out.println("Arquivo não encontrado. Criando nova instância de Escola.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao carregar dados da escola: " + e.getMessage());
        }
        return new Escola("UNESP - Rio Claro");
    }

    @Override
    public void salvar(Escola escola, String caminho) {
        try (FileWriter writer = new FileWriter(caminho)) {
            xstream.toXML(escola, writer);
            System.out.println("Escola salva com sucesso em " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao salvar escola: " + e.getMessage());
        }
    }
}
