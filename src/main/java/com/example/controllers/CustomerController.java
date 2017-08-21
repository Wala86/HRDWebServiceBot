package com.example.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.annotation.WebServlet;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import ai.api.model.ResponseMessage;
import javax.servlet.annotation.WebServlet;

import ai.api.model.Fulfillment;

@RestController
public class CustomerController {

	@RequestMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

	// @RequestMapping(value = "/webhook", method = RequestMethod.POST)
	// private Map<String,Object> webhook(@RequestParam("shipping-zone") String
	// shippingZone, @RequestParam("action") String action) throws JSONException {
	//
	//
	//
	// Map<String,Object> json = new HashMap<String,Object>();
	//
	// json.put("speech", " The cost of shipping to is 1000 euros.");
	// json.put("displayText", " The cost of shipping to is 1000 euros.");
	//
	// json.put( "source", "apiai-onlinestore-shipping");
	// System.out.println("*************
	// "+shippingZone+"******************"+action);
	// return json;
	//
	// }
	/*
	 * @RequestMapping(value = "/webhook", method = RequestMethod.POST)
	 * private @ResponseBody Map<String,Object> webhook(@RequestBody
	 * Map<String,Object> obj) throws JSONException {
	 * 
	 * 
	 * 
	 * Map<String,Object> json = new HashMap<String,Object>();
	 * System.out.println("************RequestBody*****************"+obj);
	 * 
	 * 
	 * 
	 * String Speech ="The cost of shipping to  is  for "+obj.get("result");
	 * json.put("speech", " The cost of shipping to  is  1000 euros.");
	 * json.put("displayText", " The cost of shipping to  is  1000 euros.");
	 * json.put( "source", "apiai-onlinestore-shipping");
	 * System.out.println("************* ******************"+obj.get("result"));
	 * 
	 * 
	 * 
	 * ResponseMessage speech = new ResponseMessage.Response();
	 * speech.setSpeech(Arrays.asList("speech 1", "speech 2"));
	 * 
	 * ResponseImage image = new ResponseMessage.ResponseImage();
	 * image.setImageUrl("url image");
	 * 
	 * ResponseQuickReply quickReply = new ResponseMessage.ResponseQuickReply();
	 * quickReply.setTitle("Quick title"); (...) Fulfillment full = new
	 * Fulfillment(); full.getMessages(new ArrayList<>());
	 * full.setSpeech("test speech"); full.getMessages().add(card);
	 * full.getMessages().add(image); full.getMessages().add(quickReply);
	 * full.getMessages().add(speech);
	 * 
	 * 
	 * 
	 * 
	 * return json;
	 * 
	 * }
	 */

	@WebServlet("/webhook")
	public class MyWebhookServlet extends AIWebhookServlet {
		@Override
		protected void doWebhook(AIWebhookRequest input, Fulfillment output) {
			output.setDisplayText("You said: " + input.getResult().getFulfillment().getDisplayText());
			System.out.println("-----------------You said:---------------------" + input.getResult().getFulfillment().getDisplayText());
		}
	}

}
