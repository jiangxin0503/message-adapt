package com.xin.message.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;

import com.xin.message.Interceptor.UserInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig extends AbstractWebSocketMessageBrokerConfigurer {
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/fleetdashboard").setAllowedOrigins("*").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/queue", "/topic");
		registry.setApplicationDestinationPrefixes("/app");
	}
	
    @SuppressWarnings("deprecation")
	@Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.setInterceptors(createUserInterceptor());
    }
    
    @Bean
    public UserInterceptor createUserInterceptor() {
        return new UserInterceptor();
    }
    
    @Override
    public void configureWebSocketTransport(final WebSocketTransportRegistration registration) {
      registration.addDecoratorFactory(new WebSocketHandlerDecoratorFactory() {
        @Override
        public WebSocketHandler decorate(final WebSocketHandler handler) {
          return new WebSocketHandlerDecorator(handler) {
            @Override
            public void afterConnectionEstablished(final WebSocketSession session) throws Exception {
              // 客户端与服务器端建立连接后，此处记录谁上线了
              String username = session.getPrincipal().getName();
              super.afterConnectionEstablished(session);
            }

            @Override
            public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
              // 客户端与服务器端断开连接后，此处记录谁下线了
              String username = session.getPrincipal().getName();
              super.afterConnectionClosed(session, closeStatus);
            }
          };
        }
      });
      super.configureWebSocketTransport(registration);
    }

}
