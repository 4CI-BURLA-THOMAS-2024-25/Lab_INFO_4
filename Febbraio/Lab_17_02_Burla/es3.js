function contaCaratteri() {
    let testo = document.getElementById("testo").value;
    let contatore = document.getElementById("contatore");
    let lunghezza = testo.length;

    contatore.textContent = `Caratteri: ${lunghezza}`;
}
