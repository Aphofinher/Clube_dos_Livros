function enviarSolicitacao() {

        let senha = document.getElementById('senha').value;
        let confirmaSenha = document.getElementById('confirmaSenha').value;

        if (senha === confirmaSenha) {

            document.getElementById('formulario-principal').submit();
            let sucesso = document.getElementById('sucesso');
            sucesso.classList.remove('esconder-compenente');

            setTimeout(5000, () => {
                sucesso.classList.add('esconder-compenente');
                document.location.href='index.hmtl';
            });

        } else {

            let erro = document.getElementById('erro');
            erro.classList.remove('esconder-componente');

            setTimeout(5000, () => {
                erro.classList.add('esconder-componente');
            });

        }

    }