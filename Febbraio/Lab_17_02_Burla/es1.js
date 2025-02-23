function visualizzaFinestrella(){
    const campiForm = document.forms["form"];
    const nome = campiForm[0].value;
    const cognome = campiForm[1].value;
    const email = campiForm[2].value;
    window.alert("Benvenuto " + nome + " " + cognome  + ".");
}