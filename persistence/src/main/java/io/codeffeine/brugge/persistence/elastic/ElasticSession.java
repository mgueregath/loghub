/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.codeffeine.brugge.persistence.elastic;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.google.inject.Inject;
import io.codeffeine.brugge.persistence.elastic.configuration.ElasticConfiguration;
import io.codeffeine.brugge.persistence.elastic.exception.ElasticSearchNotEnabledException;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

/**
 *
 * @author mguer
 */
public class ElasticSession {

    private static ElasticsearchClient elasticClient;
    private static ElasticConfiguration configuration;

    @Inject
    public ElasticSession(ElasticConfiguration configuration) {
        this.configuration = configuration;
        if (elasticClient == null && configuration.getEnabled() == true) {

            RestClient elasticRestClient = RestClient
                    .builder(HttpHost.create(configuration.getHost()))
                    .build();

            ElasticsearchTransport transport = new RestClientTransport(
                    elasticRestClient, new JacksonJsonpMapper());

            elasticClient = new ElasticsearchClient(transport);
        }
    }

    public ElasticsearchClient getSession() {
        if (this.configuration.getEnabled() != true) {
            throw new ElasticSearchNotEnabledException();
        }
        return elasticClient;
    }

    public void stop() {
        if (elasticClient != null) {
            elasticClient.shutdown();
        }
    }

    public String getIndex(String index) {
        return configuration.getPrefix() + "_" + index;
    }
}
