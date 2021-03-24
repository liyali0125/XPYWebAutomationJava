/*
 * @FileName Neo4jVerification: To operate  Neo4j service
 * @outhor davieyang
 * @create 2018-08-20 11:29
 */
package util.paas;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.*;
import static org.neo4j.driver.v1.Values.parameters;

public class Neo4jVerification {
    public static void neo4j(String address, String username, String password){

        Driver driver = GraphDatabase.driver( address, AuthTokens.basic( username, password ) );
        Session session = driver.session();

        session.run( "CREATE (a:Person {name: {name}, title: {title}})",
                parameters( "name", "Arthur", "title", "King" ) );

        StatementResult result = session.run( "MATCH (a:Person) WHERE a.name = {name} " +
                        "RETURN a.name AS name, a.title AS title",
                parameters( "name", "Arthur" ) );
        while ( result.hasNext() )
        {
            Record record = result.next();
            System.out.println( record.get( "title" ).asString() + " " + record.get( "name" ).asString() );
        }

        session.close();
        driver.close();
    }
}

