function verificaPalindroma(){
    let form = document.forms["form"];
    parola = form[0];
    for(let i = 0; i < (parola.length) / 2; i++){
        for(let ii = parola.length - 1; ii > (parola.length) / 2 ; ii++){
            if(!(parola.chartAt(i).equalsIgnoreCase(parola.chartAt(ii)))){
                return false;
            }
        }
    }
    return true;
}

if(verificaPalindroma() == true){
    alert("La parola è palindroma");
}else{
    alert("La parola NON è palindroma");
}