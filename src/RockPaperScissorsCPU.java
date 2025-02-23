import java.util.Random;

public class RockPaperScissorsCPU {

    public RockPaperScissorsCPU() {
    }

    public static int getComputerChoice(int[] playerChoicesCount, int currentPlayerChoice, int lastPlayerChoice) {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        int methodChoice;

        if (randomNumber < 10) {
            methodChoice = 0;
        } else {
            methodChoice = random.nextInt(4)+1;
            while (methodChoice == 3 && lastPlayerChoice == -1) {
                methodChoice = random.nextInt(4)+1;
            }
        }

        switch (methodChoice) {
            case 0:
                return cheatChoice(currentPlayerChoice);
            case 1:
                return leastUsedChoice(playerChoicesCount);
            case 2:
                return mostUsedChoice(playerChoicesCount);
            case 3:
                return lastPlayerChoice;
            case 4:
                return (int) (Math.random() * 3);
        }

        return -1;
    }

    private static int cheatChoice(int playerChoice) {
        int choice = (playerChoice + 1) % 3;

        System.out.println("Cheat choice: " + choice); // Debugging

        return choice;

        
    }

    private static int leastUsedChoice(int[] playerChoicesCount) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < playerChoicesCount.length; i++) {
            if (playerChoicesCount[i] < min) {
                min = playerChoicesCount[i];
                minIndex = i;
            }
        }

        System.out.println("Least used choice: " + minIndex); // Debugging

        return minIndex;
    }

    private static int mostUsedChoice(int[] playerChoicesCount) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < playerChoicesCount.length; i++) {
            if (playerChoicesCount[i] > max) {
                max = playerChoicesCount[i];
                maxIndex = i;
            }
        }

        System.out.println("Most used choice: " + maxIndex); // Debugging

        return maxIndex;
    }
}