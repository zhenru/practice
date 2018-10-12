java中的各种状态

代码是在Thread.getState()，如果查看当前现成的状态使用Thread.currentThread().getState();返回的对象是Thread.State。这个类是一个枚举对象。
这个对象包括：
START,RUNNABLE,BLOCKED, TIMIE-WAITING, WAITING,TERMINATE

其中各个状态之间相互转换，转换的逻辑是当前系统中的对象是