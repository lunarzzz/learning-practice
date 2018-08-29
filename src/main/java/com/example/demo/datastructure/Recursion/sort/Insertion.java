package com.example.demo.datastructure.Recursion.sort;

/**
 * @author: zhangjiawei
 * @create: 2018-08-29 14:47
 **/
public class Insertion {

    /**
     * 插入排序，每次讲后面的数一次插入到前面的数中
     * @param a
     */
    public static void sort(Comparable[] a){
        int length = a.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j >0 && less(a[j], a[j-1]); j--) {
                ecxh(a, j, j-1);
            }
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
//        String[] a = new String[]{ "a", "abc", "aa",};
        Integer[] a = new Integer[]{ 2,4,1,3,8,6,67,34};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
