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
