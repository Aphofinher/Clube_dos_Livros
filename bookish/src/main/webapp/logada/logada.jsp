<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang=pt-BR>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../logada/logada.css">

    <title>Tela Logada</title>

</head>
<body>
<header>
    <div class="header-social">
        <img class="logo-nome" src="../logada/images-logada/logoNome.png" alt="Imagem Logo">
    </div>

</header>
<div id="menu">
    <ul class="menu-esquerdo">
        <li onclick="enviarRequisicao()">Perfil</li>
        <hr>
        <li onclick="enviarDadosCategoria(7)">Ação e Aventura</li>
        <hr>
        <li onclick="enviarDadosCategoria(8)">Biografia</li>
        <hr>
        <li onclick="enviarDadosCategoria(1)">Clássicos</li>
        <hr>
        <li onclick="enviarDadosCategoria(6)">Drama</li>
        <hr>
        <li onclick="enviarDadosCategoria(3)">Finanças</li>
        <hr>
        <li onclick="enviarDadosCategoria(2)">Psicologia</li>
        <hr>
        <li onclick="enviarDadosCategoria(4)">Romance</li>
        <hr>
        <li onclick="enviarDadosCategoria(5)">Terror</li>
        <hr>
        <li><a href="../index.jsp">Sair</a></li>
    </ul>
</div>

<section class="comments">
    <div class="comments-file">
        <span class="nomecomentuser">${usuarioLogado.nome}</span>
    </div>


    <form method="post" action="/create-comentario">
        <label> Selecione uma categoria:</label>
        <select name="categoria">

            <c:forEach var="categoria" items="${categorias}">
                <option value="${categoria.id}">${categoria.categoria}</option>
            </c:forEach>

        </select>
        <label> Insira o nome do Livro:</label>
        <input class="seleciona-livro" type="text" id="livro" placeholder="Livro:" name="livro" required>
        <textarea class="comment-box" placeholder="Digite seu comentário" name="comentario" required></textarea>
        <p style="color: red">${erroComentario}</p>
        <div class="button-container">
            <button class="right-button">Publicar</button>
        </div>
    </form>

    <form id="enviarPorCategoria" method="post" action="/exibir-por-categoria">
        <input id="categoriaInput" type="hidden" name="categoriaId">
    </form>

</section>

<c:forEach var="comentario" items="${comentarios}">
    <section class="info-section">
        <img src="../images-index/livro-1.png" height="249" width="167"/>
        <div class="info-section-text">
            <h1>${comentario.nome} Comentou:</h1>
            <div class="info-section-text-button">
                <p>${comentario.comentario}.</p>
                <button class="button-info"></button>
            </div>
            <p>${comentario.redeSocial}</p>
        </div>
        <p style="color: red">Nome do livro: ${comentario.livro}</p>
    </section>
</c:forEach>

<footer>
    <img class="logo-nome" src="../logada/images-logada/logoNome.png" alt="Imagem Logo">
</footer>

<form id="enviarRequisicao" method="get" action="/alterar-usuario">
</form>

</body>
</html>

<script>
    function enviarDadosCategoria(categoriaId) {
        let categoria = document.getElementById('categoriaInput');
        let form = document.getElementById('enviarPorCategoria');
        categoria.value = categoriaId;

        form.submit();
    }

    function enviarRequisicao() {
        let form = document.getElementById('enviarRequisicao');
        form.submit();
    }
</script>