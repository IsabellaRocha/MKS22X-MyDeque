import java.util.*;
public class MyDeque<E> {
  private E[] data;
  public int size, start, end, check;
  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = data.length / 2;
    end = data.length / 2;
    check = 0;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = data.length / 2;
    end = data.length / 2;
    check = 0;
  }
  public int size(){
    return size;
  }
  public String toString(){
    String output = "{";
    if (end > start) {
      for (int idx = start; idx <= end; idx++) {
        output += data[idx] + " ";
      }
    }
    else if (start < end){
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
    if (element == null) {
      throw new NullPointerException();
    }
    if (size >= data.length) {
      resize();
    }
    if (start == 0) {
      start = data.length - 1;
    }
    else if (check != 0){
      start--;
    }
    check = 1;
    size++;
    data[start] = element;
  }
  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    if (size >= data.length) {
      resize();
    }
    if (end == data.length - 1) {
      end = 0;
    }
    else if (check != 0){
      end++;
    }
    check = 1;
    size++;
    data[end] = element;
  }
  public E removeFirst(){
    if (size == 0 && check == 0) {
      throw new NoSuchElementException();
    }
    E og = data[start];
    data[start] = null;
    if (start == data.length - 1) {
      start = 0;
    }
    else {
      start++;
    }
    size--;
    return og;
  }
  public E removeLast(){
    if (size == 0 && check == 0) {
      throw new NoSuchElementException();
    }
    E og = data[end];
    data[end] = null;
    if (end == 0) {
      end = data.length - 1;
    }
    else {
      end--;
    }
    size--;
    return og;
  }
  public E getFirst(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[start];
  }
  public E getLast(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[end];
  }
  private void resize() {
    @SuppressWarnings("unchecked")
    E[] newData = (E[]) new Object[(size * 2) + 1];
    int x = 0;
    for (int idx = newData.length / 2; idx < size + newData.length / 2; idx++) {
      if (start + x < data.length) {
        newData[idx] = data[start + x];
      }
      else {
        newData[idx] = data[start + x - data.length];
      }
      x++;
    }
    start = newData.length / 2;
    end = size + newData.length / 2 - 1;
    data = newData;
  }
  public String toStringDebug() {
    String output = "{";
    for(int idx = 0; idx < data.length; idx++) {
      output += data[idx] + " ";
    }
    output += "}";
    return output;
  }
  public static void main(String[] args) {
    MyDeque test = new MyDeque();
    test.addLast(12);
    test.addLast(12);
    test.addLast(12);
    test.addLast(12);
    test.addFirst(17);
    test.addLast(7);

//    test.addLast(32425);
//    test.addLast(32425);
    test.removeLast();
    test.addFirst(17);
    test.addFirst(17);
    test.addFirst(17);
    test.addFirst(17);
    test.addFirst(17);
    test.removeFirst();
    System.out.println(test.start);
    System.out.println(test.end);
    System.out.println(test);
    System.out.println(test.toStringDebug());
  }
}
