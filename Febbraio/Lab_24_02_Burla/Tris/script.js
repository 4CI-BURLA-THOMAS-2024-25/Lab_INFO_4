// simbolo da posizionare
const simbolo = document.getElementById("simboloPosizionando");

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

//associo ascoltatore del click ad ogni cella della tabella
document.getElementById("0,0").addEventListener("click", posizionaSimbolo);
document.getElementById("0,1").addEventListener("click", posizionaSimbolo);
document.getElementById("0,2").addEventListener("click", posizionaSimbolo);
document.getElementById("1,0").addEventListener("click", posizionaSimbolo);
document.getElementById("1,1").addEventListener("click", posizionaSimbolo);
document.getElementById("1,2").addEventListener("click", posizionaSimbolo);
document.getElementById("2,0").addEventListener("click", posizionaSimbolo);
document.getElementById("2,1").addEventListener("click", posizionaSimbolo);
document.getElementById("2,2").addEventListener("click", posizionaSimbolo);