import java.sql.*;
import java.io.*;

class DbSearch {
    public static void main(String args[]) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("タイトルを入力して下さい");
            String str = br.readLine();

            // 1.コネクション
            Connection con = DbConnect.getConnection();
            // 2.ステートメントオブジェクト作成
            Statement stmt = con.createStatement();

            //SQL文
            String mySql = "SELECT title,date, 'Yahoo Japan' AS site_name FROM test_news1 WHERE title LIKE " + "'%" + str + "%' UNION ALL SELECT title,date, 'NHK News' AS site_name FROM test_news2 WHERE title LIKE " + "'%" + str + "%' ORDER BY date DESC LIMIT 50";
            
            // 3.リザルトセット（SQL文実行）
	    	// executeQuery()メソッド
	    	// このメソッドでSELECT文を送ると、データベースを検索した結果の入ったリザルトセットというオブジェクトが帰ってくる。
            ResultSet rs = stmt.executeQuery(mySql);

	    System.out.println();
            System.out.println("date" +"\t\t\tsite"+"\t\t"+ "title");
            System.out.println("------------------------------------------");

            // リザルトセットからデータ取得
            while (rs.next()) {
                String date = rs.getString("date");
                String title = rs.getString("title");
                String siteName = rs.getString("site_name");
                System.out.print(date + "\t");
                System.out.print(siteName + "\t");
                System.out.println(title + "\t");
            }

            System.out.println("------------------------------------------");

            // リソース解放
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("エラーです：" + e );
        }
    }
}
