<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>

<input type="hidden" name="aviso"/>

<div class="logos">
    <a href="../index.html">
        <img src="img/voltar.png" class="logo-voltar">
    </a>
    <img src="img/logo-meio.png" class="logo-meio">
</div>


<section class="container">
<form action="/login" method="post">
    <h1>Faça seu Login</h1>
    <div class="forms">
        <input type="email" placeholder="Email" id="email" name="email" required/>
        <input type="password" placeholder="Senha" id="senha" name="senha" required/>
        <p>${aviso}</p>
    </div>
    <button class="atu" type="submit">Entrar</button>
</form>
    <hr>

    <p class="container-cadastro">Não tem cadastro?</p>

    <button class="atu" style="background-color: #F0D69E; color: #796650"><a href="../cadastro/cadastro.html">Cadastre-se</a></button>
</section>

</body>
</html>