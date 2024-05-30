
package com.unipar.venda.frontend;

import com.unipar.venda.frontend.model.Produto;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class VendaFrontend {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/produtos");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;
            String result = "";
            while ((inputLine = in.readLine()) != null) {
                result += inputLine;
            }

            in.close();
            List<Produto> produtos = Produto.unmarshalFromJson(result);

            for (Produto produto : produtos) {
                System.out.println(produto.getId());
                System.out.println(produto.getDescricao());
                System.out.println(produto.getValor());
                System.out.println(produto.getCategoria());
            }

            int code = connection.getResponseCode();
            System.out.println("Response code: " + code);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        };
    }
}
