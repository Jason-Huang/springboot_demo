package cn.jason.demo.controller;

import cn.jason.demo.administrativeDivision.DicCountryInfoScan;
import cn.jason.demo.dao.DicCountryInfoScanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "county")
public class DicCountryInfoScanController {
    @Autowired
    DicCountryInfoScanRepository dicCountryInfoScanRepository;

    @RequestMapping("getDicCountryInfoScan")
    public List<DicCountryInfoScan> getDicCountryInfoScan(){
        return dicCountryInfoScanRepository.findAll();
    }

}
