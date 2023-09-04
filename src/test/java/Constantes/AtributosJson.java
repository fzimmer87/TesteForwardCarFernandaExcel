package Constantes;

import org.json.JSONObject;

public class AtributosJson {
    public static final String firstname = "firstname";
    public static final String lastname = "lastname";
    public static final String username = "username";
    public static final String password = "password";
    public static final String primeiroNomeUsuario = "Fernanda";
    public static final String sobrenomeUsuario = "Zimmer";
    public static final String usanameUsuario = "zimmer70";
    public static final String senhaUsuario = "852456";
    public static final String dealer =  "dealer";
    public static final String classs= "class";
    public static final String id = "id";
    public static final String address = "address";
    public static final String city = "city";
    public static final String name = "name";
    public static final String state ="state";
    public static final String telephone = "telephone";
    public static final String website = "website";
    public static final String zip = "zip";
    public static final String model = "model";
    public static final String fuelType = "fuelType";
    public static final String make = "make";
    public static final String modelYear = "modelYear";
    public static final String subName = "subName";
    public static final String type = "type";
    public static final String stockNumber = "stockNumber";
    public static final String price = "price";
    public static final String milage = "milage";
    public static final String owners= "owners";
    public static final String color= "color";
    public static final String carTrim= "carTrim";
    public static final String engine = "engine";
    public static final String transmission = "transmission";
    public static final String vin= "vin";
    public static final String options= "options";
    public static final String image1= "image1";
    public static final String image2= "image2";

    public String gerarCorpoCadastroVeiculo(){
        JSONObject corpoCadastro = new JSONObject();
        corpoCadastro.put(AtributosJson.dealer,"{");
        corpoCadastro.put(AtributosJson.classs,RespostaAtributoJson.enderecoSite);
        corpoCadastro.put(AtributosJson.id,RespostaAtributoJson.id);
        corpoCadastro.put(AtributosJson.address,RespostaAtributoJson.address);
        corpoCadastro.put(AtributosJson.city,RespostaAtributoJson.city);
        corpoCadastro.put(AtributosJson.name,RespostaAtributoJson.name);
        corpoCadastro.put(AtributosJson.state,RespostaAtributoJson.state);
        corpoCadastro.put(AtributosJson.telephone,RespostaAtributoJson.telefone);
        corpoCadastro.put(AtributosJson.website,RespostaAtributoJson.website);
        corpoCadastro.put(AtributosJson.zip,RespostaAtributoJson.cep);

        corpoCadastro.put(AtributosJson.model,"{");
        corpoCadastro.put(AtributosJson.classs,RespostaAtributoJson.classModel);
        corpoCadastro.put(AtributosJson.id,RespostaAtributoJson.idModel);
        corpoCadastro.put(AtributosJson.classs,RespostaAtributoJson.classModel);
        corpoCadastro.put(AtributosJson.id,RespostaAtributoJson.idModel);
        corpoCadastro.put(AtributosJson.fuelType,RespostaAtributoJson.fuelTypeModel);

        corpoCadastro.put(AtributosJson.make, "{");
        corpoCadastro.put(AtributosJson.classs,RespostaAtributoJson.classMake);
        corpoCadastro.put(AtributosJson.id,RespostaAtributoJson.idMake);
        corpoCadastro.put(AtributosJson.name,RespostaAtributoJson.nameMake);

        corpoCadastro.put(AtributosJson.modelYear,RespostaAtributoJson.modelYear);
        corpoCadastro.put(AtributosJson.name,RespostaAtributoJson.nameModel);
        corpoCadastro.put(AtributosJson.subName,RespostaAtributoJson.subName);
        corpoCadastro.put(AtributosJson.type,RespostaAtributoJson.chaves);
        corpoCadastro.put(AtributosJson.classs,RespostaAtributoJson.classType);
        corpoCadastro.put(AtributosJson.id,RespostaAtributoJson.idType);
        corpoCadastro.put(AtributosJson.name, RespostaAtributoJson.nameType);

        corpoCadastro.put(AtributosJson.stockNumber,RespostaAtributoJson.stockNumber);
        corpoCadastro.put(AtributosJson.price,RespostaAtributoJson.price);
        corpoCadastro.put(AtributosJson.milage,RespostaAtributoJson.milage);
        corpoCadastro.put(AtributosJson.owners, RespostaAtributoJson.owners);
        corpoCadastro.put(AtributosJson.modelYear,RespostaAtributoJson.modelYear);
        corpoCadastro.put(AtributosJson.color,RespostaAtributoJson.color);
        corpoCadastro.put(AtributosJson.carTrim,RespostaAtributoJson.carTrim);
        corpoCadastro.put(AtributosJson.engine, RespostaAtributoJson.engine);
        corpoCadastro.put(AtributosJson.transmission,RespostaAtributoJson.transmission);
        corpoCadastro.put(AtributosJson.vin,RespostaAtributoJson.numeroVin);
        corpoCadastro.put(AtributosJson.options,RespostaAtributoJson.options);
        corpoCadastro.put(AtributosJson.image1,RespostaAtributoJson.image1);
        corpoCadastro.put(AtributosJson.image2,RespostaAtributoJson.image2);

        return corpoCadastro.toString();
    }
}







