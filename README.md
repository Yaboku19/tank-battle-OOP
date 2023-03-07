# tank-battle-OOP
tank-battle project
ll gruppo si pone come obiettivo quello di ricreare una versione personalizzata di "Tank Shoot 2D" . Ovvero creare un gioco 2-player, dove ogni giocatore controlla un carro armato e ha come obiettivo quello di sconfiggere l'altro.
(https://store.steampowered.com/app/1377780/Tank_Shoot_2D__Battle_to_save_City_Flag/)

Funzionalità minimali ritenute obbligatorie:
- creazione della mappa con ostacoli e limiti di mappa
- gestione movimento con input da tastiera dei carri armati, movimenti N-S-W-O
- gestione delle collisioni
- dinamica dello sparo, lunghezza sparo e collisione con gli oggetti / carri armati
- gestione del punteggio, tenere traccia delle partite già fatte
- gestione di fine partita (iniziarne un'altra o uscire dal gioco)
- gestione inizio partita (posizione iniziale carri armati, settaggio di inizio gioco)

Funzionalità opzionali:
- creazione di mappe differenti
- creazione di diversi tipi di carri armati con differenti caratteristiche
- menu iniziale di settaggio della partita (tempo, handicap, tipo di carro armato, scelta mappa)
- gestione effetti sonori
- ostacoli rompibili
- gestione della grafica con sprite per la mappa e i carri armati

"Challenge" principali:
- gestione dell'interazione tra i due player
- gestione dei thread dei carri armati e dell'input simultaneo
- gestione del colpo del proiettile, con interazione con i vari oggetti della mappa

Suddivisione lavoro
Emanuele Martelli:
- dinamica dello sparo
- creazione della mappa e impostazione dei limiti
* menu iniziale di settaggio della partita

Riccardo Frascio:
- gestione inizio / fine gioco
- creazione degli ostacoli
* creazione di diversi tipi di carri armati

Tomas Ventrucci:
- gestione movimento e input da tastiera
* gestione effetti sonori
* ostacoli rompibili

Lucrezia Rettori:
- gestione delle collisioni
- gestione del punteggio
* creazione di mappe differenti
