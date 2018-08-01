package Socket;

import com.sun.javafx.fxml.builder.URLBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;
import java.net.URISyntaxException;

public class HttpClient_Learning {

    public static void doGetWithParam(String address, String ak) throws URISyntaxException, IOException {


        address = address.trim();
        address = address.replaceAll(" ", "");
        address = address.replaceAll("#", "");
        if (address.length() > 84 / 2) address = address.substring(0, 41);

        CloseableHttpClient httpClient = HttpClients.createDefault();

        URIBuilder uriBuilder = new URIBuilder("http://api.map.baidu.com/geocoder/v2/");
        uriBuilder.addParameter("address",address).addParameter("ak",ak).addParameter("output","json");

        HttpGet get = new HttpGet(uriBuilder.build());

        CloseableHttpResponse response = httpClient.execute(get);

        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);

        HttpEntity entity = response.getEntity();
        String string = EntityUtils.toString(entity,"utf-8");
        System.out.println(string);

        response.close();
        httpClient.close();

    }


    public void pool() throws InterruptedException {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        String[] urisToGet = {
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市虹口区欧阳路街道大连西路145弄16号403室（蒋家桥小区）&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市杨浦区大桥街道长阳路1658弄&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市浦东新区洋泾街道巨野路61弄9号楼401室&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市徐汇区宜山路701弄4号403室&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市浦东新区康桥镇秀沿路836弄1号1204室&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市浦东新区周浦镇周秀路516弄2号306室&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市徐汇区龙华街道水南路358弄4号1404室&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市松江区岳阳街道荣乐中路835弄26号102&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市普陀区万里街道新村路1881弄16号102&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市宝山区顾村镇电台路599弄65号502室&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市嘉定区安亭镇墨玉南路1011弄嘉亭菁苑7号1901&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市静安区江宁路街道海防路538弄4号6C&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市黄浦区半淞园路街道西藏南路1739弄4号102室&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市浦东新区东明路街道凌兆路586弄16号304室&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市杨浦区定海路街道隆昌路619号2号楼c09室&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市卢湾区制造局路646弄2号502室&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市【直辖县】崇明县向化镇卫星村永春1325号&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市青浦区白鹤镇白虬江路时代名邸二期65号楼1903室&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市闵行区浦江镇浦秀路1139弄62号702室&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市奉贤区青村镇贤瑞路111弄中南锦庭33号202室&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市嘉定区江桥镇嘉峪管路380弄4号楼704&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市杨浦区殷行街道包头路1150弄城市名园39号401室&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市浦东新区川沙新镇新川路856弄玉宇小区6号102室&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市静安区彭浦镇场中路2380弄2号501室&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市浦东新区祝桥镇航城三路518弄启航公馆18号802&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市徐汇区华泾镇华泾路599弄漓江花园10号1801室?翁玉旻??1891&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq",
                "http://api.map.baidu.com/geocoder/v2/?address=上海市上海市浦东新区南码头路街道东方路2880弄临沂大楼4号楼2102&output=json&ak=vtk9XXg0zOubVWXtORUydI7F8xg8SQzq"
        };

        GetThread[] threads = new GetThread[urisToGet.length];
        for (int i = 0; i < threads.length; i++) {
            HttpGet httpGet = new HttpGet(urisToGet[i]);
            threads[i] = new GetThread(httpClient,httpGet);
        }

        for (int j = 0; j < threads.length; j++) {
            threads[j].start();
        }

        for (int j = 0; j < threads.length; j++) {
            threads[j].join();
        }
    }

    class GetThread extends Thread{
        private final CloseableHttpClient httpClient;
        private final HttpClientContext context;
        private final HttpGet httpGet;

        public GetThread(CloseableHttpClient httpClient, HttpGet httpGet) {
            this.httpClient = httpClient;
            this.context = HttpClientContext.create();
            this.httpGet = httpGet;
        }

        @Override
        public void run(){
            try{
                CloseableHttpResponse response = httpClient.execute(httpGet, context);
                try{
                    HttpEntity entity = response.getEntity();
                    System.out.println(EntityUtils.toString(entity));
                }finally {
                    response.close();
                }
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
