/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unicatolica.conexao;

import br.com.unicatolica.utilitario.Alertas;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Reginaldo
 */
public class ConectaDB {
    
    private static String servidor;
    private static String nome_db;
    private static String porta;
    private static String usuario;
    private static String senha;
    
    public static Connection getConnection() throws SQLException{
        lerArquivoConfiguracao();
        return DriverManager.getConnection("jdbc:mysql://"+servidor+":"+porta+"/"+nome_db, usuario, senha);
    }
    
    private static void lerArquivoConfiguracao() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("config/config.cfg"));
            servidor = bf.readLine();
            nome_db = bf.readLine();
            porta = bf.readLine();
            usuario = bf.readLine();
            senha = bf.readLine();
            bf.close();
        } catch (FileNotFoundException e) {
            Alertas.mensagemErro("Arquivo de configuração não encontrado!");
        } catch(Exception e) {
            Alertas.mensagemErro("Erro ao tentar ler o arquivo!");
        }
    } 
}










