package com.sap.fd.message.service;

import com.sap.fd.message.model.AlertNotification;
import com.sap.fd.message.model.Notification;
import com.sap.fd.message.model.Tour;

public interface FleetDashboardMessageService {
	
	void broadcastMessage(Tour tour);
	
	void broadcastAlertMessage(AlertNotification alertNotifiaction);
	
	void sendNotification(Notification notification);
}
