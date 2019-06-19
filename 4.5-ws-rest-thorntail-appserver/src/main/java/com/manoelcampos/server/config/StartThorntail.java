/*
 */
package com.manoelcampos.server.config;

/**
 * Inicia o Servidor de Aplicação Thorntail sem empacotar o projeto
 * (sem criar arquivos jar/war), o que torna a inicialização mais rápida.
 * Para esta classe funcionar, foi preciso configurar o classpath.
 * As configurações foram feitas e salvas no arquivo nbactions.xml.
 * 
 * @author manoelcampos
 */
public class StartThorntail {
    public static void main(String[] args) throws Throwable {
        org.wildfly.swarm.bootstrap.Main.main(args);
    }
}
