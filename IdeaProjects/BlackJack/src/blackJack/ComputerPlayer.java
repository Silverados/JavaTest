package blackJack;

public class ComputerPlayer extends Player {

    /**
     * 电脑玩家在达到17点时 采用随机算法决定是否要牌
     * 当电脑玩家点数超过17点时，不再要牌

    /**
     * 随机算法
     * @return true或者false；根据随机数返回，表达要或者不要
     */
    public boolean getRandom(){
        return  Math.random()>0.5?true:false;
    }


}
