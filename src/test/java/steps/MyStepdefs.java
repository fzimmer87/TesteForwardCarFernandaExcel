package steps;

import Constantes.EnviarEndPoints;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import utils.Excel;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class MyStepdefs {

    public static String baseURI;


    @Before
    public static void configInicial() {
        baseURI = "http://localhost:3434/cars-app";
    }
    private static List <Map<String,String>> list;
    private static int linhas;


    @Dado("que tenho a seguinte massa para realizar o cadastro")
    public void queTenhoASeguinteMassaParaRealizarOCadastro(DataTable dataTable) throws Exception{
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel.getCellDadosPlanilha(list.get(0).get("planilha"),list.get(0).get("aba"));
        EnviarEndPoints.leituraTxt(linhas);
    }

    @Entao("sistema me retorna statusCode {int}")
    public void sistemaMeRetornaStatusCode(int statusCode) throws IOException {
        List<Response> response = EnviarEndPoints.enviarEndpoints();
        for (int i = 0; i < response.size() ; i++) {
            response.get(i).then().log().all().assertThat().statusCode(statusCode);
        }
    }

    @Dado("que tenho a massa para realizar cadastro com usarname existente")
    public void queTenhoAMassaParaRealizarCadastroComUsarnameExistente( DataTable dataTable)throws Exception {
        list = dataTable.asMaps(String.class, String.class);
        linhas = Excel.getCellDadosPlanilha2(list.get(0).get("planilha"),list.get(0).get("aba"));
        EnviarEndPoints.leituraTxt(linhas);
    }

    @Entao("sistema nao realiza cadastro e retorna statusCode {int}")
    public void sistemaNaoRealizaCadastroERetornaStatusCode(int statusCode) throws IOException {
        List<Response> responses = EnviarEndPoints.enviarEndpoints();
        for (int i = 0; i < responses.size(); i++) {
            responses.get(i).then().log().all().assertThat().statusCode(statusCode);
        }
    }

    @Dado("que tenho cadastro com usarname e senha cadastrados na massa de dados")
    public void queTenhoCadastroComUsarnameESenhaCadastradosNaMassaDeDados(DataTable dataTable)throws Exception {
        list =dataTable.asMaps(String.class, String.class);
        linhas = Excel.getCellDadosPlanilhaTeste3(list.get(0).get("planilha"),list.get(0).get("aba"));
        EnviarEndPoints.leituraTxtLogin(linhas);
    }
    @Entao("o sistema me retorna status code {int}")
    public void oSistemaMeRetornaStatusCode(int statusCode) throws IOException {
        List<Response> response = EnviarEndPoints.enviarEndpointsLogin();
        for (int i = 0; i < response.size(); i++) {
            response.get(i).then().log().all().assertThat().statusCode(statusCode);
        }

    }

    @Dado("que quero cadastrar um novo veículo e preencho os seguintes campos")
    public void queQueroCadastrarUmNovoVeículoEPreenchoOsSeguintesCampos() throws IOException {
        AppTest.cadastrarVeiculo();
    }
    @Entao("sistema me retorna o VIN do modelo que cadastrei")
    public void sistemaMeRetornaOVINDoModeloQueCadastrei() throws IOException {
        AppTest.cadastrarNovoVeiculoForwardCar();
    }


    @Dado("que cadastrei um novo veiculo na ForwardCar")
    public void queCadastreiUmNovoVeiculoNaForwardCar() throws IOException {
        AppTest.cadastrarVeiculo();
    }

    @Entao("sistema me retorna VIN do carro cadastrado no GET")
    public void sistemaMeRetornaVINDoCarroCadastradoNoGET() throws IOException {
        AppTest.consultarNovoVeiculoCadastradoComGet();
    }



}

