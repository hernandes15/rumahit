package com.rumahit.controller;

import java.util.Objects;
import java.util.stream.IntStream;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ControllerTestCode {

	@GetMapping(path = "/fibonaci/{input}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> fibonaci(@PathVariable int input) {
		try {

			int n1 = 1;
			int n2 = 1;
			int n3;

			int output[] = new int[input];
			String resp = "";

			for (int i = 0; i < input; i++) {

				if (i > 1) {
					n3 = n1 + n2;

					if (n3 % 2 != 0)
						output[i] = n3;
					else
						i = i - 1;

					n1 = n2;
					n2 = n3;
				}else {
					output[i] = n1;
				}
			}

			int[] outputReverse = IntStream.rangeClosed(1, output.length).map(a -> output[output.length - a]).toArray();
			
			for (int numb : outputReverse) {
				resp = resp + " " + numb;
			}
			
			return new ResponseEntity<>("{\"output\":\""+resp+"\"}", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping(path = "/irisanString/{input}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> irisan(@PathVariable String input) {
		try {

			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			String panjang = alphabet.length() > input.length() ? alphabet : input;
			String pendek = alphabet.length() < input.length() ? alphabet : input;
			
			int output = 0;
			int length = pendek.length();
			
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length - i; j++) {
					String obj1 = pendek.substring(i, length -j);
					String obj2 = pendek.substring(j, length);
					
					if(panjang.contains(obj1))
						output = obj1.length() > output ? obj1.length() : output;
						
						if(panjang.contains(obj2))
							output = obj2.length() > output ? obj2.length() : output;
				}
				
			}
			
			return new ResponseEntity<>("{\"output\":\""+output+"\"}", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
