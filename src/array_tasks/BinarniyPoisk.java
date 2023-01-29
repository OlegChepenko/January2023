package array_tasks;
//19.12.2022
public class BinarniyPoisk {
    static int findNumber(int[] a, int x){
        int first=0;
        int last= a.length-1;
        int midle = -1;
        while (true){
            midle = (first+last)/2;
            if (a[midle]==x) break;
            if(a[midle]>x) {
                last = midle - 1;
            }
            else if (a[midle]<x) first=midle+1;
        }
        return midle;
    }
    public static void main(String[] args) {
        int[]a={1,5,7,8,9,12,89};
        int number = findNumber(a, 89);
        System.out.println(number);
    }
}
