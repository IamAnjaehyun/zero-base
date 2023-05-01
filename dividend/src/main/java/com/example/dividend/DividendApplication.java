package com.example.dividend;

import com.example.dividend.scrapper.Scrapper;
import com.example.dividend.scrapper.YahooFinanceScraper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DividendApplication {
    public static void main(String[] args) {
//        SpringApplication.run(DividendApplication.class, args);

        Scrapper scrapper = new YahooFinanceScraper(); //인터페이스 사용
//        var result = scrapper.scrap(Company.builder().ticker("O").build());
        var result = scrapper.scrapCompanyByTicker("MMM");
        System.out.println(result);
    }
}
