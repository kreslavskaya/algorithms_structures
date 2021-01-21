package geekbrains_java;

import java.util.Arrays;

public class Main {

    private static class Array {
        private int arr[];
        private int size;
        private boolean isSorted;

        private Array() {
            isSorted = false;
        }

        public Array(int size) {
            this();
 //           this.size = size;
            this.arr = new int[size];
        }

        public Array(int... args) {
            this();
            this.size = args.length;
            this.arr = args;
        }

        public Array(boolean isSorted, int... args) {
            this(args);
            this.isSorted = isSorted;
        }

        public int get(int index) {
            if (index >= size || index < 0)
                throw new ArrayIndexOutOfBoundsException("Your index is not correct: " + index);
            return arr[index];
        }

        public void set(int index, int value) {
            arr[index] = value;
            isSorted = false;
        }

        public boolean delete() { // last
            if (size == 0) return false;
            size--;
            return true;
        }

        public boolean delete(int index) {
            if (index >= size || index < 0)
                throw new ArrayIndexOutOfBoundsException("Your index is not correct: " + index);

            System.arraycopy(arr, index + 1, arr, index, size - index - 1);
            size--;
            return true;
        }

        public void append(int value) {
            if (size >= arr.length - 1) {
                int[] temp = arr;
                arr = new int[size * 2];
                System.arraycopy(temp, 0, arr, 0, size);
            }
            arr[size++] = value;
            isSorted = false;
        }

        public boolean isInArray(int value) {
            for (int i = 0; i < this.size; i++) {
                if (this.arr[i] == value) {
                    return true;
                }
            }
            return false;
        }

        public int hasValue(int value) {
            if (!isSorted)
                throw new RuntimeException("Trying to search in unsorted array");

            int l = 0;
            int r = size;
            int m;
            while (l < r) {
                m = (l + r) >> 1;
                if (value == arr[m]) {
                    return m;
                } else {
                    if (value < arr[m]) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
            }

            return -1;
        }

        private void swap(int a, int b) {
            int tmp = this.arr[a];
            this.arr[a] = this.arr[b];
            this.arr[b] = tmp;
        }

        public void sortBubble() {
            for (int out = size - 1; out >= 1; out--) {
                for (int in = 0; in < out; in++) {
                    if (this.arr[in] > arr[in + 1]) {
                        swap(in, in + 1);
                    }
                }
            }
            isSorted = true;
        }

        public void sortSelect() {
            for (int i = 0; i < size; i++) {
                int flag = i;
                for (int j = i + 1; j < size; j++) {
                    if (arr[j] < arr[flag])
                        flag = j;
                }
                swap(i, flag);
            }
            isSorted = true;
        }

        public void sortInsert() {
            for (int out = 1; out < size; out++) {
                int temp = arr[out];
                int in = out;
                while (in > 0 && arr[in - 1] >= temp) {
                    arr[in] = arr[in - 1];
                    in--;
                }
                arr[in] = temp;
            }
            isSorted = true;
        }

        @Override
        public String toString() {
            if (arr == null)
                return "null";
            int iMax = size - 1;
            if (iMax == -1)
                return "[]";

            StringBuilder b = new StringBuilder();
            b.append('[');
            for (int i = 0; ; i++) {
                b.append(arr[i]);
                if (i == iMax)
                    return b.append(']').toString();
                b.append(", ");
            }
        }

        // homework
        public boolean deleteAll(int value) {
            for (int i = 0; i < size; i++) {
                if (this.arr[i] == value) {
                    System.arraycopy(arr, i + 1, arr, i, size - i - 1);
                    size--;
                }
            } return true;
        }

        public boolean clear() {
            size = 0;
            return true;
        }

        void insert(int index, int value) {
            if (index > size || index < 0)
                throw new ArrayIndexOutOfBoundsException("Your index is not correct: " + index);
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp,0, arr, 0, index);
            for (int i = 0; i < size + 1; i++) {
                if (i == index) {
                    arr[i] = value;
                    System.arraycopy(temp,index, arr, index +1, size - index);
                    size++;
                }
            }
        }

        public void improvedSortBubble() {
            for (int out = size - 1; out >= 1; out--) {
                for (int in = 0; in < size - 1 - out; in++) {
                    if (this.arr[in] > arr[in + 1]) {
                        swap(in, in + 1);
                    }
                }
            }
            isSorted = true;
        }
    }

    public static void main(String[] args) {
        Array array = new Array(9,2,3,7,4,5,6,7,1,8,0,7);
        System.out.println(array);
//       array.delete();
//       array.delete();
//       System.out.println(array);
//       array.delete(2);
//       System.out.println(array);
//       array.sortInsert();
//       System.out.println(array);
 //      System.out.println(array.hasValue(7));
//        array.sortBubble();
 //       array.deleteAll(7);
 //       array.clear();
//        array.insert(4, 8);
        array.improvedSortBubble();
        System.out.println(array);
    }

    private static void standardArrayThings() {
        int[] arr;
        int ar2[];
        ar2 = new int[5];
        arr = new int[]{1,2,3,'_',5,6,7};
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
