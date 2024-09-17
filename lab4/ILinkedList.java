
interface ILinkedList<T> {

    /**
     * Inserts a specified element at the specified position in the list.
     * @param index
     *      the index of the element to add
     * @param element
     *      the value of the element to add
     */
    public void add(int index, T element);
    /**
     * Inserts the specified element at the end of the list.
     * @param element
     *       the value of the element
     */
    public void add(T element);
    /**
     * @param index
     *      the index of the required element
     * @return the element at the specified position in this list.
     */
    public T get(int index);
    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * @param index
     *      the index of the element to change
     * @param element
     *       the new value
     */
    public void set(int index, T element);
    /**
     * Removes all of the elements from this list.
     */
    public void clear();
    /**
     * @return true if this list contains no elements.
     */
    public boolean isEmpty();
    /**
     * Removes the element at the specified position in this list.
     * @param index
     *      the index to remove
     */
    public void remove(int index);
    /**
     * @return the number of elements in this list.
     */
    public int size();
    /**
     * @param fromIndex
     *      the first index of the sublist
     * @param toIndex
     *      the last element of the sublist
     * @return a view of the portion of this list between the specified fromIndex
    and toIndex, inclusively.
     */
    public ILinkedList<T> sublist(int fromIndex, int toIndex);
    /**
     * @param o
     *      the element to search
     * @return true if this list contains an element with the same value as the
    specified element.
     */
    public boolean contains(T o);
}
