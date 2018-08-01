package JedisSearch;

import io.redisearch.client.Client;
import io.redisearch.Document;
import io.redisearch.SearchResult;
import io.redisearch.Query;
import io.redisearch.Schema;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
//        FT.CREATE idx SCHEMA txt TEXT
//        FT.ADD idx docCn 1.0 LANGUAGE chinese FIELDS txt "Redis支持主从同步。数据可以从主服务器向任意数量的从服务器上同步，从服务器可以是关联其他从服务器的主服务器。这使得Redis可执行单层树复制。从盘可以有意无意的对数据进行写操作。由于完全实现了发布/订阅机制，使得从数据库在任何地方同步树时，可订阅一个频道并接收主服务器完整的消息发布记录。同步对读取操作的可扩展性和数据冗余很有帮助。[8]"
//        FT.SEARCH idx "数据" LANGUAGE chinese HIGHLIGHT SUMMARIZE
//# Outputs:
//# <b>数据</b>?... <b>数据</b>进行写操作。由于完全实现了发布... <b>数据</b>冗余很有帮助。[8...

        Client client = new Client("idx", "111.230.50.64", 6379);
        Schema sc = new Schema().addTextField("txt",1);
        client.createIndex(sc, Client.IndexOptions.Default());
        Map<String, Object> fields = new HashMap<>();
        fields.put("txt", "Redis支持主从同步。数据可以从主服务器向任意数量的从服务器上同步，从服务器可以是关联其他从服务器的主服务器。这使得Redis可执行单层树复制。从盘可以有意无意的对数据进行写操作。由于完全实现了发布/订阅机制，使得从数据库在任何地方同步树时，可订阅一个频道并接收主服务器完整的消息发布记录。同步对读取操作的可扩展性和数据冗余很有帮助。[8]");
        fields.put("language","chinese");
        client.addDocument("doc1", fields);
        Query q = new Query("数据").setLanguage("chinese").highlightFields().summarizeFields();
        // actual search
        SearchResult res = client.search(q);
    }


}
