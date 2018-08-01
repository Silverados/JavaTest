package Book;

public class Question1_1_11 {
    public static void main(String[] args){
        boolean[][] b = new boolean[][]{{true,false},{false,true},{true,true}};
        p(b);
    }

    public static void p(boolean[][] b){
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print("第"+(i+1)+"行 "+"第"+(j+1)+"列：");
                if (b[i][j]) System.out.println("*");
                else System.out.println(" ");
            }
        }
    }
}
