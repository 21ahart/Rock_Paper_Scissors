import java.util.Random;

/**
 * The StrategyImpl class implements the Strategy interface and provides
 * various methods to determine the computer's move in the Rock Paper Scissors game.
 */
public class StrategyImpl implements Strategy {

    /**
     * Determines the computer's move based on the player's previous choices.
     *
     * @param playerChoicesCount an array representing the count of each choice made by the player (0 for rock, 1 for paper, 2 for scissors)
     * @param currentPlayerChoice the player's current choice (0 for rock, 1 for paper, 2 for scissors)
     * @param lastPlayerChoice the player's last choice (0 for rock, 1 for paper, 2 for scissors)
     * @return the computer's choice (0 for rock, 1 for paper, 2 for scissors)
     */
    @Override
    public int determineMove(int[] playerChoicesCount, int currentPlayerChoice, int lastPlayerChoice) {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        int methodChoice;

        if (randomNumber < 10) {
            methodChoice = 0;
        } else {
            methodChoice = random.nextInt(4) + 1;
            while (methodChoice == 3 && lastPlayerChoice == -1) {
                methodChoice = random.nextInt(4) + 1;
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

    /**
     * Determines the computer's move to beat the player's current choice.
     *
     * @param playerChoice the player's current choice (0 for rock, 1 for paper, 2 for scissors)
     * @return the computer's choice that beats the player's choice
     */
    private int cheatChoice(int playerChoice) {
        int choice = (playerChoice + 1) % 3;

        System.out.println("Cheat choice: " + choice); // Debugging

        return choice;
    }

    /**
     * Determines the computer's move based on the player's least used choice.
     *
     * @param playerChoicesCount an array representing the count of each choice made by the player (0 for rock, 1 for paper, 2 for scissors)
     * @return the computer's choice based on the player's least used choice
     */
    private int leastUsedChoice(int[] playerChoicesCount) {
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

    /**
     * Determines the computer's move based on the player's most used choice.
     *
     * @param playerChoicesCount an array representing the count of each choice made by the player (0 for rock, 1 for paper, 2 for scissors)
     * @return the computer's choice based on the player's most used choice
     */
    private int mostUsedChoice(int[] playerChoicesCount) {
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