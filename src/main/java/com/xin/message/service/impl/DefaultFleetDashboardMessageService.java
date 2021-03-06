 package com.xin.message.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.xin.message.model.AlertNotification;
import com.xin.message.model.Notification;
import com.xin.message.model.Tour;
import com.xin.message.service.FleetDashboardMessageService;

@Service
public class DefaultFleetDashboardMessageService implements FleetDashboardMessageService{

	@Autowired
	private SimpMessagingTemplate messaging;
	
	@Override
	public void broadcastMessage(Tour tour) {
		messaging.convertAndSend("/topic/tourFeed", tour);
	}

	@Override
	public void broadcastAlertMessage(AlertNotification alertNotifiaction) {
		messaging.convertAndSend("/topic/messageAlert",alertNotifiaction);
	}

	@Override
	public void sendNotification(Notification notification) {
		messaging.convertAndSendToUser(notification.getToUser(), "/queue/notifications", notification);
		messaging.convertAndSendToUser(notification.getFromUser(), "/queue/notifications", notification);
	}
}
