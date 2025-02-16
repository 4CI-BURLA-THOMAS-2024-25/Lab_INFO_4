**Diario di bordo di Burla Thomas 4CI**
===================================

## 1. **Definizione dell'Idea**
   - **Definizione dell'idea**: File Manager che consente di effettuarre le oiperazioni di base con i file e le directory (successivamente si penserà alle operazioni più complesse).
   - **Target**: chiunque.

## 2. **Diario di bordo**
### 1. **25 Novembre 2024**
   - **Ordine del giorno**: Studio il linguaggio markdown per produrre il diario di bordo.
   Il markdown è un linguaggio a marcatori, come html per intenderci, ma che a differenza di quest'ultimo adotta una sintassi più "leggera", rendendo il testo più facile da leggere e consentendo allo scrittore di non focalizzarsi troppo sulla sintassi del linguaggio. In particolare, imparo la sintassi markdown di titoli, sottotitoli, testi in grassetto/corsivo, paragrafi, liste (numerate e non), immagini, links e tabelle. Inizio a stendere le prime idee sul progetto da realizzare.
   
   | Marcatore | Effetto |
   | --------- | ------- |
   | ** ... ** | testo in grassetto |
   | _ ... _   | testo in corsivo |
   | ========= | titolo |
   | # ... (fino a 3 #) | sottotitolo |
   | * ... | lista non numerata |
   | 1. ... | lista numerata |
   | ![Nome immagine] (indirizzo immagine "titolo") | immagine |
   | [Nome link] (link) | collegamento |

   - **Sitografia**: [Sito fornito dall'insegnante](https://www.html.it/articoli/markdown-guida-al-linguaggio/) con integrazione di IA ([ChatGPT](https://chat.openai.com) o [Copilot](https://copilot.microsoft.com))

### 2. **2 Dicembre 2024**
   - **Ordine del giorno**: Perfeziono quanto scritto precedentemente nel diario di bordo, inserendo una tabella che riassume i principali marcatori markdown.
   Inizio a scrivere le basi del software da sviluppare: ho realizzato un file manager "elementare" che, dato un path inserito nella casella di testo apposita (di default impostato sulla cartella dell'utente), quando si clicca sul bottone "Vai" visualizza il contenuto della directory specificata. Ovviamente, viene fatto un controllo sul path e viene gestito il caso in cui la directory sia vuota.
   Inizio a considerare una possibile implementazione del software con JavaFX.
   Mi avvalgo delle cosiddette _lambda expressions_, ovvero di definizioni di metodi degli ascolatoti all'interno del campo riservato ai parametri (per comodità risulta accettabile; potrebbe essere una schifezza da vedere, a questo si penserà in altro momento).
   - **Sitografia**: [File Java API](https://docs.oracle.com/javase/8/docs/api/java/io/File.html), [JList Java API](https://docs.oracle.com/javase/8/docs/api/javax/swing/JList.html), [JButton Java API](https://docs.oracle.com/javase/8/docs/api/javax/swing/JButton.html), [JTextField Java API](https://docs.oracle.com/javase/8/docs/api/javax/swing/JTextField.html), [BorderLayout Java API](https://docs.oracle.com/javase/8/docs/api/java/awt/BorderLayout.html).

### 3. **9 Dicembre 2024**
   - **Ordine del giorno**: mi cimento nello studio degli ascoltatori per il mouse (MouseListener e MouseAdapter, che consente di implemetare selettivamente solo alcuni metodi di MouseListener) per poter aprire una directory (o un file) una volta che viene cliccato nella GUI.
   Ovviamente, studio anche i MouseEvent per gestire i comportamenti del mouse.
   Innanzitutto, faccio in modo di prelevare il nome del file che viene selezionato dalla JList con il puntatore del mouse, aggiornando così il path da visualizzare; per fare ciò, dò uno sguardo a ListModel.
   Studio poi la classe Desktop, che permette di aprire i file con l'app predefinita.
   - **Sitografia**: [MouseAdapter Java API](https://docs.oracle.com/javase/8/docs/api/java/awt/event/MouseAdapter.html), [MouseEvent Java API](https://docs.oracle.com/javase/8/docs/api/java/awt/event/MouseEvent.html), [ListModel](https://docs.oracle.com/javase/8/docs/api/javax/swing/ListModel.html), [Desktop Java API](https://docs.oracle.com/javase/8/docs/api/java/awt/Desktop.html)
   - **DA RISOLVERE**: problema legato al path che, una volta clicatta con il mouse una directory dalla lista, non aggiorna correttamente il path (rif. riga 78).

### 4. **16 Dicembre 2024**
   - **Ordine del giorno**: innanzitutto, risolvo il problema segnalato al passo precedente creando un oggetto di classe File, che indica il file selezionato da GUI, a partire da un indirizzo relativo (path della directory e nome del file), di cui poi ottengo il percorso assoluto che, nel caso di una directory, verrà impostato come nuovo path del campo di testo (il metodo della concatenazione utilizzato in precedenza creava problemi). Studio come utilizzare il _throw exception_ per generare eccezioni differenziate in base alla situazione aiutandomi anche con la spiegazione di IA. In particolare, si noti come la parola chaiave _throw_ venga utilizzata per lanciare un'eccezione, mentre la parola chiave _throws_ viene utilizzata per indicare che un metodo può lanciare una determinata eccezione durante la sua esecuzione. Faccio ordine nel codice e lo riorganizzo secondo il pattern MVC, in precedenza era considerabile come insieme di appunti e non un programma ordinato.
   - **Sitografia**: [throw and throws in Java](https://www.geeksforgeeks.org/throw-throws-java/), [How to Throw Exceptions Java](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html)

### 5. **27 Dicembre 2024**
   - **Ordine del giorno**: sistemo codice inserendo tutti i commenti necessari per una comprensione agevolata.

### 6. **29 Dicembre 2024**
   - **Ordine del giorno**: implemetare la possibilità di visualizzare un file o il contenuto di una directory premendo il tasto _INVIO_ della tastiera anzichè cliccare necessariamente il bottone che sta in basso nella GUI quando il campo di testo è selezionato. Per fare ciò, utilizzo la classe KeyAdapter di Java che mi consente di scrivere solo i metodi necessari anziché tutti i metodi di KeyListener.
   Sempre con l'ausilio dell'interfaccia KeyAdapter, aggiungo la possibilità di aprire un file o una directory premendo il tasto _INVIO_ dopo aver selezionato il file o la directory in questione dalla GUI. A tal proposito, quando un elemento sarà cliccato due volte di fila verrà aperto (come implementato in precedenza), mentre quando sarà cliccato solo una volta verrà passato il focus della tastiera alla JList dei files. A tal proposito, le interfacce MouseAdapter e KeyAdapter associate a JList condividono un oggeto di classe _Point_, cosicché l'ascoltatore del mouse possa comunicare all'ascoltatore della tastiera il punto in cui è avvenuto il singolo click e quest'ultimo possa così ottenere l'indice dell'elemento selezionato.
   Inizio a implemetare il tasto _indietro_ che consente di andare alla directory superiore: utilizzo la classe JButton che conterrà l'icona e, per posizionare l'immagine, creo un pannello con BorderLayout che conterrà il JButton dell'icona e il JTextField del path e che sarà contenuto nel pannello principale in alto.
   Si presenta anche la necessità di scalare l'icona orginiale per inserirla nel sottopannello.
   - **Sitografia**: [KeyAdapter Java API](https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyAdapter.html)

### 7. **20 Gennaio 2025**
   - **Ordine del giorno**: preparo l'icona personalizzata per il tasto directory superiore mediante il software di fotoritocco GIMP.

### 8. **3 Febbraio 2025**
   - **Ordine del giorno**: per una migliore distinzione tra i diversi tipi di files e le directory all'interno del file system, cerco informazioni online per capire se è possibile affiancare ad ogni elemento di ciascuna directory la sua icona: nel caso di una directory, comparirà l'icona di una cartella, nel caso di un file comparirà l'icona del programma predefinito dell'OS per aprire tale tipo di file. Considero l'utilizzo di due JList (una per le icone, l'altra già esistente per i files) affiancate con barre di scorrimento sincronizzate. Per le icone dei files/directory, studio FileSystemView.
   - **Sitografia**: [FileSystemView Java API](https://docs.oracle.com/javase/8/docs/api/javax/swing/filechooser/FileSystemView.html), [JScrollPane Java API](https://docs.oracle.com/javase/8/docs/api/javax/swing/JScrollPane.html), [Icon Java API](https://docs.oracle.com/javase/8/docs/api/javax/swing/Icon.html)

### 9. **16 Febbraio 2025**
   - **Ordine del giorno**: implemento le icone accanto a ciascun file visualizzato nel FS come descritto al punto precedente.

## 3. **Design dell'Architettura**
   - **Design dell'Architettura**: linguaggio Java per produrre un software desktop.
   - **Pattern di Progettazione**: MVC (Model View Controller), che separa le classi inrelazione al loro scopo.

## 4. **Progettazione del Sistema**
   - **Diagrammi UML**: si trovano nella directory principale del progetto.

## 5. **Setup dell'Ambiente di Sviluppo**
   - **IDE**: Apache NetBeans IDE.
   - **JDK**: utilizzata ultima versione di Java Development Kit (JDK 23).

## 6. **Sviluppo**
   - **Struttura del Progetto**: classi organizzate in package in relazione alla loro funzionalità; organizzzazione secondo MVC.
   - **Scrivere Codice**: scrivo il codice nel modo più ordinato e leggibile possibile; approfondisco man mano le classi che utilizzo.
   - **Version Control**: effettutato tramite GIT e GitHub Desktop.