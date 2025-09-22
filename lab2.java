import java.util.Scanner;
import java.time.LocalDate;

class Goods {
    String name, date;
    int quantity, number;
    float price;

    Goods() {}

    void setPrice(float price) {
        if (price < 0) {
            System.out.println("Error: price is negative");
            return;
        }
        this.price = price;
    }

    void setName(String name) {
        if (name == null) {
            System.out.println("Error: name is null");
            return;
        }
        this.name = name;
    }

    void setQuantity(int quantity) {
        if (quantity < 0) {
            System.out.println("Error: quantity is negative");
        }
        this.quantity = quantity;
    }

    void setNumber(int number) {
        if (number < 0) {
            System.out.println("Error: number is negative");
            return;
        }
        this.number = number;
    }

    void setDate(String date) {
        if (date == null) {
            System.out.println("Error: date is null");
        }
        this.date = date;
    }

    float getTotal() {
        return this.price * this.quantity;
    }

    String getName() {
        return this.name;
    }

    int getQuantity() {
        return this.quantity;
    }

    int getNumber() {
        return this.number;
    }

    String getDate() {
        return this.date;
    }

    float getPrice() {
        return this.price;
    }
}

class Square {
    float side;
    Square(float side) {
        this.side = side;
    }
    void setSide(float side) {
        this.side = side;
    }
    float getArea() {
        return side * side;
    }
    float getPerimeter() {
        return side * 4;
    }
    double getDiagonal() {
        return side * Math.sqrt(2);
    }
}

class Calendar {
    int day, year;
    Calendar(int day, int year) {
        this.day = day;
        this.year = year;
    }
    void setDay(int day) {
        if (day < 1) {
            System.out.println("Error: day is not positive");
        }
        if (this.year % 4 == 0){
            if (day > 366){
                System.out.println("Error: day is too large");
            } else {
                this.day = day;
            }
        } else {
            if (day > 365){
                System.out.println("Error: day is too large");
            }  else {
                this.day = day;
            }
        }
    }
    void setYear(int year) {
        if (year < 1) {
            System.out.println("Error: year is not positive");
        } else {
            this.year = year;
        }
    }
    String getExactDate(){
        LocalDate firstDay = LocalDate.of(this.year, 1, 1);
        LocalDate newDay = firstDay.plusDays(this.day - 1);
        return  "Formatted date: "
                + newDay.getDayOfMonth() + " "
                + newDay.getMonth() + ", "
                + newDay.getDayOfWeek();
    }
}

public class Main {
    public static void main(String[] args) {
        //Task 1
        //8. Створити клас Goods (товар) з полями: назва товару, дата оформлення, ціна
        //товару, кількість одиниць товару, номер накладної, по якій товар поступив на
        //склад. Реалізувати методи зміни ціни товару, зміни кількості, обчислення
        //вартості товару.
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Input task: ");
            int task = input.nextInt();
            input.nextLine();
            if (task == 1) {
                Goods socks = new Goods();
                System.out.println("Enter the name of the product: ");
                socks.setName(input.nextLine());
                System.out.println("Enter the date of the product: ");
                socks.setDate(input.nextLine());
                System.out.println("Enter document number of the product: ");
                if (!input.hasNextInt()) {
                    System.out.println("Error: document number is not a number");
                    return;
                } else {
                    socks.setNumber(input.nextInt());
                }
                System.out.println("Enter the quantity of the product: ");
                socks.setQuantity(input.nextInt());
                System.out.println("Enter price of the product: ");
                socks.setPrice(input.nextFloat());

                System.out.println("\n\n");

                System.out.println("Name of the product: " + socks.getName());
                System.out.println("Date of the product: " + socks.getDate());
                System.out.println("Number of the product: " + socks.getNumber());
                System.out.println("Price of the product: " + socks.getPrice());
                System.out.println("Quantity of the product: " + socks.getQuantity());
                System.out.println("Total price is: " + socks.getTotal());
            }

            if (task == 2) {
                //Task 2
                //5. Клас «квадрат», який описує квадрат з заданими сторонами. Методи класу
                //дозволяють знаходити периметр та площу квадрата, довжину діагоналей.
                Square square1 = new Square(5);
                Square square2 = new Square(10);
                System.out.println("Input square 1 side: ");
                if (!input.hasNextFloat()) {
                    System.out.println("Error: side is not a number");
                    return;
                } else {
                    square1.setSide(input.nextFloat());
                }

                System.out.println("Input square 2 side: ");
                if (!input.hasNextFloat()){
                    System.out.println("Error: side is not a number");
                    return;
                } else {
                    square2.setSide(input.nextFloat());
                }

                System.out.println("Square 1 area is: " + square1.getArea());
                System.out.println("Square 1 perimeter is: " + square1.getPerimeter());
                System.out.println("Square 1 diagonal length is: " + square1.getDiagonal());
                System.out.println("Square 2 area is: " + square2.getArea());
                System.out.println("Square 2 diagonal length is: " + square2.getDiagonal());
                System.out.println("Square 2 perimeter is: " + square2.getPerimeter());
            }

            if (task == 3) {
                //Task 3
                //3. Створити клас календар, в якому реалізувати пошук дня місяця і тижня для
                //введеного числа і року (наприклад для вхідних даних 32, 2002 повернути 1
                //лютого, п’ятниця)
                Calendar date = new Calendar(1, 2000);
                System.out.println("Input year: ");
                if (!input.hasNextInt()) {
                    System.out.println("Error: year is not a number");
                    return;
                } else {
                    date.setYear(input.nextInt());
                }
                System.out.println("Input day: ");
                if (!input.hasNextInt()) {
                    System.out.println("Error: day is not a number");
                    return;
                } else {
                    date.setDay(input.nextInt());
                }
                System.out.println(date.getExactDate());
            }
            if (task == 0) {
                System.out.println("Exiting the program...");
                return;
            }
        }
    }
}
