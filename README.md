<body>
    <h1>Trabalho final - API Restful  - Grupo 4</h1>
    <p>O presente trabalho tem como objetivo a contrução de uma API voltada para a requisição de dados de um modelo fictício de e-comerce.<p>
    <h2>Conteúdo do Projeto</h2>
    <ul>
        <li><code>com.trabalhofinal.grupo4</code>: Pacote que contém o run da aplicação.</li>
        <li><code>com.trabalhofinal.grupo4.controllers</code>: Pacote com as classes controller.</li>
        <li><code>com.trabalhofinal.grupo4.dto</code>: Pacotes com as classes DTO.</li>
        <li><code>com.trabalhofinal.grupo4.entities</code>: Pacotes com as classes entities.</li>
        <li><code>com.trabalhofinal.grupo4.exceptions</code>: Pacotes com as classes exceptions.</li>
        <li><code>com.trabalhofinal.grupo4.repository</code>: Pacotes com as classes repository.</li>
        <li><code>com.trabalhofinal.grupo4.security</code>: Pacotes com as classes responsaveis pela segurança.</li>
        <li><code>com.trabalhofinal.grupo4.security.jwt</code>: Pacotes com as classes responsaveis pela segurança.</li>
        <li><code>com.trabalhofinal.grupo4.security.services</code>: Pacotes com as classes security services.</li>
        <li><code>com.trabalhofinal.grupo4.services</code>: Pacotes com as classes services.</li>
        <li><code>README.md</code>: Este arquivo, fornecendo informações sobre o projeto.</li>
    </ul>
    <h2>Requisitos Atendidos</h2>
    <ul>
        <li>Readme</li>
        <li>O banco de dados e as tabelas deverão ser criados de acordo com o DER fornecido abaixo, a partir das Entidades</li>
        <li>Não será permitido alterar a estrutura/relacionamento entre asentidades constantes no DER. </li>
        <li>Todos os endpoints disponibilizados pela API deverão estar funcionais e realizando os processos para os quais foram desenvolvidos;</li>
        <li>Para todos os recursos da API deverão ser disponibilizados os
métodos CRUD;</li>
        <li>Deverá ser criado um Relatório de Pedido, contendo: id do pedido,
data do pedido, valor total; Relação de itens do pedido: código e
nome do produto, preço de venda, quantidade, valor bruto,
percentual de desconto e valor líquido. Tal relatório deverá ser criado
com a utilização de DTO;</li>
        <li>Para transição dos dados referentes aos métodos CRUD poderão ser
utilizadas as Entidades ou DTOs, à escolha dos Grupos;</li>
        <li>Poderão ser criados diferentes DTOs referentes a uma mesma
Entidade, caso necessário;</li>
        <li>Em todos os métodos CRUD deverão ser identificadas e tratadas as
exceções de item não encontrado, com a exibição de mensagem
personalizada;</li>
        <li>As imagens dos Produtos deverão ser armazenadas no banco de
dados (utilizar o tipo de dados blob/bytea para tal);</li>
      <li> A cada novo pedido cadastrado deverá ser enviado um e-mail
contendo o Relatório de Pedido (descrito acima);
</li>
      <li>Deverão ser implementados a autenticação e o controle de acesso à
API (com o módulo de segurança do Spring + JWT);</li>
      <li>No ato de cadastro de um novo pedido deverá ser calculado os
valores bruto e líquido dos produtos: valor bruto (preço venda *
qtde) e valor líquido (valor bruto – valor desconto; sendo esse último
calculado através da aplicação do percentual de desconto sobre o
valor bruto);
</li>
      <li>Ao final do cadastro de um novo pedido deverá ser calculado e
armazenado o seu valor total: soma dos valores líquidos dos itens do
pedido;
</li>
      <li>Os dados do endereço do Cliente deverão ser obtidos a partir de sua
coleta numa API externa de consulta de CEP;
</li>
    </ul>
    <ol>
        <li>Clone ou faça o download deste repositório para a sua máquina! Fique livre para utilizá-lo como meio de estudo ou caso queira aprimorá-lo</li>
        <pre><code></code>https://github.com/philippusv/TrabalhoFinalApirestful.git</code></pre>
    </ol>
    <h2>⚜️ Siga nossos colaboradores:</h2>
      <a href = "https://github.com/marcospavao">Marcos Pavão</a>;
      <a href = "https://github.com/caiquelms">Caíque Lemos</a>;
      <a href = "https://github.com/Rian-Fernandes">Rian Fernandes</a>;
      <a href = "https://github.com/philippusv">Felipe Ribeiro</a>;
      <a href = "https://github.com/Estevao1323">Estevão Carius</a>;
      <a href = "https://github.com/Matheus-mOliveira">Matheus Oliveira</a>;
    <h2>Tecnologias utilizadas</h2>
    <p>O presente projeto foi desenvolvido utilizando as seguintes tecnologias:</p>
    <ul>
    <li><img src="https://i.stack.imgur.com/8NkOQ.gif" width="100" height="100">
      <p>JAVA</p>
    </li>
    <li><img src="https://static-00.iconduck.com/assets.00/apps-insomnia-icon-512x512-dse2p0fm.png" alt="Icone do css" width="100" height="100">
        <p>Insomnia</p>
    </li>
    <li><img src="https://static-00.iconduck.com/assets.00/dbeaver-icon-512x506-p5mxyxd5.png" alt="Icone do Java Script" width="100" height="100">
        <p>Dbeaver</p>
    </li>  
     <li><img src="https://pluralsight2.imgix.net/paths/images/corespring-f9a00f4516.png" alt="Icone do Canva" width="100" height="100">
        <p>Spring Tools 4</p>
    </li>  
</ul>
</body>
</html>
