import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main a = new Main();
        List<House> houses;
        List<House> listByRooms;
        List<House> listByRoomsAndFloor;
        List<House> listByArea = new ArrayList<>();

        houses = a.CreateList();

        listByRooms = listByRooms(houses);
        System.out.println("Список квартир за кількістю кімнат: ");
        PrintList(listByRooms);

        listByRoomsAndFloor = listByRoomsAndFloor(houses);
        System.out.println("Список квартир, які мають задане число кімнат і знаходяться на потрібному поверсі: ");
        PrintList(listByRoomsAndFloor);

        ListByArea(houses, listByArea);
        System.out.println("Список квартир, площа яких перевищує задану: ");
        PrintList(listByArea);

        
    }



    public List<House> CreateList() {
        Scanner scanner = new Scanner(System.in);
        List<House> houses = new ArrayList<>();

        System.out.print("Введіть к-сть квартир для вводу: ");
        int housesCount = scanner.nextInt(); scanner.nextLine();

        for (int i = 0; i < housesCount; i++) {
            House buffer = new House();
            buffer.SetValue();
            houses.add(buffer);
        }

        return houses;
    }

    public static List<House> listByRooms(List<House> houses) {
        List<House> listByRooms = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть к-сть кімнат для пошуку: ");
        int rooms = scanner.nextInt(); scanner.nextLine();

        for (House el: houses) {
            if (el.get_rooms() == rooms) {
                listByRooms.add(el);
            }
        }

        return listByRooms;
    }

    public static List<House> listByRoomsAndFloor(List<House> houses) {
        List<House> listByRoomsAndFloor = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть к-сть кімнат: ");
        int rooms = scanner.nextInt(); scanner.nextLine();
        System.out.print("Введіть початок діапазону поверхів: ");
        int startFloor = scanner.nextInt(); scanner.nextLine();
        System.out.print("Введіть кінець діапазону поверхів: ");
        int endFloor = scanner.nextInt(); scanner.nextLine();

        for (House el: houses) {
            if (el.get_rooms() == rooms && el.get_floor() >= startFloor && el.get_floor() <= endFloor) {
                listByRoomsAndFloor.add(el);
            }
        }

        return listByRoomsAndFloor;
    }

    public static void ListByArea(List<House> houses, List<House> listByArea) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть мінімальну площу: ");
        double minArea = scanner.nextDouble(); scanner.nextLine();

        for (House el: houses) {
            if (el.get_area() > minArea) {
                listByArea.add(el);
            }
        }
    }

    public static void PrintList(List<House> houses) {
        for (House element: houses) {
            System.out.println(element.toString());
        }
    }
}


 class House {
    private int _id, _number, _floor, _rooms;
    private double _area;
    private String _street;

    public House() {}

    public House(int id, int number, double area, int floor, int rooms, String street) {
        _id = id;
        _number = number;
        _area = area;
        _floor = floor;
        _rooms = rooms;
        _street = street;
    }

    public void SetValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть дані квартири");
        System.out.print("Введіть ID: ");
        _id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Введіть номер квартири: ");
        _number = scanner.nextInt(); scanner.nextLine();
        System.out.print("Введіть площу: ");
        _area = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Введіть поверх: ");
        _floor = scanner.nextInt(); scanner.nextLine();
        System.out.print("Введіть кількість кімнат: ");
        _rooms = scanner.nextInt(); scanner.nextLine();
        System.out.print("Введіть назву вулиці: ");
        _street = scanner.nextLine();
    }

     public void set_id(int _id) {
         this._id = _id;
     }

     public void set_street(String _street) {
         this._street = _street;
     }

     public int get_id() { return _id; }
    public int get_number() { return _number; }
    public double get_area() { return _area; }
    public int get_floor() { return _floor; }
    public int get_rooms() { return _rooms; }
    public String get_street() { return _street; }

    @Override
    public String toString() {
        return "Квартира: \n" +
                "ID: " + _id + "\n" +
                "Номер квартири: " + _number + "\n" +
                "Площа: " + _area + "\n" +
                "Поверх: " + _floor + "\n" +
                "Кількість кімнат: " + _rooms + "\n" +
                "Вулиця: " + _street + "\n";
    }
}
