package com.example.controllers;

import javax.servlet.annotation.WebServlet;

import com.example.controllers.AIWebhookServlet.AIWebhookRequest;

import ai.api.model.Fulfillment;

@WebServlet("/webhook")
public class MyWebhookServlet extends AIWebhookServlet {
	@Override
	protected void doWebhook(AIWebhookRequest input, Fulfillment output) {
		output.setDisplayText("You said: " + input.getResult().getFulfillment().getDisplayText());
		System.out.println("-----------------You said:---------------------" + input.getResult().getFulfillment().getDisplayText());
	}
}