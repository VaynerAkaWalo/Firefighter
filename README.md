# Firefighter - minigierka dla programistów

Aby uruchomić wpisujemy w terminalu:
```
mvn spring-boot:run
```

Po uruchomienu wpisujemy w przeglądarce:
```
http://localhost:8080/firefighter
```

albo klikamy tutaj: [Firefighter](http://localhost:8080/firefighter)

## Opis gry
Celem gry jest gaszenie płonącego lasu. Las reprezentowany jest jako plansza 50 x 50.
Ogień na planszy rosprzestrzenia się cały czas, co za tym idzie las wymaga stałej opieki strażaków.
Jednak strażacy nie wiedzą gdzie powinni ugasić pożar w danej chwili dlatego potrzebują gracza który będzie ich wysyłał w odpowiednie miejsca na planszy.
Komunikacja między strażakami a graczem realizowana jest przez API.

Gracz w celu wysłania strażaków do danego miejsca na planszy musi wysłać GET request na adres:
```
localhost:8080/firefighter/extinguish?x=#&y=#
```
Gdzie znak # powinien zastąpić liczbą z przedziału 0-49. (liczby z poza przedziału będą ignorowane przez serwer).

Dodatkowo gracz w celu optymalizacji, żeby nie wysyłać strażaków bez potrzeby do niepalącej się komórki planszy może pobrać aktualny stan planszy wysyłając GET request na adres:
```
localhost:8080/firefighter/board
```
Odpowiedzią serwera powinnien być boolean[50][50] z aktualnym stanem planszy.




