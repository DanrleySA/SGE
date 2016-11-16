/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unicatolica.utilitario;

import javax.swing.JOptionPane;

/**
 *
 * @author Reginaldo
 */
public class Alertas {
    
    public static void mensagemErro(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void mensagemAviso(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Aviso", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void mensagemConfirmacao(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
}
