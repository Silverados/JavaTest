package crawler;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {

    public static void main(String[] args) throws IOException {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        String uri = "http://dl.stream.qqmusic.qq.com/C400002BJAv411rZ36.m4a?vkey=B5BB423C5E415BEDA3DFC5C38837CA4E8D874F0029E2B0741B78927BD51DE16BE6C3720899AB94FF707A6FBE44520BAE8352CB8290103C02&guid=621891097&uin=0&fromtag=66";
        HttpGet httpGet = new HttpGet(uri);

        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();
        InputStream content = entity.getContent();

        Pattern pattern = Pattern.compile("(?<=/)C.*(?=\\?)");
        Matcher matcher = pattern.matcher(uri);
        matcher.find();
        String asFileName = matcher.group();

        String parentPath = "F:\\爬虫";
        File file1 = new File(parentPath+"\\"+asFileName);

        try (FileOutputStream fileOutputStream = new FileOutputStream(file1)) {
            fileOutputStream.write(EntityUtils.toByteArray(entity));
        }


    }
}
