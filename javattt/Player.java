package javattt;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;

import java.util.List;

public interface Player {

    public String getMark();
    public String getMove(Board gameBoard);
}
