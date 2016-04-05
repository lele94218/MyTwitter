package com.terryx.elasticsearch.client;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import java.util.Properties;

/**
 * Created by xueta on 2016/4/1 16:38.
 * 负责TransportClient创建、销毁的工厂 bean
 */
public class TransportClientFactoryBean implements FactoryBean<TransportClient>, InitializingBean, DisposableBean {
    private static final Logger LOGGER = Logger.getLogger(TransportClientFactoryBean.class);

    private String clusterNodes = "127.0.0.1:9300";
    private String clusterName = "elasticsearch";
    private Boolean clientTransportSniff = false;
    private Boolean clientIgnoreClusterName = Boolean.FALSE;
    private String clientPingTimeout = "5s";
    private String clientNodesSamplerInterval = "5s";
    private TransportClient client;
    private Properties properties;
    static final String COLON = ":";
    static final String COMMA = ",";

    public void destroy() throws Exception {
        try {
            LOGGER.info("Closing elasticsearch client");
            if (client != null) {
                client.close();
            }
        } catch (final Exception e) {
            LOGGER.error("Error closing elasticsearch client: " + e);
        }
    }

    public TransportClient getObject() throws Exception {
        return client;
    }

    public Class<TransportClient> getObjectType() {
        return TransportClient.class;
    }

    public boolean isSingleton() {
        return false;
    }

    public void afterPropertiesSet() throws Exception {
        buildClient();
    }

    protected void buildClient() {
        client = new TransportClient(settings());
        Assert.hasText(clusterNodes, "[Assertion failed] clusterNodes settings missing.");
        for (String clusterNode : StringUtils.split(clusterNodes, COMMA)) {
            String hostName = StringUtils.substringBefore(clusterNode, COLON);
            String port = StringUtils.substringAfter(clusterNode, COLON);
            Assert.hasText(hostName, "[Assertion failed] missing host name in 'clusterNodes'");
            Assert.hasText(port, "[Assertion failed] missing port in 'clusterNodes'");
            LOGGER.info("adding transport node: " + clusterNode);
            client.addTransportAddress(new InetSocketTransportAddress(hostName, Integer.valueOf(port)));
        }
        client.connectedNodes();
    }

    private Settings settings() {
        if (properties != null) {
            return ImmutableSettings.settingsBuilder().put(properties).build();
        }
        return ImmutableSettings.settingsBuilder()
                .put("cluster.name", clusterName)
                .put("client.transport.sniff", clientTransportSniff)
                .put("client.transport.ignore_cluster_name", clientIgnoreClusterName)
                .put("client.transport.ping_timeout", clientPingTimeout)
                .put("client.transport.nodes_sampler_interval", clientNodesSamplerInterval)
                .build();
    }

    public void setClusterNodes(String clusterNodes) {
        this.clusterNodes = clusterNodes;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public void setClientTransportSniff(Boolean clientTransportSniff) {
        this.clientTransportSniff = clientTransportSniff;
    }

    public Boolean getClientIgnoreClusterName() {
        return clientIgnoreClusterName;
    }

    public void setClientIgnoreClusterName(Boolean clientIgnoreClusterName) {
        this.clientIgnoreClusterName = clientIgnoreClusterName;
    }

    public String getClientPingTimeout() {
        return clientPingTimeout;
    }

    public void setClientPingTimeout(String clientPingTimeout) {
        this.clientPingTimeout = clientPingTimeout;
    }

    public String getClientNodesSamplerInterval() {
        return clientNodesSamplerInterval;
    }

    public void setClientNodesSamplerInterval(String clientNodesSamplerInterval) {
        this.clientNodesSamplerInterval = clientNodesSamplerInterval;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
