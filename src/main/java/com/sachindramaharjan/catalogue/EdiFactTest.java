package com.sachindramaharjan.catalogue;

import java.nio.charset.Charset;
import java.sql.*;
import java.util.Properties;

/**
 * Created by sachindra.maharjan on 4/17/16.
 */
public class EdiFactTest {

    public static void main(String[] args) {

        String sql = "select msg_tx from test where id =  1";

        String URL = "jdbc:oracle:thin:@192.168.56.101:1521:orcl";
        Properties info = new Properties( );
        info.put( "user", "INETDBA" );
        info.put( "password", "sachindra" );

        try{
            Connection conn = DriverManager.getConnection(URL, info);

            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(sql);
            StringBuilder stringBuilder = new StringBuilder();
            while (result.next()){
                byte[] bytes = result.getBytes(1);

                for (int i = 0; i < bytes.length; i++) {
                    stringBuilder.append((char)bytes[i]);
                }

               // System.out.println(stringBuilder.toString());

                String string = new String(bytes);
                System.out.println(string);
                System.out.println();

                string = string.replaceAll("'", "}");
                byte[] b = string.getBytes();
                System.out.println(b.length);
                System.out.println(new String(b));


            }

            conn.close();



        }catch (Exception ex){
            System.out.println(ex);
        }



    }

}
