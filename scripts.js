console.log("O JavaScript foi carregado com sucesso!");

//declarações de variaveis
function analisarInvestimento() {
  const campoSaldo = document.getElementById("inputSaldo");
  const campoVolatilidade = document.getElementById("inputVolatilidade");
  const displayMensagem = document.getElementById("mensagemStatus");

  const saldo = parseFloat(campoSaldo.value);
  const volatilidade = parseInt(campoVolatilidade.value);

  if (isNaN(saldo) || isNaN(volatilidade)) {
    displayMensagem.innerText =
      "Por faovr, preencha os dois campos com numeros.";
    displayMensagem.style.color = "red";
    return;
  }

  //Logica para a recomendação do aporte ou nao
  if (saldo >= 1000 && volatilidade <= 3) {
    displayMensagem.innerText =
      "Recomendado! Saldo e Volatilidade coerentes para o aporte";
    displayMensagem.style.color = "#28a745";
  } else if (saldo < 1000 && volatilidade <= 3) {
    displayMensagem.innerText =
      "O ativo é seguro, mas seu saldo é abaixo do recomendado.";
    displayMensagem.style.color = "#ffc107";
  } else {
    displayMensagem.innerText =
      "Aporte não recomendado. Volatilidade muito alta para o perfil.";
    displayMensagem.style.color = "#dc3545";
  }
  //guardar valor no navegador (evitar perda no f5)
  localStorage.setItem("saldoUsuario", saldo);
}

window.onload = function () {
  const saldoSalvo = localStorage.getItem("saldoUsuario");

  if (saldoSalvo) {
    document.getElementById("inputSaldo").value = saldoSalvo;
    console.log("Saldo recuperado com sucesso!");
  }
};
