// simbolo da posizionare
const simbolo = document.getElementById("simboloPosizionando");
//tabella della griglia
const griglia = document.getElementById("griglia");

function posizionaSimbolo(){
    var cellaCliccata = event.target;
    
    //clono immagine
    const immagineClonata = simbolo.cloneNode(true);

    // aggiungo l'immagine clonata alla cella cliccata
    cellaCliccata.appendChild(immagineClonata);

    //cambio simbolo successivo da posizionare
    if(simbolo.getAttribute("src") == "x.svg"){
        simbolo.setAttribute("src", "o.svg");
    }else{
        simbolo.setAttribute("src", "x.svg");
    }
}

