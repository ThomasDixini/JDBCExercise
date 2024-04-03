# Exercicio para JDBC

  Este exercício foi desenvolvido com o objetivo de consolidar os conhecimentos em JDBC (Java Database Connectivity). Através da criação de um programa Java, que utiliza os diversos tipos de RowSets e ResultSets, espera-se fortalecer habilidades como conexão a bancos de dados, manipulação de dados e consultas SQL. Ao realizar atividades práticas como essa, é possível aprimorar a compreensão sobre como interagir com bancos de dados relacionais usando a plataforma Java, um conhecimento fundamental para o desenvolvimento de aplicativos corporativos e sistemas baseados em dados.

Abaixo esta um exemplo de diagrama de relacionamento de entidade que vai nos ajudar a criar nossas tabelas no banco de Dados.

![JDBC Exercises drawio (1)](https://github.com/ThomasDixini/JDBCExercise/assets/83423919/17a16ff8-f8c6-49d1-b296-b990cb91ac7b)

### Clientes

---

- ID: É o id e chave primária do Cliente.
- NOME: Nome do Cliente
- NOME DE USUARIO: Nome do Cliente no sistema
- SENHA
- DATA DE CRIAÇÃO: Data em que o cliente foi criado no sistema
- DATA DE MODIFICAÇÃO: Data e hora onde houve uma alteração desse Cliente no sistema.

### Consulta

---

- ID DA CONSULTA: Chave Primaria da Tabela
- VALOR DA CONSULTA: Valor que a consulta foi cobrada em dinheiro.
- TIPO DA CONSULTA: Referente a qual tipo de consulta foi realizada.
- ID DO CLIENTE: Chave Estrangeira para relacionar a Consulta com a tabela Clientes. Relacionando o Cliente com sua determinada Consulta.
- DATA DA CONSULTA: Data que foi agendada a consulta.

## Atividade

1. Crie as tabelas a cima e suas determinadas relações utilizando *DriveManager*, *Connection e Statement.*
2. Alimente as tabelas utilizando dos Statement, PreparedStatement e CallableStatement
3. Consulte e manipule as tabelas utilizando *RowSet, JdbcRowSet, CachedRowSet, WebRowSet, JoinRowset e FilteredRowSet.*
4. Agora crie uma tabela igualmente os exemplos anteriores, só que utilizando DataSource
5. Qual as duas formas que se pode fazer conexões através de JDBC?
6. Explique o conceito por trás de cada tecnologia citada acima.
