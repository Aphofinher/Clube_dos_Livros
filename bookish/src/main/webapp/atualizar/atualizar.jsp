<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="atualizar.css">
</head>
<body>

    <div class="logos">
        <a href="../logada/logada.jsp">
        <img src="img/voltar.png" class="logo-voltar">
        </a>
        <img src="img/logo-meio.png" class="logo-meio">
    </div>

    <section class="container">
        <h1>Atualizar Meus Dados</h1>
        <div class="forms">
            <input type="text" placeholder="Seu nome:" id="nome" name="nome">
            <input type="text" placeholder="E-mail:" id="email" name="email">
            <input type="text" placeholder="Instagram:" id="rede-social" name="rede-social">
            <input type="password" placeholder="Senha:" id="senha" name="senha">
            <input type="password" placeholder="Confirme Senha:" id="confirmaSenha" name="confirmaSenha">
        </div>

        <button class="atu" role="button">Atualizar</button>
    </section>

</body>
</html>