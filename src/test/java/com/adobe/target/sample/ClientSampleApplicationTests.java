/*
 * Copyright 2019 Adobe. All rights reserved.
 * This file is licensed to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may obtain a copy
 * of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
 * OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.adobe.target.sample;

import com.adobe.target.delivery.v1.model.*;
import com.adobe.target.edge.client.ClientConfig;
import com.adobe.target.edge.client.TargetClient;
import com.adobe.target.edge.client.model.TargetDeliveryRequest;
import com.adobe.target.edge.client.model.TargetDeliveryResponse;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ClientSampleApplicationTests {
    {
      //  System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "DEBUG");
    }
    @Test
    public void superSimple() {
        ClientConfig config = ClientConfig.builder().client("emeaprod4")
                .organizationId("0DD934B85278256B0A490D44@AdobeOrg")
                .build();
        TargetClient targetClient = TargetClient.create(config);
        MboxRequest mbox = new MboxRequest().name("server-side-mbox").index(0);
        TargetDeliveryRequest request = TargetDeliveryRequest.builder()
                .context(new Context().channel(ChannelType.WEB))
                .execute(new ExecuteRequest().mboxes(Arrays.asList(mbox)))
                .build();

        TargetDeliveryResponse offers = targetClient.getOffers(request);

        if (offers.getStatus() == 200) {
            DeliveryResponse response = offers.getResponse();
        }
    }



    @Test
    public void superSAIC() {
        ClientConfig config = ClientConfig.builder().client("saicmotorcorporation")
//                .organizationId("521376F9565820527F000101@AdobeOrg")
                .organizationId("F2C014155D6CD7020A495E95@AdobeOrg")
                .build();
        TargetClient targetClient = TargetClient.create(config);
        MboxRequest mbox = new MboxRequest().name("target-global-mbox").index(0);
        TargetDeliveryRequest request = TargetDeliveryRequest.builder()
                .context(new Context().channel(ChannelType.WEB))
                .execute(new ExecuteRequest().mboxes(Arrays.asList(mbox)))
                .build();

        TargetDeliveryResponse offers = targetClient.getOffers(request);

        if (offers.getStatus() == 200) {
            DeliveryResponse response = offers.getResponse();
        }
    }


    @Test
    public void superInternal() {
        ClientConfig config = ClientConfig.builder().client("adobeinternalags920")
//                .organizationId("521376F9565820527F000101@AdobeOrg")
                .organizationId("3C4C3DE35A571CC70A495E43@AdobeOrg")
                .build();
        TargetClient targetClient = TargetClient.create(config);
        MboxRequest mbox = new MboxRequest().name("target-global-mbox").index(0);
        TargetDeliveryRequest request = TargetDeliveryRequest.builder()
                .context(new Context().channel(ChannelType.WEB))
                .execute(new ExecuteRequest().mboxes(Arrays.asList(mbox)))
                .build();

        TargetDeliveryResponse offers = targetClient.getOffers(request);

        if (offers.getStatus() == 200) {
            DeliveryResponse response = offers.getResponse();
        }
    }

    private static void simpleRequest(TargetClient targetClient) {

        List<MboxRequest> mboxes = Arrays.asList(new MboxRequest().name("a1-serverside-ab").index(0));
        TargetDeliveryRequest targetDeliveryRequest = TargetDeliveryRequest.builder()
                .context(new Context().channel(ChannelType.WEB))
                .execute(new ExecuteRequest().mboxes(mboxes))
                .build();

        TargetDeliveryResponse offersAsync = targetClient.getOffers(targetDeliveryRequest);
    }

}
