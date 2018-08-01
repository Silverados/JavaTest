package useful;

import java.io.File;

public class FileOperate {
    /**
     * 对文件进行改名：部分文件后缀是PNG ， 使用该类将其改为png.
     */
    public static void main(String[] args){
        File file = new File("C:\\Users\\dell-pc\\Desktop\\新建文件夹");
        for (File file1 : file.listFiles()) {
            System.out.println(file1.getName());
            System.out.println(file1.getName().replace("PNG","png"));
            File file2 = new File("C:\\Users\\dell-pc\\Desktop\\新建文件夹"+"\\"+file1.getName().replace("PNG","png"));
            file1.renameTo(file2);
        }
    }
}
