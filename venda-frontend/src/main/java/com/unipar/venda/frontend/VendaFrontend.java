package com.unipar.venda.frontend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unipar.venda.frontend.model.Cliente;
import com.unipar.venda.frontend.model.Produto;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class VendaFrontend {

    public static void main(String[] args) {
        try {
            // Fetch and display products
            URL productUrl = new URL("http://localhost:8080/produtos");
            String productJson = fetchJsonFromUrl(productUrl);
            List<Produto> produtos = unmarshalFromJson(productJson, new TypeReference<List<Produto>>() {});

            System.out.println("Produtos:");
            for (Produto produto : produtos) {
                System.out.println("ID: " + produto.getId());
                System.out.println("Descrição: " + produto.getDescricao());
                System.out.println("Valor: " + produto.getValor());
                System.out.println("Categoria: " + produto.getCategoria());
                System.out.println();
            }

            // Fetch and display clients
            URL clientUrl = new URL("http://localhost:8080/clientes");
            String clientJson = fetchJsonFromUrl(clientUrl);
            List<Cliente> clientes = unmarshalFromJson(clientJson, new TypeReference<List<Cliente>>() {});

            System.out.println("Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println("ID: " + cliente.getId());
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Telefone: " + cliente.getTelefone());
                System.out.println("Email: " + cliente.getEmail());
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String fetchJsonFromUrl(URL url) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder result = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            result.append(inputLine);
        }

        in.close();
        connection.disconnect();
        return result.toString();
    }

    private static <T> T unmarshalFromJson(String json, TypeReference<T> typeReference) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, typeReference);
    }
}

