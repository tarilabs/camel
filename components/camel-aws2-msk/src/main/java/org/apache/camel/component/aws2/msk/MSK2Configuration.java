/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.aws2.msk;

import org.apache.camel.RuntimeCamelException;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.apache.camel.spi.UriPath;

import software.amazon.awssdk.core.Protocol;
import software.amazon.awssdk.services.kafka.KafkaClient;

@UriParams
public class MSK2Configuration implements Cloneable {

    @UriPath(description = "Logical name")
    @Metadata(required = true)
    private String label;
    @UriParam(label = "producer")
    private KafkaClient mskClient;
    @UriParam(label = "producer", secret = true)
    private String accessKey;
    @UriParam(label = "producer", secret = true)
    private String secretKey;
    @UriParam(label = "producer")
    @Metadata(required = true)
    private MSK2Operations operation;
    @UriParam(enums = "HTTP,HTTPS", defaultValue = "HTTPS")
    private Protocol proxyProtocol = Protocol.HTTPS;
    @UriParam(label = "producer")
    private String proxyHost;
    @UriParam(label = "producer")
    private Integer proxyPort;
    @UriParam
    private String region;

    public KafkaClient getMskClient() {
        return mskClient;
    }

    /**
     * To use a existing configured AWS MSK as client
     */
    public void setMskClient(KafkaClient mskClient) {
        this.mskClient = mskClient;
    }

    public String getAccessKey() {
        return accessKey;
    }

    /**
     * Amazon AWS Access Key
     */
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    /**
     * Amazon AWS Secret Key
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public MSK2Operations getOperation() {
        return operation;
    }

    /**
     * The operation to perform
     */
    public void setOperation(MSK2Operations operation) {
        this.operation = operation;
    }
    
    public Protocol getProxyProtocol() {
        return proxyProtocol;
    }

    /**
     * To define a proxy protocol when instantiating the MSK client
     */
    public void setProxyProtocol(Protocol proxyProtocol) {
        this.proxyProtocol = proxyProtocol;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    /**
     * To define a proxy host when instantiating the MSK client
     */
    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public Integer getProxyPort() {
        return proxyPort;
    }

    /**
     * To define a proxy port when instantiating the MSK client
     */
    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getRegion() {
        return region;
    }

    /**
     * The region in which MSK client needs to work. When using this parameter, the configuration will expect the capitalized name of the region (for example AP_EAST_1)
     * You'll need to use the name Regions.EU_WEST_1.name()
     */
    public void setRegion(String region) {
        this.region = region;
    }

    // *************************************************
    //
    // *************************************************

    public MSK2Configuration copy() {
        try {
            return (MSK2Configuration)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeCamelException(e);
        }
    }
}
