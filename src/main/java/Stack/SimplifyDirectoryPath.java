package Stack;

import java.util.Stack;

/**
 * Created by hatim.lokhandwala on 02/04/20
 */
public class SimplifyDirectoryPath {

    public static String simplifyPath(String A) {
        if (A == null || A.length() == 0) {
            return "/";
        }
        Stack<String> st = new Stack<>();
        String[] tokens = A.split("/");
        for (String token: tokens) {
            if (token.equals(".") || token.isEmpty()) {
                continue;
            }
            if (token.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(token);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
            sb.insert(0, "/");
        }
        if (sb.length() == 0) {
            return "/";
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }


}
