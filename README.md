# TODOList

## 1. Temat projektu

Projekt ma w założeniu tworzyć oraz przechowywać notatki w postaci ToDo list. Możliwa będzie ich edycja, jak i usuwanie.
## 2. Użyte wzorce projektowe

- ### Wzorce kreacyjne:

  - Budowniczy - tworzenie konkretnych notatek, możliwość wyboru czy notatka ma posiadać datę

  - Singleton - baza  użytkowników jako publiczny obiekt oraz Tagi dla notatek

- ### Wzorce behawioralne:

  - Polecenie - dzialanie programu (stworz, usun, edytuj)

  - Pamiątka - ręczne backupy  

  - Iterator - iterowanie po notatkach jedna po drugiej
  
- ### Wzorce strukturalne:

  - Dekorator - kodowanie treści wybranej notatki w base64 

  - Proxy - dany użytkownik ma dostęp tylko do swoich notatek


select imie || ' ' || nazwisko as "DANE CZYTELNIKA", count(g_nazwa) as "LICZBA GATUNKOW" 
from czytelnik 
join wypozyczenia on czytelnik.id_czyt = wypozyczenia.id_czyt 
join ksiazka on wypozyczenia.id_czyt = ksiazka.id_ks
join gatunek on ksiazka.id_gat = gatunek.id_gat
group by imie, nazwisko
order by count(g_nazwa) desc;

select count(w_nazwa) as ilosc from ksiazka
join wydawnictwo on ksiazka.id_wyd = wydawnictwo.id_wyd
where wydawnictwo.id_wyd = (
select id_wyd from ksiazka
order by data_wyd asc
fetch first row only
);

select f_nazwa, count(wypozyczenia.id_wyp) as "FORMAT KSIAZKI" from format
join ksiazka on format.id_for = ksiazka.id_for
join wypozyczenia on ksiazka.id_ks = wypozyczenia.id_ks
where wypozyczenia.data_wyp > sysdate - 90
group by f_nazwa
order by count(wypozyczenia.id_wyp) DESC
fetch first row only
;
