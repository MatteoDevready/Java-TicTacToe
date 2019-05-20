package uk.ac.kingston.programming.oxyv2.model;


/**
 *
 * @author matte
 */
public class Board {
     /*private String [] [] slot = new String [4] [4];//initialising the board with a two dimensional array
     
      public String[][] getSlot() {
        return slot;
      }

    public void setSlot(String[][] slots) {
        this.slot = slots;
    }
      /* public String findWinner()
    {
        // start at coordinate 0,0,
        for (int x = 0; x < 4; x++)
        {
            for (int y = 0; y < 4; y++)
            {
                if (x < 3 && y < 3)
                {
                    String diag1 = compareStrings(new String[]{this.slot[x][y],this.slot[x+1][y+1],this.slot[x+2][y+2],this.slot[x+3][y+3]});
                    if (diag1 != null) return diag1;
                    String diag2 = compareStrings(new String[]{this.slot[x+3][y],this.slot[x+2][y+1],this.slot[x+1][y+2],this.slot[x][y+3]});
                    if (diag2 != null) return diag2;
                }
                if (x < 3)
                {
                    String horiz = compareStrings(new String[]{this.slot[x][y],this.slot[x+1][y],this.slot[x+2][y],this.slot[x+3][y]});
                    if (horiz != null) return horiz;
                }
                if (y < 3)
                {
                    String vert = compareStrings(new String[]{this.slot[x][y],this.slot[x][y+1],this.slot[x][y+2],this.slot[x][y+3]});
                    if (vert != null) return vert;
                }
            }
        }
        return null;
    }
        private String compareStrings(String[] strings)
    {
        HashSet<String> set = new HashSet(Arrays.asList(strings));
        if (set.size() != 1 || set.contains(null)) return null;        
        return new ArrayList<String>(set).get(0);
    }  */
}
