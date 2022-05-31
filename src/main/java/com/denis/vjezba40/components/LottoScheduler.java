package com.denis.vjezba40.components;

import com.denis.vjezba40.services.LottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
//@EnableScheduling
//@EnableCaching
public class LottoScheduler {
    @Autowired private LottoService lottoService;

    //@Scheduled(fixedDelay = 10_000)
    public void getEurojackpotNumbers() {
        System.out.println(lottoService.getEurojackpotNumbers());
    }

    //@Scheduled(fixedDelay = 60_000)
    public void cleanCacheEurojackpotNum() {
        lottoService.cleanEurojackpotCache();
    }
}
