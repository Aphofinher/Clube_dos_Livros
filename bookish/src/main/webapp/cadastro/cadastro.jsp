<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang=pt-BR>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../cadastro/cadastro.css">
</head>
<body>
<div class="logos">
    <a href="../login/login.jsp">
        <img src="../cadastro/img/voltar.png" class="logo-voltar">
    </a>
    <img src="../cadastro/img/logo-meio.png" class="logo-meio">
</div>

<form action="/create-usuario" method="post" id="formulario-principal">
    <section class="main">
        <h1>Cadastro</h1>
        <div class="forms">
            <input type="text" placeholder="Seu nome:" id="nome" name="nome">
            <input type="text" placeholder="E-mail:" id="email" name="email">
            <input type="text" placeholder="Instagram:" id="rede-social" name="rede-social">
            <input type="password" placeholder="Senha:" id="senha" name="senha">
            <input type="password" placeholder="Confirme Senha:" id="confirmaSenha" name="confirmaSenha">
            <button class="atu" type="submit" role="button">Cadastre-se</button>

        </div>
        <p style="text-align: center">${erroCadastro}</p>


    </section>
</form>
</body>
</html>

