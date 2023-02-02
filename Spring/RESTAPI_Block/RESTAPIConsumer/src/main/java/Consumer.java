import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// Reqres


public class Consumer {
    public static void main(String[] args) {
        System.setProperty("https.proxyHost", "proxy.orb.ru");
        System.setProperty("https.proxyPort", "3128");

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", "Test name");
        jsonToSend.put("job", "Test job");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonToSend);
        String url = "https://reqres.in/api/users";
        String response = restTemplate.postForObject(url, request, String.class);


//        String url = "https://reqres.in/api/users/2";                     //
//        String response = restTemplate.getForObject(url, String.class);   // Получаем данные из сервиса

        System.out.println(response);
    }
}
