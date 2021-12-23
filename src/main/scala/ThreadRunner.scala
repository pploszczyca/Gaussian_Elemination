package pl.tw.lab6

object ThreadRunner {
  def run(threads: List[Thread]): Unit = {
    threads.foreach(thread => thread.run())
    threads.foreach(thread => thread.join())
  }
}
