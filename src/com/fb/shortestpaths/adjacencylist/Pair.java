package com.fb.shortestpaths.adjacencylist;

import com.fb.dp.topdown.PaintFence;
import java.awt.*;

/**
 * @author swamy on 3/13/21
 */
public class Pair<Key,Value> {
  Key vertex;
  Value cost;
    public Pair(Key key, Value value){
        this.vertex = key;
        this.cost = value;
    }

    Key getKey(){
        return vertex;
    }
    Value getValue(){
        return cost;
    }

}
