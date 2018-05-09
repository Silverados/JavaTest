package useful;

import java.io.*;

public class SQLOperator {

    public static final int insertValue = 80;

    public static void main(String[] args) {
        /**
         * 在指定路径下创建sql文件
         */
        File file = new File("D:/add.sql");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /**
         * 编写sql语句
         * insert into math values
         * (id,json),(),();
         * json格式：{ "question": "../image/1-q.png", "option": { "A": "../image/1-a.png", "B": "../image/1-b.png",
         * "C": "../image/1-c.png", "D": "../image/1-d.png" }, "true": "A", "number":"4" }
         */
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            StringBuffer s = new StringBuffer();
            s.append("insert into math values");
            for (int i = 1; i <= insertValue; i++) {
                s.append("(" + i + "," + "'{" +
                        "\"question\": " + "\"http://111.230.50.64:8080/usr/tomcat/webapps/WxMath/image/" + i + "-q.png\"," +
                        "\"option\": {" +
                        "\"A\": \"http://111.230.50.64:8080/usr/tomcat/webapps/WxMath/image/" + i + "-a.png\", " +
                        "\"B\": \"http://111.230.50.64:8080/usr/tomcat/webapps/WxMath/image/" + i + "-b.png\", " +
                        "\"C\": \"http://111.230.50.64:8080/usr/tomcat/webapps/WxMath/image/" + i + "-c.png\", " +
                        "\"D\": \"http://111.230.50.64:8080/usr/tomcat/webapps/WxMath/image/" + i + "-d.png\" " +
                        "}, \"true\": " + "\"A\", \"number\":\"4\" }" + "')");
                if (i != insertValue) {
                    s.append("\n,");
                } else {
                    s.append(";");
                }
            }

            bufferedWriter.write(s.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
