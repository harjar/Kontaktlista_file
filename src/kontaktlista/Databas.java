package kontaktlista;

import java.sql.*;

/**
 *
 * @author jha
 */
public class Databas {

    private Connection conn = null;

    /**
     * Constructor for database class. This class handels databse connection ond
     * querys
     *
     */
    public Databas() {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "kontakt";
        String userName = "kontakt";
        String password = "kontakt";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url + dbName, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception ");
            /*} catch (SQLException e) {
            System.out.println(e.getMessage() + " APA4 " + e.getSQLState());
            if (conn == null) {
                System.out.println("Ingen anslutning");
            }*/
 /* } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage() + " APA5 ");*/
        }
    }

    /**
     * Inserting a new dog in tha database
     *
     * @param kon is the new contact object to be inserted to the databse.
     * @return non zero value on succsessfull insert, zero value on none
     * succsessful, insert.
     */
    public int insert(Kontakt kon) {
        int res = 0;
        if (connected()) {
            try {
                String sql = "insert into kontakt(firstname, lastname, phonenumber)"
                        + " VALUES (?, ?, ?)";
                PreparedStatement stmt
                        = conn.prepareStatement(sql);

                // Set Parameters
                stmt.setString(1, kon.getFörnamn());
                stmt.setString(2, kon.getEfternamn());
                stmt.setString(3, kon.getTelefon());

                // Execute SQL query
                res = stmt.executeUpdate();
                System.out.println(res + " record inserted");
            } catch (SQLException e) {
                System.out.println(e.getMessage() + " APA6");
            }
        }
        return res;
    }

    /**
     * Metod for retriveing all the records in the database orderd by firstname
     *
     * @return ResultSet object whith all records orders by id
     */
    public ResultSet getAllFirstName() {
        ResultSet rs = null;
        if (connected()) {
            try {
                Statement stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM kontakt order by firstname");
            } catch (SQLException e) {
                System.out.println(e.getMessage() + " APA1");
            }
        }
        return rs;
    }

    /**
     * Metod for retriveing all the records in the database
     *
     * @return ResultSet object whith all records orders by id
     */
    public ResultSet getAllLastName() {
        ResultSet rs = null;
        if (connected()) {
            try {
                Statement stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM kontakt order by lastname");
            } catch (SQLException e) {
                System.out.println(e.getMessage() + " APA1");
            }
        }
        return rs;
    }

    /**
     * Method for updating a contact in the datebase by it´s id number.
     *
     * @param kon object to be updated in the database
     */
    public void udateRow(Kontakt kon) {
        int res = 0;
        try {
            String sql = "update kontakt set firstname = ?, lastname = ?, phonenumber = ? where kon_id= ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Set Parameters
            stmt.setString(1, kon.getFörnamn());
            stmt.setString(2, kon.getEfternamn());
            stmt.setString(3, kon.getTelefon());
            stmt.setInt(4, kon.getId());

            // Execute SQL query
            res = stmt.executeUpdate();
            System.out.println(res + " records updated");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " APA6");
        }

    }

    /**
     *
     */
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " APA7");
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public ResultSet getPostById(int id) {

        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM hund where hundid = " + id);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " APA2");
        }
        return rs;
    }

    /**
     *
     * @param id
     */
    public String deletePost(int id) {
        if (connected()) {
            try {
                String sql = "delete FROM kontakt where kon_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);

                // Set Parameters
                stmt.setInt(1, id);

                // Execute SQL query
                int res = stmt.executeUpdate();

                if (res == 1) {
                    System.out.println("Kontakten med id: " + id + " är borttagen.");
                    return "Kontakten med id: " + id + " är borttagen.";
                } else {
                    System.out.println("Kontakten med id: " + id + " finns ej.");
                    return "Kontakten med id: " + id + " finns ej.";
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage() + " APA3");
            }
        }
        return "Ingen anslutning";
    }

    /**
     *
     * @return
     */
    public boolean connected() {
        try {
            if (conn != null && !conn.isClosed()) {
                // Running a simple validation query
                /*    PreparedStatement stmt = conn.prepareStatement("SELECT kon_id from hund limit 1");
                stmt.executeQuery();
                //System.out.println("anslutning: " + (conn != null));*/
                return true;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Databas.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Anslutningen är nere");
        }
        return false;
    }

}
