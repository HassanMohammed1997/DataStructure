public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        this.items = new int[length];
    }

    //O(n)
    public void insert(int item) {
        resizeIfRequired();
        this.items[count] = item;
        count++;
    }

    public boolean contains(int item) {
        for (int i = 0; i < count; i++) {
            if (this.items[i] == item) {
                return true;
            }
        }

        return false;
    }

    //O(n)
    public void removeAt(int index) {
        //validate the index
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        //shift the items to the left
        for (int i = index; i < count; i++) {
            this.items[i] = this.items[i + 1];
        }

        count--;
    }

    //O(n)
    public int indexOf(int item) {
        //if we found it, return index
        //otherwise return -1
        for (int i = 0; i < count; i++) {
            if (this.items[i] == item)
                return i;
        }

        return -1;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(this.items[i]);
        }
    }

    //o(n)
    public int max() {
        int max = this.items[0];
        for (int i = 0; i < count; i++) {
            if (this.items[i] > max)
                max = this.items[i];
        }

        return max;
    }

    //O(n)
    public int min() {
        int min = this.items[0];
        for (int i = 0; i < count; i++) {
            if (this.items[i] == min)
                min = this.items[i];
        }

        return min;
    }

/*    public Object[] reverse() {
        List<Integer> reversedArray = new ArrayList<>(count);
        for (int i = count - 1; i >= 0; i--) {
            reversedArray.add(items[i]);
        }

        return reversedArray.toArray();
    }*/

    public void reverse() {
        int[] reversed = new int[count];
        for (int i = 0; i < count; i++) {
            reversed[i] = items[count - i - 1];
        }

        items = reversed;
    }

    //O(n)
 /*   public int[] reverseArray() {
        int[] reversedArray = new int[count];
        int j = count;
        for (int i = 0; i < count; i++) {
            reversedArray[j - 1] = items[i];
            j--;
        }

        return reversedArray;
    }
*/
    //O(n^2)
  /*  public Object[] intersect(int[] otherArray) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < otherArray.length; j++) {
                set.add(this.items[i]);
            }
        }

        return set.toArray();
    }*/

    //Instructor Solution
    public Array intersectArray(Array other) {
        Array intersect = new Array(count);
        for (int item : items) {
            if (other.indexOf(item) >= 0)
                intersect.insert(item);
        }

        return intersect;
    }

    public void insertAt(int index, int item) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        resizeIfRequired();

        this.items[index] = item;
        count++;
    }

    private void resizeIfRequired() {
        if (items.length == count) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }

            items = newItems;
        }
    }
}

