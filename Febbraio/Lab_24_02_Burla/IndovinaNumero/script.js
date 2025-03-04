var tentativi = 0;

function visualizzaRegole(){
    window.open("regole.html", "Come giocare", "menubar=no");
}

function generaNumero(){
    // genero numero casuale
    return Math.floor(Math.random() * 100) + 1;
}

function verificaNumero(){
    let numeroInserito = document.getElementById("casellaNumero").value;

    console.log(numeroInserito);
    if((!numeroInserito == "") && (tentativi <= 10)){
        if(numeroInserito == numeroGenerato){
            alert("Numero indovinato!");
            tentativi = 0;
            numeroGenerato = generaNumero();

        }else if(numeroInserito > numeroGenerato){
            alert("Il numero da indovinare è più piccolo");
            tentativi++;

        }else{
            alert("Il numero da indovinare è più grande");
            tentativi++;
        }
    }else{
        alert("Numero massimi di tentativi raggiunto o numero non valido");
    }
    console.log(tentativi);
}

//genero il numero casuale al primo avvio o al refresh della pagina
var numeroGenerato = generaNumero();