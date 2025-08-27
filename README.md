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
* **Produto:**
    * /product
* **Coleção:**
    * /collection/{name}
* **Página inicial:**
    * /
* **Usuário:**
    * /my-account
    * /my-account/settings
    * /my-account/orders
    * /my-account/favorites
* **Pedidos:**
    * /my-account/orders/{number}
* **Institucionais:**
    * /about
    * /policy/devolution
    * /policy/cookies
    * /policy/legal
    * /policy/privacy
    * /faq
    * /contact

## Próximo desafio:
Adicionar as APIs para cada modelo da aplicação, atribuindo suas respectivas rotas e regras de permissão.
* **Address** (GET, PUT/PATCH, DELETE e POST; acesso apenas para clientes, apenas seus endereços cadastrados)

* **Collection** (GET; acesso a qualquer usuário - logado ou não)
* **Collection** (PUT/PATCH, DELETE e POST; acesso apenas ao usuário master)

* **Favorite** (GET, DELETE, POST; acesso apenas para clientes, apenas seus produtos favoritos cadastrados)

* **Image** (GET; acesso a qualquer usuário - logado ou não)
* **Image** (PUT/PATCH, DELETE e POST; acesso apenas ao usuário master)

* **Order** (GET, PUT/PATCH, POST; acesso apenas para clientes, apenas seus pedidos criados)
* **Order** (DELETE; acesso apenas ao usuário master)

* **Product** (GET; acesso a qualquer usuário - logado ou não)
* **Product** (POST, DELETE e PUT/PATCH; acesso apenas ao usuário master)

* **Reviews** (GET; acesso a qualquer usuário - logado ou não)
* **Reviews** (POST, PUT/PATCH e DELETE; acesso apenas para clientes, apenas suas reviews criadas)

* **Slug** (GET; acesso a qualquer usuário - logado ou não)
* **Slug** (POST, PUT/PATCH e DELETE; acesso apenas ao usuário master)