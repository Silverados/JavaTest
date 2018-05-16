package blackJack;

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
public class HandCard {
    /**
     * status表示状态
     * Blackjack ： 一张A + 10/J/Q/K
     * Brust : 点数超过 21
     * Cheat : 点数不足 17
     * Normal : 点数正常
     */
    public static final String BRUST = "Brust";
    public static final String CHEAT = "Cheat";
    public static final String BLACKJACK = "BlackJack";
    public static final String NORMAL = "Normal";

    public static final int BLACKJACKPOINT = 21;
    public static final int MINNORMALPOINT = 17;
    public static final int INITKEEPAMOUNT = 2;

    public static String setStatus(int point){
        return setStatus(point,0);
    }

    public static String setStatus(int point, int keepAmount){
        if (keepAmount == HandCard.INITKEEPAMOUNT && point == HandCard.BLACKJACKPOINT) return HandCard.BLACKJACK;
        else if (point>HandCard.BLACKJACKPOINT) return HandCard.BRUST;
        else if (point<HandCard.MINNORMALPOINT) return HandCard.CHEAT;
        else if (point>=HandCard.MINNORMALPOINT&&point<=HandCard.BLACKJACKPOINT) return HandCard.NORMAL;
        else return HandCard.NORMAL;
    }


}
