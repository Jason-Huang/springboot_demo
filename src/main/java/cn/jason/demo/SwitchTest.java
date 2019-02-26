package cn.jason.demo;

public class SwitchTest {
    public static void main(String[] args) {
        int type = 4;
        switch (type) {
            default:
                System.out.print(4);
            case 1:
                System.out.print(1);
            case 2:
                System.out.print(2);
            case 3:
                System.out.print(3);

        }
        //结果4123
    }
}
