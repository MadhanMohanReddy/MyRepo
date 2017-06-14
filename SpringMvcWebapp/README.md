Steps to run the application
	1. clean build the project using maven.
		mvn clean install
	2. And then running maven tomcat7:run goal which will download the dependencies and trigger the tomcat7-maven-plugin.
		mvn tomcat7:run

		
tomcat7-maven-plugin		
	Maven has a wonderful plugin tomcat7-maven-plugin that we can use to embed tomcat within our Java web application. 
	The idea is to create standalone web project that can start tomcat server and run on its own. 
	All we need to do is the add following maven plugin in your pom.xml plugins list.
	
		<plugin>
			<groupId>org.apache.tomcat.maven</groupId>
			<artifactId>tomcat7-maven-plugin</artifactId>
			<version>2.2</version>
		</plugin>
		
	Change the Port number
		By default the embedded tomcat will try to initialize at port 8080. 
		We can change this by passing port number in configuration.
		
			<plugin>
				<groupId>org.apache.tomcat.maven</groupId>
				<artifactId>tomcat7-maven-plugin</artifactId>
				<version>2.2</version>
				<configuration>
					<port>9090</port>
				</configuration>
			</plugin>
			
	Using different context path
		Also, by default the web context for the application will be our maven projects artifact id. 
		We can change the path or web context by setting new path in configuration.
		
			<plugin>
				<groupId>org.apache.tomcat.maven</groupId>
				<artifactId>tomcat7-maven-plugin</artifactId>
				<version>2.2</version>
				<configuration>
					<port>9090</port>
					<path>/</path>
				</configuration>
			</plugin>

	Create war file		
		Tomcat skips non war project and also it asks for webxml. 
		
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-war-plugin</artifactId>
				<version>2.4</version>
				<configuration>
					<warSourceDirectory>src/main/webapp</warSourceDirectory>
					<warName>helloworld</warName>
					<failOnMissingWebXml>false</failOnMissingWebXml>
				</configuration>
			</plugin>
		
	Now run the above commands.	
			

Required items
	Spring 4
	Servlet api
	
	WebInitializer which extends dispatcher servlet and also contains servlet configs & servlet mappings
	
	MyApp(servlet config) which extends WebMvcConfigurerAdapter and also contains 
		@EnableWebMvc //mvc:annotation-driven
		@Configuration
		@ComponentScan({"org.mine"})
	
	
	

			
Reference Links
	http://viralpatel.net/blogs/spring-4-mvc-rest-example-json/
	http://viralpatel.net/blogs/embed-tomcat-maven-project-run-tomcat-maven/