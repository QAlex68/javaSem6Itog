//📌 Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//📌 Создать множество ноутбуков.
//📌 Написать метод, который будет запрашивать у пользователя критерий (или критерии)
//фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
//        “Введите цифру, соответствующую необходимому критерию:
//        1 - ОЗУ
//        2 - Объем ЖД
//        3 - Операционная система
//        4 - Цвет …
//📌 Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры
// фильтрации можно также в Map.
//📌 Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

import java.util.*;

public class LaptopShop {
    public static void main(String[] args) {

        Set<Laptop> laptopSet = getLaptops();

        System.out.println("Весь список ноутбуков (для наглядности):");
        for (Laptop laptop : laptopSet) {
            System.out.println(laptop);
        }
        System.out.println("--------------------------------------------------");
        System.out.println();

        // Формирование запроса для ввода параметров фильтра с клавиатуры
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Map<String, Object> filters = new HashMap<>();
            System.out.println("Введите параметры фильтра (пустое поле пропуск)!! Значения указаны в круглых скобках!");
            System.out.println("Бренд, OS, и цвет корпуса должны точно соответствовать иначе будет пустой список!!):");

            System.out.print("Бренд (ASUS, Acer, GIGABYTE, Dell, HP, Huawei, Samsung) : ");
            String brandInput = scanner.nextLine();
            if (!brandInput.isEmpty()) {
                filters.put("brand", brandInput);
            }

            System.out.print("Минимальный объем ОЗУ (4, 8, 16, 32): ");
            String ramInput = scanner.nextLine();
            if (!ramInput.isEmpty()) {
                filters.put("ram", Integer.parseInt(ramInput));
            }

            System.out.print("Минимальный объем жесткого диска (120, 240, 500, 1000, 2000): ");
            String hdSizeInput = scanner.nextLine();
            if (!hdSizeInput.isEmpty()) {
                filters.put("hdSize", Integer.parseInt(hdSizeInput));
            }

            System.out.print("Операционная система (Linux, Windows): ");
            String computerOsInput = scanner.nextLine();
            if (!computerOsInput.isEmpty()) {
                filters.put("computerOs", computerOsInput);
            }

            System.out.print("Цвет (белый, серый, черный): ");
            String colorInput = scanner.nextLine();
            if (!colorInput.isEmpty()) {
                filters.put("color", colorInput);
            }

            System.out.print("Минимальный дисплей в дюймах (13, 14, 15, 16, 17, 18): ");
            String displayInput = scanner.nextLine();
            if (!displayInput.isEmpty()) {
                filters.put("display", Integer.parseInt(displayInput));
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Параметры выборки (весь список если их нет!)>> " + filters);
            System.out.println("--------------------------------------------------");
            // Фильтрация и вывод результатов
            filterLaptops(filters, laptopSet);

            System.out.print("Желаете продолжить выборку (n - нет, y - да)?: ");
            String yesNo = scanner.nextLine();
            if (yesNo.equals("n")) {
                System.out.println("GoodBy!");
                break;
            }
            System.out.println();
        }

    }

    private static Set<Laptop> getLaptops() {
        Laptop laptop1 = new Laptop("ASUS", 4, 120, "Linux", "черный", 13);
        Laptop laptop2 = new Laptop("Acer", 32, 2000, "Windows", "белый", 18);
        Laptop laptop3 = new Laptop("GIGABYTE", 4, 240, "Linux", "черный", 14);
        Laptop laptop4 = new Laptop("HP", 32, 1000, "Windows", "серый", 17);
        Laptop laptop5 = new Laptop("Samsung", 16, 500, "Windows", "серый", 16);
        Laptop laptop6 = new Laptop("Huawei", 8, 240, "Windows", "черный", 15);
        Laptop laptop7 = new Laptop("Dell", 16, 1000, "Windows", "черный", 17);
        Laptop laptop8 = new Laptop("Acer", 8, 500, "Windows", "серый", 15);
        Laptop laptop9 = new Laptop("HP", 4, 120, "Linux", "белый", 13);
        Laptop laptop10 = new Laptop("Acer", 8, 500, "Windows", "черный", 15);
        Laptop laptop11 = new Laptop("HP", 16, 2000, "Linux", "белый", 18);
        Laptop laptop12 = new Laptop("HP", 8, 240, "Linux", "черный", 14);


        // Множество ноутбуков
        Set<Laptop> laptopSet = Set.of(laptop1, laptop2, laptop3, laptop4, laptop5, laptop6,
                laptop7, laptop8, laptop9, laptop10, laptop11, laptop12);
        return laptopSet;
    }

    private static void filterLaptops(Map<String, Object> filters, Set<Laptop> laptopSet) {
        for (Laptop laptop : laptopSet) {
            boolean passFilter = true;

            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                switch (entry.getKey()) {
                    case "brand":
                        if (!laptop.getBrand().equals(entry.getValue())) {
                            passFilter = false;
                        }
                        break;
                    case "ram":
                        if (laptop.getRam() < (int) entry.getValue()) {
                            passFilter = false;
                        }
                        break;
                    case "hdSize":
                        if (laptop.getHdSize() < (int) entry.getValue()) {
                            passFilter = false;
                        }
                        break;
                    case "computerOs":
                        if (!laptop.getOs().equalsIgnoreCase((String) entry.getValue())) {
                            passFilter = false;
                        }
                        break;
                    case "color":
                        if (!laptop.getColor().equalsIgnoreCase((String) entry.getValue())) {
                            passFilter = false;
                        }
                        break;
                    case "display":
                        if (laptop.getDisplay() < (int) entry.getValue()) {
                            passFilter = false;
                        }
                        break;
                }
            }

            if (passFilter) {
                System.out.println(laptop);
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.println();
    }



}
