package sort;

public class FieldSorted {
    public static <T extends Comparable<? super T>>
    void shellsort( T [ ] a )
    {
        int j;
        for( int gap = a.length / 2; gap > 0; gap /= 2 )
        {
            for( int i = gap; i < a.length; i++ )
            {
                T tmp = a[ i ];
                for( j = i; j >= gap && tmp.compareTo( a[ j - gap ] ) < 0; j -= gap )
                {
                    a[ j ] = a[ j - gap ];
                }
                a[ j ] = tmp;
            }
        }
    }

}
