package blackJack;

public class Result {
    public static final String WIN = "win";
    public static final String LOSE = "lose";
    public static final String EVEN = "even";// 平

    public static void checkResult(Player player,Player delayer){
        /**
         * 首先判断状态,然后是判断点数： (只需要判断玩家)
         * if brust -> status = lose
         * if both normal -> judge countpoint : point bigger win.
         * if cheat -> status = lose
         * if blackjack -> win
         */
        String playerStatus = player.getStatus();
        String delayerStatus = delayer.getStatus();

        if (playerStatus.equals(HandCard.BLACKJACK)){
            if (delayerStatus.equals(HandCard.BLACKJACKPOINT)){
                player.setGameResult(Result.EVEN);
            }else player.setGameResult(Result.WIN);
        }else if (playerStatus.equals(HandCard.BRUST)){
            if (delayerStatus.equals(HandCard.NORMAL)){
                player.setGameResult(Result.LOSE);
            }else player.setGameResult(Result.EVEN);
        }else if (playerStatus.equals(HandCard.NORMAL)){
            if (delayer.getStatus().equals(HandCard.BRUST)){
                player.setGameResult(Result.WIN);
            }else if (delayer.getStatus().equals(HandCard.NORMAL)){
                if (player.countPoint() > delayer.countPoint()) {
                    player.setGameResult(Result.WIN);
                }else if (player.countPoint() == delayer.countPoint()){
                    player.setGameResult(Result.EVEN);
                }else  if (player.countPoint() < delayer.countPoint()){
                    player.setGameResult(Result.LOSE);
                }

            }
        }

    }

    /**
     * 如果够17点，调用判断是否要牌方法
     * 如果不够17点，调用要牌方法
     */
    public static boolean judgeCheat(Player player){

        if (player.checkA() == false){
            if (player.countPoint()<HandCard.MINNORMALPOINT) return true;
        }else {
            if (player.countPointWithA() < HandCard.MINNORMALPOINT) return true;
        }
        return false;
    }

    public static boolean judgeBrust(Player player){
        if (player.checkA() == false){
            if (player.countPoint()> HandCard.BLACKJACKPOINT) return true;
        }else {
            if (player.countPointWithA()> HandCard.BLACKJACKPOINT) return true;
        }
        return false;

    }
    public static boolean judgeBlackJack(Player player){
        if (player.getStatus().equals(HandCard.BLACKJACKPOINT)) return true;
        else return false;
    }


    public static void delayBet(Player player){
        if (player.getGameResult().equals(WIN)){
            player.setAcount(player.getAcount()+player.getBet());
        } else if (player.getGameResult().equals(LOSE)) {
            player.setAcount(player.getAcount()-player.getBet());
        } else player.setAcount(player.getAcount());
    }
}
