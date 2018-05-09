package br.com.sinergia.database.connection;

import br.com.sinergia.methods.log.GravaLog;
import br.com.sinergia.methods.log.LogType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexao {

    private Class invocador;
    private PreparedStatement pst;
    public ResultSet rs;
    private int index = 1;
    private ModelConnection modelConnection = new ModelConnection();

    public Conexao(Class invocador) {
        try {
            this.setInvocador(invocador);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void createStatement(String sql) throws Exception {
        GravaLog.send(LogType.INFO, getInvocador(), "Statement: " + sql);
        this.setPst(modelConnection.getConnection().prepareStatement(sql));
    }

    public void addParametro(Object... objects) throws Exception {
        for (Object object : objects) addParametro(object);
    }

    private void addParametro(Object object) throws Exception {
        GravaLog.send(LogType.INFO, getInvocador(),
                String.format("%dº Parâmetro(%s): %s", index, object.getClass().getName(), object.toString()));
        this.getPst().setObject(index, object);
        this.index++;
    }

    public void createSet() throws Exception {
        this.setRs(this.getPst().executeQuery());
    }

    public void desconecta() {
        try {
            this.modelConnection.getConnection().close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public PreparedStatement getPst() {
        return pst;
    }

    public ResultSet getRs() {
        return rs;
    }

    public Class getInvocador() {
        return invocador;
    }

    public void setInvocador(Class invocador) {
        this.invocador = invocador;
    }

    private void setPst(PreparedStatement pst) {
        this.pst = pst;
    }

    private void setRs(ResultSet rs) {
        this.rs = rs;
    }
}
