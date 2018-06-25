public class Main {
    public static void main( String... args ) throws Exception
    {
        try ( Neo4jClient greeter = new Neo4jClient( "bolt://localhost:7687", "neo4j", "admin" ) )
        {
            greeter.printGreeting( "hello, world" );
        }
    }
}
