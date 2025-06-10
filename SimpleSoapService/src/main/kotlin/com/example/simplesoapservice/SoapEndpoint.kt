package com.example.simplesoapservice

import org.springframework.stereotype.Controller
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/soap-endpoint")
class SoapEndpoint {
    @GetMapping
  @ResponseBody
    fun handleGetrequest():String{
        return "This is a Get request from Kapil"
    }
    @PostMapping
    @ResponseBody
    fun handelSoapRequest(@RequestBody soapRequest:String): String{
        return "Response to SOAP request: $soapRequest"
    }
}