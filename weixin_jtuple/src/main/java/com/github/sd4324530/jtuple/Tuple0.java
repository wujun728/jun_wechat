package com.github.sd4324530.jtuple;

/**
 * 表示有0个元素的元组类型
 *
 * @author peiyu
 */
public final class Tuple0 extends Tuple {

    private static final Object[] EMPTY    = new Object[]{};
    private static final Tuple0   INSTANCE = new Tuple0();

    private Tuple0() {
        super(EMPTY);
    }

    /**
     * 反转元组
     *
     * @return 反转后的元组
     */
    @Override
    public Tuple0 reverse() {
        return this;
    }

    /**
     * 得到一个包含0个元素的元组
     *
     * @return 元组
     * @see Tuples#tuple()
     */
    public static Tuple0 with() {
        return INSTANCE;
    }
}
