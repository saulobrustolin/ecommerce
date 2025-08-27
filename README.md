# Objetivo do projeto
Este é um projeto de e-commerce focado no nicho de moda masculina.

O projeto será um monolíto com a seguinte stack:
    - Laravel (back-end)
    - React (Front-end)
    - PostgreSQL (banco de dados)

O diagrama de entidade relacionamento e diagrama de classes já estão construídos e serão implementados neste projeto.

![Screenshot](./.readme/Diagrama%20conceitual.png)

## Desafio inicial:
Construção das rotas web sobre as seguintes rotas e categorias:
    - Produto:
        - /product
    - Coleção:
        - /collection/{name}
    - Página inicial:
        - /
    - Usuário:
        - /my-account
        - /my-account/settings
        - /my-account/orders
        - /my-account/favorites
    - Pedidos:
        -/my-account/orders/{number}
    - Institucionais:
        - /about
        - /policy/devolution
        - /policy/cookies
        - /policy/legal
        - /policy/privacy
        - /faq
        - /contact