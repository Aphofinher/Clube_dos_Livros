<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang=pt-BR>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="logada.css">

    <title>Tela Logada</title>

</head>
<body>



<header>
    <div class="header-social">
        <img class="logo-nome" src="/src/main/webapp/images-index/logoNome.png" alt="Imagem Logo">
        <div class="search-bar">
            <div class="search-container">
                <input type="text" placeholder="Pesquisar">
                <button type="submit" class="icon-search">
                    <img src="images-logada/icon-search.png" alt="Ícone de Pesquisa">
                </button>
            </div>
        </div>
    </div>

</header>
<div id="menu">
    <ul class="menu-esquerdo">
        <li><a href="#">Clássicos</a></li>
        <li><a href="#">Psicologia</a></li>
        <li><a href="#">Finanças</a></li>
        <li><a href="#">Romance</a></li>
        <li><a href="#">Terror</a></li>
        <li><a href="#">Drama</a></li>
        <li><a href="#">Ação e Aventura</a></li>
        <li><a href="#">Biografia</a></li>
    </ul>
</div>

    <section class="comments">
        <img align="left" src="../cadastro/img/foto-murilo.png">
        <div class="comments-file">
        <span class="nomecomentuser">Murilo Santos</span>
        <input type="file" class="file">
        </div>
        <textarea class="comment-box" placeholder="Digite seu comentário"></textarea>
    </section>
    <div class="button-container">
        <button class="left-button">Selecione um livro</button>
        <button class="right-button">Publicar</button>
    </div>

<section class="info-section">
    <img src="../images-index/livro-1.png" height="249" width="167"/>
    <div class="info-section-text">
        <h1>Murilo Comentou:</h1>
        <div class="info-section-text-button">
        <p>individual. Mesmo décadas após sua publicação, o livro permanece relevante e impactante, lembrando-nos da importância da vigilância constante em relação ao poder e à política. É uma leitura essencial para qualquer pessoa interessada em ficção distópica e crítica social.</p>
        
        <button class="button-info"><img src="images-logada/conectarButton.png"></button>
        </div>
    </div>
</section>

<section class="info-section">
    <img src="../images-index/livro-1.png" height="249" width="167"/>
    <div class="info-section-text">
        <h1>Murilo Comentou:</h1>
        <div class="info-section-text-button">
            <p>individual. Mesmo décadas após sua publicação, o livro permanece relevante e impactante, lembrando-nos da importância da vigilância constante em relação ao poder e à política. É uma leitura essencial para qualquer pessoa interessada em ficção distópica e crítica social.</p>

            <button class="button-info"><img src="images-logada/conectarButton.png"></button>
        </div>
    </div>
</section>

<section class="info-section">
    <img src="../images-index/livro-1.png" height="249" width="167"/>
    <div class="info-section-text">
        <h1>Murilo Comentou:</h1>
        <div class="info-section-text-button">
            <p>individual. Mesmo décadas após sua publicação, o livro permanece relevante e impactante, lembrando-nos da importância da vigilância constante em relação ao poder e à política. É uma leitura essencial para qualquer pessoa interessada em ficção distópica e crítica social.</p>

            <button class="button-info"><img src="images-logada/conectarButton.png"></button>
        </div>
    </div>
</section>



    <section class="comment-list-section">
        <h2>Amigos -</h2>
        <ul class="comment-list">
            <li>
                <img class="round-photo" src="../cadastro/img/foto-murilo.png" alt="Foto 1">
                <span class="comment-name">Murilo Santos</span>
            </li>
            <li>
                <img class="round-photo" src="../cadastro/img/foto-murilo.png" alt="Foto 2">
                <span class="comment-name">Murilo Santos</span>
            </li>
            <li>
                <img class="round-photo" src="../cadastro/img/foto-murilo.png" alt="Foto 3">
                <span class="comment-name">Murilo Santos</span>
            </li>
            <li>
                <img class="round-photo" src="../cadastro/img/foto-murilo.png" alt="Foto 5">
                <span class="comment-name">Murilo Santos</span>
            </li>
        </ul>
    </section>

<footer>
    <img class="logo-nome" src="/src/main/webapp/images-index/logoNome.png" alt="Imagem Logo">
</footer>

</body>
</html>