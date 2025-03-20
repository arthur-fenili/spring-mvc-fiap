# Projeto: Sinister Buster

## Integrantes do Grupo

- **Arthur Fenili** - RM: 552752
- **Enzo Antunes Oliveira** - RM: 553185
- **Vinicio Raphael Santana** - RM: 553813

## Descrição do Projeto

O **Sinister Buster** é um projeto desenvolvido seguindo a arquitetura MVC (Model-View-Controller) com o objetivo de gerenciar informações de pacientes e dentistas de maneira eficiente. O sistema permite cadastro, listagem, edição e exclusão de registros, utilizando o framework **Spring Boot** no backend e **Thymeleaf** para a renderização das páginas dinâmicas.

## Tecnologias Utilizadas

- **Java (Spring Boot)**: Backend da aplicação, responsável pela lógica de negócios.
- **Thymeleaf**: Template engine para renderização de páginas HTML dinâmicas.
- **Oracle**: Banco de dados utilizado para armazenamento das informações.
- **Bootstrap**: Framework CSS para estilização e responsividade.

## Funcionalidades

### **Gerenciamento de Dentistas**
- Cadastro de dentistas.
- Listagem dos dentistas cadastrados.
- Atualização de informações de um dentista.
- Remoção de um dentista do sistema.

### **Gerenciamento de Pacientes**
- Cadastro de pacientes.
- Listagem dos pacientes cadastrados.
- Atualização de informações de um paciente.
- Remoção de um paciente do sistema.

## Estrutura do Projeto

```
├── src/
│   ├── main/
│   │   ├── java/com/challenge/sinister_buster/
│   │   │   ├── controller/  # Controladores (DentistaController, PacienteController)
│   │   │   ├── dto/         # Data Transfer Objects (DentistaRequest, PacienteRequest)
│   │   │   ├── model/       # Modelos das entidades (Dentista, Paciente, Especialidade(Enum))
│   │   │   ├── repository/  # Repositórios (JpaRepository para persistência de dados)
│   │   │   ├── service/     # Serviços que contêm a lógica de negócio
│   │   ├── resources/
│   │   │   ├── templates/   # Páginas HTML (Thymeleaf)
│   │   │   ├── static/css/  # Arquivos de estilo (style.css)
│   │   ├── application.properties # Configurações do banco de dados
```

## Como Executar o Projeto

1. **Clonar o repositório**:
   ```sh
   git clone https://github.com/arthur-fenili/spring-mvc-fiap.git
   cd spring-mvc-fiap
   ```

2. **Configurar o banco de dados** (Oracle):
    - Ajustar as variáveis de ambiente e configurações no `application.properties`:
      ```properties
      spring.datasource.url=${DATABASE_URL}
      spring.datasource.username=${DATABASE_USERNAME}
      spring.datasource.password=${DATABASE_PASSWORD}
      spring.jpa.hibernate.ddl-auto=update
      ```

3. **Executar o projeto (gradle)**:
   ```sh
    ./gradlew bootRun
   ```

4. **Acessar no navegador**:
    - Listagem de Dentistas: `http://localhost:8080/dentista/lista`
    - Cadastro de Dentistas: `http://localhost:8080/dentista/cadastrar`
    - Listagem de Pacientes: `http://localhost:8080/paciente/lista`
    - Cadastro de Pacientes: `http://localhost:8080/paciente/cadastrar`

---

