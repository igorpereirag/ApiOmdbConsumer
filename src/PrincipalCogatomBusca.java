import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PrincipalCogatomBusca {
    public static void main(String[] args) throws InterruptedException {
        String chave = "YOU-ACESS-KEY";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        Apiconnect api = new Apiconnect(chave);

        try {
            String resposta = api.buscarFilme();
            while (resposta != null) { 
                if (resposta.equalsIgnoreCase("sair")) {
                    break; 
                }

                if (resposta.equalsIgnoreCase("Movie not found!")) {
                    System.out.println("Filme não encontrado.");
                } else {
                    TituloOmdb meuTituloOmdb = gson.fromJson(resposta, TituloOmdb.class);
                    Titulo titulo = new Titulo(meuTituloOmdb);
                    titulos.add(titulo);
                    System.out.println(titulo);
                }

                resposta = api.buscarFilme(); 
            }

            
            FileWriter escritor = new FileWriter("titulos.json");
            escritor.write(gson.toJson(titulos));
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RuntimeException e) { 
            System.out.println(e.getMessage());
        }
    }
}
