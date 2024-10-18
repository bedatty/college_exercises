<?php 
    include('header.php'); 
    $data_nascimento = $_POST['data_nascimento'];
    $signos = simplexml_load_file("signos.xml");
    $dataFormatada = date('d/m', strtotime($data_nascimento));
    function obterSigno($data, $signos) {
        foreach ($signos->signo as $signo) {
            $dataInicio = DateTime::createFromFormat('d/m', (string)$signo->dataInicio);
            $dataFim = DateTime::createFromFormat('d/m', (string)$signo->dataFim);
            if ($dataInicio > $dataFim) {
                if ($data >= $dataInicio || $data <= $dataFim) return $signo;
            } else {
                if ($data >= $dataInicio && $data <= $dataFim) return $signo;
            }
        }
        return null;
    }
    $dataNascFormatada = DateTime::createFromFormat('d/m', $dataFormatada);
    $signoEncontrado = obterSigno($dataNascFormatada, $signos);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado do Signo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../style.css">
</head>
<body>
    <div class="container">
        <h2 class="text-center mb-5">Resultado do Signo</h2>
        <?php if ($signoEncontrado): ?>
            <div class="card mx-auto" style="max-width: 600px;">
                <div class="card-header text-center">
                    <i class="fas fa-star signo-icon"></i>
                    <strong><?php echo htmlspecialchars($signoEncontrado->signoNome); ?></strong>
                </div>
                <div class="card-body">
                    <p><strong>Data de Nascimento:</strong> <?php echo htmlspecialchars($data_nascimento); ?></p>
                    <h5 class="card-title"><strong>Signo:</strong> <?php echo htmlspecialchars($signoEncontrado->signoNome); ?></h5>
                    <p class="card-text"><strong>Descrição:</strong> <?php echo htmlspecialchars($signoEncontrado->descricao); ?></p>
                </div>
            </div>
        <?php else: ?>
            <div class="alert alert-danger mt-3 text-center">
                <strong>Erro:</strong> Não foi possível determinar o signo para a data informada.
            </div>
        <?php endif; ?>
        <div class="text-center mt-4">
            <a href="index.php" class="btn btn-primary">Voltar</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</body>
</html>