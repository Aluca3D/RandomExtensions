package net.rand.exten.util.tools;

import java.util.Random;

public class Math_RaEx {
    public int randomInt(int i) {
        Random r = new Random();
        int ri = r.nextInt(i);
        return ri + 1;
    }
}
