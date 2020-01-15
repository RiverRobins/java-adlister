//import java.io.InputStream;
//import java.io.Reader;
//import java.math.BigDecimal;
//import java.net.URL;
//import java.sql.*;
//import java.sql.Date;
//import java.util.*;
//import java.util.logging.Logger;
//import com.mysql.jdbc.Driver;
//
//public class MySQLAdsDao implements Ads {
//    private Connection connection;
//
//    MySQLAdsDao(){}
//
//    MySQLAdsDao(Config n) throws SQLException {
////        DriverManager.registerDriver(new Driver() {
////            @Override
////            public Connection connect(String url, Properties info) throws SQLException {
////                return null;
////            }
////
////            @Override
////            public boolean acceptsURL(String url) throws SQLException {
////                return false;
////            }
////
////            @Override
////            public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
////                return new DriverPropertyInfo[0];
////            }
////
////            @Override
////            public int getMajorVersion() {
////                return 0;
////            }
////
////            @Override
////            public int getMinorVersion() {
////                return 0;
////            }
////
////            @Override
////            public boolean jdbcCompliant() {
////                return false;
////            }
////
////            @Override
////            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
////                return null;
////            }
////        });
////        this.connection = DriverManager.getConnection(
////                n.getURL(), //"jdbc:mysql://localhost/movies_db?serverTimezone=UTC&useSSL=false",
////                n.getUser(),
////                n.getPassword()
////        );
//        try {
//            Config c = new Config();
//            DriverManager.registerDriver(new Driver());
//            this.connection = DriverManager.getConnection(
//                    c.getURL(),
//                    c.getUser(),
//                    c.getPassword()
//            );
//        } catch (Exception e){
//            e.printStackTrace();
//
//
//        }
//    }
//
//    @Override
//    public List<Ad> all() throws SQLException {
//        Statement stmt = (Statement) this.connection;
//        ResultSet r = stmt.executeQuery("SELECT * FROM ads");
//
//        List<Ad> temp = new ArrayList<Ad>();
//
//        while (r.next()){
//            temp.add(new Ad(r.getLong("user_id"), r.getString("title"), r.getString("description")));
//        }
//        return temp;
//    }
//
//    @Override
//    public Long insert(Ad ad) throws SQLException {
//        String sql = "INSERT INTO ads (user_id, title, description) VALUES (" + ad.getUserId() + ",'" + ad.getTitle() +"','" + ad.getDescription() + "')";; //String.format("INSERT INTO ads(user_id, title, description) VALUES (%s, %s, %s)", ad.getUserId(), ad.getTitle(), ad.getDescription());
//        Statement stmt = connection.createStatement();
//        stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
//        ResultSet r = stmt.getGeneratedKeys();
//        return r.getLong(1);
//    }
//
//    public static void main(String[] args) throws SQLException {
//        Ads adsDoa = new MySQLAdsDao();
//        Ad testAd = new Ad(1, "title", "desc");
//        adsDoa.insert(testAd);
//        List<Ad> ads = adsDoa.all();
//        for (Ad n : ads){
//            System.out.println(n.getId());
//        }
//    }
//}


import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MySQLAdsDao implements Ads {
    private Connection connection;
    //    Statement statement = connection.createStatement();
    public MySQLAdsDao() throws SQLException {
        try {
            Config config = new Config();
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    config.getURL(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Ad> all() {
        List<Ad> output = new ArrayList<>();
        String query = "Select * FROM ads";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                output.add(
                        new Ad(
                                rs.getLong("id"), // id
                                rs.getLong("user_id"),// user id
                                rs.getString("title"),// ad title
                                rs.getString("description")// ad description
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }
    @Override
    public Long insert(Ad newAd) throws SQLException {
//setting up models.Ad object
//        inserting new models.Ad object into query string
//        String insertQuery = String.format("INSERT INTO ads (user_id, title, description) VALUES (%d, '%s', %s')",
//                newAd.getUserId(),
//                newAd.getTitle(),
//                newAd.getDescription()
//        );
        String insertQuery = "INSERT INTO ads (user_id, title, description) VALUES (" + newAd.getUserId() + ",'" + newAd.getTitle() +"','" + newAd.getDescription() + "')";
//        attempts to execute query string to add
        Statement statement = connection.createStatement();
        statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            System.out.println("Inserted id is: " + rs.getLong(1));
        }
        return rs.getLong(1);
    }
    public static void main(String[] args) throws SQLException {

        Ads adsDao = new MySQLAdsDao();
        Ad testAd = new Ad(
                1,
                "test title",
                "test description"
        );
        adsDao.insert(testAd);
        List<Ad> ads = adsDao.all();
        for (Ad ad : ads) {
            System.out.println(ad);
        }

    }
}