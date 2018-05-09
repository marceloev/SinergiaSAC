package br.com.sinergia.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ModelConnection {

    private Connection connection;
    private final ConnectionProperties propies = new ConnectionProperties();

    public ModelConnection() {
        try {
            this.setConnection(DriverManager.getConnection(getDBConnURL(), propies));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String getDBConnURL() {
        return String.format("jdbc:oracle:thin:@%s:%s:%s",
                propies.getMapProperties().get("xIP"),
                propies.getMapProperties().get("xPort"),
                propies.getMapProperties().get("xService"));
    }

    public Connection getConnection() {
        return connection;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }
}
