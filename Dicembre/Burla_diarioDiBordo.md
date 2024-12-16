**Diario di bordo di Burla Thomas 4CI**
===================================


## 1. **25 Novembre 2024**
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

   - **Definizione dell'idea**: File Manager che consente di effettuarre le oiperazioni di base con i file e le directory (successivamente si penserà alle operazioni più complesse).

   - **Design dell'Architettura**: linguaggio Java per produrre un software desktop, con l'ausilio dell'architettura MVC.

   - **Setup dell'Ambiente di Sviluppo**: utilizzo di Apache NetBeans IDE.

## 2. **2 Dicembre 2024**
   - **Ordine del giorno**: Perfeziono quanto scritto precedentemente nel diario di bordo, inserendo una tabella che riassume i principali marcatori markdown.
   Inizio a scrivere le basi del software da sviluppare: ho realizzato un file manager "elementare" che, dato un path inserito nella casella di testo apposita (di default impostato sulla cartella dell'utente), quando si clicca sul bottone "Vai" visualizza il contenuto della directory specificata. Ovviamente, viene fatto un controllo sul path e viene gestito il caso in cui la directory sia vuota.
   Inizio a considerare una possibile implementazione del software con JavaFX
   - **Sitografia**: [File Java API](https://docs.oracle.com/javase/8/docs/api/java/io/File.html), [JList Java API](https://docs.oracle.com/javase/8/docs/api/javax/swing/JList.html), [JButton Java API](https://docs.oracle.com/javase/8/docs/api/javax/swing/JButton.html).

## 3. **9 Dicembre 2024**
   - **Ordine del giorno**: mi cimento nello studio degli ascoltatori per il mouse (MouseListener e MouseAdapter, che consente di implemetare selettivamente solo alcuni metodi di MouseListener) per poter aprire una directory (o un file) una volta che viene cliccato nella GUI.
   Ovviamente, studio anche i MouseEvent per gestire i comportamenti del mouse.
   Innanzitutto, faccio in modo di prelevare il nome del file che viene selezionato dalla JList con il puntatore del mouse, aggiornando così il path da visualizzare; per fare ciò, dò uno sguardo a ListModel.
   Studio poi la classe Desktop, che permette di aprire i file con l'app predefinita.
   - **Sitografia**: [MouseAdapter Java API](https://docs.oracle.com/javase/8/docs/api/java/awt/event/MouseAdapter.html), [MouseEvent Java API](https://docs.oracle.com/javase/8/docs/api/java/awt/event/MouseEvent.html), [ListModel](https://docs.oracle.com/javase/8/docs/api/javax/swing/ListModel.html), [Desktop Java API](https://docs.oracle.com/javase/8/docs/api/java/awt/Desktop.html)
   - **DA RISOLVERE**: problema legato al path che, una volta clicatta con il mouse una directory dalla lista, on aggiorna correttamente il path (rif. riga 78).