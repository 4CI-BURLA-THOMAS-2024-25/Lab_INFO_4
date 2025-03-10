// simbolo da posizionare
const simbolo = document.getElementById("simboloPosizionando");
//tabella della griglia
const griglia = document.getElementById("griglia");
const celle = document.getElementsByTagName("td");

function posizionaSimbolo(){
    var cellaCliccata = this;
    
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

//associo ascoltatore del click ad ogni cella della tabella
for(let i = 0; i < celle.length; i++){
    celle[i].addEventListener("click", posizionaSimbolo);
}