package Directorio;

import model.Persona;
import uni.aed.cc232a20224041gpc1.SortObject;
public class DirectorioV1 implements Directorio{
    private static final int  DEFAULT_SIZE = 25;
    private static final int  NOT_FOUND    = -1;
    private Persona[]   entry;
    private int        count;
    SortObject heap = new SortObject();
    
    Persona persona = heap(entry);
    
    public DirectorioV1( )
    {
        this( DEFAULT_SIZE );
    }

    public DirectorioV1( int size )
    {
        count = 0;
        if (size <= 0 ) { //valor invalido, usa default
            throw new IllegalArgumentException("Tamaño debe ser positivo");
        }
        entry = new Persona[size];   
        
    }
    
    @Override
    public String toString() {
        String result="";        
        for(Persona p: entry)
            if (p!=null)
                if (result.length()==0)
                    result=p.toString() ;
                else
                    result=result + ", " +p.toString() ;
        return result;
    }    
    
    public void add( Persona newPersona )
    {
        if (count == entry.length)
            enlarge( );        
        entry[count] = newPersona;
        count++;
    }

    public boolean delete( String searchName )
    {
        boolean    status;
        int        loc;
        loc = findIndex( searchName );
        if (loc == NOT_FOUND)
            status = false;        
        else {
            entry[loc] = entry[count-1];//coloca el valor de la ultima posicion en la posicion del valor eliminado
            status = true;
            count--;        
        }
        return status;
    }

    public Persona search( String searchName )//aplica metodo de busqueda lineal
    {
        Persona foundPersona;
        int   loc = 0;
        while ( loc < count &&
                !searchName.equals( entry[loc].getName() ) )
            loc++;
        
        if (loc == count)
            foundPersona = null;        
        else
            foundPersona = entry[loc];
        
        return foundPersona;
    }
    public Persona[ ] sort ( int attribute) {
        if (!(attribute == Persona.NAME || attribute == Persona.AGE) ) {
            throw new IllegalArgumentException( );
        }
        Persona[ ] sortedList = new Persona[ count ];
        Persona p1, p2;
        //copiamos la data al nuevo array
        for (int i = 0; i < count; i++) {
            sortedList[i] = entry[i];
        }
        //establecemos el atributo de comparacion
        entry[0].setCompareAttribute( attribute );
        //iniciamos el metodo de ordenamiento de la burbuja en sortedList
        int       bottom, comparisonResult;
        boolean   exchanged = true;
        bottom = sortedList.length - 2;
        while ( exchanged )  {
            exchanged = false;
            for (int i = 0; i <= bottom; i++) {
                p1 = sortedList[i];
                p2 = sortedList[i+1];               
                comparisonResult = p1.compareTo( p2 );
                if ( comparisonResult > 0 ) { //p1 es mayor que p2, intercambiar
                    sortedList[i]    = p2;    
                    sortedList[i+1]  = p1;
                    exchanged  = true; //exchange is made
                }
            }
            bottom--;
        }
        return sortedList;
    }
    
    private void enlarge( )
    {        
        int newLength = (int) (1.5 * entry.length);
        Persona[] temp = new Persona[newLength];        
        for (int i = 0; i < entry.length; i++) {
            temp[i] = entry[i];
        }        
        entry = temp;   
    }

    private int findIndex( String searchName )//busqueda lineal
    {
        int loc = 0;
        while ( loc < count &&
                !searchName.equals( entry[loc].getName() ) )
            loc++;
        
        if (loc == count)
            loc = NOT_FOUND;        
        return loc;
    }   
}