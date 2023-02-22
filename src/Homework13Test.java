import by.tms.lesson13.homework.myarraylist.IntList;

import java.util.Scanner;

public class Homework13Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input string of integers with comma separation: ");
        String line = scanner.nextLine();

        if(line.isEmpty()){
            throw  new IllegalArgumentException("Input string");
        }

        String[] numberStr = line.split(",");
        int[] numbers = new int[numberStr.length];
        for (int i = 0; i < numberStr.length; i++) {
            numbers[i] = Integer.parseInt(numberStr[i]);
        }
        IntList intList = new IntList(numbers);
        System.out.println("What we will to do?");

        do {
            System.out.println("*********** MENU *************");
            System.out.println("1. toString()");
            System.out.println("2. get()");
            System.out.println("3. set()");
            System.out.println("4. size()");
            System.out.println("5. add()");
            System.out.println("6. remove()");
            System.out.println("7. subList()");
            System.out.println("8. lastIndexOf()");
            System.out.println("9. sort()");
            System.out.println("0. Exit");
            System.out.println("******************************");
            System.out.print("Input task number (0 for exit): ");

            int key =scanner.nextInt();

            switch (key) {
                case 1 -> System.out.print(intList);
                case 2 -> {
                    scanner = new Scanner(System.in);
                    System.out.print("Enter index of element: ");
                    int element = scanner.nextInt();
                    System.out.println(intList.get(element));
                }
                case 3 -> {
                    scanner = new Scanner(System.in);
                    System.out.print("Enter index: ");
                    int position = scanner.nextInt();
                    System.out.print("Enter element: ");
                    int element = scanner.nextInt();
                    System.out.println("Element [" + intList.set(position, element) + "] was removed by " + element);
                }
                case 4 -> System.out.println(intList.size());
                case 5 -> {
                    scanner = new Scanner(System.in);
                    System.out.print("Enter added element: ");
                    int element = scanner.nextInt();
                    intList.add(element);
                    System.out.println(intList);
                }
                case 6 -> {
                    scanner = new Scanner(System.in);
                    System.out.print("Enter index of element to remove: ");
                    int position = scanner.nextInt();
                    System.out.println("Element [" + intList.remove(position) + "] on position [" + position +"] was removed");
                    System.out.println(intList);
                }
                case 7 ->{

                    scanner = new Scanner(System.in);
                    System.out.print("Enter left bound: ");
                    int leftBound = Integer.parseInt(scanner.nextLine());
                    System.out.print("Need right bound? [y/n]");
                    char answer = scanner.next().charAt(0);
                    if (answer == 'y') {
                        System.out.print("Enter right bound: ");
                        int rightBound = scanner.nextInt();
                        System.out.println(intList.subList(leftBound, rightBound));
                    } else {
                        System.out.println(intList.subList(leftBound));
                    }
                }
                case 8 ->{
                    scanner = new Scanner(System.in);
                    System.out.print("Enter element: ");
                    int element = scanner.nextInt();
                    System.out.println(intList.lastIndexOf(element));
                }
                case 9 ->{
                    System.out.print("Before sorting: " + intList);
                    intList.sort();
                    System.out.print("After sorting: " + intList);
                }
                case 0 -> {
                    System.out.println("See you!!!");
                    return;
                }
                default -> System.out.println("Wrong key!!!");
            }
        } while (true);
    }
}