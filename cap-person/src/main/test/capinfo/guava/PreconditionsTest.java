package capinfo.guava;

import com.google.common.base.Preconditions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PreconditionsTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCheckArgument(){
        int i = 10;
        Preconditions.checkArgument(i<0,"不行啊你有种");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCheckElementIndex(){
        Preconditions.checkElementIndex(10,(new ArrayList<String>()).size());
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testCheckPositionIndexes(){
        Preconditions.checkPositionIndexes(1,5,4);

    }


}
