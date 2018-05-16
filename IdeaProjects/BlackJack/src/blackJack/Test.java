package blackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Pile p = new Pile();
        List<String> piles = p.createRandomPiles();
        int pileindex = 0;
        System.out.println("************游戏开始了**********");
        //下注环节
        Player player1 = new Player();
        player1.setAcount(1000);
        System.out.println("玩家1的资产有：" + player1.getAcount());
        System.out.println("玩家1开始下注");
        player1.setBet(100);
        System.out.println("玩家下注数为:" + player1.getBet());
        //洗牌发牌环节
        System.out.println("庄家开始洗牌");
        for (String s : piles) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("庄家开始发牌");
        ArrayList<String> p1 = new ArrayList<String>();
        for (int i = 0; i < HandCard.INITKEEPAMOUNT; i++, pileindex++) {
            p1.add(piles.get(pileindex));
        }
        player1.setKeep(p1);
        System.out.println("玩家手牌: "+player1.getKeep().toString());
        System.out.println("庄家询问玩家是否要牌");
        //开局拿牌：1.确认有没有A；2.确认是否是BlackJack
        System.out.printf("玩家是否有A：" + player1.checkA());
//        if(player1.checkA()){
//            HandCard.setStatus(player1.countPointWithA(), HandCard.INITKEEPAMOUNT);
//            if (Result.judgeBlackJack(player1)){
//                System.out.println("玩家BlackJack，等待庄家开牌");
//            }else if (Result.judgeCheat(player1)){
//                System.out.println("玩家Cheat，必须要牌");
//                player1.needCard(piles.get(pileindex++));
//            }
//
//
//        }else {
//            System.out.println("等待庄家开牌");
//        }

        player1.setStatus(HandCard.setStatus(player1.countPoint(), HandCard.INITKEEPAMOUNT));
        if (player1.getStatus().equals(HandCard.BLACKJACKPOINT)) {
            player1.setStatus(HandCard.BLACKJACK);
            System.out.println("玩家BlackJack，玩家胜利！");
        } else {
            System.out.println("现在的点数和是：" + player1.countPoint());
            System.out.printf("玩家是否有A：" + player1.checkA());
            if (player1.checkA()) {
                System.out.println("玩家有A，总和可以变为：" + player1.countPointWithA());
            }
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("玩家选择是否继续要牌:1,要牌 2，不要");
                int choose = scanner.nextInt();
                if (choose == 1) {
                    System.out.println("玩家回答：要");
                    System.out.println("庄家给玩家添加了一张牌" + piles.get(pileindex));
                    player1.needCard(piles.get(pileindex++));
                    System.out.println("现在的点数和是：" + player1.countPoint());
                    System.out.println("玩家是否有A：" + player1.checkA());
                    if (player1.checkA()) {
                        System.out.println("玩家有A，总和可以变为：" + player1.countPointWithA());
                    }
                    if (HandCard.setStatus(player1.countPoint(), HandCard.INITKEEPAMOUNT).equals(HandCard.BRUST)) {
                        System.out.println("玩家选择是否继续要牌:1,要牌 2，不要");
                        System.out.println("提示：当前点数已经BRUST,默认选择不要\n玩家回答：不要");
                        break;
                    }
                } else {

                    System.out.println("玩家回答：不要");
                    if (Result.judgeCheat(player1)){
                        System.out.println("你的手牌状态是CHEAT,不能停止要牌");
                        continue;
                    }
                    if (player1.checkA() == true){
                        player1.setStatus(HandCard.setStatus(player1.countPointWithA()));
                    }

                    break;
                }
                player1.setStatus(HandCard.setStatus(player1.countPoint()));
            }

        }
        Player delayer = new Player();
        System.out.println("庄家查看自己手牌：");

        ArrayList<String> p2 = new ArrayList<String>();
        for (int i = 0; i < HandCard.INITKEEPAMOUNT; i++, pileindex++) {
            p2.add(piles.get(pileindex));
        }
        delayer.setKeep(p2);
        System.out.println(delayer.getKeep().toString());


        System.out.println("判断手牌的状态：" + HandCard.setStatus(delayer.countPoint(), HandCard.INITKEEPAMOUNT));

        if (HandCard.setStatus(delayer.countPoint(), HandCard.INITKEEPAMOUNT).equals(HandCard.BLACKJACKPOINT)) {
            delayer.setStatus(HandCard.BLACKJACK);
            System.out.println("庄家BlackJack，庄家胜利！");
        } else {
            System.out.println("现在的点数和是：" + delayer.countPoint());
            System.out.printf("庄家是否有A：" + delayer.checkA());
            if (delayer.checkA()) {
                System.out.println("庄家有A，总和可以变为：" + delayer.countPointWithA());
            }
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("庄家选择是否继续要牌:1,要牌 2，不要");
                int choose = scanner.nextInt();
                if (choose == 1) {
                    System.out.println("庄家回答：要");
                    System.out.println("庄家给自己添加了一张牌" + piles.get(pileindex));
                    delayer.needCard(piles.get(pileindex++));
                    System.out.println("现在的点数和是：" + delayer.countPoint());
                    System.out.printf("庄家是否有A：" + delayer.checkA());
                    if (delayer.checkA()) {
                        System.out.println("庄家有A，总和可以变为：" + delayer.countPointWithA());
                    }
                    if (HandCard.setStatus(delayer.countPoint(), HandCard.INITKEEPAMOUNT).equals(HandCard.BRUST)) {
                        break;
                    }
                } else {

                    System.out.println("庄家回答：不要");
                    if (Result.judgeCheat(delayer)){
                        System.out.println("你的手牌状态是CHEAT,不能停止要牌");
                        continue;
                    }
                    break;
                }

            }

            delayer.setStatus(HandCard.setStatus(delayer.countPoint()));
        }

        Result.checkResult(player1, delayer);
        Result.delayBet(player1);
        System.out.println(player1.getAcount());
    }
}
