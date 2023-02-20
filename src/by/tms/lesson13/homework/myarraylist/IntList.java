package by.tms.lesson13.homework.myarraylist;

import java.util.Arrays;

public class IntList {

    private int[] arrayList;

    public IntList() {
    }

    public IntList(int[] inputArray) {
        this.arrayList = Arrays.copyOf(inputArray, inputArray.length);
    }

    public String toString() {

        String resultString = "[";

        if (arrayList == null) {
            return "null";
        } else if (arrayList.length == 0) {
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

        if (arrayList == null || arrayList.length == 0) {
            throw new IllegalArgumentException("NO place for looking");
        }

        if (index >= arrayList.length || index < 0) {
            throw new IllegalArgumentException("No element with index [" + index + "] in the list");
        }

        for (int i = 0; i < arrayList.length; i++) {
            if (index == i) {
                return arrayList[i];
            }
        }
        return 0;
    }

    public int set(int index, int element) {

        if (arrayList == null || arrayList.length == 0) {
            throw new IllegalArgumentException("No elements in the list!");
        }

        if (index >= arrayList.length || index < 0) {
            throw new IllegalArgumentException("No element with index [" + index + "] in the list");
        }

        int returnedElement = get(index);

        for (int i = 0; i < arrayList.length; i++) {
            if (index == i) {
                arrayList[i] = element;
                break;
            }
        }
        return returnedElement;
    }

    public int size() {
        if (arrayList != null) {
            return arrayList.length;
        } else {
            return 0;
        }
    }

    public void add(int element) {

        if (arrayList == null) {
            throw new IllegalArgumentException("Wrong argument");
        }

        int[] addOneArray;

        if (arrayList.length != 0) {
            addOneArray = new int[arrayList.length + 1];
        } else {
            addOneArray = new int[1];
        }

        System.arraycopy(arrayList, 0, addOneArray, 0, arrayList.length);
        addOneArray[arrayList.length] = element;
        arrayList = addOneArray;
    }

    public int remove(int index) {

        if (arrayList == null || arrayList.length == 0) {
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

    public IntList subList(int startIndexInclusive, int endIndexExclusive) {

        if (startIndexInclusive < 0 || endIndexExclusive > arrayList.length || startIndexInclusive > endIndexExclusive) {
            throw new IllegalArgumentException("Bad one of bounds");
        }

        IntList newList = new IntList(new int[0]);

        for (int i = startIndexInclusive; i < endIndexExclusive; i++) {
            newList.add(arrayList[i]);
        }

        return newList;
    }

    public int lastIndexOf(int element) {

        if (arrayList == null || arrayList.length == 0) {
            throw new IllegalArgumentException("NO place for looking");
        }

        for (int i = arrayList.length - 1; i > 0; i--) {
            if (arrayList[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public void sort() {

        if (arrayList == null || arrayList.length == 0) {
            throw new IllegalArgumentException("NO place for looking");
        }

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
