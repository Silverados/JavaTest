package blackJack;

import java.util.ArrayList;

/**
 * 玩家属性：资产，赌资，手牌
 * 玩家行为：下注，要牌，过
 */
public class Player {

    private int acount;//资产
    private int bet;//赌注
    private String gameResult;//游戏结果
    public HandCard handCard;//手牌
    private String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 默认的一组手牌具有花色和点数 例如："黑桃A"
     */
    private ArrayList<String> keep = new ArrayList();

    /**
     * 只带点数的牌组 例如："黑桃A" --> 1
     */
    private ArrayList<Integer> points = new ArrayList<Integer>();

    public ArrayList<String> getKeep() {
        return keep;
    }

    public void setKeep(ArrayList<String> keep) {
        this.keep = keep;
    }

    public ArrayList<Integer> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Integer> points) {
        this.points = points;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getAcount() {
        return acount;
    }

    public void setAcount(int acount) {
        this.acount = acount;
    }

    public void add(String s) {
        keep.add(s);
    }


    /**
     * 记录A的张数
     */
    private int countA = 0;


    /**
     * 该方法将默认的牌转化成仅带点数的链表。即实现"黑桃J" --> 10
     *
     * @return 只带点数的牌组
     */
    public void toPoint() {
        points.clear();
        for (String s : keep) {
            String sub = s.substring(2);
            int point = 0;
            if (sub.equals("J") || sub.equals("Q") || sub.equals("K") || sub.equals("10")) {
                point = 10;
            } else if (sub.equals("A")) {
                point = 1;
                this.countA = 1;
            } else {
                point = Integer.valueOf(sub);
            }
            points.add(point);

        }

    }


    /**
     * @return 手牌的总点数
     */
    public int countPoint() {
        int sum = 0;
        this.toPoint();
        for (Integer point : points) {
            sum += point;
        }
        return sum;
    }

    public int countPointWithA() {
        return this.countPoint() + 10;
    }

    /**
     * 判断是否有 A
     *
     * @return true代表有A，false代表无A
     */
    public boolean checkA() {
        return this.countA == 1 ? true : false;
    }

    /**
     * 玩家可以选择是否要牌
     */
    public void needCard(String s) {
        System.out.println("要一张牌");
        keep.add(s);
        System.out.println("玩家是否有A：" + checkA());
        if (checkA()){

        }
    }


}
