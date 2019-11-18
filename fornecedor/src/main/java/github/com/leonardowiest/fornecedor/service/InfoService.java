package github.com.leonardowiest.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import github.com.leonardowiest.fornecedor.domain.InfoFornecedor;
import github.com.leonardowiest.fornecedor.repository.InfoRepository;

@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public InfoFornecedor getInfoPorUF(String uf) {

        return infoRepository.findByUf(uf);
    }

}
