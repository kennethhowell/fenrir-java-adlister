import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class CodeRunner {

    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new Driver()); //Hey - I want to set up a NEW DRIVER. Watch that import space above and make sure you import the right Driver clas

        //Okay: now I need to make a connection object representing WHERE the server is and WHOAMI trying to log in
//        Connection localConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codeup_test_db?allowPublicKeyRetrieval=true&useSSL=false", "root", "codeup");

        //End of lecture refactor: Let's use our config classes to set up the connection
        Config configObj = new Config();
        Connection localConnection = DriverManager.getConnection(
                configObj.getUrl(),
                configObj.getUser(),
                configObj.getPassword()
        );

        //Now a connection object can return a statement object for us to utilize:

       Statement myStatement = localConnection.createStatement();
//        System.out.println("Result of executing delete statement: did it delete?");
//        System.out.println(myStatement.execute("DELETE FROM quotes WHERE id = 5"));

//        System.out.println("Insert a new quote into the quotes table");
//        myStatement.executeUpdate( "INSERT INTO quotes (content, author_id) VALUES ('JDBC makes me feel uneasy', 2)");

//        "SELECT * from authors"
        //Set up a resultset object to 'catch' what comes back
        //Execute a query with our specific query that we want
        //Then we need to loop through ALL results that came back in our resultset object (one by one, row by row)

        ResultSet allAuthors = myStatement.executeQuery("SELECT * FROM authors");

        //Now: "While it is true that there is something next in my results. . do some stuff"
//        while(allAuthors.next()){
//            System.out.println("Do some stuff"); //In this first example, it did stuff three times
//        }
//
//        while(allAuthors.next()){
//            System.out.println(allAuthors.getString("id"));
//            System.out.println(allAuthors.getString("first_name"));
//            System.out.println(allAuthors.getString("last_name"));
//            System.out.println("~~~");
//
//
//        }

        //Example of adding nelly furtado to our authors table
        //"INSERT INTO authors (first_name, last_name) VALUES ('Nelly', 'Furtado');

        myStatement.executeUpdate("INSERT INTO authors (first_name, last_name) VALUES ('Nelly', 'Furtado')", Statement.RETURN_GENERATED_KEYS);

        //Grab the results of the keys that were generated (hypothesis: we added on record, we should see one new primary key)

        ResultSet rs = myStatement.getGeneratedKeys();
        if (rs.next()) {
            System.out.println("Inserted a new record! New id: " + rs.getLong(1));
        }



    }
}
