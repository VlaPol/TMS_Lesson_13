package by.tms.lesson13.homework.myarraylist;

import java.util.Arrays;

public class IntList {

    private int[] arrayList = new int[0];

    public IntList() {
    }

    public IntList(int[] inputArray) {
        this.arrayList = Arrays.copyOf(inputArray, inputArray.length);
    }

    public String toString() {

        String resultString = "[";

        if (arrayList.length == 0) {
            return "[]";
        } else {
            for (int i = 0; i < arrayList.length - 1; i++) {
                resultString += arrayList[i] + ", ";
            }
            resultString += arrayList[arrayList.length - 1] + "]\n";
        }

        return resultString;
    }

    public int get(int index) {

        if (index >= arrayList.length || index < 0) {
            throw new IllegalArgumentException("No element with index [" + index + "] in the list");
        }
        return arrayList[index];

    }

    public int set(int index, int element) {

        if (arrayList.length == 0) {
            throw new IllegalArgumentException("No elements in the list!");
        }

        if (index >= arrayList.length || index < 0) {
            throw new IllegalArgumentException("No element with index [" + index + "] in the list");
        }

        int returnedElement = get(index);
        arrayList[index] = element;
        return returnedElement;
    }

    public int size() {
        return arrayList.length;
    }

    public void add(int element) {

        int[] addOneArray;

        addOneArray = new int[arrayList.length + 1];

        System.arraycopy(arrayList, 0, addOneArray, 0, arrayList.length);
        addOneArray[arrayList.length] = element;
        arrayList = addOneArray;
    }

    public int remove(int index) {

        if (arrayList.length == 0) {
            throw new IllegalArgumentException("List is empty");
        }

        if (index >= arrayList.length || index < 0) {
            throw new IllegalArgumentException("No element with index [" + index + "] in the list");
        }

        int[] removeOneArray = new int[arrayList.length - 1];
        int deletedDigit = 0;

        int j = 0;
        for (int i = 0; i < arrayList.length; i++) {
            if (i != index) {
                removeOneArray[j] = arrayList[i];
                j++;
            } else {
                deletedDigit = arrayList[i];
            }
        }

        arrayList = removeOneArray;
        return deletedDigit;
    }

    public IntList subList(int startIndexInclusive) {

        if (startIndexInclusive < 0 || startIndexInclusive > arrayList.length) {
            throw new IllegalArgumentException("Bad one of bounds");
        }

        int[] tmpArray = new int[arrayList.length - startIndexInclusive];

        int j = 0;
        for (int i = startIndexInclusive; i < arrayList.length; i++) {
            tmpArray[j] = arrayList[i];
            j++;
        }

        return new IntList(tmpArray);
    }

    public IntList subList(int startIndexInclusive, int endIndexExclusive) {

        if (startIndexInclusive < 0 || endIndexExclusive > arrayList.length || startIndexInclusive > endIndexExclusive) {
            throw new IllegalArgumentException("Bad one of bounds");
        }

        int[] tmpArray = new int[endIndexExclusive - startIndexInclusive];

        int j = 0;
        for (int i = startIndexInclusive; i < endIndexExclusive; i++) {
            tmpArray[j] = this.arrayList[i];
            j++;
        }

        return new IntList(tmpArray);
    }

    public int lastIndexOf(int element) {

        for (int i = arrayList.length - 1; i > 0; i--) {
            if (arrayList[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public void sort() {

        int swap;

        for (int i = 0; i < arrayList.length - 1; i++) {
            for (int j = 0; j < arrayList.length - 1 - i; j++) {
                if (arrayList[j] > arrayList[j + 1]) {
                    swap = arrayList[j];
                    arrayList[j] = arrayList[j + 1];
                    arrayList[j + 1] = swap;
                }
            }
        }
    }

}
