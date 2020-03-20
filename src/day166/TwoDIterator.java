package day166;

import java.util.*;

public class TwoDIterator<Type> implements Iterable<Type> {

    private Type[][] items;
    private int position;
    private int level;

    public TwoDIterator(Type[][] items) {
        this.items = items;
        this.position = 0;
        this.level = 0;
    }

    @Override
    public Iterator<Type> iterator() {
        Iterator<Type> it = new Iterator<Type>() {

    
            @Override
            public boolean hasNext() {
                findNext();

                if(position >= items.length) {
                    return false;
                }

                return true;
            }

            private void findNext() {
                boolean keep = true;

                while(keep) {
                    if(position < items.length && level < items[position].length) {
                        keep = false;
                        continue;
                    }

                    if(position >= items.length) {
                        keep = false;
                        continue;
                    }

                    if(items[position].length == 0) {
                        position++;
                        level = 0;
                        continue;
                    }

                    keep = false;
                }
            }

            @Override
            public Type next() {
                
                if(position >= items.length) {
                    throw new NoSuchElementException();
                }

                findNext();

                Type e = items[position][level];

                if(level < items[position].length - 1) {
                    level++;
                    return e;
                } else {
                    position++;
                    level = 0;
                }

                findNext();
                return e;

            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

}