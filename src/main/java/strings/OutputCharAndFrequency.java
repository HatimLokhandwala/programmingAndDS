package strings;



public class OutputCharAndFrequency {

    static String determineCharacterAndFrequency(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        char previous = '!';
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch: input.toCharArray()) {
            if (previous != '!' && ch != previous) {
                sb.append(previous);
                sb.append(count);
                count = 0;
            }
            previous = ch;
            count++;
        }
        sb.append(previous);
        sb.append(count);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(determineCharacterAndFrequency("abbccda"));
    }
}
