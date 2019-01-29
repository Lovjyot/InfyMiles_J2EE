
import java.util.*;
import java.util.logging.*;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.ServletContextEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebListener
public class InfinityMilesListener implements ServletContextListener {	  

      public void contextInitialized(ServletContextEvent event) {
          // Call the method which takes items from product catalog and store it in database.
      }

      public void contextDestroyed(ServletContextEvent event) {

      }
}