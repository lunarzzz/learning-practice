package com.example.demo.datastructure.Recursion.sort;

/**
 * @author: zhangjiawei
 * @create: 2018-08-29 14:40
 **/
public class Select {

    /**
     * 选择排序，每次选择最小的数交换到数组的最前面
     * @param a
     */
    public static void sort(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            int currMin = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j].compareTo(a[currMin]) < 0){
                    currMin = j;
                }
            }
            ecxh(a, currMin, i);
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
        String[] a = new String[]{ "a", "abc", "aa"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
