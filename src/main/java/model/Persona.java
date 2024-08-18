package model;
/**
 *
 * @author hp
 */
public class Persona implements Comparable{
    
    public static final int NAME = 0;
    public static final int AGE = 1;    
    private static final int LESS = -1;
    private static final int EQUAL = 0;    
    private static final int MORE  = 1;    
    private static int compareAttribute= NAME;   
    private String  name;
    private int     age;
    private char    gender;
//    static {
//       compareAttribute = NAME;       
//    }
    public Persona() {
        this("No Ingresado", 0, 'U');
    }
    public Persona(String name, int age, char gender) {
        this.age    = age;
        this.name   = name;
        this.gender = gender;
    }        
      
    public void setAge( int age ) {
        this.age = age;
    }
    
    public void setGender( char gender ) {
        this.gender = gender;
    }    
    
    public void setName( String name ) {
        this.name = name;
    }
    
     public int getAge( ) {
        return age;
    }    
    
    public char getGender( ) {
        return gender;
    }    
    
    public String getName( ) {
        return name;
    }    
    
    public String toString( )  {
        return this.name    + "||" +
               this.age     + "||" +
               this.gender;
    }
//    public String toString1( )  {
//        return this.name    + "\t\t" +
//               this.age     + "\t\t" +
//               this.gender;
//    }
    public void setCompareAttribute( int attribute ) {
        compareAttribute = attribute;
    }    
    public int compareTo( Persona persona, int attribute ) {
        int comparisonResult;

        if ( attribute == AGE ) {
            int p2age = persona.getAge( );

            if (this.age < p2age)
                comparisonResult = LESS;
            else if (this.age == p2age)
                comparisonResult = EQUAL;
            else {
                assert this.age > p2age;
                comparisonResult = MORE;
            }

        } else { //compara el nombre usando el metodo compareTo de la clase String                
            String    p2name = persona.getName( );
            comparisonResult = this.name.compareTo(p2name);
        }

        return comparisonResult;
    }        
//    public int compareTo( Persona persona ) {
//        return compareTo(persona, compareAttribute);
//    }

    @Override
    public int compareTo(Object o) {
        return compareTo((Persona)o, compareAttribute);
    }
}