package com.example.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.example.helper.*;
import com.example.service.FileUploadService;
@RestController
public class FileUploadController {

	@Autowired
	private fileUploadHelper fileUploadHelper;
	
	@Autowired
	public FileUploadService fileUploadService;
	@GetMapping("/hello")
	public String hello(){
		//return new ResponseEntity<String>("HELLO",HttpStatus.OK);
	return "index";
	}

	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam(value="file") MultipartFile file){
	
	   System.out.println(file.getContentType());
	   System.out.println(file.getName());
	   System.out.println(file.getOriginalFilename());
	   System.out.println(file.getResource());
	
	try {
		
		if(file.isEmpty()) {
			return new ResponseEntity<String>("Must contain file",HttpStatus.INTERNAL_SERVER_ERROR);
         }
		
		if(!file.getContentType().equals("application/json")) {
			return new ResponseEntity<String>("Only Txt file allowed",HttpStatus.INTERNAL_SERVER_ERROR);
         }
		
		boolean f=fileUploadHelper.uploadFile(file);
		if(f) {
			FileReader reader=new FileReader(fileUploadHelper.getPath().toString()); 
			BufferedReader b=new BufferedReader(reader);
			while(b.ready()) {
				String str=b.readLine();
				System.out.println(str);
				if(str.contains("[")) {
					 List<String> tokens = new ArrayList();
					  StringTokenizer st1 = new StringTokenizer(str,"\"\"");
					  while (st1.hasMoreTokens()) {
                            tokens.add(st1.nextToken());
				            System.out.println(tokens.get(0));
				            fileUploadHelper.setRootJson(tokens.get(0));
				           
					  }
						
					break;
				}
			}
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/").path(file.getOriginalFilename()).toUriString());
			
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		
		
		return new ResponseEntity<String>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/getLine")
	public ResponseEntity<List<String>> getLine(@RequestParam String key,String value) throws IOException{
		
		List<String> str=fileUploadService.getLine(key, value);
		System.out.println(str);
		return new ResponseEntity<List<String>>(str,HttpStatus.OK);
	}
	
	@GetMapping("/getJson")
	public ResponseEntity<List<String>> getJson(@RequestParam String key,String value) throws IOException, ParseException{
		
		List<String> str=fileUploadService.getJsonObject(key, value);
		System.out.println(str);
		return new ResponseEntity<List<String>>(str,HttpStatus.OK);
	}
	
	@GetMapping("/getJsonTwo")
	public ResponseEntity<List<String>> getJson2(@RequestParam String key,String value,String key1,String value1) throws IOException, ParseException{
		
		List<String> str=fileUploadService.getJsonObject2(key, value, key1, value1);
		System.out.println(str);
		return new ResponseEntity<List<String>>(str,HttpStatus.OK);
	}
	
	@GetMapping("/getJsonThree")
	public ResponseEntity<List<String>> getJson23(@RequestParam String key,String value,String key1,String value1,String key2,String value2) throws IOException, ParseException{
		
		List<String> str=fileUploadService.getJsonObject3(key, value, key1, value1, key2, value2);
		System.out.println(str);
		return new ResponseEntity<List<String>>(str,HttpStatus.OK);
	}
	
	
}
