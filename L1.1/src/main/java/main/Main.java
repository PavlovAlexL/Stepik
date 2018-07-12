package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestsServlet;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();   //


        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);   //Создание Servlet контейнера, передаем туда то что должно обрабатывать запросы клиента
        context.addServlet(new ServletHolder(allRequestsServlet), "/mirror");  //allRequestsServlet - этот обработчик должен обрабатывать запрос документа auform (http://localhost:8080/auform)

        Server server = new Server(8080);  //Создаем объект jetty сервера и говорим работать на порту 80080
        server.setHandler(context);


        server.start();

        //java.util.logging.Logger.getGlobal().info("Server started");
        System.out.println("Server startedd!");
        server.join();
    }
}
