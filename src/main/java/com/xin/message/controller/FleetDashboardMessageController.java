package com.xin.message.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xin.message.common.ServerResponse;
import com.xin.message.model.AlertNotification;
import com.xin.message.model.Notification;
import com.xin.message.model.Tour;
import com.xin.message.service.FleetDashboardMessageService;

@Controller("/message")
public class FleetDashboardMessageController {
	
	  private static final Logger logger = LoggerFactory
		      .getLogger(FleetDashboardMessageController.class);
	  
	  @Autowired
	  private FleetDashboardMessageService feedService;
	  
	  @PostMapping("/tourChanged")
	  @ResponseBody
	  public ServerResponse<Tour> tourChanged(Tour tour) {
		  this.feedService.broadcastMessage(tour);
		  return ServerResponse.createBySuccess("Tour changed message has been published", tour);
	  }
	  
	  @PostMapping("/pushAlertMsg")
	  @ResponseBody
	  public ServerResponse<AlertNotification> processAlertNotification(AlertNotification alertNotifiaction) {
		  feedService.broadcastAlertMessage(alertNotifiaction);
		  return ServerResponse.createBySuccess("Alert message has been published", alertNotifiaction);
	  }
	  
	  @PostMapping("/pushNotification")
	  @ResponseBody
	  public ServerResponse<Notification> processPushNotification(Notification notification) {
		  this.feedService.sendNotification(notification);
		  return ServerResponse.createBySuccess("notification has been pushlished to the user: " + notification.getToUser(), notification);
	  }
	  
}
