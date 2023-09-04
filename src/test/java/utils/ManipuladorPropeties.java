package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ManipuladorPropeties {
    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "src/test/resources/propeties/dados.properties");
        props.load(file);
        return props;

    }

    public static void  main(String args[]) throws IOException {
        String login; //Variavel que guardará o login do usuário.
        String password; //Variável que guardará o password do usúario.
        String baseUri; //Variável página original sem Endpoints.
        String register; //Variável para realizar cadastro.
        String cadastrarVeiculo; //Variável para cadastrar veículo.
        String cadastrarUsuario; //Variável para cadastrar usuário.
        System.out.println("************Teste de leitura do arquivo de propriedades************");

        Properties prop = getProp();

        login = prop.getProperty("prop.server.login");
        password = prop.getProperty("prop.server.password");
        baseUri = prop.getProperty("prop.server.baseURI");
        register = prop.getProperty("prop.server.register");
        cadastrarVeiculo = prop.getProperty("prop.server.cadastrarVeiculo");
        cadastrarUsuario=prop.getProperty("prop.server.paginaLogin");

        System.out.println("BaseURI = "+baseUri);
        System.out.println("Register = "+register);
        System.out.println("Realizar Login = "+cadastrarUsuario);
        System.out.println("Cadastrar novo veículo = "+cadastrarVeiculo);
        System.out.println("Login = " + login);
        System.out.println("Password = " + password);
    }
}
