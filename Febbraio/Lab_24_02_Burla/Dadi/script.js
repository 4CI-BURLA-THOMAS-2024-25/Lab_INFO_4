//salvo reference dado1
const dado1 = document.getElementById("dado1");
//salvo reference dado2
const dado2 = document.getElementById("dado2");

//salvo esito del lancio 1
var lancioDado1;
//salvo esito del lancio 2
var lancioDado2

//salvo reference del form con i nomi
const formNomi = document.forms["nomiGiocatori"];

//giocatore che ha lanciato
let lanciando;

//tabella per output somme
const tabellaRisultati = document.getElementById("risultati");

function visualizzaRegole(){
    window.open("regole.html", "Come giocare", "menubar=no");
}

function sorteggiaNome(){
    //controllo input 
    if((formNomi.elements[0].value != "") && (formNomi.elements[1].value != "")){
        //durante il gioco, impedisco modifica nomi
        for(let i = 0; i < formNomi.length; i++){
            formNomi.elements[i].setAttribute("disabled", true);
        }

        //sorteggio
        let inizia = generaRandom(2);
        if(inizia == 1){
            window.alert("Inizia il giocatore " + `${formNomi.elements[0].value}`);
        }else{
            window.alert("Inizia il giocatore " + `${formNomi.elements[1].value}`);
        }

        //blocco bottone sorteggia
        document.getElementById("bottoneSorteggio").setAttribute("disabled", true);
        //chi inizia, è anche colui che lancia
        lanciando = formNomi.elements[inizia - 1].value;
    }else{
        window.alert("Inserire nomi giocatori!");
    }
    
}

//funzione per generare un numero random tra 1 e il numero fornito
function generaRandom(massimo){
    return Math.floor(Math.random() * massimo) + 1;
}

function lanciaDadi(){
    //controllo che sia stato scelto il nome del giocatore che inizia
    if(lanciando != null){
        //imposto animazione dado1
        dado1.setAttribute("src", "lancio.webp");
        //imposto animazione dado2
        dado2.setAttribute("src", "lancio.webp");
        //lancio primo dado, numero random tra 1 e 6
        lancioDado1 = generaRandom(6);
        console.log(lancioDado1);
        //lancio secondo dado, numero random tra 1 e 6
        lancioDado2 = generaRandom(6);
        console.log(lancioDado2);
    }else{
        window.alert("Sorteggiare prima per stabilire chi inizierà!");
    }
}

function fermaDadi(){
    //controllo che i dadi siano stati lanciati
    if((dado1.getAttribute("src") == "lancio.webp") && (dado2.getAttribute("src") == "lancio.webp")){
        //imposto immagine del primo dado in base al numero uscito
        switch(lancioDado1){
            case 1:{
                dado1.setAttribute("src", "1.svg");
                break;
            }

            case 2:{
                dado1.setAttribute("src", "2.svg");
                break;
            }

            case 3:{
                dado1.setAttribute("src", "3.svg");
                break;
            }

            case 4:{
                dado1.setAttribute("src", "4.svg");
                break;
            }

            case 5:{
                dado1.setAttribute("src", "5.svg");
                break;
            }

            case 6:{
                dado1.setAttribute("src", "6.svg");
                break;
            }
        }

        //importo immagine del primo dado in base al numero uscito
        switch(lancioDado2){
            case 1:{
                dado2.setAttribute("src", "1.svg");
                break;
            }

            case 2:{
                dado2.setAttribute("src", "2.svg");
                break;
            }

            case 3:{
                dado2.setAttribute("src", "3.svg");
                break;
            }

            case 4:{
                dado2.setAttribute("src", "4.svg");
                break;
            }

            case 5:{
                dado2.setAttribute("src", "5.svg");
                break;
            }

            case 6:{
                dado2.setAttribute("src", "6.svg");
                break;
            }
        }

        //salva esito del lancio
        salvaEsito();

        //cambio nome del giocatore che sta lanciando, se non è il primo turno
        if(!(document.getElementById("risultati").rows.value == 1)){
            if(lanciando == formNomi.elements[0].value){
                lanciando = formNomi.elements[1].value;
            }else{
                lanciando = formNomi.elements[0].value;
            }
        }
        
    }else{
        window.alert("Lanciare prima i dadi!");
    }
}

function salvaEsito(){
    //calcolo somma dei due dadi
    let somma = lancioDado1 + lancioDado2;

    //aggiugno riga
    let nuovaRiga = tabellaRisultati.insertRow();

    //aggiungo celle
    let cella1 = nuovaRiga.insertCell(0);
    let cella2 = nuovaRiga.insertCell(1);

    //inserisco testo nelle celle
    cella1.textContent = lanciando;
    cella2.textContent = somma;
    
    //se la somma è 12, non ha senso proseguire
    if(somma == 12){
        window.alert("Vince il giocatore " + `${lanciando}`);
        //blocco bottone per lanciare
        document.getElementById("bottoneGira").setAttribute("disabled", true);
    }
}

//assegno al bottone delle regole l'ascoltatore
document.getElementById("bottoneRegole").addEventListener("click", visualizzaRegole);

//assegno ascoltatore per lanciare i dadi
document.getElementById("bottoneGira").addEventListener("click", lanciaDadi);

//assegno ascoltatore per fermare i dadi lanciati
document.getElementById("bottoneFerma").addEventListener("click", fermaDadi);

//assegno ascoltatore per stabilire quale giocatore inizia
document.getElementById("bottoneSorteggio").addEventListener("click", sorteggiaNome);