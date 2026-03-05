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

let ativosFiis = JSON.parse(localStorage.getItem("listaFiis")) || [
  "MXRF11",
  "GARE11",
  "KNCR11",
  "IT4USA",
];

function renderizarLista() {
  const listaUl = document.getElementById("Lista-fiis");
  listaUl.innerHTML = ""; //garantir que um campo esteja vazio

  ativosFiis.forEach((ativo, index) => {
    const li = document.createElement("li"); //criar um elemento na page sem precisar mudar o HTML
    li.innerText = ativo + " "; //preenchendo o campo (li)
    //logica de criacao do butao
    const butnRemove = document.createElement("Button");
    butnRemove.innerText = "❌";
    butnRemove.classList.add("butn-exclui");

    butnRemove.onclick = function () {
      //quando tivermos o clique irá chamar a funcão que retira o item da lista
      removerAtivo(index);
    };
    li.appendChild(butnRemove); //add o botao
    listaUl.appendChild(li); //anexando o filho "li" ao pai "UL"
  });
}

function adicionarAtivo() {
  const campoAtivo = document.getElementById("novoAtivo");
  const novoTicker = campoAtivo.value.toUpperCase().trim();

  if (novoTicker !== "") {
    ativosFiis.push(novoTicker);
    localStorage.setItem("listaFiis", JSON.stringify(ativosFiis));
    campoAtivo.value = "";
    renderizarLista();
    console.log("Ativo adicionado: " + novoTicker);
  }
}

function removerAtivo(pos) {
  //remove um item na posicao indicada
  ativosFiis.splice(pos, 1);
  // atualizamos o banco de dados do navegador
  localStorage.setItem("listaFiis", JSON.stringify(ativosFiis));
  //mostramos a nova lista paos a remocao
  renderizarLista();
  console.log("Ativo removido da sua carteira");
}
document.addEventListener("DOMContentLoaded", renderizarLista);
