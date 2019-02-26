package cn.jason.demo.arithmetic;

public class ArithmeticTest {
    public static void main(String[] args) {
        int a[] = {3, 5, 9, 5, 66, 1, 65, 33};
        ArithmeticTest sort = new ArithmeticTest();
//        int[] sortedA = sort.bubbleSort(a);
//        int[] sortedA = sort.selectionSort(a);
        int[] sortedA = sort.insertionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public int[] bubbleSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
    public int[] selectionSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
        return a;
    }
    public int[] insertionSort(int[] a) {
        int len = a.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = a[i];
            while (preIndex >= 0 && a[preIndex] > current) {
                a[preIndex + 1] = a[preIndex];
                preIndex--;
            }
            a[preIndex + 1] = current;
        }
        return a;
    }

}
