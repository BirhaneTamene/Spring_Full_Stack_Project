/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.mum.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import edu.mum.domain.Order;
import edu.mum.integration.transformer.OrderTransformerImpl;

 
@Component
public class Main {

	private final static String[] configFilesGatewayDemo = {
		"/META-INF/spring/integration/common.xml",
 		"/META-INF/spring/integration/order-eai.xml",
		"/META-INF/spring/integration/amqp-order-app-context.xml",
		"/META-INF/spring/integration/jms-order-app-context.xml"
	};

 
	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);

//	    RouteOrderGateway orderGateway;


		System.out.println("\n========================================================="
				+ "\n                                                         "
				+ "\n    Welcome to the Online Book Order!                    "
				+ "\n                                                         "
				+ "\n=========================================================" );
 
 				System.out.println("    Loading Demo...");
 				
// 				Order order = new Order();
// 				order.setId((long) 10);
// 				
// 				OrderTransformerImpl otfi = new OrderTransformerImpl();
// 				otfi.transformOrder(order);
 				
 				
				ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configFilesGatewayDemo, Main.class);

			    applicationContext.getBean(Main.class).mainInternal(applicationContext);
	  }
	
	    private void mainInternal(ApplicationContext applicationContext) {
				// Wait for Messages
	    }

}
