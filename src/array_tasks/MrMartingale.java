package array_tasks;
//15.12.2021
//You're in the casino, playing Roulette, going for the "1-18" bets only and desperate to beat
// the house and so you want to test how effective the Martingale strategy is.//
//You will be given a starting cash balance and an array of binary digits to represent a win (1) or a loss (0).
// Return your balance after playing all rounds.//
//The Martingale strategy//
//You start with a stake of 100 dollars. If you lose a round,
// you lose the stake placed on that round and you double the stake for your next bet.
// When you win, you win 100% of the stake and revert back to staking 100 dollars on your next bet.
public class MrMartingale {
    static int MartingaleStrategy(int[] martingale, int balance){
        int bets = 100;
        for (int j : martingale) {
            if (j == 0) {
                balance -= bets;
                bets = bets * 2;
            } else {
                balance += bets;
                bets = 100;
            }
        }
        return balance;
    }
    public static void main(String[] args) {
        int[] martingale = {1,1,0,0,1};
        int balanceStart = 1000;
        int balanceFinish = MartingaleStrategy(martingale, balanceStart);
        System.out.println("Баланс после игры равен "+balanceFinish);
    }
}
