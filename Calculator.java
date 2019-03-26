public class Calculator {
  public static boolean isNumber(String s) {
    try {
      Double.parseDouble(s);
      return true;
    }
    catch (NumberFormatException e) {
      return false;
    }
  } // Looked on stack overflow for ideas on how to tell if a string is a number
  public static double eval(String s){
    MyDeque<Double> eval = new MyDeque();
    String[] str = s.split(" ");
    for (int idx = 0; idx < str.length; idx++) {
      if (isNumber(str[idx])) {
        Double add = Double.parseDouble(str[idx]);
        eval.addLast(add);
      }
      else {
        Double x = eval.removeLast();
        Double y = eval.removeLast();
        if (str[idx].equals("+")) {
          eval.addLast(x + y);
        }
        if (str[idx].equals("*")) {
          eval.addLast(x * y);
        }
        if (str[idx].equals("-")) {
          eval.addLast(y - x);
        }
        if (str[idx].equals("/")) {
          eval.addLast(y / x);
        }
        if (str[idx].equals("%")) {
          eval.addLast(y % x);
        }
      }
    }
    return eval.getLast();
  }
}
