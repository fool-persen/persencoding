package com.persen.beijing.java_up;

class Sort {
    protected void swap(Integer a, Integer b) {
        Integer tmp;
        tmp = a;
        a = b;
        b = tmp;
        System.out.println(a + " " + b);
    }

    public void bubble(int array[], int lenth) {
        for (int i = 0; i < lenth; i++) {
            for (int j = 0; j < lenth - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array[j + 1], array[j]);
                }
            }
        }
    }
}

public class Bubble {

    public static void main(String[] args) {
        Integer a = new Integer(1);
        Integer b = new Integer(2);
        Sort ss = new Sort();
        ss.swap(a, b);
        System.out.println(a + " " + b);
        /*
		int [] array = {1, 2, 5, 4, 3};
		for(int i=0; i<5; i++) {
			System.out.print(array[i]);
		}
		System.out.println("");
		Sort sort = new Sort();
		sort.bubble(array, 5);
		for(int i=0; i<5; i++) {
			System.out.print(array[i]);
		}
		System.out.println("");
		*/
    }

}
