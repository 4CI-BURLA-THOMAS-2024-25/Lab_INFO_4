
let nomi = ["Alice", "Bob", "Carla", "Davide", "Elena"]; // Array iniziale

// Funzione per rimuovere un nome
function rimuoviNome() {
    let nomeInserito = document.getElementById("nomeInput").value.trim();

    if (nomeInserito === "") {
        alert("Inserisci un nome valido!");
        return;
    }

    let index = nomi.indexOf(nomeInserito); // Trova l'indice del nome

    if (index !== -1) {
        nomi.splice(index, 1); // Rimuove il nome se esiste
        aggiornaLista(); // Aggiorna la visualizzazione
        document.getElementById("nomeInput").value = ""; // Pulisce il campo input
    } else {
        alert("Nome non trovato nella lista!");
    }
}

// Funzione per aggiornare la lista visualizzata
function aggiornaLista() {
    let ul = document.getElementById("listaNomi");
    ul.innerHTML = ""; // Pulisce la lista

    nomi.forEach(nome => {
        let li = document.createElement("li");
        li.textContent = nome;
        ul.appendChild(li);
    });
}

//visualizza lista iniziale
aggiornaLista();