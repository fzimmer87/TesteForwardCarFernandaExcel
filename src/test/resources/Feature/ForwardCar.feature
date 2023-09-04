# language: pt
  Funcionalidade: Testar o Api da ForwardCar

    @CT001
    Cenario: Realizar cadastro na ForwardCar
      Dado que tenho a seguinte massa para realizar o cadastro
        | planilha        |  aba    |
        | ForwardCar.xlsx | Teste1  |
      Entao sistema me retorna statusCode 200

    @CT002
    Cenario: Realizar cadastro na ForwardCar com usarname já existente
      Dado que tenho a massa para realizar cadastro com usarname existente
        | planilha        |  aba    |
        | ForwardCar.xlsx | Teste2  |
      Entao sistema nao realiza cadastro e retorna statusCode 500

    @CT003
    Cenario: Realizar Login com usuário Cadastrado
      Dado que tenho cadastro com usarname e senha cadastrados na massa de dados
        | planilha          |  aba    |
        | ForwardCar.xlsx   | Teste3  |
      Entao o sistema me retorna status code 200

    @CT004
    Cenario: Cadastrar novo modelo de Carro
      Dado que quero cadastrar um novo veículo e preencho os seguintes campos
      Entao sistema me retorna o VIN do modelo que cadastrei

    @CT005
    Cenario: Consultar se novo modelo está cadastrado na funcao get
      Dado que cadastrei um novo veiculo na ForwardCar
      Entao sistema me retorna VIN do carro cadastrado no GET





