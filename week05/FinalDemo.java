// TODO 2: Ship 類別
class Ship {
    protected String name;

    public Ship(String name) {
        this.name = name;
    }

    // final 方法：子類別「禁止」覆寫此行為
    public final String type() {
        return "船舶";
    }

    public String sail() {
        return name + " 正在航行";
    }
}

// TODO 3: FishingBoat 繼承 Ship
class FishingBoat extends Ship {
    public FishingBoat(String name) {
        super(name);
    }

    @Override
    public String sail() {
        return name + " 正在拖網捕魚";
    }

    /* // 嘗試覆寫 type() 會導致編譯錯誤：
    // 'type()' cannot override 'type()' in 'Ship'; overridden method is final
    @Override
    public String type() {
        return "漁船";
    }
    */
}

public class FinalDemo {

    // TODO 1: 宣告 final 變數 (常數通常建議使用大寫加底線)
    static final int MAX_DEPTH = 11034;  // 馬里亞納海溝最深處

    public static void main(String[] args) {
        System.out.println("馬里亞納海溝最深：" + MAX_DEPTH + " 公尺");

        // 如果取消下面這行的註解，編譯器會報錯：cannot assign a value to final variable MAX_DEPTH
        // MAX_DEPTH = 12000; 

        Ship s = new Ship("遠洋號");
        FishingBoat f = new FishingBoat("海豐號");

        System.out.println(s.type() + "：" + s.sail());
        System.out.println(f.type() + "：" + f.sail());

        // 多型示範
        Ship s2 = new FishingBoat("福星號");
        // type() 依然呼叫父類別定義的版本，sail() 則呼叫子類別覆寫的版本
        System.out.println(s2.type() + "：" + s2.sail());
    }
}