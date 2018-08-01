package Text;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RegexHtml {
    public static void main(String[] args) throws IOException {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        String uri = "https://y.qq.com/n/yqq/album/002eFUFm2XYZ7z.html";
        HttpGet httpGet = new HttpGet(uri);

        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();
        String html = EntityUtils.toString(entity);

    }
}
