package by.aston;

public class MyCollection {
    public static <T extends Comparable<? super T>> List<T> sort(List<T> list) {//Task 3
        int n = list.size();
        List<T> tempList = new ArrayList<>(list);

        boolean sorted = false;
        for (int i = 0; i < n - 1 && !sorted; i++) {
            sorted = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (tempList.get(j).compareTo(tempList.get(j + 1)) > 0) {
                    T temp = tempList.get(j);
                    tempList.remove(j);
                    tempList.add(j + 1, temp);
                    sorted = false;
                }
            }
        }
        return tempList;
    }
}



