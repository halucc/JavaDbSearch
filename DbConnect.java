import java.sql.*;

class DbConnect{
  static Connection getConnection() throws Exception {

    //JDBCドライバのロード
    Class.forName("com.mysql.jdbc.Driver");
    
    //「jdbc:mysql://localhost/[DB名]?」
    //「abc_db_test」にデータベース名を入れる
    String url = "jdbc:mysql://localhost/abc_db_test?"
    + "useUnicode=true&characterEncoding=utf8&user=root&password=";
    
    // 外部DBサーバーに接続する例
    // 「3306」はMySQLの初期ポート番号、変更可（セキュリティ面）
    // String url = "jdbc:mysql://123.123.12.123:3306/test_db_test?" 
   
    //ユーザー名　パスワード
    String user = "root";
    String pass = "";

    //データベースに接続
    Connection con = DriverManager.getConnection(url,user,pass);
    return con;
  }
}
