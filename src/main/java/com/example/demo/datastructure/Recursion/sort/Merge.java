package com.example.demo.datastructure.Recursion.sort;

/**
 * @author: zhangjiawei
 * @create: 2018-08-29 15:22
 **/
public class Merge {

    public static void sort(Comparable[] a){
        merge(a, 0, a.length-1);
    }

    private static void merge(Comparable[] a, int i, int j) {
        if (i>= j)
            return;
        int mid = (i+j)>>>1;
        merge(a, i, mid);
        merge(a, mid+1, j);
        mergeArray(a, i, mid, j);
    }

    private static void mergeArray(Comparable[] a, int i, int mid, int j) {
        Comparable[] temp1 = new Comparable[a.length];
        for (int k = i; k <= j; k++) {
            temp1[k] = a[k];
        }
        int lo = i, hi = mid+1;
        for (int k = lo; k <= j ; k++) {
            if (lo > mid)
                a[k] = temp1[hi++];
            else if (hi > j)
                a[k] = temp1[lo++];
            else if (less(temp1[hi], temp1[lo]))
                a[k] = temp1[hi++];
            else
                a[k] = temp1[lo++];
        }

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
