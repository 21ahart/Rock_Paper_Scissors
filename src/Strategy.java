/**
 * The Strategy interface defines the method for determining the computer's move
 * in the Rock Paper Scissors game based on the player's previous choices.
 */
public interface Strategy {
    /**
     * Determines the computer's move based on the player's previous choices.
     *
     * @param playerChoicesCount an array representing the count of each choice made by the player (0 for rock, 1 for paper, 2 for scissors)
     * @param currentPlayerChoice the player's current choice (0 for rock, 1 for paper, 2 for scissors)
     * @param lastPlayerChoice the player's last choice (0 for rock, 1 for paper, 2 for scissors)
     * @return the computer's choice (0 for rock, 1 for paper, 2 for scissors)
     */
    public int determineMove(int[] playerChoicesCount, int currentPlayerChoice, int lastPlayerChoice);
}