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
          Double add = eval.removeLast();
          add += eval.removeLast();
          eval.addLast(add);
        }
        if (str[idx].equals("*")) {
          Double multiply = eval.removeLast();
          multiply *= eval.removeLast();
          eval.addLast(multiply);
        }
        if (str[idx].equals("-")) {
          Double temp = eval.removeLast();
          Double subtract = eval.removeLast() - temp;
          eval.addLast(subtract);
        }
        if (str[idx].equals("/")) {
          Double temp = eval.removeLast();
          Double divide = eval.removeLast() / temp;
          eval.addLast(divide);
        }
        if (str[idx].equals("%")) {
          Double temp = eval.removeLast();
          Double mod = eval.removeLast() % temp;
          eval.addLast(mod);
        }
      }
    }
    return eval.getLast();
  }
}
