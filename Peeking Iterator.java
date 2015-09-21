// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    int next;
    boolean hasNext = true;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	    if(iterator.hasNext())
	        next = iterator.next();
	    else
	        hasNext = false;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int thisnum = next;
	    if(iterator.hasNext())
	        next = iterator.next();
	    else
	        hasNext = false;
	    return thisnum; 
	}

	@Override
	public boolean hasNext() {
	    return hasNext;
	}
}