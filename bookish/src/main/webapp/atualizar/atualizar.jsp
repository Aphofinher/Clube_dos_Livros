<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../atualizar/atualizar.css">
</head>
<body>

    <div class="logos">
        <img  onclick="mandarRequisicaoServlet()" src="../atualizar/img/voltar.png" class="logo-voltar">
        <img src="../atualizar/img/logo-meio.png" class="logo-meio">
    </div>

    <section class="container">
        <h1>Atualizar Meus Dados</h1>
        <form action ="/alterar-usuario" method="post">
        <div class="forms">
            <input type="text" placeholder="Seu nome:" id="nome" name="nome" value="${usuario.nome}" >
            <input type="text" placeholder="E-mail:" id="email" name="email" value="${usuario.email}">
            <input type="text" placeholder="Instagram:" id="rede-social" name="rede-social" value="${usuario.redeSocial}">
            <input type="password" placeholder="Senha:" id="senha" name="senha" value="${usuario.senha}">
            <input type="password" placeholder="Confirme Senha:" id="confirmaSenha" name="confirmaSenha">
        </div>

            <button class="atu" type="submit" role="button">Atualizar</button>
            <p style="color: green">${alteracao}</p>

        </form>

    </section>

    <form id="enviarRequisicao" method="post" action="/login">
        <input type="hidden" name="email" value="${usuario.email}" >
        <input type="hidden" name="senha" value="${usuario.senha}">
    </form>

</body>
</html>

<script>
    function mandarRequisicaoServlet() {
        let form = document.getElementById('enviarRequisicao');
        form.submit();
    }
</script>