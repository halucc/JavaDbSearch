import java.sql.*;

class DbConnect{
  static Connection getConnection() throws Exception {

    //JDBC�h���C�o�̃��[�h
    Class.forName("com.mysql.jdbc.Driver");
    
    //�ujdbc:mysql://localhost/[DB��]?�v
    //�uabc_db_test�v�Ƀf�[�^�x�[�X��������
    String url = "jdbc:mysql://localhost/abc_db_test?"
    + "useUnicode=true&characterEncoding=utf8&user=root&password=";
    
    // �O��DB�T�[�o�[�ɐڑ������
    // �u3306�v��MySQL�̏����|�[�g�ԍ��A�ύX�i�Z�L�����e�B�ʁj
    // String url = "jdbc:mysql://123.123.12.123:3306/test_db_test?" 
   
    //���[�U�[���@�p�X���[�h
    String user = "root";
    String pass = "";

    //�f�[�^�x�[�X�ɐڑ�
    Connection con = DriverManager.getConnection(url,user,pass);
    return con;
  }
}
