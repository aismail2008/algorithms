/** 
 * ConcurrentHashMap
 * 		- You should use ConcurrentHashMap when you need very high concurrency in your project.
 * 		- It is thread safe without synchronizing the whole map.
 * 		- Reads can happen very fast while write is done with a lock.
 * 		- There is no locking at the object level.
 * 		- The locking is at a much finer granularity at a hashmap bucket level.
 * 		- ConcurrentHashMap doesn’t throw a ConcurrentModificationException if one thread tries to modify it while another is iterating over it.
 * 		- ConcurrentHashMap uses multitude of locks.
 * SynchronizedHashMap
 * 		- Synchronization at Object level.
 * 		- Every read/write operation needs to acquire lock.
 * 		- Locking the entire collection is a performance overhead.
 * 		- This essentially gives access to only one thread to the entire map & blocks all the other threads.
 * 		- It may cause contention.
 * 		- SynchronizedHashMap returns Iterator, which fails-fast on concurrent modification.
 */
 package com.code.test.concurrency;