# TODOList

## 1. Temat projektu

Projekt ma w założeniu tworzyć oraz przechowywać notatki w postaci ToDo list. Możliwa będzie ich edycja, jak i usuwanie.
## 2. Użyte wzorce projektowe

- ### Wzorce kreacyjne:

  - Fabryka Abstrakcyjna - stworzenie fabryki dla różnych typów notatek (nadklasa notatki i nadklasa fabryki)

  - Budowniczy - tworzenie konkretnych notatek, możliwość wyboru czy notatka ma posiadać tytuł/temat/ikonka/data/przypomnienie 

  - Singleton - baza  użytkowników jako publiczny obiekt 

- ### Wzorce behawioralne:

  - Polecenie - dzialanie programu (stworz, usun, edytuj)

  - Pamiątka - ręczne backupy  

  - Iterator - iterowanie po notatkach jedna po drugiej (alternatywny widok) 
  
- ### Wzorce strukturalne:

  - Dekorator - przekazywanie notatek do bazy zakodowanych w base64 

  - Proxy - zwrócenie bazy notatek niepozwalającej na edycje cudzych notatek  


## 3. Do zrobienia:
 - Metoda wytworcza i budowniczy - Hubert
 - Pamiatka - Kuba
 - Singleton (baza Userow)
 - Dekorator
 - Proxy (do bazy notatek)
 - klasa User (ma miec ID)
 - owner ID do notatki
 - finalne userID
 - system logowania (pozniej moze zapis do pliku csv + bardzo opcjonalne kodowanie)
