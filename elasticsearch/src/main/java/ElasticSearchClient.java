import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class ElasticSearchClient {
    private RestHighLevelClient client;
    public void connect(){
        client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http"),
                        new HttpHost("localhost", 9201, "http")));
    }
    public void close() throws IOException {
        if (client!=null)
            client.close();
    }
    public IndexResponse index(IndexRequest request) throws IOException {
        IndexResponse indexResponse = client.index(request);
        return indexResponse;

    }

}
