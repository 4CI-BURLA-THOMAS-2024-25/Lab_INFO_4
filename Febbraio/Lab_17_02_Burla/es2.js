let lista = []; // Array per memorizzare gli elementi

function aggiungiElemento() {
    let item = document.getElementById("item").value.trim();

    if (item === "") {
        alert("Inserisci un elemento valido!");
        return;
    }

    lista.push(item); // Aggiunge l'elemento all'array
    aggiornaLista(); // Aggiorna la visualizzazione
    document.getElementById("item").value = ""; // Pulisce il campo di input
}

function aggiornaLista() {
    let ul = document.getElementById("listaSpesa");
    ul.innerHTML = ""; // Svuota la lista prima di aggiornarla

    lista.forEach((elemento, index) => {
        let li = document.createElement("li");
        li.innerHTML = `${elemento} <button class="remove-button" onclick="rimuoviElemento(${index})">X</button>`;
        ul.appendChild(li);
    });
}

function rimuoviElemento(index) {
    lista.splice(index, 1); // Rimuove l'elemento dall'array
    aggiornaLista(); // Aggiorna la lista
}
