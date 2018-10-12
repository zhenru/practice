package org.muzhe.lambada.ch5;

import org.muzhe.lambada.ch5.domain.Trader;
import org.muzhe.lambada.ch5.domain.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author muzhe-wang on  18-10-11 下午1:08.
 */
public class PuttingIntoPractice {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brain = new Trader("Brain", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brain, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        //
        handleFilterSorted(transactions);

        System.out.println(" -------------------------------------------------------------------------------- ");

        handleTransactionTraderAndSorted(transactions);

        System.out.println(" -------------------------------------------------------------------------------- ");

        handleDistinctCityOfTrader(transactions);

        System.out.println(" -------------------------------------------------------------------------------- ");

        handleReduceTraderNameMerge(transactions);

        System.out.println(" -------------------------------------------------------------------------------- ");

//        handleUpdateTradeCity(transactions);

        System.out.println(" -------------------------------------------------------------------------------- ");

        handleIsExistCityOfMilan(transactions);

        System.out.println(" -------------------------------------------------------------------------------- ");

        handleHightestValueOfTransaction(transactions);

        System.out.println(" -------------------------------------------------------------------------------- ");

    }

    /**
     * 找出　
     */
    private static void handleHightestValueOfTransaction(List<Transaction> transactions) {


        Optional<Integer> max = transactions.stream()
                .map(transaction -> transaction.getValue())
                .max(Integer::compareTo);

        System.out.println(max.get());
    }

    /**
     * 判断所有的Trader中是否有城市为Milan的
     * 使用AnyMatch来判断
     *
     * @param transactions
     */
    private static void handleIsExistCityOfMilan(List<Transaction> transactions) {

        boolean isExistMilan = transactions
                .stream()
                .anyMatch(transaction ->
                        "Milan".equals(
                                transaction
                                        .getTrader()
                                        .getCity()));

        System.out.println(isExistMilan);
    }

    /**
     * 将所有的的Trader中为Milan改为　ACMilan
     * 首先将所有的Trader中city为Milan的Trader过滤出来，然后再依次遍历，将所有的city改为 ACMilan
     */
    private static void handleUpdateTradeCity(List<Transaction> transactions) {

        transactions.stream()
                .filter(transaction -> "Milan".equals(transaction.getTrader().getCity()))
                .map(transaction -> transaction.getTrader())
                .forEach(trader -> trader.setCity("ACMilan"));

        System.out.println(transactions);

    }

    /**
     * 对于所有出现的Trader的名称进行字母排序，然后链接为一个字符串返回
     * <p>
     * 使用reduce其中的一个BiFunction这个方法是两个参数对这个参数进行处理。　这个方法和　reduce进行配置比较的不适应
     *
     * @param transactions
     */
    private static void handleReduceTraderNameMerge(List<Transaction> transactions) {

        String nameSum = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("[", (str1, str2) -> str1 + str2);
        System.out.println(nameSum);

    }

    /**
     * 将所有的Trader中有的city的信息都给low出来
     * 通过map将所有Transactionzhong
     */
    private static void handleDistinctCityOfTrader(List<Transaction> transactions) {

        List<String> cities = transactions
                .stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        cities.forEach(System.out::println);
    }

    /**
     * 将所有的城市为剑桥的Trader找出来
     * 然后通过name进行排序
     *
     * @param transactions
     */
    private static void handleTransactionTraderAndSorted(List<Transaction> transactions) {

        List<Trader> traderList = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(traderList);


    }

    /**
     * 处理filter和sorted方法。
     * 　１.先使用filter将2011年的　transaction数据给过滤出来
     * 2.使用comparing对象来构建比较器具，然后添加到sort方法中对当前的方法进行排序
     *
     * @param transactions 日志队列
     */
    private static void handleFilterSorted(List<Transaction> transactions) {
        List<Transaction> collect = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }


}
