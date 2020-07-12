###学习笔记


#### 选择排序
```$java
public class SelectionSort {
    public static void main(String[] args) {
        int[] testArrs = {1,12,33,4,2,1,4};
        int[] resultArr = selectionSort(testArrs);
        for (int arr : resultArr) {
            System.out.print(arr + " ");
        }
    }
    private static int[] selectionSort(int[] arrs) {
        int i, j, min, temp, len = arrs.length;
        for (i = 0; i < len - 1; i++) {
            min = i; //假设当前i为数组最小值的下标
            for (j = i + 1; j < len; j++) { //在未排序元素中继续寻找最小元素，并保存其下标
                if (arrs[min] > arrs[j]) {
                    min = j;
                }
            }
            temp = arrs[min]; //将最小元素放到已排序序列的末尾
            arrs[min] = arrs[i];
            arrs[i] = temp;
        }
        return arrs;
    }
```

#### 插入排序
```$java
public class InsertionSort {
    public static void main(String[] args) {
        int[] testArrs = {1,12,33,4,2,1,4};
        int[] resultArrs = insertionSort(testArrs);
        for (int arr : resultArrs) {
            System.out.print(arr + " ");
        }
    }
    private static int[] insertionSort(int[] arrs) {
        for (int i = 1; i < arrs.length; i++ ) {
            int temp = arrs[i];
            int j = i - 1;
            //如果将赋值放到下一行的for循环内, 会导致在第10行出现j未声明的错误
            for (; j >= 0 && arrs[j] > temp; j-- ) {
                arrs[j + 1] = arrs[j];
                }
            arrs[j + 1] = temp;
            }
        return arrs;
    }
}
```

#### 冒泡排序

```$java
public class BubbleSort {
   
       public static void main(String[] args) {
           int[] testArrs = {1,12,33,4,2,1,4};
           int[] resultArr = bubblesort(testArrs);
           for (int arr : resultArr) {
               System.out.print(arr + " ");
           }
       }
   
       private static int[] bubblesort(int[] arrs) {
           int i, j, len = arrs.length;
           for (i = 0; i < len - 1; i++) {
               for (j = 0; j < len - 1 - i; j++) {
                   if (arrs[j] > arrs[j + 1]) {
                       swap(arrs, j);
                   }
               }
           }
           return arrs;
       }
   
       private static void swap(int[] arrs, int j) {
           int temp;
           temp = arrs[j];
           arrs[j] = arrs[j + 1];
           arrs[j + 1] = temp;
       }
   }
```