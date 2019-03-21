public class MyDeque<E> {
  private E[] data;
  private int size, start, end, check;
  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 10;
    start = data.length / 2;
    end = data.length / 2;
    check = 0;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = initialCapacity;
    start = data.length / 2;
    end = data.length / 2;
    check = 0;
  }
  public int size(){
    return size;
  }
  public String toString(){
    String output = "{";
    if (end >= start) {
      for (int idx = start; idx <= end; idx++) {
        output += data[idx] + " ";
      }
    }
    else {
      for (int idx = start; idx < data.length; idx++) {
        output += data[idx] + " ";
      }
      for (int idx = 0; idx <= end; idx++) {
        output += data[idx] + " ";
      }
    }
    output += "}";
    return output;
  }
  public void addFirst(E element){
    if (start == 0) {
      start = data.length - 1;
    }
    else if (check != 0){
      start--;
    }
    check = 1;
    data[start] = element;
  }
  public void addLast(E element){
    if (end == data.length - 1) {
      end = 0;
    }
    else {
      end++;
    }
    data[end] = element;
  }
  public E removeFirst(){
    E og = data[start];
    data[start] = null;
    start++;
    return og;
  }
  public E removeLast(){
    E og = data[end];
    data[end] = null;
    end--;
    return og;
  }
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[end];
  }
  public static void main(String[] args) {
    MyDeque test = new MyDeque();
    test.addLast(12);
    test.addLast(12);
    test.addLast(12);
    test.addLast(12);
    test.addFirst(17);
    System.out.println(test);
  }
}
