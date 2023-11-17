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
//📌 Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
// -----------------
// Магазин ноутбуков.
// Поля:
//     Бренд (brand);
//     ОЗУ (ram);
//     Объем ЖД (hdSize);
//     Операционная система (computerOs);
//     Цвет корпуса (color);
//     Размер экрана (display);
// Методы:
//     Получить бренд (getBrand);
//     Получить ОЗУ (getRam);
//     Получить ЖД (getHdSize);
//     Получить ОС (getOS);
//     Получить цвет корпуса (getColor);
//     Получить размер экрана (getDisplay);


public class Laptop {

    private String brand;
    private int ram;
    private int hdSize;
    private String computerOs;
    private String color;
    private int display;

    public Laptop(String brand, int ram, int hdSize, String computerOs, String color, int display) {
        this.brand = brand;
        this.ram = ram;
        this.hdSize = hdSize;
        this.computerOs = computerOs;
        this.color = color;
        this.display = display;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getHdSize() {
        return hdSize;
    }

    public String getOs() {
        return computerOs;
    }

    public String getColor() {
        return color;
    }

    public int getDisplay() {
        return display;
    }

    @Override
    public String toString(){
        String result = "Бренд -> " + brand + " | "
                + "ОЗУ ГБ -> " + ram + " | "
                + "Объем диска ГБ -> " + hdSize + " | "
                + "OS -> " + computerOs + " | "
                + "Цвет корпуса -> " + color + " | "
                + "Дисплей дюймов -> " + display;
        return result;
    }

}
