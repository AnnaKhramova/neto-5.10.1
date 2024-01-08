
public class JvmComprehension {
    // Application ClassLoader подгрузил JvmComprehension в Metaspace,
    // связал с Object, Integer и System, проинициализировал методы main и printAll.
    public static void main(String[] args) { // В стеке создается новый фрейм main(). В него добавляется ссылка "args" на уже созданный в куче массив.
        int i = 1;                      // Во фрейме main() создается и инициализируется примитивная переменная "i".
        Object o = new Object();        // В куче создается экземпляр типа Object, ссылка "o" на который добавляется во фрейм main().
        Integer ii = 2;                 // В куче создается экземпляр типа Integer, ссылка "ii" на который добавляется во фрейм main().
        printAll(o, i, ii);             // В стеке создается новый фрейм printAll().
        System.out.println("finished"); // В стеке создается новый фрейм println(), в котором создается ссылка на экземпляр типа String в куче.
                                        // После отработки метода println(), фрейм println() из стека удаляется.
                                        // GC чистит в куче экземпляр типа String.
    } // Фрейм main() удаляется из стека. GC чистит экземпляры типов Integer и Object, на которые ссылались "o" и "ii", а также массив, на который ссылалась "args".

    private static void printAll(Object o, int i, Integer ii) { // Во фрейме printAll() создается и инициализируется примитивная
                                                                // переменная "i" с таким же значением, как и во фрейме main() (но это другая, новая переменная),
                                                                // а также добавляются ссылки "o" и "ii" на уже созданные в куче экземпляры классов Object и Integer
        Integer uselessVar = 700;                   // В куче создается экземпляр типа Integer, ссылка "uselessVar" на который добавляется во фрейм printAll().
        System.out.println(o.toString() + i + ii);  // В стеке создается новый фрейм toString(), удаляется фрейм toString(),
                                                    // затем в стеке создается фрейм println(), в куче создается экземпляр типа String,
                                                    // ссылка на который добавляется во фрейм println().
                                                    // После отработки метода println(), фрейм println() удаляется из стека.
                                                    // GC чистит в куче экземпляр типа String.
    } // Фрейм printAll() удаляется из стека. GC чистит экземпляр типа Integer, на который ссылалась "uselessVar".
}
