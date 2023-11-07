<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container">
        <h1>Formulário de Cadastro</h1>
        <form action="CreateController" method="post">
            <div class="form-group">
                <label for="nomeCliente">Nome:</label>
                <input type="text" class="form-control" id="nomeCliente" name="nomeCliente" required>
            </div>
            <div class="form-group">
                <label for="cpfCliente">CPF:</label>
                <input type="text" class="form-control" id="cpfCliente" name="cpfCliente" required pattern="\d{3}\.\d{3}\.\d{3}-\d{2}">
                <small class="form-text text-muted">Formato: 123.456.789-01</small>
            </div>
            <div class="form-group">
                <label for="enderecoCliente">Endereço:</label>
                <input type="text" class="form-control" id="enderecoCliente" name="enderecoCliente" required>
            </div>
            <div class="form-group">
                <label for="telefoneCliente">Telefone:</label>
                <input type="tel" class="form-control" id="telefoneCliente" name="telefoneCliente" required pattern="\(\d{2}\) \d{4,5}-\d{4}">
                <small class="form-text text-muted">Formato: (00) 12345-6789</small>
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </div>

</body>
</html>