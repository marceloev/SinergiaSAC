package br.com.sinergia.controllers;

import br.com.sinergia.database.connection.Conexao;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Conexao conex = new Conexao(Main.class);
        try {
            conex.createStatement("SELECT NUNOTA, DTMOV FROM TGFCAB");
            conex.createSet();
            while (conex.rs.next()) {
                System.out.println(
                        String.format("Nunota: %d x Dt. Canc.: %s", conex.rs.getInt(1), conex.rs.getString(2))
                );
            }
            conex.desconecta();
            conex.createStatement("SELECT SYSDATE FROM DUAL");
            conex.createSet();
            conex.rs.next();
            System.out.println(conex.rs.getString(1));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            conex.desconecta();
        }
    }
}
