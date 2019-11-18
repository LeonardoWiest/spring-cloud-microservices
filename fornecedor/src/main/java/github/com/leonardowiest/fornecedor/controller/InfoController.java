package github.com.leonardowiest.fornecedor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github.com.leonardowiest.fornecedor.service.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping("/{uf}")
    public void getInfoPorUF(String uf) {

        infoService.getInfoPorUF(uf);
    }

}
