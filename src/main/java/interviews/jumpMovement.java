package interviews;

public class jumpMovement {
    public static boolean level(int[] obstacles, String instructions) {
        if (instructions == null || instructions.length() == 0) {
            return true;
        }
        int currentPosition = 0;
        int maxPosition = 10;
        char lastStep = ' ';
        for (Character currentCharacter: instructions.toCharArray()) {
            if (currentCharacter == 'R') {
                currentPosition++;
                lastStep = 'R';
            } else if (currentCharacter == 'L') {
                currentPosition--;
                lastStep = 'L';
            } else if (currentCharacter == 'J') {
                currentPosition = makeJump(lastStep, currentPosition);
            }
            if (currentPosition == maxPosition) {
                return true;
            }
            if (isObstaclePosition(currentPosition, obstacles)) {
                return false;
            }
        }
        return false;
    }

    static boolean isObstaclePosition(int currentPosition, int[] obstacles) {
        for (int i = 0; i < obstacles.length; i++) {
            if (obstacles[i] == currentPosition) {
                return true;
            }
        }
        return false;
    }

    static int makeJump(char lastStep, int currentPosition) {
        if (lastStep == 'R') {
            return currentPosition + 2;
        }
        return currentPosition - 2;
    }


    public static void main(String[] argv) {


    }
}






