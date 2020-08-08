import java.sql.*;
import java.io.*;

class DbSearch {
    public static void main(String args[]) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("�^�C�g������͂��ĉ�����");
            String str = br.readLine();

            // 1.�R�l�N�V����
            Connection con = DbConnect.getConnection();
            // 2.�X�e�[�g�����g�I�u�W�F�N�g�쐬
            Statement stmt = con.createStatement();

            //SQL��
            String mySql = "SELECT title,date, 'YahooJapan' AS site_name FROM test_news1 WHERE title LIKE " + "'%" + str + "%' ORDER BY date DESC LIMIT 50";
            
            // 3.���U���g�Z�b�g�iSQL�����s�j
	    	// executeQuery()���\�b�h
	    	// ���̃��\�b�h��SELECT���𑗂�ƁA�f�[�^�x�[�X�������������ʂ̓��������U���g�Z�b�g�Ƃ����I�u�W�F�N�g���A���Ă���B
            ResultSet rs = stmt.executeQuery(mySql);

            System.out.println("date" +"\t\t\tsite"+"\t\t"+ "title");
            System.out.println("------------------------------------------");

            // ���U���g�Z�b�g����f�[�^�擾
            while (rs.next()) {
                String date = rs.getString("date");
                String title = rs.getString("title");
                String siteName = rs.getString("site_name");
                System.out.print(date + "\t");
                System.out.print(siteName + "\t");
                System.out.println(title + "\t");
            }

            System.out.println("------------------------------------------");

            // ���\�[�X���
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("�G���[�ł��F" + e );
        }
    }
}
