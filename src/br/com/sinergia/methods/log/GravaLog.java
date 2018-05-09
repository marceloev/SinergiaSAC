package br.com.sinergia.methods.log;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.net.BindException;
import java.net.URL;

public class GravaLog {

    private final static Logger logger = Logger.getLogger(GravaLog.class);
    private final static URL properties = GravaLog.class.getResource("Log.Properties");
    private static Boolean configurado = false;

    public static void send(LogType logType, Class invocador, String mensagem) {
        sendFinal(logType, invocador, mensagem, null);
    }

    public static void send(LogType logType, Class invocador, String mensagem, String tips) {
        sendFinal(logType, invocador, mensagem, new SinergiaTip(tips));
    }

    public static void send(LogType logType, Class invocador, String mensagem, Throwable throwable) {
        sendFinal(logType, invocador, mensagem, throwable);
    }

    private static void sendFinal(LogType logType, Class invocador, String mensagem, Throwable throwable) {
        setConfig();
        String text = String.format("[%s] : %s", invocador.getName(), mensagem);
        switch (logType) {
            case INFO:
                logger.info(text, throwable);
                break;
            case WARN:
                logger.warn(text, throwable);
                break;
            case ERROR:
                logger.error(text, throwable);
                break;
        }
    }

    private static void setConfig() {
        if (!configurado) {
            PropertyConfigurator.configure(properties);
            configurado = true;
        }
    }
}
