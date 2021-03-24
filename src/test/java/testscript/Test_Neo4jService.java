/*
 * @FileName Test_Neo4jService: Test Scripts of Neo4j Graph Database
 * @outhor davieyang
 * @create 2018-08-21 16:37
 */
package testscript;

import org.testng.annotations.Test;
import static util.paas.Neo4jVerification.neo4j;

public class Test_Neo4jService {
    @Test
    public void test_neo4j(){
        for(int i = 1; i<10000;i++){
            neo4j("bolt://210.13.50.105:31705/","neo4j","neo4j03");
            //createDB("bolt://127.0.0.1:7687/","admin","admin");
        }
    }
}
