package com.example.dividend.scheduler;

import com.example.dividend.model.Company;
import com.example.dividend.model.ScrapedResult;
import com.example.dividend.persist.entity.CompanyEntity;
import com.example.dividend.persist.entity.DividendEntity;
import com.example.dividend.persist.repository.CompanyRepository;
import com.example.dividend.persist.repository.DividendRepository;
import com.example.dividend.scraper.Scraper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
//자동화 이유 -> 만약 새로운 배당 정보가 생겼을 때 새로 갱신
@Component
@AllArgsConstructor
public class ScraperScheduler {
//    @Scheduled(cron = "0/5 * * * * *") //5초마다 시간 찍는 testScheduler
//    public void test() {
//        System.out.println("now -> " + Thread.currentThread().getName() + " : " + System.currentTimeMillis());
//    }

    private final CompanyRepository companyRepository;
    private final DividendRepository dividendRepository;
    private final Scraper yahooFinanceScraper;

//    @Scheduled(fixedDelay = 1000)
//    public void test1() throws InterruptedException{
//        Thread.sleep(10000); //10초간 일시 정지
//        System.out.println(Thread.currentThread().getName() + " 테스트 1 : " + LocalDateTime.now());
//    }
//
//    @Scheduled(fixedDelay = 1000)
//    public void test2() throws InterruptedException{
//        System.out.println(Thread.currentThread().getName() + " 테스트 2 : " + LocalDateTime.now());
//    }

    //일정 주기마다 반복 시분일월요일 순서
    @Scheduled(cron = "${scheduler.scrap.yahoo}")
    public void yahooFinanceScheduling() {
        log.info("scraping scheduler is started");
        //저장된 회사 목록을 조회
        List<CompanyEntity> companies = this.companyRepository.findAll();

        //회사마다 배당금 정보를 새로 스크래핑
        for (var company : companies) {
            log.info("scraping scheduler is started -> " + company.getName());
            ScrapedResult scrapedResult = this.yahooFinanceScraper.scrap(new Company(company.getTicker(), company.getName()));

            //스크래핑한 배당금 정보 중 데이터베이스에 없는 값은 저장
            scrapedResult.getDividends().stream()
                    //디비든 모델을 디비든 엔티티로 매핑
                    .map(e -> new DividendEntity(company.getId(), e))
                    //엘리멘트를 하나씩 디비든 레파지토리에 삽입
                    .forEach(e -> {
                        boolean exists = this.dividendRepository.existsByCompanyIdAndDate(e.getCompanyId(), e.getDate());
                        if (!exists) {
                            this.dividendRepository.save(e);
                        }
                    });
            //연속적으로 스크래핑 대상 사이트 서버에 요청을 날리지 않도록 일시 정지
            try {
                Thread.sleep(3000); //3 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
