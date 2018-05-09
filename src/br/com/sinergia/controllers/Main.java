package br.com.sinergia.controllers;

import br.com.sinergia.database.connection.Conexao;

public class Main {

    public static void main(String[] args) {
        try {
            Conexao conex = new Conexao(Main.class);
            conex.createStatement("SELECT MD5 FROM TGFPAF\n" +
                    "WHERE NOMEAPLICATIVO = ?\n" +
                    "AND VERSAO = ?\n" +
                    "AND NUMEND = ?");
            conex.addParametro("FAST SERVICE", "4.6.0.7", 369);
            conex.createSet();
            conex.rs.next();
            System.out.print(conex.rs.getString(1));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
