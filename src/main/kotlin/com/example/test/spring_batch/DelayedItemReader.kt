package com.example.test.spring_batch

import org.springframework.batch.item.ItemReader

class DelayedItemReader<T>(
  items: List<T>
) : ItemReader<T> {

  private val list: MutableList<T> = items.toMutableList()

  override fun read(): T? {
    Thread.sleep(500)
    return list.removeAt(0)
  }
}
