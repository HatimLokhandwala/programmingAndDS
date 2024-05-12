package strings;


public class LongestPrefix {
  static String determineLongestPrefixv2(String[] arr) {
    String result = arr[0];
    for (int i = 1; i < arr.length; i++) {
      int minLen = Math.min(result.length(), arr[i].length());
      int currentIndex = 0;
      while (currentIndex < minLen) {
        if (result.charAt(currentIndex) != arr[i].charAt(currentIndex)) {
          break;
        }
        currentIndex++;
      }

      result = result.substring(0, currentIndex);
    }
    return result;
  }

  static String determineLongestPrefix(String[] arr) {
    if (arr == null || arr.length == 0) {
      return "";
    }
    int currentIndex = 0;
    StringBuilder stringBuilder = new StringBuilder();
    while (currentIndex < arr[0].length()) {
      char ch = arr[0].charAt(currentIndex);
      boolean flag = false;
      for (int i = 1; i < arr.length; i++) {
       if (currentIndex == arr[i].length() || arr[i].charAt(currentIndex) != ch) {
         flag = true;
         break;
       }
      }
      if (flag) {
        break;
      }
      stringBuilder.append(ch);
      currentIndex++;
    }
    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    String arr[] = {"flower", "flow", "float"};

    System.out.println(determineLongestPrefix(arr));
    System.out.println(determineLongestPrefixv2(arr));
  }

}

