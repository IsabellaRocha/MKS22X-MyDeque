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
        if (str[idx].equals("+")) {
          Double add = eval.getLast();
          eval.removeLast();
          add += eval.getLast();
          eval.removeLast();
          eval.addLast(add);
        }
        if (str[idx].equals("*")) {
          Double multiply = eval.getLast();
          eval.removeLast();
          multiply *= eval.getLast();
          eval.removeLast();
          eval.addLast(multiply);
        }
        if (str[idx].equals("-")) {
          Double temp = eval.getLast();
          eval.removeLast();
          Double subtract = eval.getLast() - temp;
          eval.removeLast();
          eval.addLast(subtract);
        }
        if (str[idx].equals("/")) {
          Double temp = eval.getLast();
          eval.removeLast();
          Double divide = eval.getLast() / temp;
          eval.removeLast();
          eval.addLast(divide);
        }
        if (str[idx].equals("%")) {
          Double temp = eval.getLast();
          eval.removeLast();
          Double mod = eval.getLast() % temp;
          eval.removeLast();
          eval.addLast(mod);
        }
      }
    }
    return eval.getLast();
  }
}
