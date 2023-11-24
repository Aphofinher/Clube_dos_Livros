<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="index.css">
    <title>Document</title>
</head>
<body>



<header>
    <div class="image-button">
        <img class="logo-nome" src="/images-index/logoNome.png" alt="Imagem Logo">

        <a href="login/login.jsp"><button class="button">Login/Cadastre-se</button></a>

    </div>
    <hr>
    <h1>${deletado}</h1>
    <hr>
    <p class="subtitle">A rede social dos livros.</p>
</header>

<section>
    <p class="info-livros">Mais comentados da semana</p>

    <div class="livros">
        <div class="livro1">
            <img src="/images-index/livro-1.png">
            <p class="titulo-livro">É assim que começa</p>
            <p class="autor-livro">Collen Hoover</p>
        </div>
        <div class="livro1">
            <img src="/images-index/livro-2.png">
            <p class="titulo-livro">O homem mais rico da</p>
            <p class="autor-livro">George Clason</p>
        </div>
        <div class="livro1">
            <img src="/images-index/livro-3.png">
            <p class="titulo-livro">Verity</p>
            <p class="autor-livro">Collen Hoover</p>
        </div>
        <div class="livro1">
            <img src="/images-index/livro-4.png">
            <p class="titulo-livro">1984</p>
            <p class="autor-livro">George Orwell</p>
        </div>
    </div>
</section>


<p class="info-comment">Feedbacks</p>


</section>
<section class="comments">

    <p class="aspasinicio">❝</p>
    <p>Tenho descoberto bons livros para ler graças ao Bookish!!!</p>
    <p align="right" class="aspasfinal">❞</p>
    <span class="nomecomentuser">Ygor Gomes</span>

</section>

<section class="comments">

    <p class="aspasinicio">❝</p>
    <p>Estou conhecendo varios leitores e adquirindo conversas sobre as obras!!!</p>
    <p align="right" class="aspasfinal">❞</p>
    <span class="nomecomentuser">Murilo Santos</span>

</section>

<section class="comments">

    <p class="aspasinicio">❝</p>
    <p>Bookish, o melhor com certeza!!! s2</p>
    <p align="right" class="aspasfinal">❞</p>
    <span class="nomecomentuser">Schevechenco</span>

</section>

<section class="comments">

    <p class="aspasinicio">❝</p>
    <p>Adorei a proposta do site! Facilita muito a busca por novos livros e autores. A navegação é simples e eficiente, tornando a descoberta de novas leituras uma experiência prazerosa.</p>
    <p align="right" class="aspasfinal">❞</p>
    <span class="nomecomentuser">Lucas Freire</span>

</section>

<section class="comments">

    <p class="aspasinicio">❝</p>
    <p>Ótima iniciativa para conectar leitores a novos horizontes literários!</p>
    <p align="right" class="aspasfinal">❞</p>
    <span class="nomecomentuser">Kelvin Oliveira</span>

</section>

<footer>
    <p class="subtitlefooter">Bookish bounding</p>
</footer>

<script src="script.js"></script>
</body>
</html>