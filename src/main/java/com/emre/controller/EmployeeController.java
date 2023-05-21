package com.emre.controller;

import com.emre.dto.request.SaveEmployeeRequestDto;
import com.emre.dto.request.UpdateEmployeeRequestDto;
import com.emre.dto.response.UpdateEmployeeResponseDto;
import com.emre.entity.Employee;
import com.emre.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.emre.constants.EndPointList.*;

@RestController
@RequestMapping(EMPLOYEE)
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody @Valid SaveEmployeeRequestDto dto){
        return ResponseEntity.ok(employeeService.save(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeService.findAll());
    }
    @DeleteMapping(DELETE_BY_ID+"/{employeeId}")
    public ResponseEntity<Boolean> delete(@PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.delete(employeeId));
    }
    @PutMapping(UPDATE+"/{employeeId}")
    public ResponseEntity<UpdateEmployeeResponseDto> update(@PathVariable Long employeeId, @RequestBody @Valid UpdateEmployeeRequestDto dto){
        return ResponseEntity.ok(employeeService.update(employeeId,dto));
    }

}
