/*
 * Copyright 2005-2007 Lawrence H. Reeve, PhD and Drexel University. All Rights Reserved.
 * 
 * This source code and related modules are an unpublished work.
 * 
 */
package biocommon.lists;

import java.util.Arrays;

public class IntList
{
    @SuppressWarnings("unused")
    private static final String COPYRIGHT            = biocommon.copyright.Copyright.COPYRIGHT;

    private static final int    DEFAULT_INITIAL_SIZE = 32;

    protected int[]             list                 = null;
    protected int               listLength           = 0;
    private boolean             sorted               = false;


    public IntList()
    {
        this(DEFAULT_INITIAL_SIZE);
    }

    public IntList(int initialSize)
    {
        if (initialSize > 0)
            this.list = new int[initialSize];
        else
            this.list = new int[DEFAULT_INITIAL_SIZE];

        this.listLength = 0;
        
        this.sorted = false;
    }

    public void add(int value)
    {
        this.ensureCapacity(this.listLength + 1);

        this.list[this.listLength] = value;

        this.listLength++;
        
        this.sorted = false;
    }

    public void clear()
    {
        this.list = new int[DEFAULT_INITIAL_SIZE];
        this.listLength = 0;
        this.sorted = false;
    }

    public boolean contains(int value)
    {
        if (this.listLength == 0)
            return false;
        
        if (this.listLength == 1)
            this.sorted = true;

        if (!this.sorted)
        {
            Arrays.sort(this.list);
            this.sorted = true;
        }

        return (Arrays.binarySearch(this.list, value) >= 0);
    }

    public boolean equals(Object o)
    {
        if (!(o instanceof IntList))
            return false;

        IntList targetList = (IntList) o;

        if (this.listLength != targetList.listLength)
            return false;

        for (int idx = 0; idx < this.listLength; idx++)
        {
            if (this.list[idx] != targetList.list[idx])
                return false;
        }

        return true;
    }

    public int get(int index) throws ArrayIndexOutOfBoundsException
    {
        if (index >= this.listLength)
            throw new ArrayIndexOutOfBoundsException(index);
        else
            return this.list[index];
    }

    public boolean isEmpty()
    {
        return (this.listLength == 0);
    }

    public int size()
    {
        return this.listLength;
    }

    public int[] toArray()
    {
        int[] listToReturn = new int[this.listLength];

        System.arraycopy(this.list, 0, listToReturn, 0, this.listLength);

        return listToReturn;
    }

    protected void ensureCapacity(int minCapacity)
    {
        int oldCapacity = this.list.length;

        if (minCapacity > oldCapacity)
        {
            int newCapacity = Math.max(oldCapacity * 2, minCapacity);

            //System.out.println("Resize from " + oldCapacity + " to: " + newCapacity);            

            int[] newList = new int[newCapacity];

            System.arraycopy(this.list, 0, newList, 0, this.listLength);

            this.list = newList;
        }
    }
}
