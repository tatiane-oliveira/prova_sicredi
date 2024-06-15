# Prova Técnica Sicredi

Solução elaborada para atender aos requisitos dos Desafios 1 e 2 da **Prova Técnica de automação de testes** proposto pelo Sicredi.


# Estrutura do Projeto

Foi criado um projeto **Maven**  com as seguintes dependências:

- **Selenium WebDriver**,
- **JUnit 4**,
- **Commons IO**.

## br.com.dbccompany.ProvaSicredi.core

- **BaseTest** (classe base de teste),
- **DriverFactory**,
- **DSL** (métodos customizados para interagir com os elementos das páginas).


## br.com.dbccompany.ProvaSicredi.page

Contempla todas as páginas (PageObject Pattern).

## br.com.dbccompany.ProvaSicredi.test

Contém duas classes para solucionar os Desafios 1 e 2, descritos na prova. Os dados para preenchimento do formulário são passados através de parâmetros pelo JUnit.

> Como o teste de cadastro impacta diretamente no teste de exclusão (validação da mensagem de confirmação de exclusão do registro), foi adicionado no final do teste a exclusão do registro.

## br.com.dbccompany.ProvaSicredi.utils

Classes de apoio ao teste:

- **CustomerUtils** (classe utilizada para centralizar a ação de exclusão do customer),
- **PropertiesReader** (classe utilizada para ler o arquivo de propriedades).

## src\test\resources

Contém o arquivo de propriedades "**config.properties**" onde é permitido informar a localização do chromedriver através da propriedade **chromedriver.path**.

> **O driver não foi adicionado ao projeto, logo, é necessário alterar o valor desta propriedade para execução dos testes.**

## Execução dos testes

Basta acessar a pasta do projeto e executar via linha de comando de duas formas: 

* mvn surefire-report:report (gera o relatório em HTML);
* mvn test (gera o relatório em XML).

> No término da execução dos testes é gerada uma evidência na pasta **target\screenshot** com o nome do método, data, e horário da execução.

> O relatório em HTML é gerado na pasta **target\site**. Os demais na pasta **target\surefire-reports**.
