import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;

import java.io.IOException;

public class Jhava {

    private int hitPoints = 334545;

    // 调用kotlin
    public static void main(String[] args) {
        // @JvmName
        // System.out.println(HeroKt.makeProclamation()); // 未修改名字前的访问方式
        System.out.println(Hero.makeProclamation());

        // @JvmField

        Spellbook spellbook = new Spellbook();// 未加@JvmField
        spellbook.getSpells1();// 加了@JvmField
        for (String spell : spellbook.spells2) {
            System.out.println(spell);
        }

        // @JvmOverloads
        Hero.handOverFood("apple");

        // 伴生对象
        // System.out.println(Spellbook.Companion.getMAX_SPELL_COUNT());// 未加JvmField
        System.out.println(Spellbook.MAX_SPELL_COUNT);// 加了@JvmField
        // Spellbook.Companion.getSpellbookGreeting();// 未加@JvmStatic
        Spellbook.getSpellbookGreeting();// 加了@JvmStatic

        try {
            new Jhava().extendHandInFrienfship();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // java 处理kotlin异常
        try {
            Hero.acceptApology();
        } catch (IOException e) {// 加了@Throws(IOException::class)才有效，不然只能抛出Throwable,因为kotlin的异常转成了不然只能抛出Throwable
            System.out.println("Caught " + e);
        }

        // 函数类型操作
        // java8之前没有lambda,Kotlin函数类型使用FunctionN这样的名字的接口来表示
        Function1<String, Unit> translator = Hero.getTranslator();
        translator.invoke("TRUCE");
    }

    @NotNull
    public String utterGreeting() {
        return "HELLO";
    }

    @Nullable
    public String determineFriendshipLevel() {
        return null;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void extendHandInFrienfship() throws IOException {
        throw new IOException();
    }
}
