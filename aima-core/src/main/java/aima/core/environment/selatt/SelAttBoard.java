
package aima.core.environment.selatt;

import java.util.Arrays;

public class SelAttBoard {
    
    private int[] state;
    //Vector de 9 elementos que representan los 9 atributos,
    //0 = no pertenece al subconjunto,
    //1 = pertenece al subconjunto
    
    
    public static final double [][] DATA={
        {1,0.64491,0.65459,0.48636,0.52182,0.58730,0.55843,0.53583,0.35003},
        {0.64491,1,0.90688,0.70558,0.75180,0.68680,0.75572,0.72286,0.45869},
        {0.65459,0.90688,1,0.68308,0.71967,0.70961,0.73595,0.71945,0.43891},
        {0.48636,0.70558,0.68308,1,0.59960,0.66505,0.66672,0.60335,0.41763},
        {0.52182,0.75180,0.71967,0.59960,1,0.58126,0.61610,0.62888,0.47910},
        {0.58730,0.68680,0.70961,0.66505,0.58126,1,0.67590,0.57736,0.33874},
        {0.55843,0.75572,0.73595,0.66672,0.61610,0.67590,1,0.66588,0.34417},
        {0.53583,0.72286,0.71945,0.60335,0.62888,0.57736,0.66588,1,0.42834},
        {0.35003,0.45869,0.43891,0.41763,0.47910,0.33874,0.34417,0.42834,1},
        {0.71600,0.81790,0.81893,0.69680,0.68278,0.81605,0.75662,0.71224,0.42317}
    };
    
    public SelAttBoard() {
        state = new int[]{0,0,0,0,0,0,0,0,0};
    }

    public SelAttBoard(int[] state) {
        this.state = new int[state.length];
        System.arraycopy(state, 0, this.state, 0, state.length);
    }

    public SelAttBoard(SelAttBoard copyBoard) {
        this(copyBoard.getState());
    }
    
    public int[] getState() {
        return state;
    }
    
    public int getSize(){
        return state.length;
    }
    
    
    public void add(int pos,int value){
        state[pos]=value;
    }
    
    public void remove(int pos,int value){
        state[pos]=value;
    }


    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Arrays.hashCode(this.state);
        return hash;
    }


    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SelAttBoard other = (SelAttBoard) obj;
        if (!Arrays.equals(this.state, other.state)) {
            return false;
        }
        return true;
    }


    public String toString() {
        String stateChar="";
        for(int i=0;i<state.length;i++)
            stateChar+=String.valueOf(state[i])+" ";
        return "state={ " + stateChar + '}';
    }
    
    
}
