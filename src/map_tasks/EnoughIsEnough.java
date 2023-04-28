package map_tasks;
//https://www.codewars.com/kata/554ca54ffa7d91b236000023/java
//Алиса и Боб были в отпуске. Они оба сделали много фотографий мест, где побывали, и теперь хотят показать Чарли всю свою коллекцию.
// Однако эти сеансы не нравятся Чарли, так как мотив обычно повторяется. Ему не нравится смотреть на Эйфелеву башню 40 раз.
//Он говорит им, что будет сидеть на сеансе только в том случае, если они покажут один и тот же мотив не более N раз.
// К счастью, Алиса и Боб могут закодировать мотив как число. Можете ли вы помочь им удалить числа так,
// чтобы их список содержал каждое число только до N раз, не меняя порядок?

//Учитывая список и число, создайте новый список, который содержит каждое число списка не более N раз без изменения порядка.
//Например, если входное число равно 2, а входной список — [1,2,3,1,2,1,2,3],
// вы берете [1,2,3,1,2], отбрасываете следующий [ 1,2], поскольку это приведет к тому,
// что 1 и 2 будут в результате 3 раза, а затем взять 3, что приведет к [1,2,3,1,2,3].
//Со списком [20,37,20,21] и числом 1 результатом будет [20,37,21].

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EnoughIsEnough {
    //метод решающий задачу через for
    static ArrayList<Integer> enough(int[] elements, int maxOccurrences) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == elements[i]) count++;
            }
            if (count < maxOccurrences) {
                list.add(elements[i]);
            }
        }
        return list;
    }

    //метод решающий задачу через словарь / не сделал. не понятно как и зачем?
    static ArrayList<Integer> enoughHashMap(int[] elements, int maxOccurrences) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        //Перегнать весь список в словарь???
        for (Integer k : elements) {
            int count;
            if (map.containsKey(k)) {
                count = map.get(k);
                map.replace(k, map.get(k) + 1);
            } else {
                map.put(k, 1);
                count = 0;
            }
            if (count < maxOccurrences) {
                list.add(k);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] m = {20, 37, 20, 21};
        int n = 1;
        ArrayList<Integer> list = enough(m, n);

        System.out.println(list.toString());
    }
}
