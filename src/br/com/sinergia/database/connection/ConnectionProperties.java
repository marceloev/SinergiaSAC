package br.com.sinergia.database.connection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class ConnectionProperties extends Properties {

    private Map<String, String> mapProperties = new LinkedHashMap<>();

    public ConnectionProperties() {
        getMapProperties().put("user", "hdesnk03");
        getMapProperties().put("password", "tecsis");
        getMapProperties().put("v$session.program", "Sinergia");
        getMapProperties().put("xIP", "192.168.0.170");
        getMapProperties().put("xPort", "1521");
        getMapProperties().put("xService", "ORCL");
        getMapProperties().entrySet().stream().filter(prop -> !prop.getKey().startsWith("x"))
                .distinct().forEach((prop -> this.put(prop.getKey(), prop.getValue())));
    }

    public Map<String, String> getMapProperties() {
        return mapProperties;
    }
}
