package blackJack;

import java.util.ArrayList;

/**
 * 玩家持有一组牌
 * 可以选择加牌
 *
 * 玩家的逻辑应该是：看手牌：
 * 1.判断手牌的状态：是否是BlackJack/cheat/normal。如果是BlackJack直接win。
 * 2.如果不是BlackJack，玩家会计算手牌的点数，如果这时候手牌没有A，且大于等于17，
 *   电脑玩家会根据随机算法确定是否要牌，对于电脑玩家一旦牌点和大于等于18就不会再要牌。
 *   人类玩家根据 选择 是否要牌；一旦牌数大于21点系统会判断玩家的状态为brust，不会再询问玩家是否要牌。
 *
 *
 *   逻辑：把 A 当成 1 处理，但是如果手牌有 A 会进行 +10 处理同时进行判断手牌的状态；电脑如果 +10后大于18
 *        就不会要牌。人类玩家可以继续要牌，且把 A 当做 1 进行运算，一旦当成 1 处理后状态变为 brust，停止给牌。
 *        具体实现如果是button选择要牌和不要，此时button设置enable=false。对于有 A 的时候当玩家停止要牌，检查
 *        手牌点数小于17，这时候将 A 当成11处理：
 *
 *   实现：在把 A 当成 1 进行运算后，添加一个 checkA 函数，该函数会把结果+10后判断手牌的状态
 */
public class Player {


    /**
     * 默认的一组手牌具有花色和点数 例如："黑桃A"
     */
    private ArrayList<String> keep = new ArrayList();

    /**
     * 只带点数的牌组 例如："黑桃A" --> 1
     */
    private ArrayList<Integer> points = new ArrayList<Integer>();

    /**
     * 记录A的张数
     */
    private int countA = 0;

    /**
     * status表示状态
     * Blackjack （status = 1）： 一张A + 10/J/Q/K
     * Brust （status = 2）: 点数超过21
     * Cheat （status = 3）: 点数不足17
     * Normal (status = 4) : 点数正常
     */
    private String status = "Normal";

    public String getStatus(){
        int point = this.countPoint();
        if (this.checkA()&&this.keep.size()==2&&point==11) {
            return "BlackJack";
        }
        if (point>21) return "Brust";
        else if (point<17) return "Cheat";
        else return  status;
    }

    public String getStatusA(){
        int point = this.countPoint();
        point = point + 10;
        if (point>21) return "Brust";
        else if (point<17) return "Cheat";
        else return  status;
    }


    /**
     * countA : getter/setter
     */
    public int getCountA() {
        return countA;
    }

    public void setCountA(int countA) {
        this.countA = countA;
    }

    /**
     * keep : getter/setter
     */
    public ArrayList<String> getKeep() {
        return keep;
    }
    public void setKeep(ArrayList<String> keep) {
        this.keep = keep;
    }
    /**
     * 该方法将默认的牌转化成仅带点数的链表。即实现"黑桃J" --> 10
     * @return 只带点数的牌组
     */
    public void toPoint(){

        for (String s : keep) {
            String sub = s.substring(2);
            int point = 0;
            if(sub.equals("J")||sub.equals("Q")||sub.equals("K")||sub.equals("10")){
                point = 10;
            }else if (sub.equals("A")){
                point = 1;
                this.countA = 1;
            }else {
                point = Integer.valueOf(sub);
            }
            points.add(point);

        }

    }



    /**
     * @return 手牌的总点数
     */
    public int countPoint(){
        int sum = 0;
        this.toPoint();
        for (Integer point : points) {
            sum += point;
        }
        return sum;
    }

    /**
     * 判断是否有 A
     * @return true代表有A，false代表无A
     */
    public boolean checkA(){
        return this.countA==1?true:false;
    }

    /**
     * 玩家可以选择是否要牌
     */
    public void needCard(){
        System.out.println("要一张牌");
    }
}
