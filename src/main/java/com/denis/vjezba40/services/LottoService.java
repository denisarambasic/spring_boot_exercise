package com.denis.vjezba40.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LottoService {
    @Value("${eurojackpot.url}") private String eurojackpotUrl;
    @Value("${germany.lotto.url}") private String germanyLottoUrl;
    @Autowired private HttpClient client;

    @Cacheable("eurojackpot")
    public List<Integer> getEurojackpotNumbers() {
        System.out.println("Get numbers from service.");
        String cuttedPageSource = cutPageSource(eurojackpotUrl, "<ul class=\"results\">", "<script");
        List<Integer> numbers = getNumbersFromString(cuttedPageSource);
        return numbers;
    }

    @CacheEvict("eurojackpot")
    public void cleanEurojackpotCache() {
        System.out.println("Clean eurojackpot cache");
    }

    public List<Integer> getGermanyLottoNumbers() {
        String cuttedPageSource = cutPageSource(germanyLottoUrl, "<ul class=\"balls\">", "<div class=\"jackpot\">");
        List<Integer> numbers = getNumbersFromString(cuttedPageSource);
        return numbers;
    }

    private List<Integer> getNumbersFromString(String str) {

        String regex ="(\\d+)";
        Matcher matcher = Pattern.compile( regex ).matcher( str);
        List<Integer> numbers = new ArrayList<>();
        while (matcher.find( ))
        {
            numbers.add(Integer.parseInt(matcher.group()));
        }

        return numbers;
    }

    private String cutPageSource(String url, String startTag, String endTag) {
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        int startPosition   = response.body().indexOf(startTag);
        int endPosition     = response.body().indexOf(endTag);

        return response.body().substring(startPosition, endPosition);
    }
}
