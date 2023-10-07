## Fluxo da Solução - Cadastro de Ficha Escolar
<br />

1. Acessar a home: http://localhost:8080.
2. A tela da Home será apresentada:
<br />

![HOME](./screenshots/home.png "Home")

3. Realize o Sign-up e o Login.
<br />

![SIGNIN](./screenshots/sign-in.png "Sign-In")

![LOGIN](./screenshots/login.png "Login")

4. Cada aba do menu possui 2 sub-abas: Cadastro e Listagem:
<br />

![SIGNIN](./screenshots/home-2.png "Sign-In")

4. Realize os cadastros na sequência:
**Aluno > Responsável > Professor > Efetivação da Ficha de Cadastro.**
<br />

![CADASTROALUNO](./screenshots/cadastro-aluno.png "Aluno")

![CADASTRORESP](./screenshots/cadastro-responsavel.png "Responsável")

![CADASTROPROF](./screenshots/cadastro-professor.png "Professor")

![CADASTROFICHA](./screenshots/cadastro-ficha-dados.png "Ficha")

5. Após todo o processo, a Lista de Cadastramento - Ficha de Dados Efetivada será apresentada.
<br />

![LISTAGEMFICHA](./screenshots/ficha-dados-final-efetivada.png "Ficha Efetivada")

6. Tratamento de exceção:
- Caso seja inserida uma sala diferente do Enum declarado dentro do projeto, a seguinte tela será apresentada:
<br />

![EXCEÇÃO](./screenshots/exceção.png "Exceção")

7. Clicando no canto superior esquerdo, Registro Escolar, será apresentado detalhes sobre as classes como ensinado em aula.
<br />

![SOBRE](./screenshots/sobre.png "Sobre")

8. [!IMPORTANTE]
**Para a exclusão dos dados, a sequência para não quebrar as regras de foreign key deve ser:**

**Excluir: Ficha Escolar > Responsável > Professor > Aluno.**

🔙 [Voltar](https://github.com/npalleta/Infnet-Dep-Inj-Project)

---