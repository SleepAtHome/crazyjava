package faceobject2;

/**
 * 使用数组来作为缓存池，实现一个具有缓存的不可变类
 * 类似于String的一个缓存池
 */
public class CacheImmutale {
    private final String name;
    private static CacheImmutale[] cache = new CacheImmutale[10];

    // 记录缓存实例在缓存中的位置
    private static int pos = 0;

    public CacheImmutale(String name) {
        this.name = name;
    }
    public String getName() {return name;}


    public static CacheImmutale valueOf(String name) {
        // 遍历已缓存的对象
        for (int i = 0 ; i < pos ; i++) {
            // 如果有相同的实例，直接返回该缓存的实例
            if (cache[i] != null && cache[i].getName().equals(name)){
                return cache[i];
            }
        }

        // 如果缓存池已满
        if (pos == 10) {
            // 把缓存的第一个对象覆盖，把刚刚生成的对象放在缓存池最开始的位置、
            cache[0] = new CacheImmutale(name);
            // 这个把pos赋值为1，这样的话，当有第12个不一样的话，直接进入到下面的else中，覆盖原先的cache[2]
            pos = 1;
            return cache[0];
        } else {
            // 把创建的对象缓存起来，pos+1
            cache[pos++] = new CacheImmutale(name);
            return cache[pos-1];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof CacheImmutale) {
            CacheImmutale ci = (CacheImmutale) o;
            if (name.equals(ci.getName())) {return true;}

        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public static void main(String[] args) {
        CacheImmutale c1 = valueOf("hello1");
        CacheImmutale c2 = valueOf("hello1");

        System.out.println(c1 == c2);
        /*CacheImmutale c2 = valueOf("hello2");
        CacheImmutale c3 = valueOf("hello3");
        CacheImmutale c4 = valueOf("hello4");
        CacheImmutale c5 = valueOf("hello5");
        CacheImmutale c6 = valueOf("hello6");
        CacheImmutale c7 = valueOf("hello7");
        CacheImmutale c8 = valueOf("hello8");
        CacheImmutale c9 = valueOf("hello9");
        CacheImmutale c10 = valueOf("hello10");
        CacheImmutale c11 = valueOf("hello11");
        CacheImmutale c12 = valueOf("hello12");*/

    }

}
