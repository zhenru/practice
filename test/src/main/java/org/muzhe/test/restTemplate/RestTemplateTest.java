package org.muzhe.test.restTemplate;

import org.muzhe.test.restTemplate.bean.Customer;
import org.muzhe.test.restTemplate.bean.MessageWrapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author muzhe-wang on  18-10-16 下午6:23.
 */
public class RestTemplateTest {

    public static void main(String[] args) {
        String url = "http://localhost:9099/customer-client/{id}";

        //        Customer customer = restTemplate.exchange(
//                "http://customer-service/customer/{id}",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<Customer>() {
//                },
//                id).getBody();

        RestTemplate restTemplate = new RestTemplate();
        MessageWrapper body = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<MessageWrapper>() {
                }, 12
        ).getBody();
        System.out.println(body);

    }
}
