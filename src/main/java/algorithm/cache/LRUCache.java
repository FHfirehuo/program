package algorithm.cache;

/**
 * 要求是缓存的加入put()，缓存读取get()，都要在O(1)内实现。
 *
 * LRU的一个实现方法：
 * 用一个双向链表记录访问时间，因为链表插入删除高效，时间新的在前面，旧的在后面。
 * 用一个哈希表记录缓存(key, value)，哈希查找近似O(1)，发生哈希冲突时最坏O(n)，同时哈希表中得记录 (key, (value, key_ptr))，key_ptr 是key在链表中的地址，为了能在O(1)时间内找到该节点，并把节点提升到表头。
 * 链表中的key，能快速找到hash中的value，并删除。

 */
public class LRUCache {


}
