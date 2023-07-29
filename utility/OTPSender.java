/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sanjeevaniapp.utility;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;

/**
 *
 * @author sharm
 */
public class OTPSender implements Sender {

   
          //  String url = "https://2factor.in/API/V1/093b4edc-a9e1-11ed-813b-0200cd936042/SMS/"+mobNo+"/"+otp+"/OTP1";
           @Override
    public boolean send(String number,String data)throws UnirestException{
           Unirest.setTimeouts(0,0);
           String mobNo=number;
           System.out.println(mobNo);
           int otp=Integer.parseInt(data);
           System.out.println("otp is-"+otp);
           String url="https://2factor.in/API/V1/ff6dd695-abb3-11ed-813b-0200cd936042/SMS/"+mobNo+"/"+otp+"/OTP1";
           GetRequest gr=Unirest.get(url);
           HttpResponse<String>response=gr.asString();
           String result=response.getBody();
           System.out.println("result-"+result);
           return result.contains("Success");
    }
    }
