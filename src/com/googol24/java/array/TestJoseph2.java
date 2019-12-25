package com.googol24.java.array;

/**
 * 面向对象实现双向环链表来实现约瑟夫环
 * 500 3
 */
public class TestJoseph2 {
    public static void main(String[] args) {
        KidsCircle kidsCircle = new KidsCircle(500);

        // 方法一
//        Kid indexKid = kidsCircle.getFirst();
//        while (kidsCircle.getCount() > 1) {
//            Kid quitKid = indexKid.getRight().getRight();
//
//            indexKid = quitKid.getRight();
//
//            kidsCircle.delete(quitKid);
//        }

        // 方法二
        int countNum = 0;
        Kid k = kidsCircle.getFirst();
        while (kidsCircle.getCount() > 1) {
            countNum++;
            if (countNum % 3 == 0) {
                kidsCircle.delete(k);
            }

            k = k.getRight();
        }

        System.out.print(kidsCircle.getFirst().getId());
    }
}

/**
 * 元素类
 */
class Kid {
    private int id;
    private Kid left;
    private Kid right;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kid getLeft() {
        return left;
    }

    public void setLeft(Kid left) {
        this.left = left;
    }

    public Kid getRight() {
        return right;
    }

    public void setRight(Kid right) {
        this.right = right;
    }
}

/**
 * 环类
 */
class KidsCircle {
    // 环中的人数
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Kid getFirst() {
        return first;
    }

    public void setFirst(Kid first) {
        this.first = first;
    }

    public Kid getLast() {
        return last;
    }

    public void setLast(Kid last) {
        this.last = last;
    }

    private Kid first;
    private Kid last;

    KidsCircle(int n) {
        for (int i = 0; i < n; i++) {
            Kid kid = new Kid();
            kid.setId(this.getCount());
            this.add(kid);
        }
    }

    public void add(Kid kid) {
        if (count <= 0) {
            this.setFirst(kid);
            this.setLast(kid);
            kid.setLeft(kid);
            kid.setRight(kid);
        } else {
            last.setRight(kid);
            kid.setLeft(last);
            kid.setRight(first);
            first.setLeft(kid);

            this.last = kid;
        }

        count++;
    }

    public void delete(Kid k) {
        if (count >= 1) {
            if (count == 1) {
                this.first = this.last = null;
            } else {
                k.getLeft().setRight(k.getRight());
                k.getRight().setLeft(k.getLeft());

                if (k == first) {
                    this.first = k.getRight();
                } else if(k == last) {
                    last = last.getLeft();
                }
            }

            this.count--;
        }
    }

}
