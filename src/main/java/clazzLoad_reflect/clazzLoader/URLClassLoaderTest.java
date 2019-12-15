package clazzLoad_reflect.clazzLoader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ClassName: URLClassLoaderTest
 * Description: 测试URLClassLoaderTest
 * 功能：从文件系统中加载MySQL驱动
 * date: 2019/12/15 12:30
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class URLClassLoaderTest {
    private static Connection connection;

    /**
     * 得到数据库连接的方法
     * @param url
     * @param user
     * @param pass
     * @return
     */
    public static Connection getConnection(String url, String user, String pass) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        if (connection == null) {
            // 新建一个URL数组，这个jar包在我本地是存在的，如果以http:为前缀，则表明从网上加载，还有ftp等..
            URL[] urls = {new URL("file:F:\\temp\\mysql-connector-java-8.0.15.jar")};
            // 创建URLClassLoader
            URLClassLoader jykClassLoader = new URLClassLoader(urls);
            // 加载MySQL的驱动，新版本的要用带cj的
            Driver driver = (Driver) jykClassLoader.loadClass("com.mysql.cj.jdbc.Driver").newInstance();
            // 设置连接属性
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", pass);
            // 取得数据库连接
            connection = driver.connect(url, props);
        }
        return connection;
    }

    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException, InstantiationException, SQLException, IllegalAccessException {
        // 这里要加上时区，否则会报错
        System.out.println(getConnection("jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC", "jyk", "jykqwe123"));
    }
}

