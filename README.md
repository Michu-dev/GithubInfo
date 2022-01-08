<h1 align="center">
    GithubInfo 
</h1>

## O projekcie
GithubInfo to napisana w [Java](https://www.java.com/) przy pomocy [Spring Boot](https://spring.io/) 
aplikacja serwerowa napisana umożliwiająca wyświetlenie
informacji o dowolnym użytkowniku serwisu GitHub. Zwraca ona przy pomocy metody
GET w formacie JSON informacje o:
* reozytorium i zdobytych w nim gwiazdkach
* łącznej sumie zdobytych gwiazdek
* językach programowania wykorzystywanych w repozytoriach użytkownika wraz z
liczbą bajtów kodu.
  

## Uruchamianie
Aby uruchomić aplikację należy pobrać repozytorium na własne urządzenie i 
uruchomić w katalogu projektu komendę `mvnw` (Windows), lub `./mvnw` (Mac & Linux).
Możliwe jest również uruchomienie aplikacji z poziomu środowiska Intellij po
odpowieniej konfiguracji.

## Testowanie
Aby przetestować, czy aplikacja zwraca odpowiednie dane o użytkowniku, po
uruchomieniu należy wpisać następujące polecenie w oknie przeglądarki lub przy pomocy narzędzia
Postman: `http://localhost:8080/nazwa_uzytkownika/`. Mozna przetestować
aktualną wersję bez uruchamiania aplikacji pod adresem:
`http://github-info-app-with-languages.herokuapp.com/nazwa_uzytkownika/`.
Przykład: <br><br>
http://github-info-app-with-languages.herokuapp.com/Michu-dev/ <br><br>
Rekomendacje dla przeglądarek: wtyczka [JSON Formatter](https://github.com/callumlocke/json-formatter)

## Uwagi
Aplikacja w celu wybrania odpowiednich danych korzysta z GitHub API. 
Niezautoryzowani użytkownicy posiadają tylko 60 możliwych zapytań w ciągu
godziny. Aktualna wersja aplikacji wykorzystuje `liczba_repozytoriow + 1`
takich zapytań dla każdego użytkownika, co wydłuża czas wykonanego żądania
oraz jest sporym ograniczeniem dla kont z dużą liczbą repozytoriów. Dostępna
jest również wersja bez listowania języków programowania z 1 zapytaniem dla
każdego użytkownika pod adresem: `http://github-info-app.herokuapp.com/nazwa_uzytkownika/`.
Przykład: <br><br>
http://github-info-app.herokuapp.com/Michu-dev/





