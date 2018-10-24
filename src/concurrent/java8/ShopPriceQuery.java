package concurrent.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;

/**
 * 假设shop只提供了阻塞方法
 */
public class ShopPriceQuery {
    private static List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItNow"));

    public static List<String> findOriginPrices1(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    //和findOriginPrices1的并行流相比，好处是可以手动指定线程池指定线程数量
    public static List<String> findOriginPrice2(String product) {
        //supplyAync 默认使用通用线程池，可以指定
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> String.format("%s price is %.2f",
                                shop.getName(), shop.getPrice(product))))
                .collect(toList());
        //防止stream流的合并执行特性
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(toList());
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(findOriginPrices1("myPhone27s"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + "msecs");
    }
}
