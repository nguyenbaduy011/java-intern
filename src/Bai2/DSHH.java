package Bai2;

import java.util.ArrayList;

public class DSHH<T extends Goods> {
    private ArrayList<T> goods;

    public DSHH(ArrayList<T> goods) {
        this.goods = goods;
    }

    public DSHH() {
        this.goods = new ArrayList<>();
    }

    public void setGoods(T goods) {
        for (T good : this.goods) {
            if (good.getProductId().equals(goods.getProductId())) {
                throw new RuntimeException("Goods already exists");
            }
        }
        this.goods.add(goods);
        System.out.println("Goods added to the list successfully!");
    }

    public T getGoods(int i) {
        return this.goods.get(i);
    }
}

