package cn.jason.demo.arithmetic;

public class ArithmeticTest {
    public static void main(String[] args) {
        int a[] = {3, 5, 9, 5, 66, 1, 65, 33};
        ArithmeticTest sort = new ArithmeticTest();
//        int[] sortedA = sort.bubbleSort(a);
//        int[] sortedA = sort.selectionSort(a);
        int[] sortedA = sort.selectionSort2(a);
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

    /**
     * 每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
     * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 选择排序是不稳定的排序方法。
     */
    public int[] selectionSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
        }
        return a;
    }

    private void swap(int[] a, int i, int minIndex) {
        int temp = a[i];
        a[i] = a[minIndex];
        a[minIndex] = temp;
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

    /**
     * 每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
     * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 选择排序是不稳定的排序方法。
     */
    public int[] selectionSort2(int[] a) {
        int left = 0;
        int right = a.length - 1;
        int minIndex, maxIndex;
        while (left < right) {
            minIndex = left;
            maxIndex = right;
            for (int i = left; i <= right; i++) {
                if (a[i] < a[minIndex]) {
                    minIndex = i;
                }
                if (a[i] > a[maxIndex]) {
                    maxIndex = i;
                }
            }

            swap(a, right, maxIndex);
            if (minIndex == right) {
                minIndex = maxIndex;
            }
            swap(a, left, minIndex);
            left++;
            right--;
        }


        return a;
    }

}
