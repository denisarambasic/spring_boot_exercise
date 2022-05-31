package com.denis.vjezba40.controllers;

import com.denis.vjezba40.services.LottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/results")
public class LottoController {

    @Autowired private LottoService lottoService;

    @GetMapping("/eurojackpot")
    @ResponseStatus(HttpStatus.OK)
    public List<Integer> getEurojackpotNumbers() {
        return lottoService.getEurojackpotNumbers();
    }

    @GetMapping("/germanyLotto")
    @ResponseStatus(HttpStatus.OK)
    public List<Integer> getGermanyLottoNumbers() {
        return lottoService.getGermanyLottoNumbers();
    }
}
