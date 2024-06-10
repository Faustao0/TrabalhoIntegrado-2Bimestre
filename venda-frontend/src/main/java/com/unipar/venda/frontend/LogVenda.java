package com.unipar.venda.frontend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LogVenda {
    
     public void registrarLog(String tipoOperacao, String statusOperacao) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHora = now.format(formatter);

        String logMessage = String.format("%s - Operação: %s - Status: %s%n", dataHora, tipoOperacao, statusOperacao);

        String logFilePath = "/home/guest/NetBeansProjects/venda-frontend/LogVenda/log.txt";
        File logFile = new File(logFilePath);

        if (!logFile.exists()) {
            try {
                if (logFile.createNewFile()) {
                    System.out.println("Arquivo de log criado com sucesso!");
                } else {
                    System.out.println("Falha ao criar o arquivo de log.");
                }
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo de log: " + e.getMessage());
                return;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write(logMessage);
        } catch (IOException e) {
            System.err.println("Erro ao escrever log: " + e.getMessage());
        }
    }
}
