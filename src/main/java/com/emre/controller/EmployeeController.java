package com.emre.controller;

import com.emre.dto.request.SaveEmployeeRequestDto;
import com.emre.dto.request.UpdateEmployeeRequestDto;
import com.emre.entity.Employee;
import com.emre.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.emre.constants.EndPointList.*;

@RestController
@RequestMapping(EMPLOYEE)
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody SaveEmployeeRequestDto dto){
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
    @PutMapping(UPDATE)
    public ResponseEntity<Boolean> update(@RequestBody UpdateEmployeeRequestDto dto){
        return ResponseEntity.ok(employeeService.update(dto));
    }

}
