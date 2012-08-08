/*    -*- Java -*-
 *
 *  Copyright 2012 Tail-F Systems AB. All rights reserved.
 *
 *  This software is the confidential and proprietary
 *  information of Tail-F Systems AB.
 *
 *  $Id$
 *
 */

package com.tailf.jnc;


/**
 * Implements the built-in YANG data type "int32".
 * 
 * @author emil@tail-f.com
 */
public class YangInt32 extends YangInt<Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a YangInt32 object from a String.
     * 
     * @param s The string.
     * @throws YangException If value could not be parsed from s.
     */
    public YangInt32(String s) throws YangException {
        super(s);
        setMinMax(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Creates a YangInt32 object from a Number. This may involve rounding or
     * truncation.
     * 
     * @param value The initial value of the new YangInt32 object.
     * @throws YangException If value does not fit in 8 bits.
     */
    public YangInt32(Number value) throws YangException {
        super(value.intValue());
        setMinMax(Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (!(value instanceof Integer)) {
            YangException.throwException(!valid(value), this);
        }
    }

    /*
     * (non-Javadoc)
     * @see com.tailf.jnc.yang.YangInt#parse(java.lang.String)
     */
    @Override
    protected Integer decode(String s) {
        return Integer.decode(s);
    }

}