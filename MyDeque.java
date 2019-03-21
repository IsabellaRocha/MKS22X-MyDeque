public class MyDeque<E> {
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 10;
    start = 0;
    end = 0;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = initialCapacity;
    start = 0;
    end = 0;
  }
  public int size(){
    return size;
  }
  public String toString(){ }
  public void addFirst(E element){
    if (start == 0) {
      start = data.length;
    }
    else {
      start--;
    }
    data[start] = element;
  }
  public void addLast(E element){
    if (end == data.length) {
      end = 0;
    }
    else {
      end++;
    }
    data[end] = element;
  }
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }
}
