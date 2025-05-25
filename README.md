# Втора лабораториска вежба по Софтверско Инженерство

## Александар Ѓорески 225013

### Control Flow Graph (CFG):

![image](https://github.com/user-attachments/assets/f288cab2-dda5-4d84-b66a-ef25221c4958)

### Цикломатската комплексност
Цикломатската комплексност на овој код е 7, истата ја добив со користење на формулата P + 1, каде P е бројот на услови. Во овој случај имаме 6 услови и по цикломатската комплексност се добива да е 7.

### Тест случаи според критериумот Every statement

**Тест случај 1: allItems == null**

Влез:
allItems = null, cardNumber = "1234567890123456"

Очекуван излез:
RuntimeException("allItems list can't be null!")

Го покрива првиот if услов (изјава 1).


**Тест случај 2: Празно име на артикл (item.getName() == null)**

Влез:
allItems = [new Item(null, 1, 100, 0)], cardNumber = "1234567890123456"

Очекуван излез:
RuntimeException("Invalid item!")

Го покрива for-циклусот (изјава 3), item.getName() == null (изјава 5), и throw (изјава 17).

**Тест случај 3: Артикл со попуст (discount > 0)**

Влез:
allItems = [new Item("Book", 2, 200, 0.1)], cardNumber = "1234567890123456"

Очекуван излез:
sum = 200 * (1 - 0.1) * 2 = 360

Го покрива:
item.getDiscount() > 0 (изјава 8)
sum += item.getPrice()*(1-discount)*quantity (изјава 9)
Валидна cardNumber (изјави 11-19).

**Тест случај 4: Невалидна карта (несоодветна должина)**

Влез:
allItems = [new Item("Shirt", 1, 100, 0)], cardNumber = "123"

Очекуван излез:
RuntimeException("Invalid card number!")

Го покрива cardNumber.length() != 16 (изјава 11) и throw (изјава 18).

**Тест случај 5: Артикл без попуст (discount == 0)**
Влез:
allItems = [new Item("Food", 3, 50, 0)], cardNumber = "1234567890123456"

Очекуван излез:
sum = 50 * 3 = 150

Го покрива:
else гранката (изјава 10)
Нормално извршување до return sum (изјава 19).

 **Минималниот број на тест случаи е: 5**

А тоа е докажано со следниве тестови:

**Тест 1: Покрива if (allItems == null).**

**Тест 2: Покрива for, item.getName() == null, и throw.**

**Тест 3: Покрива discount > 0 и пресметка со попуст.**

**Tест 4: Покрива невалидна cardNumber.**

**Teст 5: Покрива else гранка и краен return.**

Секоја изјава е извршена барем еднаш во овие 5 тестови.

### Тест случаи според критериумот  Multiple Condition 

 Multiple Condition критериум бара секоја комбинација на услови во логичкиот израз да се тестира независно.
Условот е:

**if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)**

каде:

**A: item.getPrice() > 300**

**B: item.getDiscount() > 0**

**C: item.getQuantity() > 10**

**Тест случај 1: Сите услови се true (A=T, B=T, C=T)**

Влез:
allItems = [new Item("Laptop", 15, 350, 0.1)] // price>300, discount>0, quantity>10

cardNumber = "1234567890123456"

Очекуван излез:
sum = (350 * (1 - 0.1) * 15) - 30 = 4695

price>300, discount>0, и quantity>10 се true.

Се активира sum -= 30 и попустот.

**Тест случај 2: Само price>300 (A=T, B=F, C=F)**

Влез:
allItems = [new Item("Phone", 5, 400, 0)] // price>300, discount=0, quantity<=10

cardNumber = "1234567890123456"

Очекуван излез:
sum = (400 * 5) - 30 = 1970

Само price>300 е true.

Се активира sum -= 30.

**Тест случај 3: Само discount>0 (A=F, B=T, C=F)**

Влез:
allItems = [new Item("Book", 3, 200, 0.2)] // price<=300, discount>0, quantity<=10

cardNumber = "1234567890123456"

Очекуван излез:
sum = (200 * (1 - 0.2) * 3) - 30 = 450

Само discount>0 е true.

Се активира sum -= 30 и попустот.

**Тест случај 4: Само quantity>10 (A=F, B=F, C=T)**

Влез:
allItems = [new Item("Shirt", 20, 100, 0)] // price<=300, discount=0, quantity>10

cardNumber = "1234567890123456"

Очекуван излез:
sum = (100 * 20) - 30 = 1970

Само quantity>10 е true.

Се активира sum -= 30.

**Тест случај 5: Сите услови се false (A=F, B=F, C=F)**

Влез:
allItems = [new Item("Food", 2, 50, 0)] // price<=300, discount=0, quantity<=10

cardNumber = "1234567890123456"

Очекуван излез:
sum = 50 * 2 = 100

Ниту еден услов не е true.

Нема sum -= 30.

**За Multiple Condition покривање:**

Секој подуслов да биде true независно (Тестови 2, 3, 4).

Сите услови true (Тест 1).

Сите услови false (Тест 5).

**Вкупно: 5 тестови (4 за true + 1 за false).**

