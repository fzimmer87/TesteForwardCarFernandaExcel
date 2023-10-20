package Constantes;


import io.restassured.response.Response;
import steps.AppTest;
import utils.ArquivoTxt;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnviarEndPoints {

    public static List<Response> dadosUsuarios  = new ArrayList<>();
    public static List<String> firstname = new ArrayList<>();
    public static List<String> lastname = new ArrayList<>();
    public static List<String> usarname = new ArrayList<>();
    public static List<String> password = new ArrayList<>();

    public static void leituraTxt(int linhas) {
        String dadosUsuario;
        for (int i = 1; i <= linhas; i++) {
            dadosUsuario = ArquivoTxt.lerArquivo("firstname_" +i,"ForwardCar.txt");
            if (!dadosUsuario.isEmpty()){
                firstname.add(dadosUsuario);
            }
            dadosUsuario = ArquivoTxt.lerArquivo("lastname_"+i,"ForwardCar.txt");
            if (!dadosUsuario.isEmpty()){
                lastname.add(dadosUsuario);
            }
            dadosUsuario = ArquivoTxt.lerArquivo("usarname_"+i,"ForwardCar.txt");
            if(!dadosUsuario.isEmpty()){
                usarname.add(dadosUsuario);
            }
            dadosUsuario = ArquivoTxt.lerArquivo("password_"+i,"ForwardCar.txt");
            if(!dadosUsuario.isEmpty()){
                password.add(dadosUsuario);
            }
        }
    }

    public static List<Response> enviarEndpoints() throws IOException {

        for (int i = 0; i < password.size(); i++) {
            String corpoRegistro = AppTest.gerarCorpoCadastro(firstname.get(i),lastname.get(i),
                                                              usarname.get(i),password.get(i));

            dadosUsuarios.add(AppTest.novoCadastro(corpoRegistro)); //minhaLista
        }
        return dadosUsuarios;
    }

    public static void leituraTxtLogin(int linhas) {
        String dadosUsuario;
        for (int i = 1; i <= linhas; i++) {
            dadosUsuario = ArquivoTxt.lerArquivo("usarname_"+i,"ForwardCar.txt");
            if(!dadosUsuario.isEmpty()){
                usarname.add(dadosUsuario);
            }
            dadosUsuario = ArquivoTxt.lerArquivo("password_"+i,"ForwardCar.txt");
            if(!dadosUsuario.isEmpty()){
                password.add(dadosUsuario);
            }
        }
    }
    public static List<Response> enviarEndpointsLogin() throws IOException {

        for (int i = 0; i < password.size(); i++) {
            String corpoLogin = AppTest.gerarCorpoLogin(usarname.get(i),password.get(i));
            dadosUsuarios.add(AppTest.realizarLogin(corpoLogin));
        }
        return dadosUsuarios;
    }
}

