package com.xin.message.service;

import com.xin.message.model.AlertNotification;
import com.xin.message.model.Notification;
import com.xin.message.model.Tour;

public interface FleetDashboardMessageService {
	
	void broadcastMessage(Tour tour);
	
	void broadcastAlertMessage(AlertNotification alertNotifiaction);
	
	void sendNotification(Notification notification);
}
