package com.example.springemployeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lombok Library
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO
{
    private String message;
    private Object data;
}