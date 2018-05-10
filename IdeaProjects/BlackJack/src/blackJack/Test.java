package blackJack;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){

        Pile p = new Pile();
        List<String> piles = p.createRandomPiles();

        System.out.println("************游戏开始了**********");
        System.out.println("输入玩家数量：");
        System.out.println("玩家开始下注");
        System.out.println("玩家下注数分别是:1,2,3,4");
        System.out.println("荷官开始洗牌");
        for (String s : piles) {
            System.out.print(s+" ");
        }
        System.out.println("荷官开始发牌");
        System.out.println("荷官询问玩家是否要牌");
        Player player1 = new Player();
        ArrayList<String> p1 = new ArrayList<String>();
        for (int i = 0; i < 2; i++) {
            p1.add(piles.get(i));
        }
        player1.setKeep(p1);
        System.out.println(player1.getKeep().toString());
        System.out.println("判断手牌的状态："+player1.getStatus());
        if (player1.getStatus().equals("BlackJack")) {
            System.out.println("玩家BlackJack，玩家胜利！");
        }else {
            System.out.println("现在的点数和是：" + player1.countPoint());
            System.out.printf("玩家是否有A：" + player1.checkA());
            if (player1.checkA()) {
                System.out.println("玩家有A，");
            }

            System.out.println("玩家回答：要");
            System.out.println("荷官给玩家添加了一张牌");
            System.out.println("荷官询问玩家是否要牌");
            System.out.println("玩家回答：不要");

        }

        System.out.println("荷官询问下一位玩家是否要牌...");

        System.out.println("荷官询问最后一名玩家是否要牌...");

        System.out.println("荷官正在查看自己的手牌");
        System.out.println("荷官给自己加了一张牌");
        System.out.println("荷官说开牌并掀开了自己的牌，他的点数是：20");

        System.out.println("荷官掀开了玩家的手牌，分别是：18,20,23,21");
        System.out.println("游戏结束！胜利的是玩家：4 失败的是玩家：1,3 平的是玩家：2");
    }
}
