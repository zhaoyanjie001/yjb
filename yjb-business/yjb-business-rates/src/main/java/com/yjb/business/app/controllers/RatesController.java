package com.yjb.business.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjb.business.app.service.RatesService;

@RestController
@RequestMapping("/api/rates")
public class RatesController {

	@Autowired
	RatesService ratesService;

//	@GetMapping("/rateInfo")
//	public String getRatesInfo() {
//		return ratesService.getInitRates();
//	}
//	
//	@GetMapping("/getInitStart")
//	public void getInitStart() {
//		System.out.println("getInitStart");
//		ratesService.getInitStart();;
//	}
	@GetMapping("/getRates")
	public ResponseEntity<String> getRates() {
		System.out.println("getRates");
		HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type","application/json; charset=utf-8");
        return new ResponseEntity<>(ratesService.getRates(),httpHeaders, HttpStatus.OK);
	}

	@GetMapping("/getNews")
	public ResponseEntity<String> getNews() {
//		System.out.println("getNews");
//		return ratesService.getNews();

//		HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.APPLICATION_JSON);//  ratesService.getNews()
//	    HashMap<String, String> headers1 = new HashMap<String, String>();
//	    headers1.put("Content-Type", "application/json; charset=utf-8");
//	    MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;
//	    return ResponseEntity.ok().contentType(mediaType).body(ratesService.getNews());

		HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type","application/json; charset=utf-8");
        return new ResponseEntity<>(ratesService.getNews(),httpHeaders, HttpStatus.OK);
//        
//	    HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "application/json; charset=utf-8");
//        return ResponseEntity.ok()
//                             .headers(headers)
//                             .body("Headers set!");

	}
}
