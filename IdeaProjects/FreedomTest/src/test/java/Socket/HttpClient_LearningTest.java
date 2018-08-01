package Socket;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class HttpClient_LearningTest {

    @Test
    public void doGetWithParam() throws IOException, URISyntaxException, InterruptedException {
        HttpClient_Learning.doGetWithParam("上海市上海市嘉定区安亭镇曹安公路4908号西上海御庭168#1201", "vtk9XXg0zOubVWXtORUydI7F8xg8SQzq");
//        HttpClient_Learning httpClient_learning = new HttpClient_Learning();
//        httpClient_learning.pool();
    }
}