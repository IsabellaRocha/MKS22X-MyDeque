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
    MyDeque eval = new MyDeque();
    String[] str = s.split(" ");
    for (int idx = 0; idx < str.length; idx++) {
      if (isNumber(str[idx])) {
        double add = Double.parseDouble(str[idx]);
        eval.addLast(add);
      }
      else {
        if (str[idx].equals("+")) {
          double add = eval.getLast();
          eval.removeLast();
          add += eval.getLast();
          eval.addLast(add);
        }
      }
    }
  }
}
