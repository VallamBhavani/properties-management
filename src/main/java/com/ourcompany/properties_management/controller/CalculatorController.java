package com.ourcompany.properties_management.controller;

import com.ourcompany.properties_management.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {
    @GetMapping("/add")
    public Double add(@RequestParam("num111") Double num1, @RequestParam("num2") Double num2)
    {
        return  num1+num2;
    }
@GetMapping("/sub/{num11}/{num2}") //Map the values of url to java variables by path variable method
    public  Double substract(@PathVariable("num11") Double num1,@PathVariable("num2") Double num2)
    {
        Double result=null;
        if(num1>num2)
        {
            result = num1-num2;
        }
        else {
           result= num2-num1;
        }
        return result;
    }
    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO){
        Double res = null;
       res= calculatorDTO.getNum1()* calculatorDTO.getNum2()*calculatorDTO.getNum3()*calculatorDTO.getNum4();
        ResponseEntity<Double>  responseEntity= new ResponseEntity<>(res, HttpStatus.CREATED);
       return  responseEntity;
    }


}
