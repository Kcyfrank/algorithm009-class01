### 学习笔记

---
> jdk 1.8 版 HashMap

#### V get(Object key)

入参为一个任意类型的key，先对key进行hash计算。
以hash后的结果以及key作为参数获取对应的存储节点。
若当前Map的table为空时直接返回。
每次均判断当前hash与key是否与首节点匹配，若是直接返回。
非首节点时，从首节点的下一节点开始迭代判断 直到hash与key匹配上Node为止。
存在匹配的Node时返回node.val,否则为null

#### V put(K key, V value)

直接调用putVal方法 默认 onlyIfAbsent 为false，evict 为true
即当key存在重复时，强制替换成新的value，且不处于 "creation mode"

若当前map未进行初始化，默认进行resize() DEFAULT_INITIAL_CAPACITY 为16(1<<4)。
若当前hash值不在table表内，直接添加新的node 并更新map的大小。
若当前hash值已存在，判断key是否匹配，处理hash碰撞的问题。
由于onlyIfAbsent默认为false ，若原key值存在直接替换为新的val。
