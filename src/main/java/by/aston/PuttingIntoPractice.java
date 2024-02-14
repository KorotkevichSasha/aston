package by.aston;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

       //task1
       transactions
               .stream()
               .filter(t->t.getYear() == 2011)
               .sorted(Comparator.comparing(Transaction::getValue))
               .forEach(System.out::println);
        System.out.println("----------------------");


       //task2
       transactions
               .stream()
               .map(t -> t.getTrader().getCity())
               .distinct()
               .forEach(System.out::println);
        System.out.println("----------------------");

       //task3
        transactions
                .stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .forEach(System.out::println);
        System.out.println("----------------------");


        //task4
        transactions
                .stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .distinct()
                .forEach(System.out::println);

        System.out.println("----------------------");


        //task5
        boolean traderFromMilan = transactions
                .stream()
                .map(Transaction::getTrader)
                .distinct()
                .anyMatch(t-> t.getCity().equals("Milan"));
        System.out.println(traderFromMilan?"There are/is trader(s) from Milan":"There are/is no trader(s) from Milan");
        System.out.println("----------------------");


        //task6
        transactions
                .stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .mapToInt(Transaction::getValue)
                .sum();
        System.out.println("----------------------");


        //task7
        transactions
                .stream()
                .map(Transaction::getValue)
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .forEach(System.out::println);
        System.out.println("----------------------");


        //task8
        transactions
                .stream()
                .map(Transaction::getValue)
                .sorted()
                .limit(1)
                .forEach(System.out::println);
        System.out.println("----------------------");



    }
}