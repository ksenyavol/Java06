package lesson61;

// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
// import java.util.List;
import java.util.Arrays;

// 1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. 
// Реализовать в java.
// 2. Создать множество ноутбуков.
// 3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) 
// фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. 
// Например: “Введите цифру, соответствующую необходимому критерию:

// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры 
// фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

public class Task16 {
    static int id = 1;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Laptop nb1 = new Laptop(id, "MSI", "GF75", "White",
        16, 2400,
        "Intel", "Core i5 7500", 4, 3.2,
        512,
        "IPS", 14.2);
id++;

Laptop nb2 = new Laptop(id, "Acer", "Aspire 3", "Black",
        8, 2400,
        "AMD", "Ryzen 5 3500U", 4, 2.1,
        256,
        "IPS", 15.6);
id++;

Laptop nb3 = new Laptop(id, "Apple", "MacBook Air", "Midnight",
        8, 3200,
        "Apple", "M2", 8, 3.5,
        512,
        "IPS", 13.6);
id++;

Laptop nb4 = new Laptop(id, "ASUS", "TUF Gaming F17", "White",
        16, 3200,
        "Intel", "Core i5 11400H", 6, 2.7,
        1024,
        "IPS", 17.3);
id++;

Laptop nb5 = new Laptop(id, "ASUS", "TUF Gaming F17", "Silver",
        16, 3200,
        "Intel", "Core i5 11400H", 6, 2.7,
        1024,
        "AMOLED", 17.3);
id++;

Set<Laptop> nbs = new HashSet<>(Arrays.asList(nb1, nb2, nb3, nb4, nb5));
System.out.println("Ноутбуки загружены. Введите номер параметра для фильтрации:");
System.out.println("1 - по вендору");
System.out.println("2 - по CPU");
System.out.println("3 - по объёму RAM");
System.out.println("4 - по объёму HDD");

System.out.print("Введите параметр: ");
String param = input.nextLine();

var fnbs = filter(param, nbs);
if (fnbs != null) {
        for (Laptop nb: fnbs) {
        System.out.println(nb + "\n");
}
}
}

public static Set<Laptop> filter(String param, Set<Laptop> nbs) {
        Set<Laptop> fnbs = new HashSet<>();
int min, max;
switch (param) {

case "1":
System.out.print("Введите вендора: ");
String vendor = input.nextLine().toLowerCase();
for (Laptop nb: nbs) {
        if (((String) nb.vendor).toLowerCase().equals(vendor)) {
                fnbs.add(nb);
}
}
break;

case "2":
System.out.print("Введите производителя CPU: ");
String CPUVendor = input.nextLine().toLowerCase();
System.out.print("Введите модель CPU: ");
String CPUModel = input.nextLine().toLowerCase();
for (Laptop nb: nbs) {
        if (nb.CPUVendor.toLowerCase().equals(CPUVendor) &&
nb.CPUModel.toLowerCase().equals(CPUModel)) {
fnbs.add(nb);
}
}
break;

case "3":
System.out.println("Введите диапазон [min, max]:");
System.out.print("min: ");
min = Integer.parseInt(input.nextLine());
System.out.print("max: ");
max = Integer.parseInt(input.nextLine());

for (Laptop nb: nbs) {
        if (min <= nb.RAMSize && Laptop.RAMSize <= max) {
                fnbs.add(nb);
                }
}
break;

case "4":
System.out.println("Введите диапазон [min, max]:");
System.out.print("min: ");
min = Integer.parseInt(input.nextLine());
System.out.print("max: ");
max = Integer.parseInt(input.nextLine());

for (Laptop nb: nbs) {
        if (min <= nb.HDDSize && nb.HDDSize <= max) {
                fnbs.add(nb);
                }
}
break;
default:
System.out.println("Неверный параметр");
return null;
}
return fnbs;
}
}
