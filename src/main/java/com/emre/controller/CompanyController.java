package com.emre.controller;

import com.emre.dto.request.SaveCompanyRequestDto;
import com.emre.dto.request.UpdateCompanyRequestDto;
import com.emre.entity.Company;
import com.emre.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.emre.constants.EndPointList.*;

@RestController
@RequestMapping(COMPANY)
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping(SAVE)
    public ResponseEntity<Company> save(@RequestBody @Valid SaveCompanyRequestDto dto){
        return ResponseEntity.ok(companyService.save(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Company>> findAll(){
        return ResponseEntity.ok(companyService.findAll());
    }
    @DeleteMapping(DELETE_BY_ID+"/{companyId}")
    public ResponseEntity<Boolean> delete(@PathVariable Long companyId){
        return ResponseEntity.ok(companyService.delete(companyId));
    }
    @PutMapping(UPDATE+"/{companyId}")
    public ResponseEntity<Boolean> update(@PathVariable Long companyId, @RequestBody @Valid UpdateCompanyRequestDto dto){
        return ResponseEntity.ok(companyService.update(companyId,dto));
    }
}
