package be.koencorp.bookApp.tools;

/**
 * for String modifying
 */
public final class StringTool {
   private StringTool(){}

   /**
    * Replace a character with X on a given index
    * @param str The String to modify
    * @param index The position where we need to replace the char with X
    * @return the modified String
    */
   public static String setX(String str, int index){
      if(str==null || index < 0 || index >= str.length()) return str;
      StringBuilder sb = new StringBuilder(str);
      sb.replace(index, index+1, "x");
      return sb.toString();
   }
}
