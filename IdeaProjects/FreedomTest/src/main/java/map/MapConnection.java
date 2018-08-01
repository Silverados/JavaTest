package map;

import Text.JsonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MapConnection {
    public static void main(String[] args){
        String ak = "vtk9XXg0zOubVWXtORUydI7F8xg8SQzq";
        String url = "http://api.map.baidu.com/direction/v2/driving?origin=40.01116,116.339303&destination=39.936404,116.452562&ak="+ak;
        URL url1 = null;
        HttpURLConnection urlConnection = null;
        BufferedReader rd = null;
        try{
            url1 = new URL(url);
            urlConnection = (HttpURLConnection) url1.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            rd = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
            StringBuffer sb = new StringBuffer();
//            int ch;
//            while ((ch = rd.read())>-1){
//                sb.append((char)ch);
//            }
            String data = null;
            while ((data = rd.readLine())!= null) {
                sb.append(data);
            }
            System.out.println(JsonUtil.toJsonString(sb));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
          urlConnection.disconnect();
            try {
                rd.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
