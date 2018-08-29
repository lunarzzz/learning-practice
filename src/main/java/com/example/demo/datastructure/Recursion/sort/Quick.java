package com.example.demo.datastructure.Recursion.sort;

/**
 * @author: zhangjiawei
 * @create: 2018-08-29 15:54
 **/
public class Quick {
    public static void sort(Comparable[] a){
        quicksort(a,0,a.length-1);
    }

    private static void quicksort(Comparable[] a, int i, int j) {
        if (i>=j)
            return;
        Comparable flag = a[i];
        int s = i;
        int e = j;
        while (s<e){
            while (s<e && less(flag, a[e]))
                e--;
            a[s] = a[e];
            while (s<e && less(a[s], flag))
                s++;
            a[e] = a[s];
        }
        a[e] = flag;
        quicksort(a, i, e);
        quicksort(a, e+1, j);
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void ecxh(Comparable[] a, int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i-1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{ 2,4,1,3,8,6,67,34};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
